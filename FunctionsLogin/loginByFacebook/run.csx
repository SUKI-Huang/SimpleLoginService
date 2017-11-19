#r "System.Configuration"
#r "System.Data"

using System.Net;
using System.Configuration;
using System.Data.SqlClient;
using System.Threading.Tasks;

public static async Task<HttpResponseMessage> Run(HttpRequestMessage req, TraceWriter log)
{

    dynamic data = await req.Content.ReadAsAsync<LoginInfo>();
    string name = data?.name;
    int gender = data?.gender;
    string email = data?.email;

    log.Info("name : "+name);
    log.Info("gender : "+gender);
    log.Info("email : "+email);

    //connect to the database
    SqlConnection conn = new SqlConnection(ConfigurationManager.ConnectionStrings["user_db"].ConnectionString);
    conn.Open();

    //excute sql command (add new user)
    var text = @"INSERT INTO dbo.members (Email, Name, Gender, LastLogin) VALUES ('"+email+"', '"+name+"', "+gender+",  GETDATE());";
    SqlCommand cmd = new SqlCommand(text, conn);
    var rows = await cmd.ExecuteNonQueryAsync();
    
    //reponse
    ResponseData res = new ResponseData();
    res.status = true;
    res.message = "login successful";

    
    return req.CreateResponse(HttpStatusCode.OK, res);

}

public class LoginInfo {
     public string name {get; set;}
     public int gender{get; set;}
     public string email {get; set;}
}

public class ResponseData{
    public bool status { set; get; }
    public string message { set; get; }

}


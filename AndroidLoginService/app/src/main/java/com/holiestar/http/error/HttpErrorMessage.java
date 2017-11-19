package com.holiestar.http.error;

/**
 * Created by Suki on 9/19/2017.
 */

public class HttpErrorMessage {
    private static String GSON_PARSE_ERROR="gson_parse_error";
    private static String NETWORK_UNAVAILABLE = "Network unavailable";
    private static String UNKNOWN_ERROR = "Unknown error";
    private static String ACCEPTED = "Accepted";
    private static String BAD_GATEWAY = "Bad Gateway";
    private static String BAD_REQUEST = "Bad Request";
    private static String CONFLICT = "Conflict";
    private static String CONTINUE = "Continue";
    private static String CREATED = "Created";
    private static String EXPECTATION_FAILED = "Expectation Failed";
    private static String FAILED_DEPENDENCY = "Failed Dependency";
    private static String FORBIDDEN = "Forbidden";
    private static String GATEWAY_TIMEOUT = "Gateway Timeout";
    private static String GONE = "Gone";
    private static String HTTP_VERSION_NOT_SUPPORTED = "HTTP Version Not Supported";
    private static String INSUFFICIENT_SPACE_ON_RESOURCE = "Insufficient Space on Resource";
    private static String INSUFFICIENT_STORAGE = "Insufficient Storage";
    private static String INTERNAL_SERVER_ERROR = "Server Error";
    private static String LENGTH_REQUIRED = "Length Required";
    private static String LOCKED = "Locked";
    private static String METHOD_FAILURE = "Method Failure";
    private static String METHOD_NOT_ALLOWED = "Method Not Allowed";
    private static String MOVED_PERMANENTLY = "Moved Permanently";
    private static String MOVED_TEMPORARILY = "Moved Temporarily";
    private static String MULTI_STATUS = "Multi-Status";
    private static String MULTIPLE_CHOICES = "Multiple Choices";
    private static String NETWORK_AUTHENTICATION_REQUIRED = "Network Authentication Required";
    private static String NO_CONTENT = "No Content";
    private static String NON_AUTHORITATIVE_INFORMATION = "Non Authoritative Information";
    private static String NOT_ACCEPTABLE = "Not Acceptable";
    private static String NOT_FOUND = "Not Found";
    private static String NOT_IMPLEMENTED = "Not Implemented";
    private static String NOT_MODIFIED = "Not Modified";
    private static String OK = "OK";
    private static String PARTIAL_CONTENT = "Partial Content";
    private static String PAYMENT_REQUIRED = "Payment Required";
    private static String PRECONDITION_FAILED = "Precondition Failed";
    private static String PRECONDITION_REQUIRED = "Precondition Required";
    private static String PROCESSING = "Processing";
    private static String PROXY_AUTHENTICATION_REQUIRED = "Proxy Authentication Required";
    private static String REQUEST_HEADER_FIELDS_TOO_LARGE = "Request Header Fields Too Large";
    private static String REQUEST_TIMEOUT = "Request Timeout";
    private static String REQUEST_TOO_LONG = "Request Entity Too Large";
    private static String REQUEST_URI_TOO_LONG = "Request-URI Too Long";
    private static String REQUESTED_RANGE_NOT_SATISFIABLE = "Requested Range Not Satisfiable";
    private static String RESET_CONTENT = "Reset Content";
    private static String SEE_OTHER = "See Other";
    private static String SERVICE_UNAVAILABLE = "Service Unavailable";
    private static String SWITCHING_PROTOCOLS = "Switching Protocols";
    private static String TEMPORARY_REDIRECT = "Temporary Redirect";
    private static String TOO_MANY_REQUESTS = "Too Many Requests";
    private static String UNAUTHORIZED = "Unauthorized";
    private static String UNPROCESSABLE_ENTITY = "Unprocessable Entity";
    private static String UNSUPPORTED_MEDIA_TYPE = "Unsupported Media Type";
    private static String USE_PROXY = "Use Proxy";

    public static void setMessage(int errorCode, String msg) {
        switch (errorCode) {
            case HttpErrorCode.NETWORK_UNAVAILABLE:
                NETWORK_UNAVAILABLE = msg;
                break;
            case HttpErrorCode.UNKNOWN_ERROR:
                UNKNOWN_ERROR = msg;
                break;
            case HttpErrorCode.GSON_PARSE_ERROR:
                GSON_PARSE_ERROR=msg;
                break;
            case HttpErrorCode.ACCEPTED:
                ACCEPTED = msg;
                break;
            case HttpErrorCode.BAD_GATEWAY:
                BAD_GATEWAY = msg;
                break;
            case HttpErrorCode.BAD_REQUEST:
                BAD_REQUEST = msg;
                break;
            case HttpErrorCode.CONFLICT:
                CONFLICT = msg;
                break;
            case HttpErrorCode.CONTINUE:
                CONTINUE = msg;
                break;
            case HttpErrorCode.CREATED:
                CREATED = msg;
                break;
            case HttpErrorCode.EXPECTATION_FAILED:
                EXPECTATION_FAILED = msg;
                break;
            case HttpErrorCode.FAILED_DEPENDENCY:
                FAILED_DEPENDENCY = msg;
                break;
            case HttpErrorCode.FORBIDDEN:
                FORBIDDEN = msg;
                break;
            case HttpErrorCode.GATEWAY_TIMEOUT:
                GATEWAY_TIMEOUT = msg;
                break;
            case HttpErrorCode.GONE:
                GONE = msg;
                break;
            case HttpErrorCode.HTTP_VERSION_NOT_SUPPORTED:
                HTTP_VERSION_NOT_SUPPORTED = msg;
                break;
            case HttpErrorCode.INSUFFICIENT_SPACE_ON_RESOURCE:
                INSUFFICIENT_SPACE_ON_RESOURCE = msg;
                break;
            case HttpErrorCode.INSUFFICIENT_STORAGE:
                INSUFFICIENT_STORAGE = msg;
                break;
            case HttpErrorCode.INTERNAL_SERVER_ERROR:
                INTERNAL_SERVER_ERROR = msg;
                break;
            case HttpErrorCode.LENGTH_REQUIRED:
                LENGTH_REQUIRED = msg;
                break;
            case HttpErrorCode.LOCKED:
                LOCKED = msg;
                break;
            case HttpErrorCode.METHOD_FAILURE:
                METHOD_FAILURE = msg;
                break;
            case HttpErrorCode.METHOD_NOT_ALLOWED:
                METHOD_NOT_ALLOWED = msg;
                break;
            case HttpErrorCode.MOVED_PERMANENTLY:
                MOVED_PERMANENTLY = msg;
                break;
            case HttpErrorCode.MOVED_TEMPORARILY:
                MOVED_TEMPORARILY = msg;
                break;
            case HttpErrorCode.MULTI_STATUS:
                MULTI_STATUS = msg;
                break;
            case HttpErrorCode.MULTIPLE_CHOICES:
                MULTIPLE_CHOICES = msg;
                break;
            case HttpErrorCode.NETWORK_AUTHENTICATION_REQUIRED:
                NETWORK_AUTHENTICATION_REQUIRED = msg;
                break;
            case HttpErrorCode.NO_CONTENT:
                NO_CONTENT = msg;
                break;
            case HttpErrorCode.NON_AUTHORITATIVE_INFORMATION:
                NON_AUTHORITATIVE_INFORMATION = msg;
                break;
            case HttpErrorCode.NOT_ACCEPTABLE:
                NOT_ACCEPTABLE = msg;
                break;
            case HttpErrorCode.NOT_FOUND:
                NOT_FOUND = msg;
                break;
            case HttpErrorCode.NOT_IMPLEMENTED:
                NOT_IMPLEMENTED = msg;
                break;
            case HttpErrorCode.NOT_MODIFIED:
                NOT_MODIFIED = msg;
                break;
            case HttpErrorCode.OK:
                OK = msg;
                break;
            case HttpErrorCode.PARTIAL_CONTENT:
                PARTIAL_CONTENT = msg;
                break;
            case HttpErrorCode.PAYMENT_REQUIRED:
                PAYMENT_REQUIRED = msg;
                break;
            case HttpErrorCode.PRECONDITION_FAILED:
                PRECONDITION_FAILED = msg;
                break;
            case HttpErrorCode.PRECONDITION_REQUIRED:
                PRECONDITION_REQUIRED = msg;
                break;
            case HttpErrorCode.PROCESSING:
                PROCESSING = msg;
                break;
            case HttpErrorCode.PROXY_AUTHENTICATION_REQUIRED:
                PROXY_AUTHENTICATION_REQUIRED = msg;
                break;
            case HttpErrorCode.REQUEST_HEADER_FIELDS_TOO_LARGE:
                REQUEST_HEADER_FIELDS_TOO_LARGE = msg;
                break;
            case HttpErrorCode.REQUEST_TIMEOUT:
                REQUEST_TIMEOUT = msg;
                break;
            case HttpErrorCode.REQUEST_TOO_LONG:
                REQUEST_TOO_LONG = msg;
                break;
            case HttpErrorCode.REQUEST_URI_TOO_LONG:
                REQUEST_URI_TOO_LONG = msg;
                break;
            case HttpErrorCode.REQUESTED_RANGE_NOT_SATISFIABLE:
                REQUESTED_RANGE_NOT_SATISFIABLE = msg;
                break;
            case HttpErrorCode.RESET_CONTENT:
                RESET_CONTENT = msg;
                break;
            case HttpErrorCode.SEE_OTHER:
                SEE_OTHER = msg;
                break;
            case HttpErrorCode.SERVICE_UNAVAILABLE:
                SERVICE_UNAVAILABLE = msg;
                break;
            case HttpErrorCode.SWITCHING_PROTOCOLS:
                SWITCHING_PROTOCOLS = msg;
                break;
            case HttpErrorCode.TEMPORARY_REDIRECT:
                TEMPORARY_REDIRECT = msg;
                break;
            case HttpErrorCode.TOO_MANY_REQUESTS:
                TOO_MANY_REQUESTS = msg;
                break;
            case HttpErrorCode.UNAUTHORIZED:
                UNAUTHORIZED = msg;
                break;
            case HttpErrorCode.UNPROCESSABLE_ENTITY:
                UNPROCESSABLE_ENTITY = msg;
                break;
            case HttpErrorCode.UNSUPPORTED_MEDIA_TYPE:
                UNSUPPORTED_MEDIA_TYPE = msg;
                break;
            case HttpErrorCode.USE_PROXY:
                USE_PROXY = msg;
                break;

        }
    }

    public static String getMessage(int errorCode) {
        switch (errorCode) {
            case HttpErrorCode.NETWORK_UNAVAILABLE:
                return NETWORK_UNAVAILABLE;
            case HttpErrorCode.UNKNOWN_ERROR:
                return UNKNOWN_ERROR;
            case HttpErrorCode.GSON_PARSE_ERROR:
                return GSON_PARSE_ERROR;
            case HttpErrorCode.ACCEPTED:
                return ACCEPTED;
            case HttpErrorCode.BAD_GATEWAY:
                return BAD_GATEWAY;
            case HttpErrorCode.BAD_REQUEST:
                return BAD_REQUEST;
            case HttpErrorCode.CONFLICT:
                return CONFLICT;
            case HttpErrorCode.CONTINUE:
                return CONTINUE;
            case HttpErrorCode.CREATED:
                return CREATED;
            case HttpErrorCode.EXPECTATION_FAILED:
                return EXPECTATION_FAILED;
            case HttpErrorCode.FAILED_DEPENDENCY:
                return FAILED_DEPENDENCY;
            case HttpErrorCode.FORBIDDEN:
                return FORBIDDEN;
            case HttpErrorCode.GATEWAY_TIMEOUT:
                return GATEWAY_TIMEOUT;
            case HttpErrorCode.GONE:
                return GONE;
            case HttpErrorCode.HTTP_VERSION_NOT_SUPPORTED:
                return HTTP_VERSION_NOT_SUPPORTED;
            case HttpErrorCode.INSUFFICIENT_SPACE_ON_RESOURCE:
                return INSUFFICIENT_SPACE_ON_RESOURCE;
            case HttpErrorCode.INSUFFICIENT_STORAGE:
                return INSUFFICIENT_STORAGE;
            case HttpErrorCode.INTERNAL_SERVER_ERROR:
                return INTERNAL_SERVER_ERROR;
            case HttpErrorCode.LENGTH_REQUIRED:
                return LENGTH_REQUIRED;
            case HttpErrorCode.LOCKED:
                return LOCKED;
            case HttpErrorCode.METHOD_FAILURE:
                return METHOD_FAILURE;
            case HttpErrorCode.METHOD_NOT_ALLOWED:
                return METHOD_NOT_ALLOWED;
            case HttpErrorCode.MOVED_PERMANENTLY:
                return MOVED_PERMANENTLY;
            case HttpErrorCode.MOVED_TEMPORARILY:
                return MOVED_TEMPORARILY;
            case HttpErrorCode.MULTI_STATUS:
                return MULTI_STATUS;
            case HttpErrorCode.MULTIPLE_CHOICES:
                return MULTIPLE_CHOICES;
            case HttpErrorCode.NETWORK_AUTHENTICATION_REQUIRED:
                return NETWORK_AUTHENTICATION_REQUIRED;
            case HttpErrorCode.NO_CONTENT:
                return NO_CONTENT;
            case HttpErrorCode.NON_AUTHORITATIVE_INFORMATION:
                return NON_AUTHORITATIVE_INFORMATION;
            case HttpErrorCode.NOT_ACCEPTABLE:
                return NOT_ACCEPTABLE;
            case HttpErrorCode.NOT_FOUND:
                return NOT_FOUND;
            case HttpErrorCode.NOT_IMPLEMENTED:
                return NOT_IMPLEMENTED;
            case HttpErrorCode.NOT_MODIFIED:
                return NOT_MODIFIED;
            case HttpErrorCode.OK:
                return OK;
            case HttpErrorCode.PARTIAL_CONTENT:
                return PARTIAL_CONTENT;
            case HttpErrorCode.PAYMENT_REQUIRED:
                return PAYMENT_REQUIRED;
            case HttpErrorCode.PRECONDITION_FAILED:
                return PRECONDITION_FAILED;
            case HttpErrorCode.PRECONDITION_REQUIRED:
                return PRECONDITION_REQUIRED;
            case HttpErrorCode.PROCESSING:
                return PROCESSING;
            case HttpErrorCode.PROXY_AUTHENTICATION_REQUIRED:
                return PROXY_AUTHENTICATION_REQUIRED;
            case HttpErrorCode.REQUEST_HEADER_FIELDS_TOO_LARGE:
                return REQUEST_HEADER_FIELDS_TOO_LARGE;
            case HttpErrorCode.REQUEST_TIMEOUT:
                return REQUEST_TIMEOUT;
            case HttpErrorCode.REQUEST_TOO_LONG:
                return REQUEST_TOO_LONG;
            case HttpErrorCode.REQUEST_URI_TOO_LONG:
                return REQUEST_URI_TOO_LONG;
            case HttpErrorCode.REQUESTED_RANGE_NOT_SATISFIABLE:
                return REQUESTED_RANGE_NOT_SATISFIABLE;
            case HttpErrorCode.RESET_CONTENT:
                return RESET_CONTENT;
            case HttpErrorCode.SEE_OTHER:
                return SEE_OTHER;
            case HttpErrorCode.SERVICE_UNAVAILABLE:
                return SERVICE_UNAVAILABLE;
            case HttpErrorCode.SWITCHING_PROTOCOLS:
                return SWITCHING_PROTOCOLS;
            case HttpErrorCode.TEMPORARY_REDIRECT:
                return TEMPORARY_REDIRECT;
            case HttpErrorCode.TOO_MANY_REQUESTS:
                return TOO_MANY_REQUESTS;
            case HttpErrorCode.UNAUTHORIZED:
                return UNAUTHORIZED;
            case HttpErrorCode.UNPROCESSABLE_ENTITY:
                return UNPROCESSABLE_ENTITY;
            case HttpErrorCode.UNSUPPORTED_MEDIA_TYPE:
                return UNSUPPORTED_MEDIA_TYPE;
            case HttpErrorCode.USE_PROXY:
                return USE_PROXY;
            default:
                return null;
        }
    }
}

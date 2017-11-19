package com.rey.material.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.rey.material.drawable.CheckBoxDrawable;

public class CheckBox extends CompoundButton {
    private Context context;
    private CheckBoxDrawable checkBoxDrawable;
    private CheckBoxDrawable.Builder checkBoxDrawableBuilder;
    public CheckBox(Context context) {
        super(context);

        init(context, null, 0, 0);
    }

    public CheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs, 0, 0);
    }

	public CheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		
		init(context, attrs, defStyleAttr, 0);
	}

    public CheckBox(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);

        init(context, attrs, defStyleAttr, defStyleRes);
    }

	private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        this.context=context;
		applyStyle(context, attrs, defStyleAttr, defStyleRes);
    }

    public void applyStyle(int resId){
        applyStyle(getContext(), null, 0, resId);
    }

    public void setMColor(int color){
        if(checkBoxDrawableBuilder!=null){
            checkBoxDrawableBuilder.strokeColor(color);
            checkBoxDrawable =checkBoxDrawableBuilder.build();
            checkBoxDrawable.setInEditMode(isInEditMode());
            checkBoxDrawable.setAnimEnable(false);
            setButtonDrawable(checkBoxDrawable);
            checkBoxDrawable.setAnimEnable(true);
        }
    }

    private void applyStyle(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
//        CheckBoxDrawable drawable = new CheckBoxDrawable.Builder(context, attrs, defStyleAttr, defStyleRes).build();
        checkBoxDrawableBuilder=new CheckBoxDrawable.Builder(context, attrs, defStyleAttr, defStyleRes);
        checkBoxDrawable =checkBoxDrawableBuilder.build();

        checkBoxDrawable.setInEditMode(isInEditMode());
        checkBoxDrawable.setAnimEnable(false);
        setButtonDrawable(checkBoxDrawable);
        checkBoxDrawable.setAnimEnable(true);
    }

    public void setCheckedImmediately(boolean checked){
        if(mButtonDrawable instanceof CheckBoxDrawable){
            CheckBoxDrawable drawable = (CheckBoxDrawable)mButtonDrawable;
            drawable.setAnimEnable(false);
            setChecked(checked);
            drawable.setAnimEnable(true);
        }
        else
            setChecked(checked);
    }

    public CheckBoxDrawable getCheckBoxDrawable() {
        return checkBoxDrawable;
    }

    public void setCheckBoxDrawable(CheckBoxDrawable checkBoxDrawable) {
        this.checkBoxDrawable = checkBoxDrawable;
    }

    @Override
    public void setClickable(boolean clickable) {
        if(!clickable){
            setOnClickListener(null);
        }
        super.setClickable(clickable);
    }
}

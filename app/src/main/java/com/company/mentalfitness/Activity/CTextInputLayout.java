package com.company.mentalfitness.Activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class CTextInputLayout extends TextInputLayout {

    public CTextInputLayout(Context context) {
        this(context, null);
    }

    public CTextInputLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CTextInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (child instanceof EditText) {
            // cache the actual hint
            CharSequence hint = ((EditText)child).getHint();
            // remove the hint for now - we don't want TextInputLayout to see it
            ((EditText)child).setHint(null);
            // let `TextInputLayout` do its thing
            super.addView(child, index, params);
            // finally, set the hint back
            ((EditText)child).setHint(hint);
        } else {
            // Carry on adding the View...
            super.addView(child, index, params);
        }
    }
}
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xhanhan.comm;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.xhanhan.base.BaseActivity;
import com.xhanhan.fpzs.MainActivity;

public class ExitActivity extends Activity
{

    public ExitActivity()
    {
    }

    private void loadViews()
    {
    }

    private void setListener()
    {
    }

    public void exitbtnno(View view)
    {
        finish();
    }

    public void exitbtnyes(View view)
    {
        finish();
        MainActivity.instance.finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030002);
        loadViews();
        setListener();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        finish();
        return true;
    }
}

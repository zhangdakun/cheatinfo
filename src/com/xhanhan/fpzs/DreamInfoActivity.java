// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xhanhan.fpzs;

import net.youmi.android.banner.AdSize;
import net.youmi.android.banner.AdView;

import com.android.adlib.ADbaseActivity;
import com.android.myappfangf.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.*;
import android.widget.*;

public class DreamInfoActivity extends ADbaseActivity
    implements android.view.View.OnTouchListener, android.view.GestureDetector.OnGestureListener
{
    class OnBackBtnListener
        implements android.view.View.OnClickListener
    {

        public void onClick(View view)
        {
            finish();
        }

//        final DreamInfoActivity this$0;
//
//        OnBackBtnListener()
//        {
//            this$0 = DreamInfoActivity.this;
//            super();
//        }
    }


    public DreamInfoActivity()
    {
        verticalMinDistance = 50;
        minVelocity = 0;
    }

    private void loadViews()
    {
        dreamInfoTxt = (TextView)findViewById(0x7f070007);
        dreamInfoTitle = (TextView)findViewById(0x7f070006);
        backBtn = (ImageButton)findViewById(0x7f070009);
    }

    private void setListener()
    {
        backBtn.setOnClickListener(new OnBackBtnListener());
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030001);
        LinearLayout adLayout = (LinearLayout) findViewById(R.id.adLayout);
        AdView adView = new AdView(this, AdSize.FIT_SCREEN);
        adLayout.addView(adView);
        
        loadViews();
        setListener();
        mGestureDetector = new GestureDetector(this);
        LinearLayout linearlayout = (LinearLayout)findViewById(0x7f070004);
        linearlayout.setOnTouchListener(this);
        linearlayout.setLongClickable(true);
        Intent intent = getIntent();
        dreamInfoTitle.setText(intent.getExtras().getString("dream_name"));
        dreamInfoTxt.setText(intent.getExtras().getString("dream_value"));
        dreamInfoTxt.setMovementMethod(ScrollingMovementMethod.getInstance());
        dreamInfoTxt.setOnTouchListener(this);
        dreamInfoTxt.setLongClickable(true);
    }

    public boolean onDown(MotionEvent motionevent)
    {
        return false;
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if(motionevent1.getX() - motionevent.getX() > (float)verticalMinDistance && Math.abs(f) > (float)minVelocity)
            finish();
        return false;
    }

    public void onLongPress(MotionEvent motionevent)
    {
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return false;
    }

    public void onShowPress(MotionEvent motionevent)
    {
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        return false;
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        return mGestureDetector.onTouchEvent(motionevent);
    }

    private ImageButton backBtn;
    private TextView dreamInfoTitle;
    private TextView dreamInfoTxt;
    private GestureDetector mGestureDetector;
    private int minVelocity;
    private int verticalMinDistance;
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xhanhan.fpzs;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
//import com.bcc.ds.uti.JMPManager;
import com.xhanhan.base.BaseActivity;
import com.xhanhan.comm.*;
import java.io.IOException;

import net.youmi.android.AdManager;

// Referenced classes of package com.xhanhan.fpzs:
//            FPLstActivity

public class MainActivity extends BaseActivity
{
    class OnBtn1Listener
        implements android.view.View.OnClickListener
    {

        public void onClick(View view)
        {
            strFPLst(0);
        }

//        final MainActivity this$0;
//
//        OnBtn1Listener()
//        {
//            this$0 = MainActivity.this;
//            super();
//        }
    }

    class OnBtn2Listener
        implements android.view.View.OnClickListener
    {

        public void onClick(View view)
        {
            strFPLst(1);
        }

//        final MainActivity this$0;
//
//        OnBtn2Listener()
//        {
//            this$0 = MainActivity.this;
//            super();
//        }
    }

    class OnBtn3Listener
        implements android.view.View.OnClickListener
    {

        public void onClick(View view)
        {
            strFPLst(2);
        }

//        final MainActivity this$0;
//
//        OnBtn3Listener()
//        {
//            this$0 = MainActivity.this;
//            super();
//        }
    }

    class OnBtn4Listener
        implements android.view.View.OnClickListener
    {

        public void onClick(View view)
        {
            strFPLst(3);
        }

//        final MainActivity this$0;
//
//        OnBtn4Listener()
//        {
//            this$0 = MainActivity.this;
//            super();
//        }
    }

    class OnBtn5Listener
        implements android.view.View.OnClickListener
    {

        public void onClick(View view)
        {
            strFPLst(4);
        }

//        final MainActivity this$0;
//
//        OnBtn5Listener()
//        {
//            this$0 = MainActivity.this;
//            super();
//        }
    }

    class OnBtn6Listener
        implements android.view.View.OnClickListener
    {

        public void onClick(View view)
        {
            strFPLst(5);
        }

//        final MainActivity this$0;
//
//        OnBtn6Listener()
//        {
//            this$0 = MainActivity.this;
//            super();
//        }
    }

    class OnBtn7Listener
        implements android.view.View.OnClickListener
    {

        public void onClick(View view)
        {
            strFPLst(6);
        }

//        final MainActivity this$0;
//
//        OnBtn7Listener()
//        {
//            this$0 = MainActivity.this;
//            super();
//        }
    }


    public MainActivity()
    {
    }

    private void setListener()
    {
        btn1.setOnClickListener(new OnBtn1Listener());
        btn2.setOnClickListener(new OnBtn2Listener());
        btn3.setOnClickListener(new OnBtn3Listener());
        btn4.setOnClickListener(new OnBtn4Listener());
        btn5.setOnClickListener(new OnBtn5Listener());
        btn6.setOnClickListener(new OnBtn6Listener());
        btn7.setOnClickListener(new OnBtn7Listener());
    }

    public void CreatDB()
    {
        try {
			CreateDB.CreateDBFile(getBaseContext().getAssets().open("FPZS.db"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//_L1:
//        return;
//        IOException ioexception;
//        ioexception;
//        ioexception.printStackTrace();
//          goto _L1
    }

    public void loadViews()
    {
        btn1 = (ImageButton)findViewById(0x7f070011);
        btn2 = (ImageButton)findViewById(0x7f070012);
        btn3 = (ImageButton)findViewById(0x7f070013);
        btn4 = (ImageButton)findViewById(0x7f070014);
        btn5 = (ImageButton)findViewById(0x7f070015);
        btn6 = (ImageButton)findViewById(0x7f070016);
        btn7 = (ImageButton)findViewById(0x7f070017);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030005);
//        (new JMPManager()).startService(this, 1);
        AdManager.getInstance(this).init("028b620e6a8c36aa",
        	    "55a6818e692177cb", false);
        
        CreatDB();
        loadViews();
        setListener();
        SqlTool.createDB(this);
        update();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if(i == 4 && keyevent.getRepeatCount() == 0)
        {
            Intent intent = new Intent();
            intent.setClass(this, ExitActivity.class);
            startActivity(intent);
        }
        return false;
    }

    public void strFPLst(int i)
    {
        Intent intent = new Intent(this, FPLstActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("grpId", i + 1);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private ImageButton btn1;
    private ImageButton btn2;
    private ImageButton btn3;
    private ImageButton btn4;
    private ImageButton btn5;
    private ImageButton btn6;
    private ImageButton btn7;
}

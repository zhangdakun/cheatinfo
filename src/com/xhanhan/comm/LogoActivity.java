// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xhanhan.comm;

import net.youmi.android.AdManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.xhanhan.fpzs.MainActivity;

public class LogoActivity extends Activity
{

    public LogoActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030004);
        
        AdManager.getInstance(this).init("028b620e6a8c36aa",
        	    "55a6818e692177cb", false);
        
        (new Handler()).postDelayed(new Runnable() {

            public void run()
            {
                Intent intent = new Intent(LogoActivity.this, MainActivity.class);
                startActivity(intent);
                if(Integer.valueOf(android.os.Build.VERSION.SDK).intValue() >= 5)
                    overridePendingTransition(0x10a0000, 0x10a0001);
                finish();
            }

//            final LogoActivity this$0;
//
//            
//            {
//                this$0 = LogoActivity.this;
//                super();
//            }
        }
, 1000L);
    }

    private final int SPLASH_DISPLAY_LENGHT = 1000;
}

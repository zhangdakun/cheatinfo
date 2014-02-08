// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xhanhan.base;

import android.app.Activity;
import android.os.*;
import android.view.Window;

import com.android.adlib.ADbaseActivity;
import com.xhanhan.comm.UpdateManager;

public class BaseActivity extends ADbaseActivity
{

    public BaseActivity()
    {
    }

    protected final void fullScreenForm()
    {
        super.requestWindowFeature(1);
        super.setRequestedOrientation(1);
        super.getWindow().setFlags(1024, 1024);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        instance = this;
    }

    protected final void setVersionNet()
    {
        StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder()).detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        StrictMode.setVmPolicy((new android.os.StrictMode.VmPolicy.Builder()).detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath().build());
    }

    protected final void update()
    {
        (new Thread() {

            public void run()
            {
                Looper.prepare();
                (new UpdateManager(BaseActivity.this)).checkUpdate(Boolean.valueOf(false));
                Looper.loop();
            }

//            final BaseActivity this$0;
//
//            
//            {
//                this$0 = BaseActivity.this;
//                super();
//            }
        }
).start();
    }

    public static BaseActivity instance = null;

}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xhanhan.comm;

import android.app.Dialog;
import android.content.*;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.*;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.io.*;
import java.net.*;

// Referenced classes of package com.xhanhan.comm:
//            NetworkState, JsonUtil

public class UpdateManager
{
    private class downloadApkThread extends Thread
    {

        public void run()
        {
//            if(!Environment.getExternalStorageState().equals("mounted")) goto _L2; else goto _L1
//_L1:
//            int i;
//            InputStream inputstream;
//            FileOutputStream fileoutputstream;
//            int j;
//            byte abyte0[];
//            String s = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").toString();
//            mSavePath = (new StringBuilder(String.valueOf(s))).append("download").toString();
//            HttpURLConnection httpurlconnection = (HttpURLConnection)(new URL(apkDownUrl)).openConnection();
//            httpurlconnection.connect();
//            i = httpurlconnection.getContentLength();
//            inputstream = httpurlconnection.getInputStream();
//            File file = new File(mSavePath);
//            if(!file.exists())
//                file.mkdir();
//            fileoutputstream = new FileOutputStream(new File(mSavePath, apkName));
//            j = 0;
//            abyte0 = new byte[1024];
//_L6:
//            int k;
//            k = inputstream.read(abyte0);
//            j += k;
//            progress = (int)(100F * ((float)j / (float)i));
//            mHandler.sendEmptyMessage(1);
//            if(k > 0) goto _L4; else goto _L3
//_L3:
//            mHandler.sendEmptyMessage(2);
//_L5:
//            fileoutputstream.close();
//            inputstream.close();
//_L2:
//            mDownloadDialog.dismiss();
//            return;
//_L4:
//            boolean flag;
//            fileoutputstream.write(abyte0, 0, k);
//            flag = cancelUpdate;
//            if(!flag) goto _L6; else goto _L5
//            MalformedURLException malformedurlexception;
//            malformedurlexception;
//            malformedurlexception.printStackTrace();
//              goto _L2
//            IOException ioexception;
//            ioexception;
//            ioexception.printStackTrace();
//              goto _L2
        }

//        final UpdateManager this$0;
//
//        private downloadApkThread()
//        {
//            this$0 = UpdateManager.this;
//            super();
//        }

        downloadApkThread(downloadApkThread downloadapkthread)
        {
//            this();
        }
    }


    public UpdateManager(Context context)
    {
        cancelUpdate = false;
        mHandler = new Handler() {

            public void handleMessage(Message message)
            {
//                message.what;
//                JVM INSTR tableswitch 1 2: default 28
//            //                           1 29
//            //                           2 49;
//                   goto _L1 _L2 _L3
//_L1:
//                return;
//_L2:
//                mProgress.setProgress(progress);
//                continue; /* Loop/switch isn't completed */
//_L3:
//                installApk();
//                if(true) goto _L1; else goto _L4
//_L4:
            }

//            final UpdateManager this$0;
//
//            
//            {
//                this$0 = UpdateManager.this;
//                super();
//            }
        }
;
        mContext = context;
    }

    private void downloadApk()
    {
        (new downloadApkThread(null)).start();
    }

    private int getVersionCode(Context context)
    {
        int i = 0;
        try
        {
            i = context.getPackageManager().getPackageInfo("com.xhanhan", 0).versionCode;
        }
        catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception.printStackTrace();
        }
        return i;
    }

    private void installApk()
    {
        File file = new File(mSavePath, apkName);
        if(file.exists())
        {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse((new StringBuilder("file://")).append(file.toString()).toString()), "application/vnd.android.package-archive");
            mContext.startActivity(intent);
        }
    }

    private boolean isCheckUpdate()
    {
//        boolean flag = true;
//        int i = JsonUtil.newJsonUtil(NetworkState.getJsonByURL("http://211.149.149.69:8888/FPZS.html")).getInt("isUp");
//        if(i != flag) goto _L2; else goto _L1
//_L1:
//        return flag;
//        Exception exception;
//        exception;
//        exception.printStackTrace();
//_L2:
//        flag = false;
//        if(true) goto _L1; else goto _L3
//_L3:
    	return false;
    }

    private boolean isUpdate()
    {
//        boolean flag;
//        int i;
//        String s;
//        flag = true;
//        i = getVersionCode(mContext);
//        System.out.println(i);
//        s = NetworkState.getJsonByURL("http://211.149.149.69:8888/FPZS.html");
//        if(JsonUtil.newJsonUtil(s).getInt("isUp") != flag) goto _L2; else goto _L1
//_L1:
//        int j;
//        j = JsonUtil.newJsonUtil(s).getInt("verCode");
//        apkDownUrl = JsonUtil.newJsonUtil(s).getString("verUrl");
//        apkName = JsonUtil.newJsonUtil(s).getString("verName");
//        if(j <= i || apkDownUrl == null || "".equals(apkDownUrl) || apkName == null) goto _L2; else goto _L3
//_L3:
//        boolean flag1 = "".equals(apkName);
//        if(flag1) goto _L2; else goto _L4
//_L4:
//        return flag;
//        Exception exception;
//        exception;
//        exception.printStackTrace();
//_L2:
//        flag = false;
//        if(true) goto _L4; else goto _L5
//_L5:
    	return false;
    }

    private void showDownloadDialog()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(mContext);
        builder.setTitle(0x7f05000a);
        View view = LayoutInflater.from(mContext).inflate(0x7f030006, null);
        mProgress = (ProgressBar)view.findViewById(0x7f070018);
        builder.setView(view);
        builder.setNegativeButton(0x7f05000b, new android.content.DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                cancelUpdate = true;
            }

//            final UpdateManager this$0;
//
//            
//            {
//                this$0 = UpdateManager.this;
//                super();
//            }
        }
);
        mDownloadDialog = builder.create();
        mDownloadDialog.show();
        downloadApk();
    }

    private void showNoticeDialog()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(mContext);
        builder.setTitle(0x7f050006);
        builder.setMessage(0x7f050007);
        builder.setPositiveButton(0x7f050008, new android.content.DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                showDownloadDialog();
            }

//            final UpdateManager this$0;
//
//            
//            {
//                this$0 = UpdateManager.this;
//                super();
//            }
        }
);
        builder.setNegativeButton(0x7f050009, new android.content.DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

//            final UpdateManager this$0;
//
//            
//            {
//                this$0 = UpdateManager.this;
//                super();
//            }
        }
);
        builder.create().show();
    }

    public void checkUpdate(Boolean boolean1)
    {
//        if(!isCheckUpdate()) goto _L2; else goto _L1
//_L1:
//        if(!isUpdate()) goto _L4; else goto _L3
//_L3:
//        showNoticeDialog();
//_L2:
//        return;
//_L4:
//        if(boolean1.booleanValue())
//            Toast.makeText(mContext, 0x7f05000c, 1).show();
//        if(true) goto _L2; else goto _L5
//_L5:
    }

    private static final int DOWNLOAD = 1;
    private static final int DOWNLOAD_FINISH = 2;
    private String apkDownUrl;
    private String apkName;
    private boolean cancelUpdate;
    private Context mContext;
    private Dialog mDownloadDialog;
    private Handler mHandler;
    private ProgressBar mProgress;
    private String mSavePath;
    private int progress;













}

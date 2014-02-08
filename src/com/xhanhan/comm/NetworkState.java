// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xhanhan.comm;

import java.io.IOException;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

public class NetworkState
{

    public NetworkState()
    {
    }

    public static String getHtmlByURL(String s)
    {
        String s2 = null;
        DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
        org.apache.http.params.HttpParams httpparams = defaulthttpclient.getParams();
        HttpConnectionParams.setConnectionTimeout(httpparams, 5000);
        HttpConnectionParams.setSoTimeout(httpparams, 5000);
        try {
			s2 = EntityUtils.toString(defaulthttpclient.execute(new HttpGet(s)).getEntity(), "GBK");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        String s1 = s2;
//_L2:
//        return s1;
//        Exception exception;
//        exception;
//        exception.printStackTrace();
//        s1 = null;
//        if(true) goto _L2; else goto _L1
//_L1:
        
        return s2;
    }

    public static String getJsonByURL(String s)
    {
        String s2 = null;
        DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
        org.apache.http.params.HttpParams httpparams = defaulthttpclient.getParams();
        HttpConnectionParams.setConnectionTimeout(httpparams, 5000);
        HttpConnectionParams.setSoTimeout(httpparams, 5000);
        try {
			s2 = EntityUtils.toString(defaulthttpclient.execute(new HttpGet(s)).getEntity());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        String s1 = s2;
//_L2:
//        return s1;
//        Exception exception;
//        exception;
//        exception.printStackTrace();
//        s1 = null;
//        if(true) goto _L2; else goto _L1
//_L1:
        
        return s2;
    }

    public static boolean isNetworkAvailable(Context context)
    {
        ConnectivityManager connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
//        if(connectivitymanager == null) goto _L2; else goto _L1
//_L1:
//        NetworkInfo anetworkinfo[] = connectivitymanager.getAllNetworkInfo();
//        if(anetworkinfo == null) goto _L2; else goto _L3
//_L3:
//        int i = 0;
//_L8:
//        if(i < anetworkinfo.length) goto _L4; else goto _L2
//_L2:
//        boolean flag = false;
//_L6:
//        return flag;
//_L4:
//        if(anetworkinfo[i].getState() != android.net.NetworkInfo.State.CONNECTED)
//            break; /* Loop/switch isn't completed */
//        flag = true;
//        if(true) goto _L6; else goto _L5
//_L5:
//        i++;
//        if(true) goto _L8; else goto _L7
//_L7:
        
        return true;
    }
}

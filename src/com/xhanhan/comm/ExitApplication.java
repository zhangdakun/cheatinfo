// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xhanhan.comm;

import android.app.Activity;
import android.app.Application;
import java.util.*;

public class ExitApplication extends Application
{

    private ExitApplication()
    {
        activityList = new LinkedList();
    }

    public static ExitApplication getInstance()
    {
        if(instance == null)
            instance = new ExitApplication();
        return instance;
    }

    public void addActivity(Activity activity)
    {
        activityList.add(activity);
    }

    public void backHome()
    {
        Iterator iterator = activityList.iterator();
        do
        {
            if(!iterator.hasNext())
                return;
            ((Activity)iterator.next()).finish();
        } while(true);
    }

    private static ExitApplication instance;
    private List activityList;
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xhanhan.comm;

import android.app.Activity;
import android.database.Cursor;

// Referenced classes of package com.xhanhan.comm:
//            DBHelper

public class SqlTool
{

    public SqlTool()
    {
    }

    public static void closeDB()
    {
        dbHelper.close();
    }

    public static void createDB(Activity activity)
    {
        if(dbHelper == null)
            dbHelper = new DBHelper(activity, "FPZS.db");
    }

    public static Cursor getData(String s, String as[])
    {
        return dbHelper.getData(s, as);
    }

    public static int getSQLCount(String s, String as[])
    {
        Cursor cursor = dbHelper.getData(s, as);
        int i;
        cursor.moveToFirst();
        i = cursor.getInt(0);
        cursor.close();
        dbHelper.close();
        return i;
//        Exception exception;
//        exception;
//        cursor.close();
//        dbHelper.close();
//        throw exception;
    }

    public static String getSQLStr(String s, String as[])
    {
        Cursor cursor = dbHelper.getData(s, as);
        String s1;
        cursor.moveToFirst();
        s1 = cursor.getString(0);
        cursor.close();
        dbHelper.close();
        return s1;
//        Exception exception;
//        exception;
//        cursor.close();
//        dbHelper.close();
//        throw exception;
    }

    private static DBHelper dbHelper;
}

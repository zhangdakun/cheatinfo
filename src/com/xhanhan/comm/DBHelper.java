// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xhanhan.comm;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper
{

    public DBHelper(Context context, String s)
    {
        this(context, s, 1);
    }

    public DBHelper(Context context, String s, int i)
    {
        this(context, s, null, i);
    }

    public DBHelper(Context context, String s, android.database.sqlite.SQLiteDatabase.CursorFactory cursorfactory, int i)
    {
        super(context, s, cursorfactory, i);
    }

    public boolean ExecSQL(ArrayList arraylist)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        int i;
        sqlitedatabase.beginTransaction();
        i = 0;
//_L1:
//        if(i < arraylist.size())
//            break MISSING_BLOCK_LABEL_31;
//        sqlitedatabase.setTransactionSuccessful();
//        sqlitedatabase.endTransaction();
//        return true;
//        try
//        {
//            sqlitedatabase.execSQL(((String)arraylist.get(i)).toString());
//        }
//        catch(Exception exception)
//        {
//            sqlitedatabase.endTransaction();
//            throw new RuntimeException(exception);
//        }
//        i++;
//          goto _L1
        
        for(i =0;i < arraylist.size();i++) {

          try
          {
              sqlitedatabase.execSQL(((String)arraylist.get(i)).toString());
          }
          catch(Exception exception)
          {
              sqlitedatabase.endTransaction();
//              throw new RuntimeException(exception);
              exception.printStackTrace();
          }        	
        }
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        return true;
    }

    public Cursor getData(String s, String as[])
    {
        return getReadableDatabase().rawQuery(s, as);
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
    }

    private static final int VERSION = 1;
}

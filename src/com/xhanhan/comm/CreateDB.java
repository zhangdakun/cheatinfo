// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xhanhan.comm;

import java.io.*;

public class CreateDB
{

    public CreateDB()
    {
    }

    public static void CreateDBFile(InputStream inputstream)
    {
        File file = new File("/data/data/com.android.myappfangf/databases/FPZS.db");
        if(file.exists())
            file.delete();
        if(!file.exists())
        {
            File file1 = new File("/data/data/com.android.myappfangf/databases/");
            if(!file1.exists())
                file1.mkdir();
            try
            {
                FileOutputStream fileoutputstream = new FileOutputStream("/data/data/com.android.myappfangf/databases/FPZS.db");
//                String packname = 
                byte abyte0[] = new byte[1024];
                do
                {
                    int i = inputstream.read(abyte0);
                    if(i <= 0)
                    {
                        fileoutputstream.flush();
                        fileoutputstream.close();
                        inputstream.close();
                        break;
                    }
                    fileoutputstream.write(abyte0, 0, i);
                } while(true);
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
    }

    public static final String DB_NAME = "FPZS.db";
    public static final String DB_PATH = "/data/data/com.xhanhan.fpzs/databases/";
}

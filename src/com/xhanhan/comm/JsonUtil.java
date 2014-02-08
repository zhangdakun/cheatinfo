// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xhanhan.comm;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.json.*;

public class JsonUtil
{

    public JsonUtil()
    {
    }

    private JsonUtil(String s)
    {
        jsonObject = getJsonObject(s);
    }

    public static String getFieldValue(Class class1, Object obj)
        throws IllegalArgumentException, IllegalAccessException
    {
        StringBuffer stringbuffer = new StringBuffer();
        Field afield[] = class1.getFields();
        int i = 0;
        do
        {
            if(i >= afield.length)
                return stringbuffer.toString();
            stringbuffer.append((new StringBuilder(String.valueOf(afield[i].getName()))).append("=").append(afield[i].get(obj)).toString()).append("\n");
            i++;
        } while(true);
    }

    public static JsonUtil getJsonUtil(String s)
    {
        if(myJsonUtil == null)
            myJsonUtil = new JsonUtil(s);
        return myJsonUtil;
    }

    public static JsonUtil newJsonUtil(String s)
    {
        myJsonUtil = new JsonUtil(s);
        return myJsonUtil;
    }

    public double getDouble(String s)
        throws JSONException
    {
        double d;
        if(jsonObject != null)
            d = jsonObject.getDouble(s);
        else
            d = -1D;
        return d;
    }

    public int getInt(String s)
        throws JSONException
    {
        int i;
        if(jsonObject != null)
            i = jsonObject.getInt(s);
        else
            i = -1;
        return i;
    }

    public JSONObject getJsonObject(String s)
    {
        JSONObject jsonobject = null;
//        JSONObject jsonobject1;
		try {
			jsonobject = new JSONObject(s);
		} catch (JSONException e) {
			// TODO Auto-generated catch block

//        jsonobject = jsonobject1;
		e.printStackTrace();
	}
//_L2:
//        return jsonobject;
//        JSONException jsonexception;
//        jsonexception;
//        jsonexception.printStackTrace();
//        if(true) goto _L2; else goto _L1
//_L1:
        
        return jsonobject;
        		
    }

    public List getList(String s, Class class1)
        throws Exception
    {
        ArrayList arraylist = null;
//        if(jsonObject == null) goto _L2; else goto _L1
//_L1:
//        JSONArray jsonarray = jsonObject.getJSONArray(s);
//        if(jsonarray.isNull(0)) goto _L2; else goto _L3
//_L3:
//        int i;
//        arraylist = new ArrayList();
//        i = 0;
//_L6:
//        if(i < jsonarray.length()) goto _L4; else goto _L2
//_L2:
//        return arraylist;
//_L4:
//        arraylist.add(getObject(jsonarray.getJSONObject(i), null, class1));
//        i++;
//        if(true) goto _L6; else goto _L5
//_L5:
        if(jsonObject != null) {
          JSONArray jsonarray = jsonObject.getJSONArray(s);
          if(!jsonarray.isNull(0)) {
        	  arraylist = new ArrayList();
        	  for(int i=0; i<jsonarray.length();i++) {
        		  
        		  arraylist.add(getObject(jsonarray.getJSONObject(i), null, class1));
        	  }
          }

        	
        }
        
        return arraylist;
    }

    public Object getObject(Class class1)
        throws Exception
    {
        Object obj;
        if(jsonObject != null)
            obj = getObject(class1.getSimpleName().toLowerCase(), class1);
        else
            obj = null;
        return obj;
    }

    public Object getObject(String s, Class class1)
        throws Exception
    {
        Object obj;
        if(jsonObject != null)
            obj = getObject(jsonObject, s, class1);
        else
            obj = null;
        return obj;
    }

    public Object getObject(JSONObject jsonobject, Class class1)
        throws Exception
    {
        return getObject(jsonobject, class1.getSimpleName().toLowerCase(), class1);
    }

    public Object getObject(JSONObject jsonobject, String s, Class class1)
        throws Exception
    {
        Object obj = null;
        if(jsonobject != null)
        {
            JSONObject jsonobject1;
            if(s != null)
                jsonobject1 = jsonobject.getJSONObject(s);
            else
                jsonobject1 = jsonobject;
            if(jsonobject1 != null)
                if(class1.equals(null))
                {
                    obj = jsonobject1.get(s);
                } else
                {
                    obj = class1.newInstance();
                    Field afield[] = class1.getDeclaredFields();
                    int i = 0;
                    while(i < afield.length) 
                    {
                        Field field = afield[i];
                        field.setAccessible(true);
                        java.lang.reflect.Type type = field.getGenericType();
                        String s1 = jsonobject1.getString(field.getName());
                        if(type.equals(Integer.TYPE))
                            field.setInt(obj, Integer.valueOf(s1).intValue());
                        else
                        if(type.equals(Double.TYPE))
                            field.setDouble(obj, Double.valueOf(s1).doubleValue());
                        else
                            field.set(obj, s1);
                        i++;
                    }
                }
        }
        return obj;
    }

    public String getString(String s)
        throws JSONException
    {
        String s1;
        if(jsonObject != null)
            s1 = jsonObject.getString(s);
        else
            s1 = null;
        return s1;
    }

    private static JsonUtil myJsonUtil;
    private JSONObject jsonObject;
}

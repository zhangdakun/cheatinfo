// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xhanhan.fpzs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.android.adlib.AD;
import com.android.adlib.ADbaseActivity;
import com.android.myappfangf.R;
import com.xhanhan.comm.SqlTool;
import java.util.*;

import net.youmi.android.banner.AdSize;
import net.youmi.android.banner.AdView;

// Referenced classes of package com.xhanhan.fpzs:
//            DreamAdapter, DreamInfoActivity

public class FPLstActivity extends ADbaseActivity
{
    class OnBackBtnListener
        implements android.view.View.OnClickListener
    {

        public void onClick(View view)
        {
            finish();
        }

//        final FPLstActivity this$0;
//
//        OnBackBtnListener()
//        {
//            this$0 = FPLstActivity.this;
//            super();
//        }
    }


    public FPLstActivity()
    {
    }

    private void loadViews()
    {
        backBtn = (ImageButton)findViewById(0x7f07000f);
    }

    private void setListener()
    {
        backBtn.setOnClickListener(new OnBackBtnListener());
    }

    public void getDreamLst(String s)
    {
        Cursor cursor;
        ArrayList arraylist;
        String as[] = new String[1];
        as[0] = s;
        cursor = SqlTool.getData("select * from Tab_Child where grp_id = ?", as);
        arraylist = new ArrayList();
//_L1:
//        if(cursor.moveToNext())
//            break MISSING_BLOCK_LABEL_114;

        for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()) {
          HashMap hashmap = new HashMap();
          hashmap.put("dream_id", Integer.valueOf(cursor.getInt(0)));
          hashmap.put("dream_name", cursor.getString(1));
          hashmap.put("dream_value", cursor.getString(2));
          arraylist.add(hashmap);        	
        }
        ListView listview = (ListView)findViewById(0x7f07000d);
        mtLst = arraylist;
        String as1[] = new String[1];
        as1[0] = "dream_name";
        int ai[] = new int[1];
        ai[0] = 0x7f070003;
        listview.setAdapter(new DreamAdapter(this, arraylist, 0x7f030000, as1, ai));
        listview.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
            	if(i >10) {
	            	if(!AD.i().haveOffers(context)) {
	            		return;
	            	}
            	}
                strDreamInfo(((HashMap)mtLst.get(i)).get("dream_name").toString(), ((HashMap)mtLst.get(i)).get("dream_value").toString());
            }

//            final FPLstActivity this$0;
//
//            
//            {
//                this$0 = FPLstActivity.this;
//                super();
//            }
        }
);
        SqlTool.closeDB();
//        return;
//        HashMap hashmap = new HashMap();
//        hashmap.put("dream_id", Integer.valueOf(cursor.getInt(0)));
//        hashmap.put("dream_name", cursor.getString(1));
//        hashmap.put("dream_value", cursor.getString(2));
//        arraylist.add(hashmap);
//          goto _L1
//        Exception exception;
//        exception;
//        SqlTool.closeDB();
//        throw exception;
    }

    public void getSearchDreamLst(String s)
    {
        Cursor cursor;
        ArrayList arraylist;
        String as[] = new String[1];
        as[0] = (new StringBuilder("%")).append(s).append("%").toString();
        cursor = SqlTool.getData("select * from Tab_Child where name like ?", as);
        arraylist = new ArrayList();
//_L1:
//        if(cursor.moveToNext())
//            break MISSING_BLOCK_LABEL_134;
        for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()) {
        
	      HashMap hashmap = new HashMap();
	      hashmap.put("dream_id", Integer.valueOf(cursor.getInt(0)));
	      hashmap.put("dream_name", cursor.getString(1));
	      hashmap.put("dream_value", cursor.getString(2));
	      arraylist.add(hashmap);
        	
        }
        ListView listview = (ListView)findViewById(0x7f07000d);
        mtLst = arraylist;
        String as1[] = new String[1];
        as1[0] = "dream_name";
        int ai[] = new int[1];
        ai[0] = 0x7f070003;
        listview.setAdapter(new DreamAdapter(this, arraylist, 0x7f030000, as1, ai));
        listview.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
            	if(i >10) {
	            	if(!AD.i().haveOffers(context)) {
	            		return;
	            	}
            	}
            	
                strDreamInfo(((HashMap)mtLst.get(i)).get("dream_name").toString(), ((HashMap)mtLst.get(i)).get("dream_value").toString());
            }

//            final FPLstActivity this$0;
//
//            
//            {
//                this$0 = FPLstActivity.this;
//                super();
//            }
        }
);
        SqlTool.closeDB();
//        return;
//        HashMap hashmap = new HashMap();
//        hashmap.put("dream_id", Integer.valueOf(cursor.getInt(0)));
//        hashmap.put("dream_name", cursor.getString(1));
//        hashmap.put("dream_value", cursor.getString(2));
//        arraylist.add(hashmap);
//          goto _L1
//        Exception exception;
//        exception;
//        SqlTool.closeDB();
//        throw exception;
    }
    
    private Context context;
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030003);
        
        context = this;
        
        LinearLayout adLayout = (LinearLayout) findViewById(R.id.adLayout);
        AdView adView = new AdView(this, AdSize.FIT_SCREEN);
        adLayout.addView(adView);
        
        loadViews();
        setListener();
        getDreamLst(String.valueOf(getIntent().getExtras().getInt("grpId")));
    }

    public void strDreamInfo(String s, String s1)
    {
        Intent intent = new Intent(this,  DreamInfoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("dream_name", s);
        bundle.putString("dream_value", s1);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private ImageButton backBtn;
    private List mtLst;

}

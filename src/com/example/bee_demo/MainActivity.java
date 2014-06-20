package com.example.bee_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {

	private String[] items = {"用户基本信息", "蜂场基本信息", "蜂场年度信息", "日常操作信息", "摇蜜信息采集", "数据上传管理"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/*
		EditText email = (EditText)findViewById(R.id.email);
		email.setText("jack@hutc");
		
		EditText fc = new EditText(this);
		fc.setText("fengchang");
		LinearLayout lay = new LinearLayout(this);
		lay.setOrientation(LinearLayout.VERTICAL);
		lay.addView(fc);
		setContentView(lay);
		*/
		
		//ArrayAdapter adapt = new ArrayAdapter<String>(this, lay, items);
		ListView menu = (ListView)findViewById(R.id.menu);
		menu.setOnItemClickListener(
				new OnItemClickListener(){

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int pos, long id) {
						// TODO Auto-generated method stub
						
						switch(pos)
						{
							case 0:
								startActivity(new Intent(getApplicationContext(), UserInfoActivity.class));
								break;
							case 1:
								startActivity(new Intent(getApplicationContext(), BeeInfoActivity.class));
								break;
							case 2:
								break;
						}		
							
						
						
					}}
				);
	}
}

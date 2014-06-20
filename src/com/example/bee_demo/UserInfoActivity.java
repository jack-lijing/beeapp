package com.example.bee_demo;

import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserInfoActivity extends Activity {

	public SharedPreferences setting;
	public String EMAIL;
	public User person;
	
	private EditText xm ;
	private EditText dh ;
	private EditText sfz ;
	private EditText fcdz ;
	private EditText fcmc ;
	private EditText fcgm ;
	private Button but;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.userinfo);
		
		Intent intent = getIntent();
		//String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		
		//get
		xm = (EditText)findViewById(R.id.xm);
		dh = (EditText)findViewById(R.id.dh);
		sfz = (EditText)findViewById(R.id.sfz);
		fcdz = (EditText)findViewById(R.id.fcdz);
		fcmc = (EditText)findViewById(R.id.fcmc);
		fcgm = (EditText)findViewById(R.id.fcgm);
		but = (Button)findViewById(R.id.submit);
		
		//SharedPreferences setting = getPreferences(MODE_PRIVATE);
		setting = getSharedPreferences(EMAIL, 0);
		// 非第一次登录
		if(setting.contains("user")){
			Map<String, ?> map =  setting.getAll();
			xm.setText((String)map.get("xm"));
			dh.setText((String)map.get("dh"));
			sfz.setText((String)map.get("sfz"));
			fcmc.setText((String)map.get("fcmc"));
			fcdz.setText((String)map.get("fcdz"));
			fcgm.setText((String)map.get("fcgm"));
		}else			//第一次登录
		{
			
		}

		
		xm.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				String name = "";
				// get userinfo from  internet
				if (hasFocus){
					if(name != null){
						((EditText)v).setText(name);
					}
				}else{
					name = ((EditText)v).getText().toString();
				}
			}
		});
		
	}
	
	public void saveUserInfo(View view){
		//do save info HTTP
		//Intent intent = new Intent(this,);
		if(but.getText().equals("编辑"))
		{
			xm.setEnabled(true);
			dh.setEnabled(true);
			sfz.setEnabled(true);
			fcmc.setEnabled(true);
			fcdz.setEnabled(true);
			fcgm.setEnabled(true);
			but.setText("保存");
		}else{
			SharedPreferences.Editor se = setting.edit();
			se.clear();
			se.putString("user", EMAIL);
			se.putString("xm", xm.getText().toString() );
			se.putString("dh", dh.getText().toString() );
			se.putString("sfz", sfz.getText().toString() );
			se.putString("fcmc", fcmc.getText().toString() );
			se.putString("fcdz", fcdz.getText().toString() );
			se.putString("fcgm", fcgm.getText().toString() );
			se.commit();
			xm.setEnabled(false);
			dh.setEnabled(false);
			sfz.setEnabled(false);
			fcmc.setEnabled(false);
			fcdz.setEnabled(false);
			fcgm.setEnabled(false);
			but.setText("编辑");
		}
	}
}

package com.example.broadcastbestpractice.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.broadcastbestpractice.R;

public class MainActivity extends BaseActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button forceOffineButton = (Button) findViewById(R.id.froce_offline_button);
		forceOffineButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (R.id.froce_offline_button == v.getId()) {
			Intent intent = new Intent(
					"com.han.broadcastpractice.FORCE_OFFLINE");
			sendBroadcast(intent);
		}
	}

}

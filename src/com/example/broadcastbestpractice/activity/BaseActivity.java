package com.example.broadcastbestpractice.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.broadcastbestpractice.activitycollector.ActivityCollector;

public class BaseActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e("BaseActivity", getClass().getSimpleName());
		ActivityCollector.addActivity(this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		ActivityCollector.removeActivity(this);
	}
}

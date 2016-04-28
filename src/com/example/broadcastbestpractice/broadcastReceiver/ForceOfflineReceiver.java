package com.example.broadcastbestpractice.broadcastReceiver;

import com.example.broadcastbestpractice.activity.LoginActivity;
import com.example.broadcastbestpractice.activitycollector.ActivityCollector;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.WindowManager;

public class ForceOfflineReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(final Context context, Intent intent) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle("Warnning!");
		builder.setCancelable(false);
		builder.setMessage("you are forced offline. please try login again.");
		builder.setPositiveButton("OK", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				ActivityCollector.finishAll();
				Intent intent = new Intent(context,LoginActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(intent);
			}
		});
		AlertDialog dialog = builder.create();
		dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
		dialog.show();
	}

}

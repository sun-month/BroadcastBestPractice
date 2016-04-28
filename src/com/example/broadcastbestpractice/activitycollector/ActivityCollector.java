package com.example.broadcastbestpractice.activitycollector;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

public class ActivityCollector {
	private static List<Activity> list = new ArrayList<Activity>();

	public static void addActivity(Activity activity) {
		list.add(activity);
	}

	public static void removeActivity(Activity activity) {
		list.remove(activity);
	}

	public static void finishAll() {
		for (Activity activity : list) {
			if (!activity.isFinishing()) {
				activity.finish();
			}
		}
	}
}

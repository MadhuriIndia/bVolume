package com.mk.a2dp.Volume;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * @author Jim Roal This broadcast receiver just listens to the BOOT_COMPLETE
 *         intent and starts the service if the preference is set to do so
 */
public class Starter extends BroadcastReceiver {
	SharedPreferences preferences;

	public static final String PREFS_NAME = "com.mk.a2dp.Volume_preferences";

	@Override
	public void onReceive(Context context, Intent arg1) {

		preferences = context.getSharedPreferences(PREFS_NAME, 0);

		if (preferences.getBoolean("bootstart", false)) {
			context.startService(new Intent(context, service.class));
		}
	}
}

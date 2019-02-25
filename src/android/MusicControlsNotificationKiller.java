package com.homerours.musiccontrols;

import android.app.Service;
import android.os.IBinder;
import android.os.Binder;
import android.app.NotificationManager;
import android.content.Intent;

public class MusicControlsNotificationKiller extends Service {

	private final int NOTIFICATION_ID = 27071976;
	private NotificationManager mNM;
	private final IBinder mBinder = new KillBinder(this);

	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return Service.START_STICKY;
	}
	
	@Override
	public void onDestroy() {
		mNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		mNM.cancel(NOTIFICATION_ID);
	}
}

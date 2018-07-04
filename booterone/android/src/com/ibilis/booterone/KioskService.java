/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package com.ibilis.booterone;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiC;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;
import org.appcelerator.titanium.util.TiConvert;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiCompositeLayout;
import org.appcelerator.titanium.view.TiCompositeLayout.LayoutArrangement;
import org.appcelerator.titanium.view.TiUIView;
import org.appcelerator.titanium.TiApplication;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Service;
import android.os.IBinder;
import android.content.SharedPreferences;
import android.content.ComponentName;
import android.preference.PreferenceManager;
import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.app.PendingIntent;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class KioskService extends Service {

	  private static final long INTERVAL = TimeUnit.SECONDS.toMillis(2); // periodic interval to check in seconds -> 2 seconds
	  private static final String TAG = KioskService.class.getSimpleName();
	  private static final String PREF_KIOSK_MODE = "pref_kiosk_mode";

	  private Thread t = null;
	  private Context ctx = null;
	  private boolean running = false;

	  @Override
	  public void onDestroy() {
	    Log.i(TAG, "Stopping service 'KioskService'");
	    running =false;
	    super.onDestroy();
	  }

	  @Override
	  public int onStartCommand(Intent intent, int flags, int startId) {
	    Log.i(TAG, "Starting service 'KioskService'");
	    running = true;
	    ctx = this;
	    
	    // start a thread that periodically checks if your app is in the foreground
	    t = new Thread(new Runnable() {
	      @Override
	      public void run() {
	        do {
	          handleKioskMode();
	          try {
	            Thread.sleep(INTERVAL);
	          } catch (InterruptedException e) {
	            Log.i(TAG, "Thread interrupted: 'KioskService'");
	          }
	        }while(running);
	        stopSelf();
	      }
	    });

	    t.start();
	    return Service.START_NOT_STICKY;
	  }

	  private void handleKioskMode() {
	    // is Kiosk Mode active? 
		  if(isKioskModeActive()) {
		    // is App in background?
	      if(isInBackground()) {
	        restoreApp(); // restore!
	      }
	    }
	  }

	  private boolean isInBackground() {
		TiApplication context = TiApplication.getInstance();
	    ActivityManager am = (ActivityManager) ctx.getSystemService(context.ACTIVITY_SERVICE);
	    
	    List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);
	    ComponentName componentInfo = taskInfo.get(0).topActivity;
	    return (!ctx.getApplicationContext().getPackageName().equals(componentInfo.getPackageName()));
	  }

	  private void restoreApp() {
	    // Restart activity
		  TiApplication context = TiApplication.getInstance();

		if(TiApplication.getInstance() == null){
			Intent standardIntent = context.getPackageManager().getLaunchIntentForPackage(context.getApplicationContext().getPackageName());
			context.startActivity(standardIntent); 		
		}else{
			Intent tiIntent = TiApplication.getInstance().getPackageManager().getLaunchIntentForPackage(TiApplication.getInstance().getApplicationContext().getPackageName());
			tiIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			TiApplication.getInstance().startActivity(tiIntent);						
		}
	  }
	  
	  public boolean isKioskModeActive() {
		TiApplication context = TiApplication.getInstance();
	    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
	    return sp.getBoolean(PREF_KIOSK_MODE, false);
	  }

	  @Override
	  public IBinder onBind(Intent intent) {
	    return null;
	  }
	}
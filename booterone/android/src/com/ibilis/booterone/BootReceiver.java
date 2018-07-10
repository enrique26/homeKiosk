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
import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.app.PendingIntent;
import android.view.KeyEvent;



public class BootReceiver extends BroadcastReceiver
{
	@Override
	public void onReceive(Context context, Intent intent) {
		if(TiApplication.getInstance() == null){
			Intent standardIntent = context.getPackageManager().getLaunchIntentForPackage(context.getApplicationContext().getPackageName());
			context.startActivity(standardIntent); 		
		}else{
			Intent tiIntent = TiApplication.getInstance().getPackageManager().getLaunchIntentForPackage(TiApplication.getInstance().getApplicationContext().getPackageName());
			tiIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			TiApplication.getInstance().startActivity(tiIntent);						
		}
	}
}
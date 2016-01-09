package com.xiaoxin.xiaoxinlib;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	private WifiManager mWifiManager;
	private WifiConfiguration wifiConfig;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Test();
	}

	private void Test() {
		wifiConfig=new WifiConfiguration();
		mWifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
		int wifiConfigId = mWifiManager.addNetwork(wifiConfig);
	}
}

package com.sandfoxstudio.indoor;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ScrollView;

public class IndoorLocalizationActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView1);
		//		scrollView.addView(locationView);
		LocationView locationView = (LocationView) findViewById(R.id.locationView);
		locationView.drawPoint(100, 100);
		locationView.drawPoint(105, 105);
	}
}
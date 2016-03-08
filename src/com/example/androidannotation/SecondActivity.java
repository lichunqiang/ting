package com.example.androidannotation;

import org.androidannotations.annotations.EActivity;

import android.app.Activity;
import android.os.Bundle;

@EActivity(R.layout.second_activity)
public class SecondActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
}

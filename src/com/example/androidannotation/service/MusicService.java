package com.example.androidannotation.service;

import java.io.IOException;

import com.example.androidannotation.R;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public class MusicService extends Service {
	private static final String TAG = "MusicPlayService";
	
	private MediaPlayer mediaPlayer;
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate() {
		Log.v(TAG, "onCreate");
		if (mediaPlayer == null) {
			mediaPlayer = MediaPlayer.create(this, R.raw.call);
			mediaPlayer.setLooping(false);
		}
	}
	
	@Override
	public void onDestroy() {
		Log.v(TAG, "onDestory");
		if (mediaPlayer != null ){
			mediaPlayer.stop();
			mediaPlayer.release();
		}
	}
	
	@Override
	public void onStart(Intent intent, int startId) {
		Log.v(TAG, "Service onStart");
		if (intent != null ){
			Bundle bundle = intent.getExtras();
			if (bundle != null) {
				int op = bundle.getInt("op");
				switch (op) {
				case 1:
					start();
					break;
				case 2:
					stop();
					break;
				case 3:
					pause();
					break;
				}
			}
			
		}
	}

	private void pause() {
		if (mediaPlayer != null && mediaPlayer.isPlaying()) {
			mediaPlayer.pause();
		}
		
	}

	private void stop() {
		if (mediaPlayer != null) {
			mediaPlayer.stop();
			try {
				mediaPlayer.prepare();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	private void start() {
		if (!mediaPlayer.isPlaying()) {
			mediaPlayer.start();
		}
		
	}
}

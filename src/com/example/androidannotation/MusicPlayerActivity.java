package com.example.androidannotation;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MusicPlayerActivity extends Activity implements OnClickListener {
	private static final String TAG = "musicPlayer";

	private Button btn_play;
	private Button btn_stop;
	private Button btn_pause;
	private Button btn_exit;
	private Button btn_close;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.music_player_activity);
		
		btn_play = (Button) findViewById(R.id.btn_play);
		btn_stop = (Button) findViewById(R.id.btn_stop);
		btn_pause = (Button) findViewById(R.id.btn_pause);
		btn_exit = (Button) findViewById(R.id.btn_exit);
		btn_close = (Button) findViewById(R.id.btn_close);
		
		btn_play.setOnClickListener(this);
		btn_stop.setOnClickListener(this);
		btn_pause.setOnClickListener(this);
		btn_exit.setOnClickListener(this);
		btn_close.setOnClickListener(this);
	}


	@Override
	public void onClick(View button) {
		int op = -1;
		Intent intent = new Intent();
		intent.setAction("com.example.androidannotation.service.MusicService");
		intent.setPackage(getPackageName());
		
		switch (button.getId()) {
		case R.id.btn_play:
			Log.d(TAG, "OnClick: Playing music");
			op = 1;
			break;
		case R.id.btn_stop:
			Log.d(TAG, "OnClicl: stopping music");
			op = 2;
			break;
		case R.id.btn_pause:
			Log.d(TAG, "OnClicl: paused music");
			op = 3;
			break;
		case R.id.btn_close:
			Log.d(TAG, "OnClick: Close");
			this.finish();
			break;
		case R.id.btn_exit:
			Log.d(TAG, "OnClick: Exit");
			op = 4;
			stopService(intent);
			this.finish();
			break;
		default:
			break;
		}
		
		Bundle bundle = new Bundle();
		bundle.putInt("op", op);
		intent.putExtras(bundle);
		
		this.startService(intent);
		
	}
}

package com.example.androidannotation;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {
	@ViewById(R.id.button1)
	Button button;
	
	@ViewById(R.id.btn_music)
	Button openMusicBtn;
	
	@Click(R.id.button1)
	public void startActivity() {
		Intent intent = new Intent(MainActivity.this, SecondActivity_.class);
		startActivity(intent);
	}
	
	@Click(R.id.btn_music)
	public void openMusicPlayer() {
		Intent intent = new Intent(MainActivity.this, MusicPlayerActivity.class);
		startActivity(intent);
	}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}

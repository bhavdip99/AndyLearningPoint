package com.bhavdip.learningpoint;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by Bhavdip Bhalodia on 08-10-2015.
 */
public class SplashScreen extends Activity {

    MediaPlayer ourSong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        ourSong = MediaPlayer.create(SplashScreen.this, R.raw.music);
        ourSong.start();

        Thread timer = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(1000);//Init

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    ourSong.stop();
//                    Intent menuIntent = new Intent(SplashScreen.this, MenuActivity.class);
                    Intent menuIntent = new Intent(SplashScreen.this, MenuActivityStringArray.class);
                    startActivity(menuIntent);
                    SplashScreen.this.finish();
                }
            }
        };
        timer.start();
    }
}

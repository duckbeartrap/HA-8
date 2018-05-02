package com.example.william.asynchw;

import android.media.MediaPlayer;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MediaPlayer media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        media = MediaPlayer.create(MainActivity.this,R.raw.zhu);
        media.start();

        FragmentTransaction trFrag = getSupportFragmentManager().beginTransaction();
        trFrag.replace(R.id.flPlaceHolder, new Splash());
        trFrag.commit();

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {

                    Thread.sleep(6000);

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }

                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                        FragmentTransaction trFrag = getSupportFragmentManager().beginTransaction();
                        trFrag.replace(R.id.flPlaceHolder, new UnoFragmento());
                        trFrag.commit();

                    }
                });

            }
        }).start();
    }
}

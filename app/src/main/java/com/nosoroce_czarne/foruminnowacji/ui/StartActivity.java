package com.nosoroce_czarne.foruminnowacji.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nosoroce_czarne.foruminnowacji.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        /**
         * Start Event opening and timing
         */
        final Intent intent = new Intent(this, MainActivity.class);

        Thread timer = new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
}


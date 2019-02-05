package com.example.top_and_bot_nav;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

@SuppressLint("SetTextI18n")
public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);


                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    time_duration = 100;
                    startRepeating();
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    stopRepeating();
                    return true;
            }
            return false;
        }
    };


    // https://www.youtube.com/watch?v=hyoeBI3Wg4I
    //https://www.youtube.com/watch?v=InF5tU_hecI
    //how to add icons to the "action bar at the top of app"


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    //private Handler mHandler = new Handler();
    private Handler mHandler = new Handler();
    //==============
    public void startRepeating() {
        if (!isRunning){
        mToastRunnable.run();
        }else{
        Toast.makeText(MainActivity.this, "Timer already running", Toast.LENGTH_SHORT).show();
        }
    }
    public void stopRepeating() {
        mHandler.removeCallbacks(mToastRunnable);
        isRunning = false;
    }

    int ccc = 0;
    int time_duration = 1000;
    boolean isRunning = false;
    private Runnable mToastRunnable = new Runnable() {
        @Override
        public void run(){
            isRunning = true;
            //Toast.makeText(MainActivity.this, "This is a delayed toast", Toast.LENGTH_SHORT).show();
            ccc++;
            mTextMessage.setText("" + ccc);
            mHandler.postDelayed(this, time_duration);
        }
    };

    //=======================Button clicks
    @SuppressLint("SetTextI18n")
    public void buttonOnClick(View view) {
        int the_id = view.getId();
        if (the_id == R.id.button) {
            time_duration = 1000;
            startRepeating();
        }
        if (the_id == R.id.button2) {
            time_duration = 100;
            startRepeating();
        }
        if (the_id == R.id.button3) {
            stopRepeating();
        }
    }
}

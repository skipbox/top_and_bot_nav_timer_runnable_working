package com.example.template_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

@SuppressLint("SetTextI18n")

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //makes the text view scroll
        TextView t1= (TextView) findViewById(R.id.t1);
        t1.setMovementMethod(new ScrollingMovementMethod());


       Button b1 = (Button) findViewById(R.id.b1);
       Button b2 = (Button) findViewById(R.id.b2);
       Button b3 = (Button) findViewById(R.id.b3);
       b1.setText("shared pref");
       b2.setText("my");
       b3.setText("Buttons");

       stopPlaying();
       mp = MediaPlayer.create(getApplicationContext(), R.raw.airplane_ding);mp.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            TextView t1 = (TextView)(findViewById(R.id.t1));
            t1.setText("asdf");
            return true;
        }
        if (id == R.id.top_1) {
            int temp_x = my_frag.count_it();
            TextView t1 = (TextView)(findViewById(R.id.t1));
            t1.setText("my_frag.count_it="+temp_x);
            return true;
        }
        if (id == R.id.top_2) {
            int temp_x = my_frag.count_it_2(5);
            TextView t1 = (TextView)(findViewById(R.id.t1));
            t1.setText("my_frag.count_it_222="+temp_x);

            //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
            MediaPlayer.create(getApplicationContext(), R.raw.door_bell).start();
            //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //=======================Button clicks
    @SuppressLint("SetTextI18n")
    public void buttonOnClick(View view) {
        int the_id = view.getId();
        if (the_id == R.id.b1) {
            Button b1_stop_but = (Button) findViewById(R.id.b1);
            // #FF4500 equal to OrangeRed color
            int my_color = Color.parseColor("#FF4500");
            open_activity();
            // set the button text color
            // setTextColor() method require to pass an int color
            b1_stop_but.setTextColor(Color.RED);
            stopPlaying();
            //b1_stop_but.setText("STOP");
        }
        if (the_id == R.id.b2) {
            Toast.makeText(this, "b1", Toast.LENGTH_SHORT).show();
        }
        if (the_id == R.id.b3) {
            String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
            TextView tv_1= (TextView)findViewById(R.id.t1);
            tv_1.setText("tv_1 = "+mydate + System.getProperty ("line.separator") + tv_1.getText().toString());
            //Toast.makeText(this, "222", Toast.LENGTH_SHORT).show();
        }
        /// bot buts
        if (the_id == R.id.bot_but_1) {
            //Toast.makeText(this, "bot_but_1", Toast.LENGTH_SHORT).show();
            //MediaPlayer.create(getApplicationContext().release());
            //MediaPlayer.create(getApplicationContext(), R.raw.airplane_ding).start();
            //mp.stop();
            stopPlaying();
            mp = MediaPlayer.create(getApplicationContext(), R.raw.airplane_ding);mp.start();
        }
        if (the_id == R.id.bot_but_2) {
            //Toast.makeText(this, "bot_but_1", Toast.LENGTH_SHORT).show();
            stopPlaying();
            mp = MediaPlayer.create(getApplicationContext(), R.raw.explosion);mp.start();
        }
        if (the_id == R.id.bot_but_3) {
            //Toast.makeText(this, "bot_but_1", Toast.LENGTH_SHORT).show();
            stopPlaying();
            mp = MediaPlayer.create(getApplicationContext(), R.raw.fart);mp.start();
        }
    }//end button clicks


private void stopPlaying() { if (mp != null){ mp.stop();mp.release();mp = null;}}

    /** need this to open another activity*/
    public void open_activity() {
        Intent intent = new Intent(this, shared_pref.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
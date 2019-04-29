package com.example.andrewcreaghflynn.carbon_json_test_gitpull;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {


    public static TextView eData;
    public static TextView cData;
    public static TextView trafficLight;
    public static TextView cTotal;
    public static Drawable image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cData = (TextView) findViewById(R.id.cfetchedData);
        trafficLight = (TextView) findViewById(R.id.trafficLight);
        eData = (TextView) findViewById(R.id.environResult);
        cTotal = (TextView) findViewById(R.id.ctotal);

        fetchC02 process = new fetchC02();
        process.execute();


       TimerTask task = new TimerTask() {
            @Override
            public void run() {

                fetchC02 process2 = new fetchC02();
                process2.execute();
            }
        };

        Timer timer = new Timer();
        long delay = 0;
        long intervalPeriod = 1*1000;
        timer.schedule(task, delay, intervalPeriod);

    }

    public void moreDetail(View v){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
    public void login(View v){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void devices(View v){
        Intent intent = new Intent(this, Devices.class);
        startActivity(intent);
    }
}

package com.example.andrewcreaghflynn.carbon_json_test_gitpull;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity2 extends AppCompatActivity {

    public static TextView total;
    public static TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        total = (TextView) findViewById(R.id.total);
        data = (TextView) findViewById(R.id.fetchedData);

        fetchData process = new fetchData();
        process.execute();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                fetchData process = new fetchData();
                process.execute();

            }
        };
        Timer timer = new Timer();
        long delay = 0;
        long intervalPeriod = 1*1000;
        timer.schedule(task, delay, intervalPeriod);
    }
    public void lessDetail(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

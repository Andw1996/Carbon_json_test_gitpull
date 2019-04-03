package com.example.andrewcreaghflynn.carbon_json_test_gitpull;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    public static TextView data;
    public static TextView eData;
    public static TextView cData;
    public static TextView total;
    public static TextView cTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cData = (TextView) findViewById(R.id.cfetchedData);
        data = (TextView) findViewById(R.id.fetchedData);
        eData = (TextView) findViewById(R.id.environResult);
        total = (TextView) findViewById(R.id.total);
        cTotal = (TextView) findViewById(R.id.ctotal);

        fetchData process = new fetchData();
        fetchC02 process2 = new fetchC02();
        process.execute();
        process2.execute();


       TimerTask task = new TimerTask() {
            @Override
            public void run() {
                fetchData process = new fetchData();
                fetchC02 process2 = new fetchC02();

                process.execute();
                process2.execute();
            }
        };

        Timer timer = new Timer();
        long delay = 0;
        long intervalPeriod = 1*1000;
        timer.schedule(task, delay, intervalPeriod);

    }
}

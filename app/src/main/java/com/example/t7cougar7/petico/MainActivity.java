package com.example.t7cougar7.petico;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import com.example.t7cougar7.petico.ProgessBars.ProgressBarUpdate;

import static android.os.SystemClock.sleep;

public class MainActivity extends Activity {

    private int waterProgressLevel = 100;

    private ProgressBar waterProgressBar;

    private final ProgressBarUpdate progressBarUpdate = new ProgressBarUpdate();

    private final Handler mainHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        waterProgressBar = findViewById(R.id.waterProgressBar);
        waterProgressBar.setProgress(0);
        waterProgressBar.setProgress(25, true);
        waterProgressBar.setProgress(75, true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                main();
            }
        }).start();
    }

    public void main() {
        sleep(2000);
        progressBarUpdate.updateProgressBar(waterProgressBar, 50, mainHandler);
        sleep(2000);
        progressBarUpdate.updateProgressBar(waterProgressBar, 10, mainHandler);
        sleep(2000);
    }
}

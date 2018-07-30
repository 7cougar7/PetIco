package com.example.t7cougar7.petico;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.t7cougar7.petico.Controllers.ProgressBarController;
import com.example.t7cougar7.petico.Models.ProgressBarModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.os.SystemClock.sleep;

public class MainActivity extends Activity {

    private final ProgressBarController progressBarController = new ProgressBarController();

    public static final List<ProgressBarModel> ALL_PROGRESS_BARS = new ArrayList<>();

    public ProgressBar healthProgressBar;
    public ProgressBar waterProgressBar;
    public ProgressBar foodProgressBar;
    public ProgressBar exerciseProgressBar;
    public ProgressBar weightProgressBar;

    public TextView healthText;
    public TextView waterText;
    public TextView foodText;
    public TextView exerciseText;
    public TextView weightText;



    private final Handler mainHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        healthProgressBar = findViewById(R.id.healthProgressBar);
        waterProgressBar = findViewById(R.id.waterProgressBar);
        foodProgressBar = findViewById(R.id.foodProgressBar);
        exerciseProgressBar = findViewById(R.id.exerciseProgressBar);
        weightProgressBar = findViewById(R.id.weightProgressBar);

        healthText = findViewById(R.id.healthText);
        waterText = findViewById(R.id.waterText);
        foodText = findViewById(R.id.foodText);
        exerciseText = findViewById(R.id.exerciseText);
        weightText = findViewById(R.id.weightText);

        ALL_PROGRESS_BARS.add(
                new ProgressBarModel(
                        healthProgressBar,"healthProgressBar", 100, 100, "Health: ", healthText
                )
        );
        ALL_PROGRESS_BARS.add(
                new ProgressBarModel(
                        waterProgressBar, "waterProgressBar", 60, 100, "Water: ", waterText
                )
        );
        ALL_PROGRESS_BARS.add(
                new ProgressBarModel(
                        foodProgressBar, "foodProgressBar", 40, 100, "Food: ", foodText
                )
        );
        ALL_PROGRESS_BARS.add(
                new ProgressBarModel(
                        exerciseProgressBar,"exerciseProgressBar", 30, 100, "Exercise: ", exerciseText
                )
        );
        ALL_PROGRESS_BARS.add(
                new ProgressBarModel(
                        weightProgressBar, "weightProgressBar", 40, 80, "Weight: ", weightText
                )
        );
        progressBarController.initProgressBars(mainHandler);

        new Thread(new Runnable() {
            @Override
            public void run() {
                main();
            }
        }).start();
    }

    public void main() {
        for (int i = 0; i < 20; i++) {
            sleep(2000);
            progressBarController.initProgressBars(mainHandler);
        }
    }
}

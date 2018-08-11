package com.example.t7cougar7.petico;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.t7cougar7.petico.Controllers.ProgressBarController;
import com.example.t7cougar7.petico.Controllers.TimeController;
import com.example.t7cougar7.petico.Models.ProgressBarModel;
import com.example.t7cougar7.petico.Utils.MainUtils;

import java.util.HashMap;

import static android.os.SystemClock.sleep;

public class MainActivity extends Activity {

    private final ProgressBarController progressBarController = new ProgressBarController();
    private final TimeController timeController = new TimeController();
    private final MainUtils mainUtils = new MainUtils();

    public static final HashMap<String, ProgressBarModel> ALL_PROGRESS_BARS = new HashMap();

    private MediaPlayer backgroundMusic;

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
    public TextView debugText;

    public Button waterButton;
    public Button foodButton;
    public Button exerciseButton;
    public Button weightButton;

    public static final Handler mainHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.gc();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViewObjects();
        progressBarController.initProgressBars(mainHandler);
        backgroundMusic = MediaPlayer.create(MainActivity.this, R.raw.cats_and_playing_cards);
        backgroundMusic.setLooping(true);

        new Thread(new Runnable() {
            @Override
            public void run() {
                main();
            }
        }).start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        backgroundMusic.release();
    }

    public void main() {
        timeController.startGameClock();
        backgroundMusic.start();
        sleep(3000);
        mainUtils.asyncTask(timeController.changeStatViaTime(75, ALL_PROGRESS_BARS.get("waterProgressBarModel"), -1));
        sleep(7);
        mainUtils.asyncTask(timeController.changeStatViaTime(150, ALL_PROGRESS_BARS.get("foodProgressBarModel"), -1));
        sleep(2);
        mainUtils.asyncTask(timeController.changeStatViaTime(170, ALL_PROGRESS_BARS.get("weightProgressBarModel"), -1));
        sleep(5);
        mainUtils.asyncTask(timeController.changeStatViaTime(35, ALL_PROGRESS_BARS.get("exerciseProgressBarModel"), -1));
        sleep(10);
        mainUtils.asyncTask(timeController.changeHealthViaTime(ALL_PROGRESS_BARS.get("healthProgressBarModel"), -1, debugText, mainHandler));
    }

    private void initializeViewObjects(){
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
        debugText = findViewById(R.id.debuggerView);

        waterButton = findViewById(R.id.waterButton);
        waterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBarController.updateProgressBar(ALL_PROGRESS_BARS.get("waterProgressBarModel"), 10, mainHandler, true);
            }
        });
        foodButton = findViewById(R.id.foodButton);
        foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBarController.updateProgressBar(ALL_PROGRESS_BARS.get("foodProgressBarModel"), 10, mainHandler, true);
            }
        });
        exerciseButton = findViewById(R.id.exerciseButton);
        exerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBarController.updateProgressBar(ALL_PROGRESS_BARS.get("exerciseProgressBarModel"), 10 , mainHandler, true);
            }
        });
        weightButton = findViewById(R.id.weightButton);
        weightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBarController.updateProgressBar(ALL_PROGRESS_BARS.get("weightProgressBarModel"), 10, mainHandler, true);
            }
        });

        ALL_PROGRESS_BARS.put("healthProgressBarModel",
                new ProgressBarModel(
                        healthProgressBar, 100, 100, "Health: ", healthText, 100)
        );
        ALL_PROGRESS_BARS.put("waterProgressBarModel",
                new ProgressBarModel(
                        waterProgressBar, 60, 100, "Water: ", waterText, 75)
        );
        ALL_PROGRESS_BARS.put("foodProgressBarModel",
                new ProgressBarModel(
                        foodProgressBar, 40, 100, "Food: ", foodText, 75)
        );
        ALL_PROGRESS_BARS.put("exerciseProgressBarModel",
                new ProgressBarModel(
                        exerciseProgressBar, 30, 100, "Exercise: ", exerciseText, 75)
        );
        ALL_PROGRESS_BARS.put("weightProgressBarModel",
                new ProgressBarModel(
                        weightProgressBar, 40, 80, "Weight: ", weightText, 75)
        );
    }
}

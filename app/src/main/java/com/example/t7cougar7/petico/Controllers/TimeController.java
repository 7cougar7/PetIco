package com.example.t7cougar7.petico.Controllers;

import com.example.t7cougar7.petico.MainActivity;
import com.example.t7cougar7.petico.Models.ProgressBarModel;

import static android.os.SystemClock.sleep;

public class TimeController {

    private static long MAIN_CLOCK;

    public static final int TICK_LENGTH = 50; //20x per second

    private ProgressBarController progressBarController = new ProgressBarController();

    public void startGameClock() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    sleep(TICK_LENGTH);
                    MAIN_CLOCK++;
                }
            }
        }).start();
    }

    public static long getMainClock() {
        return MAIN_CLOCK;
    }

    public Runnable changeStatViaTime(final int timeInterval,
                                        final ProgressBarModel progressBarModel,
                                        final int changeAmount) {
        return new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (getMainClock() % timeInterval == 0) {
                        progressBarController.updateProgressBar(progressBarModel, changeAmount, MainActivity.mainHandler, true);
                        sleep(TICK_LENGTH+5);
                    }
                }
            }
        };
    }
}

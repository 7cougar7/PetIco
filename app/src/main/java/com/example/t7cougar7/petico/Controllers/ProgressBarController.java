package com.example.t7cougar7.petico.Controllers;

import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.t7cougar7.petico.MainActivity;
import com.example.t7cougar7.petico.Models.ProgressBarModel;

import static android.os.SystemClock.sleep;

public class ProgressBarController {

    private static final int SLEEP_DELAY = 25;

    public boolean initProgressBars(final Handler handler) {
        for (ProgressBarModel progressBarModel : MainActivity.ALL_PROGRESS_BARS) {
            final int randomVal = randomGen(progressBarModel.getInitMax(), progressBarModel.getInitMin());
            updateProgressBar(progressBarModel, randomVal, handler).start();
        }
        return true;
    }
    public Thread updateProgressBar(final ProgressBarModel progressBarModel,
                                    final int progressLevel,
                                    final Handler mainHandler) {
        final ProgressBar progressBar = progressBarModel.getProgressBarViewObject();
        final TextView textView = progressBarModel.getTextViewDisplay();
        final String displaytext = progressBarModel.getDisplaytext();
        return new Thread(new Runnable() {
            @Override
            public void run() {
                int currentLevel = progressBar.getProgress();
                if (currentLevel != progressLevel) {
                    final int levelChange = progressLevel - currentLevel;
                    final int changeDirection = levelChange / Math.abs(levelChange);

                    for (int i = 1; i <= Math.abs(levelChange); i++) {
                        final int newLevel = currentLevel + (changeDirection * i);
                        sleep(SLEEP_DELAY);
                        mainHandler.post(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(newLevel);
                                        textView.setText(displaytext + newLevel + "%");

                                    }
                                });
                        mainHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                textView.setVisibility(textView.VISIBLE);
                            }
                        });
                    }
                }
            }
        });
    }


    public int randomGen(final int max,
                         final int min) {
        int randomVal = (int)(Math.random() * ((max-min)+1))+min;
        return randomVal;
    }
}

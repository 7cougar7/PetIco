package com.example.t7cougar7.petico.Controllers;

import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.t7cougar7.petico.MainActivity;
import com.example.t7cougar7.petico.Models.ProgressBarModel;
import com.example.t7cougar7.petico.Utils.MainUtils;

import static android.os.SystemClock.sleep;

public class ProgressBarController {

    private MainUtils mainUtils = new MainUtils();

    private static final int SLEEP_DELAY = 25;

    public boolean initProgressBars(final Handler handler) {
        for (String progressBarModelId : MainActivity.ALL_PROGRESS_BARS.keySet()) {
            final ProgressBarModel progressBarModel = MainActivity.ALL_PROGRESS_BARS.get(progressBarModelId);
            final int randomVal = MainUtils.randomGen(progressBarModel.getInitMax(), progressBarModel.getInitMin());
            updateProgressBar(progressBarModel, randomVal, handler,false);
        }
        return true;
    }

    public void updateProgressBar(final ProgressBarModel progressBarModel,
                                  final int progressLevel,
                                  final Handler mainHandler,
                                  final boolean relativeLevel) {
        final ProgressBar progressBar = progressBarModel.getProgressBarViewObject();
        final TextView textView = progressBarModel.getTextViewDisplay();
        final String displaytext = progressBarModel.getDisplaytext();
        mainUtils.asyncTask(new Runnable() {
            @Override
            public void run() {
                int currentLevel = progressBar.getProgress();
                if (currentLevel != progressLevel) {
                    int levelChange;
                    if (relativeLevel) {
                        levelChange = progressLevel;
                    } else {
                        levelChange = progressLevel - currentLevel;
                    }
                    final int changeDirection = levelChange / Math.abs(levelChange);
                    for (int i = 0; i < Math.abs(levelChange); i++) {
                        final int newLevel = currentLevel + (changeDirection * (i + 1));
                        sleep(SLEEP_DELAY);
                        mainHandler.post(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(newLevel);
                                        textView.setText(displaytext + newLevel + "%  " + TimeController.getMainClock());
                                    }
                                });
                    }
                }
            }
        });
    }
}

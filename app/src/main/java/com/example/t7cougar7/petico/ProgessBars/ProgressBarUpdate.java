package com.example.t7cougar7.petico.ProgessBars;

import android.os.Handler;
import android.widget.ProgressBar;

import static android.os.SystemClock.sleep;

public class ProgressBarUpdate {

    private static int SLEEP_DELAY = 75;

    public void updateProgressBar(final ProgressBar progressBar,
                                    final int progressLevel,
                                  final Handler mainHandler) {
        int currentLevel = progressBar.getProgress();
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
                        }
                    });
        }
    }

}

package com.example.t7cougar7.petico.Controllers;

import com.example.t7cougar7.petico.Models.ProgressBarModel;

import java.util.Map;

public class HealthController {

    public static int HEALTH_TIME_INTERVAL = 100;

    public int calculateHealthRateMultiplier(final Map<String, ProgressBarModel> allProgressBars) {
        double numerator = 0d;
        for (final String progressBarId : allProgressBars.keySet()) {
            if (progressBarId == "healthProgressBarModel") {
                continue;
            }
            final ProgressBarModel progressBarModel = allProgressBars.get(progressBarId);
            final double additionalValue = (double) 1 / (1 + Math.abs(progressBarModel.getIdealLevel() - progressBarModel.getProgressBarViewObject().getProgress()));
            numerator += additionalValue;
        }
        return (int) ((allProgressBars.keySet().size()-1)/(2.5*numerator));
    }

}

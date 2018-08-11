package com.example.t7cougar7.petico.Models;

import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBarModel {

    private final ProgressBar progressBarViewObject;

    private final int initMin;

    private final int initMax;

    private final String displaytext;

    private final TextView textViewDisplay;

    private final int idealLevel;

    public ProgressBarModel(final ProgressBar progressBarViewObject,
                            final int initMin,
                            final int initMax,
                            final String displayText,
                            final TextView textViewDisplay,
                            final int idealLevel) {
        this.progressBarViewObject = progressBarViewObject;
        this.initMin = initMin;
        this.initMax = initMax;
        this.displaytext = displayText;
        this.textViewDisplay = textViewDisplay;
        this.idealLevel = idealLevel;
    }

    public ProgressBar getProgressBarViewObject() {
        return progressBarViewObject;
    }

    public int getInitMin() {
        return initMin;
    }

    public int getInitMax() {
        return initMax;
    }

    public String getDisplaytext() {
        return displaytext;
    }

    public TextView getTextViewDisplay() {
        return textViewDisplay;
    }

    public int getIdealLevel() {
        return idealLevel;
    }
}

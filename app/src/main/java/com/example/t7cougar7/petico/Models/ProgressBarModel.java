package com.example.t7cougar7.petico.Models;

import android.widget.ProgressBar;
import android.widget.TextView;
import org.w3c.dom.Text;

public class ProgressBarModel {

    private final ProgressBar progressBarViewObject;

    private final String progressBarId;

    private final int initMin;

    private final int initMax;

    private final String displaytext;

    private final TextView textViewDisplay;

    public ProgressBarModel(final ProgressBar progressBarViewObject,
                            final String progressBarId,
                            final int initMin,
                            final int initMax,
                            final String displayText,
                            final TextView textViewDisplay) {
        this.progressBarViewObject = progressBarViewObject;
        this.progressBarId = progressBarId;
        this.initMin = initMin;
        this.initMax = initMax;
        this.displaytext = displayText;
        this.textViewDisplay = textViewDisplay;
    }

    public ProgressBar getProgressBarViewObject() {
        return progressBarViewObject;
    }

    public String getProgressBarId() {
        return progressBarId;
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
}

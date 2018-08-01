package com.example.t7cougar7.petico.Controllers;

import com.example.t7cougar7.petico.MainActivity;
import com.example.t7cougar7.petico.Models.ProgressBarModel;
import com.example.t7cougar7.petico.Utils.MainUtils;

public class WaterController {

    public final MainUtils mainUtils = new MainUtils();

    private ProgressBarModel waterProgressBarModel = MainActivity.ALL_PROGRESS_BARS.get("waterProgressBarModel");

    private ProgressBarController progressBarController = new ProgressBarController();


}

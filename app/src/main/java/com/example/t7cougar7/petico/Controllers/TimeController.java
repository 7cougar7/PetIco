package com.example.t7cougar7.petico.Controllers;

import static android.os.SystemClock.sleep;

public class TimeController {

    public long MAIN_CLOCK = 0l;

    public static final int TICK_LENGTH = 50; //20x per second

    public void startGameClock(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                sleep(TICK_LENGTH);
                MAIN_CLOCK++;
            }
        }).start();
    }

}

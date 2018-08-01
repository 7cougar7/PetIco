package com.example.t7cougar7.petico.Utils;

public class MainUtils {

    public static int randomGen(final int max,
                                final int min) {
        final int randomVal = (int)(Math.random() * ((max-min)+1))+min;
        return randomVal;
    }

    public void asyncTask(final Runnable function) {
        new Thread(function).start();
    }
}

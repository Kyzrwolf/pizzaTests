package ru.cheeseknock.utils;

import java.util.concurrent.TimeUnit;

public class Utils {

    public static void wait(int sec){
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(sec) );
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

package com.scout.musicplayer;

/**
 * Created by liaoyuhuan on 2016/7/21.
 */
public class LOG {
    private static final String TAG = "scout/";

    public static void i(String tag, String msg) {
        android.util.Log.i(TAG + tag, msg);
    }
}

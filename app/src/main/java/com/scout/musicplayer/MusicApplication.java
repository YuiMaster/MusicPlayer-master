package com.scout.musicplayer;

import android.app.Application;

/**
 * Created by liaoyuhuan on 2016/7/25.
 */
public class MusicApplication extends Application {
    private static MusicApplication musicApplication;

    @Override
    public void onCreate() {
        super.onCreate();

        musicApplication = this;
    }

    public static MusicApplication getInstance() {
        return musicApplication;
    }
}

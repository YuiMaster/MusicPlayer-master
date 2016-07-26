package com.scout.musicplayer.utils;

import android.content.Context;
import android.view.WindowManager;

import com.scout.musicplayer.MusicApplication;

/**
 * Created by liaoyuhuan on 2016/7/25.
 */
public class ScreenUtils {

    public static int getScreenWidth() {
        WindowManager wm = (WindowManager) MusicApplication.getInstance().getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getWidth();
    }
}

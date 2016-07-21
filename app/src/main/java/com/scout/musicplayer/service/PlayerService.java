package com.scout.musicplayer.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by liaoyuhuan on 2016/7/20.
 */
public class PlayerService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new PlayerBinder();
    }

    public class PlayerBinder extends Binder {

        PlayerService getService() {
            return PlayerService.this;
        }

    }
}

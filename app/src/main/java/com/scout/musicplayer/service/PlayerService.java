package com.scout.musicplayer.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liaoyuhuan on 2016/7/20.
 * 音乐播放器基本素质
 * 扫描本地音乐  scanNativeMusic
 * 避免播放器内存被系统回收
 * 来电或拔出耳机时暂停播放
 * 捕捉或丢弃音乐焦点
 * 耳机线控
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

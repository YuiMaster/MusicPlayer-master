package com.scout.musicplayer.service;


/**
 * Created by liaoyuhuan on 2016/7/21.
 * 音乐播放器基本素质
 * 扫描本地音乐  scanNativeMusic
 * 避免播放器内存被系统回收
 * 来电或拔出耳机时暂停播放
 * 捕捉或丢弃音乐焦点
 * 耳机线控
 *
 */
public interface IMusicBaseFunctions {
    public void scanLocalMusic();


}

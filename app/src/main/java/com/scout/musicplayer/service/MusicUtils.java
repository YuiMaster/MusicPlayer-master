package com.scout.musicplayer.service;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import com.scout.musicplayer.LOG;

import java.util.List;

/**
 * Created by liaoyuhuan on 2016/7/21.
 */
public class MusicUtils {
    private static final String TAG = "MusicUtils";

    public static boolean scanMusic(Context context, List<MusicInfo> musicList) {

        //open Cursor
        Cursor cursor = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
        if (cursor == null) {
            LOG.i(TAG,"scanMusic cursor == null");
            return false;
        }

        //clear
        musicList.clear();

        //get data from Cursor
        while (cursor.moveToNext()) {
            int isMusic = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.IS_MUSIC));
            if (isMusic == 0) {
                continue;
            }

            final long id = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media._ID));
            final String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
            final String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
            final String album = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
            final long duration = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
            final String uri = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
            final String fileName = cursor.getString((cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME)));
            final long fileSize = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.SIZE));
            final String year = cursor.getString((cursor.getColumnIndex(MediaStore.Audio.Media.YEAR)));

            final long albumId = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID));
            final String coverUri = getCoverUri(context, albumId);

            MusicInfo music = new MusicInfo();
            music.id = id;
            music.title = title;
            music.artist = artist;
            music.album = album;
            music.duration = duration;
            music.uri = uri;
            music.fileName = fileName;
            music.year = year;
            music.coverUri = coverUri;
            musicList.add(music);
            LOG.i(TAG,"scanMusic musicList.add(music)");
        }

        //close Cursor
        cursor.close();
        return true;
    }

    private static String getCoverUri(Context context, long albumId) {
        String uri = null;
        Cursor cursor = context.getContentResolver().query(
                Uri.parse("content://media/external/audio/albums/" + albumId),
                new String[]{"album_art"}, null, null, null);
        if (cursor != null) {
            cursor.moveToNext();
            uri = cursor.getString(0);
            cursor.close();
        }
        return uri;
    }
}

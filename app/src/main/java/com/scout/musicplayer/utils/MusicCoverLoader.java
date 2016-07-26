package com.scout.musicplayer.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.LruCache;

import com.scout.musicplayer.MusicApplication;
import com.scout.musicplayer.R;

/**
 * Created by liaoyuhuan on 2016/7/25.
 * 用时加载的单例模式
 */
public class MusicCoverLoader {
    LruCache<String, Bitmap> mLruCover;

    private MusicCoverLoader() {
        int maxMemory = (int) Runtime.getRuntime().maxMemory() / 1024;
        int cacheSize = maxMemory / 8;

        mLruCover = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getByteCount() / 2014;
            }
        };
    }

    public static MusicCoverLoader getInstance() {
        return MusicCoverLoaderHolder.instance;
    }

    private static class MusicCoverLoaderHolder {
        private static MusicCoverLoader instance = new MusicCoverLoader();
    }

    private static final String KEY_NULL = "key_null";

    public Bitmap loadThumbnail(String url) {
        Bitmap bitmap;
        if (TextUtils.isEmpty(url)) {
            bitmap = mLruCover.get(KEY_NULL);
            if (bitmap == null) {
                bitmap = BitmapFactory.decodeResource(MusicApplication.getInstance().getResources(), R.drawable.default_cover);
                mLruCover.put(KEY_NULL, bitmap);
            }
        } else {
            bitmap = mLruCover.get(url);
            if (bitmap == null) {
                bitmap = createBitmapByUri(url);
                mLruCover.put(KEY_NULL, bitmap);
            }
        }
        return bitmap;
    }

    private Bitmap createBitmapByUri(String url) {
        return BitmapFactory.decodeFile(url);
    }


}

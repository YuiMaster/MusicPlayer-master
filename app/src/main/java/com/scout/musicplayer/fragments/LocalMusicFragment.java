package com.scout.musicplayer.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.scout.musicplayer.adapter.LocalMusicAdapter;
import com.scout.musicplayer.LOG;
import com.scout.musicplayer.MusicActivity;
import com.scout.musicplayer.R;
import com.scout.musicplayer.service.MusicInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liaoyuhuan on 2016/7/21.
 * only support MusicActivity
 */
public class LocalMusicFragment extends BaseFragment {
    private static final String TAG = "LocalMusicFragment";

    private List<MusicInfo> sMusicList = new ArrayList<>();
    private LocalMusicAdapter mAdapter;
    private ListView mListView;

    @Override
    public void onAttach(Context context) {
        LOG.i(TAG, "onAttach ");
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LOG.i(TAG, "onCreateView ");

        return inflater.inflate(R.layout.fragment_localmusic, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        LOG.i(TAG, "onViewCreated mAdapter=" + mAdapter);
        mListView = (ListView) view.findViewById(R.id.listView);
        sMusicList = ((MusicActivity) this.getActivity()).getLocalMusicList();
        mAdapter = new LocalMusicAdapter();
        mAdapter.updateMusicList(sMusicList);
        mListView.setAdapter(mAdapter);
        LOG.i(TAG, "onViewCreated mAdapter=" + mAdapter + sMusicList.toString());
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        LOG.i(TAG, "onActivityCreated " + sMusicList.toString());
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDetach() {
        LOG.i(TAG, "onDetach ");
        sMusicList = null;
        super.onDetach();
    }
}

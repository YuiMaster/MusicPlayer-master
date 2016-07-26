package com.scout.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;

import com.scout.musicplayer.adapter.FragmentAdapter;
import com.scout.musicplayer.activity.ExitActivity;
import com.scout.musicplayer.fragments.LocalMusicFragment;
import com.scout.musicplayer.fragments.NetMusicListFragment;
import com.scout.musicplayer.fragments.PlayFragment;
import com.scout.musicplayer.service.MusicInfo;
import com.scout.musicplayer.service.MusicUtils;

import java.util.ArrayList;
import java.util.List;


public class MusicActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MusicActivity";

    private ViewPager mViewPager;
    private LocalMusicFragment mLocalMusicFragment;
    private PlayFragment mPlayFragment;
    private NetMusicListFragment mNetMusicListFragment;


    private List<MusicInfo> sMusicList = new ArrayList<>();

    public List<MusicInfo> getLocalMusicList() {
        return sMusicList;
    }

    @Override
    protected void initVariable() {
        LOG.i(TAG, "initVariable ");

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        LOG.i(TAG, "initView ");
        setContentView(R.layout.activity_music);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        mLocalMusicFragment = new LocalMusicFragment();
        mNetMusicListFragment = new NetMusicListFragment();
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        adapter.addFragment((Fragment) mLocalMusicFragment);
        adapter.addFragment((Fragment) mNetMusicListFragment);

        mViewPager.setAdapter(adapter);
    }


    @Override
    protected void loadData() {
        LOG.i(TAG, "loadData ");
        scanLocalMusic();
    }

    @Override
    public void onBackPressed() {
        LOG.i(TAG, "onBackPressed ");
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        LOG.i(TAG, "onCreateOptionsMenu ");
        getMenuInflater().inflate(R.menu.music, menu);
        return true;
    }


    //    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        LOG.i(TAG, "onNavigationItemSelected " + id);

        if (id == R.id.nav_settings) {
        } else if (id == R.id.nav_exit) {
            Intent intent = new Intent(this, ExitActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            this.startActivity(intent);
            this.finish();
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    protected void scanLocalMusic() {
        LOG.i(TAG, "scanLocalMusic ");

        MusicUtils.scanMusic(this, sMusicList);
        LOG.i(TAG, "scanLocalMusic " + sMusicList.toString());
    }


    @Override
    protected void onNewIntent(Intent intent) {
        LOG.i(TAG, "onNewIntent ");
        super.onNewIntent(intent);
    }

    @Override
    protected void onRestart() {
        LOG.i(TAG, "onRestart ");
        super.onRestart();
    }

    @Override
    protected void onPause() {
        LOG.i(TAG, "onPause ");
        super.onPause();
    }

    @Override
    protected void onResume() {
        LOG.i(TAG, "onResume ");
        super.onResume();
    }
}

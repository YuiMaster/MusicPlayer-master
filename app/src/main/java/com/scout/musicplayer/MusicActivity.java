package com.scout.musicplayer;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;

import com.scout.musicplayer.Adapter.FragmentAdapter;
import com.scout.musicplayer.fragments.LocalMusicFragment;
import com.scout.musicplayer.fragments.NetMusicListFragment;
import com.scout.musicplayer.fragments.PlayFragment;

/*
* 音乐播放器基本素质
* 扫描本地音乐  scanNativeMusic
* 避免播放器内存被系统回收
* 来电或拔出耳机时暂停播放
* 捕捉或丢弃音乐焦点
* 耳机线控
* */

public class MusicActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager mViewPager;
    private LocalMusicFragment mLocalMusicFragment;
    private PlayFragment mPlayFragment;
    private NetMusicListFragment mNetMusicListFragment;


    @Override
    protected void initVariable() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_music);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);


        mLocalMusicFragment = new LocalMusicFragment();
        mNetMusicListFragment = new NetMusicListFragment();
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        adapter.addFragment((Fragment) mLocalMusicFragment);
        adapter.addFragment((Fragment) mNetMusicListFragment);
//        adapter.addFragment((Fragment) mNetMusicListFragment);

        mViewPager.setAdapter(adapter);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.music, menu);
        return true;
    }


    //    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_exit) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

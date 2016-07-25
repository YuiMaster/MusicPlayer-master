package com.scout.musicplayer.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ExitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this,"exit",Toast.LENGTH_SHORT).show();
        this.finish();
//        setContentView(R.layout.activity_exit);
    }
}

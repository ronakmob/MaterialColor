package com.mob.materialcolor;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.cognito.mobgare.mylibrary.MaterialColorPalette;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    private static final String TAG = "MaterialColor";
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        relativeLayout.setBackgroundColor(MaterialColorPalette.randomColor());
        runnable = new Runnable() {
            @Override
            public void run() {
                relativeLayout.setBackgroundColor(MaterialColorPalette.randomColor());
                relativeLayout.invalidate();
                handler.postDelayed(runnable, 2000);
            }
        };
        handler.postDelayed(runnable, 2000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
}

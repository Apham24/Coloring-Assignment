
/*Created by Augustine Pham
Last Updated 2/7/2022
* */
package com.example.cs301coloring;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SnowmanView snowmanView = findViewById(R.id.snowmanView);
        snowmanView.setBackgroundColor(0xFF023512);
        SnowmanController snowmanController = new SnowmanController(snowmanView,findViewById(R.id.textView4), findViewById(R.id.seekBar),findViewById(R.id.seekBar2),findViewById(R.id.seekBar3));
        snowmanView.setOnTouchListener(snowmanController);
        SeekBar rSeekbar = findViewById(R.id.seekBar);
        SeekBar gSeekbar = findViewById(R.id.seekBar2);
        SeekBar bSeekbar = findViewById(R.id.seekBar3);
        rSeekbar.setOnSeekBarChangeListener(snowmanController);
        gSeekbar.setOnSeekBarChangeListener(snowmanController);
        bSeekbar.setOnSeekBarChangeListener(snowmanController);
    }
}
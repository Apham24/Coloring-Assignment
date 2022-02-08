/*Created by Augustine Pham
Last Updated 2/7/2022
* */
package com.example.cs301coloring;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
/**
 External Citation
 Date: 07 September 2022
 Problem: forgot which interface to implement for a seekbar listener
 Resource:
 https://stackoverflow.com/questions/8956218/android-seekbar-setonseekbarchangelistener
 Solution: I used the example code from this post.
 */
public class SnowmanController implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener{
    SnowmanView snowView;
    private TextView tV;
    private SeekBar s1,s2,s3;

    //controllor constructor
    public SnowmanController(SnowmanView snowView,TextView tv,SeekBar seek1,SeekBar seek2, SeekBar seek3){
        this.snowView = snowView;
        tV = tv;
        s1 = seek1;
        s2 = seek2;
        s3 = seek3;
    }

    // creates on touch listener that resets the selected object and then checks for click location
    // then updating seekbar and text view
    @Override
    public boolean onTouch(View view, MotionEvent e) {
        float y = e.getY();
        float x = e.getX();

        snowView.scarf.selected = false;
        for(hitBox eyes : snowView.eyeList){
            eyes.selected = false;
        }
        for(hitBox snow : snowView.snowList){
            snow.selected = false;
        }
        for(hitBox arm : snowView.armList){
            arm.selected = false;
        }
        for(hitBox hat : snowView.hatList){
            hat.selected = false;
        }
        for(hitBox butt : snowView.buttList){
            butt.selected = false;
        }
        /**
         External Citation
         Date: 07 September 2022
         Problem: forgot how to change textView
         Resource:
         https://stackoverflow.com/questions/13452991/change-textview-text
         Solution: I used the example code from this post.
         */

        if(x>snowView.scarf.left && x<snowView.scarf.right && y>snowView.scarf.top && y<snowView.scarf.bottom){
            snowView.scarf.selected = true;
            s1.setProgress(snowView.scarf.r);
            s2.setProgress(snowView.scarf.g);
            s3.setProgress(snowView.scarf.b);
            tV.setText(snowView.scarf.name);
            snowView.invalidate();
            return true;
        }

        for(hitBox eyes : snowView.eyeList){
            if(x>eyes.left && x<eyes.right && y>eyes.top && y<eyes.bottom){
                eyes.selected = true;
                s1.setProgress(eyes.r);
                s2.setProgress(eyes.g);
                s3.setProgress(eyes.b);
                tV.setText(eyes.name);
                snowView.invalidate();
                return true;
            }
        }
        for(hitBox hat : snowView.hatList){
            if(x>hat.left && x<hat.right && y>hat.top && y<hat.bottom){
                hat.selected = true;
                s1.setProgress(hat.r);
                s2.setProgress(hat.g);
                s3.setProgress(hat.b);
                tV.setText(hat.name);
                snowView.invalidate();
                return true;
            }
        }
        for(hitBox butt : snowView.buttList){
            if(x>butt.left && x<butt.right && y>butt.top && y<butt.bottom){
                butt.selected = true;
                s1.setProgress(butt.r);
                s2.setProgress(butt.g);
                s3.setProgress(butt.b);
                tV.setText(butt.name);
                snowView.invalidate();
                return true;
            }
        }
        for(hitBox arm : snowView.armList){
            if(x>arm.left && x<arm.right && y>arm.top && y<arm.bottom){
                arm.selected = true;
                s1.setProgress(arm.r);
                s2.setProgress(arm.g);
                s3.setProgress(arm.b);
                tV.setText(arm.name);
                snowView.invalidate();
                return true;
            }
        }
        for(hitBox snow : snowView.snowList){
            if(x>snow.left && x<snow.right && y>snow.top && y<snow.bottom){
                snow.selected = true;
                s1.setProgress(snow.r);
                s2.setProgress(snow.g);
                s3.setProgress(snow.b);
                tV.setText(snow.name);
                tV.setText(snow.name);
                snowView.invalidate();
                return true;
            }
        }

        return true;
    }

// checks which seekbar is selected and changes the obj rgb value accordingly
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
    if(R.id.seekBar == seekBar.getId() && b){
        check().r = i;
        snowView.invalidate();
    }
        if(R.id.seekBar2 == seekBar.getId() && b){
            check().g = i;
            snowView.invalidate();
        }
        if(R.id.seekBar3 == seekBar.getId() && b){
            check().b = i;
            snowView.invalidate();
        }
    }

//helper method to go through and check which obj is currently selected
    private hitBox check(){
        if(snowView.scarf.selected) {
            return snowView.scarf;
        }
        for(hitBox eyes : snowView.eyeList){
            if(eyes.selected) {
                return eyes;
            }
        }
        for(hitBox snow : snowView.snowList){
            if(snow.selected) {
                return snow;
            }
        }
        for(hitBox arm : snowView.armList){
            if(arm.selected) {
                return arm;
            }
        }
        for(hitBox hat : snowView.hatList){
            if(hat.selected) {
                return hat;
            }
        }
        for(hitBox butt : snowView.buttList){
            if(butt.selected) {
                return butt;
            }
        }
        return null;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}

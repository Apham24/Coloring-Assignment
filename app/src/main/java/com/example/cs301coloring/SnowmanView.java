/*Created by Augustine Pham
Last Updated 2/7/2022
* */
package com.example.cs301coloring;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.ArrayList;

public class SnowmanView extends SurfaceView {
    hitBox snow,snow1,snow2,arm,arm1,butt,butt1,butt2,hatTop,hatBot,scarf,eye,eye1;
    ArrayList<hitBox> eyeList,hatList,buttList,armList,snowList;
//initializes objects to be drawn on the view with names and paint objects
    public SnowmanView(Context context, AttributeSet attrs) {
        super(context,attrs);
        setWillNotDraw(false);
        Paint snowPaint = new Paint();
        snow = new hitBox(255,255,255,400.0f,600.0f,400.0f,600.0f,"snow",snowPaint);
        snow1 = new hitBox(255,255,255,300.0f,700.0f,600.0f,1000.0f,"snow",snowPaint);
        snow2 = new hitBox(255,255,255,200.0f,800.0f,1000.0f,1600.0f,"snow",snowPaint);
        Paint armPaint = new Paint();
        arm = new hitBox(150,75,0,250.0f,300.0f,600.0f,1000.0f,"arm",armPaint);
        arm1 = new hitBox(150,75,0,700.0f,750.0f,600.0f,1000.0f,"arm",armPaint);
        Paint buttPaint = new Paint();
        butt = new hitBox(0,0,0,475.0f,525.0f,600.0f,650.0f,"button",buttPaint);
        butt1 = new hitBox(0,0,0,475.0f,525.0f,800.0f,850.0f,"button",buttPaint);
        butt2 = new hitBox(0,0,0,475.0f,525.0f,1000.0f,1050.0f,"button",buttPaint);
        Paint hatPaint = new Paint();
        hatTop = new hitBox(0,0,0,300.0f,700.0f,350.0f,400.0f,"hat",hatPaint);
        hatBot = new hitBox(0,0,0,400.0f,600.0f,200.0f,350.0f,"hat",hatPaint);
        Paint scarfPaint = new Paint();
        scarf = new hitBox(255,0,0,300.0f,700.0f,550.0f,600.0f,"scarf",scarfPaint);
        Paint eyePaint = new Paint();
        eye = new hitBox(0,0,0,450.0f,475.0f,425.0f,450.0f,"eyes",eyePaint);
        eye1 = new hitBox(0,0,0,525.0f,550.0f,425.0f,450.0f,"eyes",eyePaint);
        // stores the common objects in the view for later use
        eyeList= new ArrayList<>();
        eyeList.add(eye);
        eyeList.add(eye1);
        hatList= new ArrayList<>();
        hatList.add(hatTop);
        hatList.add(hatBot);
        buttList= new ArrayList<>();
        buttList.add(butt);
        buttList.add(butt1);
        buttList.add(butt2);
        armList= new ArrayList<>();
        armList.add(arm);
        armList.add(arm1);
        snowList= new ArrayList<>();
        snowList.add(snow);
        snowList.add(snow1);
        snowList.add(snow2);
        //sets paint color and style for basic drawing
        snow.paint.setColor(0xFFFFFFFF);
        snow.paint.setStyle(Paint.Style.FILL);
        arm.paint.setColor(0xFF964B00);
        arm.paint.setStyle(Paint.Style.FILL);
        butt.paint.setColor(0xFF000000);
        butt.paint.setStyle(Paint.Style.FILL);
        hatTop.paint.setColor(0xFF000000);
        hatTop.paint.setStyle(Paint.Style.FILL);
        scarf.paint.setColor(0xFFFF0000);
        scarf.paint.setStyle(Paint.Style.FILL);
        eye.paint.setColor(0xFF000000);
        eye.paint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void onDraw(Canvas canvas){
        // checks to see which obj is selected before updating the objects rgb values
        for(hitBox snow : snowList) {
            if (snow.selected) {
                snow.paint.setARGB(255, snow.r, snow.g, snow.b);
            }
        }
        for(hitBox arm:armList) {
            if (arm.selected) {
                arm.paint.setARGB(255, arm.r, arm.g, arm.b);
            }
        }
        for(hitBox butt:buttList) {
            if (butt.selected) {
                butt.paint.setARGB(255, butt.r, butt.g, butt.b);
            }
        }
        for(hitBox hat:hatList) {
            if (hat.selected) {
                hat.paint.setARGB(255, hat.r, hat.g, hat.b);
            }
        }
        for(hitBox eyes:eyeList) {
            if (eyes.selected) {
                eyes.paint.setARGB(255, eyes.r, eyes.g, eyes.b);
            }
        }
        if(scarf.selected){
            scarf.paint.setARGB(255,scarf.r,scarf.g,scarf.b);
        }
        //redraws the object with updated rgb values

        for(hitBox snow:snowList){
            canvas.drawRect(snow.left,snow.top,snow.right,snow.bottom, snow.paint);
        }
        for(hitBox arm:armList) {
            canvas.drawRect(arm.left, arm.top, arm.right, arm.bottom, arm.paint);
        }
        for(hitBox butt:buttList) {
            canvas.drawRect(butt.left, butt.top, butt.right, butt.bottom, butt.paint);
        }
        for(hitBox hat:hatList){
            canvas.drawRect(hat.left,hat.top,hat.right,hat.bottom, hat.paint);
        }

        canvas.drawRect(scarf.left,scarf.top,scarf.right,scarf.bottom, scarf.paint);
        for(hitBox eye:eyeList) {
            canvas.drawRect(eye.left, eye.top, eye.right, eye.bottom, eye.paint);
        }
    }

}

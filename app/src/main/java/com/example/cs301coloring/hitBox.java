/*Created by Augustine Pham
Last Updated 2/7/2022
* */
package com.example.cs301coloring;

import android.graphics.Paint;
//sets values for different hitboxes
public class hitBox {
    int r,g,b;
    float left, right, top,bottom;
    String name;
    Paint paint;
    boolean selected = false;
    //hitbox constructor
    public hitBox(int r, int g, int b, float left, float right, float top, float bot, String name, Paint paint){
        this.r = r;
        this.g = g;
        this.b = b;
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bot;
        this.name = name;
        this.paint = paint;
    }
}

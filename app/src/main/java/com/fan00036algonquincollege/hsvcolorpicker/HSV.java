package com.fan00036algonquincollege.hsvcolorpicker;

import android.graphics.Color;

/**
 * Created by helen on 2015-10-22.
 */
public class HSV {
    private float H;
    private float S;
    private float V;


    public HSV() {
        this(0,0,0);
    }
    public HSV(float h,float s,float v) {
        H=h;
        S=s;
        V=v;
    }

    public void setHSV(int color)
    {
        float [] hsvComponent=new float[3];

        Color.colorToHSV(color, hsvComponent);
        H=hsvComponent[0];
        S=hsvComponent[1];
        V=hsvComponent[2];
    }
    @Override
    public String toString()
    {
        return "H: "+ (int)H +"\u00B0"+" "+"S: "+ (int)(S*100) +"%"+" "+"V: "+ (int)(V*100) +"%";
    }

    public float getH() {
        return H;
    }

    public void setH(float h) {
        H = h;
    }
    public int getColor()
    {
        return Color.HSVToColor(new float[]{H,S,V});
    }

    public float getS() {
        return S*100;
    }

    public void setS(float s) {
        S = s/100;
    }

    public float getV() {
        return V*100;
    }

    public void setV(float v) {
        V = v/100;
    }
}

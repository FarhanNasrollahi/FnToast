package com.example.fntoast;

import android.content.Context;
import android.util.DisplayMetrics;

public class DisplaySizes {

    public static int width;
    public static int height;

    public static float convertPixelsToDp(int px , Context context){
        return px / ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }


    public static int getWidth(Context context) {
        return (int)convertPixelsToDp(width,context);
    }

    public static int getHeight(Context context) {
        return (int)convertPixelsToDp(height,context);
    }



}

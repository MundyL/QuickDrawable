package com.lm.library;

import android.content.Context;

public class Convert {


    //dp转px
    public static int dpToPx(Context context, int dp){
        float ds = context.getResources().getDisplayMetrics().density;
        return (int) (dp * ds + 0.5f);
    }

}

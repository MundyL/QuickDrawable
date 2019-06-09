package com.lm.quickdrawable;

import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings;

public class Convert {


    //dp转px
    public static int dpToPx(int dp){
        float ds =Resources.getSystem().getDisplayMetrics().density;
        return (int) (dp * ds + 0.5f);
    }

}

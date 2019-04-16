package com.lm.quickdrawable;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.content.ContextCompat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.graphics.drawable.GradientDrawable.RECTANGLE;

public class QuickDrawable {


    private Context mContext;



    //默认矩形
    private int shape = RECTANGLE;

    //边框宽度，默认0
    private int borderWidth=0;
    //边框颜色
    private int borderColor= Color.GRAY;
    //背景颜色
    private int backgroundColor=Color.WHITE;


    //圆角半径
    private float topRightRadius=5;
    private float topLeftRadius=5;
    private float bottomRightRadius=5;
    private float bottomLeftRadius=5;


    //虚线宽度
    private int dashWidth=0;

    //虚线间隔
    private float dashGap = 0;



    //存放stateSet
    Map<Integer,Drawable> stateMap=new HashMap<>();


    public QuickDrawable(Context context){
        this.mContext=context;

    }

    //初始化基础属性
    private void iniParms(){
        borderWidth=0;
        borderColor= Color.GRAY;
        backgroundColor=Color.WHITE;
        topRightRadius=5;
        topLeftRadius=5;
        bottomRightRadius=5;
        bottomLeftRadius=5;
    }

    private Drawable createDrawable(){
        GradientDrawable drawable=new GradientDrawable();
        drawable.setShape(shape);
        drawable.setStroke(borderWidth,borderColor,dashWidth,dashGap);
        drawable.setColor(backgroundColor);
        drawable.setCornerRadii(new float[]{topLeftRadius,topLeftRadius,topRightRadius,topRightRadius,bottomRightRadius,bottomRightRadius,bottomLeftRadius,bottomLeftRadius});
        return drawable;
    }

    public Drawable build(){
        if(stateMap.size()>0){
            StateListDrawable stateListDrawable=new StateListDrawable();
            for (Map.Entry<Integer,Drawable> entry:stateMap.entrySet()){
                stateListDrawable.addState(new int[]{entry.getKey()},entry.getValue());
            }
            return stateListDrawable;
        }else {
            return createDrawable();
        }
    }


    public QuickDrawable border(){
        borderWidth=Convert.dpToPx(mContext,1);;
        return this;
    }
    public QuickDrawable border(int width){
        this.borderWidth=Convert.dpToPx(mContext,width);
        return this;
    }
    public QuickDrawable borderColor(int color){
        this.borderColor=color;
        return this;
    }

    public QuickDrawable corner(){

        return this;
    }
    public QuickDrawable corner(int radius){
        corner(radius,radius,radius,radius);
        return this;
    }
    public QuickDrawable corner(int topLeft,int topRight,int bottomLeft,int bottomRight){
        this.topLeftRadius=Convert.dpToPx(mContext,topLeft);
        this.topRightRadius=Convert.dpToPx(mContext,topRight);
        this.bottomLeftRadius=Convert.dpToPx(mContext,bottomLeft);
        this.bottomRightRadius=Convert.dpToPx(mContext,bottomRight);
        return this;
    }

    public QuickDrawable color(int color){
        this.backgroundColor=color;
        return this;
    }

    public QuickDrawable setPressed(){
        return this;
    }

    /**
     *设置state_pressed的效果
     * @param backgroundColor 背景颜色
     * @param b 对应state_xxx 的布尔值属性
     * @return
     */
    public QuickDrawable addPressed(int backgroundColor,boolean b){
        putStateColor(b?android.R.attr.state_pressed:-android.R.attr.state_pressed,backgroundColor);
        return this;
    }
    public QuickDrawable addPressedDrawable(Drawable drawable,boolean b){
        stateMap.put(b?android.R.attr.state_pressed:-android.R.attr.state_pressed,drawable);
        return this;
    }
    public QuickDrawable addPressResource(int resid,boolean b){
        stateMap.put(b?android.R.attr.state_pressed:-android.R.attr.state_pressed, ContextCompat.getDrawable(mContext,resid));
        return this;
    }

    /**
     * 将之前的操作添加到state_pressed的drawable
     * @param b
     * @return
     */
    public QuickDrawable addToPressed(boolean b){
        Drawable drawable=createDrawable();
        iniParms();
        stateMap.put(b?android.R.attr.state_pressed:-android.R.attr.state_pressed,drawable);
        return this;
    }


    /**
     *
     * @param backgroundColor 背景颜色
     * @param b 对应state_xxx 的布尔值属性
     * @return
     */
    public QuickDrawable addEnable(int backgroundColor,boolean b){
        putStateColor(b?android.R.attr.state_enabled:-android.R.attr.state_enabled,backgroundColor);
        return this;
    }
    public QuickDrawable addEnableDrawable(Drawable drawable,boolean b){
        stateMap.put(b?android.R.attr.state_enabled:-android.R.attr.state_enabled,drawable);
        return this;
    }
    public QuickDrawable addEnableResource(int resid,boolean b){
        stateMap.put(b?android.R.attr.state_enabled:-android.R.attr.state_enabled, ContextCompat.getDrawable(mContext,resid));
        return this;
    }
    public QuickDrawable addToEnable(boolean b){
        Drawable drawable=createDrawable();
        iniParms();
        stateMap.put(b?android.R.attr.state_enabled:-android.R.attr.state_enabled,drawable);
        return this;
    }


    /**
     *
     * @param backgroundColor 背景颜色
     * @param b 对应state_xxx 的布尔值属性
     * @return
     */
    public QuickDrawable addChecked(int backgroundColor,boolean b){
        putStateColor(b?android.R.attr.state_checked:-android.R.attr.state_checked,backgroundColor);
        return this;
    }
    public QuickDrawable addCheckedDrawable(Drawable drawable,boolean b){
        stateMap.put(b?android.R.attr.state_checked:-android.R.attr.state_checked,drawable);
        return this;
    }

    public QuickDrawable addCheckedResource(int resid,boolean b){
        stateMap.put(b?android.R.attr.state_checked:-android.R.attr.state_checked, ContextCompat.getDrawable(mContext,resid));
        return this;
    }

    public QuickDrawable addToChecked(boolean b){
        Drawable drawable=createDrawable();
        iniParms();
        stateMap.put(b?android.R.attr.state_checked:-android.R.attr.state_checked,drawable);
        return this;
    }


    private void putStateColor(int state,int color){
        ColorDrawable colorDrawable=new ColorDrawable();
        colorDrawable.setColor(color);
        stateMap.put(state,colorDrawable);
    }



}

package com.lm.quickdrawabledemo;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import com.lm.quickdrawable.QuickDrawable;

public class MainActivity extends AppCompatActivity {



    Button btn1,btn2,btn3;
    RadioButton rbLeft,rbRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);

        rbLeft=findViewById(R.id.rb_left);
        rbRight=findViewById(R.id.rb_rigth);

        QuickDrawable quickDrawable=new QuickDrawable();

        quickDrawable
                .color(Color.RED)//设置背景色
               // .color(Color.parseColor("#f34563")) 也可以这样设置颜色
                //.color(ContextCompat.getColor(this,R.color.colorPrimary)) 也可以这样设置颜色
                .corner(10)//设置圆角,所有此类值的单位都是dp
                .into(btn1);


        quickDrawable
                .corner(10,10,0,0)//单独设置4个圆角
                .borderColor(Color.parseColor("#f34563"))//设置边框颜色.
                .into(btn2);

        quickDrawable.corner()
                .color(Color.RED)
                .addToPressed(true)
                .color(Color.CYAN)
                .addToPressed(false)
                .textColor(Color.BLUE,Color.YELLOW)
                .into(btn3);

        //标签切换效果
        quickDrawable
                .corner(20,0,20,0)
                .color(Color.RED)
                .addToChecked(true)
                .borderColor(Color.RED)
                .corner(20,0,20,0)
                .addToChecked(false)
                 .textColor(Color.RED,Color.WHITE)
                .into(rbLeft);
        quickDrawable
                .corner(0,20,0,20)
                .color(Color.RED)
                .addToChecked(true)
                .borderColor(Color.RED)
                .corner(0,20,0,20)
                .addToChecked(false)
                .textColor(Color.RED,Color.WHITE)
                .into(rbRight);




        //按钮按下效果

    }
}

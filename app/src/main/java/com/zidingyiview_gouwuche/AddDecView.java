package com.zidingyiview_gouwuche;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 类描述：
 * 创建人：xuyaxi
 * 创建时间：2017/7/11 15:16
 */
public class AddDecView extends LinearLayout implements View.OnClickListener {

    private TextView txtjian;
    private TextView txtjia;
    private EditText ed_txt;

    private int count = 0;
    private int defaultColor = Color.parseColor("#FF0000");
    private int max = 0;

    public AddDecView(Context context) {
        this(context, null);
    }

    public AddDecView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AddDecView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //通过这条语句把我们自定义的属性引入进来
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AddDecView, defStyleAttr, 0);
        //自定义属性的名字 stylable的名字_attrs属性名字
        int bgcolor = a.getColor(R.styleable.AddDecView_textBackGround, defaultColor);
        max = a.getInt(R.styleable.AddDecView_max, 0);
        String addText = a.getString(R.styleable.AddDecView_addText);
        String decText = a.getString(R.styleable.AddDecView_decText);



        //第三个参数试this,代表给当前view设置视图
        View view = View.inflate(context, R.layout.view_add, this);
        txtjian = (TextView) view.findViewById(R.id.txt_jian);
        txtjia = (TextView) view.findViewById(R.id.txt_jia);
        ed_txt = (EditText) findViewById(R.id.ed_txt);

        txtjian.setText(TextUtils.isEmpty(addText)?"_":addText);
        txtjia.setText(TextUtils.isEmpty(addText)?"+":decText);


        ed_txt.setText(count + "");

        txtjia.setOnClickListener(this);
        txtjian.setOnClickListener(this);

        txtjia.setBackgroundColor(bgcolor);
        txtjian.setBackgroundColor(bgcolor);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
        ed_txt.setText(count + "");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_jia:
                if (count < max) {
                    count++;
                    ed_txt.setText(count + "");
                }
                break;
            case R.id.txt_jian:
                if (count > 0) {
                    count--;
                }
                ed_txt.setText(count + "");
                break;
        }
    }
}

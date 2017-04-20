package com.hoho.supertextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hoho.supertextview.util.DensityUtils;

import supertextview.hoho.com.library.R;


/**
 * Created by SB on 2017/4/10.
 */

public class SuperTextView extends LinearLayout {
    private int mIconStart;
    private int mIconEnd;
    private int mIconTop;
    private int mIconBottom;
    private float mTextSizeTitle;
    private float mTextSizeSub;
    private float mIconSize;
    private float mIconPadding;
    private int mTextColor;
    private int mTextColorSub;
    private String mTextTitle;
    private String mTextSub;
    private Context mContext;
    ImageView imgStart;
    TextView tvTitle;
    TextView tvSubline;
    ImageView imgEnd;
    ImageView imgTop;
    ImageView imgBottom;
    LinearLayout linContent;

    public SuperTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.super_textview, this);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SuperTextView, 0, 0);
        try {
            mTextTitle = typedArray.getString(R.styleable.SuperTextView_textTitle);
            mTextSub = typedArray.getString(R.styleable.SuperTextView_textSub);
            mIconSize = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_iconSize, 0);
            mTextSizeTitle = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_textSize, 0);
            mTextSizeSub = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_textSizeSub, 0);
            mIconStart = typedArray.getResourceId(R.styleable.SuperTextView_iconStart, 0);
            mIconEnd = typedArray.getResourceId(R.styleable.SuperTextView_iconEnd, 0);
            mIconTop = typedArray.getResourceId(R.styleable.SuperTextView_iconTop, 0);
            mIconBottom = typedArray.getResourceId(R.styleable.SuperTextView_iconBottom, 0);
            mIconPadding = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_iconPadding, 0);
            mTextColor = typedArray.getColor(R.styleable.SuperTextView_textColor, 0xff333333);
            mTextColorSub = typedArray.getColor(R.styleable.SuperTextView_textColorSub, 0xff666666);
        } catch (Exception e) {

        } finally {
            typedArray.recycle();
        }
        init();
    }

    private void init() {
        imgStart = (ImageView) findViewById(R.id.img_start);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvSubline = (TextView) findViewById(R.id.tv_subline);
        imgEnd = (ImageView) findViewById(R.id.img_end);
        imgTop = (ImageView) findViewById(R.id.img_top);
        imgBottom = (ImageView) findViewById(R.id.img_bottom);
        linContent = (LinearLayout) findViewById(R.id.lin_content);
        tvTitle.setTextColor(mTextColor);
        tvSubline.setTextColor(mTextColorSub);
        linContent.setPadding(DensityUtils.dp2px(mContext, mIconPadding), 0, DensityUtils.dp2px(mContext, mIconPadding), 0);
        if (!TextUtils.isEmpty(mTextTitle)) {
            tvTitle.setText(mTextTitle);
        }
        if (!TextUtils.isEmpty(mTextSub)) {
            tvSubline.setText(mTextSub);
        }
        if (mIconStart != 0) {
            imgStart.setImageResource(mIconStart);
            setImgLayout(imgStart);
        }
        if (mIconEnd != 0) {
            imgEnd.setImageResource(mIconEnd);
            setImgLayout(imgEnd);
        }
        if (mIconTop != 0) {
            imgTop.setImageResource(mIconTop);
            setImgLayout(imgTop);
            LinearLayout.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            tvTitle.setLayoutParams(params);
            tvSubline.setLayoutParams(params);
        }
        if (mIconBottom != 0) {
            imgBottom.setImageResource(mIconBottom);
            setImgLayout(imgBottom);
            LinearLayout.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            tvTitle.setLayoutParams(params);
            tvSubline.setLayoutParams(params);
        }
        if (mTextSizeTitle != 0) {
            tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSizeTitle);
        }
        if (mTextSizeSub != 0) {
            tvSubline.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSizeSub);
        }


        invalidate();
    }

    private void setImgLayout(ImageView imageView) {
        if (mIconSize != 0) {
            LayoutParams layoutParams = new LayoutParams(DensityUtils.dp2px(mContext, mIconSize), DensityUtils.dp2px(mContext, mIconSize));
            imageView.setLayoutParams(layoutParams);
        }
    }

    public void setTitle(String text) {
        tvTitle.setText(text);
        invalidate();
    }

    public void setTvSubline(String text) {
        tvSubline.setText(text);
        invalidate();
    }

    public void setIconStart(int iconRes) {
        imgStart.setImageResource(iconRes);
        invalidate();
    }

    public void setIconEnd(int iconRes) {
        imgEnd.setImageResource(iconRes);
        invalidate();
    }
}
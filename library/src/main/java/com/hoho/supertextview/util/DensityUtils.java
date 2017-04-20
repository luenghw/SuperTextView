package com.hoho.supertextview.util;

/**
 * Created by SB on 2017/4/10.
 */

import android.content.Context;
import android.util.TypedValue;


/**
 * Created by luenghw on 2016/7/6.
 */
public class DensityUtils {
    private DensityUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * dp转px
     */
    public static int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal,
                context.getResources().getDisplayMetrics());
    }

    /**
     * sp转px
     */
    public static int sp2px(Context context, float spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spVal,
                context.getResources().getDisplayMetrics());
    }

    /**
     * px转dp
     */
    public static float px2dp(Context context, float pxVal) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (pxVal / scale);
    }

    /**
     * px转sp
     */
    public static float px2sp(Context context, float pxVal) {
        return (pxVal / context.getResources().getDisplayMetrics().scaledDensity);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static float px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return ((pxValue / scale + 0.5f) + 3) / 320 * 240;
    }

    public static String getDensityList(Context context) {
        StringBuilder densityList = new StringBuilder();
        for (int i = 201; i <= 600; i++) {

            densityList.append(
                    " <dimen name=\"dimen" + i + "px\">" + px2dip(context, i) + "dp" + "</dimen>\n");
        }
        return densityList.toString();
    }
}
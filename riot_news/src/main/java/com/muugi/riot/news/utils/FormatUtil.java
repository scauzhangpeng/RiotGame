package com.muugi.riot.news.utils;

import java.util.Locale;

/**
 * Created by ZP on 2017/8/19.
 */

public class FormatUtil {

    public static String unitToTenThousand(String src) {
        Long srcLong = Long.valueOf(src);
        if (srcLong < 10000) {
            return src + "阅";
        }
        return String.format(Locale.US, "%.1f", srcLong / 10000.0f) + "万阅";
    }

    public static String formatVideoPv(String src) {
        Long srcLong = Long.valueOf(src);
        if (srcLong < 10000) {
            return src + "播放";
        }
        return String.format(Locale.CHINA, "%.1f", srcLong / 10000.0f) + "万播放";
    }
}

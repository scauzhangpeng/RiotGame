package com.xyz.basiclib.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    /*
     日期格式
      */
    public static String DATE_FORMAT_SEC_NUMBER = "yyyyMMddHHmmss";
    public static String DATE_FORMAT_DAY_NUMBER = "yyyyMMdd";
    public static String DATE_FORMAT_MONTH_NUMBER = "yyyyMM";
    public static String DATE_FORMAT_SEC = "yyyy-MM-dd HH:mm:ss";
    public static String DATE_FORMAT_DAY = "yyyy-MM-dd";
    public static String DATE_FORMAT_MONTH = "yyyy-MM";
    public static String DATE_FORMAT_DAY_ZH_CN = "yyyy年MM月dd日";
    public static String DATE_FORMAT_MONTH_ZH_CN = "yyyy年MM月";
    public static String DATE_FORMAT_DYA_MONTH = "MM月dd日";
    public static String DATE_FORMAT_YEAR = "yyyy年";
    public static String DATE_FORMAT_HOUR_MIN = "HH:dd";
    public static String DATE_FORMAT_MONTH_DAY = "MM-dd";


    /**
     * 字符串转日期，字符串的格式如:"yyyy-MM-dd HH:mm:ss"
     *
     * @param dateStr
     * @param format
     * @return
     * @Title:strToDate
     * @author yudapei
     */
    public static Date strToDate(String dateStr, String format) {
        Date date = null;
        SimpleDateFormat sdfSecond = new SimpleDateFormat(format);
        try {
            date = sdfSecond.parse(dateStr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 时间转字符串, 如"yyyy-MM-dd HH:mm:ss"
     *
     * @param datetime
     * @param format
     * @return
     * @Title:dateToStr
     * @author yudapei
     */
    public static String dateToStr(Date datetime, String format) {
        return new SimpleDateFormat(format, Locale.CHINA).format(datetime);
    }

    /**
     * 日期转换到秒格式的字符串,"yyyy-MM-dd HH:mm:ss"
     *
     * @param date
     * @return
     * @Title:dateToSec
     * @author yudapei
     */
    public static String dateToSec(Date date) {
        if (date == null)
            return "";
        return dateToStr(date, DATE_FORMAT_SEC);
    }

    /**
     * 日期到秒，字符串转时间，字符串格式为"yyyy-MM-dd HH:mm:ss"
     *
     * @param dateStr
     * @return
     * @Title:strToDate
     * @author yudapei
     */
    public static Date secToDate(String dateStr) {
        Date date = null;
        SimpleDateFormat sdfSecond = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = sdfSecond.parse(dateStr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 日期转换到天格式的字符串,"yyyy-MM-dd" TODO(这里用一句话描述这个方法的作用)
     *
     * @param date
     * @return
     * @Title:dateToDay
     * @author yudapei
     */
    public static String dateToDay(Date date) {
        return dateToStr(date, DATE_FORMAT_DAY);
    }

    /**
     * 日期转换到天格式的字符串,"yyyy-MM-dd" TODO(这里用一句话描述这个方法的作用)
     *
     * @param date
     * @return
     * @Title:dateToDay
     * @author yudapei
     */
    public static String dateToMonth(Date date) {
        return dateToStr(date, DATE_FORMAT_MONTH);
    }


    /**
     * 日期转换到天格式的字符串,"yyyyMMdd" TODO(这里用一句话描述这个方法的作用)
     *
     * @param date
     * @return
     * @Title:dateToDay
     * @author yudapei
     */
    public static String dateToDay2(Date date) {
        return dateToStr(date, DATE_FORMAT_DAY_NUMBER);
    }

    /**
     * 日期转换到天格式的字符串,"yyyy年MM月dd日" TODO(这里用一句话描述这个方法的作用)
     *
     * @param date
     * @return
     * @Title:dateToDay
     * @author yudapei
     */
    public static String dateToDayZh(Date date) {
        return dateToStr(date, DATE_FORMAT_DAY_ZH_CN);
    }

    /**
     * 日期转换到分格式的字符串,"yyyy-MM-dd HH:mm" TODO(这里用一句话描述这个方法的作用)
     *
     * @param date
     * @return
     * @Title:dateToMin
     * @author yudapei
     */
    public static String dateToMin(Date date) {
        return dateToStr(date, "yyyy-MM-dd HH:mm");
    }

    /**
     * 目标日期是否在离现在的n天里
     *
     * @param date
     * @param daysDuration
     * @return
     * @Title:isMatchDateInDays
     * @author yudapei
     */
    public static boolean isMatchDateInDays(Date date, int daysDuration) {
        boolean result = true;
        Date nowDate = new Date();
        int diffDays = nowDate.getDate() - date.getDate();
        if (diffDays > daysDuration) {
            result = false;
        }
        return result;
    }

    /**
     * 日期格式转换（从字符串格式转成另外一种字符串格式）
     *
     * @param dateStr    时间字符串
     * @param fromFormat 初始时间格式
     * @param toFormat   目标时间格式
     * @return
     */
    public static String strToStr(String dateStr, String fromFormat, String toFormat) {
        Date date = strToDate(dateStr, fromFormat);
        String toDateStr = dateToStr(date, toFormat);
        return toDateStr;
    }

    /**
     * 判断输入的两个时间是否后者早于前者，日期格式：yyyy-mm-dd
     *
     * @return
     */
    public static Boolean isEarlyOrNot(String beginTime, String endTime) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date bt = sdf.parse(beginTime);
            Date et = sdf.parse(endTime);
            if (bt.after(et)) {
                return false;
            } else {
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 给出年月日，显示相应格式的时间，如：
     * 给出year = 2015；
     * 给出month = 12；
     * 给出day = 15；
     * 给出format yyyy年MM月dd日
     * 输出 2015年12月15日
     *
     * @return
     */
    public static String intToStr(int year, int month, int day, String format) {
        Date date = new Date(year - 1900, month, day);
        return dateToStr(date, format);
    }

    /**
     * 获取上周一日期
     *
     * @param format
     * @return
     */
    public static String lastWeekMonday(String format) {
        Calendar cal = Calendar.getInstance();
        //n为推迟的周数，1本周，-1向前推迟一周，2下周，依次类推
        int n = -1;
        String monday;
        cal.add(Calendar.DATE, n * 7);
        //想周几，这里就传几Calendar.MONDAY（TUESDAY...）
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        monday = new SimpleDateFormat(format).format(cal.getTime());
        return monday;
    }

    /**
     * 格式化卡号
     *
     * @param cardNum 卡号
     * @return
     */
    public static String formatCardNum(String cardNum) {
        String regex = "(.{4})";
        String cardNo = "3601" + cardNum;
        return cardNo.replaceAll(regex, "$1 ");
    }

    /**
     * 得到当前时间的前一周 wangbin
     *
     * @return
     */
    public static String getBeforeWeek() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, -7);//得到前7
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String mDateTime = formatter.format(c.getTime());
        return mDateTime;
    }

    public static Boolean isLeakThreeMonth(String sourceDate, String format) {
        System.out.println(sourceDate);
        Calendar c = Calendar.getInstance();//默认是当前日期
        int nowday = c.get(c.DAY_OF_YEAR);

        Calendar c1 = Calendar.getInstance();
        Date date = strToDate(sourceDate, format);
        c1.setTime(date);
        int oldday = c1.get(c1.DAY_OF_YEAR);
        int endYear = c1.get(c1.YEAR);
        int nowYear = c.get(c.YEAR);
        if (endYear > nowYear) {
            return false;
        } else {
            if (Math.abs(nowday - oldday) > 90) {
                return false;
            } else {
                return true;
            }
        }
    }
}

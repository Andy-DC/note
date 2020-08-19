package com.demo.common.util;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateUtil
 *
 * @author dengce
 * @date 2019/10/8
 * @description 日期工具类
 */
@Slf4j
public class DateUtil {

    /**
     * Date 转 String
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String parseDateToString(Date date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    /**
     * @param pattern    时间格式
     * @param dateString 时间字符串
     * @return
     */
    public static Date parseStringToDate(String pattern, String dateString) {
        Date date;
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            log.error("parseStringToDate error:", e);
            throw new RuntimeException("parseStringToDate error:", e);
        }
        return date;
    }

    /**
     * 拼业务归属月格式:2019年08月
     *
     * @param businessMonth
     * @return
     */
    public static String getBusinessMonth(String businessMonth) {
        StringBuilder resultStr = new StringBuilder();
        String[] year = businessMonth.split("年");
        String[] month = year[1].split("月");
        if (Integer.valueOf(month[0]) < 10 && month[0].length() == 1) {
            month[0] = "0" + month[0];
        }
        resultStr.append(year[0]);
        resultStr.append("年");
        resultStr.append(month[0]);
        resultStr.append("月");
        return resultStr.toString();
    }

    /**
     * 根据年月获取上一月
     *
     * @param year
     * @param month
     * @return
     */
    public static String getLastMonth(Integer year, Integer month) {
        String monthStr = "";
        month = month - 1;
        if (month == 0) {
            year = year - 1;
            month = 12;
        } else if (month < 10) {
            monthStr = "0";
        }
        StringBuilder resultStr = new StringBuilder();
        resultStr.append(year).append("年").append(monthStr).append(month).append("月");
        return resultStr.toString();
    }

    /**
     * 根据年月获取当前年月
     *
     * @param year
     * @param month
     * @return
     */
    public static String getCurrentMonth(Integer year, Integer month) {
        String monthStr = "";
        if (month < 10) {
            monthStr = "0";
        }
        StringBuilder resultStr = new StringBuilder();
        resultStr.append(year).append("年").append(monthStr).append(month).append("月");
        return resultStr.toString();
    }

    /**
     * 2019年09月转换为2019-09
     *
     * @param yearAndMonth
     * @return
     */
    public static String getYearAndMonthStr(String yearAndMonth) {
        yearAndMonth = yearAndMonth.replace("年", "-");
        yearAndMonth = yearAndMonth.replace("月", "");
        return yearAndMonth;
    }

    /**
     * 2019-19-19转换为209/19/19
     * @param yearAndMonth
     * @return
     */
    public static String getStringDate(String yearAndMonth) {
        yearAndMonth = yearAndMonth.replace("-", "/");
        yearAndMonth = yearAndMonth.replace("-", "/");
        return yearAndMonth;
    }

    /**
     * 2019-09转日期
     *
     * @param yearAndMonth
     * @return
     * @throws ParseException
     */
    public static Date yearAndMonthTransferDate(String yearAndMonth) {
        String yearAndMonthStr = getYearAndMonthStr(yearAndMonth);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date date;
        try {
            date = sdf.parse(yearAndMonthStr);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return date;
    }

    /**
     * 计算两个日期之间的间隔
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static int timeInterval(String startTime,String endTime) {
        SimpleDateFormat formatter =   new SimpleDateFormat( "yyyy-MM-dd");
        Date date1=null;
        Date date = null;
        Long l = 0L;
        try {
            date = formatter.parse(startTime);
            long ts = date.getTime();
            date1 =  formatter.parse(endTime);
            long ts1 = date1.getTime();

            l = (ts1 - ts) / (1000 * 60 * 60 * 24);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return l.intValue();
    }
}

package com.sakura.ofm.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转换工具
 */
public class DateHelper {

    /**
     * 时间转换成字符串
     * @param date
     * @return
     */
    public static String dateToString(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return  format.format(date);
    }
}

package com.sakura.ofm.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHelper {


    public static String delHTMLTag(String content){
        // <p>段落替换为换行
        content = content.replaceAll("<p .*?>", "\r\n");
        // <br><br/>替换为换行
        content = content.replaceAll("<br\\s*/?>", "\r\n");
        // 去掉其它的<>之间的东西
        content = content.replaceAll("\\<.*?>", "");
        //去掉 \n
        content = content.replaceAll("\\n"," ");
        // 去掉空格
        content = content.replaceAll(" ", "");
        return content;
    }
}

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

    public static void ttt() {
        int sum = 0;
        boolean flag = true;
        int x=  10000;

        for(int i = 2;i<=x;i++){
            for (int j = 2;j<i;j++){
                if (i % j == 0){
                    flag = false;
                    break;
                }

            }
            if (flag){
                System.out.println(i);
                sum = sum+i;
            }
            flag = true;
        }
        System.out.println("合计："+sum);
    }



    public static void main(String[] args) {
        ttt();
        System.out.println();
        System.out.println("------------------------------------------------------------");
        ddd();
        System.out.println();
        System.out.println("------------------------------------------------------------");
        dada();
    }

    public static void dada(){
        int x = 10000;
        boolean isprime = true;

        for (int i = 2; i <= x; i++) {
            for(int j = 2; j < i; j++) {
                if(i % j == 0) {
                    isprime = false;
                    break;
                }
            }
            if(isprime)System.out.print(i + " ");
            isprime = true;
        }

    }

    public static void ddd() {
        int x = 10000;
        boolean isprime = true;

        for (int i = 2; i <= x; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isprime = false;
                    break;
                }
            }
            if (isprime){
                System.out.print(i + " ");
            }
            isprime = true;
        }
    }


}

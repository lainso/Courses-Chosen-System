// 业勤：已完成

package com.artisan.util;

public class StringUtil {
    public static boolean isEmpty(String str){
        if(str==null || "".equals(str.trim())){
            return true;
        }else{
            return false;
        }
    }

    public static boolean IisEmpty(int i){
        if(i>=0){return false;}
        else {return true;}
    }

    public static boolean IisNotEmpty(int i){
        if(i>=0){
            return true;
        }else {
            return false;
        }
    }

    public static boolean isNotEmpty(String str){
        if(str!=null && !"".equals(str.trim())){
            return true;
        }else{
            return false;
        }
    }

    public static boolean classNotEmpty(String str){
        if(str=="—请选择—"){return false;}
        else {return true;}
    }
}

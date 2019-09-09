package com.lovo.sh.util;

public class StringBlNull {
    public static boolean StringNullYesOrNo(String str){
        if (str!=null&&!str.equals("")){
            return true;
        }
        return false;
    }
}

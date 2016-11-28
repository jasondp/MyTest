package com.mytest.util;

import com.google.gson.Gson;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jason on 2016/11/28.
 *
 */

public class Utils {

    public static boolean checkEmail(String email){
        Pattern emailCompile = Pattern.compile("\\\\w+([-+.]\\\\w+)*@\\\\w+([-.]\\\\w+)*\\\\.\\\\w+([-.]\\\\w+)*");
        Matcher matcher = emailCompile.matcher(email);
        if(matcher.find()){
            return true;
        }
        return false;
    }

    public static String convertJason(Objects objects){
        Gson gson = new Gson();
        return gson.toJson(objects);
    }
}

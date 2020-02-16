package com.project.utils;

public class Common {
    public static String numberGenerator(){
        return String.format("%06d", (long) (Math.random() * 1000000));
    }
    public static long numberGeneratorLong(){
        return  (long) (Math.random() * 1000000);
    }
}

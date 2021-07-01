package com.hhstudygroup.npustudy.configuration.property;

public class CookieConfig {

    public static String getName() {
        return "NPUStudy";
    }

    public static Integer getInterval() {
        return 30 * 24 * 60 * 60;
    }
}

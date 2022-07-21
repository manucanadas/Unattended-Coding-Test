package org.example;

public class TestPathUtil {
    public static String getCategoryPath(int id) {
        return "/Categories/" + id + "/Details.json?catalogue=false";
    }
}

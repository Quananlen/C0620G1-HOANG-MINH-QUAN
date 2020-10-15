package model;

import org.springframework.stereotype.Controller;

public class Setting {
    private static String language;
    private static String pageSize;
    private static String spamFilter;
    private static String signature;

    public Setting() {
    }

    public String getLanguage() {
        return language;
    }

    public static void setLanguage(String language) {
        Setting.language = language;
    }

    public String getPageSize() {
        return pageSize;
    }

    public static void setPageSize(String pageSize) {
        Setting.pageSize = pageSize;
    }

    public String getSpamFilter() {
        return spamFilter;
    }

    public static void setSpamFilter(String spamFilter) {
        Setting.spamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public static void setSignature(String signature) {
        Setting.signature = signature;
    }
}

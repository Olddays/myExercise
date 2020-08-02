package com.liu.LeetCode.ThirtyDays202006.exercise;

/**
 * Created by Liu on 2020/6/16.
 */
public class TD16_ValidateIPAddress {
    public static String validIPAddress(String IP) {
        if (IP.contains(".")) {
            return checkV4(IP);
        } else if (IP.contains(":")) {
            return checkV6(IP);
        }
        return "Neither";
    }

    private static String checkV4(String ip) {
        char[] chars = ip.toCharArray();
        String cache = "";
        int part = 0;
        for (char c : chars) {
            if (c <= '9' && c >= '0') {
                cache += c;
            } else if (c == '.') {
                try {
                    if (cache.startsWith("0") && cache.length() > 1) {
                        return "Neither";
                    }
                    int i = Integer.valueOf(cache);
                    if (i > 255 || i < 0) {
                        return "Neither";
                    }
                } catch (Exception e) {
                    return "Neither";
                }
                cache = "";
                part++;
            } else {
                return "Neither";
            }
        }
        try {
            if (cache.startsWith("0") && cache.length() > 1) {
                return "Neither";
            }
            int i = Integer.valueOf(cache);
            if (i > 255 || i < 0) {
                return "Neither";
            }
        } catch (Exception e) {
            return "Neither";
        }
        if (part != 3) {
            return "Neither";
        }
        return "IPv4";
    }

    private static String checkV6(String ip) {
        ip = ip.toLowerCase();
        char[] chars = ip.toCharArray();
        String cache = "";
        int part = 0;
        for (char c : chars) {
            if (c <= '9' && c >= '0' || c <= 'f' && c >= 'a') {
                cache += c;
            } else if (c == ':') {
                if (cache.length() > 4 || cache.length() == 0) {
                    return "Neither";
                }
                cache = "";
                part++;
            } else {
                return "Neither";
            }
        }
        if (cache.length() > 4 || cache.length() == 0) {
            return "Neither";
        }
        if (part != 7) {
            return "Neither";
        }
        return "IPv6";
    }

}

package com.llf.springboot.util;

import java.security.MessageDigest;

public class MD5Util {
        //盐，用于混交md5
        private static final String slat = "com.blxt.user";
        public static String create(String dataStr) {
            try {
                dataStr = dataStr + slat;
                MessageDigest m = MessageDigest.getInstance("MD5");
                m.update(dataStr.getBytes("UTF8"));
                byte s[] = m.digest();
                String result = "";
                for (int i = 0; i < s.length; i++) {
                    result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
                }
                return result;
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "";
        }

    }


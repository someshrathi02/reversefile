package org.example;

public class StringReverser {
    public static String reverse(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }
}
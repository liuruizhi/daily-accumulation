package com.palindrome;

/**
 * Longest Palindromic Substring
 *
 * @author liuruizhi
 * @since 2018/12/28
 */
public class Palindrome {

    private static int start = 0;
    private static int maxLen = 0;

//    public static String longestPalindrome(String s) {
//        int maxPalinLength = 0;
//        String longestPalindrome = null;
//        int length = s.length();
//
//        // check all possible sub strings
//        for (int i = 0; i < length; i++) {
//            for (int j = i + 1; j < length; j++) {
//                int len = j - i;
//                String curr = s.substring(i, j + 1);
//                if (isPalindrome(curr)) {
//                    if (len > maxPalinLength) {
//                        longestPalindrome = curr;
//                        maxPalinLength = len;
//                    }
//                }
//            }
//        }
//
//        return longestPalindrome;
//    }
//
//    public static boolean isPalindrome(String s) {
//
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
//                return false;
//            }
//        }
//
//        return true;
//    }


    public static String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int n = s.length();
        for (int i = 0; i < n - 1; ++i) {
            searchPalindrome(s, i, i);
            searchPalindrome(s, i, i + 1);
        }
        return s.substring(start, maxLen);
    }
    public static void searchPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left; ++right;
        }
        if (maxLen < right) {
            start = left + 1;
            // 此处有改动：maxLen = right - left - 1;
            // 个人感觉最大值直接是right就可以了，java的substring为[)这种区间
            maxLen = right;
        }
    }

    public static void main(String[] args) {
        // babcbabcbaccba
        System.out.println(Palindrome.longestPalindrome("abba"));
    }
}

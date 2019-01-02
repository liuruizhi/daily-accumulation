/*
 * Copyright (c) 2018.
 */

package com.palindrome;

/**
 * 马拉车算法实现
 * 参考实现 @link{http://www.cnblogs.com/grandyang/p/4475985.html}
 *
 * 复杂度为O(n)
 * 由于回文串的长度可奇可偶，比如"bob"是奇数形式的回文，"noon"就是偶数形式的回文，马拉车算法的第一步是预处理，做法是在每一个字符的左右都加上一个特殊字符，比如加上'#'，那么
 *
 * bob    -->    #b#o#b#
 *
 * noon    -->    #n#o#o#n#
 *
 * 这样做的好处是不论原字符串是奇数还是偶数个，处理之后得到的字符串的个数都是奇数个，这样就不用分情况讨论了，而可以一起搞定。
 *
 * @author LRZ
 * @date 2018-12-29
 */
public class Manacher {

    public static String longestPalindrome(String s) {

        int index = 0;
        int right = 0;
        int maxLen = 0;
        int center = 0;

        if (s == null || s.length() <= 1) {
            return s;
        }

        StringBuffer stringBuffer = new StringBuffer("$");
        for (char c : s.toCharArray()) {
            stringBuffer.append("#");
            stringBuffer.append(c);
        }

        stringBuffer.append("#");
        String str = stringBuffer.toString();

        int[] p = new int[str.length()];

        for (int i = 1; i < str.length() - 1; i++) {
            p[i] = right > i ? Math.min(right - i, p[2 * center - i]) : 1;

            while (i + p[i] < str.length() && str.charAt(i + p[i]) == str.charAt(i - p[i]))
                p[i]++;

            if (right < i + p[i]) {
                right = i + p[i];
                center = i;
            }

            if (maxLen < p[i]) {
                maxLen = p[i];
                index = i;
            }
        }

        return s.substring((index - maxLen) / 2, (index + maxLen) / 2 - 1);

    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abba"));
    }
}

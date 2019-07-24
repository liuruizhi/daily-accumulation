/*
 * Copyright (c) 2019.
 */

package com.dp;

/**
 * 有n阶台阶，每次只能上一阶或两阶，问有多少种方法
 *
 * @author liuruizhi
 * @since 2019/7/16
 */
public class FloorTest {

    public int search(int n) {
        if (1 == n) {
           return 1;
        }

        if (2 == n) {
            return 2;
        }

        return search(n - 1) + search(n - 2);
    }

    public static void main(String[] args) {
        String pre = "test";
        String p = "otestere";
        System.out.println(p.indexOf(pre));
    }
}

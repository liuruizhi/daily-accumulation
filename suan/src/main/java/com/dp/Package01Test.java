/*
 * Copyright (c) 2019.
 */

package com.dp;

/**
 * 01背包
 *
 * @author LRZ
 * @date 2019-01-02
 */
public class Package01Test {

    private static int[] weight = {2, 2, 6, 5, 4};
    private static int[] value = {6, 3, 5, 4, 6};
    private static int[][] c = new int[6][11];

    // TODO 递归实现
    // TODO 动态规划实现
    private static void dpPackage() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == 0) {
                    c[j][i] = 0;
                } else if (j == 0) {
                    c[j][i] = 0;
                } else {
                    if (i >= weight[j - 1]) {
                        c[j][i] = Math.max(c[j - 1][i], c[j - 1][i - weight[j - 1]] + value[j - 1]);
                    } else {
                        c[j][i] = c[j - 1][i];
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        dpPackage();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}

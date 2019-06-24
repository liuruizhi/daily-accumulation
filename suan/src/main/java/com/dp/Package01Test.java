/*
 * Copyright (c) 2019.
 */

package com.dp;

/**
 * 01背包
 * https://blog.csdn.net/chanmufeng/article/details/82955730
 * 首先我们用递归的方式来尝试解决这个问题我们用F(n,C)表示将前n个物品放进容量为C的背包里，得到的最大的价值。
 * 我们用自顶向下的角度来看，假如我们已经进行到了最后一步（即求解将n nn个物品放到背包里获得的最大价值），此时我们便有两种选择
 *  a) 不放第n个物品，此时总价值为F(n−1,C)
 *  b) 放置第n个物品，此时总价值为Vn+F(n−1,C−Wn)
 * 两种选择中总价值最大的方案就是我们的最终方案，递推式（有时也称之为状态转移方程）如下
 *  F(i,C)=max(F(i−1,C),v(i)+F(i−1,C−w(i)))
 *
 * @author LRZ
 * @date 2019-01-02
 */
public class Package01Test {

    private static int[] weight = {2, 2, 6, 5, 4};
    private static int[] value = {6, 3, 5, 4, 6};
    private static int[][] c = new int[6][11];

    // TODO 递归实现
    /**
     * 解决背包问题的递归函数
     *
     * @param w        物品的重量数组
     * @param v        物品的价值数组
     * @param index    当前待选择的物品索引
     * @param capacity 当前背包有效容量
     * @return 最大价值
     */
    private static int solveKS(int[] w, int[] v, int index, int capacity) {
        //基准条件：如果索引无效或者容量不足，直接返回当前价值0
        if (index < 0 || capacity <= 0)
            return 0;

        //不放第index个物品所得价值
        int res = solveKS(w, v, index - 1, capacity);
        //放第index个物品所得价值（前提是：第index个物品可以放得下）
        if (w[index] <= capacity) {
            res = Math.max(res, v[index] + solveKS(w, v, index - 1, capacity - w[index]));
        }
        return res;
    }

    public static int knapSack(int[] w, int[] v, int C) {
        int size = w.length;
        return solveKS(w, v, size - 1, C);
    }

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
                System.out.print(c[i][j] + "  ");
            }
            System.out.println();
        }
    }
}

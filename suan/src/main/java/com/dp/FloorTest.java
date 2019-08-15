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

    public int search2(int n) {
        if (1 == n) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }

    // 暴力法
    // 在暴力法中，我们将会把所有可能爬的阶数进行组合，也就是 1 和 2 。
    // 而在每一步中我们都会继续调用 climbStairs 这个函数模拟爬 1 阶和 2 阶的情形，并返回两个函数的返回值之和。
    // climbStairs(i,n)=(i + 1, n) + climbStairs(i + 2, n)
    // 其中 i 定义了当前阶数，而 n 定义了目标阶数。

    // 作者：LeetCode
    // 链接：https://leetcode-cn.com/problems/two-sum/solution/pa-lou-ti-by-leetcode/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int search3(int i, int n) {

        if (i > n) {
            return 0;
        }

        if (i == n) {
            return 1;
        }

        return search3(i + 1, n) + search3(i + 2, n);
    }

}

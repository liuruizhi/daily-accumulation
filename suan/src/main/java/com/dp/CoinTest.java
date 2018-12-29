package com.dp;

import java.util.Arrays;

/**
 * 动态规划 - 硬币组合
 *
 * dp(0) = 0;
 * dp(1) = dp(0) + 1 = 1;
 * dp(2) = dp(1) + 1 = dp(0) + 1 + 1 = 2;
 * dp(3) = dp(3) + 1 = 3 or dp(3) + 1 = 1 [i == coin];
 *
 * dp(i) = min{dp(i - coin) + 1, dp(i - i) + 1}
 *
 * @author liuruizhi
 * @since 2017/11/21
 */
public class CoinTest {
    private static int[] coinChoose(int value) {
        int[] result = new int[value + 1];
        int[] coins = {1, 3, 5};

        Arrays.fill(result, 9999);
        result[0] = 0;

        for (int i = 1; i <= value; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    if (result[i - coin] + 1 <= result[i]) {
                        result[i] = result[i - coin] + 1;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] result = coinChoose(4);
        System.out.println(result[4]);
    }
}

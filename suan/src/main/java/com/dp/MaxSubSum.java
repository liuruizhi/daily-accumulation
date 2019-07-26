/*
 * Copyright (c) 2019.
 */

package com.dp;

/**
 * 数组中子序列的最大和
 * 数组至少包含一个元素
 *
 * dp
 * 1.状态定义 F(i)表示下标为i时连续数组的最大和
 * 2.状态转移方程 F(i) = max(F(i-1)+nums[i],nums[i]);
 * 3.初始状态 F(0) = nums[0];
 * 4.返回值 F(nums.size()-1)
 *
 * @author liuruizhi
 * @since 2019/7/26
 */
public class MaxSubSum {

    public int solution(int[] nums) {

        // 不会出现
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        int maxSum = nums[0];
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
        }

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);

            if (dp[i] < nums[i]) {
                maxSum = nums[i];
            }
        }

        return maxSum;
    }
}

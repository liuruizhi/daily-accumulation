/*
 * Copyright (c) 2019.
 */

package com.dp;

/**
 * 打家劫舍Ⅱ
 *
 * @author liuruizhi
 * @since 2019/8/6
 */
public class RobRoom {

    public int rob(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        int len = nums.length;
        int[] dpH = new int[len - 1];
        dpH[0] = nums[0];
        dpH[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len - 1; i++) {
            dpH[i] = Math.max(dpH[i - 2] + nums[i], dpH[i - 1]);
        }

        int[] dpT = new int[len - 1];
        dpT[0] = nums[1];
        dpT[1] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < len; i++) {
            dpT[i - 1] = Math.max(dpT[i - 3] + nums[i], dpT[i - 2]);
        }

        return Math.max(dpH[len - 2], dpT[len - 2]);
    }
}

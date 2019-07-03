/*
 * Copyright (c) 2019.
 */

package com.other;

/**
 * 将数组中的所有零移到末尾，且保持非零数字的顺心
 *
 * @author liuruizhi
 * @since 2019/7/1
 */
public class ZeroMoveLast {

    public void move(int[] nums) {

        int firstZeroEle = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[firstZeroEle++] = nums[i];
            }
        }

        for (int j = firstZeroEle; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}

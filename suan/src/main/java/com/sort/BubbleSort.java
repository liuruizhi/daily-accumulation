/*
 * Copyright (c) 2019.
 */

package com.sort;

/**
 * 冒泡排序
 *
 * @author liuruizhi
 * @since 2019/8/21
 */
public class BubbleSort {

    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j + 1] < nums[j]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }
}

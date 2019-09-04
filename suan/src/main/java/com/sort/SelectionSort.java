/*
 * Copyright (c) 2019.
 */

package com.sort;

/**
 * 选择排序
 * 非稳定排序
 * 如，{8, 1, 1...}，后面的1会排到第一个1前面
 *
 * @author liuruizhi
 * @since 2019/8/21
 */
public class SelectionSort {

    public void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            int tmp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = tmp;
        }
    }
}

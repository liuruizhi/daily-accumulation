/*
 * Copyright (c) 2019.
 */

package com.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author liuruizhi
 * @since 2019/8/21
 */
public class MergeSort {

    public static int[] mergeSort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }

        int mid = nums.length / 2;

        int[] leftCopy = Arrays.copyOfRange(nums, 0, mid);
        int[] rightCopy = Arrays.copyOfRange(nums, mid, nums.length);
        int[] left = mergeSort(leftCopy);
        int[] right = mergeSort(rightCopy);

        return merge(left, right);

    }

    public static int[] merge(int[] left, int[] right) {
        int[] tmp = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < tmp.length; index++) {
            if (i >= left.length) {
                tmp[index] = right[j++];
            } else if (j >= right.length) {
                tmp[index] = left[i++];
            } else if (left[i] > right[j]) {
                tmp[index] = right[j++];
            } else {
                tmp[index] = left[i++];
            }
        }

        return tmp;
    }

    public static void main(String[] args) {
        int[] nums = {8, 1, 5, 2, 9, 6, 0, 7, 4, 3};
        int[] result = mergeSort(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }
}

/*
 * Copyright (c) 2018.
 */

package com.sort;

/**
 * 希尔排序
 *
 * @author LRZ
 * @date 2018-12-30
 */
public class ShellSort {

    public static void shellSort(int[] arr) {

        int length = arr.length;

        // 步长，即分组
        for (int step = length / 3; step > 0; step = step / 3) {
            // 对各个分组进行插入排序
            for (int j = step; j < length; j++) {
                int tmp = arr[j];
                int n;
                for (n = j - step; n >= 0 && tmp < arr[n]; n-=step) {
                    arr[n + step] = arr[n];
                }
                arr[n + step] = tmp;

                for (int x : arr) {
                    System.out.print(x + " ");

                }
                System.out.println("-----");
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 1, 0, 4, 3, 8, 6};
        shellSort(arr);
    }
}

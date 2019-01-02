/*
 * Copyright (c) 2019.
 */

package com.sort;

/**
 * 插入排序
 *
 * @author LRZ
 * @date 2019-01-02
 */
public class InsertSort {

    public static void insertSort(int[] arr) {
        for (int start = 1; start < arr.length; start++) {
            int tmp = arr[start];
            for (int old = start; old > 0; old--) {
                if (arr[old] < arr[old - 1]) {

                    arr[old] = arr[old - 1];
                    arr[old - 1] = tmp;
                }
            }

            for (int x : arr) {
                System.out.print(x + " ");

            }
            System.out.println("-----");
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 1, 0, 4, 3, 8, 6};
        insertSort(arr);

    }
}

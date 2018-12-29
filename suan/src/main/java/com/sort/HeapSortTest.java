package com.sort;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author liuruizhi
 * @since 2017/11/21
 */
public class HeapSortTest {

    public static void main(String[] args) {
        int[] array = {3, 1, 6, 9, 4, 5, 8, 7, 0, 2};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 构建初始堆
     *      无序
     *
     * @param array
     * @param parentPosition
     * @param height
     */
    private static void init(int[] array, int parentPosition, int height) {
        int parent = array[parentPosition];

        for (int i = 2 * parentPosition + 1; i < height; i = 2 * i + 1) {

            if (i + 1 < height && array[i] <= array[i + 1]) {
                i++;
            }

            if (array[parentPosition] >= array[i]) {
                break;
            }

            array[parentPosition] = array[i];
            array[i] = parent;
            parentPosition = i;

        }
    }

    /**
     * 排序
     *
     * @param array
     */
    private static void heapSort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            init(array, i, array.length);
        }

        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            init(array, 0, i);
        }
    }

    /**
     * 交换
     *
     * @param array
     * @param first
     * @param second
     */
    private static void swap(int[] array, int first, int second) {
        int tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }
}

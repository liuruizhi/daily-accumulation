package com.other;

/**
 * 找出第一个出现的数
 *
 * http://blog.csdn.net/jfkidear/article/details/52886228
 * @author liuruizhi
 * @since 2017/12/7
 */
public class SearchFirstNumber {

    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 6, 6, 8};
        int result = search(array, 2);
        System.out.println(result);
    }

    public static int search(int[] array, int key) {

        if (array.length == 0) {
            return -1;
        }

        int low = 0;
        int hgt = array.length;
        int mid = (low + hgt) / 2;

        while (low <= hgt) {
            if (array[low] == key) {
                return low;
            }
            mid = (low + hgt) / 2;
            if (array[mid] == key && mid - 1 >= 0 && array[mid - 1] != key) {
                return mid;
            } else if (array[mid] < key) {
                low = mid + 1;
            } else {
                hgt = mid - 1;
            }
        }

        return mid;
    }
}

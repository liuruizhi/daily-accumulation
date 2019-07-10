/*
 * Copyright (c) 2019.
 */

package com.other;

/**
 * 接雨水问题
 *
 * @author liuruizhi
 * @since 2019/7/5
 */
public class Solution_Rain {

    public int reslove(int[] height) {

        int result = 0;
        int length = height.length;

        int left = 0;
        int right = length - 1;

        if (length == 0 || length == 0) {
            return result;
        }

        int leftHeight = 0;
        int rightHeight = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                leftHeight = Math.max(leftHeight, height[left]);
                result = result + (leftHeight - height[left]);
                left++;
            } else {
                rightHeight = Math.max(rightHeight, height[right]);
                result = result + (rightHeight - height[right]);
                right--;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        Solution_Rain rain = new Solution_Rain();

        int x = rain.reslove(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});

        System.out.println(x);
    }
}

/*
 * Copyright (c) 2019.
 */

package com.array;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * ---------------------
 * 作者：技术小二郎
 * 来源：CSDN
 * 原文：https://blog.csdn.net/qq_16151925/article/details/80204729
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 *
 * @author liuruizhi
 * @since 2019/7/11
 */
public class MissNum {

    /**
     * 输入:
     * [4,3,2,7,8,2,3,1]

     * 输出:
     * [5,6]
     *
     * @param nums
     */

    private List<Integer> result = new ArrayList<>();

    public List<Integer> search(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}

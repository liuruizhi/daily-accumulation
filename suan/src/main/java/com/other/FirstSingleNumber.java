/*
 * Copyright (c) 2019.
 */

package com.other;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * a^a^b = b，a ^ a = 0, 0 ^ b = b
 *
 * @author liuruizhi
 * @since 2019/6/26
 */
public class FirstSingleNumber {

    public int search(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }

        return result;
    }
}

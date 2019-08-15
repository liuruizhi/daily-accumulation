/*
 * Copyright (c) 2019.
 */

package com.other;

import java.util.HashSet;
import java.util.Set;

/**
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。

 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author liuruizhi
 * @since 2019/8/2
 */
public class HappyNumber {
    public boolean isHappy(int n) {

        if (1 == n || 7 == n) {
            return true;
        }

        if (n < 10) {
            return false;
        }
        int sum = 0;
        while (n > 0) {
            int tmp = n % 10;
            sum = sum + tmp * tmp;
            n = n / 10;
        }

        return isHappy(sum);
    }

    public boolean isHappy2(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        while (true) {
            while (n > 0) {
                int d = n % 10;
                sum = sum + d * d;
                n = n / 10;
            }

            if (1 == sum) {
                return true;
            }

            if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
                n = sum;
                sum = 0;
            }
        }
    }
}

/*
 * Copyright (c) 2019.
 */

package com.other;

/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 注意：
 * 0 ≤ x, y < 2^31.
 *
 * 示例:
 * 输入: x = 1, y = 4
 * 输出: 2
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑

 * 上面的箭头指出了对应二进制位不同的位置。
 *
 * n -1 是会将最后一个1变为0，然后这个1前面的各位保持不变，后面的各位全变成1（或者这个1刚好是最后一位的话后面没有了）。比如1100 1000-1==1100 0111
 * n&(n-1)会将从最后一个1及后面的位数全部清零。如上得1100 1000&1100 0111==1100 0000
 *
 * @author liuruizhi
 * @since 2019/6/24
 */
public class HanMingDistance {

    public int hangming(int x, int y) {

        int res = x ^ y;
        int count = 0;
        while (res != 0) {
            count++;
            res = res & (res - 1);
        }

        return count;
    }
}

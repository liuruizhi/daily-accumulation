/*
 * Copyright (c) 2019.
 */

package com.array;

/**
 * 荷兰旗问题
 * 本问题被称为 荷兰国旗问题 ，最初由 Edsger W. Dijkstra提出。 其主要思想是给每个数字设定一种颜色，并按照荷兰国旗颜色的顺序进行调整。
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author liuruizhi
 * @since 2019/7/11
 */
public class ArrayColor {

    public void search(int[] nums) {
        int p0 = 0;
        int curr = 0;
        int p2 = nums.length;

        int tmp;
        while (curr <= p2) {

            if (nums[curr] == 0) {
//                nums[p0] = nums[curr] ^ nums[p0];
//                nums[curr] = nums[p0] ^ nums[curr];
//                nums[p0] = nums[p0] ^ nums[curr];
                tmp = nums[p0];
                nums[p0] = nums[curr];
                nums[curr] = tmp;
                p0++;
                curr++;
            } else if (nums[curr] == 2) {
//                nums[p2] = nums[p2] ^ nums[curr];
//                nums[curr] = nums[p2] ^ nums[curr];
//                nums[p2] = nums[p2] ^ nums[curr];
                tmp = nums[p2];
                nums[p2] = nums[curr];
                nums[curr] = tmp;
                p2--;
            } else {
                curr++;
            }
        }
    }
}

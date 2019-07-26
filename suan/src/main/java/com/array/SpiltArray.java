/*
 * Copyright (c) 2019.
 */

package com.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liuruizhi
 * @since 2019/7/24
 */
public class SpiltArray {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        int [] left = new int[n];
        left[0] = nums[0];
        int [] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            // from left to right
            if (i % k == 0)
                left[i] = nums[i];  // block_start
            else
                left[i] = Math.max(left[i - 1], nums[i]);

            // from right to left
            int j = n - i - 1;
            if ((j + 1) % k == 0)
                right[j] = nums[j];  // block_end
            else
                right[j] = Math.max(right[j + 1], nums[j]);
        }

        int [] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++)
            output[i] = Math.max(left[i + k - 1], right[i]);

        return output;
    }

    /**
      思路： 遍历数组 L R 为滑窗左右边界 只增不减
            双向队列保存当前窗口中最大的值的数组下标 双向队列中的数从大到小排序，
            新进来的数如果大于等于队列中的数 则将这些数弹出 再添加
            当R-L+1=k 时 滑窗大小确定 每次R前进一步L也前进一步 保证此时滑窗中最大值的
            数组下标在[L，R]中，并将当前最大值记录
      举例： nums[1，3，-1，-3，5，3，6，7] k=3
         1：L=0,R=0, 队列【0】 R-L+1 < k
                队列代表值【1】
         2: L=0,R=1, 队列【1】 R-L+1 < k
                队列代表值【3】
         解释：当前数为3 队列中的数为【1】 要保证队列中的数从大到小 弹出1 加入3
              但队列中保存的是值对应的数组下标 所以队列为【1】 窗口长度为2 不添加记录
         3: L=0,R=2, 队列【1，2】 R-L+1 = k ,result={3}
                队列代表值【3，-1】
         解释：当前数为-1 队列中的数为【3】 比队列尾值小 直接加入 队列为【3，-1】
              窗口长度为3 添加记录记录为队首元素对应的值 result[0]=3
         4: L=1,R=3, 队列【1，2，3】 R-L+1 = k ,result={3，3}
                队列代表值【3，-1,-3】
         解释：当前数为-3 队列中的数为【3，-1】 比队列尾值小 直接加入 队列为【3，-1，-3】
              窗口长度为4 要保证窗口大小为3 L+1=1 此时队首元素下标为1 没有失效
              添加记录记录为队首元素对应的值 result[1]=3
         5: L=2,R=4, 队列【4】 R-L+1 = k ,result={3，3，5}
                队列代表值【5】
         解释：当前数为5 队列中的数为【3，-1，-3】 保证从大到小 依次弹出添加 队列为【5】
              窗口长度为4 要保证窗口大小为3 L+1=2 此时队首元素下标为4 没有失效
              添加记录记录为队首元素对应的值 result[2]=5
        依次类推 如果队首元素小于L说明此时值失效 需要弹出
    */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums==null||nums.length<2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数按从大到小排序
        LinkedList<Integer> list = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            // 保证从大到小 如果前面数小 弹出
            while(!list.isEmpty()&&nums[list.peekLast()]<=nums[i]){
                list.pollLast();
            }
            // 添加当前值对应的数组下标
            list.addLast(i);
            // 初始化窗口 等到窗口长度为k时 下次移动在删除过期数值
            if(list.peek()<=i-k){
                list.poll();
            }
            // 窗口长度为k时 再保存当前窗口中最大值
            if(i-k+1>=0){
                result[i-k+1] = nums[list.peek()];
            }
        }
        return result;
    }

    /**
     * 作者：liweiwei1419
     * 链接：https://leetcode-cn.com/problems/two-sum/solution/zui-da-suo-yin-dui-shuang-duan-dui-lie-cun-suo-yin/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int len = nums.length;
        // 特判
        if (len == 0) {
            return new int[]{};
        }
        // 结果集
        List<Integer> res = new ArrayList<>();
        // 滑动窗口，注意：保存的是索引值
        ArrayDeque<Integer> deque = new ArrayDeque<>(k);

        for (int i = 0; i < len; i++) {
            // 当元素从左边界滑出的时候，如果它恰恰好是滑动窗口的最大值
            // 那么将它弹出
            if (i >= k && i - k == deque.getFirst()) {
                deque.pollFirst();
            }

            // 如果滑动窗口非空，新进来的数比队列里已经存在的数还要大
            // 则说明已经存在数一定不会是滑动窗口的最大值（它们毫无出头之日）
            // 将它们弹出
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.add(i);
            // 队首一定是滑动窗口的最大值的索引
            if (i >= k - 1) {
                res.add(nums[deque.peekFirst()]);
            }
        }

        int size = res.size();
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        SpiltArray test = new SpiltArray();
        test.maxSlidingWindow2(nums, 3);
    }

}

class Copy {
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums == null || nums.length == 0) {
//            return null;
//        }
//
//        if (k == 1) {
//            return nums;
//        }
//
//        LinkedList<Integer> list = new LinkedList<>();
//
//        for (int i = 0; i < nums.length; i++) {
//
//        }
//    }
}

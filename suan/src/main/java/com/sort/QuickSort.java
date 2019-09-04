/*
 * Copyright (c) 2019.
 */

package com.sort;

/**
 * 快速排序
 *
 * https://www.cnblogs.com/nullzx/p/5880191.html
 *
 * @author liuruizhi
 * @since 2019/8/21
 */
public class QuickSort {

    public static void swap(int[] A, int i, int j){
        int tmp;
        tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void quickSort1(int[] nums, int L, int R) {
        if (L < R) { // 递归的边界条件，当 L == R时数组的元素个数为1个
            int pivot = nums[L]; // 最左边的元素作为中轴，L表示left, R表示right
            int i = L + 1;
            int j = R;

            // 当i == j时，i和j同时指向的元素还没有与中轴元素判断，
            // 小于等于中轴元素，i++,大于中轴元素j--,
            // 当循环结束时，一定有i = j+1, 且i指向的元素大于中轴，j指向的元素小于等于中轴
            while (i <= j) {
                while (i <= j && nums[i] <= pivot) {
                    i++;
                }

                while (i <= j && nums[j] > pivot) {
                    j--;
                }

                // 当 i > j 时整个切分过程就应该停止了，不能进行交换操作
                // 这个可以改成 i < j， 这里 i 永远不会等于j， 因为有上述两个循环的作用
                if (i <= j) {
                    swap(nums, i, j);
                    i++;
                    j--;
                }
            }

            // 当循环结束时，j指向的元素是最后一个（从左边算起）小于等于中轴的元素
            swap(nums, L, j); // 将中轴元素和j所指的元素互换
            quickSort1(nums, L, j - 1); // 递归左半部分
            quickSort1(nums, j + 1, R); // 递归右半部分
        }
    }

    public static void quickSort2(int[] nums, int l, int r) {
        if (l < r) {
            // 最左边的元素作为中轴复制到pivot，这时最左边的元素可以看做一个坑
            int pivot = nums[l];
            // 注意这里 i = L,而不是 i = L+1, 因为i代表坑的位置,当前坑的位置位于最左边
            int i = l;
            int j = r;

            while (i < j) {
                // 下面两个循环的位置不能颠倒，因为第一次坑的位置在最左边
                while (i < j && nums[j] > pivot) {
                    j--;
                }
                // 填nums[i]这个坑,填完后nums[j]是个坑
                // 注意不能是nums[i++] = nums[j],当因i==j时跳出上面的循环时
                // 坑为i和j共同指向的位置,执行nums[i++] = nums[j],会导致i比j大1，
                // 但此时i并不能表示坑的位置
                nums[i] = nums[j];

                while (i < j && nums[i] <= pivot) {
                    i++;
                }
                // 填nums[j]这个坑，填完后nums[i]是个坑，
                // 同理不能是nums[j--] = nums[i]
                nums[j] = nums[i];
            }

            // 循环结束后i和j相等，都指向坑的位置，将中轴填入到这个位置
            nums[i] = pivot;

            quickSort2(nums, l, i - 1);
            quickSort2(nums, i + 1, r);
        }
    }

    public static void QuickSortDualPivot(int[] A, int L, int R){
        if(L >= R){
            return;
        }

        if(A[L] > A[R]){
            swap(A, L, R); //保证pivot1 <= pivot2
        }

        int pivot1 = A[L];
        int pivot2 = A[R];

        //如果这样初始化 i = L+1, k = L+1, j = R-1,也可以
        //但代码中边界条件, i,j先增减，循环截止条件，递归区间的边界都要发生相应的改变
        int i = L;
        int k = L+1;
        int j = R;

        OUT_LOOP:
        while(k < j){
            if(A[k] < pivot1){
                i++;//i先增加，首次运行pivot1就不会发生改变
                swap(A, i, k);
                k++;
            }else
            if(A[k] >= pivot1 && A[k] <= pivot2){
                k++;
            }else{
                while(A[--j] > pivot2){//j先增减，首次运行pivot2就不会发生改变
                    if(j <= k){//当k和j相遇
                        break OUT_LOOP;
                    }
                }
                if(A[j] >= pivot1 && A[j] <= pivot2){
                    swap(A, k, j);
                    k++;
                }else{
                    i++;
                    swap(A, j, k);
                    swap(A, i, k);
                    k++;
                }
            }
        }
        swap(A, L, i);//将pivot1交换到适当位置
        swap(A, R, j);//将pivot2交换到适当位置

        //一次双轴切分至少确定两个元素的位置，这两个元素将整个数组区间分成三份
        QuickSortDualPivot(A, L, i-1);
        QuickSortDualPivot(A, i+1, j-1);
        QuickSortDualPivot(A, j+1, R);
    }

    public static void main(String[] args) {
        int[] nums = {8, 1, 5, 2, 9, 9, 10, 11, 12, 13};
        //quickSort1(nums, 0, nums.length - 1);
        QuickSortDualPivot(nums, 0, nums.length - 1);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}

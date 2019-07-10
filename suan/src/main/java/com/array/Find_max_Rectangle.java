/*
 * Copyright (c) 2019.
 */

package com.array;

import java.util.Random;

/**
 * @author liuruizhi
 * @since 2019/7/4
 */
public class Find_max_Rectangle {


    public static void main(String[] args) {
        int[] source = new int[7];
        createRandomA(source);
        printA(source);
        int[] backup = new int[source.length];
        int[] maxnum = new int[source.length];
        for(int i = 0; i < source.length; i++){
            backup[i] = source[i];
            maxnum[i] = 0;
        }
        findmax(source, backup, maxnum, new int[]{0, source.length - 1, 0, source.length - 1});
        System.out.println();


        int max = 0;
        for(int i = 0; i < maxnum.length; i++){
            max = max > maxnum[i] ? max : maxnum[i];
            System.out.print(maxnum[i] + " ");
        }
        System.out.println();
        System.out.println(max);
    }


    private static void printA(int[] source) {
        for(int i = 0; i < source.length; i++)
            System.out.print(source[i] + " ");
        System.out.println();
    }

    /**
     * 找到最大面积，backup存储了原数组剩余的墙高度
     *
     * 示例
     * 17 19 10  1  6 27 23  source
     *  7  7  7  7  7  7  7  max1
     * 30 30 30  7  7  7  7  max2
     * 34 34 30  7  7  7  7  ...
     * 34 34 30  7 18 18 18  ...
     * 34 34 30  7 18 46 46  ...
     *
     * @param source
     * @param backup
     * @param maxnum
     * @param tag
     * @return
     */

    private static int findmax(int[] source, int[] backup, int[] maxnum, int[] tag) {

        // 存在有效数组
        while(get_cutoff_backup(backup, tag)){
            // 假设最小元素为子数组首元素
            int tmp = backup[tag[2]];
            // 找出子数组中最小的元素
            for(int i = tag[2]; i <= tag[3]; i++) {
                tmp = tmp < backup[i] ? tmp : backup[i];
            }
            // bcakup减去最小元素
            for(int i = tag[2]; i <= tag[3]; i++)
                backup[i] -= tmp;
            // 如果有子数组，且原最大值比计算的小则更新
            if(tag[3] >= tag[2] && maxnum[tag[2]] < (tag[3] - tag[2] + 1) * (source[tag[2]] - backup[tag[2]])){
                // 填充从起点到终点的最大面积
                // 示例中的max1 ...
                for(int i = tag[2]; i <= tag[3]; i++) {
                    maxnum[i] = (tag[3] - tag[2] + 1) * (source[i] - backup[i]);
                }

                printA(maxnum);
                // TODO 不太理解
                findmax(source, backup, maxnum, new int[]{tag[2], tag[3], tag[2], tag[3]});
            }

            tag[0] = tag[2] + 1;
            if(tag[0] > tag[1])
                break;
        }
        return -1;
    }

    // 检查是否可以分割为子数组，tag[2]、tag[3]为子数组的起点、终点，tag[0]原数组的起点，tag[1]原数组的终点
    private static boolean get_cutoff_backup(int[] backup, int[] tag) {

        boolean have_a_sub_head = false;
        for(int i = tag[0]; i <= tag[1]; i++){
            // 找出第一个非零的元素下标，tag[2]
            if(!have_a_sub_head && backup[i] != 0) {
                tag[2] = i;
                have_a_sub_head = true;
            }
            // 找到非零元素下标，且连续的数组的结尾下标
            if(have_a_sub_head && backup[i] == 0) {
                tag[3] = i - 1; // 零元素的前一个元素
                return true;
            }
            // 找到非零元素下标，连续的数组的结尾下标，且最后一个元素非零
            if(have_a_sub_head && i == tag[1] && backup[i] != 0) {
                tag[3] = i;
                return true;
            }
        }
        return false;
    }

    // 初始化数组
    private static void createRandomA(int[] a) {
        Random random = new Random();
        for(int i = 0; i < a.length; i++)
            a[i] = random.nextInt(30);
    }


}

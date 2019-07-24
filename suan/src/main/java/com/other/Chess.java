/*
 * Copyright (c) 2019.
 */

package com.other;

/**
 * 棋盘覆盖问题
 *
 * @author liuruizhi
 * @since 2019/7/23
 */
public class Chess {
    /**  棋盘的规格  */
    public static int SIZE = 8;
    /**  特殊格子的竖坐标(从零开始)  */
    public static int TR = 1;
    /**  特殊格子的横坐标(从零开始)  */
    public static int TC = 1;

    /** 模拟棋盘  */
    static int[][] board;
    /** 模拟骨牌（相同数字为同一块骨牌）  */
    static int tile = 1;

    /**
     * 棋盘覆盖问题
     * @param dr  左上角方格行号
     * @param dc  左上角方格列号
     * @param tr  特殊方格行号
     * @param tc  特殊方格列号
     * @param size  2的正整数次方
     */
    public static void chessBoard(int dr, int dc, int tr, int tc, int size) {

        if (size == 1) {
            return;
        }

        int t = tile++;
        /**  分割棋盘后的size  */
        int s = size / 2;

        // 判断特殊方格是否在左上角的小棋盘中
        if (tr < dr + s && tc < dc + s) {
            chessBoard(dr, dc, tr, tc, s);
        } else {
            board[dr + s - 1][dc + s - 1] = t;
            chessBoard(dr, dc, dr + s - 1, dc + s - 1, s);
        }

        // 判断特殊方格是否在右上角的小棋盘中
        if (tr < dr + s && tc >= dc + s) {
            chessBoard(dr, dc + s, tr, tc, s);
        } else {
            board[dr + s - 1][dc + s] = t;
            chessBoard(dr, dc + s, dr + s - 1, dc + s, s);
        }

        // 判断特殊方格是否在左下角的小棋盘中
        if (tr >= dr + s && tc < dc + s) {
            chessBoard(dr + s, dc, tr, tc, s);
        } else {
            board[dr + s][dc + s - 1] = t;
            chessBoard(dr + s, dc, dr + s, dc + s - 1, s);
        }

        // 判断特殊方格是否在右下角的小棋盘中
        if (tr >= dr + s && tc >= dc + s) {
            chessBoard(dr + s, dc + s, tr, tc, s);
        } else {
            board[dr + s][dc + s] = t;
            chessBoard(dr + s, dc + s, dr + s, dc + s, s);
        }

    }

    public static void main(String[] args) {

        // init parameter
        try{
            if(args[0]!=null){
                SIZE = Integer.parseInt(args[0], 10);
            }
            if(args[1]!=null){
                TR = Integer.parseInt(args[1], 10);
            }
            if(args[2]!=null){
                TC = Integer.parseInt(args[2], 10);
            }
        }catch(Exception e){
            System.out.print("\t(部分)采用默认参数");
        }

        System.out.printf("\t棋盘规模：%d*%d",SIZE,SIZE);
        System.out.printf("\t特殊方格：(%d,%d)",TR,TC);

        // 初始化棋盘
        board = new int[SIZE][SIZE];
        // 调用方法进行测试
        chessBoard(0, 0, TR, TC, SIZE);
        // 显示棋盘结果
        for (int[] is : board) {
            System.out.println();
            for (int i : is) {
                System.out.printf("%4d", i);
            }
        }
    }
}

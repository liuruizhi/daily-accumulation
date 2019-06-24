package com.queen;

/**
 * @author liuruizhi
 * @since 2019/5/29
 */
public class Queen {

    private static int[][] ground;
    private int count = 8;
    int sum = 0;

    {
        ground = new int[count][count];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                ground[i][j] = 0;
            }
        }
    }

    public boolean safe(int[][] ground, int row, int col) {

        // 判断左上、上、右上
        int step = 1;
        while (row - step >= 0) {
            // 左上
            if (col - step >= 0 && ground[row - step][col - step] == 1) {
                return false;
            }

            // 中上
            if (ground[row - step][col] == 1) {
                return false;
            }

            // 右上
            if (col + step < ground.length && ground[row - step][col + step] == 1) {
                return false;
            }

            step++;
        }

        return true;
    }

    public int search(int[][] chess, int row) {

        if (row == count) {
            return sum++;
        }

//        int[][] temp = chess.clone();

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++)
                ground[row][j] = 0;

            ground[row][i] = 1;

            if (safe(ground, row, i)) {
                search(ground, row + 1);
            }
        }


        return sum;
    }

    public static void main(String[] args) {
        Queen queen = new Queen();
        int sum = queen.search(ground, 0);
        System.out.println(sum);
    }

}

package com.greedy;

/**
 * 小船调度问题
 *
 * @description
 *             题目大意是只有一艘船，能乘2人，船的运行速度为2人中较慢一人的速度，
 *             过去后还需一个人把船划回来，问把n个人运到对岸，最少需要多久。
 *
 *             先将所有人过河所需的时间按照升序排序，我们考虑把单独过河所需要时间最多的两个旅行者送到对岸去，有两种方式：
 *             1.最快的和次快的过河，然后最快的将船划回来；次慢的和最慢的过河，然后次快的将船划回来，所需时间为：t[0]+2*t[1]+t[n-1]；
 *             2.最快的和最慢的过河，然后最快的将船划回来，最快的和次慢的过河，然后最快的将船划回来，所需时间为：2*t[0]+t[n-2]+t[n-1]。
 *
 * @author liuruizhi
 * @since 2017/11/22
 */
public class ShipTest {

    public static void main(String[] args) {
        int[] time = {1, 2, 3, 4, 5, 6};
        int person = 6;
        int sum = 0;

        // if person < 3 sum = time[person - 1]
        // if person = 3 sum = time[0] + time[1] + time[2]

        sum = ship(person, time);

        System.out.println(sum);
    }

    private static int min(int a, int b) {
        return a > b ? b : a;
    }

    private static int ship(int person, int[] time) {
        int sum = 0;

        if (person < 3) {
            sum = time[person - 1];
        }

        if (person == 3) {
            sum = sum + time[0] + time[1] + time[2];
        }

        if (person > 3) {
            for (int i = time.length - 1; i > 0; i = i - 2) {
                sum = min(sum + time[0] + time[i] + 2 * time[1], sum + time[i] + time[i - 1] + 2 * time[0]);
            }
        }


        return sum;
    }
}

package com.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 活动安排问题
 *
 * @author liuruizhi
 * @since 2017/11/22
 */
public class ActionChooseTest {

    public static void main(String[] args) {

        Action[] actions = new Action[7];

        actions[0] = new Action(2, 4);
        actions[1] = new Action(1, 4);
        actions[2] = new Action(3, 6);
        actions[3] = new Action(4, 7);
        actions[4] = new Action(5, 8);
        actions[5] = new Action(6, 8);
        actions[6] = new Action(7, 9);

        // 排序
        Arrays.sort(actions, new ActionCompara());

        int max = choose(actions);

        System.out.println(max);

    }

    /**
     * 首尾相接
     *
     * @param actions
     * @return
     */
    private static int choose(Action[] actions) {
        int max = 1;
        int start = 0;
        for (int i = 1; i < actions.length; i++) {

            if (actions[i].getStart() >= actions[start].getEnd()) {
                start = i;
                max++;
            }

        }

        return max;
    }

}

class Action {

    private int start;
    private int end;

    Action() {

    }

    Action(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}

class ActionCompara implements Comparator<Action> {

    @Override
    public int compare(Action o1, Action o2) {
        if (o1.getEnd() == o2.getEnd()) {
            return o1.getStart() < o2.getStart() ? -1 : 1;
        }
        return o1.getEnd() < o2.getEnd() ? -1 : 1;
    }
}

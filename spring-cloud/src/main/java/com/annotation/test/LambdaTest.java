package com.annotation.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuruizhi
 * @since 2019/9/6
 */
public class LambdaTest {

    public static void main(String[] args) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<Integer>(){
            {
                add(1);
                add(2);
                add(3);
            }
        };
        map.put("a", list);

        map.forEach((k, v) -> {
            for (int i = 0; i < v.size(); i++) {
                if (v.get(i) == 2) {
                    continue;
                }
                System.out.println(v.get(i));
            }
        });
    }
}

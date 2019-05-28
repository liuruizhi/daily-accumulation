/*
 * Copyright (c) 2019.
 */

package com.test;

import java.util.Random;

/**
 * class
 *
 * @author LRZ
 * @date 2019-01-14
 */
public class AssignTest {
    public static void main(String[] args) {
        System.out.println(int.class.isAssignableFrom(Integer.class));
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            random.setSeed(100);
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + random.nextInt(100) + ", ");
            }
            System.out.println("");
        }
    }
}

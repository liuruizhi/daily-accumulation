package com.lock;

public class Test0 {

    private String lock = "lock";
    volatile boolean flag = false;
    public static void main(String[] args) {
        Test0 test0 = new Test0();
        new Thread(test0.new PrintOne(), "print-one").start();
        new Thread(test0.new PrintTwo(), "print-two").start();
    }

    class PrintOne implements Runnable {

//        @Override
//        public void run() {
//            while (true) {
//                if (!flag) {
//                    System.out.println("1");
//                    flag = true;
//                }
//            }
//        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    System.out.println("1");
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class PrintTwo implements Runnable {

//        @Override
//        public void run() {
//            while (true) {
//                if (flag) {
//                    System.out.println("2");
//                    flag = false;
//                }
//            }
//        }
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    System.out.println("2");
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

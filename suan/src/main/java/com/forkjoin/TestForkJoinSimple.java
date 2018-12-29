package com.forkjoin;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * @author liuruizhi
 * @since 2018/1/2
 */

class SortTask extends RecursiveAction {

    final long[] array;
    final int lo;
    final int hi;
    private int THRESHOLD = 0; //For demo only

    public SortTask(long[] array) {
        this.array = array;
        this.lo = 0;
        this.hi = array.length - 1;
    }

    public SortTask(long[] array, int lo, int hi) {
        this.array = array;
        this.lo = lo;
        this.hi = hi;
    }

    private int partition(long[] array, int lo, int hi) {
        long x = array[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (array[j] <= x) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, hi);
        return i + 1;
    }

    private void swap(long[] array, int i, int j) {
        if (i != j) {
            long temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    private void sequentiallySort(long[] array, int lo, int hi) {
        Arrays.sort(array, lo, hi + 1);
    }

    @Override
    protected void compute() {
        if (hi - lo < THRESHOLD)
            sequentiallySort(array, lo, hi);
        else {
            int pivot = partition(array, lo, hi);
            System.out.println("\npivot = " + pivot + ", low = " + lo + ", high = " + hi);
            System.out.println("array" + Arrays.toString(array));
            new SortTask(array, lo, pivot - 1).fork();
            new SortTask(array, pivot + 1, hi).fork();
        }
    }
}

class Fibonacci extends RecursiveTask<Integer> {
    final int n;

    Fibonacci(int n) {
        this.n = n;
    }

    private int compute(int small) {
        final int[] results = { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89 };
        return results[small];
    }

    public Integer compute() {
        if (n <= 10) {
            return compute(n);
        }
        Fibonacci f1 = new Fibonacci(n - 1);
        Fibonacci f2 = new Fibonacci(n - 2);
        f1.fork();
        f2.fork();
        return f1.join() + f2.join();
    }
}

public class TestForkJoinSimple {
    private static final int NARRAY = 16; //For demo only
    long[] array = new long[NARRAY];
    Random rand = new Random();

    @Before
    public void setUp() {
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextLong()%100; //For demo only
        }
        System.out.println("Initial Array: " + Arrays.toString(array));
    }

    @Test
    public void testSort() throws Exception {
        ForkJoinTask sort = new SortTask(array);
        ForkJoinPool fjpool = new ForkJoinPool();
        fjpool.submit(sort);
        fjpool.shutdown();

        fjpool.awaitTermination(30, TimeUnit.SECONDS);

        assertTrue(checkSorted(array));
    }

    @Test
    public void testFibonacci() throws InterruptedException, ExecutionException {
        ForkJoinTask<Integer> fjt = new Fibonacci(12);
        ForkJoinPool fjpool = new ForkJoinPool();
        Future<Integer> result = fjpool.submit(fjt);

        // do something
        System.out.println(result.get());
    }

    boolean checkSorted(long[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > (a[i + 1])) {
                return false;
            }
        }
        return true;
    }
}

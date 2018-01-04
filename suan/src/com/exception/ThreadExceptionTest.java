package com.exception;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 多线程异常问题
 *
 * @author liuruizhi
 * @since 2017/12/28
 */
class ThreadException implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
    /*
     * Thread.UncaughtExceptionHandler.uncaughtException()会在线程因未捕获的异常而临近死亡时被调用
     */
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        throw new RuntimeException();
    }
}

class HanlderThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());//设定线程工厂的异常处理器
        return t;
    }
}

class MyThreadPoolExecutor extends ThreadPoolExecutor {

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                                TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        // If submit() method is called instead of execute()
        if (t == null && r instanceof Future<?>) {
            try {
                Object result = ((Future<?>) r).get();
            } catch (CancellationException e) {
                t = e;
            } catch (ExecutionException e) {
                t = e.getCause();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        if (t != null) {
            // Exception occurred
            System.err.println("Uncaught exception is detected! " + t
                    + " st: " + Arrays.toString(t.getStackTrace()));
            // ... Handle the exception
            // Restart the runnable again
            execute(r);
        }
    }
}

class ExceptionTest implements Callable {

    @Override
    public Object call() throws Exception {
        throw new RuntimeException();
    }
}

public class ThreadExceptionTest {

    public static void main(String[] args) {
        // Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler()); 与下面2作用一致
        try {
            // 2
            ExecutorService exec = Executors.newFixedThreadPool(1, new HanlderThreadFactory());
            exec.execute(new ThreadException());
            exec.shutdown();

            ExecutorService call = Executors.newFixedThreadPool(1);
            Future future = call.submit(new ExceptionTest());
            future.get();

            call.shutdown();
        } catch (Exception e) {
            System.out.println("终于捕捉到了 error " + e);

        }


    }
}

package com.lulin.threadscount;

import java.util.concurrent.atomic.AtomicLong;

/**
 * ——2.AtomicLong
 *
 * @Author: LuLin
 * @Date: 2020/12/30 11:42
 */
public class AtomicInteger02 {
    static AtomicLong atomicLong = new AtomicLong(0L);

    public static void getAtomicInteger02() throws InterruptedException {
        Thread[] threads = new Thread[10000];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    atomicLong.incrementAndGet();
                }
            });
        }
        for (Thread thread : threads) thread.start();
        for (Thread thread : threads) thread.join();
        System.out.println("atomicLong=" + atomicLong);
    }


    public static void main(String[] args) throws InterruptedException {
        getAtomicInteger02();
    }
}

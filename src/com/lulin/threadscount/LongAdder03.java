package com.lulin.threadscount;

import java.util.concurrent.atomic.LongAdder;

/**
 * ——3.LongAdder
 *
 * @Author: LuLin
 * @Date: 2020/12/30 11:44
 */
public class LongAdder03 {
    static LongAdder longAdder = new LongAdder();

    public static void getLongAdder() throws InterruptedException {
        Thread[] threads = new Thread[10000];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    longAdder.increment();
                }
            });
        }
        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();
        System.out.println("longAdder=" + longAdder);
    }

    public static void main(String[] args) throws InterruptedException {
        getLongAdder();
    }

}

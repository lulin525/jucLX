package com.lulin.threadscount;
/**
 * 多个线程对一个数进行++
 * ——1.加锁—synchronized
 *
 * @Author: LuLin
 * @Date: 2020/12/30 11:24
 */
public class SynchronizedObject01 {

    static long count = 0;

    public static void getSynchhronized() throws InterruptedException {
        Thread[] threads = new Thread[10000];

        SynchronizedObject01 lock=new SynchronizedObject01();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    synchronized (lock) {
                        count++;
                    }
                }
            });
        }
        for (Thread thread : threads) thread.start();
        for (Thread thread : threads) thread.join();
        System.out.println("coun=" + count);
    }

    public static void main(String[] args) throws InterruptedException {
        getSynchhronized();
    }

}

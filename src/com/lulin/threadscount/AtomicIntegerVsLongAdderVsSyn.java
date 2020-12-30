package com.lulin.threadscount;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * 多个线程对一个数进行++
 * 比较效率：
 * ——1.加锁—synchronized
 * ——2.AtomicLong
 * ——3.LongAdder
 *
 * @Author: LuLin
 * @Date: 2020/12/30 11:49
 */
public class AtomicIntegerVsLongAdderVsSyn {

    public static void main(String[] args) throws InterruptedException {
        long start=0L;
        long end=0L;

        SynchronizedObject01 s1 = new SynchronizedObject01();
        AtomicInteger02 s2 = new AtomicInteger02();
        LongAdder03 s3 = new LongAdder03();

        start=System.currentTimeMillis();
        s1.getSynchhronized();
        end=System.currentTimeMillis();
        System.out.println("————————————————————————————————————————————1结束:"+(end-start));

        start=System.currentTimeMillis();
        s2.getAtomicInteger02();
        end=System.currentTimeMillis();
        System.out.println("————————————————————————————————————————————2结束:"+(end-start));

        start=System.currentTimeMillis();
        s3.getLongAdder();
        end=System.currentTimeMillis();
        System.out.println("————————————————————————————————————————————3结束:"+(end-start));

    }


}

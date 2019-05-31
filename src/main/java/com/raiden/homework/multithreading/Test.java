package com.raiden.homework.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: Raiden
 * Date: 2019/5/23
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        t.count();
        t.useThread();
    }

    void count() {
        Long startTime = System.currentTimeMillis();
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("for循环耗时:" + (System.currentTimeMillis() - startTime) + "ms");
    }

    void useThread() {
        Long startTime = System.currentTimeMillis();
        List<Thread> threadList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Thread t = new Thread(new MyThread());
            t.start();
            threadList.add(t);
        }
        for (Thread t : threadList) {
            if (t.isAlive()) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("多线程耗时:" + (System.currentTimeMillis() - startTime) + "ms");
    }


    class MyThread implements Runnable {
        public void run() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

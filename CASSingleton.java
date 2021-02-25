package com.le.jvm.design;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author happy_le
 * @date 2020/12/14 上午7:23
 */
public class CASSingleton {
    private static final AtomicReference<CASSingleton> INSTANCE = new AtomicReference();

    private CASSingleton() {
    }

    public static final CASSingleton getInstance() {
        for (; ;) {
            CASSingleton current = INSTANCE.get();
            if (current != null)
                return current;
            current = new CASSingleton();
            if (INSTANCE.compareAndSet(null,current)) {
                return current;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("main thread" + CASSingleton.getInstance());
        System.out.println("main thread" + CASSingleton.getInstance());
        System.out.println("main thread" + CASSingleton.getInstance());
        System.out.println("main thread" + CASSingleton.getInstance());
        System.out.println("main thread" + CASSingleton.getInstance());
        System.out.println("main thread" + CASSingleton.getInstance());
        Thread t1 = new Thread(new A());
        Thread t2 = new Thread(new A());
        Thread t3 = new Thread(new A());
        Thread t4 = new Thread(new A());
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println("program end");
    }
}

class A implements Runnable {
    @Override
    public void run() {
        CASSingleton instance = CASSingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+"  " + instance);
    }
}
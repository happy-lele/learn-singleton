package com.le.jvm.design;

/**
 * @Author happy_le
 * @date 2020/12/13 下午8:05
 * 从结果我们可以看出这个单例之算是个伪单例，只能在一个线程里面实现单例。
 */
public class ThreadLocalSingleton {

    private static final ThreadLocal<ThreadLocalSingleton> tlSingleton =
            new ThreadLocal() {
                @Override
                protected ThreadLocalSingleton initialValue() {
                    return new ThreadLocalSingleton();
                }
            };

    public static ThreadLocalSingleton getInstance() {
        return tlSingleton.get();
    }

    private ThreadLocalSingleton() {
    }

    public static void main(String[] args) {
        System.out.println("main thread" + ThreadLocalSingleton.getInstance());
        System.out.println("main thread" + ThreadLocalSingleton.getInstance());
        System.out.println("main thread" + ThreadLocalSingleton.getInstance());
        System.out.println("main thread" + ThreadLocalSingleton.getInstance());
        System.out.println("main thread" + ThreadLocalSingleton.getInstance());
        System.out.println("main thread" + ThreadLocalSingleton.getInstance());
        Thread t1 = new Thread(new T());
        Thread t2 = new Thread(new T());
        Thread t3 = new Thread(new T());
        Thread t4 = new Thread(new T());
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println("program end");
    }
}

class T implements Runnable {
    @Override
    public void run() {
        ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+"  " + instance);
    }
}

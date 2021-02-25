package com.le.jvm.design;

/**
 * @Author happy_le
 * @date 2020/10/23 18:00
 * DCL双重校验锁，线程安全
 */
public class DCLSingleton {

    // private类型的构造方法
    private DCLSingleton() {
    }

    private volatile static DCLSingleton instance;

    public DCLSingleton getInstance() {
        if (null == instance) {
            synchronized (instance) {
                if (null == instance) {
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }
}

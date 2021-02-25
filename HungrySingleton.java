package com.le.jvm.design;

/**
 * @Author happy_le
 * @date 2020/10/23 17:52
 * 饿汉式单例模式，在类加载时已经创建好单例对象，多线程hashCode值一样，所以线程安全
 */
public class HungrySingleton {

    // private类型的构造方法
    private HungrySingleton() {
    }

    private static HungrySingleton instance = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return instance;
    }

}

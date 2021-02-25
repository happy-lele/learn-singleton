package com.le.jvm.design;

/**
 * @Author happy_le
 * @date 2020/10/23 17:54
 * 懒 汉式单例模式，在真正需要使用对象时才去创建该单例类对象,线程安全
 */
public class LazySingleton {

    // private类型的构造方法
    private LazySingleton() {
    }

    // 公有的获取实例对象方法
    public static LazySingleton getInstance() {
        return Holder.LAZY_SINGLETON;
    }

    // 私有静态内部类：定义一个私有静态final类型的实例对象
    private static class Holder {
        private static final LazySingleton LAZY_SINGLETON = new LazySingleton();
    }
}

package com.le.jvm.design;

/**
 * @Author happy_le
 * @date 2020/10/23 20:44
 * 枚举类不要暴露了，否则违反了单一职责的原则
 */
public class ClassFactory {

    private enum MyEnumSingleton {
        singletonFactory;

        private Singleton instance;

        // 枚举类的构造方法在类加载是被实例化
        private MyEnumSingleton() {
            instance = new Singleton();
        }

        public Singleton getInstance() {
            return instance;
        }
    }

    public static Singleton getInstance() {
        return MyEnumSingleton.singletonFactory.getInstance();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                System.out.println(ClassFactory.getInstance().hashCode());
            }).start();
        }
    }
}

class Singleton {
    public Singleton() {
    }
}
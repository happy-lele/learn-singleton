package com.le.jvm.design;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @Author happy_le
 * @date 2020/10/23 20:17
 */
public class MySingleton implements Serializable {

    private static final long serialVersionUID = 1L;

    private static boolean flag = false;

    private MySingleton(){
        // 防止反射攻击
        synchronized(MySingleton.class) {
            if(flag == false) {
                flag = !flag;
            }
            else {
                throw new RuntimeException("单例模式被侵犯！");
            }
        }
    }

    //内部类
    private static class MySingletonHandler {
        private static MySingleton instance = new MySingleton();
    }

    public static MySingleton getInstance() {
        return MySingletonHandler.instance;
    }

    //该方法在反序列化时会被调用，该方法不是接口定义的方法，有点儿约定俗成的感觉
    protected Object readResolve() throws ObjectStreamException {
        System.out.println("调用了readResolve方法！");
        return MySingletonHandler.instance;
    }
}
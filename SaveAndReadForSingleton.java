package com.le.jvm.design;

import java.io.*;

/**
 * @Author happy_le
 * @date 2020/10/23 20:16
 * 静态内部类虽然保证了单例在多线程并发下的线程安全性，但是在遇到序列化对象时，
 * 默认的方式运行得到的结果就是多例的,解决办法就是在反序列化的过程中使用readResolve()方法
 */
public class SaveAndReadForSingleton {

    public static void main(String[] args) {
        MySingleton singleton = MySingleton.getInstance();

        File file = new File("MySingleton.txt");

        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(singleton);
            fos.close();
            oos.close();
            System.out.println(singleton.hashCode());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            MySingleton rSingleton = (MySingleton) ois.readObject();
            fis.close();
            ois.close();
            System.out.println(rSingleton.hashCode());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

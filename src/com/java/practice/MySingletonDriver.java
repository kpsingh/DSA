package com.java.practice;

/*
https://www.baeldung.com/java-singleton
https://www.geeksforgeeks.org/singleton-class-java/

A private constructor
A static field containing its only instance
A static factory method for obtaining the instance
 */

public class MySingletonDriver {

    public static void main(String[] args) {
        MySingleton ms1 = MySingleton.getInstance();
        MySingleton ms2 = MySingleton.getInstance();
        MySingleton ms3 = MySingleton.getInstance();

        System.out.println(ms1.getInfo());
        System.out.println("************");

        ms2.setInfo("I'm a modified info");

        System.out.println(ms1.getInfo());
        System.out.println(ms2.getInfo());

    }

}

class MySingleton {
    //
    private static MySingleton INSTANCE;
    private String info;

    private MySingleton() {
        info = "I'm a singleton instance";
    }

    // synchronized to make it thread safe in case of multi threded environment
    public synchronized static MySingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MySingleton();
        }
        return INSTANCE;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
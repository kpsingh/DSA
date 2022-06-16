package com.java.practice;
/*
https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html

https://medium.com/javarevisited/confused-with-immutable-class-in-java-why-string-is-immutable-get-it-clear-7edbee856c9

A Strategy for Defining Immutable Objects
The following rules define a simple strategy for creating immutable objects. Not all classes documented as "immutable" follow
these rules. This does not necessarily mean the creators of these classes were sloppy — they may have good reason for
believing that instances of their classes never change after construction. However, such strategies require sophisticated
analysis and are not for beginners.

1. Don't provide "setter" methods — methods that modify fields or objects referred to by fields.
2. Make all fields final and private.
3. Don't allow subclasses to override methods. The simplest way to do this is to declare the class as final.
    A more sophisticated approach is to make the constructor private and construct instances in factory methods.
4. If the instance fields include references to mutable objects, don't allow those objects to be changed:
    a. Don't provide methods that modify the mutable objects.
    b. Don't share references to the mutable objects. Never store references to external, mutable objects passed to the constructor;
       if necessary, create copies, and store references to the copies. Similarly, create copies of your internal mutable objects
when necessary to avoid returning the originals in your methods.
 */


public class MyImmutableDriver {
    public static void main(String[] args) {
        Student student = new Student(32, "Krishna");

        MyImmutable immutable = new MyImmutable(121,"CSE",student);

        System.out.println(immutable);

        immutable.getDesc().setAge(55);
        student.setName("temp");

        System.out.println(immutable);

    }
}


// This is immutable class.
final class MyImmutable {
    final private int id;
    final private String branch;
    final private Student desc;

    MyImmutable(int id, String branch, Student desc) {
        this.id = id;
        this.branch = branch;

        // we should not do this otherwise object can be modified by reference.
        //this.desc = desc;

        this.desc = new Student(desc.getAge(), desc.getName());
    }

    public int getId() {
        return id;
    }

    public String getBranch() {
        return branch;
    }

    public Student getDesc() {
        // We should not return like this, otherwise by reference it can be modified.
        // return desc;

        return new Student(desc.getAge(), desc.getName());
    }

    @Override
    public String toString() {
        return "MyImmutable{" +
                "id=" + id +
                ", branch='" + branch + '\'' +
                ", desc=" + desc +
                '}';
    }
}


// This is a mutable class.
class Student {
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

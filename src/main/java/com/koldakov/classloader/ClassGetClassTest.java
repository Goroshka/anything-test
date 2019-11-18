package com.koldakov.classloader;

import java.util.Arrays;

public class ClassGetClassTest {

    public static void main(String[] args) {
        Parent parent = new Parent();
        Parent child = new Child();
        Parent childParent = new Child();

        System.out.println("Parent.class = " + Parent.class);
        System.out.println("Child.class = " + Child.class);

        System.out.println("parent.getClass() = " + parent.getClass());
        System.out.println("child.getClass() = " + child.getClass());
        System.out.println("childParent.getClass() = " + childParent.getClass());
    }
}

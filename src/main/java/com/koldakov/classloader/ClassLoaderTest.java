package com.koldakov.classloader;

import com.sun.javafx.util.Logging;
import org.springframework.context.ApplicationContext;
import sun.awt.HKSCS;

import java.util.List;

public class ClassLoaderTest {

    public static void main(String[] args) {
        System.out.println("Class loader of List: " + List.class.getClassLoader());

        System.out.println("Class loader of com.sun.javafx.util.Logging: " + Logging.class.getClassLoader());

        System.out.println("Class loader of this class: " + ClassLoaderTest.class.getClassLoader());

        System.out.println("Class loader of org.springframework.context.ApplicationContext: " + ApplicationContext.class.getClassLoader());

        System.out.println("Class loader of sun.awt.HKSCS: " + HKSCS.class.getClassLoader());
    }
}

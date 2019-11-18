package com.koldakov.serialization;

import java.io.*;

public class DeserializationUtil {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream("src/main/resources/classForSerialization.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            ClassForSerialization classForSerialization = (ClassForSerialization) ois.readObject();
            System.out.println("Name = " + classForSerialization.getName());
            System.out.println("Password = " + classForSerialization.getPassword());
            System.out.println("Address = " + classForSerialization.getAddress());
        }
    }
}

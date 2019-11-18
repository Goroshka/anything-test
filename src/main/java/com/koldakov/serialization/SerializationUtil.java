package com.koldakov.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationUtil {

    public static void main(String[] args) throws IOException {
        ClassForSerialization classForSerialization = new ClassForSerialization();
        classForSerialization.setName("Ant");
        classForSerialization.setPassword("qwer");

        try (FileOutputStream fos = new FileOutputStream("src/main/resources/classForSerialization.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(classForSerialization);
        }
    }
}

package com.koldakov.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class KryoSample {

    public static void main(String[] args) throws FileNotFoundException {
        Kryo kryo = new Kryo();
        kryo.register(ClassForKryo.class);
        kryo.register(SubClassForKryo.class);

        ClassForKryo classForKryo = new ClassForKryo();
        classForKryo.val = "Q";
        classForKryo.subClassForKryo = new SubClassForKryo();
        classForKryo.subClassForKryo.val = 123;

        Output output = new Output(new FileOutputStream("file.kryo"));
        kryo.writeObject(output, classForKryo);
        output.close();

        Input input = new Input(new FileInputStream("file.kryo"));
        ClassForKryo classForKryo2 = kryo.readObject(input, ClassForKryo.class);
        input.close();

        System.out.println(classForKryo2.val);
        System.out.println(classForKryo2.subClassForKryo.val);
    }
}

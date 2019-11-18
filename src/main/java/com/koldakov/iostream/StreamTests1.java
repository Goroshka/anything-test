package com.koldakov.iostream;

import java.io.*;

public class StreamTests1 {
    public static void main(String[] args) {
        String path = "src/main/resources/";
        String inFileName = path + "Input.txt";

        copyBytes(inFileName, path);
        copyChars(inFileName, path);
        copyBufferedChars(inFileName, path);
    }

    private static void copyBytes(String inFileName, String outPath) {
        try (FileInputStream inputStream = new FileInputStream(inFileName);
             FileOutputStream outputStream = new FileOutputStream(outPath + "ByteOutput.txt")) {

            int b;
            while ((b = inputStream.read()) != -1) {
                outputStream.write(b);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void copyChars(String inFileName, String outPath) {

        try (FileReader reader = new FileReader(inFileName);
             FileWriter writer = new FileWriter(outPath + "CharOutput.txt")) {

            int b;
            while ((b = reader.read()) != -1) {
                writer.write(b);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void copyBufferedChars(String inFileName, String outPath) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inFileName));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outPath + "BufferedCharOutput.txt"))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

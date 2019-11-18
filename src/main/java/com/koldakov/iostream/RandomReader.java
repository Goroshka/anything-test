package com.koldakov.iostream;

import java.io.*;

public class RandomReader {

    public static void main(String[] args) throws IOException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(new File("src/main/resources/InputRandomReader.txt"),"r")) {
            long fileLength = randomAccessFile.length();

            randomAccessFile.seek(fileLength - Math.min(fileLength, 30));

            byte[] bytes = new byte[500];
            randomAccessFile.read(bytes, 0, 500);

            String lastLine = null;
            try (InputStreamReader is = new InputStreamReader(new ByteArrayInputStream(bytes), "UTF-8");
                 BufferedReader br = new BufferedReader(is)) {
                String line;
                while ((line = br.readLine()) != null) {
                    lastLine = line;
                }
            }
            System.out.println(lastLine);
        }
    }
}

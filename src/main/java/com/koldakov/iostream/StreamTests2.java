package com.koldakov.iostream;

import java.io.*;

public class StreamTests2 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new StringReader("qwer\nasdf\nzxcv"));
             PrintWriter printWriter = new PrintWriter(new StringWriter())) {

            String string;
            while ((string = bufferedReader.readLine()) != null) {
                printWriter.print(string);
            }

        }
    }
}

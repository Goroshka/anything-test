package com.koldakov.iostream;

import java.io.*;

public class LastBytesReader {

    /**
     * Effective reading of last bytes of file
     *
     * @param file - file to read
     * @param bytesCount - number of bytes to be read
     * @return InputStream of bytes that were read
     * @throws IOException in case of file not found etc.
     */
    public static InputStream readLastBytes(File file, int bytesCount) throws IOException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file,"r")) {
            long fileLength = randomAccessFile.length();
            int bytesToRead = (int) Math.min(fileLength, bytesCount);

            randomAccessFile.seek(fileLength - bytesToRead);
            byte[] bytes = new byte[bytesToRead];
            randomAccessFile.read(bytes);
            return new ByteArrayInputStream(bytes);
        }
    }
}

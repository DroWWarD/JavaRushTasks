package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "C:/tmp/result.txt";
    FileOutputStream fileOut;

    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
        this.fileOut = fileOutputStream;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));

    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        fileOut.write(b, off, len);
    }

    @Override
    public void write(byte[] b) throws IOException {
        fileOut.write(b);
    }

    @Override
    public void write(int b) throws IOException {
        fileOut.write(b);
    }

    @Override
    public void flush() throws IOException {
        fileOut.flush();
    }

    @Override
    public void close() throws IOException {
        fileOut.flush();
        fileOut.write(("JavaRush © All rights reserved.").getBytes(StandardCharsets.UTF_8));
        fileOut.close();
    }
}

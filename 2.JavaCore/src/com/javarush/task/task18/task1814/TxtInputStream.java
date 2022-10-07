package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {
    FileInputStream fileIn;
    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        this.fileIn = new FileInputStream(fileName);
        if (fileName.lastIndexOf(".txt") != fileName.length()-4){
            super.close();
            throw new UnsupportedFileNameException();

        }
    }

    public static void main(String[] args) {

    }

    @Override
    public void close() throws IOException {
        fileIn.close();
        super.close();
    }
}


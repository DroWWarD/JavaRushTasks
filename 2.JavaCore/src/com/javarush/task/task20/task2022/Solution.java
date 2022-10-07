package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
//        out.defaultWriteObject();
        out.writeObject(this.fileName);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        this.fileName = (String)in.readObject();

        in.defaultReadObject();
        this.stream = new FileOutputStream(this.fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Solution solution1 = new Solution("C:\\JavaTest\\test1.txt");
        solution1.writeObject("какая то строка солутион1");
        solution1.writeObject("Можно просто добавить строку");
        FileOutputStream fos = new FileOutputStream("C:\\JavaTest\\test2.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(solution1);
        oos.close();
        fos.close();
        FileInputStream fis = new FileInputStream("C:\\JavaTest\\test2.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Solution solution2 = (Solution) ois.readObject();
        solution2.writeObject("Еще какая то строка, но уже после десериализации потока FOS");
        fis.close();
        ois.close();


    }
}

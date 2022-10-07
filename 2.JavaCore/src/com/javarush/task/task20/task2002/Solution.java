package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            String yourFile = "C:\\JavaTest\\test1.txt";
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User sidorov = new User();
            sidorov.setFirstName("Иван");
            sidorov.setLastName("Сидоров");
            sidorov.setBirthDate(new GregorianCalendar(1995 , 5, 10).getTime());
            sidorov.setMale(true);
            sidorov.setCountry(User.Country.RUSSIA);

            User saloedov = new User();
            saloedov.setFirstName("Герасим");
            saloedov.setLastName("Салоедов");
            saloedov.setBirthDate(new GregorianCalendar(1965 , 3, 5).getTime());
            saloedov.setMale(true);
            saloedov.setCountry(User.Country.UKRAINE);

            User chernov = new User();
            chernov.setFirstName("Дмитрий");
            chernov.setLastName("Чернов");
            chernov.setBirthDate(new GregorianCalendar(1988 , 7, 17).getTime());
            chernov.setMale(true);
            chernov.setCountry(User.Country.OTHER);

            javaRush.users.add(sidorov);
            javaRush.users.add(saloedov);
            javaRush.users.add(chernov);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(loadedObject.equals(javaRush));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter pw = new PrintWriter(outputStream);
            if (!this.users.isEmpty()){
//                pw.println("true");
//                pw.flush();
                for (User user:this.users) {
                    pw.print(user.getFirstName() + "/");
                    pw.print(user.getLastName()+"/");
                    pw.print(user.getBirthDate().getTime()+"/");
                    pw.print(user.isMale()+"/");
                    pw.print(user.getCountry()+"\n");
                    pw.flush();
                }
            }
            pw.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
//            if (bf.readLine().equals("true")){
                String line;
                while ((line= bf.readLine())!=null){
                    String[] parsedLine = line.split("/");
                    if (parsedLine.length<5) break;
                    User user = new User();
                    user.setFirstName(parsedLine[0]);
                    user.setLastName(parsedLine[1]);
                    user.setBirthDate(new Date(Long.parseLong(parsedLine[2])));
                    user.setMale(Boolean.parseBoolean(parsedLine[3]));
                    switch (parsedLine[4]){
                        case "RUSSIA" : user.setCountry(User.Country.RUSSIA);
                            break;
                        case "UKRAINE" : user.setCountry(User.Country.UKRAINE);
                            break;
                        default: user.setCountry(User.Country.OTHER);
                            break;
                    }
                    this.users.add(user);
                }
//            }
            bf.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}

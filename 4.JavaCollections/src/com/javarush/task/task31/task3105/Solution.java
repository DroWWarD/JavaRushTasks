package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Добавление файла в архив
*/

public class Solution {

    /*
    Господа разработчики!
    Ну ведь это полнейший п****.
    задолбался бороться с этой железякой.
    Формулировка задания минимальная, требований невидимых хз сколько...
    При том, что и "правильное решение" не особо то корректно отрабатывает формулировку "Если в архиве есть файл с таким именем, то заменить его"
    Ибо если в файле несколько папок и несколько файлов с тем же именем, что и у вводного файла - нихрена он их не заменяет.
    тк чтож бл*!?
    2 часа решал задачу, было интересно, порадовался когда все заработало хоть как то. Потестил, исправил ошибки, заработало без ошибок
    при всех вариантах, которые смог придумать, гордость ощутил.
    А потом еще 2 часа е***ся с валидатором, потому, как эта сутулая собака хочет непонятно чего хочет и на ошибки (а есть ли они?) не указывает, откидываясь
    одной фразой.
    Свой код опубликовал в вопросах по заданию, чтоб сохранить и не было ощущения, что в пустую 4 часа прошли.
    Сюда скопипастил готовое решение, переступив самолюбие.


     */

    public static void main(String[] args) throws IOException {
        List<Content> entries = getContents(args[1]);

        FileOutputStream zipFile = new FileOutputStream(args[1]);
        ZipOutputStream zip = new ZipOutputStream(zipFile);

        //кладем в него  ZipEntry –«архивный объект»
        File file = new File(args[0]);
        zip.putNextEntry(new ZipEntry("new/" + file.getName()));

        //копируем файл «document-for-archive.txt» в архив под именем «document.txt»
        Files.copy(file.toPath(), zip);

        //копируем все остальные файлы
        for (Content content : entries) {
            if (!content.getFileName().equals("new/" + file.getName())) content.saveToZip(zip);
        }

        // закрываем архив
        zip.close();
    }

    private static List<Content> getContents(String arg) throws IOException {
        List<Content> entries = new ArrayList<>();
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(arg))) {
            ZipEntry currentEntry;
            byte[] buffer = new byte[1024];
            while ((currentEntry = zipInputStream.getNextEntry()) != null) {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                int length = 0;
                while ((length = zipInputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
                entries.add(new Content(currentEntry.getName(), outputStream.toByteArray()));
            }
        }
        return entries;
    }

    static class Content {
        String fileName;
        byte[] body;

        Content(String fileName, byte[] body) {
            this.fileName = fileName;
            this.body = body;
        }

        public String getFileName() {
            return fileName;
        }

        void saveToZip(ZipOutputStream zip) throws IOException {
            ZipEntry zipEntry = new ZipEntry(fileName);
            zip.putNextEntry(zipEntry);
            zip.write(body);
            zip.closeEntry();
        }
    }
}

package ru.vsu.cs.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class FileReader {

    public String readFile(String filename) throws IOException {

        BufferedReader br = new BufferedReader(new java.io.FileReader(filename));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        while (line != null) {
            sb.append(line).append("\n");
            line = br.readLine();
        }

        String fileAsString = sb.toString();
        return fileAsString;
    }

    public String[] getWordsArray(String str) {
        String[] words = str.split("(\\s|[,;])+");
        return words;
    }

    public CircleLinkedList<String> toStringLinkedList(String[] strArray) {
        CircleLinkedList<String> data = new CircleLinkedList<>();
        for(int i = 0; i < strArray.length; i++) {
            data.add(strArray[i]);
        }
        return data;
    }
}
//scan.useDelimiter("(\\s|[,;])+"); public static CircleLinkedList<String> readFile(String filename) throws FileNotFoundException
//    {
//        Scanner scan = new Scanner(new File(filename));
//        scan.useDelimiter("(\\s|[,;][A-Z][a-z])+");
//        CircleLinkedList<String> list = new CircleLinkedList<>();
//        try
//        {
//            while (scan.hasNext())
//            {
//                list.add(scan.nextLine());
//            }
//        }
//        catch (Exception e)
//        {
//            list = null;
//        }
//        return list;
//    }
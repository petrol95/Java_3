package Lesson_3.HomeWork3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class CombineFiles {

    public static void main(String[] args) throws IOException {
        SequenceInputStream seq = null;
        FileOutputStream out = null;

        ArrayList<InputStream> al = new ArrayList<>();

        al.add(new FileInputStream("file1.txt"));
        al.add(new FileInputStream("file2.txt"));
        al.add(new FileInputStream("file3.txt"));
        al.add(new FileInputStream("file4.txt"));
        al.add(new FileInputStream("file5.txt"));

        Enumeration<InputStream> en = Collections.enumeration(al);

        try {
            seq = new SequenceInputStream(en);
            out = new FileOutputStream("output.txt");

            int rb;
            while ((rb = seq.read()) != -1) {
                out.write(rb);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            seq.close();
        }
    }
}
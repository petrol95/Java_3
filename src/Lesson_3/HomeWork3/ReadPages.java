package Lesson_3.HomeWork3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadPages {

    private static final int PAGE_SIZE = 1800;
    private static final int NUMBER_OF_PAGES = 1800;

    public static void main(String[] args){

//        new Thread(() -> {
//            try(BufferedWriter bw = Files.newBufferedWriter(Paths.get("pages.txt")))
//            {
//                for (int i = 0; i < NUMBER_OF_PAGES; i++) {
//                    for (int j = 0; j < PAGE_SIZE; j++) {
//                        bw.write(Integer.toString(i));
//                    }
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }).start();

        new Thread(() -> {
            try (RandomAccessFile raf = new RandomAccessFile( "pages.txt" , "r" )) {
                for (int i = 0; i < NUMBER_OF_PAGES; i++) {
                    for (int j = 0; j < PAGE_SIZE; j++) {
                        raf.seek(PAGE_SIZE * i + j);
                        System.out.print((char)raf.read());
                    }
                    System.out.println();
                    System.out.println("Page " + (i + 1));
                    System.out.println();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

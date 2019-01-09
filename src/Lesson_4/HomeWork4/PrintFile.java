package Lesson_4.HomeWork4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PrintFile {

    private Object mon = new Object();


    public static void main(String[] args) {

        PrintFile pf = new PrintFile();
        pf.writeToFile();
    }

    private void writeToFile() {

        new Thread(() -> printString("1111111111")).start();
        new Thread(() -> printString("2222222222")).start();
        new Thread(() -> printString("3333333333")).start();

    }

    private synchronized void printString(String s) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("outfile.txt", true))) {
            for (int i = 0; i < 10; i++) {
                try {
                    bw.write(s);
                    bw.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

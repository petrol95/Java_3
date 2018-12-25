package Lesson_3.HomeWork3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class ReadByteArray {
    public static final String FILE_NAME = "arr.txt";

    public static void main(String[] args) throws IOException {

        byte[] br = new byte[50];

        System.out.println("Task 1");
        byte[] bytes = Files.readAllBytes(Paths.get(FILE_NAME));
        System.out.println(Arrays.toString(bytes));

    }
}





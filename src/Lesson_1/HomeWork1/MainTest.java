package Lesson_1.HomeWork1;

import java.util.ArrayList;

public class MainTest {

    public static void main(String[] args) {

        Integer[] ints = {1, 2, 3, 4, 5};
        String[] strings = {"a", "b", "c", "d"};

        // Task 1
        System.out.println("Task 1");
        SwapElements<Integer> se1 = new SwapElements<>();
        se1.swap(ints, 0, 3);
        se1.display(ints);

        SwapElements<String> se2 = new SwapElements<>();
        se2.swap(strings, 1, 2);
        se2.display(strings);

        // Task 2
        System.out.println("Task 2");
        TransformArray<Integer> ta1 = new TransformArray<>();
        ArrayList al1 = ta1.transform(ints);
        System.out.println(al1.getClass().getName() + ": " + al1);


        TransformArray<String> ta2 = new TransformArray<>();
        ArrayList al2 = ta2.transform(strings);
        System.out.println(al2.getClass().getName() + ": " + al2);

    }
}


package Lesson_8;

import java.util.ArrayList;
import java.util.List;

public class Student implements Gamer, Waiter {

    private static int b = 777;

    static {
        System.out.println(b);
        b = 888;
        System.out.println(b);
    }


    private int a = 5;

    {
        System.out.println(a);
        a = 3;
        System.out.println(a);

        class A {
            private int c;
        }

        A aaa = new A();
        aaa.c = 8;
    }

    public Student() {
        a = 7;
        System.out.println(a);
    }

    public static void main(String[] args) {
        new Student();
//        for (int i = 0; i < 5; i++) {
//            label:
//            for (int j = 0; j < 5; j++) {
//                System.out.println("i = " + i + "; j = " + j);
//                if (j == 2) {
//                    break label;
//                }
//            }
//        }
//        List collection = new ArrayList();
//        collection.add("str");
//        String o = (String) collection.get(0);
    }

    @Override
    public void work() {
//        while (true) {
//
//        }


    }
}

package Lesson_1.HomeWork1.Fruits;

import java.util.ArrayList;

public class MainClass {

    public static void main(String[] args) {

        Apple ap1 = new Apple();
        Apple ap2 = new Apple();
        Apple ap3 = new Apple();
        Apple ap4 = new Apple();
        Apple ap5 = new Apple();
        Orange or1 = new Orange();
        Orange or2 = new Orange();
        Orange or3 = new Orange();

        ArrayList<Apple> apples = new ArrayList<>();
        ArrayList<Apple> apples2 = new ArrayList<>();
        ArrayList<Orange> oranges = new ArrayList<>();

        Box appleBox = new Box(apples);
        Box appleBox2 = new Box(apples2);
        Box orangeBox = new Box(oranges);

        appleBox.add(ap1);
        appleBox.add(ap2);
        appleBox.add(ap3);
        orangeBox.add(or1);
        orangeBox.add(or2);
        appleBox2.add(ap4);
        appleBox2.add(ap5);
//        appleBox2.add(or3);


        System.out.println("Weight of boxes:");
        System.out.println("appleBox = " + appleBox.getWeight());
        System.out.println("orangeBox = " + orangeBox.getWeight());
        System.out.println("appleBox2 = " + appleBox2.getWeight());

        System.out.println("compare appleBox & orangeBox: " + appleBox.compare(orangeBox));
        System.out.println("compare appleBox & appleBox2: " + appleBox.compare(appleBox2));

        System.out.println("put appleBox into orangeBox: " + appleBox.emptyBox(orangeBox));
        System.out.println("put appleBox into appleBox2: " + appleBox.emptyBox(appleBox2));

        appleBox.getFruits().add(or1);


    }
}

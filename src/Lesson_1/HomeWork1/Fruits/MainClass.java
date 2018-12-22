package Lesson_1.HomeWork1.Fruits;

import java.util.ArrayList;

public class MainClass {

    public static void main(String[] args) {

        ArrayList<Apple> apples = new ArrayList<>();
        ArrayList<Apple> apples2 = new ArrayList<>();
        ArrayList<Orange> oranges = new ArrayList<>();

        Box<Apple> appleBox = new Box(apples);
        Box<Apple> appleBox2 = new Box(apples2);
        Box<Orange> orangeBox = new Box(oranges);

        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        appleBox2.add(new Apple());
        appleBox2.add(new Apple());
//        appleBox2.add(new Orange());

        System.out.println("Weight of boxes:");
        System.out.println("appleBox = " + appleBox.getWeight());
        System.out.println("orangeBox = " + orangeBox.getWeight());
        System.out.println("appleBox2 = " + appleBox2.getWeight());

        System.out.println("\ncompare appleBox & orangeBox: " + appleBox.compare(orangeBox));
        System.out.println("compare appleBox & appleBox2: " + appleBox.compare(appleBox2));
        System.out.println("compare appleBox2 & appleBox: " + appleBox2.compare(appleBox));

//        System.out.println("put appleBox into orangeBox:");
//        appleBox.emptyBox(orangeBox);
        System.out.println("\nput appleBox into appleBox2:");
        appleBox.emptyBox(appleBox2);
        System.out.println("Weight of applebox: " + appleBox.getWeight());
        System.out.println("Weight of applebox2: " + appleBox2.getWeight());

        System.out.println("\nput appleBox2 into appleBox:");
        appleBox2.emptyBox(appleBox);
        System.out.println("Weight of applebox: " + appleBox.getWeight());
        System.out.println("Weight of applebox2: " + appleBox2.getWeight());

    }
}

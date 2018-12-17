package Lesson_1.HomeWork1.Fruits;

import java.util.ArrayList;

public class Box<E extends Fruit> {

    private ArrayList<E> fruits;
    private float weight;

    public Box(ArrayList<E> fruits) {
        this.fruits = fruits;
        this.weight = 0;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public ArrayList<E> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<E> fruits) {
        this.fruits = fruits;
    }

    public void add(E fruit) {
        // allow add the fruit only into appropriate box
        if (!this.getFruits().isEmpty() && !this.getFruits().get(0).getClass().equals(fruit.getClass()))
        {
            System.out.println("You are not allowed to mix different fruits");;
        } else {
            this.getFruits().add(fruit);
            this.setWeight(this.getWeight() + fruit.getWeight());
        }
    }

    public boolean compare(Box box) {
        return this.weight == box.weight;
    }

    public boolean emptyBox(Box box) {
        // if the box is not empty, assume box type == type of first fruit
        if (!this.getFruits().isEmpty() &&
                !this.getFruits().get(0).getClass().equals(box.getFruits().get(0).getClass()))

        {
            System.out.println("You are not allowed to mix different fruits");
            return false;
        } else {
            box.setWeight(box.getWeight() + this.getWeight());
            this.setWeight(0);
            return true;
        }

    }

}

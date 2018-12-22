package Lesson_1.HomeWork1.Fruits;

import java.util.ArrayList;

public class Box<E extends Fruit> {

    private ArrayList<E> fruits;
    private float weight;

    public Box (ArrayList<E> fruits) {
        this.fruits = fruits;
        this.weight = 0;
    }

    public float getWeight() {
        float weight = 0;
        for (E fruit : this.fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public ArrayList<E> getFruits() {
        return fruits;
    }

    public void add(E fruit) {
        this.getFruits().add(fruit);
    }

    public boolean compare(Box box) {
        return Math.abs(this.getWeight() - box.getWeight()) < 0.0001;
    }

    public void emptyBox(Box<E> box) {
        box.getFruits().addAll(this.getFruits());
        this.getFruits().clear();
        this.setWeight(0);
    }

}

package Lesson_7.reflection;

import java.io.Serializable;

public final class Cat extends SuperCat implements ICat, Serializable {


    public String color;
    private int age = 10;

    private final boolean catty = true;


    public Cat(String name, String color, int age) {
        super(name);
        this.color = color;
        this.age = age;
    }

    public Cat(String name) {
        super(name);
    }

    public Cat(String name, int age) {
        super(name);
        this.age = age;
    }

    @Override
    public void meow(int db) {
        System.out.println(name + ": meow - " + db + " dB");
    }

    private void jump() {
        System.out.println(name + ": jump");
    }


    @Override
    public String toString() {
        return "reflection.reflection.Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }



}

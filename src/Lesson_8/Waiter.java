package Lesson_8;

public interface Waiter {

    default void work() {
        System.out.println("Waiter is working");
    }
}

package Lesson_1.generics;

@FunctionalInterface
public interface Transformer<T, R> {

    R transform(T value);
}
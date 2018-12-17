package Lesson_1.generics.utils;

import Lesson_1.generics.Transformer;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtils {

    public static <T, R> List<R> transform(List<T> values, Transformer<T, R> transformer) {
        List<R> result = new ArrayList<>();
        for (T value : values) {
            result.add(transformer.transform(value));
        }

        return result;
    }

}
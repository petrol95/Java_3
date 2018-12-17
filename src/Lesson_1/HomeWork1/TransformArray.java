package Lesson_1.HomeWork1;

import java.util.ArrayList;

public class TransformArray<T> {

    // Method to transform array into ArrayList
    public <T> ArrayList transform (T[] data) {
        ArrayList al = new ArrayList();
        for (T datum : data) {
            al.add(datum);
        }
        return al;
    }

}


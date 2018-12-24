package Lesson_1.HomeWork1;

public class SwapElements<T> {

    // Method to swap array elements
    public <T> void swap (T[] data, int i, int j) {
        T temp;
        temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public <T> void display (T[] data) {
        System.out.print("[ ");
        for (T datum : data) {
            System.out.print(datum + ", ");
        }
        System.out.println("]\n");

    }

}



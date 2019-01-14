package Lesson_6.HomeWork6;

import java.util.ArrayList;

public class CheckArray {

    public boolean checkArr(ArrayList<Integer> al) {
        if (!al.contains(1) && !al.contains(4)) {
            return false;
        }
        return true;
    }
}
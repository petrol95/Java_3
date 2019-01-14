package Lesson_6.HomeWork6;

import java.util.ArrayList;

public class ReturnArray4 {

    public ArrayList<Integer> returnArr(ArrayList<Integer> al) {
        ArrayList<Integer> res = new ArrayList<>();
        RuntimeException exception = new RuntimeException();

        if (al.isEmpty() || !al.contains(4)) {
            throw exception;
        }

        int k = 0;
        for (int i = al.size() - 1; i >= 0; i--) {
            if (al.get(i) == 4) {
                k = i;
                break;
            }
        }
        for (int j = k + 1; j < al.size(); j++) {
            res.add(al.get(j));
        }
        return res;
    }
}
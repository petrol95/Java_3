package Lesson_6.HomeWork6;

import java.util.ArrayList;

public class ReturnArray4 {

    public static ArrayList<Integer> returnArr(ArrayList<Integer> al) {
        ArrayList<Integer> res = new ArrayList<>();

//        if (al.isEmpty() || !al.contains(4)) {
//            throw RuntimeException;
//        }

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

//    public static void main(String[] args) {
//        ArrayList<Integer> arr = new ArrayList<>();
//        arr.add(1);
//        arr.add(2);
//        arr.add(4);
//        arr.add(4);
//        arr.add(2);
//        arr.add(3);
//        arr.add(4);
//        arr.add(1);
//        arr.add(7);
//        ArrayList<Integer> res = new ArrayList<>();
//        res = returnArr(arr);
//        System.out.println(res);
//
//    }
}


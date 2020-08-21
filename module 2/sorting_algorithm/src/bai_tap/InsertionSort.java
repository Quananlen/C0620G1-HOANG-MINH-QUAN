package bai_tap;

import java.util.ArrayList;

public class InsertionSort {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(4);
        arr.add(3);
        arr.add(2);
        arr.add(10);
        arr.add(1);
        arr.add(5);
        arr.add(6);
        System.out.println(arr);
        insertionSort(arr);
    }

    public static void insertionSort(ArrayList<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            int key = arr.get(i);
            System.out.println("key " + key);
            int currentMaxIndex = i - 1;
            while (currentMaxIndex > -1) {
                int comparedNum = arr.get(currentMaxIndex);
                if (key < comparedNum) {
                    System.out.println(key + " < " + comparedNum);
                    currentMaxIndex--;
                } else {
                    System.out.println(key + " > " + comparedNum);
                    System.out.println("Move " + key + " to position after " + comparedNum);
                    break;
                }
            }
            if(currentMaxIndex == -1) System.out.println("Move " + key + " to first position");
            arr.add(currentMaxIndex + 1, key);
            arr.remove(i + 1);
            System.out.println(arr);
        }
    }
}


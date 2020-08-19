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
            Integer selectedNum = arr.get(i);
            System.out.println("key " + selectedNum);
            int currentMaxIndex = i - 1;
            while (currentMaxIndex > -1) {
                int comparedNum = arr.get(currentMaxIndex);
                if (selectedNum < comparedNum) {
                    System.out.println(selectedNum + " < " + comparedNum);
                    currentMaxIndex--;
                } else {
                    System.out.println(selectedNum + " > " + comparedNum);
                    break;
                }
            }
            arr.add(currentMaxIndex + 1, selectedNum);
            arr.remove(i + 1);
            System.out.println(arr);
        }
    }
}


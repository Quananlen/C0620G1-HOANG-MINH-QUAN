package bai_tap;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<Character, Integer> treeMap = new TreeMap();
        String str = "This is a tree map aaa";
        str = str.toUpperCase();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!treeMap.containsKey(c)) {
                treeMap.put(c, 1);
            } else {
                for (Map.Entry<Character, Integer> entry : treeMap.entrySet()) {
                    int value = entry.getValue();
                    if (entry.getKey().equals(c)) {
                        treeMap.put(c, ++value);
                    }
                    break;
                }
            }
        }
        System.out.println(treeMap);
    }
}

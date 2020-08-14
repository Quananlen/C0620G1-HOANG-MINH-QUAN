package bai_tap;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        String str = "abbcccddddeeeee";
        str = str.toUpperCase();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!treeMap.containsKey(c)) treeMap.put(c, 1);
            else {
                int value = treeMap.get(c);
                treeMap.put(c, ++value);
            }
        }
        System.out.println(treeMap);
    }
}

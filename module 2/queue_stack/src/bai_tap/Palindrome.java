package bai_tap;

import java.util.*;
import java.util.Queue;

public class Palindrome {
    public static void main(String[] args) {
        String str = "Able was I ere I saw Elba";
        Stack stack = new Stack();
        Queue queue = new PriorityQueue();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            stack.push(c);
            queue.add(c);
        }
        String result = "Not palindrome";
        for (int i = 0; i < str.length()/2; i++) {
            if (stack.pop().equals(queue.remove())) result = "Palindrome";
        }
        System.out.println(str);
        System.out.println(result);
    }
}

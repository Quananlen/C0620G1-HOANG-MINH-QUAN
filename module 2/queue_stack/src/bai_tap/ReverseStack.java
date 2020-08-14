package bai_tap;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.add(i);
        }
        System.out.println(stack);
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack2.add((stack.pop()));
        }
        System.out.println(stack2);

        String str = "This is a Stack";
        String newStr ="";
        Stack<Character> wStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            wStack.push(str.charAt(i));
        }
        System.out.println(wStack);
        for (int i = 0; i < str.length(); i++) {
            newStr += wStack.pop();
        }
        System.out.println(newStr);
    }
}

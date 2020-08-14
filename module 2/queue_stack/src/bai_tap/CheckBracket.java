package bai_tap;

import java.util.Stack;

public class CheckBracket {
    public static void main(String[] args) {
        String str = "(– b + (b^2 – 4*a*c)^(0.5/ 2*a))";
        System.out.println(checkBracket(str));
    }
    public static boolean checkBracket(String str) {
        Stack<Character> bStack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            boolean isOpenBracket = Character.compare(str.charAt(i), '(') == 0;
            boolean isCloseBracket = Character.compare(str.charAt(i), ')') == 0;
            if (isOpenBracket) bStack.push('(');
            if (isCloseBracket) {
                if (bStack.isEmpty()) {
                    return false;
                }
                bStack.pop();
            }
        }
        return bStack.isEmpty();
    }
}

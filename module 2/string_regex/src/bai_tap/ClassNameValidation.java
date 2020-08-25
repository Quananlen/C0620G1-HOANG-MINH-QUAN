package bai_tap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassNameValidation {
    static final String CLASS_REGEX = "^[ACP]\\d{4}[G-IK-M]$";
    public static void main(String[] args) {
        System.out.println(validateClassName("C0318G"));
        System.out.println(validateClassName("M0318G"));
        System.out.println(validateClassName("P0323A"));

    }
    public static boolean validateClassName(String name) {
        Pattern pattern = Pattern.compile(CLASS_REGEX);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

}

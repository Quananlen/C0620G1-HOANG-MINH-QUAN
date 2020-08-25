package bai_tap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidation {
    static final String PHONE_REGEX = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$";

    public static void main(String[] args) {
        System.out.println(validatePhoneNumber("(84)-(0978489648)"));
        System.out.println(validatePhoneNumber("(a8)-(22222222)"));
    }
    public static boolean validatePhoneNumber(String phone) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}

package common;

import org.apache.commons.lang3.math.NumberUtils;

public class Validate {
    public static String validatePositiveNumber(String num) {
        String message = "OK";
        if (!NumberUtils.isParsable(num)) {
            return "Not OK. Input must be a number";
        }
        double number = Double.parseDouble(num);
        if (number <= 0) {
            return "Not OK. Number must be positive";
        }
        return message;
    }

    public static String validatePhone(String phone) {
        String message = "OK";
        String regex = "^((\\(84\\)\\+)|0)9[01]\\d{7}$";
        if (!phone.matches(regex)) {
            message = "Not OK. Phone format must be 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx.";
        }
        return message;
    }

    public static String validateEmail(String email) {
        String message = "OK";
        String regex = "^\\w+@\\w+\\.\\w{2,3}$";
        if (!email.matches(regex)) {
            message = "Not OK. Email format must be xxx@xxx.xx";
        }
        return message;
    }

    public static String validateName(String name) {
        String message = "OK";
        String regex = "";
        if (name.matches(regex)) {
            message = "Not OK. Name can not be null";
        }
        return message;
    }

    public static String validatePrice(String price) {
        String message = "OK";
        if (!NumberUtils.isParsable(price)) {
            return "Not OK. Input must be a number";
        }
        double number = Double.parseDouble(price);
        if (number <= 10000000) {
            return "Not OK. Number must larger than 10.000.000";
        }
        return message;
    }


}

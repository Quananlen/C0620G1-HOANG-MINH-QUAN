package common;

import org.apache.commons.lang3.math.NumberUtils;

public class Validate {

    public static String validateCustomerID(String name) {
        String message = "OK";
        String regex = "^KH-\\d{4}$";
        if (!name.matches(regex)) {
            message = "Not OK. Customer ID format must be KH-XXXX with X is a number from 0-9.";
        }
        return message;
    }

    public static String validateServiceID(String name) {
        String message = "OK";
        String regex = "^DV-\\d{4}$";
        if (!name.matches(regex)) {
            message = "Not OK. Service ID format must be DV-XXXX with X is a number from 0-9.";
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

    public static String validateIdCard(String id) {
        String message = "OK";
        String regex = "^(\\d{9}|\\d{12})$";
        if (!id.matches(regex)) {
            message = "Not OK. ID Card must have 9 or 12 digit";
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
}

package common;

public class Validate {

    public static String ValidateCustomerID(String name) {
        String message = "OK";
        String regex = "^KH-\\d{4}$";
        if (!name.matches(regex)) {
            message = "Not OK. Customer ID format must be KH-XXXX with X is a number from 0-9.";
        }
        return message;
    }

    public static String ValidateServiceID(String name) {
        String message = "OK";
        String regex = "^DV-\\d{4}$";
        if (!name.matches(regex)) {
            message = "Not OK. Service ID format must be DV-XXXX with X is a number from 0-9.";
        }
        return message;
    }

    public static String ValidatePhone(String phone) {
        String message = "OK";
        String regex = "^((\\(84\\)\\+)|0)9[01]\\d{7}$";
        if (!phone.matches(regex)) {
            message = "Not OK. Phone format must be 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx.";
        }
        return message;
    }
}

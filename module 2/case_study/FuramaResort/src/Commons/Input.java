package Commons;

import Libs.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    public static String inputID(String type) {
        Scanner scanner = new Scanner(System.in);
        final String ID_REGEX = "^SV" + type + "-\\d{4}$";
        String id;
        Matcher matcher;
        do {
            Pattern pattern = Pattern.compile(ID_REGEX);
            System.out.println("Input ID");
            id = scanner.nextLine();
            matcher = pattern.matcher(id);
            if (!matcher.matches())
                System.err.println("Invalid ID. Correct ID: SV" + type + "-XXXX with X is number from 0-9");
        } while (!matcher.matches());
        return id;
    }

    public static int inputFloors() {
        Scanner scanner = new Scanner(System.in);
        int floors;
        do {
            System.out.println("Input floors");
            floors = scanner.nextInt();
            if (floors < 1) System.err.println("Floor must be positive");
        } while (floors < 1);
        return floors;
    }

    public static String inputExclusives() {
        Scanner scanner = new Scanner(System.in);
        final String EXCLUSIVES_REGEX = "^massage$|^karaoke$|^food$|^drink$|^car$";
        String exclusives;
        Matcher matcher;
        do {
            Pattern pattern = Pattern.compile(EXCLUSIVES_REGEX);
            System.out.println("Input other exclusives");
            exclusives = scanner.next();
            matcher = pattern.matcher(exclusives);
            if (!matcher.matches())
                System.err.println("Exclusives must be either massage, karaoke, food, drink or car");
        } while (!matcher.matches());
        return exclusives;
    }

    public static String inputRoomStandard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input room standard");
        String roomStandard = scanner.next();
        roomStandard = roomStandard.toLowerCase();
        roomStandard = Character.toUpperCase(roomStandard.charAt(0)) + roomStandard.substring(1);
        return roomStandard;
    }

    public static double inputPoolArea() {
        Scanner scanner = new Scanner(System.in);
        double poolArea;
        do {
            System.out.println("Input pool area");
            poolArea = scanner.nextDouble();
            if (poolArea <= 30) System.err.println("Pool area must be larger than 30");
        } while (poolArea <= 30);
        return poolArea;
    }

    public static String inputRentType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input rent type");
        String rentType = scanner.next();
        rentType = rentType.toLowerCase();
        rentType = Character.toUpperCase(rentType.charAt(0)) + rentType.substring(1);
        return rentType;
    }

    public static int inputGuestAmount() {
        Scanner scanner = new Scanner(System.in);
        int guestAmount;
        do {
            System.out.println("Input guest amount");
            guestAmount = scanner.nextInt();
        } while (guestAmount < 1 || guestAmount > 19);
        return guestAmount;
    }

    public static double inputRentCost() {
        Scanner scanner = new Scanner(System.in);
        double rentCost;
        do {
            System.out.println("Input Rent Cost");
            rentCost = scanner.nextDouble();
            if (rentCost <= 0) System.err.println("Rent cost must be positive");
        } while (rentCost <= 0);
        return rentCost;
    }

    public static double inputUsageArea() {
        Scanner scanner = new Scanner(System.in);
        double usageArea;
        do {
            System.out.println("Input Usage Area");
            usageArea = scanner.nextDouble();
            if (usageArea <= 30) System.err.println("Usage area must be larger than 30");
        } while (usageArea <= 30);
        return usageArea;
    }

    public static String inputServiceType() {
        Scanner scanner = new Scanner(System.in);
        final String SERVICE_TYPE_REGEX = "^[A-Z][a-z]+$";
        String serviceType;
        Matcher matcher;
        do {
            Pattern pattern = Pattern.compile(SERVICE_TYPE_REGEX);
            System.out.println("Input Service Type");
            serviceType = scanner.nextLine();
            matcher = pattern.matcher(serviceType);
            if (!matcher.matches()) System.err.println("Invalid format. First letter must be Upper Case");
        } while (!matcher.matches());
        return serviceType;
    }

    public static String inputFreeService() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input free service");
        return scanner.next();
    }

    public static String inputName() {
        Scanner scanner = new Scanner(System.in);
        final String NAME_REGEX = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)+$";
        Pattern pattern = Pattern.compile(NAME_REGEX);
        String name;
        try {
            System.out.println("Input name");
            name = scanner.nextLine();
            Matcher matcher = pattern.matcher(name);
            if (!matcher.matches()) throw new NameException();
        } catch (NameException e) {
            System.err.println("Invalid name format");
            return inputName();
        }
        return name;
    }

    public static String inputEmail() {
        Scanner scanner = new Scanner(System.in);
        final String EMAIL_REGEX = "^\\w+@\\w+\\.\\w+$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        String email;
        try {
            System.out.println("Input email");
            email = scanner.nextLine();
            Matcher matcher = pattern.matcher(email);
            if (!matcher.matches()) throw new EmailException();
        } catch (EmailException e) {
            System.err.println("Email must follow format abc@abc.abc");
            return inputEmail();
        }
        return email;
    }

    public static String inputGender() {
        Scanner scanner = new Scanner(System.in);
        String gender;
        try {
            System.out.println("Input gender");
            gender = scanner.nextLine();
            gender = gender.toLowerCase();
            gender = Character.toUpperCase(gender.charAt(0)) + gender.substring(1);
            boolean isCorrect = gender.equals("Male") || gender.equals("Female") || gender.equals("Unknown");
            if (!isCorrect) throw new GenderException();
        } catch (GenderException e) {
            System.err.println("Gender must be either Male, Female or Unknown");
            return inputGender();
        }
        return gender;
    }

    public static String inputIDCard() {
        Scanner scanner = new Scanner(System.in);
        final String ID_REGEX = "\\d{3}(\\s\\d{3}){2}";
        Pattern pattern = Pattern.compile(ID_REGEX);
        String idCard;
        try {
            System.out.println("Input ID card");
            idCard = scanner.nextLine();
            Matcher matcher = pattern.matcher(idCard);
            if (!matcher.matches()) throw new IdCardException();
        } catch (IdCardException e) {
            System.err.println("ID Card must have 9 digits and follow format XXX XXX XXX");
            return inputIDCard();
        }
        return idCard;
    }

    public static String inputBirthday() {
        Scanner scanner = new Scanner(System.in);
        final String BIRTHDAY_REGEX = "^(\\d{2}\\/){2}\\d{4}$";
        Pattern pattern = Pattern.compile(BIRTHDAY_REGEX);
        String birthday;
        int year;
        try {
            System.out.println("Input birthday");
            birthday = scanner.nextLine();
            Matcher matcher = pattern.matcher(birthday);
            if (!matcher.matches()) throw new BirthdayException();

            year = Integer.parseInt(birthday.substring(6));
            boolean isLegit = year > 1900 && year < 2002;
            if (!isLegit) throw new BirthdayException();
        } catch (BirthdayException e) {
            System.err.println("Year must greater than 1900 and smaller than current year by 18 and must follow format dd/mm/yyyy");
            return inputBirthday();
        }
        return birthday;
    }
}

package Controllers;

import Libs.*;
import Models.Customer;
import Models.House;
import Models.Room;
import Models.Villa;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController {

    public static final String ROOM_CSV = "src/Data/Room.csv";
    public static final String HOUSE_CSV = "src/Data/House.csv";
    public static final String VILLA_CSV = "src/Data/Villa.csv";
    public static final String CUSTOMER_CSV = "src/Data/Customer.csv";
    public static final String COMMA = ",";
    public static final char LINE_BREAKER = '\n';

    public static void main(String[] args) {
        try {
            String bd =  inputBirthday();
            System.out.println(bd);
            showInformationCustomers();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayMainMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int menuChoice;
        do {
            System.out.println("1. Add New Services" + "\n" +
                    "2. Show Services" + "\n" +
                    "3. Add New Customers" + "\n" +
                    "4. Show Information of Customer" + "\n" +
                    "5. Add New Blocking" + "\n" +
                    "6. Show Information of Employee" + "\n" +
                    "7. Exit");
            menuChoice = scanner.nextInt();
            switch (menuChoice) {
                case 1:
                    addNewServices();
                    displayMainMenu();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    return;
            }
        } while (menuChoice < 1 || menuChoice > 7);
    }

    public static void addNewServices() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int serviceChoice;
        do {
            System.out.println("1. Add New Villa" + "\n" +
                    "2. Add New House" + "\n" +
                    "3. Add New Room" + "\n" +
                    "4. Back to menu" + "\n" +
                    "5. Exit");
            serviceChoice = scanner.nextInt();
            switch (serviceChoice) {
                case 1:
                    addVilla();
                    break;
                case 2:
                    addHouse();
                    break;
                case 3:
                    addRoom();
                    break;
                case 4:
                    displayMainMenu();
                    break;
                case 5:
                    return;
            }
        } while (serviceChoice < 1 || serviceChoice > 5);
    }

    public static void addVilla() throws IOException {
        String id = inputID("VL");
        String serviceType = inputServiceType();
        double usageArea = inputUsageArea();
        double poolArea = inputPoolArea();
        double rentCost = inputRentCost();
        int guestAmount = inputGuestAmount();
        String rentType = inputRentType();
        String roomStandard = inputRoomStandard();
        int floors = inputFloors();
        String exclusives = inputExclusives();

        Villa villa = new Villa(id, serviceType, usageArea, rentCost, guestAmount, rentType, poolArea, roomStandard, exclusives, floors);
        String[] array = villa.showInfo().split(COMMA);
        writeCSV(array, VILLA_CSV);
    }

    public static void addHouse() throws IOException {
        String id = inputID("HO");
        String serviceType = inputServiceType();
        double usageArea = inputUsageArea();
        double rentCost = inputRentCost();
        int guestAmount = inputGuestAmount();
        String rentType = inputRentType();
        String roomStandard = inputRoomStandard();
        String exclusives = inputExclusives();
        int floors = inputFloors();

        House house = new House(id, serviceType, usageArea, rentCost, guestAmount, rentType, roomStandard, exclusives, floors);
        String[] array = house.showInfo().split(COMMA);
        writeCSV(array, HOUSE_CSV);
    }

    private static void addRoom() throws IOException {
        String id = inputID("RO");
        String serviceType = inputServiceType();
        double usageArea = inputUsageArea();
        double rentCost = inputRentCost();
        int guestAmount = inputGuestAmount();
        String rentType = inputRentType();
        String freeService = inputFreeService();

        Room room = new Room(id, serviceType, usageArea, rentCost, guestAmount, rentType, freeService);
        String[] array = room.showInfo().split(COMMA);
        writeCSV(array, ROOM_CSV);
    }

    private static String inputID(String type) {
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

    private static int inputFloors() {
        Scanner scanner = new Scanner(System.in);
        int floors;
        do {
            System.out.println("Input floors");
            floors = scanner.nextInt();
            if (floors < 1) System.err.println("Floor must be positive");
        } while (floors < 1);
        return floors;
    }

    private static String inputExclusives() {
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

    private static String inputRoomStandard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input room standard");
        String roomStandard = scanner.next();
        roomStandard = roomStandard.toLowerCase();
        roomStandard = Character.toUpperCase(roomStandard.charAt(0)) + roomStandard.substring(1);
        return roomStandard;
    }

    private static double inputPoolArea() {
        Scanner scanner = new Scanner(System.in);
        double poolArea;
        do {
            System.out.println("Input pool area");
            poolArea = scanner.nextDouble();
            if (poolArea <= 30) System.err.println("Pool area must be larger than 30");
        } while (poolArea <= 30);
        return poolArea;
    }

    private static String inputRentType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input rent type");
        String rentType = scanner.next();
        rentType = rentType.toLowerCase();
        rentType = Character.toUpperCase(rentType.charAt(0)) + rentType.substring(1);
        return rentType;
    }

    private static int inputGuestAmount() {
        Scanner scanner = new Scanner(System.in);
        int guestAmount;
        do {
            System.out.println("Input guest amount");
            guestAmount = scanner.nextInt();
        } while (guestAmount < 1 || guestAmount > 19);
        return guestAmount;
    }

    private static double inputRentCost() {
        Scanner scanner = new Scanner(System.in);
        double rentCost;
        do {
            System.out.println("Input Rent Cost");
            rentCost = scanner.nextDouble();
            if (rentCost <= 0) System.err.println("Rent cost must be positive");
        } while (rentCost <= 0);
        return rentCost;
    }

    private static double inputUsageArea() {
        Scanner scanner = new Scanner(System.in);
        double usageArea;
        do {
            System.out.println("Input Usage Area");
            usageArea = scanner.nextDouble();
            if (usageArea <= 30) System.err.println("Usage area must be larger than 30");
        } while (usageArea <= 30);
        return usageArea;
    }

    private static String inputServiceType() {
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

    private static String inputFreeService() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input free service");
        return scanner.next();
    }

    private static void showServices() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Show all Villa" + '\n' +
                    "2. Show all House" + '\n' +
                    "3. Show all Room" + '\n' +
                    "4. Show all Name Villa not Duplicate" + '\n' +
                    "5. Show all Name House not Duplicate" + '\n' +
                    "6. Show all Name Room not Duplicate" + '\n' +
                    "7. Back to menu" + '\n' +
                    "8. Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showAllVilla();
                    showServices();
                    break;
                case 2:
                    showAllHouse();
                    showServices();
                    break;
                case 3:
                    showAllRoom();
                    showServices();
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                    displayMainMenu();
                    break;
                case 8:
                    return;
            }
        } while (choice < 1 || choice > 8);
    }

    public static void showAllVilla() throws IOException {
        FileReader fileReader = new FileReader(VILLA_CSV);
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static void showAllHouse() throws IOException {
        FileReader fileReader = new FileReader(HOUSE_CSV);
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static void showAllRoom() throws IOException {
        FileReader fileReader = new FileReader(ROOM_CSV);
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static void writeCSV(String[] array, String csv) throws IOException {
        try (FileWriter writer = new FileWriter(csv, true)) {
            for (int i = 0; i < array.length; i++) {
                writer.append(array[i]);
                if (i != array.length - 1) writer.append(COMMA);
                else writer.append(LINE_BREAKER);
            }
        }
    }

    public static void addNewCustomer() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String name = inputName();
        String birthday = inputBirthday();
        String gender = inputGender();
        String idCard = inputIDCard();
        System.out.println("Input phone number");
        int phoneNum = scanner.nextInt();
        String email = inputEmail();
        System.out.println("Input address");
        String address = scanner.next();

        Customer customer = new Customer(name, birthday, gender, idCard, phoneNum, email, address);
        String[] array = customer.showInfo().split(COMMA);
        writeCSV(array, CUSTOMER_CSV);
    }

    public static void showInformationCustomers() throws IOException {
        FileReader fileReader = new FileReader(CUSTOMER_CSV);
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
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
        final String EMAIL_REGEX = "^\\w+@\\w+.\\w+$";
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

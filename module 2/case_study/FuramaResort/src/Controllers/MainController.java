package Controllers;

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

    public static void main(String[] args) {
        try {
            displayMainMenu();
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
        int  guestAmount = inputGuestAmount();
        String rentType = inputRentType();
        String roomStandard = inputRoomStandard();
        int floors = inputFloors();
        String exclusives = inputExclusives();

        Villa villa = new Villa(id, serviceType, usageArea, rentCost, guestAmount, rentType, poolArea, roomStandard, exclusives, floors);
        String[] array = villa.showInfo().split(",");
        try (FileWriter villaWriter = new FileWriter(VILLA_CSV, true)) {
            for (int i = 0; i < array.length; i++) {
                villaWriter.append(array[i]);
                if (i != array.length - 1) villaWriter.append(",");
                else villaWriter.append('\n');
            }
        }
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
        String[] array = house.showInfo().split(",");
        try (FileWriter houseWriter = new FileWriter(HOUSE_CSV, true)) {
            for (int i = 0; i < array.length; i++) {
                houseWriter.append(array[i]);
                if (i != array.length - 1) houseWriter.append(",");
                else houseWriter.append('\n');
            }
        }
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
        String[] array = room.showInfo().split(",");
        try (FileWriter roomWriter = new FileWriter(ROOM_CSV, true)) {
            for (int i = 0; i < array.length; i++) {
                roomWriter.append(array[i]);
                if (i != array.length - 1) roomWriter.append(",");
                else roomWriter.append('\n');
            }
        }
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
            if (!matcher.matches()) System.err.println("Invalid ID. Correct ID: SV" + type + "-XXXX with X is number from 0-9");
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
            if (!matcher.matches()) System.err.println("Exclusives must be either massage, karaoke, food, drink or car");
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
}

package Controllers;

import Models.House;
import Models.Room;
import Models.Villa;

import java.io.*;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input ID");
        String id = scanner.nextLine();
        System.out.println("Input Service Type");
        String serviceType = scanner.nextLine();
        System.out.println("Input Usage Area");
        double usageArea = scanner.nextDouble();
        System.out.println("Input Rent Cost");
        double rentCost = scanner.nextDouble();
        System.out.println("Input guest amount");
        int guestAmount = scanner.nextInt();
        System.out.println("Input rent type");
        String rentType = scanner.next();
        System.out.println("Input pool area");
        double poolArea = scanner.nextDouble();
        System.out.println("Input room standard");
        String roomStandard = scanner.next();
        System.out.println("Input other exclusives");
        String exclusives = scanner.next();
        System.out.println("Input floors");
        int floors = scanner.nextInt();
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input ID");
        String id = scanner.nextLine();
        System.out.println("Input Service Type");
        String serviceType = scanner.nextLine();
        System.out.println("Input Usage Area");
        double usageArea = scanner.nextDouble();
        System.out.println("Input Rent Cost");
        double rentCost = scanner.nextDouble();
        System.out.println("Input guest amount");
        int guestAmount = scanner.nextInt();
        System.out.println("Input rent type");
        String rentType = scanner.next();
        System.out.println("Input room standard");
        String roomStandard = scanner.next();
        System.out.println("Input other exclusives");
        String exclusives = scanner.next();
        System.out.println("Input floors");
        int floors = scanner.nextInt();
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input ID");
        String id = scanner.nextLine();
        System.out.println("Input Service Type");
        String serviceType = scanner.nextLine();
        System.out.println("Input Usage Area");
        double usageArea = scanner.nextDouble();
        System.out.println("Input Rent Cost");
        double rentCost = scanner.nextDouble();
        System.out.println("Input guest amount");
        int guestAmount = scanner.nextInt();
        System.out.println("Input rent type");
        String rentType = scanner.next();
        System.out.println("Input free service");
        String freeService = scanner.next();
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
        while ((line = reader.readLine())!=null){
            System.out.println(line);
        }
    }

    public static void showAllHouse() throws IOException {
        FileReader fileReader = new FileReader(HOUSE_CSV);
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        while ((line = reader.readLine())!=null){
            System.out.println(line);
        }
    }

    public static void showAllRoom() throws IOException {
        FileReader fileReader = new FileReader(ROOM_CSV);
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        while ((line = reader.readLine())!=null){
            System.out.println(line);
        }
    }
}

package Controllers;

import Models.Villa;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        displayMainMenu();

    }

    public static void displayMainMenu() {
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
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    return;
            }
        } while (menuChoice < 1 || menuChoice > 7);
    }

    public static void addNewServices() {
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

                    break;
                case 3:
                case 4:
                case 5:
                    return;
            }
        } while (serviceChoice < 1 || serviceChoice > 5);
    }
    public static void addVilla() {
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
        String rentType = scanner.nextLine();
        System.out.println("Input pool area");
        double poolArea = scanner.nextDouble();
        System.out.println("Input room standard");
        String roomStandard = scanner.nextLine();
        System.out.println("Input other exclusives");
        String exclusives = scanner.nextLine();
        System.out.println("Input floors");
        int floors = scanner.nextInt();
        Villa villa = new Villa(id, serviceType, usageArea, rentCost, guestAmount, rentType, poolArea, roomStandard, exclusives, floors);
    }
}

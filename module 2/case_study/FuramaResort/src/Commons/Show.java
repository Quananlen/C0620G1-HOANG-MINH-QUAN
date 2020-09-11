package Commons;

import Commons.SourcePath;
import Controllers.MainController;
import Models.Customer;
import Models.Employee;
import Models.Services;

import java.io.*;
import java.util.*;

public class Show {
    public static void showServices() throws IOException, ClassNotFoundException {
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
                    showAllUnique(SourcePath.ARR_VILLA_TXT);
                    break;
                case 5:
                    showAllUnique(SourcePath.ARR_HOUSE_TXT);
                    break;
                case 6:
                    showAllUnique(SourcePath.ARR_ROOM_TXT);
                    break;
                case 7:
                    MainController.displayMainMenu();
                    break;
                case 8:
                    return;
            }
        } while (choice < 1 || choice > 8);
    }

    public static void showAllVilla() throws IOException {
        FileReader fileReader = new FileReader(SourcePath.VILLA_CSV);
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        int i = 1;
        while ((line = reader.readLine()) != null) {
            System.out.println("Villa " + i + ": " + line);
            i++;
        }
    }

    public static void showAllHouse() throws IOException {
        FileReader fileReader = new FileReader(SourcePath.HOUSE_CSV);
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        int i = 1;
        while ((line = reader.readLine()) != null) {
            System.out.println("House " + i + ": " + line);
            i++;
        }
    }

    public static void showAllRoom() throws IOException {
        FileReader fileReader = new FileReader(SourcePath.ROOM_CSV);
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        int i = 1;
        while ((line = reader.readLine()) != null) {
            System.out.println("Room " + i + ": " + line);
            i++;
        }
    }

    public static void showInfoCustomerInOrder() throws IOException, ClassNotFoundException {
        try (
                FileInputStream fileInputStream = new FileInputStream(SourcePath.ARR_CUSTOMER_TXT);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            ArrayList<Customer> list = (ArrayList<Customer>) objectInputStream.readObject();
            list.sort(Comparator.comparing(Customer::getName));
            int i = 1;
            for (Customer item : list) {
                System.out.println("Customer " + i + ": " + item.showInfo());
                i++;
            }
        }
    }

    public static void showInformationCustomers() throws IOException {
        FileReader fileReader = new FileReader(SourcePath.CUSTOMER_CSV);
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        int i = 1;
        while ((line = reader.readLine()) != null) {
            System.out.println("Customer " + i + ": " + line);
            i++;
        }
    }

    public static void showAllUnique(String source) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(source);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<Services> arr = (ArrayList<Services>) objectInputStream.readObject();
        TreeSet<Services> tree = new TreeSet<>(arr);
        for (Services element : tree) System.out.println(element.showInfo());
    }

    public static void showEmployees() throws IOException {
        try (FileReader fileReader = new FileReader(SourcePath.EMPLOYEE_CSV);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            String[] array;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                Employee employee = new Employee(array[0], array[1], Integer.parseInt(array[2]), array[3]);
                Employee.treeEmployee.put(array[0], employee);
            }
            for (Map.Entry<String, Employee> employee : Employee.treeEmployee.entrySet()) {
                StringBuilder str = new StringBuilder();
                str.append("ID ").append(employee.getKey()).append(": ").append(employee.getValue());
                System.out.println(str);
            }
        }
    }
}

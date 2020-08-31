package Views;

import Commons.SourcePath;
import Models.Cabinet;
import Models.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Find {
    public static void findEmployee() throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean isFounded = false;
        System.out.println("Find employee by:\n" +
                "1. id\n" +
                "2. name\n" +
                "3. age\n" +
                "4. address\n");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("input id");
                scanner.skip("\\R");
                String id = scanner.nextLine();
                isFounded = findEmployeeBy("id", id);
                break;
            case 2:
                System.out.println("input name");
                scanner.skip("\\R");
                String name = scanner.nextLine();
                isFounded = findEmployeeBy("name", name);
                break;
            case 3:
                System.out.println("input age");
                scanner.skip("\\R");
                String age = scanner.nextLine();
                isFounded =  findEmployeeBy("age", age);
                break;
            case 4:
                System.out.println("input address");
                scanner.skip("\\R");
                String address = scanner.nextLine();
                isFounded = findEmployeeBy("address", address);
                break;
        }
        if (!isFounded) System.out.println("Can't find employee");
    }

    public static boolean findEmployeeBy(String property, String value) throws IOException {
        FileReader fileReader = new FileReader((SourcePath.EMPLOYEE_CSV));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Cabinet.stack.clear();
        boolean isFounded = false;
        String line;
        String[] array;
        while ((line = bufferedReader.readLine()) != null) {
            array = line.split(",");
            Employee employee = new Employee(array[0], array[1], Integer.parseInt(array[2]), array[3]);
            Cabinet.stack.add(employee);
        }
        for (Employee employee : Cabinet.stack) {
            switch (property) {
                case "id":
                    if (employee.getId().equals(value)) {
                        isFounded = true;
                        System.out.println(employee);
                    }
                    break;
                case "name":
                    if (employee.getName().equals(value)) {
                        isFounded = true;
                        System.out.println(employee);
                    }
                    break;
                case "age":
                    if (String.valueOf(employee.getAge()).equals(value)) {
                        isFounded = true;
                        System.out.println(employee);
                    }
                    break;
                case "address":
                    if (employee.getAddress().equals(value))
                        isFounded = true;
                    System.out.println(employee);
                    break;
            }
        }
        return isFounded;
    }
}

package Commons;

import Models.Cinema;
import Models.Customer;
import Models.Services;
import Views.Show;

import java.io.*;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Booking {

    public static void bookService(String sourceText, Customer customer, String type) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        ArrayList list = File.readArray(sourceText);
        System.out.println("Select " + type + " to book");
        int choice = scanner.nextInt() - 1;
        Services service = (Services) list.get(choice);
        customer.setService(service);
        ArrayList<Customer> arrBooking = new ArrayList<>();
        if (File.readArray(SourcePath.ARR_BOOKING_TXT) != null) arrBooking = File.readArray(SourcePath.ARR_BOOKING_TXT);
        arrBooking.add(customer);
        File.writeArray(arrBooking, SourcePath.ARR_BOOKING_TXT);
        String[] array = arrBooking.get(arrBooking.size() - 1).showInfo().split(",");
        File.writeCSV(array, SourcePath.BOOKING_CSV);
    }

    public static void buyTicket() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Show.showInfoCustomerInOrder();
        Customer.arrCustomer = File.readArray(SourcePath.ARR_CUSTOMER_TXT);
        System.out.println("Select customer to buy ticket");
        int choice = scanner.nextInt() - 1;
        ObjectInputStream objectInputStream;
        java.io.File file = new java.io.File(SourcePath.TICKET_TXT);
        if (file.length() != 0) {
            FileInputStream fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            Cinema.queue = (Queue<Customer>) objectInputStream.readObject();
        }

        if (Cinema.queue.size() < 2) {
            Cinema.queue.offer(Customer.arrCustomer.get(choice));
            FileOutputStream fileOutputStream = new FileOutputStream(SourcePath.TICKET_TXT);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(Cinema.queue);
        } else {
            System.out.println("All tickets sold. List of customers:");
            for (Customer customer : Cinema.queue) {
                System.out.println(customer.showInfo());
            }
        }
    }
}

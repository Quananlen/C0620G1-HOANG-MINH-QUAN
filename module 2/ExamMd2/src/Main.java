import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static final String CONTACT_TXT = "src/data/contact.txt";
    public static final String CONTACT_CSV = "src/data/contact.csv";

    public static void main(String[] args) {
        try {
            displayMenu();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void displayMenu() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.print("----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ----" +
                    "\nChọn chức năng theo số (để tiếp tục):" +
                    "\n1. Xem danh sách" +
                    "\n2. Thêm mới" +
                    "\n3. Cập nhật" +
                    "\n4. Xoá" +
                    "\n5. Tìm kiếm" +
                    "\n6. Đọc từ file" +
                    "\n7. Ghi vào file" +
                    "\n8. Thoát" +
                    "\nChọn chức năng: ");
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Nhập ko đúng, mời thử lại");
                displayMenu();
            }
        } while (choice < 1 || choice > 8);

        switch (choice) {
            case 1:
                displayList();
                displayMenu();
                break;
            case 2:
                addContact();
                displayMenu();
                break;
            case 3:
                updateContact();
                displayMenu();
                break;
            case 4:
                deleteContact();
                displayMenu();
                break;
            case 5:
                System.out.println(findContact());
                displayMenu();
                break;
            case 6:
                readCSV(CONTACT_CSV);
                displayList();
                displayMenu();
                break;
            case 7:
                writeCSV();
                displayMenu();
            case 8:
                return;
        }
    }

    public static void displayList() throws IOException, ClassNotFoundException {
        try (
                FileInputStream fileInputStream = new FileInputStream(CONTACT_TXT);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            ArrayList<Contact> list = (ArrayList<Contact>) objectInputStream.readObject();
            int i = 1;
            for (Contact contact : list) {
                System.out.println("Contact " + i + ": " + contact.toString());
                i++;
            }
        }
    }

    public static void addContact() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Thông tin của danh bạ:");
        String number = inputNumber();
        String group = inputField("nhóm");
        String name = inputField("họ tên");
        String gender = inputField("giới tính");
        String address = inputField("địa chỉ");
        String birthday = inputField("ngày sinh");
        String email = inputEmail();

        Contact.listContact = readTXT(CONTACT_TXT);

        Contact contact = new Contact(number, group, name, gender, address, birthday, email);
        String[] array = contact.toString().split(",");
        writeLineCSV(array, CONTACT_CSV);

        System.out.println("Thêm mới danh bạ thành công!");

        Contact.listContact.add(contact);
        writeTXT(Contact.listContact, "src/data/contact.txt");
    }

    public static void updateContact() throws IOException, ClassNotFoundException {
        Contact.listContact = readTXT(CONTACT_TXT);
        Scanner scanner = new Scanner(System.in);
        String number = inputNumber();

        validateNumber:
        do {
            for (Contact contact : Contact.listContact) {
                if (contact.getNumber().equals(number)) break validateNumber;
            }
            System.out.println("Không tìm được danh bạ với số điện thoại trên. Nhập lại số điện thoại");
            number = scanner.nextLine();
            if (number.equals("")) return;
        } while (true);

        String[] arrayForWriting;
        for (Contact contact : Contact.listContact) {
            if (contact.getNumber().equals(number)) {

                System.out.println("Nhập nhóm của danh ba");
                contact.setGroup(scanner.nextLine());
                System.out.println("Nhập họ tên danh bạ");
                contact.setName(scanner.nextLine());
                System.out.println("Nhập giới tính danh bạ");
                contact.setGender(scanner.nextLine());
                System.out.println("Nhập địa chỉ danh bạ");
                contact.setAddress(scanner.nextLine());
                System.out.println("Nhập ngày sinh danh bạ");
                contact.setBirthday(scanner.nextLine());
                contact.setEmail(inputEmail());


                writeTXT(Contact.listContact, CONTACT_TXT);

                FileWriter fileWriter = new FileWriter(CONTACT_CSV, false);
                fileWriter.close();

                for (Contact contact1 : Contact.listContact) {
                    arrayForWriting = contact1.toString().split(",");
                    writeLineCSV(arrayForWriting, CONTACT_CSV);
                }

                return;
            }
        }
    }

    public static void deleteContact() throws IOException, ClassNotFoundException {
        Contact.listContact = readTXT(CONTACT_TXT);
        Scanner scanner = new Scanner(System.in);
        String number = inputNumber();

        validateNumber:
        do {
            for (Contact contact : Contact.listContact) {
                if (contact.getNumber().equals(number)) break validateNumber;
            }
            System.out.println("Không tìm được danh bạ với số điện thoại trên. Nhập lại số điện thoại");
            number = scanner.nextLine();
            if (number.equals("")) return;
        } while (true);

        String choice;
        String[] arr;
        for (Contact contact : Contact.listContact) {
            if (contact.getNumber().equals(number)) {
                System.out.println("Bạn có chắc ko? Y(es) / N(o)");
                choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    Contact.listContact.remove(contact);
                    System.out.println("Xoá danh bạ " + number + " hoàn thành");
                    writeTXT(Contact.listContact, CONTACT_TXT);

                    FileWriter fileWriter = new FileWriter(CONTACT_CSV, false);
                    fileWriter.close();

                    for (Contact contact1 : Contact.listContact) {
                        arr = contact1.toString().split(",");
                        writeLineCSV(arr, CONTACT_CSV);
                    }
                }
                return;
            }
        }

    }

    public static String findContact() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        boolean isFounded;
        String choice;
        while (true) {
            System.out.println("Tìm danh bạ theo:" +
                    "\n1. Số điện thoại" +
                    "\n2. Họ tên");
            choice = scanner.nextLine();
            if (choice.equals("1") || choice.equals("2")) break;
            else System.out.println("Lựa chọn ko đúng");
        }
        if (choice.equals("1")) {
            System.out.println("Nhập số điện thoại");
            String number = scanner.nextLine();
            isFounded = findContactBy("number", number);
        } else {
            System.out.println("Nhập họ tên");
            String name = scanner.nextLine();
            isFounded = findContactBy("name", name);
        }
        if (isFounded) return "Tìm kiếm hoàn tất";
        else return "Ko tìm thấy trong danh bạ";
    }

    public static boolean findContactBy(String type, String value) throws IOException, ClassNotFoundException {
        Contact.listContact = readTXT(CONTACT_TXT);
        boolean isFounded = false;
        for (Contact contact : Contact.listContact) {
            switch (type) {
                case "number":
                    if (contact.getNumber().equals(value)) {
                        isFounded = true;
                        System.out.println(contact.toString());
                    }
                    break;
                case "name":
                    if (contact.getName().equals(value)) {
                        isFounded = true;
                        System.out.println(contact.toString());
                    }
            }
        }
        return isFounded;
    }

    public static String inputNumber() {
        Scanner scanner = new Scanner(System.in);
        final String NUMBER_REGEX = "\\d{10}";
        String number;
        while (true) {
            System.out.println("Nhập số điện thoại: ");
            number = scanner.nextLine();
            if (number.matches(NUMBER_REGEX)) break;
            else System.out.println("Định dạng số điện thoại ko đúng. Điện thoại phải có 10 số");
        }
        return number;
    }

    public static String inputEmail() {
        Scanner scanner = new Scanner(System.in);
        final String EMAIL_REGEX = "^\\w+@\\w+\\.\\w+$";
        String email;
        while (true) {
            System.out.println("Nhập email của danh bạ");
            email = scanner.nextLine();
            if (email.matches(EMAIL_REGEX)) break;
            else System.out.println("Email ko đúng định dạng. Email phải có định dạng abc@abc.abc");
        }
        return email;
    }

    public static String inputField(String str) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Nhập " + str + " danh bạ");
            String result = scanner.nextLine();
            if (!result.equals("")) return result;
            else System.out.println("Ko dc để trống");
        }
    }

    public static ArrayList<Contact> readCSV(String csv) throws IOException {
        FileReader fileReader = new FileReader(CONTACT_CSV);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<Contact> list = new ArrayList<>();
        String[] array;
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            array = line.split(",");
            Contact contact = new Contact(array[0], array[1], array[2], array[3], array[4], array[5], array[6]);
            list.add(contact);
        }
        return list;
    }

    public static void writeCSV() throws IOException, ClassNotFoundException {
        Contact.listContact = readTXT(CONTACT_TXT);
        String[] array;

        FileWriter fileWriter = new FileWriter(CONTACT_CSV, false);
        fileWriter.close();

        for (Contact contact : Contact.listContact) {
            array = contact.toString().split(",");
            writeLineCSV(array, CONTACT_CSV);
        }
    }

    public static void writeLineCSV(String[] array, String csv) throws IOException {
        try (FileWriter writer = new FileWriter(csv, true)) {
            for (int i = 0; i < array.length; i++) {
                writer.append(array[i]);
                if (i != array.length - 1) writer.append(",");
                else writer.append("\n");
            }
        }
    }

    public static void writeTXT(ArrayList<Contact> arr, String dest) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(dest);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(arr);
        }
    }

    public static ArrayList<Contact> readTXT(String source) throws IOException, ClassNotFoundException {
        java.io.File file = new java.io.File(source);
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream;
        if (file.length() != 0) {
            objectInputStream = new ObjectInputStream(fileInputStream);
            return (ArrayList<Contact>) objectInputStream.readObject();
        }
        return null;
    }
}

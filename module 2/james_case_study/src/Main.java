import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            Controller.handleRequest2();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

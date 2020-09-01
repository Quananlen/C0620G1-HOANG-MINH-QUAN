import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            Controller.handleRequest();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

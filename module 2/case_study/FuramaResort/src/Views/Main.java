package Views;

import Controllers.MainController;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        try {
            MainController.displayMainMenu();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

package Models;

public class Main {
    public static void main(String[] args) {
        Services services = new Services() {
            @Override
            void showInfo() {
                System.out.println("hehe");
            }
        };
        services.showInfo();
    }
}

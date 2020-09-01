import java.io.Serializable;
import java.util.Scanner;

public class Adj implements IEntities, Serializable {
    String adj;
    String meaning;

    public Adj(String adj) {
        Scanner scanner = new Scanner(System.in);
        this.adj = adj;
        System.out.print("Adj definition: ");
        this.meaning = scanner.nextLine();
        System.out.println("Saved!");
    }

    @Override
    public String display() {
        return "@" + adj + "\nAdjective: " + meaning;
    }

    @Override
    public String getWord() {
        return adj;
    }
}

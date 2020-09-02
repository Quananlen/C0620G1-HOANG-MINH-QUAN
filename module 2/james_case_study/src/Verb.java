import java.io.Serializable;
import java.util.Scanner;

public class Verb implements IEntities, Serializable {
    String verb;
    String meaning;

    public Verb(String verb) {
        Scanner scanner = new Scanner(System.in);
        this.verb = verb;
        System.out.print("Verb definition: ");
        this.meaning = scanner.nextLine();
    }

    @Override
    public String display() {
        return "@" + verb + "\nVerb: " + meaning;
    }

    @Override
    public String getWord() {
        return verb;
    }
}

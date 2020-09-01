import java.io.Serializable;
import java.util.Scanner;

public class Verb implements IEntities, Serializable {
    String verb;
    String meaning;

    public Verb(String verb) {
        Scanner scanner = new Scanner(System.in);
        this.verb = verb;
        System.out.print("Noun definition: ");
        this.meaning = scanner.nextLine();
        System.out.println("Saved!");
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

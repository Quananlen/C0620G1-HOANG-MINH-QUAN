import java.io.Serializable;
import java.util.Scanner;

public class Noun implements IEntities, Serializable {
    String noun;
    String meaning;

    public Noun(String noun) {
        Scanner scanner = new Scanner(System.in);
        this.noun = noun;
        System.out.print("Noun definition: ");
        this.meaning = scanner.nextLine();
    }

    @Override
    public String display() {
        return "@" + noun + "\nNoun: " + meaning;
    }

    @Override
    public String getWord() {
        return noun;
    }
}

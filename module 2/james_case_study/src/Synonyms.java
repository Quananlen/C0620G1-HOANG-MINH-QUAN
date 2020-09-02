import java.io.Serializable;
import java.util.Scanner;

public class Synonyms implements IEntities, Serializable {
    String synonyms;
    String meaning;

    public Synonyms(String synonyms) {
        Scanner scanner = new Scanner(System.in);
        this.synonyms = synonyms;
        System.out.print("Input synonyms: ");
        this.meaning = scanner.nextLine();
    }

    @Override
    public String display() {
        return "@" + synonyms + "\nSynonyms: " + meaning;
    }

    @Override
    public String getWord() {
        return synonyms;
    }
}

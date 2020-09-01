import java.io.Serializable;

public class Fox implements Serializable {
    public int tails;
    public String name;

    public Fox(int tails, String name) {
        this.tails = tails;
        this.name = name;
    }

    @Override
    public String toString() {
        return tails + "," + name;
    }
}

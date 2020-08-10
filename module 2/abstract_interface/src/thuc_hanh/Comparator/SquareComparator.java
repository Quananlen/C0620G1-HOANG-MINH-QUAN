package thuc_hanh.Comparator;
import java.util.Comparator;

public class SquareComparator implements Comparator<Square> {
    @Override
    public int compare(Square r1, Square r2) {
        if (r1.getSide() > r2.getSide()) return 1;
        if (r1.getSide() < r2.getSide()) return -1;
        return 0;
    }
}

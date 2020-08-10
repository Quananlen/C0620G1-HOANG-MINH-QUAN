package thuc_hanh;

public class Test {
    abstract class Hinh{}

    class Tron extends Hinh{}

    abstract class DaGiac extends Hinh{}

    class TamGiac extends DaGiac{}

    class ChuNhat extends DaGiac{}

    public  void main(String[] args) {
        Hinh h1 = new Tron();

        Hinh h2 = new TamGiac();

        Hinh h3 = new ChuNhat();

        h2 = h3;
    }

}

import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input a,b,c for a^2x + bx + c = 0");
        System.out.println("a =");
        double a = scanner.nextDouble();
        System.out.println("b =");
        double b = scanner.nextDouble();
        System.out.println("c =");
        double c = scanner.nextDouble();
        QuadraticEquation equation1 = new QuadraticEquation(a, b, c);
        double delta = equation1.getDiscriminant();
        if (delta > 0) {
            System.out.println("root 1 = " + equation1.getRoot1());
            System.out.println("root 2 = " + equation1.getRoot2());
        } else if (delta == 0) {
            System.out.println("root = " + equation1.getRoot1());
        } else System.out.println("The equation has no roots");
    }

    double a;
    double b;
    double c;

    QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    double getA() {
        return this.a;
    }

    double getB() {
        return this.b;
    }

    double getC() {
        return this.c;
    }

    double getDiscriminant() {
        return this.b * this.b - 4 * this.a * this.c;
    }

    double getRoot1() {
        return (-this.b + Math.sqrt(this.getDiscriminant())) / (this.a * 2);
    }

    double getRoot2() {
        return (-this.b - Math.sqrt(this.getDiscriminant())) / (this.a * 2);
    }
}

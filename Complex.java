
import java.util.*;

public class Complex {

    int real;
    int img;

    Complex() {
        real = 0;
        img = 0;
    }

    Complex(int real, int img) {
        this.real = real;
        this.img = img;
    }

    public void add(Complex c1, Complex c2) {
        int r1 = c1.real + c2.real;
        int img1 = c1.img + c2.img;
        System.out.println("Answer: " + r1 + "+(" + img1 + ")i");
    }

    public void sub(Complex c1, Complex c2) {
        int r1 = c1.real - c2.real;
        int img1 = c1.img - c2.img;
        System.out.println("Answer: " + r1 + "+(" + img1 + ")i");
    }

    public void mul(Complex c1, Complex c2) {
        int r1 = c1.real * c2.real - c1.img * c2.img;
        int img1 = c1.real * c2.img + c2.real * c1.img;
        System.out.println("Answer: " + r1 + "+(" + img1 + ")i");

    }

    public void div(Complex c1, Complex c2) {
        if (c2.real * c2.real + c2.img * c2.img == 0) {
            System.out.println("Invalid denominator");
        } else {
            int r1 = (c1.real * c2.real - c1.img * c2.img) / c2.real * c2.real + c2.img * c2.img;
            int img1 = (c1.real * c2.img + c2.real * c1.img) / c2.real * c2.real + c2.img * c2.img;
            System.out.println("Answer: " + r1 + "+(" + img1 + ")i");
        }
    }

    public static void main(String[] args) {
        Complex complex = new Complex();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the real part of first number:");
        int n1 = sc.nextInt();
        System.out.println("Enter the first imag part:");
        int n2 = sc.nextInt();
        System.out.println("Enter the Second real part:");
        int n3 = sc.nextInt();
        System.out.println("Enter the second imag part:");
        int n4 = sc.nextInt();
        Complex t1 = new Complex(n1, n2);
        Complex t2 = new Complex(n3, n4);
        int ch;
        do {
            System.out.println("\n1. Addition ");
            System.out.println("2. Subtraction ");
            System.out.println("3. Multiplication ");
            System.out.println("4. Division ");
            System.out.println("5. Exit\n");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    complex.add(t1, t2);
                    break;
                case 2:
                    complex.sub(t1, t2);
                    break;
                case 3:
                    complex.mul(t1, t2);
                    break;
                case 4:
                    complex.div(t1, t2);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid input");
            }
        } while (ch != 5);
        sc.close();
    }
}

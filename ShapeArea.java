import java.util.Scanner;

// Base class
abstract class Shape {
    protected double dimension1, dimension2;

    // Method to input data
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter dimension 1: ");
        dimension1 = scanner.nextDouble();
        System.out.print("Enter dimension 2: ");
        dimension2 = scanner.nextDouble();
    }

    // Abstract method to compute area
    public abstract void computeArea();
}

// Derived class for Triangle
class Triangle extends Shape {
    @Override
    public void computeArea() {
        double area = 0.5 * dimension1 * dimension2;
        System.out.println("Area of Triangle: " + area);
    }
}

// Derived class for Rectangle
class Rectangle extends Shape {
    @Override
    public void computeArea() {
        double area = dimension1 * dimension2;
        System.out.println("Area of Rectangle: " + area);
    }
}

// Main class
public class ShapeArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose a shape to calculate area:");
            System.out.println("1. Triangle");
            System.out.println("2. Rectangle");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            Shape shape = null;

            switch (choice) {
                case 1:
                    shape = new Triangle();
                    break;
                case 2:
                    shape = new Rectangle();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice! Please try again.");
                    continue; // Go back to the menu
            }

            // Input dimensions and compute area
            shape.inputData();
            shape.computeArea();
        }
    }
}

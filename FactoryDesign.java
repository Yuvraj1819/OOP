
import java.util.Scanner; 
 
abstract class Car { 
    protected String type; 
 
    public Car(String type) { 
        this.type = type; 
    } 
 
    public abstract void build(); 
 
    protected void allocateAccessories() { 
        System.out.println("Allocating accessories for " + type); 
    } 
 
    protected void assembleBody() { 
        System.out.println("Assembling body for " + type); 
    } 
 
    protected void paint() { 
        System.out.println("Painting " + type); 
    } 
 
    protected void installInterior() { 
        System.out.println("Installing interior for " + type); 
    } 
} 
 
class Hatchback extends Car { 
    public Hatchback() { 
        super("Hatchback"); 
    } 
 
    @Override 
    public void build() { 
        allocateAccessories(); 
        assembleBody(); 
        paint(); 
        installInterior(); 
        System.out.println("Hatchback built successfully.\n"); 
    } 
} 
 
class Sedan extends Car { 
    public Sedan() { 
        super("Sedan"); 
    } 
 
    @Override 
    public void build() { 
        allocateAccessories(); 
        assembleBody(); 
        paint(); 
        installInterior(); 
        System.out.println("Sedan built successfully.\n"); 
    } 
} 
 
class SUV extends Car { 
    public SUV() { 
        super("SUV"); 
    } 
 
    @Override 
    public void build() { 
        allocateAccessories(); 
        assembleBody(); 
        paint(); 
        installInterior(); 
        System.out.println("SUV built successfully.\n"); 
    } 
} 
 
class CarFactory { 
    public static Car createCar(String type) { 
        switch (type.toLowerCase()) { 
            case "hatchback": 
                return new Hatchback(); 
            case "sedan": 
                return new Sedan(); 
            case "suv": 
                return new SUV(); 
            default: 
                throw new IllegalArgumentException("Car type not recognized."); 
        } 
    } 
} 
 
public class FactoryDesign { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        int ch; 
        String choice; 
 
        do { 
            System.out.println("Enter the car you want to build: "); 
            System.out.println("1: Hatchback\n2: Sedan\n3: SUV\n4: Exit\n"); 
            ch = sc.nextInt(); 
 
            switch (ch) { 
                case 1: 
                    // Create and build a Hatchback 
                    Car hatchback = CarFactory.createCar("hatchback"); 
                    hatchback.build(); 
                    break; 
 
                case 2: 
                    // Create and build a Sedan 
                    Car sedan = CarFactory.createCar("sedan"); 
                    sedan.build(); 
                    break; 
 
                case 3: 
                    // Create and build an SUV 
                    Car suv = CarFactory.createCar("suv"); 
                    suv.build(); 
                    break; 
 
                case 4: 
                    return; 
 
                default: 
                    System.out.println("Enter Correct Choice."); 
                    break; 
            } 
 
            System.out.println("Do you want to continue? 'Y' or 'N' "); 
            choice = sc.next(); 
        } while (choice.equalsIgnoreCase("y")); 
 
        sc.close(); 
    } 
} 

import java.util.Scanner;

//Base class Publication
class Publication {
 String title;
 double price;
 int copies;
 int copies1;

 public int setCopies(int c) {
	
     this.copies -= c;
     return this.copies;
 }

 public void saleCopy(double totalPrice) {
     System.out.println("Total Publication sales: " + totalPrice);
 }
}

//Derived class Book
class Book extends Publication {
 String author;
 int bookNo;
 int scpy=0;

 // Default constructor
 Book() {
     title = null;
     price = 0.0;
     copies = 0;
     author = null;
     
 }

 // Parameterized constructor
 Book(int index, String t, String a, double p, int c) {
     bookNo = index;
     title = t;
     price = p;
     author = a;
     copies = c;
 }

 // Method to order copies of books
 public double orderCopies(Book[] books) {
     double totalPrice = 0.0;
     double totalPricei=0.0;
     int flag = 0, ch;
     Scanner scr = new Scanner(System.in);

     do {
         System.out.println(".........................................................................");
         System.out.println("Books available with us:");
         System.out.println("Number"+" \t " + "Title"+ " \t " + "price");
         for (int i = 0; i < books.length; i++) {
        	
             System.out.println(books[i].bookNo + " \t " + books[i].title + " \t " + books[i].author + " \t " + books[i].price);
         }
         System.out.println(".........................................................................");

         System.out.println("Enter the Book Number You want to Order:");
         int bNo = scr.nextInt();
         int qty;
        
        
         for (int i = 0; i < books.length; i++) {
             if (books[i].bookNo == bNo) {
                 System.out.println("Enter the number of copies You want to Order:");
                 qty = scr.nextInt();
                
                 flag = 1;
              
                 if (books[i].copies >= qty) {
                     System.out.println("Copies Ordered Successfully");
                     totalPricei = books[i].price * qty;
                     totalPrice += books[i].price * qty;

                     System.out.println("Total amount for " + books[i].title + " is: " + totalPricei);
                    
                     System.out.println("Number of Copies of " + books[i].title + " left are " + books[i].setCopies(qty));
                     books[i].scpy+=qty;
                     System.out.println("Number of Copies of " + books[i].title + " sold are " +books[i].scpy);
                     
                     break;
                 } else {
                     System.out.println("Sorry, Not sufficient Copies");
                 }
             }
         }

         if (flag == 0) {
             System.out.println("Book not Found");
         }
         System.out.println(".........................................................................");
         System.out.println("Do you want to order more books? \n 1: Yes 2: No");
         ch = scr.nextInt();
     } while (ch == 1);

     return totalPrice;
 }

 public void saleCopy(double totalPrice) {
     System.out.println("Total Book sales: " + totalPrice);
 }
}

//Derived class Magazine
class Magazine extends Publication {
 int mNo;
 int currentIssued = 0;
 int smgz=0;

 // Default constructor
 Magazine() {
     title = null;
     price = 0.0;
     copies = 0;
 }

 // Parameterized constructor
 Magazine(int index, String t, double p, int c) {
     mNo = index;
     title = t;
     price = p;
     copies = c;
 }

 // Method to order quantities of magazines (with do-while loop similar to the Book class)
 public double orderQty(Magazine[] magazines) {
     double totalPrice = 0.0;
     double totalPricei=0.0;
     int flag = 0, ch;
     Scanner scr = new Scanner(System.in);

     do {
         System.out.println("Magazines available with us:");
         System.out.println(".........................................................................");
         System.out.println("Number"+" \t " + "Title"+ " \t " + "\t"+"price");
         for (int i = 0; i < magazines.length; i++) {
        	 
             System.out.println(magazines[i].mNo + " \t " + magazines[i].title + " \t " + magazines[i].price);
         }
         System.out.println(".........................................................................");

         System.out.println("Enter the Magazine Number You want to Order:");
         int mNo = scr.nextInt();
         int qty;
         int scpy;

         for (int i = 0; i < magazines.length; i++) {
             if (magazines[i].mNo == mNo) {
                 System.out.println("Enter the number of copies You want to Order:");
                 qty = scr.nextInt();
                 flag = 1;
            
                 if (magazines[i].copies >= qty) {
                     System.out.println("Copies Ordered Successfully");
                     totalPricei = magazines[i].price * qty;
                     totalPrice += magazines[i].price * qty;
                     System.out.println("Total amount for " + magazines[i].title + " is: " + totalPricei);
                     magazines[i].smgz+=qty;
                   
                     System.out.println("Number of Copies of " + magazines[i].title + " left are " + magazines[i].setCopies(qty));
                     
                     System.out.println("Number of Copies of " + magazines[i].title + " sold are " + magazines[i].smgz);
                     
                     break;
                 } else {
                     System.out.println("Sorry, Not sufficient Copies");
                 }
             }
         }

         if (flag == 0) {
             System.out.println("Magazine not Found");
         }
         System.out.println(".........................................................................");
         System.out.println("Do you want to order more magazines? \n 1: Yes 2: No");
         ch = scr.nextInt();
     } while (ch == 1);

     return totalPrice;
 }

 public void saleCopy(double totalPrice) {
     System.out.println("Total Magazine sales: " + totalPrice);
 }
}



public class Publ {

	 public static void main(String[] args) {
	        Book[] bookList = new Book[3];
	        bookList[0] = new Book(1, "M1", "Sdfsgjhs", 9000, 30);
	        bookList[1] = new Book(2, "M2", "Jack fgfh", 4040, 30);
	        bookList[2] = new Book(3, "DM", "max gsdatc", 7250, 30);

	        Magazine[] magazineList = new Magazine[2];
	        magazineList[0] = new Magazine(1, "gfdjgs jhf", 750, 100);
	        magazineList[1] = new Magazine(2, "skill kno", 500, 100);

	        double bookSales = 0, magazineSales = 0;

	        System.out.println("Welcome to siuuuu Publication ");

	        Scanner scr = new Scanner(System.in);
	        int choice, continueChoice;

	        do {
	            System.out.println(".........................................................................");
	            
	            System.out.println("Enter the correct choice to order \n 1: Book \n 2: Magazine");
	            choice = scr.nextInt();

	            if (choice == 1) {
	                Book book = new Book();
	                bookSales += book.orderCopies(bookList);
	                book.saleCopy(bookSales);
	            } else if (choice == 2) {
	                Magazine magazine = new Magazine();
	                magazineSales += magazine.orderQty(magazineList);
	                magazine.saleCopy(magazineSales);
	            } else {
	                System.out.println("Invalid choice");
	            }
	            
	            System.out.println(".........................................................................");
	            System.out.println("Do you want to order something more? \n 1: Yes \n 2: No");
	            continueChoice = scr.nextInt();
	        } while (continueChoice == 1);
	        System.out.println(".........................................................................");
	        Publication totalSales = new Publication();
	        
	        totalSales.saleCopy(bookSales + magazineSales);
	        System.out.println(".........................................................................");

	}

}



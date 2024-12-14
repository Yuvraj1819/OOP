import java.util.*;
public class ExceptionHandling {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            System.out.println("Enter the 1st number: ");
            String in1=sc.nextLine();
            int n1=Integer.parseInt(in1);

            System.out.println("Enter the 2st number: ");
            String in2=sc.nextLine();
            int n2=Integer.parseInt(in2);

            int n3=n1/n2;
            System.out.println("Result is "+ n3);

            int[] num={1,2,3};
            System.out.println("Enter the index you want to access: ");
            int index=sc.nextInt();
            System.out.println("The value at index "+index+ "is "+num[index]);
        }catch (NumberFormatException e){
            System.out.println("Enter the valid number");
        }catch(ArithmeticException e){
            System.out.println("Cannot divide with 0");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Enter a valid index");
        }catch(Exception e){
            System.out.println("An unknown error occured"+e.getMessage());
        }finally{
            sc.close();
            System.out.println("Execution completed...");
        }
    }
}

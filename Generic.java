import java.util.*;
public class Generic<T> {
    private List<Integer> integerList;
    private List<String> stringList;

    public Generic(){
        integerList = new ArrayList<>();
        stringList = new ArrayList<>();
    }
    public void addInteger(Integer number){
        integerList.add(number);
    }
    public void addString(String str){
        stringList.add(str);
    }
    public int countEven(){
        int count=0;
        for (Integer number : integerList) {
            if(number % 2 ==0){
                count++;
            }
        }
        return count;
    }
    public int countOdd(){
        int count=integerList.size()-countEven();
        return count;
    }
    public int countPrime(){
        int count = 0;
        for(int i : integerList){
            if(isPrime(i)==0){
                count++;
            }
        }
        return count;
    }
    private int isPrime(int no){
        int i,flag=0;
        for(i=2;i<no;i++){
            if(no % i ==0){
                flag=1;
                break;
            }
            else{
                flag=0;
            }
        }
        return flag;
    }
    public int countPalindromes(){
        int count=0;

        for(String str : stringList){
            if(isPalindrome(str)){
                count++;
            }
        }
        return count;
    }
    private boolean isPalindrome(String str){
        StringBuilder sl = new StringBuilder(str);
        if(str.equals(sl.reverse().toString()))
           return true;
        else
            return false;
    }
    public <T> void display(T data){
        System.out.println("Integer List: "+ data);
    }

    public <T> void displayS(T data){
        System.out.println("String List: "+ data);
    }

    public static void main(String [] args){
        Generic<Object> counter = new Generic<>();
        Scanner scr= new Scanner(System.in);
        String con ;

        do{
            System.out.println("1:String\n2:Integer\nEnter your choice:");
            int ch=scr.nextInt();
            int n;
            switch(ch){
                case 1:
                      System.out.println("Enter no of strings you want to add:");
                      n= scr.nextInt();
                      System.out.println("Enter List of strings:\n");
                      for (int i = 0; i < n; i++) {
                        String input = scr.next();
                        counter.addString(input);
                      }
                      counter.displayS(counter.stringList);
                      System.out.println("Count of palindromes: "+ counter.countPalindromes());
                      break;
                case 2:
                      System.out.println("Enter no of integers you want to add:");
                      n= scr.nextInt();
                      System.out.println("Enter list of integers:\n");
                      for (int i = 0; i < n; i++) {
                        int input = scr.nextInt();
                        counter.addInteger(input);
                      }
                      counter.display(counter.integerList);
                      System.out.println("count of even numbers:"+ counter.countEven());
                      System.out.println("count of odd numbers:"+ counter.countOdd());
                      System.out.println("count of prime numbers:"+ counter.countPrime());
                      break;
                default : System.out.println("Enter valid choice \n");
                return;
            }
            System.out.println("do you want to continue? Y or N: \n");
            con = scr.next();
        }while(con.equalsIgnoreCase("Y"));
    }
    
}

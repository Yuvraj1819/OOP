import java.io.*;
import java.util.*;
class Student{
    String stdId;
    String name;
    String rollNo;
    String stdClass;
    double marks;
    String address;

    public Student(String name,String stdId,String rollNo, String stdClass,double marks, String address){
        this.name=name;
        this.stdId=stdId;
        this.rollNo=rollNo;
        this.stdClass=stdClass;
        this.marks=marks;
        this.address=address;
    }
    public String toString(){
        return stdId+","+name+","+rollNo+","+stdClass+","+marks+","+address;
    }
    public static Student fromString(String data){
        String[] feilds=data.split(",");
        return new Student(feilds[0],feilds[1],feilds[2],feilds[3],Double.parseDouble(feilds[4]),feilds[5]);
    }
}
public class StudentRecord{
    private static void createDatabase(Scanner scr){
        try(BufferedWriter writer=new BufferedWriter(new FileWriter("StudentRecord.txt",true))){
            System.out.print("Enter Student ID: ");
            String stdId=scr.nextLine();
            System.out.print("Enter Student Name: ");
            String name=scr.nextLine();
            System.out.print("Enter Student Roll Number: ");
            String rollNo=scr.nextLine();
            System.out.print("Enter Student Class: ");
            String stdClass=scr.nextLine();
            System.out.print("Enter Student marks: ");
            double marks= scr.nextDouble();
            scr.nextLine();
            System.out.print("Enter Address: ");
            String address=scr.nextLine();
            Student student=new Student(stdId,name,rollNo,stdClass,marks,address);
            writer.write(student.toString());
            writer.newLine();
            System.out.println("Student record affed successfully.");
        }catch(IOException e){
            System.out.println("Error while creating database:"+e.getMessage());
        }
    }
    private static void displayDatabase(){
        try(BufferedReader reader=new BufferedReader(new FileReader("StudentRecord.txt"))){
            String line;
            System.out.println("Student Records:");
            while((line =reader.readLine())!=null){
                System.out.println(Student.fromString(line));
            }
        }catch(IOException e){
            System.out.println("Error while displaying database:"+e.getMessage()); 
        }
    }
    private static void deleteRecord(Scanner scr){
        System.out.println("Enter Student ID to detele: ");
        String stdId=scr.nextLine();
        File inputFile=new File("StuedentRecord.txt");
        File tempFile=new File("temp.txt");
        try (BufferedReader reader =new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer=new BufferedWriter(new FileWriter(tempFile))){
            String line;
            boolean found=false;
            while((line=reader.readLine())!=null){
                Student student=Student.fromString(line);
                if(!student.stdId.equals(stdId)){
                    writer.write(line);
                    writer.newLine();
                }else{
                    found=true;
                }
            }
            if(found){
                System.out.println("Record deleted successfully.");
            }else{
                System.out.println("Record not found.");
            }
        }catch(IOException e){
            System.out.println("Error while deleting record: "+e.getMessage());
        }
        if(!tempFile.delete()){
            System.out.println("Could not delete the original file.");
        }
    }
    private static void updateRecord(Scanner scr){
        System.out.println("Enter Student Id to update: ");
        String stdId=scr.nextLine();
        File inputFile=new File("StudentRecord.txt");
        File tempFile=new File("temp.txt");
        try(BufferedReader reader=new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer=new BufferedWriter(new FileWriter(tempFile))){
            String line;
            boolean found=false;
            while((line=reader.readLine())!=null){
                Student student=Student.fromString(line);
                if(student.stdId.equals(stdId)){
                    found=true;
                    System.out.println("Enter new Name(Leave empty to keep unchanged): ");
                    String name=scr.nextLine();
                    System.out.print("Enter new Roll No(Leave empty to keep unchanged)");
                    String rollNo=scr.nextLine();
                    System.out.print("Enter new Class(Leave empty to keep unchanged)");
                    String stdClass=scr.nextLine();
                    System.out.print("Enter new Marks(Leave empty to keep unchanged)");
                    String marksStr=scr.nextLine();
                    System.out.print("Enter new Address(Leave empty to keep unchanged)");
                    String address=scr.nextLine();
                    if(!name.isEmpty()) student.name=name;
                    if(!rollNo.isEmpty()) student.rollNo=rollNo;
                    if(!stdClass.isEmpty()) student.stdClass=stdClass;
                    if(!marksStr.isEmpty()) student.marks=Double.parseDouble(marksStr);
                    if(!address.isEmpty()) student.address=address;
                }
                writer.write(student.toString());
                writer.newLine();
            }
            if (found){
                System.out.println("Record upadated successfully.");
            }else{
                System.out.println("Record not found.");
            }
        }catch(IOException e){
            System.out.println("Error while updating record:"+e.getMessage());
        }
        if(!inputFile.delete()){
            System.out.println("Could not delete the original file.");
        }
        if(!tempFile.renameTo(inputFile)){
            System.out.println("Could not rename temp file to original file.");
        }
    }
    private static void SearchRecord(Scanner scr){
        System.out.println("Enter Student ID to search: ");
        String stdId=scr.nextLine();
        try(BufferedReader reader=new BufferedReader(new FileReader("StudentRecord.txt"))){
            String line;
            boolean found=false;
            while((line=reader.readLine())!=null){
                Student student=Student.fromString(line);
                if(student.stdId.equals(stdId)){
                    System.out.println("Record found: "+student);
                    found=true;
                    break;
                }
            }
            if(!found){
                System.out.println("Record not found.");
            }
        }catch(IOException e){
            System.out.println("Error while searching record: "+e.getMessage());
        }
    }
    public static void main(String[] args) {
        Scanner scr= new Scanner(System.in);
        while (true) { 
            System.out.println("");
            System.out.println("1. Create Database"); 
            System.out.println("2. Display Database");
            System.out.println("3. Delete Record");
            System.out.println("4. Update Record");
            System.out.println("5. Search Record");  
            System.out.println("6. Exit");
            System.out.println("Choose an option: ");
            System.out.println("");
            int ch =scr.nextInt();
            scr.nextLine();
            switch(ch){
                case 1:
                    createDatabase(scr);
                    break;
                case 2:
                    displayDatabase();
                    break;
                case 3:
                    deleteRecord(scr);
                    break;
                case 4:
                    updateRecord(scr);
                    break;
                case 5:
                    SearchRecord(scr);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Enter Correct Choice");
            }
        }
    }
}
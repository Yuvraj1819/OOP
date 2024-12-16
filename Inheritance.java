
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Employee{
		private String name;
		private String id;
		private String address;
		private String mailid;
		private String mobileno;
		
		public Employee(String name, String id, String address, String mailid, String mobileno) {
			this.name=name;
			this.id=id;
			this.address=address;
			this.mailid=mailid;
			this.mobileno=mobileno;
			
			
		}
		public void display() {
		System.out.println("Employee name: "+ name+"\n"+"Empleoyee id: "+id );
		System.out.println("Employee address: " +address);
		System.out.println("Employee mailid: " + mailid + "\n" +
        "Employee mobileno: "+ mobileno);
		}
		public void paySlip()
		{}
		
}
class Programmer extends Employee{
	private double BP;
	private String des;
	public Programmer(String name, String id, String address, String mailid, String mobileno, double bpay, 
			String des) {
		super(name, id, address, mailid, mobileno);
		BP=bpay;
		this.des=des;
	}
	public void paySlip() {
		double DA=BP*97/100;
		double HRA=BP*10/100;
		double GrossSalary=BP+DA+HRA;
		double PF=BP*12/100;
		double SCF=BP*0.1/100;
		double NetSalary=GrossSalary-PF-SCF;
		System.out.println("Employees Pay Slip");
		this.display();
		System.out.println("Designation: "+des);
		System.out.println("Basic Pay: "+BP);
		System.out.println("Gross Salary: "+GrossSalary +"\t" + "Net salary: "+NetSalary);
	}	
}

class Team_Lead extends Employee{
	private double BP;
	private String des;
	public Team_Lead(String name, String id, String address, String mailid, String mobileno, double bpay, 
			String des) {
		super(name, id, address, mailid, mobileno);
		BP=bpay;
		this.des=des;
	}
	public void paySlip() {
		double DA=BP*97/100;
		double HRA=BP*10/100;
		double GrossSalary=BP+DA+HRA;
		double PF=BP*12/100;
		double SCF=BP*0.1/100;
		double NetSalary=GrossSalary-PF-SCF;
		System.out.println("Employees Pay Slip");
		this.display();
		System.out.println("Designation: "+des);
		System.out.println("Basic Pay: "+BP);
		System.out.println("Gross Salary: "+GrossSalary +"\t" + "Net salary: "+NetSalary);
	}	
}

class Assistant_Project_Manager extends Employee{
	private double BP;
	private String des;
	public Assistant_Project_Manager(String name, String id, String address, String mailid, String mobileno, double bpay, 
			String des) {
		super(name, id, address, mailid, mobileno);
		BP=bpay;
		this.des=des;
	}
	public void paySlip() {
		double DA=BP*97/100;
		double HRA=BP*10/100;
		double GrossSalary=BP+DA+HRA;
		double PF=BP*12/100;
		double SCF=BP*0.1/100;
		double NetSalary=GrossSalary-PF-SCF;
		System.out.println("Employees Pay Slip");
		this.display();
		System.out.println("Designation: "+des);
		System.out.println("Basic Pay: "+BP);
		System.out.println("Gross Salary: "+GrossSalary +"\t" + "Net salary: "+NetSalary);
	}	
}

class Project_Manager extends Employee{
	private double BP;
	private String des;
	public Project_Manager(String name, String id, String address, String mailid, String mobileno, double bpay, 
			String des) {
		super(name, id, address, mailid, mobileno);
		BP=bpay;
		this.des=des;
	}
	public void paySlip() {
		double DA=BP*97/100;
		double HRA=BP*10/100;
		double GrossSalary=BP+DA+HRA;
		double PF=BP*12/100;
		double SCF=BP*0.1/100;
		double NetSalary=GrossSalary-PF-SCF;
		System.out.println("Employees Pay Slip");
		this.display();
		System.out.println("Designation: "+des);
		System.out.println("Basic Pay: "+BP);
		System.out.println("Gross Salary: "+GrossSalary +"\t" + "Net salary: "+NetSalary);
	}	
}

public class Inheritance{
	Employee e;
	ArrayList<Employee>obj=new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
		public void addEmployee() {
			System.out.println("Enter the Emp_Name:");
			String name=sc.next();
			System.out.println("Enter the Emp_Id:");
			String id=sc.next();
			System.out.println("Enter the Emp_Address:");
			String address=sc.next();
			System.out.println("Enter the Emp_Mailid:");
			String mailid=sc.next();
			System.out.println("Enter the Emp_Mobile No:");
			String mobileno=sc.next();
			System.out.println("Enter the Emp_Designation:");
			System.out.println("1. Programmer \n2. Team Lead \n3. Assistant Project Manager \n4. Project Manager");
			int c =sc.nextInt();
			System.out.println("Enter the Emp_basic Pay:");
			double bPay=sc.nextDouble();
			
			if(c==1) {
				e=new Programmer(name, id, address, mailid, mobileno, bPay, "Programmer");
				obj.add(e);
			}
			else if(c==2) {
				e=new Team_Lead(name, id, address, mailid, mobileno, bPay, "Programmer");
				obj.add(e);
			}
			else if(c==3) {
				e=new Assistant_Project_Manager(name, id, address, mailid, mobileno, bPay, "Programmer");
				obj.add(e);
			}
			else if(c==4) {
				e=new Project_Manager(name, id, address, mailid, mobileno, bPay, "Programmer");
				obj.add(e);
			}
			
		}
		
		public void displayEmployee()
		{
			for(Employee e:obj) {
				e.paySlip();
				System.out.println(".................................................");
			}
		}
		public static void main(String[]args)throws IOException{
			Inheritance x= new Inheritance();
			String check;
			Scanner scr = new Scanner(System.in);
			int ch=0;
			do {
				System.out.println(".................................................");
				System.out.println("Enter your choice: ");
				System.out.println("\n1. Add Employee \n2. Display Pay Slip");
				ch=scr.nextInt();
				System.out.println(".................................................");
				
				switch(ch) {
				case 1:
					x.addEmployee();
					System.out.println("For continue press 'c'");
					check=x.sc.next();
						break;
				case 2:
					x.displayEmployee();
					System.out.println("For continue press 'y'");
					check=x.sc.next();
						break;
				default :
					System.out.println("Enter correct choice");
						return;
					
				
				}
				
			}while(check.equalsIgnoreCase("c"));
		}
	
}



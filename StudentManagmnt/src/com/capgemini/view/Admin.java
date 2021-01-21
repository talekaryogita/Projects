package com.capgemini.view;
import java.util.Scanner;
import com.capgemini.service.*;

public class Admin {
	private static Scanner sc=new Scanner(System.in);
	private static StudentSchdlr studSch = new StudentSchdlr();
	public static void main(String[] args) {
		showMenu();
	}

	private static void showMenu() {
		
		int choice;
		
		while(true)
		{
			System.out.println("1.add student");
			System.out.println("2.show all students");
			System.out.println("3.Show all student details by roll no");
			System.out.println("4.show students detail by course name");
			System.out.println("5.show count by course name");
			System.out.println("6.Exit");
			
			System.out.println("Enter your choice");
			choice=sc.nextInt();
			
			
			switch(choice)
			{
			case 1:addStudentDetails();
			       break;
			       
			case 2:showAllStudents();
			       break;
			        
			case 3:showDetailsByRollNo();
			       break;
			      
			case 4:showDetailsByCourseName();
			       break;
			case 5:countByCourseName();
			       break;
			 case 6:System.exit(0);
			        break;
			        
			 default:System.out.println("Sorry entered wrong choice");
		  }
			
		}
		
	}

	private static void showAllStudents() {
		studSch.showAllStudents();
		
	}

	private static void addStudentDetails() {
		System.out.println("Enter roll number");
		int rollNumber=sc.nextInt();
		
		System.out.println("Enter name");
		String name = sc.next();
		
		System.out.println("Enter the number of subjects:");
		int num=sc.nextInt();
		String[] courses=new String[num];
		System.out.println("Enter the name of subjects:");
		for(int x=0;x<num;x++) {
			courses[x]=sc.next();
		}
		System.out.println(studSch.addStudent(rollNumber, name, courses));
	}
	
	private static void showDetailsByRollNo() {
		System.out.println("Enter roll NO");
		int rollNumber=sc.nextInt();
		studSch.showDetailsByRollNo(rollNumber);
		
	}
	
	private static void showDetailsByCourseName() {
		System.out.println("Enter Course Name:");
		String courses=sc.next();
		studSch.showDetailsByCourseName(courses);
		
	}
	
	private static void countByCourseName() {
		System.out.println("Enter Course Name:");
		String course=sc.next();
		studSch.countByCourseName(course);
		
	}

}

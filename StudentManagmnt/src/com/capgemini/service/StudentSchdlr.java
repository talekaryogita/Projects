package com.capgemini.service;
import com.capgemini.model.*;

public class StudentSchdlr {
	private Student[] students= new Student[10];
	private int counterStudent;
	
	public String addStudent(int rollNumber, String name, String[] courses)
	{
		students[counterStudent]=new Student(rollNumber, name, courses);
		counterStudent++;
		
		return "student added successfully";
	}
	public void countByCourseName(String course)
	{
		int count = 0;
		for(int i=0;i<counterStudent;i++) {
			String[] courses = students[i].getCourses();
			for(int j=0; j< courses.length;j++) {
				if(courses[j].equals(course)) {
					count++;
					break;
				}
			}
		}
		System.out.println("Students in course "+course+" are:"+count);
	}
	public void showAllStudents()
	{
		if(counterStudent == 0)
			System.out.println(" You have not added any student. please add student first,");
		else {
			System.out.println("Showing details of all students: ");
			
			for(int i=0;i<counterStudent;i++) {
				String[] courses=students[i].getCourses();
				System.out.println("Student RollNumber is "+students[i].getRollNumber());
				System.out.println("Student name is "+students[i].getName());
				System.out.println("Name of subjects are: ");
				for(int j=0;j<courses.length;j++) {
					System.out.println(courses[j]);
	}

}
		}}
	public void showDetailsByCourseName(String studcourse) {
		String Course1=studcourse;
		String courses[];
		for(int i=0;i<counterStudent;i++)
		{
			courses=students[i].getCourses();
			for(int j=0;j<courses.length;j++) {
				if(courses[j].equals(Course1)) {
					System.out.println("Student RollNumber is "+students[i].getRollNumber());
					System.out.println("Student name is "+students[i].getName());
					System.out.println("Name of subjects are: ");
					for(int x=0;x<courses.length;x++) {
						System.out.println(courses[x]);
					}
					break;
				}
			}
		}
	}
	public void showDetailsByRollNo(int rollNumber) {
		int roll1=rollNumber;
		String courses[];
		for(int i=0;i<counterStudent;i++)
		{
				if(students[i].getRollNumber() == roll1) {
					courses=students[i].getCourses();
					System.out.println("Student RollNumber is "+students[i].getRollNumber());
					System.out.println("Student name is "+students[i].getName());
					System.out.println("Name of subjects are: ");
					for(int j=0;j<courses.length;j++) {
						System.out.println(courses[j]);
					}
					break;
				}
				else
				{
					System.out.println("Student of this roll no. Not found");
				}
		}
	}
}

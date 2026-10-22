package com.jt.week1.student;

public class Student {
	
	public Student(String name, int rollNumber, double marks) {
		super();
		this.name = name;
		this.rollNumber = rollNumber;
		this.marks = marks;
	}

	String name;
		int rollNumber;
		double marks;
	
	public void displayDetails() {
		System.out.println("Roll Number: " + this.rollNumber);
		System.out.println("Name: " + this.name);
		System.out.println("Mark: " + this.marks);
	}

}

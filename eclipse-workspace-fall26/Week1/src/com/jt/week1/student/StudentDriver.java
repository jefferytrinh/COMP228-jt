package com.jt.week1.student;

import java.util.Scanner;

public class StudentDriver {
	public static void main(String[] args) {
		
		Student s1 = new Student("Peter", 21, 80.8);
		
		s1.toString();
		
		// dynamic inputs from user
		Scanner sc = new Scanner(System.in);
		String name;
			int rollNumber;
			double marks;
		name = sc.next();
		rollNumber = sc.nextInt();
		marks = sc.nextDouble();
		
		Student s2 = new Student(name, rollNumber, marks);
		
		s2.toString();
		
		sc.close();
		
	}

}

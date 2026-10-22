package com.jt.week1.ex2;

/*
 * @author Jeffery Trinh
 * @since 09/09/26
 * @version 1.0
 * Week 1 Addition class, sum values with Scanner object
 */

import java.util.Scanner;

public class Addition {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// sc is object to take keyboard input from user

			int no1;
			int no2;
			int sum;
			
			System.out.println("Addition calculator");
			System.out.println("Enter first no: ");
			no1 = sc.nextInt();
			System.out.println("Enter second no: ");
			no2 = sc.nextInt();
			
			sum = no1 + no2;
			System.out.println(no1 + " + " + no2 + " = " + sum);
		}
	}

}

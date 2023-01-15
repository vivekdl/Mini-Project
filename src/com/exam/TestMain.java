package com.exam;

import java.util.Scanner;

import com.exam.exception.InvalidInputException;
import com.exam.studentInterfcaeImpl.SudentInterfcaeImpl;
import com.exam.studentinterface.*;

public class TestMain {

	public static Scanner scanner = new Scanner(System.in);

	/*
	 * First page method
	 */

	public static void getFristPage() {
		StudentInterface impl = new SudentInterfcaeImpl();
		try {
			System.out.println('\n'
					+ "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< MAIN PORTAL >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
					+ '\n');
			System.out.println("FOR EXAM  PRESS>> 1" + '\n' + "TO GET ALL STUDENT RECORD PRESS>> 2" + '\n'
					+ "TO KNOW MARKS BY ID PRESS>> 3");
			int num = scanner.nextInt();
			int choice = num;
			switch (choice) {
			case 1:
				impl.getRegistrationDetails();
				break;
			case 2:
				impl.getAllStuentDetails();
				break;
			case 3:
				impl.getStuentDetails();
				break;
			default:
				System.out.println("####INVALID INPUT####");
				relogin();
			}
		} catch (Exception e) {
			System.out.println("INVALID INPUT TRY AGAIN");
			throw new InvalidInputException(relogin());

		}
	}

	/*
	 * Relogin to first page
	 */
	public static String relogin() {
		try {
			System.out.println('\n' + "GO TO MAIN PORTAL ->PRESS = 1 " + " & " + "TO EXIT PRESS = 2 ");
			int relogin = scanner.nextInt();
			if (relogin == 1) {
				getFristPage();
			} else if (relogin == 2) {
				System.out.println("Thank you");
			}
			
		} catch (Exception e) {
			System.out.println("INVALID INPUT TRY AGAIN");
			throw new InvalidInputException(relogin());
		}
		return "Error";
		
	}
	
	//Main Method 

	public static void main(String[] args) {
		getFristPage();
	}
}

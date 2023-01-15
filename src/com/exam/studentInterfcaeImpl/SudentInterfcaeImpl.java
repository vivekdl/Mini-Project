package com.exam.studentInterfcaeImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.exam.TestMain;
import com.exam.config.JdbcConfiguration;
import com.exam.exception.InvalidInputException;
import com.exam.studentDetails.StudentDetails;
import com.exam.studentinterface.StudentInterface;

public class SudentInterfcaeImpl implements StudentInterface {

	public static Scanner scanner = new Scanner(System.in);
	public static PreparedStatement ps = null;
	public static Connection connection = null;
	public static ResultSet rs = null;

	public void getRegistrationDetails() throws SQLException {
		StudentDetails q = new StudentDetails();

		for (int i = 0; i < 1; i++) {
			System.out.println("ENTER ID >>");
			int id = scanner.nextInt();
			q.setId(id);
			System.out.println("ENTER FIRST NAME >>");
			String fname = scanner.next();
			q.setFirstName(fname);
			System.out.println("ENTER LAST NAME >>");
			String lname = scanner.next();
			q.setLastName(lname);

		}
		examPage(q.getId(), q.getFirstName(), q.getLastName());
	}

	public static void examPage(int id, String fname, String lname) throws SQLException {
		System.out.println(
				'\n' + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<WELCOME TO CORE JAVA QUIZ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + '\n');
		System.out.println("QUIZ DETAILS" + '\n' + ">>NUMBER OF QUESTIONS = 10 " + '\n' + '\n'
				+ ">>THERE WILL BE NO NEGATIVE MARKING" + '\n'
				+ ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>BEST OF LUCK >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println('\n' + "TO START THE EXAM PRESS >>>>>  1  ");
		int start = scanner.nextInt();
		if (start == 1) {
			fetchQuestionsFromDatabase(id, fname, lname);
		} 
	}

	public static void fetchQuestionsFromDatabase(int id, String fname, String lname) throws SQLException {

		int score = 0;
		try {
			connection = JdbcConfiguration.getConnetionDetails();
			ps = connection.prepareStatement("select * from question order by rand()"); // query to fetch random
																						// questions
			rs = ps.executeQuery();
			int question = 0;
			int questionNo;
			while (rs.next()) {
				question++;
				questionNo = question;
				System.out.println("Q " + questionNo + " ] " + rs.getString(2));
				System.out.println("A)" + rs.getString(3));
				System.out.println("B)" + rs.getString(4));
				System.out.println("C)" + rs.getString(5));
				System.out.println("D)" + rs.getString(6));
				System.out.println("Enter your Answer>>");
				String response = scanner.next().toUpperCase();
				String ans = rs.getString(7);

				if (response.equals(ans)) {
					score++;
				}
			}
			System.out.println("Your Score is>>" + score + "/10");
			showGrade(score);
			saveStudentScoreCardDetails(id, fname, lname, score);
			TestMain.relogin();
		} catch (Exception e) {
			System.out.println("INVALID INPUT TRY AGAIN");
			throw new InvalidInputException(TestMain.relogin());
		} finally {
			connection.close();
		}

	}

	public static void showGrade(int marks) {
		if (marks <= 10 && marks >= 8) {
			System.out.println("Your Result is>>" + "CONGRATULATIONS YOU ARE PASS with Grade>> " + "Class A");
		} else if (marks <= 8 && marks >= 6) {
			System.out.println("Your Result is>>" + "CONGRATULATIONS YOU ARE PASS with Grade>> " + "Class B");
		} else if (marks == 5) {
			System.out.println("Your Result is>>" + "CONGRATULATIONS YOU ARE PASS with Grade>> " + "Class C");
		} else if (marks < 5) {
			System.out.println("Your Result is>>" + "SORRY YOU ARE FAIL ,YOUR Grade >> " + "Class D");
		}
	}

	public static void saveStudentScoreCardDetails(int id, String firstname, String lastname, int score)
			throws SQLException {

		try {
			connection = JdbcConfiguration.getConnetionDetails();
			ps = connection.prepareStatement("insert into studentinfo (id,fname,lname,score)values(?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, firstname);
			ps.setString(3, lastname);
			ps.setInt(4, score);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("INVALID INPUT TRY AGAIN");
			throw new InvalidInputException(TestMain.relogin());
		} finally {
			connection.close();
		}

	}

	public void getAllStuentDetails() throws SQLException {

		try {
			connection = JdbcConfiguration.getConnetionDetails();
			ps = connection.prepareStatement("select * from studentinfo");
			rs = ps.executeQuery();
			System.out.println("STUDENT DETAILS");
			while (rs.next()) {

				System.out.println('\n' + "ID=>" + rs.getInt(1) + '\n' + "NAME>>" + rs.getString(2) + "  "
						+ rs.getString(3) + '\n' + "Score=" + rs.getInt(4) + '\n' + '\n');
			}
			TestMain.getFristPage();
		} catch (Exception e) {
			System.out.println("INVALID INPUT TRY AGAIN");
			throw new InvalidInputException(TestMain.relogin());
		} finally {
			connection.close();
		}
	}

	public void getStuentDetails() throws SQLException {
		System.out.println("ENTER YOUR REGISTRATION ID>>");
		int idFromUser = scanner.nextInt();

		try {
			connection = JdbcConfiguration.getConnetionDetails();
			ps = connection.prepareStatement("select * from studentinfo");
			rs = ps.executeQuery();

			while (rs.next()) {
				int idfromDb = rs.getInt(1);
				if (idFromUser == idfromDb) {
					System.out.println('\n' + "YOUR ID>>" + idfromDb + '\n' + "NAME>>" + rs.getString(2) + " "
							+ rs.getString(3) + '\n' + "YOUR SCORE IS >>" + rs.getInt(4));
				} else {
					System.out.println("Student Record Not Found");
				}
			}
			TestMain.getFristPage();
		} catch (Exception e) {
			System.out.println("INVALID INPUT TRY AGAIN");
		} finally {
			connection.close();
		}

	}

}

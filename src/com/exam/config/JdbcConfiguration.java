package com.exam.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConfiguration {

	public static Connection getConnetionDetails() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}

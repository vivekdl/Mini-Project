package com.exam.studentinterface;

import java.sql.SQLException;

public interface StudentInterface {

	public void getAllStuentDetails() throws SQLException;

	public void getRegistrationDetails() throws SQLException;

	public void getStuentDetails() throws SQLException;
}

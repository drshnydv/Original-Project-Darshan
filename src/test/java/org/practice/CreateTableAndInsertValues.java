package org.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class CreateTableAndInsertValues {
	
	public static void main(String[] args) throws SQLException {
		//Create the object for DB driver class
		Driver dbDriver = new Driver();
		
		//register the driver of the JDBC
		DriverManager.registerDriver(dbDriver);
		
		Connection connection = null;
		
		try {
			
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet38", "root", "root");
		Statement statement = connection.createStatement();
		
		//statement.executeUpdate("create table EmpDetails(empId int(4) not null unique, empName varchar(30), phone_number int(10) not null unique, Address Varchar(50))");
		
		//statement.executeUpdate("RENAME TABLE EmpDetails to Shophunt");
		//System.out.println("tabel name updated");
		
		statement.executeUpdate("INSERT INTO shophunt VALUES(01,'DARSHAN',810580252,'MYSURU')");
		statement.executeUpdate("INSERT INTO shophunt VALUES(02,'RAJU',123456789,'BALLARY')");
		statement.executeUpdate("INSERT INTO shophunt VALUES(03,'SARAVANAN',123456788,'MADURAI')");
	    statement.executeUpdate("INSERT INTO shophunt VALUES(04,'SHARATH',123456777,'HASSAN')");
	    
		}
		
		finally {
			
			//close the connection
			connection.close();
			System.out.println("Connection closed");
			
		}
	}

}
package org.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchTheDataFromTheDatabase {
	
	public static void main(String[] args) throws SQLException {
	
	//Create object of driver for JDBC
	Driver driverref = new Driver();
	
	//register driver of the JDBC
	DriverManager.registerDriver(driverref);
	
	//Establishing connection with database - providing database_name
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet38", "root", "root");
	
	//Create statement
	Statement statement = connection.createStatement();
	
	//Fetching data
	
	String query = "select address from shophunt where empname = 'DARSHAN';";
	String expname = "MYSURU";
	ResultSet details = statement.executeQuery(query);
	
	boolean flag = false;
	
	while(details.next()) {
		
		String actname = details.getString(1);
		
		if(expname.equalsIgnoreCase(actname)) {
			System.out.println(actname);
			flag = true;
			break;
		}
		 
	}
	
	 if(flag) {
    	 System.out.println("data exists");
     }
     
     else {
    	 System.out.println("data not exist");
     }
	
     statement.close();
	
	}
}
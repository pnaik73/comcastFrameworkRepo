 package com.comcast.crm.generic.databaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection con;
	public void getDbConnection(String url,String username,String password ) throws SQLException {
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url,username,password);
		}
		catch (Exception e) {
		}
	}
	public void getDbConnection() throws SQLException {
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333","root@%","root");
		}
		catch (Exception e) {
		}
	}

	public void closeDbConnection() throws SQLException {
		try {
			con.close();
		}
		catch (Exception e) {
		}
	}
	public ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet result=null;
		try {
			Statement s = con.createStatement();
			result = s.executeQuery(query);
		}
		catch (Exception e) {
		}
		return result;
	}
	public int executeNonSelectQuery(String query) throws SQLException {
		int	result=0;
		try {
			Statement s = con.createStatement();
			result=s.executeUpdate(query);
		}
		catch (Exception e) {
		}
		return result;
	}
}
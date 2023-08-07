package com;
import java.sql.*;
public class DBCONN {
	protected String DBURL = "jdbc:mysql://localhost:3306/employee";
	protected String DBUSERNAME = "root";
	protected String DBPWD = "admin@3104";
	protected Connection con;
	public DBCONN() throws ClassNotFoundException, SQLException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(DBURL, DBUSERNAME, DBPWD);
			System.out.println("CONNECTION SUCCESSFULL!!");
		}catch(Exception e) {
			System.out.println("Exception faced..");
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		DBCONN obj = new DBCONN();
		
	}
}

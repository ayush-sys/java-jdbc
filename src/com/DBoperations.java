package com;

import java.sql.*;
import java.util.Scanner;

public class DBoperations extends DBCONN {

	static Scanner in = new Scanner(System.in);

	public DBoperations() throws ClassNotFoundException, SQLException {
		super();

	}

	public void insert() {
		String insertQuery = "insert into empdetails values (?,?,?,?,?)";
		try {
			System.out.print("Enter emp id : ");
			int id = in.nextInt();
			System.out.print("Enter emp name : ");
			String name = in.next();
			System.out.print("Enter emp designation : ");
			String desg = in.next();
			System.out.print("Enter emp age : ");
			int age = in.nextInt();
			System.out.print("Enter emp salary : ");
			double sal = in.nextDouble();
			PreparedStatement stmt = con.prepareStatement(insertQuery);
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setString(3, desg);
			stmt.setInt(4, age);
			stmt.setDouble(5, sal);
			stmt.executeUpdate();
			System.out.println("Record inserted succesfully !!");
			viewAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update() {
		System.out.print("Enter emp id : ");
		int eid = in.nextInt();
		System.out.println("1. Emp name");
		System.out.println("2. Emp desg");
		System.out.println("3. Emp age");
		System.out.println("4. Emp salary");
		System.out.println("Enter what you want to change ?");
		int choice = in.nextInt();
		try {
			switch (choice) {
			case 1:
				System.out.println("Enter new name : ");
				String name = in.next();
				PreparedStatement stmt = con.prepareStatement("update empdetails set empname=? where empid=?");
				stmt.setString(1, name);
				stmt.setInt(2, eid);
				stmt.executeUpdate();
				System.out.println("Name updated succesfully!!");
				break;
			case 2:
				System.out.println("Enter new desg : ");
				String desg = in.next();
				PreparedStatement stmt2 = con.prepareStatement("update empdetails set empdesg=? where empid=?");
				stmt2.setString(1, desg);
				stmt2.setInt(2, eid);
				stmt2.executeUpdate();
				System.out.println("Desg updated succesfully!!");
				break;
			case 3:
				System.out.println("Enter new age : ");
				int age = in.nextInt();
				PreparedStatement stmt3 = con.prepareStatement("update empdetails set empage=? where empid=?");
				stmt3.setInt(1, age);
				stmt3.setInt(2, eid);
				stmt3.executeUpdate();
				System.out.println("Age updated succesfully!!");
				break;
			case 4:
				System.out.println("Enter new salary : ");
				double sal = in.nextDouble();
				PreparedStatement stmt4 = con.prepareStatement("update empdetails set empsal=? where empid=?");
				stmt4.setDouble(1, sal);
				stmt4.setInt(2, eid);
				stmt4.executeUpdate();
				System.out.println("Salary updated succesfully!!");
				break;
			default:
				System.out.println("Please check your input!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteById() {
		String deleteByIdQuery = "delete from empdetails where empid=?";
		try {
			System.out.println("Enter id : ");
			int id = in.nextInt();
			PreparedStatement stmt = con.prepareStatement(deleteByIdQuery);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("Record deleted succesfully!!");
		} catch (Exception e) {
			System.out.println("Error faced!!");
			e.printStackTrace();
		}
	}

	public void deleteAll() {
		String deleteAllQuery = "truncate empdetails";
		try {
			Statement stmt = con.createStatement();
			stmt.execute(deleteAllQuery);
			System.out.println("All records deleted succesfully!!");
		} catch (Exception e) {
			System.out.println("Error faced!!");
			e.printStackTrace();
		}
	}

	public void viewById() {
		String viewByIdQuery = "select * from empdetails where empid=?";
		try {
			System.out.println("Enter id : ");
			int id = in.nextInt();
			PreparedStatement stmt = con.prepareStatement(viewByIdQuery);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			System.out.println("---------------------------------------------------");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "	");
				System.out.print(rs.getString(2) + "	");
				System.out.print(rs.getString(3) + "	");
				System.out.print(rs.getInt(4) + "	");
				System.out.print(rs.getDouble(5) + "	");
				System.out.println();
			}
			System.out.println("---------------------------------------------------");
		} catch (Exception e) {
			System.out.println("Error faced!!");
			e.printStackTrace();
		}
	}

	public void viewAll() {
		String viewAllQuery = "select * from empdetails";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(viewAllQuery);
			System.out.println("---------------------------------------------------");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "	");
				System.out.print(rs.getString(2) + "	");
				System.out.print(rs.getString(3) + "	");
				System.out.print(rs.getInt(4) + "	");
				System.out.print(rs.getDouble(5) + "	");
				System.out.println();
			}
			System.out.println("---------------------------------------------------");
		} catch (Exception e) {
			System.out.println("Error faced!!");
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		DBoperations dbops = new DBoperations();

		while (true) {
			System.out.println("1. Insert");
			System.out.println("2. Update");
			System.out.println("3. View");
			System.out.println("4. View all");
			System.out.println("5. Delete");
			System.out.println("6. Delete all");
			System.out.println("7. Exit");
			System.out.print("Enter your choice : ");
			int choice = in.nextInt();
			switch (choice) {
			case 1:
				dbops.insert();
				break;
			case 2:
				dbops.update();
				break;
			case 3:
				dbops.viewById();
				break;
			case 4:
				dbops.viewAll();
				break;
			case 5:
				dbops.deleteById();
				break;
			case 6:
				dbops.deleteAll();
				break;
			case 7:
				System.exit(0);
				break;
			default:
				System.out.println("Please check your input!!");
				break;
			}
		}
	}

}

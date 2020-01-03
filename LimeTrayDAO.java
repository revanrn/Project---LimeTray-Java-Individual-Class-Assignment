package com.deloitte.library.dao;

import java.sql.*;
import java.util.*;

import com.deloitte.library.model.LimeTray;

public class LimeTrayDAO {
	public static Connection connectToDB() {
		Connection connection = null;
		try {// Register the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Create Connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static void addUsers(LimeTray user) {
		try {
			Connection con = connectToDB();
			// Create Statement
			PreparedStatement stmt = con.prepareStatement("insert into registration values(?,?,?,?,?)");
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getUserId());
			stmt.setString(3, user.getPassword());
			stmt.setLong(4, user.getPhone());
			stmt.setString(5, user.getEmail());
			// Execute SQL query
			int affectedrows = stmt.executeUpdate();
			System.out.println("Affected Rows = " + affectedrows);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static boolean signIn(String userId, String password) {
		boolean flag = false;
		try {
			Connection con = connectToDB();
			// Create Statement
			PreparedStatement stmt = con.prepareStatement(
					"select * from registration where userid = '" + userId + "' and password = '" + password + "'");
			int affectedrows = stmt.executeUpdate();
			if (affectedrows == 1)
				return flag = true;
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public static List<LimeTray> displayUsers() {
		List<LimeTray> usersList = new ArrayList<LimeTray>();
		try {
			Connection con = connectToDB();
			PreparedStatement stmt = con.prepareStatement("select * from registration");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				LimeTray users = new LimeTray();
				users.setUserName(rs.getString(1));
				users.setUserId(rs.getString(2));
				users.setPassword(rs.getString(3));
				users.setPhone(rs.getLong(4));
				users.setEmail(rs.getString(5));
				usersList.add(users);
			}

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usersList;

	}

}

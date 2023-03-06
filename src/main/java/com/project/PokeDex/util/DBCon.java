package com.project.PokeDex.util;

import java.sql.*;

public class DBCon {
	private static String url = "jdbc:mysql://localhost:3306/pokemonnew";
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String username = "root";
    private static String password = "I~992kqo";
    private static Connection con;
	
    public static Connection getConnection() {
		try {
			Class.forName(driverName);
			try {
				con = DriverManager.getConnection(url, username, password);
			}catch(SQLException ex) {
				System.out.println("Failed to creat the database connection.");
			}
		}catch(ClassNotFoundException ex) {
			System.out.println("Driver not found.");
		}
		return con;
	}
}

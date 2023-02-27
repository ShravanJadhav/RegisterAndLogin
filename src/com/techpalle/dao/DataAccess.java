package com.techpalle.dao;

import java.sql.*;
import java.util.Arrays;

import com.techpalle.model.Customer;
public class DataAccess 
{
	private static final  String dbUrl = "jdbc:mysql://localhost:3306/J2eePalle";
	private static final  String dbUsername = "root";
	private static final  String dbPassword = "Shravan@844";
	
	private static Connection con = null;
	//private static Statement stm = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs=null;
	
	private static final String insertQuery = "insert into customer(name, email,mobile,password,state) values (?,?,?,?,?)";
	
	private static final String validateQuery = "select email,password from customer where email=? and password=?";
	
	public static boolean validateCustomer(String email, String password ) {
		boolean b = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			
			ps = con.prepareStatement(validateQuery);
			 
			ps.setString(1,email);
			ps.setString(2, password);
			 
			rs = ps.executeQuery();
			
			b = rs.next();
			 
				
					
		} catch (ClassNotFoundException e) {
			 
			e.printStackTrace();
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		finally {
			 
				try {
					if(rs!=null)
						rs.close();
					if(ps!=null)
						ps.close();
					if(con!=null)
						con.close();
				} catch (SQLException e) {
					 
					e.printStackTrace();
				}
			
		}
		return b;
		
}
	
	public static void insertCustomer(Customer customer)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			
			ps = con.prepareStatement(insertQuery);
			
			ps.setString(1,customer.getName());
			ps.setString(2, customer.getEmail());
			ps.setLong(3, customer.getMobile());
			ps.setString(4, customer.getPassword());
			ps.setString(5, customer.getState());
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			 
			e.printStackTrace();
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		finally {
			 
				try {
					if(ps!=null)
						ps.close();
					if(con!=null)
						con.close();
				} catch (SQLException e) {
					 
					e.printStackTrace();
				}
			
		}
		
	}

}

package com.management.hospital.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.management.hospital.domain.Patient;

// ALL THE DAL CLASSES WILL INHERIT METHODS FROM THIS CLASS
public class BaseDAL {
	 Connection connection =null;
	private String url = "jdbc:mysql://localhost:3306/hospital_managementdb";
	private  String user = "root";
	private String password = "argita040";
	
	public BaseDAL()  {
		setConnection();
		
	}


	
	public void commitStatement(String query) {
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.executeUpdate();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "An error occured due invalid/conflict in customer data inputted.", "",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}
	
	
	//CONNECTS TO THE DATABASE
	public void setConnection() {
		
		try {
			
			Connection connection = DriverManager.getConnection(url, user, password);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//GETS THE NEXT ID
	public long getNextId(String nextIdQuery) {
		try {
			long id = 0;

			ResultSet rs = getResultSet(nextIdQuery);
			if (rs.next()) {
				id = rs.getInt(1);
			}
			return id++;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "An error occured due invalid/conflict in customer data inputted.", "",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return 0;
		}
	}

	
	//RETURNS THE RESULT
	public ResultSet getResultSet(String query) {
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			return rs;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "An error occured due invalid/conflict in customer data inputted.", "",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return null;
		}
	}
	
	
	


		
		public int getTableNextId(String query) {
			int id = 0;
			try {
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(query);
				if (rs.next()) {
					id = rs.getInt(1);
					id = id + 1;
				}
				return id;

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "An error occured due invalid/conflict in customer data inputted.", "",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
				return 0;
			}
		
	}

}
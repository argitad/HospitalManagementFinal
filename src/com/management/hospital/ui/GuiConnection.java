package com.management.hospital.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class GuiConnection {
	Connection connection= null;
	public static Connection setGuiConnection()  {
         try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_managementdb",
					"root", "argita040317");
			JOptionPane.showMessageDialog(null, "Database Connection Successful!");
			 return connection;
		 
         } catch (SQLException e) {
        	 e.printStackTrace();
        	 return null;
         }
        
	}

}

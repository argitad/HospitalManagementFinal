package com.management.hospital.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;

import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
  

public class DoctorFrame extends JFrame  {

	public JFrame frame1;

	private JTextField doctorNameTextField;
	private JTextField doctorSurnameTextField;
	private JTextField doctorAgeTextField;
	private JTextField doctorAddressTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorFrame window1 = new DoctorFrame();
					window1.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	 Connection connection= null;   //initializes the connection with the database
	 
	 private JTable doctorTable;
	 DefaultTableModel dm;
	 private JTextField textField;
	 private JTextField doctorIdTextField;
	
	/**
	 * Create the application.
	 * @throws ClassNotFoundException 
	 */
	public DoctorFrame() {
		initialize1();
		connection= GuiConnection.setGuiConnection();   //creates the connection with the database
	
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize1() {
		frame1 = new JFrame();
		frame1.getContentPane().setBackground(new Color(176, 196, 222));
		frame1.setBounds(100, 100, 692, 382);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
	
		JLabel doctorHeaderLabel = new JLabel("Doctor's Profile");
		doctorHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		doctorHeaderLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		doctorHeaderLabel.setBounds(85, 11, 505, 31);
		frame1.getContentPane().add(doctorHeaderLabel);
		
		JLabel doctorIdLabel = new JLabel("ID");
		doctorIdLabel.setBounds(60, 53, 46, 14);
		frame1.getContentPane().add(doctorIdLabel);
		
		JLabel doctorNameLabel = new JLabel("Name");
		doctorNameLabel.setBounds(60, 126, 46, 14);
		frame1.getContentPane().add(doctorNameLabel);
		
		JLabel doctorSurnameLabel = new JLabel("Surname");
		doctorSurnameLabel.setBounds(60, 151, 60, 14);
		frame1.getContentPane().add(doctorSurnameLabel);
		
		JLabel doctorAgeLabel = new JLabel("Age");
		doctorAgeLabel.setBounds(60, 176, 46, 14);
		frame1.getContentPane().add(doctorAgeLabel);
		
		JLabel doctorGenderLabel = new JLabel("Gender");
		doctorGenderLabel.setBounds(60, 201, 46, 14);
		frame1.getContentPane().add(doctorGenderLabel);
		
		JLabel doctorAddressLabel = new JLabel("Address");
		doctorAddressLabel.setBounds(60, 226, 60, 14);
		frame1.getContentPane().add(doctorAddressLabel);
		
		
		
		doctorIdTextField = new JTextField();
		doctorIdTextField.setBounds(150, 53, 86, 20);
		frame1.getContentPane().add(doctorIdTextField);
		doctorIdTextField.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(150, 120, 86, 20);
		frame1.getContentPane().add(textField);
		textField.setColumns(10);
		
		doctorSurnameTextField = new JTextField();
		doctorSurnameTextField.setBounds(150, 145, 86, 20);
		frame1.getContentPane().add(doctorSurnameTextField);
		doctorSurnameTextField.setColumns(10);
		
		doctorAgeTextField = new JTextField();
		doctorAgeTextField.setBounds(150, 173, 86, 20);
		frame1.getContentPane().add(doctorAgeTextField);
		doctorAgeTextField.setColumns(10);
		
		String[] messageStrings= {"Male", "Female"};
		JComboBox doctorGenderComboBox = new JComboBox(messageStrings);
		doctorGenderComboBox.setBounds(150, 197, 86, 22);
		frame1.getContentPane().add(doctorGenderComboBox);
		
		doctorAddressTextField = new JTextField();
		doctorAddressTextField.setBounds(150, 222, 86, 22);
		frame1.getContentPane().add(doctorAddressTextField);
		doctorAddressTextField.setColumns(10);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(276, 53, 357, 159);
        frame1.getContentPane().add(scrollPane);
		
        doctorTable = new JTable();
        scrollPane.setViewportView(doctorTable);
		doctorTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//Create buttons and add ActionListeners
		JButton doctorInsertButton = new JButton("Add");
		doctorInsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                   try {
					
					String query = "INSERT INTO doctor  (name, surname, age, gender, address)"
							+" VALUES ( ?, ?, ?, ?, ?)";
					PreparedStatement ps = connection.prepareStatement(query);
					
					ps.setString(1, textField.getText());
					ps.setString(2, doctorSurnameTextField.getText());
					ps.setString(3, doctorAgeTextField.getText());
					ps.setObject(4, doctorGenderComboBox.getSelectedItem());
					ps.setString(5, doctorAddressTextField.getText());
					ps.executeUpdate();
					
				 
		         } catch (SQLException e) {
		        	 e.printStackTrace();
		        	 
		         }
			}
		});
		
			
		doctorInsertButton.setBounds(135, 277, 89, 23);
		frame1.getContentPane().add(doctorInsertButton);
		
		
		
		JButton doctorUpdateButton = new JButton("Edit");
		doctorUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					String query = "UPDATE doctor SET  name = ?, surname= ?, age= ?, gender=?, "
							+ " address = ? WHERE doctor_id = ?";
					PreparedStatement ps = connection.prepareStatement(query);
					ps.setString(6, doctorIdTextField.getText());
					ps.setString(1, textField.getText());
					ps.setString(2, doctorSurnameTextField.getText());
					ps.setString(3, doctorAgeTextField.getText());
					ps.setObject(4, doctorGenderComboBox.getSelectedItem());
					ps.setString(5, doctorAddressTextField.getText());
					
					ps.executeUpdate();
				 
		         } catch (SQLException e) {
		        	 e.printStackTrace();
		        	 
		         }
			 
			}
		});                       
		doctorUpdateButton.setBounds(289, 277, 89, 23);
		frame1.getContentPane().add(doctorUpdateButton);
		
		JButton doctorDeleteButton = new JButton("Delete");
		doctorDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                    try {
					
					String query = "DELETE FROM doctor WHERE doctor_id = ?";
					PreparedStatement ps = connection.prepareStatement(query);
					ps.setString(1, doctorIdTextField.getText());
					ps.executeUpdate();
					
				 
		         } catch (SQLException e) {
		        	 e.printStackTrace();
		        	 
		         }
			}  
			
		});
		
	
			
		doctorDeleteButton.setBounds(453, 277, 89, 23);
		frame1.getContentPane().add(doctorDeleteButton);
		
		JButton doctorPreviousButton = new JButton("BACK");
		doctorPreviousButton.setBounds(17, 309, 89, 23);
		frame1.getContentPane().add(doctorPreviousButton);
		
		JButton doctorNextButton = new JButton("NEXT");
		doctorNextButton.setBounds(563, 309, 89, 23);
		frame1.getContentPane().add(doctorNextButton);
		
		JButton refreshButton = new JButton("Refresh Table");
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try {
						
						String query = "SELECT * FROM doctor";
						PreparedStatement ps = connection.prepareStatement(query);
						ResultSet rs = ps.executeQuery();
						doctorTable.setModel(DbUtils.resultSetToTableModel(rs));
						
					 
			         } catch (SQLException e) {
			        	 e.printStackTrace();
			        	 
			         }
			
			}
		});
		refreshButton.setBounds(478, 222, 155, 23);
		frame1.getContentPane().add(refreshButton);
		
		doctorPreviousButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(java.awt.event.ActionEvent evt){ 
				
				frame1.setVisible(false);
				
				WelcomeFrame window = new WelcomeFrame();
				window.frame.setVisible(true);
				
			        }
		});
		
		doctorNextButton.addActionListener(new ActionListener(){ 
			public void actionPerformed(java.awt.event.ActionEvent evt){ 
				
				frame1.setVisible(false);
				
				LaboratoryFrame window2 = new LaboratoryFrame();
				window2.frame2.setVisible(true);
			        }
		});
		
		
		
	}
}

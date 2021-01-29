package com.management.hospital.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class PatientFrame {

	JFrame frame3;
	private JTextField patientNameTextField;
	private JTextField patientSurnameTextField;
	private JTextField patientAgeTextField;
	private JTextField patientAddressTextField;
	private JTextField patientDiseaseTextField;
	private JTextField patientDoctorIdTextField;
	private JTable patientTable;
	private JTextField patientIdTextField;
	 
	 Connection connection= null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientFrame window3 = new PatientFrame();
					window3.frame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PatientFrame() {
		initialize3();
		connection= GuiConnection.setGuiConnection();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize3() {
		frame3 = new JFrame();
		frame3.setBounds(100, 100, 692, 382);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.getContentPane().setLayout(null);
		
		JLabel patientHeaderLabel = new JLabel("Patient's Profile");
		patientHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		patientHeaderLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		patientHeaderLabel.setBounds(59, 11, 536, 25);
		frame3.getContentPane().add(patientHeaderLabel);
		
		JLabel patientIdLabel = new JLabel("ID");
		patientIdLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		patientIdLabel.setBounds(22, 47, 68, 14);
		frame3.getContentPane().add(patientIdLabel);
		
		JLabel patientNameLabel = new JLabel("Name");
		patientNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		patientNameLabel.setBounds(44, 86, 46, 14);
		frame3.getContentPane().add(patientNameLabel);
		
		JLabel patientSurnameLabel = new JLabel("Surname");
		patientSurnameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		patientSurnameLabel.setBounds(10, 111, 80, 14);
		frame3.getContentPane().add(patientSurnameLabel);
		
		JLabel patientAgeLabel = new JLabel("Age");
		patientAgeLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		patientAgeLabel.setBounds(44, 136, 46, 14);
		frame3.getContentPane().add(patientAgeLabel);
		
		JLabel patientGenderLabel = new JLabel("Gender");
		patientGenderLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		patientGenderLabel.setBounds(22, 161, 68, 14);
		frame3.getContentPane().add(patientGenderLabel);
		
		JLabel patientAddressLabel = new JLabel("Address");
		patientAddressLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		patientAddressLabel.setBounds(10, 186, 80, 14);
		frame3.getContentPane().add(patientAddressLabel);
		
		JLabel patientDiseaseLabel = new JLabel("Disease");
		patientDiseaseLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		patientDiseaseLabel.setBounds(22, 211, 68, 14);
		frame3.getContentPane().add(patientDiseaseLabel);
		
		JLabel patientDoctorIdLabel = new JLabel("Doctor's ID");
		patientDoctorIdLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		patientDoctorIdLabel.setBounds(22, 236, 68, 14);
		frame3.getContentPane().add(patientDoctorIdLabel);
		
		
		patientIdTextField = new JTextField();
		patientIdTextField.setBounds(131, 47, 86, 20);
		frame3.getContentPane().add(patientIdTextField);
		patientIdTextField.setColumns(10);
		
		patientNameTextField = new JTextField();
		patientNameTextField.setBounds(131, 83, 86, 20);
		frame3.getContentPane().add(patientNameTextField);
		patientNameTextField.setColumns(10);
		
		patientSurnameTextField = new JTextField();
		patientSurnameTextField.setBounds(131, 108, 86, 20);
		frame3.getContentPane().add(patientSurnameTextField);
		patientSurnameTextField.setColumns(10);
		
		patientAgeTextField = new JTextField();
		patientAgeTextField.setBounds(131, 133, 86, 20);
		frame3.getContentPane().add(patientAgeTextField);
		patientAgeTextField.setColumns(10);
		
		String[] messageStrings= {"Male", "Female"};
		JComboBox patientComboBox = new JComboBox(messageStrings);
		patientComboBox.setBounds(131, 157, 86, 22);
		frame3.getContentPane().add(patientComboBox);
		
		patientAddressTextField = new JTextField();
		patientAddressTextField.setBounds(131, 183, 86, 20);
		frame3.getContentPane().add(patientAddressTextField);
		patientAddressTextField.setColumns(10);
		
		patientDiseaseTextField = new JTextField();
		patientDiseaseTextField.setBounds(131, 208, 86, 20);
		frame3.getContentPane().add(patientDiseaseTextField);
		patientDiseaseTextField.setColumns(10);
		
		patientDoctorIdTextField = new JTextField();
		patientDoctorIdTextField.setBounds(131, 233, 86, 20);
		frame3.getContentPane().add(patientDoctorIdTextField);
		patientDoctorIdTextField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(264, 58, 374, 156);
		frame3.getContentPane().add(scrollPane);
		
		patientTable = new JTable();
		scrollPane.setViewportView(patientTable);
		
		JButton patientInsertButton = new JButton("INSERT");
		patientInsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 try {
						
						String query = "INSERT INTO patient  (name, surname, age, gender, address, disease, doctor_id)"
								+" VALUES ( ?, ?, ?, ?, ?, ?, ?)";
						PreparedStatement ps = connection.prepareStatement(query);
						
						ps.setString(1, patientNameTextField.getText());
						ps.setString(2, patientSurnameTextField.getText());
						ps.setString(3, patientAgeTextField.getText());
						ps.setObject(4, patientComboBox.getSelectedItem());
						ps.setString(5, patientAddressTextField.getText());
						ps.setString(6, patientDiseaseTextField.getText());
						ps.setString(7, patientDoctorIdTextField.getText());
						ps.executeUpdate();
						ResultSet rs = ps.executeQuery();
						patientTable.setModel(DbUtils.resultSetToTableModel(rs));
					 
			         } catch (SQLException e) {
			        	 e.printStackTrace();
			        	 
			         }
			}
		});
		patientInsertButton.setBounds(131, 267, 89, 23);
		frame3.getContentPane().add(patientInsertButton);
		
		JButton patientUpdateButton = new JButton("UPDATE");
		patientUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try {
						
						String query = "UPDATE patient SET  name = ?, surname= ?, age= ?, gender=?,"
								+ " address = ?, disease = ?, doctor_id = ? WHERE patient_id = ?";
						PreparedStatement ps = connection.prepareStatement(query);
						ps.setString(8, patientIdTextField.getText());
						ps.setString(1, patientNameTextField.getText());
						ps.setString(2, patientSurnameTextField.getText());
						ps.setString(3, patientAgeTextField.getText());
						ps.setObject(4, patientComboBox.getSelectedItem());
						ps.setString(5, patientAddressTextField.getText());
						ps.setString(6, patientDiseaseTextField.getText());
						ps.setString(7, patientDoctorIdTextField.getText());
						ps.executeUpdate();
						ResultSet rs = ps.executeQuery();
						patientTable.setModel(DbUtils.resultSetToTableModel(rs));
					 
			         } catch (SQLException e) {
			        	 e.printStackTrace();
			        	 
			         }
				 
				
			}
		});
		patientUpdateButton.setBounds(291, 267, 89, 23);
		frame3.getContentPane().add(patientUpdateButton);
		
		JButton patientDeleteButton = new JButton("DELETE");
		patientDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					String query = "DELETE FROM patient WHERE patient_id = ?";
					PreparedStatement ps = connection.prepareStatement(query);
					
					ps.setString(1, patientIdTextField.getText());
					ps.executeUpdate();
					ResultSet rs = ps.executeQuery();
					patientTable.setModel(DbUtils.resultSetToTableModel(rs));
				 
		         } catch (SQLException e) {
		        	 e.printStackTrace();
		        	 
		         }
			}
		});
		patientDeleteButton.setBounds(461, 267, 89, 23);
		frame3.getContentPane().add(patientDeleteButton);
		
		JButton patientPreviousButton = new JButton("Previous");
		patientPreviousButton.setBounds(10, 309, 89, 23);
		frame3.getContentPane().add(patientPreviousButton);
		
		JButton patientNextButton = new JButton("Next");
		patientNextButton.setBounds(577, 309, 89, 23);
		frame3.getContentPane().add(patientNextButton);
		
		JButton btnNewButton = new JButton("Refresh Table");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					String query = "SELECT * FROM patient";
					PreparedStatement ps = connection.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					patientTable.setModel(DbUtils.resultSetToTableModel(rs));
					
				 
		         } catch (SQLException e) {
		        	 e.printStackTrace();
		        	 
		         }
			}
		});
		btnNewButton.setBounds(441, 221, 198, 23);
		frame3.getContentPane().add(btnNewButton);
		
		
		
		patientPreviousButton.addActionListener(new ActionListener(){ 
			public void actionPerformed(java.awt.event.ActionEvent evt){ 
				WelcomeFrame window = new WelcomeFrame();
				window.frame.setVisible(true);
			        }
		});
		
		patientNextButton.addActionListener(new ActionListener(){ 
			public void actionPerformed(java.awt.event.ActionEvent evt){ 
				RoomFrame window4 = new RoomFrame();
				window4.frame4.setVisible(true);
			        }
		});
	}
}

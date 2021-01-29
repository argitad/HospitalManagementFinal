package com.management.hospital.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionEvent;

public class BillFrame {

	JFrame frame5;
	private JTextField billNumberTextField;
	private JTextField doctorChargeTextField;
	private JTextField roomChargeTextField;
	private JTextField noOfDaysTextField;
	private JTextField billLabChargeTextField;
	
	 Connection connection= null;
	 private JTextField patientIdTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillFrame window5 = new BillFrame();
					window5.frame5.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BillFrame() {
		initialize5();
		connection= GuiConnection.setGuiConnection();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize5() {
		frame5 = new JFrame();
		frame5.setBounds(100, 100, 464, 361);
		frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame5.getContentPane().setLayout(null);
		
		JLabel billHeaderLabel = new JLabel("Bill");
		billHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		billHeaderLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		billHeaderLabel.setBounds(66, 11, 320, 14);
		frame5.getContentPane().add(billHeaderLabel);
		
		JLabel billNumberLabel = new JLabel("Number");
		billNumberLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		billNumberLabel.setBounds(10, 58, 102, 14);
		frame5.getContentPane().add(billNumberLabel);
		
		JLabel patientIdLabel = new JLabel("Patient ID");
		patientIdLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		patientIdLabel.setBounds(20, 83, 93, 14);
		frame5.getContentPane().add(patientIdLabel);
		
		JLabel billDoctorChargeLabel = new JLabel("Doctor Charge");
		billDoctorChargeLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		billDoctorChargeLabel.setBounds(10, 114, 102, 14);
		frame5.getContentPane().add(billDoctorChargeLabel);
		
		JLabel billRoomChargeLabel = new JLabel("Room Charge");
		billRoomChargeLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		billRoomChargeLabel.setBounds(10, 139, 102, 14);
		frame5.getContentPane().add(billRoomChargeLabel);
		
		JLabel lblNewLabel_4 = new JLabel("No of Days");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4.setBounds(10, 164, 102, 14);
		frame5.getContentPane().add(lblNewLabel_4);
		
		JLabel billLabChargeLabel = new JLabel("Lab Charge");
		billLabChargeLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		billLabChargeLabel.setBounds(10, 189, 102, 14);
		frame5.getContentPane().add(billLabChargeLabel);
		
		billNumberTextField = new JTextField();
		billNumberTextField.setBounds(134, 55, 86, 20);
		frame5.getContentPane().add(billNumberTextField);
		billNumberTextField.setColumns(10);
		
		patientIdTextField = new JTextField();
		patientIdTextField.setBounds(134, 80, 86, 20);
		frame5.getContentPane().add(patientIdTextField);
		patientIdTextField.setColumns(10);
		
		doctorChargeTextField = new JTextField();
		doctorChargeTextField.setBounds(134, 111, 86, 20);
		frame5.getContentPane().add(doctorChargeTextField);
		doctorChargeTextField.setColumns(10);
		
		roomChargeTextField = new JTextField();
		roomChargeTextField.setBounds(134, 136, 86, 20);
		frame5.getContentPane().add(roomChargeTextField);
		roomChargeTextField.setColumns(10);
		
		billLabChargeTextField = new JTextField();
		billLabChargeTextField.setBounds(134, 186, 86, 20);
		frame5.getContentPane().add(billLabChargeTextField);
		billLabChargeTextField.setColumns(10);
		
		noOfDaysTextField = new JTextField();
		noOfDaysTextField.setBounds(134, 161, 86, 20);
		frame5.getContentPane().add(noOfDaysTextField);
		noOfDaysTextField.setColumns(10);
		
		JButton billInsertButton = new JButton("INSERT");
		billInsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try {
						
						String query = "INSERT INTO bill(bill_no, patient_id, doctor_charge, room_charge, no_of_days, lab_charge)"
								+ "VALUES (?, ?, ?, ?, ?, ?)";
						PreparedStatement ps = connection.prepareStatement(query);
						
						ps.setString(1, billNumberTextField.getText());
						ps.setString(2, patientIdTextField.getText());
						ps.setString(3, doctorChargeTextField.getText());
						ps.setString(4, roomChargeTextField.getText());
						ps.setString(5, noOfDaysTextField.getText());
						ps.setString(6, billLabChargeTextField.getText());
						ps.executeUpdate();
						ResultSet rs = ps.executeQuery();
						
					 
			         } catch (SQLException e) {
			        	 e.printStackTrace();
			        	 
			         }
			}
		});
		billInsertButton.setBounds(117, 232, 89, 23);
		frame5.getContentPane().add(billInsertButton);
		
		JButton billUpdateButton = new JButton("UPDATE");
		billUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try {
						
						String query = "UPDATE bill SET doctor_charge= ?, room_charge=?, no_of_days= ?, "
								+ "	lab_charge=? WHERE bill_no= ?";
						PreparedStatement ps = connection.prepareStatement(query);
						
						ps.setString(5, billNumberTextField.getText());
						ps.setString(1, doctorChargeTextField.getText());
						ps.setString(2, roomChargeTextField.getText());
						ps.setString(3, noOfDaysTextField.getText());
						ps.setString(4, billLabChargeTextField.getText());
						ps.executeUpdate();
						ResultSet rs = ps.executeQuery();
						
					 
			         } catch (SQLException e) {
			        	 e.printStackTrace();
			        	 
			         }
			}
		});
		billUpdateButton.setBounds(278, 232, 89, 23);
		frame5.getContentPane().add(billUpdateButton);
		
		JButton billPreviousButton = new JButton("Previous");
		billPreviousButton.setBounds(23, 288, 89, 23);
		frame5.getContentPane().add(billPreviousButton);
		
		
		
		JButton billCalculateButton = new JButton("Calculate");
		billCalculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				 String numofdays= noOfDaysTextField.getText();
				int nodays=Integer.parseInt(numofdays);  
				
				String doctorcharge= doctorChargeTextField.getText();
				double dch=Double.parseDouble(doctorcharge);  
				String roomcharge= roomChargeTextField.getText();
				double rch=Double.parseDouble(roomcharge);  
				String labcharge= billLabChargeTextField.getText();
				double lch=Double.parseDouble(labcharge);  
				
				double total=(dch+rch+lch)*nodays;
				JOptionPane.showMessageDialog(null, "Total charge is: "+total+"!");
				
				
				
			}
		});
		billCalculateButton.setBounds(278, 131, 108, 23);
		frame5.getContentPane().add(billCalculateButton);
		
		
		

		
		
		
		
		
		billPreviousButton.addActionListener(new ActionListener(){ 
			public void actionPerformed(java.awt.event.ActionEvent evt){ 
				RoomFrame window4 = new RoomFrame();
				window4.frame4.setVisible(true);
			        }
		});
	}

}


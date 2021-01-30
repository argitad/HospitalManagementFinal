package com.management.hospital.ui;
import com.toedter.calendar.JCalendar;
import com.jgoodies.looks.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class LaboratoryFrame {

	JFrame frame2;
	private JTextField labNumberTextField;
	private JTextField labPatientTextField;
	private JTextField doctorIdTextField;
	 
	Connection connection= null;  //initializes the connection with the database
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LaboratoryFrame window2 = new LaboratoryFrame();
					window2.frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LaboratoryFrame() {
		initialize2();
		connection= GuiConnection.setGuiConnection();   //creates the connection with the database

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize2() {
		frame2 = new JFrame();
		frame2.getContentPane().setBackground(new Color(176, 196, 222));
		frame2.setBounds(100, 100, 464, 361);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		JLabel labHeaderLabel = new JLabel("Laboratory");
		labHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		labHeaderLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		labHeaderLabel.setBounds(53, 11, 340, 20);
		frame2.getContentPane().add(labHeaderLabel);
		
		JLabel labNumberLabel = new JLabel("Number");
		labNumberLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		labNumberLabel.setBounds(10, 59, 89, 14);
		frame2.getContentPane().add(labNumberLabel);
		
		JLabel labPatientLabel = new JLabel("Patient ID");
		labPatientLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		labPatientLabel.setBounds(10, 102, 89, 14);
		frame2.getContentPane().add(labPatientLabel);
		
		JLabel doctorIdLabel = new JLabel("Doctor ID");
		doctorIdLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		doctorIdLabel.setBounds(20, 140, 79, 14);
		frame2.getContentPane().add(doctorIdLabel);
		
		JLabel labDayLabel = new JLabel("Day");
		labDayLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		labDayLabel.setBounds(10, 177, 89, 14);
		frame2.getContentPane().add(labDayLabel);
		
		labNumberTextField = new JTextField();
		labNumberTextField.setBounds(149, 56, 86, 20);
		frame2.getContentPane().add(labNumberTextField);
		labNumberTextField.setColumns(10);
		
		labPatientTextField = new JTextField();
		labPatientTextField.setBounds(149, 99, 86, 20);
		frame2.getContentPane().add(labPatientTextField);
		labPatientTextField.setColumns(10);
		
		doctorIdTextField = new JTextField();
		doctorIdTextField.setBounds(149, 140, 86, 20);
		frame2.getContentPane().add(doctorIdTextField);
		doctorIdTextField.setColumns(10);
		
		JDateChooser labDayDateChooser = new JDateChooser();
		labDayDateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent Date) {
				Date date=java.util.Calendar.getInstance().getTime();
			}
		});
		labDayDateChooser.setBounds(148, 177, 110, 20);
		frame2.getContentPane().add(labDayDateChooser);
		
		//Create buttons and add ActionListeners
		JButton labPreviousButton = new JButton("BACK");
		labPreviousButton.setBounds(10, 271, 89, 23);
		frame2.getContentPane().add(labPreviousButton);
		
		JButton labInsertButton = new JButton("Add");
		labInsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try {
						
						String query = "INSERT INTO laboratory(lab_no, patient_id, doctor_id, day)"
								+ "	 VALUES (?, ?, ?, ?)";
						PreparedStatement ps = connection.prepareStatement(query);
						
						ps.setString(1, labNumberTextField.getText());
						ps.setString(2, labPatientTextField.getText());
						ps.setString(3, doctorIdTextField.getText());
						ps.setObject(4, labDayDateChooser.getDate());
						ps.executeUpdate();
						ResultSet rs = ps.executeQuery();
						
					 
			         } catch (SQLException e) {
			        	 e.printStackTrace();
			        	 
			         }
			}
		});
		labInsertButton.setBounds(194, 226, 89, 23);
		frame2.getContentPane().add(labInsertButton);
		
		JButton labUpdateButton = new JButton("Edit");
		labUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					String query = "UPDATE laboratory SET patient_id = ?, day= ? WHERE lab_no =?";
					PreparedStatement ps = connection.prepareStatement(query);
					
					ps.setString(3, labNumberTextField.getText());
					ps.setString(1, labPatientTextField.getText());
					ps.setObject(2, labDayDateChooser.getDate());
					ps.executeUpdate();
					ResultSet rs = ps.executeQuery();
					
				 
		         } catch (SQLException e) {
		        	 e.printStackTrace();
		        	 
		         }
			}
		});
		labUpdateButton.setBounds(337, 226, 89, 23);
		frame2.getContentPane().add(labUpdateButton);

		
		labPreviousButton.addActionListener(new ActionListener(){ 
			public void actionPerformed(java.awt.event.ActionEvent evt){ 
				
				frame2.setVisible(false);
				
				DoctorFrame window1 = new DoctorFrame();
				window1.frame1.setVisible(true);
			        }
		});
		
		
		
		
		
	}
}

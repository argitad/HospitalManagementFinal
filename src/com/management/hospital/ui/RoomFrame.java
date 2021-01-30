package com.management.hospital.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class RoomFrame {

	JFrame frame4;
	private JTextField roomNumberTextField;
	private JTextField patientIdTextField;
	
	Connection connection= null;  //initializes the connection with the database
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomFrame window4 = new RoomFrame();
					window4.frame4.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RoomFrame() {
		initialize4();
		connection= GuiConnection.setGuiConnection();  //creates the connection with the database
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize4() {
		frame4 = new JFrame();
		frame4.getContentPane().setBackground(new Color(176, 196, 222));
		frame4.setBounds(100, 100, 464, 361);
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame4.getContentPane().setLayout(null);
		
		JLabel roomHeaderLabel = new JLabel("Room");
		roomHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		roomHeaderLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		roomHeaderLabel.setBounds(37, 11, 374, 20);
		frame4.getContentPane().add(roomHeaderLabel);
		
		JLabel roomNumberLabel = new JLabel("Number");
		roomNumberLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		roomNumberLabel.setBounds(37, 58, 46, 14);
		frame4.getContentPane().add(roomNumberLabel);
		
		JLabel roomTypeLabel = new JLabel("Type");
		roomTypeLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		roomTypeLabel.setBounds(37, 103, 46, 14);
		frame4.getContentPane().add(roomTypeLabel);
		
		JLabel roomStatusLabel = new JLabel("Status");
		roomStatusLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		roomStatusLabel.setBounds(37, 146, 46, 14);
		frame4.getContentPane().add(roomStatusLabel);

		JLabel patientIdLabel = new JLabel("Patient's ID");
		patientIdLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		patientIdLabel.setBounds(10, 201, 73, 14);
		frame4.getContentPane().add(patientIdLabel);
		

		roomNumberTextField = new JTextField();
		roomNumberTextField.setBounds(132, 55, 86, 20);
		frame4.getContentPane().add(roomNumberTextField);
		roomNumberTextField.setColumns(10);
		
		String[] messageStrings= {"Standart", "Twin", "Deluxe"};
		JComboBox roomTypeComboBox = new JComboBox(messageStrings);
		roomTypeComboBox.setBounds(132, 99, 86, 22);
		frame4.getContentPane().add(roomTypeComboBox);
		
		String[] messageStrings1= {"Available", "Unavailable"};
		JComboBox statusComboBox = new JComboBox(messageStrings1);
		statusComboBox.setBounds(132, 142, 86, 22);
		frame4.getContentPane().add(statusComboBox);
		
		patientIdTextField = new JTextField();
		patientIdTextField.setBounds(132, 198, 86, 20);
		frame4.getContentPane().add(patientIdTextField);
		patientIdTextField.setColumns(10);
		
		
		//Create buttons and add ActionListeners
		JButton roomPreviousButton = new JButton("BACK");
		roomPreviousButton.setBounds(37, 288, 89, 23);
		frame4.getContentPane().add(roomPreviousButton);
		
		JButton roomBillButton = new JButton("Proceed to Checkout!");
		roomBillButton.setBounds(223, 288, 188, 23);
		frame4.getContentPane().add(roomBillButton);
		
		JButton roomInsertButton = new JButton("Add");
		roomInsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try {
						
						String query = "INSERT INTO room (room_no, room_type, status, patient_id)"
								+" VALUES (?, ?, ?, ?)";
						PreparedStatement ps = connection.prepareStatement(query);
						
						ps.setString(1, roomNumberTextField.getText());
						ps.setObject(2, roomTypeComboBox.getSelectedItem());
						ps.setObject(3, statusComboBox.getSelectedItem());
						ps.setString(4, patientIdTextField.getText());
						ps.executeUpdate();
					
						
					 
			         } catch (SQLException e) {
			        	 e.printStackTrace();
			        	 
			         }
			}
		});
		roomInsertButton.setBounds(172, 241, 89, 23);
		frame4.getContentPane().add(roomInsertButton);
		
		JButton roomUpdateButton = new JButton("Edit");
		roomUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try {
						
						String query = "UPDATE room SET status = ?, patient_id=?  WHERE room_no= ?";
						PreparedStatement ps = connection.prepareStatement(query);
						
						ps.setString(3, roomNumberTextField.getText());
						ps.setObject(1, statusComboBox.getSelectedItem());
						ps.setString(2, patientIdTextField.getText());
						ps.executeUpdate();
					
						
					 
			         } catch (SQLException e) {
			        	 e.printStackTrace();
			        	 
			         }
			}
		});
		roomUpdateButton.setBounds(307, 241, 89, 23);
		frame4.getContentPane().add(roomUpdateButton);
		
		
		roomPreviousButton.addActionListener(new ActionListener(){ 
			public void actionPerformed(java.awt.event.ActionEvent evt){ 
				
				frame4.setVisible(false);
				PatientFrame window3 = new PatientFrame();
				window3.frame3.setVisible(true);
			        }
		});
		
		roomBillButton.addActionListener(new ActionListener(){ 
			public void actionPerformed(java.awt.event.ActionEvent evt){ 
				
				frame4.setVisible(false);

				BillFrame window5 = new BillFrame();
				window5.frame5.setVisible(true);
			        }
		});
		
	}
}


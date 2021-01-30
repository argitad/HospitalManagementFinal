package com.management.hospital.ui;

import java.awt.*;
import java.awt.event.*;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class WelcomeFrame extends JFrame {

	JFrame frame;

     
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeFrame window = new WelcomeFrame();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WelcomeFrame() {
		initialize();
		
	}
	


	// Initialize the contents of the frame
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 196, 222));
		frame.setBounds(100, 100, 692, 382);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
        JLabel headerLabel = new JLabel("HOSPITAL MANAGEMENT SYSTEM");
        headerLabel.setBackground(Color.DARK_GRAY);
		headerLabel.setBounds(0, 22, 676, 33);
		headerLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 27));
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(headerLabel);
		
		JLabel doctorImgLabel = new JLabel("");
		ImageIcon doctor= new ImageIcon("doctor.png");
		
		doctorImgLabel.setBounds(141, 75, 171, 146);
		doctorImgLabel.setIcon(doctor);
		frame.getContentPane().add(doctorImgLabel);
		
		JLabel patientImgLabel = new JLabel("");
		ImageIcon patient= new ImageIcon("patient.png");
		
		patientImgLabel.setBounds(492, 75, 174, 146);
		patientImgLabel.setIcon(patient);
		frame.getContentPane().add(patientImgLabel);
		
		JButton doctorButton = new JButton("Continue To Doctor");
		doctorButton.setForeground(Color.DARK_GRAY);
		doctorButton.setBackground(Color.LIGHT_GRAY);
		doctorButton.setBounds(97, 247, 178, 33);
		frame.getContentPane().add(doctorButton);
		  
		JButton patientButton = new JButton("Continue To Patient");
		patientButton.setForeground(Color.DARK_GRAY);
		patientButton.setBackground(Color.LIGHT_GRAY);
		patientButton.setBounds(446, 247, 178, 33);
		frame.getContentPane().add(patientButton);
	
	
	// Add ActionListeners for the buttons	
	doctorButton.addActionListener(new ActionListener(){ 
		
		public void actionPerformed(java.awt.event.ActionEvent evt){ 
			
			frame.setVisible(false);
			
			DoctorFrame window1 = new DoctorFrame();
			window1.frame1.setVisible(true);
			
		}
		
	});
	
	
	
	patientButton.addActionListener(new ActionListener(){ 
		
		public void actionPerformed(java.awt.event.ActionEvent evt){ 
			
			frame.setVisible(false);

			PatientFrame window3 = new PatientFrame();
			window3.frame3.setVisible(true);
		        }
	});
	}	
		
}	


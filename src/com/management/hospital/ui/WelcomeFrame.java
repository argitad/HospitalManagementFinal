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
		close();
		
	}
	
	private void close() {
		// TODO Auto-generated method stub
	WindowEvent winClosingEvent= new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

	// Initialize the contents of the frame
	private void initialize() {
		
		//First Frame
		frame = new JFrame();
		frame.setBounds(100, 100, 692, 382);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Header Label
		JLabel headerLabel = new JLabel("HOSPITAL MANAGEMENT SYSTEM");
		headerLabel.setBounds(0, 11, 676, 33);
		headerLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(headerLabel);
		
		
	    // Doctor Image Label
		JLabel doctorImgLabel = new JLabel("");
		ImageIcon doctor= new ImageIcon("doctor.png");
		
		doctorImgLabel.setBounds(141, 75, 171, 146);
		doctorImgLabel.setIcon(doctor);
		frame.getContentPane().add(doctorImgLabel);
		
	    //Patient Image Label
		JLabel patientImgLabel = new JLabel("");
		ImageIcon patient= new ImageIcon("patient.png");
		
		patientImgLabel.setBounds(492, 75, 174, 146);
		patientImgLabel.setIcon(patient);
		frame.getContentPane().add(patientImgLabel);
		
		JButton doctorButton = new JButton("Continue As Doctor");
		doctorButton.setBounds(97, 247, 178, 33);
		frame.getContentPane().add(doctorButton);
		  
		
		
		JButton patientButton = new JButton("Continue As Patient");
		patientButton.setBounds(446, 247, 178, 33);
		frame.getContentPane().add(patientButton);
	
	
		
	doctorButton.addActionListener(new ActionListener(){ 
		
		public void actionPerformed(java.awt.event.ActionEvent evt){ 
			close();
			DoctorFrame window1 = new DoctorFrame();
			window1.frame1.setVisible(true);
			
		}
		
	});
	
	
	
	patientButton.addActionListener(new ActionListener(){ 
		
		public void actionPerformed(java.awt.event.ActionEvent evt){ 
			close();
			PatientFrame window3 = new PatientFrame();
			window3.frame3.setVisible(true);
		        }
	});
	}	
		
}	


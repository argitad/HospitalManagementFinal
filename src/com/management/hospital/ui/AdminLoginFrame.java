package com.management.hospital.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLoginFrame {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLoginFrame window = new AdminLoginFrame();
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
	public AdminLoginFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 462, 353);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(90, 31, 278, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(90, 116, 77, 14);
		frame.getContentPane().add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(90, 158, 77, 14);
		frame.getContentPane().add(passwordLabel);
		
		textField = new JTextField();
		textField.setBounds(201, 113, 111, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(201, 155, 111, 20);
		frame.getContentPane().add(passwordField);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username= textField.getText();
				String passsword= passwordField.getText();
				if (username.equals("admin")  && passsword.equals("admin")) {
					WelcomeFrame window = new WelcomeFrame();
					window.frame.setVisible(true);
					dispose();
				}
				else {
				 JOptionPane.showMessageDialog(null, "Invaild username or password");
				}
			}
		});
		loginButton.setBounds(163, 242, 89, 23);
		frame.getContentPane().add(loginButton);
	}

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}
}

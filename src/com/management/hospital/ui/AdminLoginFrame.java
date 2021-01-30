package com.management.hospital.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Color;

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
		frame.getContentPane().setBackground(new Color(176, 196, 222));
		frame.setBounds(100, 100, 462, 353);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ImageIcon welcome= new ImageIcon("welcome (3).jpg");
		
		JLabel welcomeLabel = new JLabel("");
		ImageIcon admin= new ImageIcon("hospital.png");
		welcomeLabel.setIcon(admin);
		welcomeLabel.setBounds(65, 86, 159, 138);
		frame.getContentPane().add(welcomeLabel);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(263, 111, 77, 14);
		frame.getContentPane().add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(263, 176, 77, 14);
		frame.getContentPane().add(passwordLabel);
		
		textField = new JTextField();
		textField.setBounds(263, 128, 111, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(263, 195, 111, 20);
		frame.getContentPane().add(passwordField);
		
		
		//Create and add ActionListener for the login button
		JButton loginButton = new JButton("Login");
		loginButton.setBackground(Color.LIGHT_GRAY);
		loginButton.setForeground(Color.BLACK);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username= textField.getText();
				String passsword= passwordField.getText();
				if (username.equals("admin")  && passsword.equals("admin")) {
					
					frame.setVisible(false);
					
					WelcomeFrame window = new WelcomeFrame();
					window.frame.setVisible(true);
					
				}
				else {
				 JOptionPane.showMessageDialog(null, "Invaild username or password");
				}
			}
		});
		loginButton.setBounds(290, 249, 89, 23);
		frame.getContentPane().add(loginButton);
		
		JLabel lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setBounds(140, 30, 159, 25);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 19));
		
		
		
		
	}
}

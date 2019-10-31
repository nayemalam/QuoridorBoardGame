package ca.mcgill.ecse223.quoridor.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SaveGamePage {
	private JFrame frame;
	private JTextField gameFileNameTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaveGamePage window = new SaveGamePage();
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
	public SaveGamePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1165, 693);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel saveGameFileNameLabel = new JLabel("Enter Save Game File Name:");
		saveGameFileNameLabel.setBackground(Color.WHITE);
		saveGameFileNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		saveGameFileNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		saveGameFileNameLabel.setBounds(10, 151, 469, 68);
		frame.getContentPane().add(saveGameFileNameLabel);
		
		gameFileNameTextField = new JTextField();
		gameFileNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gameFileNameTextField.setBounds(445, 151, 498, 68);
		frame.getContentPane().add(gameFileNameTextField);
		gameFileNameTextField.setColumns(10);
		
		JButton saveGameFileButton = new JButton("Save Game File\r\n");
		saveGameFileButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		saveGameFileButton.setBounds(977, 151, 165, 68);
		frame.getContentPane().add(saveGameFileButton);
		
		JLabel lblNewLabel = new JLabel("Quoridor");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(445, 10, 498, 131);
		frame.getContentPane().add(lblNewLabel);
	}
}

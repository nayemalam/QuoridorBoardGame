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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import ca.mcgill.ecse223.quoridor.controller.*;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class SavePositionPage {
	private JFrame frame;
	private JTextField gameFileNameTextField;
	private QuoridorController QC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SavePositionPage window = new SavePositionPage();
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
	public SavePositionPage() {
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
		saveGameFileNameLabel.setBounds(10, 151, 348, 68);
		frame.getContentPane().add(saveGameFileNameLabel);
		
		gameFileNameTextField = new JTextField();
		gameFileNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gameFileNameTextField.setBounds(327, 151, 498, 68);
		frame.getContentPane().add(gameFileNameTextField);
		gameFileNameTextField.setColumns(10);
		
		JSplitPane PositionSavedPane = new JSplitPane();
		PositionSavedPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		PositionSavedPane.setBounds(269, 272, 614, 88);
		frame.getContentPane().add(PositionSavedPane);
		
		JLabel PositionSavedLabel = new JLabel("Position Succesfully Saved!");
		PositionSavedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PositionSavedLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PositionSavedPane.setLeftComponent(PositionSavedLabel);
		
		
		JButton ReturntoMenu1 = new JButton("Return to Main Menu");
		ReturntoMenu1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ReturntoMenu1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		PositionSavedPane.setRightComponent(ReturntoMenu1);
		PositionSavedPane.setVisible(false);
		
		JButton saveGameFileButton = new JButton("Save Game File\r\n");
		saveGameFileButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				try {
					QC.saveGamePosition(saveGameFileNameLabel.getText());
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				PositionSavedPane.setVisible(true);
			}		
		});
		saveGameFileButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		saveGameFileButton.setBounds(977, 151, 165, 68);
		frame.getContentPane().add(saveGameFileButton);
		
		JLabel lblNewLabel = new JLabel("Quoridor");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(327, 10, 498, 131);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel OverwriteLabel = new JLabel("File already exists, Overwrite file?");
		OverwriteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		OverwriteLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		OverwriteLabel.setBounds(447, 457, 258, 28);
		frame.getContentPane().add(OverwriteLabel);
		OverwriteLabel.setVisible(false);
		
		JSplitPane OverwritePane = new JSplitPane();
		OverwritePane.setBounds(314, 495, 524, 88);
		frame.getContentPane().add(OverwritePane);
		OverwritePane.setVisible(false);
		
		JButton NoOvewriteButton = new JButton("No, do not overwrite the file");
		NoOvewriteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				OverwritePane.setVisible(false);
				OverwriteLabel.setVisible(false);
			}
		});
		NoOvewriteButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		OverwritePane.setLeftComponent(NoOvewriteButton);
		
		JButton ConfirmOverwriteButton = new JButton("Yes, overwrite the file\r\n");
		ConfirmOverwriteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					QC.overwriteGamePosition(saveGameFileNameLabel.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				OverwritePane.setVisible(false);
				OverwriteLabel.setVisible(false);
				PositionSavedPane.setVisible(true);	
			}
		});
		ConfirmOverwriteButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		OverwritePane.setRightComponent(ConfirmOverwriteButton);		
	}
}

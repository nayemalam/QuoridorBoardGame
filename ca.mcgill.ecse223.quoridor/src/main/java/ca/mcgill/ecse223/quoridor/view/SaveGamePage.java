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

public class SaveGamePage {
	public JFrame frame;
	private QuoridorController QC;
	private boolean fileExists;

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
		
		// Forces fullscreen
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(null);

		JLabel saveGameFileNameLabel = new JLabel("Enter Save Game File Name:");
		saveGameFileNameLabel.setBackground(Color.WHITE);
		saveGameFileNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		saveGameFileNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		saveGameFileNameLabel.setBounds(10, 151, 348, 68);
		frame.getContentPane().add(saveGameFileNameLabel);

		JLabel emptyFileNameLabel = new JLabel("Please enter a file name");
		emptyFileNameLabel.setForeground(Color.RED);
		emptyFileNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emptyFileNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emptyFileNameLabel.setBounds(441, 229, 232, 28);
		frame.getContentPane().add(emptyFileNameLabel);
		emptyFileNameLabel.setVisible(false);
		
		JLabel invalidFileNameLabel = new JLabel("Please enter a valid file name");
		invalidFileNameLabel.setForeground(Color.RED);
		invalidFileNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		invalidFileNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		invalidFileNameLabel.setBounds(441, 120, 232, 28);
		frame.getContentPane().add(invalidFileNameLabel);
		emptyFileNameLabel.setVisible(false);
		
		JTextField gameFileNameTextField = new JTextField();
		gameFileNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gameFileNameTextField.setBounds(327, 151, 498, 68);
		frame.getContentPane().add(gameFileNameTextField);
		gameFileNameTextField.setColumns(10);

		JSplitPane gameSavedPane = new JSplitPane();
		gameSavedPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		gameSavedPane.setBounds(269, 272, 614, 88);
		gameSavedPane.setVisible(false);
		frame.getContentPane().add(gameSavedPane);

		JLabel gameSavedLabel = new JLabel("File Succesfully Saved!");
		gameSavedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameSavedLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gameSavedPane.setLeftComponent(gameSavedLabel);
		gameSavedLabel.setVisible(false);

		JButton ReturntoMenu1 = new JButton("Return to Main Menu");
		ReturntoMenu1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ReturntoMenu1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				frame.dispose();
				MainMenu main = new MainMenu();
				main.frame.setVisible(true);
					
			}
		});
		gameSavedPane.setRightComponent(ReturntoMenu1);
		gameSavedPane.setVisible(false);
		
		JLabel OverwriteLabel = new JLabel("File already exists, Overwrite file?");
		OverwriteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		OverwriteLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		OverwriteLabel.setBounds(447, 457, 258, 28);
		OverwriteLabel.setVisible(false);
		frame.getContentPane().add(OverwriteLabel);
		
		JSplitPane OverwritePane = new JSplitPane();
		OverwritePane.setBounds(314, 495, 524, 88);
		OverwritePane.setVisible(false);
		frame.getContentPane().add(OverwritePane);
		
		JButton saveFileButton = new JButton("Save File\r\n");
		saveFileButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				if(gameFileNameTextField.getText().isEmpty()) {
					emptyFileNameLabel.setVisible(true);
					return;
				}
				
				try {
					fileExists = QC.save(saveGameFileNameLabel.getText());
				} catch (IllegalArgumentException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					invalidFileNameLabel.setVisible(true);
					e.printStackTrace();
				}
				if(fileExists = true) {
					gameSavedPane.setVisible(true);
					gameSavedLabel.setVisible(true);
				}
				else {
					OverwritePane.setVisible(true);
					OverwriteLabel.setVisible(true);
				}
			}		
		});
		saveFileButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		saveFileButton.setBounds(977, 151, 165, 68);
		frame.getContentPane().add(saveFileButton);

		JLabel TitleLabel = new JLabel("Quoridor");
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		TitleLabel.setBounds(327, 10, 498, 111);
		frame.getContentPane().add(TitleLabel);

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
					QC.overwriteGameFile(saveGameFileNameLabel.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				OverwritePane.setVisible(false);
				OverwriteLabel.setVisible(false);
		
				gameSavedPane.setVisible(true);
				gameSavedLabel.setVisible(true);
			}
		});
		ConfirmOverwriteButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		OverwritePane.setRightComponent(ConfirmOverwriteButton);		
		
		JButton btnReturnToMain = new JButton("Return to Main Menu");
		btnReturnToMain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				frame.dispose();
				MainMenu main2 = new MainMenu();
				main2.frame.setVisible(true);
			}
		});
		btnReturnToMain.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReturnToMain.setBounds(0, 0, 190, 46);
		frame.getContentPane().add(btnReturnToMain);
	}
}

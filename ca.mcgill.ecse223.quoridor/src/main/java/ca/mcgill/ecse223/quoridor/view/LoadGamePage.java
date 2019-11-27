package ca.mcgill.ecse223.quoridor.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.io.*;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.*;
import ca.mcgill.ecse223.quoridor.model.Direction;
import ca.mcgill.ecse223.quoridor.model.Player;
import ca.mcgill.ecse223.quoridor.model.Quoridor;
import ca.mcgill.ecse223.quoridor.model.User;
import ca.mcgill.ecse223.quoridor.utilities.ControllerUtilities;

public class LoadGamePage {
	public JFrame frame;
	private QuoridorController QC;
	private boolean valid;
	private JTextField LoadFileNameTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadGamePage window = new LoadGamePage();
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
	public LoadGamePage() {
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

		

		LoadFileNameTextField = new JTextField();
		LoadFileNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LoadFileNameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		LoadFileNameTextField.setBounds(507, 151, 521, 68);
		frame.getContentPane().add(LoadFileNameTextField);
		LoadFileNameTextField.setColumns(10);
		
		JLabel invalidLoadFileLabel = new JLabel("Invalid file, Please select a valid file to load");
		invalidLoadFileLabel.setForeground(Color.RED);
		invalidLoadFileLabel.setHorizontalAlignment(SwingConstants.CENTER);
		invalidLoadFileLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		invalidLoadFileLabel.setBounds(591, 121, 354, 20);
		frame.getContentPane().add(invalidLoadFileLabel);
		invalidLoadFileLabel.setVisible(false);
		
		JLabel loadGameFileLabel = new JLabel("Select File to Load:");
		loadGameFileLabel.setBackground(Color.WHITE);
		loadGameFileLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loadGameFileLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loadGameFileLabel.setBounds(132, 151, 332, 68);
		frame.getContentPane().add(loadGameFileLabel);
		
		JLabel emptyFileNameLabel = new JLabel("Please enter a file name");
		emptyFileNameLabel.setForeground(Color.RED);
		emptyFileNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emptyFileNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emptyFileNameLabel.setBounds(591, 229, 354, 26);
		frame.getContentPane().add(emptyFileNameLabel);
		emptyFileNameLabel.setVisible(false);
		
		JButton loadGameFileButton = new JButton("Load File\r\n");
		loadGameFileButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(LoadFileNameTextField.getText().isEmpty()) {
					emptyFileNameLabel.setVisible(true);
					return;
				}
				try {
					Quoridor quoridor = QuoridorApplication.getQuoridor();
					User userWhite = quoridor.addUser("TestUser1");
					User userBlack = quoridor.addUser("TestUser2");
					Player whitePlayer = new Player(new Time(0), quoridor.getUser(0), ControllerUtilities.BLACK_TILE_INDEX, Direction.Horizontal);
					Player blackPlayer = new Player(new Time(0), quoridor.getUser(1), ControllerUtilities.WHITE_TILE_INDEX, Direction.Horizontal);
					QuoridorController.initializeNewGame(QuoridorApplication.getQuoridor(), whitePlayer, blackPlayer);
					valid = QC.loadGame(LoadFileNameTextField.getText(), whitePlayer, blackPlayer);
					frame.dispose();
					MainGameWindow main = new MainGameWindow();
					main.frmQuoridorPlay.setVisible(true);
				} catch (IOException e1) {
					invalidLoadFileLabel.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(valid = false) {
					invalidLoadFileLabel.setVisible(true);
				}
			}
		});
		loadGameFileButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loadGameFileButton.setBounds(1103, 151, 238, 68);
		frame.getContentPane().add(loadGameFileButton);
		
		JLabel TitleLabel = new JLabel("Quoridor\r\n");
		TitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setBounds(475, 10, 586, 101);
		frame.getContentPane().add(TitleLabel);
		
		JButton btnReturntoMainMenu = new JButton("Return to Main Menu");
		btnReturntoMainMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				frame.dispose();
				MainMenu main = new MainMenu();
				main.frame.setVisible(true);
			}
		});
		btnReturntoMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReturntoMainMenu.setBounds(0, 0, 194, 45);
		frame.getContentPane().add(btnReturntoMainMenu);
	}
}

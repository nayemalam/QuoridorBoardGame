package ca.mcgill.ecse223.quoridor.view;

import ca.mcgill.ecse223.quoridor.controller.QuoridorController;

import java.awt.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartGamePage {

	// UI elements
	public JFrame frame;
	private JTextPane QuoridorTitleField;
	private JLabel errorMessage;
	// player 1
	private JLabel PlayerLabel_1;
	private JComboBox PlayerSelect_1;
	private JButton btnAddPlayer_1;
	private DefaultComboBoxModel model_1;
	// player 2
	private JLabel PlayerLabel_2;
	private JComboBox PlayerSelect_2;
	private JButton btnAddPlayer_2;
	private DefaultComboBoxModel model_2;

	// total thinking time
	private JLabel ThinkingTime_Label;
	private JTextArea Minutes_TextField;
	private JLabel Minutes_label;
	private JTextArea Seconds_TextField;
	private JLabel Seconds_label;
	private JButton btnSetTime;
	// start game
	private JButton btnStartGame;

	// data elements
	private String error = null;
	private JPanel panel;
	private JButton btnReturntoMainMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartGamePage window = new StartGamePage();
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
	public StartGamePage() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.getContentPane().setLocation(x, y);
		// Forces fullscreen
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(null);
		model_1 = new DefaultComboBoxModel(QuoridorController.getUsers(" ").toArray());
		model_2 = new DefaultComboBoxModel(QuoridorController.getUsers(" ").toArray());

		// global settings
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setTitle("Quoridor - Start New Game");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{97, 2, 62, 48, 60, 111, 0};
		gridBagLayout.rowHeights = new int[]{46, 25, 25, 18, 25, 1, 25, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
				// Content title
				QuoridorTitleField = new JTextPane();
				QuoridorTitleField.setLocation(50, 50);
				QuoridorTitleField.setEditable(false);
				QuoridorTitleField.setForeground(Color.BLACK);
				QuoridorTitleField.setBackground(SystemColor.activeCaption);
				QuoridorTitleField.setEditable(false);
				QuoridorTitleField.setFont(new Font("Monospaced", Font.BOLD, 30));
				QuoridorTitleField.setAlignmentX(SwingConstants.CENTER);
				QuoridorTitleField.setText("Quoridor");
				GridBagConstraints gbc_QuoridorTitleField = new GridBagConstraints();
				gbc_QuoridorTitleField.anchor = GridBagConstraints.NORTH;
				gbc_QuoridorTitleField.fill = GridBagConstraints.HORIZONTAL;
				gbc_QuoridorTitleField.insets = new Insets(0, 0, 5, 0);
				gbc_QuoridorTitleField.gridwidth = 6;
				gbc_QuoridorTitleField.gridx = 0;
				gbc_QuoridorTitleField.gridy = 0;
				frame.getContentPane().add(QuoridorTitleField, gbc_QuoridorTitleField);
		
				// elements for Player1
				PlayerLabel_1 = new JLabel("Player 1 Name:");
				PlayerLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				GridBagConstraints gbc_PlayerLabel_1 = new GridBagConstraints();
				gbc_PlayerLabel_1.anchor = GridBagConstraints.EAST;
				gbc_PlayerLabel_1.insets = new Insets(0, 0, 5, 5);
				gbc_PlayerLabel_1.gridx = 0;
				gbc_PlayerLabel_1.gridy = 1;
				frame.getContentPane().add(PlayerLabel_1, gbc_PlayerLabel_1);
		PlayerSelect_1 = new JComboBox(model_1);
		PlayerSelect_1.setEditable(true);
		GridBagConstraints gbc_PlayerSelect_1 = new GridBagConstraints();
		gbc_PlayerSelect_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_PlayerSelect_1.insets = new Insets(0, 0, 5, 5);
		gbc_PlayerSelect_1.gridwidth = 4;
		gbc_PlayerSelect_1.gridx = 1;
		gbc_PlayerSelect_1.gridy = 1;
		frame.getContentPane().add(PlayerSelect_1, gbc_PlayerSelect_1);
		btnAddPlayer_1 = new JButton("Select");
		
				// listeners for player1
				btnAddPlayer_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						addPlayerOneUsernameActionPerformed(evt);
					}
				});
				GridBagConstraints gbc_btnAddPlayer_1 = new GridBagConstraints();
				gbc_btnAddPlayer_1.anchor = GridBagConstraints.NORTH;
				gbc_btnAddPlayer_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnAddPlayer_1.insets = new Insets(0, 0, 5, 0);
				gbc_btnAddPlayer_1.gridx = 5;
				gbc_btnAddPlayer_1.gridy = 1;
				frame.getContentPane().add(btnAddPlayer_1, gbc_btnAddPlayer_1);
		
				// elements for Player2
				PlayerLabel_2 = new JLabel("Player 2 Name:");
				GridBagConstraints gbc_PlayerLabel_2 = new GridBagConstraints();
				gbc_PlayerLabel_2.anchor = GridBagConstraints.EAST;
				gbc_PlayerLabel_2.insets = new Insets(0, 0, 5, 5);
				gbc_PlayerLabel_2.gridx = 0;
				gbc_PlayerLabel_2.gridy = 2;
				frame.getContentPane().add(PlayerLabel_2, gbc_PlayerLabel_2);
		PlayerSelect_2 = new JComboBox(model_2);
		PlayerSelect_2.setEditable(true);
		GridBagConstraints gbc_PlayerSelect_2 = new GridBagConstraints();
		gbc_PlayerSelect_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_PlayerSelect_2.insets = new Insets(0, 0, 5, 5);
		gbc_PlayerSelect_2.gridwidth = 4;
		gbc_PlayerSelect_2.gridx = 1;
		gbc_PlayerSelect_2.gridy = 2;
		frame.getContentPane().add(PlayerSelect_2, gbc_PlayerSelect_2);
		btnAddPlayer_2 = new JButton("Select");
		// listeners for player2
		btnAddPlayer_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				addPlayerTwoUsernameActionPerformed(evt);
			}
		});
		GridBagConstraints gbc_btnAddPlayer_2 = new GridBagConstraints();
		gbc_btnAddPlayer_2.anchor = GridBagConstraints.NORTH;
		gbc_btnAddPlayer_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddPlayer_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddPlayer_2.gridx = 5;
		gbc_btnAddPlayer_2.gridy = 2;
		frame.getContentPane().add(btnAddPlayer_2, gbc_btnAddPlayer_2);
		
				// elements for setTotalThinkingTime
				ThinkingTime_Label = new JLabel("Set Thinking Time for Both Players");
				ThinkingTime_Label.setFont(new Font("Lucida Grande", Font.BOLD, 13));
				ThinkingTime_Label.setHorizontalAlignment(SwingConstants.CENTER);
				GridBagConstraints gbc_ThinkingTime_Label = new GridBagConstraints();
				gbc_ThinkingTime_Label.anchor = GridBagConstraints.NORTH;
				gbc_ThinkingTime_Label.fill = GridBagConstraints.HORIZONTAL;
				gbc_ThinkingTime_Label.insets = new Insets(0, 0, 5, 0);
				gbc_ThinkingTime_Label.gridwidth = 6;
				gbc_ThinkingTime_Label.gridx = 0;
				gbc_ThinkingTime_Label.gridy = 3;
				frame.getContentPane().add(ThinkingTime_Label, gbc_ThinkingTime_Label);
		Minutes_label = new JLabel("Minutes");
		Minutes_label.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_Minutes_label = new GridBagConstraints();
		gbc_Minutes_label.anchor = GridBagConstraints.EAST;
		gbc_Minutes_label.insets = new Insets(0, 0, 5, 5);
		gbc_Minutes_label.gridwidth = 2;
		gbc_Minutes_label.gridx = 0;
		gbc_Minutes_label.gridy = 4;
		frame.getContentPane().add(Minutes_label, gbc_Minutes_label);
		Minutes_TextField = new JTextArea();
		Minutes_TextField.setToolTipText("Minutes");
		GridBagConstraints gbc_Minutes_TextField = new GridBagConstraints();
		gbc_Minutes_TextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_Minutes_TextField.insets = new Insets(0, 0, 5, 5);
		gbc_Minutes_TextField.gridx = 2;
		gbc_Minutes_TextField.gridy = 4;
		frame.getContentPane().add(Minutes_TextField, gbc_Minutes_TextField);
		Seconds_label = new JLabel("Seconds");
		Seconds_label.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_Seconds_label = new GridBagConstraints();
		gbc_Seconds_label.anchor = GridBagConstraints.WEST;
		gbc_Seconds_label.insets = new Insets(0, 0, 5, 5);
		gbc_Seconds_label.gridx = 3;
		gbc_Seconds_label.gridy = 4;
		frame.getContentPane().add(Seconds_label, gbc_Seconds_label);
		Seconds_TextField = new JTextArea();
		GridBagConstraints gbc_Seconds_TextField = new GridBagConstraints();
		gbc_Seconds_TextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_Seconds_TextField.insets = new Insets(0, 0, 5, 5);
		gbc_Seconds_TextField.gridx = 4;
		gbc_Seconds_TextField.gridy = 4;
		frame.getContentPane().add(Seconds_TextField, gbc_Seconds_TextField);
		
				// elements for starting new game
				btnStartGame = new JButton("START GAME");
				// listeners for starting game
				btnStartGame.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						startGameActionPerformed(evt);
					}
				});
				btnSetTime = new JButton("Set Time");
				// listeners for setting time
				btnSetTime.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						setTotalThinkingTimeActionPerformed(evt);
					}
				});
				GridBagConstraints gbc_btnSetTime = new GridBagConstraints();
				gbc_btnSetTime.anchor = GridBagConstraints.NORTH;
				gbc_btnSetTime.insets = new Insets(0, 0, 5, 0);
				gbc_btnSetTime.gridx = 5;
				gbc_btnSetTime.gridy = 4;
				frame.getContentPane().add(btnSetTime, gbc_btnSetTime);
				
						// elements for error message
						errorMessage = new JLabel("");
						errorMessage.setHorizontalAlignment(SwingConstants.CENTER);
						errorMessage.setForeground(Color.RED);
						GridBagConstraints gbc_errorMessage = new GridBagConstraints();
						gbc_errorMessage.anchor = GridBagConstraints.NORTH;
						gbc_errorMessage.fill = GridBagConstraints.HORIZONTAL;
						gbc_errorMessage.insets = new Insets(0, 0, 5, 0);
						gbc_errorMessage.gridwidth = 6;
						gbc_errorMessage.gridx = 0;
						gbc_errorMessage.gridy = 5;
						frame.getContentPane().add(errorMessage, gbc_errorMessage);
				
				btnReturntoMainMenu = new JButton("Return to Main Menu");
				btnReturntoMainMenu.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						frame.dispose();
						MainMenu main = new MainMenu();
						main.frame.setVisible(true);
					}
				});
				GridBagConstraints gbc_btnReturntoMainMenu = new GridBagConstraints();
				gbc_btnReturntoMainMenu.anchor = GridBagConstraints.NORTH;
				gbc_btnReturntoMainMenu.insets = new Insets(0, 0, 0, 5);
				gbc_btnReturntoMainMenu.gridx = 0;
				gbc_btnReturntoMainMenu.gridy = 6;
				frame.getContentPane().add(btnReturntoMainMenu, gbc_btnReturntoMainMenu);
				GridBagConstraints gbc_btnStartGame = new GridBagConstraints();
				gbc_btnStartGame.anchor = GridBagConstraints.NORTH;
				gbc_btnStartGame.insets = new Insets(0, 0, 0, 5);
				gbc_btnStartGame.gridwidth = 3;
				gbc_btnStartGame.gridx = 2;
				gbc_btnStartGame.gridy = 6;
				frame.getContentPane().add(btnStartGame, gbc_btnStartGame);
				
				panel = new JPanel();
				GridBagConstraints gbc_panel = new GridBagConstraints();
				gbc_panel.fill = GridBagConstraints.BOTH;
				gbc_panel.gridx = 5;
				gbc_panel.gridy = 6;
				frame.getContentPane().add(panel, gbc_panel);

	}
	// Methods
	private void startGameActionPerformed(ActionEvent evt) {
		// clears error message
		error = null;
		try {
			errorMessage.setForeground(Color.BLACK);
			errorMessage.setText(QuoridorController.testMethod());
		} catch (Exception e) {
			errorMessage.setText(e.getMessage());
			System.out.println(e.getMessage());
		}
	}
	private void addPlayerOneUsernameActionPerformed(ActionEvent evt) {
		// NOTE: The model_1 and model_2 calls the controller methods that use the ProvideSelectUsername Features
		if(String.valueOf(PlayerSelect_1.getSelectedItem()).equals(String.valueOf(PlayerSelect_2.getSelectedItem()))) {
			errorMessage.setText("Both players cannot have the same username.");
			if (String.valueOf(PlayerSelect_1.getSelectedItem()).isEmpty() || " ".equals(String.valueOf(PlayerSelect_1.getSelectedItem()))) {
				errorMessage.setText("Please enter a username for player 1.");
			}
		}else {
			errorMessage.setText(null);
			// if the username does not exist within the list
			if (model_1.getIndexOf(PlayerSelect_1.getSelectedItem()) == -1) {
				model_1.addElement(PlayerSelect_1.getSelectedItem());
				model_2.addElement(PlayerSelect_1.getSelectedItem());
//				QuoridorController.setWhitePlayerUserName(PlayerSelect_1.getSelectedItem().toString());
			}
		}
	}

	private void addPlayerTwoUsernameActionPerformed(ActionEvent evt) {
		// NOTE: The model_1 and model_2 calls the controller methods that use the ProvideSelectUsername Features
		if(String.valueOf(PlayerSelect_1.getSelectedItem()).equals(String.valueOf(PlayerSelect_2.getSelectedItem()))) {
			errorMessage.setText("Both players cannot have the same username.");
			if (String.valueOf(PlayerSelect_2.getSelectedItem()).isEmpty() || " ".equals(String.valueOf(PlayerSelect_2.getSelectedItem()))) {
				errorMessage.setText("Please enter a username for player 2.");
			}
		}else {
			errorMessage.setText(null);
			// if the username does not exist within the list
			if (model_2.getIndexOf(PlayerSelect_2.getSelectedItem()) == -1) {
				model_2.addElement(PlayerSelect_2.getSelectedItem());
				model_1.addElement(PlayerSelect_2.getSelectedItem());
//				QuoridorController.setBlackPlayerUserName(PlayerSelect_2.getSelectedItem().toString());
			}
		}
	}

	private void setTotalThinkingTimeActionPerformed(ActionEvent evt) {
		// clears error message
		error = null;

		// call controller
		Integer min = Integer.parseInt(Minutes_TextField.getText());
		Integer sec = Integer.parseInt(Seconds_TextField.getText());
		long thinkingTime = min* 60L *1000 + sec* 1000L;
		try {
			QuoridorController.setThinkingTime(min, sec);
			errorMessage.setForeground(Color.BLACK);
			errorMessage.setText("Time set to: " + min +" minutes and " +sec+ " seconds.");
		} catch (Exception e) {
			error = e.getMessage();
			errorMessage.setForeground(Color.RED);
			errorMessage.setText("Invalid time input. Please enter integers.");
			System.err.println("Not calling controller method ... ");
		}
	}
}

package ca.mcgill.ecse223.quoridor.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainGameWindow {

	private JFrame frmQuoridorPlay;
	private JTextField txtCurrentPlayer;
	private JTextField textField_1;
	private JTextField txtTimeRemaining;
	private JTextField textField_2;
	private JTextField textField;
	private JTextField txtWhitePlayer;
	private JTextField txtWallsInStock;
	private JTextField wallsInStockWhitePlayer;
	private JTextField textField_3;
	private JTextField txtBlackPlayer;
	private JTextField txtWallsOnBoard_1;
	private JTextField wallsOnBoardWhitePlayer;
	private JTextField txtWallsInStock_1;
	private JTextField wallsInStockBlackPlayer;
	private JTextField txtWallsOnBoard;
	private JTextField wallsOnBoardBlackPlayer;
	private static final int TOTAL_NUMBER_OF_TILES = 81;
	private static final int TOTAL_ROWS = 9;
	private static final int TOTAL_COLS = 9;
	private JButton[][] btnArray = new JButton[TOTAL_ROWS][TOTAL_COLS];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGameWindow window = new MainGameWindow();
					window.frmQuoridorPlay.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGameWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQuoridorPlay = new JFrame();
		frmQuoridorPlay.setTitle("Quoridor - Play Game");
		frmQuoridorPlay.setBounds(100, 100, 1256, 876);
		frmQuoridorPlay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmQuoridorPlay.getContentPane().add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		leftPanel.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 1, 0, 0));
		
		textField = new JTextField();
		textField.setBackground(SystemColor.control);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		txtWhitePlayer = new JTextField();
		txtWhitePlayer.setEditable(false);
		txtWhitePlayer.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtWhitePlayer.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtWhitePlayer.setText("White Player - Wall Stock");
		txtWhitePlayer.setToolTipText("");
		panel_3.add(txtWhitePlayer);
		txtWhitePlayer.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_3.add(panel_4);
		
		txtWallsInStock = new JTextField();
		txtWallsInStock.setEditable(false);
		txtWallsInStock.setText("Walls in Stock:");
		panel_4.add(txtWallsInStock);
		txtWallsInStock.setColumns(10);
		
		wallsInStockWhitePlayer = new JTextField();
		wallsInStockWhitePlayer.setEditable(false);
		panel_4.add(wallsInStockWhitePlayer);
		wallsInStockWhitePlayer.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_3.add(panel_5);
		
		txtWallsOnBoard_1 = new JTextField();
		txtWallsOnBoard_1.setText("Walls on Board:");
		txtWallsOnBoard_1.setEditable(false);
		panel_5.add(txtWallsOnBoard_1);
		txtWallsOnBoard_1.setColumns(10);
		
		wallsOnBoardWhitePlayer = new JTextField();
		wallsOnBoardWhitePlayer.setEditable(false);
		panel_5.add(wallsOnBoardWhitePlayer);
		wallsOnBoardWhitePlayer.setColumns(10);
		
		JPanel centerPanel = new JPanel();
		frmQuoridorPlay.getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(9, 9, 10, 10));
		
		for(int row = 0; row < TOTAL_ROWS; row++) {
			for(int col = 0; col < TOTAL_COLS; col ++) {

			btnArray[row][col] = new JButton();

				btnArray[row][col].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO: Add correct mouse listener for this tile, aka the right method call
						//textField_1.setText("SUP");
					}
				});

			centerPanel.add(btnArray[row][col]);
			}
		}
		
		JPanel northPanel = new JPanel();
		northPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmQuoridorPlay.getContentPane().add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
		
		JTextPane txtpnQuori = new JTextPane();
		txtpnQuori.setBackground(SystemColor.activeCaption);
		txtpnQuori.setEditable(false);
		txtpnQuori.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtpnQuori.setText("Quoridor");
		northPanel.add(txtpnQuori);
		
		JPanel panel = new JPanel();
		northPanel.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		txtCurrentPlayer = new JTextField();
		txtCurrentPlayer.setEditable(false);
		txtCurrentPlayer.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtCurrentPlayer.setText("Current Player:");
		txtCurrentPlayer.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(txtCurrentPlayer);
		txtCurrentPlayer.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		northPanel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		txtTimeRemaining = new JTextField();
		txtTimeRemaining.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTimeRemaining.setText("Time Remaining:");
		txtTimeRemaining.setEditable(false);
		panel_1.add(txtTimeRemaining);
		txtTimeRemaining.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel southPanel = new JPanel();
		frmQuoridorPlay.getContentPane().add(southPanel, BorderLayout.SOUTH);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmQuoridorPlay.getContentPane().add(rightPanel, BorderLayout.EAST);
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.X_AXIS));
		
		JPanel panel_6 = new JPanel();
		rightPanel.add(panel_6);
		panel_6.setLayout(new GridLayout(2, 1, 0, 0));
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setEditable(false);
		panel_6.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.Y_AXIS));
		
		txtBlackPlayer = new JTextField();
		txtBlackPlayer.setEditable(false);
		txtBlackPlayer.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtBlackPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		txtBlackPlayer.setText("Black Player - Wall Stock");
		panel_7.add(txtBlackPlayer);
		txtBlackPlayer.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8);
		
		txtWallsInStock_1 = new JTextField();
		txtWallsInStock_1.setEditable(false);
		txtWallsInStock_1.setText("Walls in Stock:");
		panel_8.add(txtWallsInStock_1);
		txtWallsInStock_1.setColumns(10);
		
		wallsInStockBlackPlayer = new JTextField();
		wallsInStockBlackPlayer.setEditable(false);
		panel_8.add(wallsInStockBlackPlayer);
		wallsInStockBlackPlayer.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9);
		
		txtWallsOnBoard = new JTextField();
		txtWallsOnBoard.setEditable(false);
		txtWallsOnBoard.setText("Walls on Board:");
		panel_9.add(txtWallsOnBoard);
		txtWallsOnBoard.setColumns(10);
		
		wallsOnBoardBlackPlayer = new JTextField();
		wallsOnBoardBlackPlayer.setEditable(false);
		panel_9.add(wallsOnBoardBlackPlayer);
		wallsOnBoardBlackPlayer.setColumns(10);
	}
}

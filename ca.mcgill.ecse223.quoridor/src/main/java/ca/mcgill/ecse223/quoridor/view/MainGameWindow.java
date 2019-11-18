package ca.mcgill.ecse223.quoridor.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;
import ca.mcgill.ecse223.quoridor.view.QuoridorPage;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import ca.mcgill.ecse223.quoridor.view.main.BlackWallPanel;
import ca.mcgill.ecse223.quoridor.view.main.WhiteWallPanel;
import ca.mcgill.ecse223.quoridor.view.*;

import ca.mcgill.ecse223.quoridor.view.main.BlackWallPanel;
import ca.mcgill.ecse223.quoridor.view.main.WhiteWallPanel;
import ca.mcgill.ecse223.quoridor.view.*;

public class MainGameWindow {

	// UI elements
	public static JFrame frmQuoridorPlay;
	// time remaining
	private JTextField timeRemaining_Label;
	private JTextField timeRemaining_TextField;
	// current player
	private JTextField currentPlayer_Label;
	private JTextField currentPlayer_TextField;
	// white player

	private JTextField wallsInStockWhitePlayer_Label;
	private JTextField wallsInStockWhitePlayer_TextField;
	private JTextField wallsOnBoardWhitePlayer_Label;
	private JTextField wallsOnBoardWhitePlayer_TextField;
	// black player
	private JTextField blackPlayer_Label;
	private JTextField wallsInStockBlackPlayer_Label;
	private JTextField wallsInStockBlackPlayer_TextField;
	private JTextField wallsOnBoardBlackPlayer_Label;
	private JTextField wallsOnBoardBlackPlayer_TextField;
	// tiles
	private static final int TOTAL_NUMBER_OF_TILES = 81;
	private static final int TOTAL_ROWS = 9;
	private static final int TOTAL_COLS = 9;
	private static JButton[][] btnArray = new JButton[TOTAL_ROWS][TOTAL_COLS];
	// walls
	private static JButton[] wallArray = new JButton[20];
	private JButton btnPlaceNewWall;
	private JButton btnNewButton;
	private JButton button;
	private static int wallWidth = 185;
	private static int wallWidthV = 11;
	private static int wallHeight = 102;
	private static boolean WallGrabbed = false;
	private static int CurrRow;
	private static int CurrCol;
	private static JButton horizontal = new JButton("horizontal");
	private static JButton vertical = new JButton("vertical");
	static JLabel errorMessage = new JLabel("Incorrect Move");
	private static int wallIndex;
	private static int tileLength = 45;
	private static int tileWidth = 87;
	private static JPanel panel_10 = new JPanel();

	private static JPanel panel_10_1 = new JPanel();
	private static JPanel panel_11 = new JPanel();
	private static JPanel centerPanel = new JPanel();
	private static JPanel boardPanel = new JPanel();
	private static JPanel navigationButtonsPanel = new JPanel();
	private MoveCandidate wallMoveCandidate;
	private MoveCandidate blackPawnMove;
	private MoveCandidate whitePawnMove;

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
		try {
			initialize();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws InterruptedException {

		// layout
		frmQuoridorPlay = new JFrame();
		frmQuoridorPlay.setTitle("Quoridor - Play Game");
		frmQuoridorPlay.setBounds(100, 100, 1256, 876);
		frmQuoridorPlay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQuoridorPlay.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmQuoridorPlay.setVisible(true);
		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmQuoridorPlay.getContentPane().add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		leftPanel.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 1, 0, 0));
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));

		playerTimeLineHandler(panel_3, "white");
		wallsHandler(panel_3, "white");

		JPanel southPanel = new JPanel();
		frmQuoridorPlay.getContentPane().add(southPanel, BorderLayout.SOUTH);
		southPanel.add(vertical);
		southPanel.add(horizontal);
		JPanel rightPanel = new JPanel();
		rightPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmQuoridorPlay.getContentPane().add(rightPanel, BorderLayout.EAST);
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.X_AXIS));
		JPanel panel_6 = new JPanel();
		rightPanel.add(panel_6);
		panel_6.setLayout(new GridLayout(2, 1, 0, 0));
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.Y_AXIS));

		playerTimeLineHandler(panel_7, "black");
		wallsHandler(panel_7, "black");
		// layout
		panel_6.add(panel_11);

		// elements for label selectMove
		errorMessage.setBackground(Color.RED);
		errorMessage.setForeground(Color.RED);
		errorMessage.setFont(new Font("Tahoma", Font.BOLD, 25));
		errorMessage.setBounds(410, 350, 400, 52);
		frmQuoridorPlay.getContentPane().add(errorMessage);
		errorMessage.setVisible(false);
		
		// elements for blackPlayer
		BlackWallPanel whitePane = new BlackWallPanel(panel_10_1);
		WhiteWallPanel blackPane = new WhiteWallPanel(panel_11);
		panel_2.add(panel_10_1);
		panel_11 = blackPane.getWallPanel();
		panel_10 = whitePane.getWallPanel();

		// layout
		frmQuoridorPlay.getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - centerPanel.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - centerPanel.getHeight()) / 2);
		centerPanel.setLocation(x, y);
		centerPanel.add(boardPanel);
		centerPanel.add(navigationButtonsPanel);
		boardPanel.setLayout(null);
		boardPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		boardPanel.setPreferredSize(new Dimension(x, y + 500));
		boardPanel.setBackground(Color.lightGray);
		navigationButtonsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
	

		centerPanel.add(boardPanel);
		centerPanel.add(navigationButtonsPanel);

		boardPanel.setLayout(null);

		boardPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		boardPanel.setPreferredSize(new Dimension(x, y + 500));
		boardPanel.setBackground(Color.lightGray);
		navigationButtonsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		for (int row = 0; row < TOTAL_ROWS; row++) {
			for (int col = 0; col < TOTAL_COLS; col++) {

				errorMessage.setVisible(false);

				btnArray[row][col] = new JButton(new ImageIcon("./tile.png"));
				// btnArray[row][col].setLayout(null);
				btnArray[row][col].setVisible(true);

				btnArray[row][col].setBounds((tileWidth + 11) * row, (tileLength + 11) * col, tileWidth, tileLength);

				boardPanel.add(btnArray[row][col]);
				btnArray[row][col].addMouseListener(new ButtonActionListener(row + 1, col + 1));

			}
		}
		createBlackAndWhitePawns();

		frmQuoridorPlay.repaint();
		JButton grabWall = new JButton("Grab Wall");
		JButton dropWall = new JButton("Drop Wall");
		JButton rotateWall = new JButton("Rotate Wall");
		JPanel wallActionsPanel = new JPanel();
		wallActionsPanel.setLayout(new GridLayout(1, 3));
		wallActionsPanel.add(grabWall);
		wallActionsPanel.add(dropWall);
		wallActionsPanel.add(rotateWall);
		navigationButtonsPanel.setLayout(new GridLayout(2, 1));
		navigationButtonsPanel.add(wallActionsPanel);

		WallCandidateHandler(grabWall, dropWall);
		dropWallHandler(dropWall, grabWall);
		rotateWallHandler(rotateWall);
		createNavigationButtons();

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

		// elements for currentPlayer
		currentPlayer_Label = new JTextField();
		currentPlayer_Label.setEditable(false);
		currentPlayer_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
		currentPlayer_Label.setText("Current Player:");
		currentPlayer_Label.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(currentPlayer_Label);
		currentPlayer_Label.setColumns(10);
		currentPlayer_TextField = new JTextField();
		currentPlayer_TextField.setEditable(false);
		panel.add(currentPlayer_TextField);
		currentPlayer_TextField.setColumns(10);
		// print statement: for checking if we get the right users
		// this will get the names of player one and two that was set in prev. window
		String playerName = "";
		try {
			playerName = QuoridorApplication.getQuoridor().getCurrentGame().getCurrentPosition().getPlayerToMove().getUser().getName();
		} catch (Exception e) {
		}
		currentPlayer_TextField.setText(playerName);
		currentPlayer_TextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		// layout
		JPanel panel_1 = new JPanel();
		northPanel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		// elements for remaining time
		timeRemaining_Label = new JTextField();
		timeRemaining_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
		timeRemaining_Label.setText("Time Remaining:");
		timeRemaining_Label.setEditable(false);
		panel_1.add(timeRemaining_Label);
		timeRemaining_Label.setColumns(10);
		timeRemaining_TextField = new JTextField();
		timeRemaining_TextField.setEditable(false);
		panel_1.add(timeRemaining_TextField);
		timeRemaining_TextField.setColumns(10);
		String remainingTimeValue = "";
		try {
			remainingTimeValue = QuoridorApplication.getQuoridor().getCurrentGame().getWhitePlayer().getRemainingTime()
					.toString();
		} catch (Exception e) {
		}
		timeRemaining_TextField.setText(remainingTimeValue);
	}

	private void updateCurrentPlayer(){
		String playerName = "";
		try {
			playerName = QuoridorApplication.getQuoridor().getCurrentGame().getCurrentPosition().getPlayerToMove().getUser().getName();
		} catch (Exception e) {
		}
		currentPlayer_TextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		currentPlayer_TextField.setText(playerName);
	}
	private void createBlackAndWhitePawns() {

		JButton whitePawn = new JButton();
		whitePawn.setIcon(new ImageIcon("./whitePawn.png"));
		whitePawn.setPreferredSize(new Dimension(3, 3));

		whitePawn.setMaximumSize(new Dimension(20, 20));

		whitePawn.setBounds(btnArray[0][4].getX() + tileWidth, btnArray[0][4].getY() + tileLength, 20, 20);
		JButton blackPawn = new JButton();
		blackPawn.setIcon(new ImageIcon("./lightWall.png"));

		JPanel p = new JPanel(new BorderLayout());

		btnArray[8][4].add(blackPawn);
		// p.add(blackPawn, BorderLayout.NORTH);
		btnArray[0][4].add(whitePawn);
		int x = btnArray[8][4].getX() + tileWidth;
		int y = btnArray[8][4].getY() + tileWidth;

		blackPawn.setMaximumSize(new Dimension(20, 20));
		blackPawn.setBounds(btnArray[8][4].getX() + tileWidth / 2, btnArray[8][4].getY(), 20, 20);
		this.blackPawnMove = new MoveCandidate(blackPawn, 8, 4);
		this.whitePawnMove = new MoveCandidate(whitePawn, 0, 4);
	}

	private void movePawnUp(JButton btn) {
		int[] rd = { 1, -1, 0, 0 };
		int[] cd = { 0, 0, 1, -1 };
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	private void wallsHandler(JPanel jPanel, String player) {
		// walls in stock for whitePlayer
		JPanel panel_4 = new JPanel();
		if (player.equalsIgnoreCase("black")) {

			FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
			flowLayout_1.setAlignment(FlowLayout.LEFT);
			wallsInStockBlackPlayer_Label = new JTextField();
			wallsInStockBlackPlayer_Label.setEditable(false);
			wallsInStockBlackPlayer_Label.setText("Walls in Stock:");
			panel_4.add(wallsInStockBlackPlayer_Label);
			wallsInStockBlackPlayer_Label.setColumns(10);
			wallsInStockBlackPlayer_TextField = new JTextField();
			wallsInStockBlackPlayer_TextField.setEditable(false);
			panel_4.add(wallsInStockBlackPlayer_TextField);
			wallsInStockBlackPlayer_TextField.setColumns(10);
			String value = "";
			try {
				value = QuoridorApplication.getQuoridor().getCurrentGame().getCurrentPosition().getBlackWallsInStock()
						.size() + "";
			} catch (Exception e) {
			}
			wallsInStockBlackPlayer_TextField.setText(value);
		} else if (player.equalsIgnoreCase("white")) {
			FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
			flowLayout_1.setAlignment(FlowLayout.LEFT);
			wallsInStockWhitePlayer_Label = new JTextField();
			wallsInStockWhitePlayer_Label.setEditable(false);
			wallsInStockWhitePlayer_Label.setText("Walls in Stock:");
			panel_4.add(wallsInStockWhitePlayer_Label);
			wallsInStockWhitePlayer_Label.setColumns(10);
			wallsInStockWhitePlayer_TextField = new JTextField();
			wallsInStockWhitePlayer_TextField.setEditable(false);
			panel_4.add(wallsInStockWhitePlayer_TextField);
			wallsInStockWhitePlayer_TextField.setColumns(10);
			String value = "";
			try {
				value = QuoridorApplication.getQuoridor().getCurrentGame().getCurrentPosition().getWhiteWallsInStock()
						.size() + "";
			} catch (Exception e) {
			}
			wallsInStockWhitePlayer_TextField.setText(value);
		}

		JPanel panel_5 = new JPanel();

		if (player.equalsIgnoreCase("black")) {
			FlowLayout flowLayout_2 = (FlowLayout) panel_5.getLayout();
			flowLayout_2.setAlignment(FlowLayout.LEFT);
			wallsInStockBlackPlayer_Label = new JTextField();
			wallsInStockBlackPlayer_Label.setEditable(false);
			wallsInStockBlackPlayer_Label.setText("Walls On Board:");
			panel_5.add(wallsInStockBlackPlayer_Label);
			wallsInStockBlackPlayer_Label.setColumns(10);
			wallsInStockBlackPlayer_TextField = new JTextField();
			wallsInStockBlackPlayer_TextField.setEditable(false);
			panel_5.add(wallsInStockBlackPlayer_TextField);
			wallsInStockBlackPlayer_TextField.setColumns(10);
			String value = "";
			try {
				value = QuoridorApplication.getQuoridor().getCurrentGame().getCurrentPosition().getBlackWallsOnBoard()
						.size() + "";
			} catch (Exception e) {
			}
			wallsInStockBlackPlayer_TextField.setText(value);
		} else if (player.equalsIgnoreCase("white")) {
			FlowLayout flowLayout_2 = (FlowLayout) panel_5.getLayout();
			flowLayout_2.setAlignment(FlowLayout.LEFT);
			wallsInStockWhitePlayer_Label = new JTextField();
			wallsInStockWhitePlayer_Label.setEditable(false);
			wallsInStockWhitePlayer_Label.setText("Walls On Board:");
			panel_5.add(wallsInStockWhitePlayer_Label);
			wallsInStockWhitePlayer_Label.setColumns(10);
			wallsInStockWhitePlayer_TextField = new JTextField();
			wallsInStockWhitePlayer_TextField.setEditable(false);
			panel_5.add(wallsInStockWhitePlayer_TextField);
			wallsInStockWhitePlayer_TextField.setColumns(10);
			String value = "";
			try {
				value = QuoridorApplication.getQuoridor().getCurrentGame().getCurrentPosition().getWhiteWallsOnBoard()
						.size() + "";
			} catch (Exception e) {
			}
			wallsInStockWhitePlayer_TextField.setText(value);
		}

		jPanel.add(panel_4);
		jPanel.add(panel_5);

		frmQuoridorPlay.repaint();
	}

	private void playerTimeLineHandler(JPanel jPanel, String player) {

		JPanel timePanel = new JPanel();
		timeRemaining_Label = new JTextField();
		timeRemaining_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
		timeRemaining_Label.setText("Time Remaining:");
		timeRemaining_Label.setEditable(false);
		timePanel.add(timeRemaining_Label);
		timeRemaining_Label.setColumns(10);
		timeRemaining_TextField = new JTextField();
		timeRemaining_TextField.setEditable(false);
		timePanel.add(timeRemaining_TextField);
		timeRemaining_TextField.setColumns(10);
		String time = "";
		try {
			time = QuoridorApplication.getQuoridor().getCurrentGame().getWhitePlayer().getRemainingTime().toString();
		} catch (Exception e) {
		}
		timeRemaining_TextField.setText(time);

		JPanel playerPanel = new JPanel();
		JTextField newPlayerLabel = new JTextField();
		newPlayerLabel.setEditable(false);
		newPlayerLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		if (player.equalsIgnoreCase("White")) {
			newPlayerLabel.setText("White Player:");
		} else if (player.equalsIgnoreCase("Black")) {
			newPlayerLabel.setText("Black Player:");
		}
		JTextField newPlayerTextFeild = new JTextField();
		
		newPlayerLabel.setHorizontalAlignment(SwingConstants.LEFT);
		playerPanel.add(newPlayerLabel);
		newPlayerLabel.setColumns(10);
		
		newPlayerTextFeild.setEditable(false);
		playerPanel.add(newPlayerTextFeild);
		newPlayerTextFeild.setColumns(10);
		// print statement: for checking if we get the right users
		// this will get the names of player one and two that was set in prev. window
		String name = player.equalsIgnoreCase("white") ? "Naruto" : "Sasuke";
		try {
			name = player.equalsIgnoreCase("white") ?  QuoridorApplication.getQuoridor().getUser(0).getName() : QuoridorApplication.getQuoridor().getUser(1).getName();
		} catch (Exception e) {
		}
		newPlayerTextFeild.setText(name);
		jPanel.add(playerPanel);
		jPanel.add(timePanel);
		frmQuoridorPlay.repaint();
	}

	private void rotateWallHandler(JButton rotateWall) {
		rotateWall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (wallMoveCandidate != null) {
					// if rotated then it is in vertical position
					if (wallMoveCandidate.isRotated) {

						setHorizontal();
						wallMoveCandidate.isRotated = false;
					} else {

						setVerticle();
						wallMoveCandidate.isRotated = true;
					}

				}

			}
		});
	}

	private void setHorizontal() {

		wallMoveCandidate.wallMoveBtn.setBounds(btnArray[wallMoveCandidate.row][wallMoveCandidate.col].getX(),
				btnArray[wallMoveCandidate.row][wallMoveCandidate.col].getY() + tileLength, wallWidth, 13);

	}

	private void setVerticle() {
		wallMoveCandidate.wallMoveBtn.setBounds(
				btnArray[wallMoveCandidate.row][wallMoveCandidate.col].getX() + tileWidth,
				btnArray[wallMoveCandidate.row][wallMoveCandidate.col].getY(), 13, 102);
	}

	private void moveUpHandler(BasicArrowButton btn) {
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (wallMoveCandidate != null && wallMoveCandidate.col > 0) {
					// if isRotated then it is in vertical position
					btnArray[whitePawnMove.row][whitePawnMove.col].add(whitePawnMove.wallMoveBtn);
					wallMoveCandidate.col -= 1;
					if (!wallMoveCandidate.isRotated) {

						setHorizontal();
					} else {
						setVerticle();
					}
				} else {
					// handlle message : please grab a wall if there are still more walls.
					String curPlayer = "white";
					try {
						curPlayer = QuoridorController.getCurPlayerToString();
					} catch (Exception event) {
					}
					System.out.println(curPlayer);
					if (curPlayer.equalsIgnoreCase("white")) {
						if(whitePawnMove.col > 0){
						btnArray[whitePawnMove.row][whitePawnMove.col].remove(whitePawnMove.wallMoveBtn);
						btnArray[whitePawnMove.row][--whitePawnMove.col].add(whitePawnMove.wallMoveBtn);
						}
					} else if (curPlayer.equalsIgnoreCase("black")) {
						if(blackPawnMove.col > 0){
						btnArray[blackPawnMove.row][blackPawnMove.col].remove(blackPawnMove.wallMoveBtn);
						btnArray[blackPawnMove.row][--blackPawnMove.col].add(blackPawnMove.wallMoveBtn);
						}
					}
					try {
						QuoridorController.switchCurrentPlayer();
					} catch(Exception event){}
					
				}
				updateCurrentPlayer();
				frmQuoridorPlay.repaint();

			}
		});
	}

	private void moveDownHandler(BasicArrowButton btn) {
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (wallMoveCandidate != null && wallMoveCandidate.col < 7) {
					wallMoveCandidate.col += 1;
					if (!wallMoveCandidate.isRotated) {
						setHorizontal();
					} else {
						setVerticle();
					}
				} else {
					// handlle message : please grab a wall if there are still more walls.
					String curPlayer = "white";
					try {
						curPlayer = QuoridorController.getCurPlayerToString();
					} catch (Exception event) {
					}
					
					if (curPlayer.equalsIgnoreCase("white")) {
						if (whitePawnMove.col < 8) {
							btnArray[whitePawnMove.row][whitePawnMove.col].remove(whitePawnMove.wallMoveBtn);
							btnArray[whitePawnMove.row][++whitePawnMove.col].add(whitePawnMove.wallMoveBtn);
						}
						
					} else if (curPlayer.equalsIgnoreCase("black")) {
						if (blackPawnMove.col < 8) {
							btnArray[blackPawnMove.row][blackPawnMove.col].remove(blackPawnMove.wallMoveBtn);
							btnArray[blackPawnMove.row][++blackPawnMove.col].add(blackPawnMove.wallMoveBtn);
						}
						
					}
					try {
						QuoridorController.switchCurrentPlayer();
					} catch(Exception event){}

				
				}
				updateCurrentPlayer();
				frmQuoridorPlay.repaint();

			}
		});
	}

	private void moveLeftHandler(BasicArrowButton btn) {
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (wallMoveCandidate != null && wallMoveCandidate.row < 7) {
					wallMoveCandidate.row += 1;
					if (!wallMoveCandidate.isRotated) {
						setHorizontal();
					} else {
						setVerticle();
					}
				} else {
					// handlle message : please grab a wall if there are still more walls.
					String curPlayer = "white";
					try {
						curPlayer = QuoridorController.getCurPlayerToString();
					} catch (Exception event) {
					}
					
					if (curPlayer.equalsIgnoreCase("white")) {
						if (whitePawnMove.row <8) {
							btnArray[whitePawnMove.row][whitePawnMove.col].remove(whitePawnMove.wallMoveBtn);
							btnArray[++whitePawnMove.row][whitePawnMove.col].add(whitePawnMove.wallMoveBtn);
						}
						
					} else if (curPlayer.equalsIgnoreCase("black")) {
						if (blackPawnMove.row <8) {
							btnArray[blackPawnMove.row][blackPawnMove.col].remove(blackPawnMove.wallMoveBtn);
							btnArray[++blackPawnMove.row][blackPawnMove.col].add(blackPawnMove.wallMoveBtn);
						}
						
					}
					try {
						QuoridorController.switchCurrentPlayer();
					} catch(Exception event){}

					
				}
				updateCurrentPlayer();
				frmQuoridorPlay.repaint();

			}
		});
	}

	private void moveRightHandler(BasicArrowButton btn) {
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (wallMoveCandidate != null && wallMoveCandidate.row > 0) {
					wallMoveCandidate.row -= 1;
					if (!wallMoveCandidate.isRotated) {
						setHorizontal();
					} else {
						setVerticle();
					}

				} else {
					// handlle message : please grab a wall if there are still more walls.
					String curPlayer = "white";
					try {
						curPlayer = QuoridorController.getCurPlayerToString();
					} catch (Exception event) {
					}
					
					if (curPlayer.equalsIgnoreCase("white")) {
						if (whitePawnMove.row > 0) {
							btnArray[whitePawnMove.row][whitePawnMove.col].remove(whitePawnMove.wallMoveBtn);
							btnArray[--whitePawnMove.row][whitePawnMove.col].add(whitePawnMove.wallMoveBtn);
						}
						
					} else if (curPlayer.equalsIgnoreCase("black")) {
						if (blackPawnMove.row > 0) {
							btnArray[blackPawnMove.row][blackPawnMove.col].remove(blackPawnMove.wallMoveBtn);
							btnArray[--blackPawnMove.row][blackPawnMove.col].add(blackPawnMove.wallMoveBtn);
						}
						
					}
					try {
						QuoridorController.switchCurrentPlayer();
					} catch(Exception event){}

					
				}
				updateCurrentPlayer();
				frmQuoridorPlay.repaint();
			}
		});
	}

	private void WallCandidateHandler(JButton grabWall, JButton dropWall) {

		grabWall.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// boolean grabbed =
				

				if (wallMoveCandidate == null && QuoridorController.grabWall(QuoridorApplication.getQuoridor())) {
					
					JButton wallMoveBtn = createWallMoveCandidate();
					wallMoveCandidate = new MoveCandidate(wallMoveBtn, 0, 0);
					grabWall.setText("Cancel Move");

				} else {
					boardPanel.remove(wallMoveCandidate.wallMoveBtn);
					wallMoveCandidate = null;
					grabWall.setText("Grab Wall");

				}
	
				
				frmQuoridorPlay.repaint();
			}
		});

	}

	private void dropWallHandler(JButton dropWall, JButton grabWall) {
		dropWall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(QuoridorController.wallMove(wallMoveCandidate.row + 1, wallMoveCandidate.col + 1, QuoridorController.getWallDirection(wallMoveCandidate.isRotated).toString(), QuoridorController.getWallMoveCandidate(), QuoridorController.getCurrentPlayer())){
					wallMoveCandidate.wallMoveBtn.setIcon(new ImageIcon("./dropped.png"));
					wallMoveCandidate = null;
					grabWall.setText("Grab Wall");
					updateCurrentPlayer();
					frmQuoridorPlay.repaint();
				}
				
			}
		});
	}

	private JButton createWallMoveCandidate() {
		JButton btn = new JButton(new ImageIcon("./lightWall.png"));
		btn.setBounds(btnArray[0][0].getX(), btnArray[0][0].getY() + tileLength, wallWidth, 13);
		btn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
		btn.setBorder(new EmptyBorder(2, 2, 2, 2));
		boardPanel.add(btn);

		return btn;
	}

	private void createNavigationButtons() {
		JPanel east = new JPanel();
		east.setLayout(new BoxLayout(east, BoxLayout.X_AXIS));
		JPanel newPanel = new JPanel();
		newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));

		navigationButtonsPanel.add(east, BorderLayout.NORTH);

		BasicArrowButton north = new BasicArrowButton(BasicArrowButton.NORTH) {
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(70, 70);
			}
		};
		;

		BasicArrowButton south = new BasicArrowButton(BasicArrowButton.SOUTH) {
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(70, 70);
			}
		};
		;
		BasicArrowButton west = new BasicArrowButton(BasicArrowButton.WEST) {
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(70, 70);
			}
		};
		;
		BasicArrowButton est = new BasicArrowButton(BasicArrowButton.EAST) {
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(70, 70);
			}
		};

		newPanel.add(north, BorderLayout.NORTH); // up
		newPanel.add(south, BorderLayout.SOUTH); // down
		east.add(west, BorderLayout.WEST);
		east.add(newPanel, BorderLayout.CENTER);
		east.add(est, BorderLayout.EAST);
		moveUpHandler(north);
		moveDownHandler(south);
		moveLeftHandler(est);
		moveRightHandler(west);
		frmQuoridorPlay.repaint();
	}

	private void createWalls(JPanel jPanel) {
		for (int i = 0; i < 10; i++) { // Initializing the walls for both players
			JButton btn = new JButton("Wall" + i);
			btn.setBounds(10, 11 + i * (wallHeight + 5), wallWidth, wallHeight);
			jPanel.add(btn);
		}
	}

	private void validatePawnPosition() {

		int Player = QuoridorController.currentPlayerInt();
		if (Player == 1) {

			int row = QuoridorController.getBlackPlayerPlayerPosition().getTile().getRow();
			int col = QuoridorController.getBlackPlayerPlayerPosition().getTile().getColumn();

			if (QuoridorController.initializeValidatePosition(row - 1, col) == true) {

				btnArray[row - 1][col].setBackground(Color.GREEN);

			}
			if (QuoridorController.initializeValidatePosition(row + 1, col) == true) {

				btnArray[row + 1][col].setBackground(Color.GREEN);

			}
			if (QuoridorController.initializeValidatePosition(row, col - 1) == true) {

				btnArray[row][col - 1].setBackground(Color.GREEN);

			}
			if (QuoridorController.initializeValidatePosition(row, col + 1) == true) {

				btnArray[row][col + 1].setBackground(Color.GREEN);

			}
		}
		if (Player == 0) {

			int row = QuoridorController.getWhitePlayerPosition().getTile().getRow();
			int col = QuoridorController.getWhitePlayerPosition().getTile().getColumn();

			if (QuoridorController.initializeValidatePosition(row - 1, col) == true) {

				btnArray[row - 1][col].setBackground(Color.GREEN);

			}
			if (QuoridorController.initializeValidatePosition(row + 1, col) == true) {

				btnArray[row + 1][col].setBackground(Color.GREEN);

			}
			if (QuoridorController.initializeValidatePosition(row, col - 1) == true) {

				btnArray[row][col - 1].setBackground(Color.GREEN);

			}
			if (QuoridorController.initializeValidatePosition(row, col + 1) == true) {

				btnArray[row][col + 1].setBackground(Color.GREEN);

			}
		}

	}

	public static void tileListener(int row, int col) {

		for (int i = 0; i < 20; i++) {

			if (wallArray[i].isVisible() == false) {// checking if there is one wall grabbed or not

				WallGrabbed = true;
				wallIndex = i;

			} else {
				continue;
			}
		}
		if (WallGrabbed == true) {

			vertical.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent e) {
					moveWallView(row, col, "vertical", wallIndex);
				}
			});

			horizontal.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent e) {

					moveWallView(row, col, "horizontal", wallIndex);

				}
			});

		}
		if (WallGrabbed == false) {

			if (btnArray[CurrRow][CurrCol].getBackground().equals(Color.GREEN)) {

				// TODO implement pawn move

			} else {

				errorMessage.setVisible(true);
				SwingUtilities.updateComponentTreeUI(frmQuoridorPlay);

			}

		}
		WallGrabbed = false;

	}

	public static void moveWallView(int row, int col, String dir, int wallIndex) {
		if (wallIndex <= 9) {

			panel_10.remove(wallArray[wallIndex]);
			centerPanel.add(wallArray[wallIndex]);
			wallArray[wallIndex].setVisible(true);
			if (QuoridorController.wallMove(row, col, dir, QuoridorController.getWall(wallIndex),
					QuoridorController.getCurrentPlayer()) == true) {
				if (dir.equals("horizontal")) {

					wallArray[wallIndex].setBounds(btnArray[row - 1][col - 1].getX(),
							btnArray[row - 1][col - 1].getY() + tileWidth, wallWidth, wallHeight);
					wallArray[wallIndex].setVisible(true);
					SwingUtilities.updateComponentTreeUI(frmQuoridorPlay);

				} else {
					wallArray[wallIndex].setBounds(btnArray[row - 1][col - 1].getX() + tileLength,
							btnArray[row - 1][col - 1].getY(), wallHeight, wallWidthV);
					wallArray[wallIndex].setVisible(true);
					SwingUtilities.updateComponentTreeUI(frmQuoridorPlay);
				}

			} else {
				errorMessage.setVisible(true);

			}

		}
		if (wallIndex > 9) {

			panel_11.remove(wallArray[wallIndex]);
			centerPanel.add(wallArray[wallIndex]);
			if (QuoridorController.wallMove(row, col, dir, QuoridorController.getWall(wallIndex),
					QuoridorController.getCurrentPlayer()) == true) {
				if (dir.equals("horizontal")) {
					btnArray[row][col].setBackground(Color.RED);
					wallArray[wallIndex].setBounds(btnArray[row - 1][col - 1].getX(),
							btnArray[row - 1][col - 1].getY() + tileWidth, wallWidth, wallHeight);
					wallArray[wallIndex].setVisible(true);
					SwingUtilities.updateComponentTreeUI(frmQuoridorPlay);

				} else {
					wallArray[wallIndex].setBounds(btnArray[row - 1][col - 1].getX() - 11,
							btnArray[row - 1][col - 1].getY(), wallHeight, wallWidthV);
					wallArray[wallIndex].setVisible(true);
					SwingUtilities.updateComponentTreeUI(frmQuoridorPlay);
				}

			} else {
				errorMessage.setVisible(true);

			}
		}

	}
}

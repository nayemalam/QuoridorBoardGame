package ca.mcgill.ecse223.quoridor.view;

import java.awt.EventQueue;
import ca.mcgill.ecse223.quoridor.controller.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
//import ca.mcgill.ecse223.quoridor.view.MouseListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class QuoridorPage {

	JButton[][] btnArray = new JButton[9][9];
	JButton[] WallArray = new JButton[20];
	JButton horizontal = new JButton();
	JButton vertical = new JButton();

	private int idWhite = -1;
	private int idBlack = 8;
	private int CurrPlayer = 0;
	private int index;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuoridorPage window = new QuoridorPage();
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
	public QuoridorPage() {
		initialize();
		placeWall();
		validatePawnPosition();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Quoridor");
		frame.setBounds(100, 100, 1165, 693);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnWall = new JButton("Wall");
		btnWall.setBounds(993, 399, 89, 9);
		frame.getContentPane().add(btnWall);


		btnWall.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				btnWall.setBackground(Color.RED);;
				frame.addMouseListener(new MouseAdapter(){

					public void mouseClicked(MouseEvent ev) {

						btnWall.setLocation(ev.getXOnScreen(), ev.getYOnScreen());
						btnWall.setBackground(Color.black);
					}
				});
			}
		});


	}



	private void placeWall() {



		JButton btnMoveWall = new JButton("Place new Wall");
		btnMoveWall.setBounds(970, 29, 133, 62);
		frame.getContentPane().add(btnMoveWall);

		btnMoveWall.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {


				creatingNewWall();

			}
		});




	}
	private void validatePawnPosition() {

		int Player = QuoridorController.currentPlayerInt();
		if(Player == 1) {

			int row = QuoridorController.getBlackPlayerPlayerPosition().getTile().getRow();
			int col = QuoridorController.getBlackPlayerPlayerPosition().getTile().getColumn();


			if(QuoridorController.initializeValidatePosition(row-1 , col) == true) {


				btnArray[row-1][col].setBackground(Color.GREEN);

			}
			if(QuoridorController.initializeValidatePosition(row+1 , col) == true) {


				btnArray[row+1][col].setBackground(Color.GREEN);

			}
			if(QuoridorController.initializeValidatePosition(row , col-1) == true) {


				btnArray[row][col-1].setBackground(Color.GREEN);

			}
			if(QuoridorController.initializeValidatePosition(row , col+1) == true) {


				btnArray[row][col+1].setBackground(Color.GREEN);

			}
		}
		if(Player == 0) {

			int row = QuoridorController.getWhitePlayerPosition().getTile().getRow();
			int col = QuoridorController.getWhitePlayerPosition().getTile().getColumn();


			if(QuoridorController.initializeValidatePosition(row-1 , col) == true) {


				btnArray[row-1][col].setBackground(Color.GREEN);

			}
			if(QuoridorController.initializeValidatePosition(row+1 , col) == true) {


				btnArray[row+1][col].setBackground(Color.GREEN);

			}
			if(QuoridorController.initializeValidatePosition(row , col-1) == true) {


				btnArray[row][col-1].setBackground(Color.GREEN);

			}
			if(QuoridorController.initializeValidatePosition(row , col+1) == true) {


				btnArray[row][col+1].setBackground(Color.GREEN);

			}
		}



	}

	private void creatingNewWall() {

		if(QuoridorController.currentPlayerInt() == 0) {
			idWhite++;
			if(idWhite > 9) {
				// TODO create a text zone to say there are no more walls
			}
			CurrPlayer = 0;
			WallArray[idWhite] = new JButton("Wall"+ idWhite );
			WallArray[idWhite].setBounds(993, 399, 89, 9);
			frame.getContentPane().add(WallArray[idWhite]);
			SwingUtilities.updateComponentTreeUI(frame);
		}
		if(QuoridorController.currentPlayerInt() == 1) {
			idBlack++;
			if(idBlack>19) {
				// TODO Create a text zone to say there are no more walls
			}
			CurrPlayer = 1;
			WallArray[idBlack] = new JButton("Wall"+ idBlack);
			WallArray[idBlack].setBounds(993, 399, 89, 9);
			frame.getContentPane().add(WallArray[idBlack]);
			SwingUtilities.updateComponentTreeUI(frame);
		}





	}

	private void BoardListener() {

		for(int i = 0; i<= btnArray.length; i++) {
			index = i;
			btnArray[i][i].addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent e) {

					int col = 0;
					while(index%9 != 0) {
						col++;
						index--;
					}

					int row = (index/9)+1;
					if(CurrPlayer == 0) {
						if(QuoridorController.initiatePosValidation(row, col, "horizontal", idWhite) == true && QuoridorController.initiatePosValidation(row, col, "vertical", idWhite) == true ) {

							horizontal.setBounds(btnArray[index][index].getX(),btnArray[index][index].getY(), 89, 9);
							frame.getContentPane().add(horizontal);
							horizontal.setVisible(true);
							vertical.setBounds(993, 399, 89, 9);
							frame.getContentPane().add(vertical);
							vertical.setVisible(true);
							// :TODO try implementing wall move here and add the button for position

						}
						if(QuoridorController.initiatePosValidation(row, col, "horizontal", idWhite) == true && QuoridorController.initiatePosValidation(row, col, "vertical", idWhite) == false ) {

							// :TODO try implementing wall move here and add the button for position

						}
						if(QuoridorController.initiatePosValidation(row, col, "horizontal", idWhite) == false && QuoridorController.initiatePosValidation(row, col, "vertical", idWhite) == true ) {

							// :TODO try implementing wall move here and add the button for position

						}
						if(QuoridorController.initiatePosValidation(row, col, "horizontal", idWhite) == false && QuoridorController.initiatePosValidation(row, col, "vertical", idWhite) == false) {

							// :TODO try implementing wall move here and add the button for position

						}

					}
					else {

						if(QuoridorController.initiatePosValidation(row, col, "horizontal", idBlack) == true && QuoridorController.initiatePosValidation(row, col, "vertical", idWhite) == true ) {

							// :TODO try implementing wall move here and add the button for position

						}
						if(QuoridorController.initiatePosValidation(row, col, "horizontal", idBlack) == true && QuoridorController.initiatePosValidation(row, col, "vertical", idWhite) == false ) {

							// :TODO try implementing wall move here and add the button for position

						}
						if(QuoridorController.initiatePosValidation(row, col, "horizontal", idBlack) == false && QuoridorController.initiatePosValidation(row, col, "vertical", idWhite) == true ) {

							// :TODO try implementing wall move here and add the button for position

						}
						if(QuoridorController.initiatePosValidation(row, col, "horizontal", idBlack) == false && QuoridorController.initiatePosValidation(row, col, "vertical", idWhite) == false) {

							// :TODO try implementing wall move here and add the button for position

						}
					}


				}
			});
		}
	}
}

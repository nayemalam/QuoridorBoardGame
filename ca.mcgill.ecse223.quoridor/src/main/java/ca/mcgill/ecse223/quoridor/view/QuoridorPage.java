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

	JButton[] btnArray = new JButton[81];


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

		JButton btnWall = new JButton("Wall");
		btnWall.setBounds(993, 399, 89, 9);
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
		frame.getContentPane().setLayout(null);


		//			public void mouseDragged(MouseEvent e) {
		//				btnWall.setLocation(e.getXOnScreen(), e.getYOnScreen());
		//				SwingUtilities.updateComponentTreeUI(frame);
		//						}


		frame.getContentPane().add(btnWall);
		SwingUtilities.updateComponentTreeUI(frame);





	}



	private void placeWall() {



		JButton btnMoveWall = new JButton("Place new Wall");
		btnMoveWall.setBounds(970, 29, 133, 62);
		frame.getContentPane().add(btnMoveWall);

		btnMoveWall.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				JButton btnWall = new JButton("Wall");
				btnWall.setBounds(993, 399, 89, 9);
				frame.getContentPane().add(btnWall);
				SwingUtilities.updateComponentTreeUI(frame);
				
				for(int i = 0; i<= btnArray.length; i++) {
					
					btnArray[i].addMouseListener(new MouseAdapter() {
						
						public void mouseClicked(MouseEvent e) {
							
							
						}
					});
				}


			}
		});




	}
	private void validatePawnPosition() {


		int Player = QuoridorController.currentPlayerInt();
		if(Player == 1) {

			int row = QuoridorController.getBlackPlayerPlayerPosition().getTile().getRow();
			int col = QuoridorController.getBlackPlayerPlayerPosition().getTile().getColumn();


			if(QuoridorController.initializeValidatePosition(row-1 , col) == true) {

				int indexOfTile = (row-2)*9+ col;
				btnArray[indexOfTile].setBackground(Color.GREEN);

			}
			if(QuoridorController.initializeValidatePosition(row+1 , col) == true) {

				int indexOfTile = (row)*9+ col;
				btnArray[indexOfTile].setBackground(Color.GREEN);

			}
			if(QuoridorController.initializeValidatePosition(row , col-1) == true) {

				int indexOfTile = (row-1)*9+ col-1;
				btnArray[indexOfTile].setBackground(Color.GREEN);

			}
			if(QuoridorController.initializeValidatePosition(row , col+1) == true) {

				int indexOfTile = (row-1)*9+ col+1;
				btnArray[indexOfTile].setBackground(Color.GREEN);

			}
		}



	}
}

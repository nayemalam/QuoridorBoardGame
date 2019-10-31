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

	private boolean event;
	
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
		initializeBoard();
		PlaceWall();
		movePawn();
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
	
	private void initializeBoard() {
		
		
	}
	
	private void PlaceWall() {
		
		
		
		JButton btnMoveWall = new JButton("Place new Wall");
		btnMoveWall.setBounds(970, 29, 133, 62);
		frame.getContentPane().add(btnMoveWall);
		
		btnMoveWall.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				JButton btnWall = new JButton("Wall");
				btnWall.setBounds(993, 399, 89, 9);
				frame.getContentPane().add(btnWall);
				SwingUtilities.updateComponentTreeUI(frame);
				btnWall.addMouseMotionListener(new MouseMotionAdapter() {
	
					public void mouseDragged(MouseEvent e) {
						
						btnWall.setAlignmentX(e.getX());
						btnWall.setAlignmentY(e.getY());
						SwingUtilities.updateComponentTreeUI(frame);
					}
				});
				
				
			}
		});
		

		
		
	}
	private void movePawn() {
		
		JButton btnMovePawn = new JButton("Move Pawn");
		btnMovePawn.setBounds(970, 118, 133, 62);
		frame.getContentPane().add(btnMovePawn);
		
		
		btnMovePawn.addMouseListener(new java.awt.event.MouseAdapter()
	    {
	        public void mousePressed(java.awt.event.MouseEvent evt)
	        {

	    		JButton btnright = new JButton("right");
	    		btnright.setBounds(970, 250, 66, 31);
	    		frame.getContentPane().add(btnright);
	    		btnright.setVisible(true);
	    		
	    		JButton btnleft = new JButton("left");
	    		btnleft.setBounds(1036, 250, 66, 31);
	    		frame.getContentPane().add(btnleft);
	    		btnleft.setVisible(true);
	    		
	    		JButton btnup = new JButton("up");
	    		btnup.setBounds(1001, 217, 66, 31);
	    		frame.getContentPane().add(btnup);
	    		btnup.setVisible(true);
	    		
	    		JButton btndown = new JButton("down");
	    		btndown.setBounds(1001, 284, 66, 31);
	    		frame.getContentPane().add(btndown);
	    		btndown.setVisible(true);
	    		
	    		SwingUtilities.updateComponentTreeUI(frame);
	    		
	        }
	    });
		
	}
}

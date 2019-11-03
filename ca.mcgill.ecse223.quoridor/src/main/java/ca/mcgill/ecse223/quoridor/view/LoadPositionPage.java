package ca.mcgill.ecse223.quoridor.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import ca.mcgill.ecse223.quoridor.controller.*;

public class LoadPositionPage {
	private JFrame frame;
	private QuoridorController QC;
	private boolean valid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadPositionPage window = new LoadPositionPage();
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
	public LoadPositionPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		JLabel InvalidLoadLabel = new JLabel("Invalid file, Please select another file");
		InvalidLoadLabel.setForeground(Color.RED);
		InvalidLoadLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		InvalidLoadLabel.setHorizontalAlignment(SwingConstants.CENTER);
		InvalidLoadLabel.setBounds(401, 121, 349, 20);
		frame.getContentPane().add(InvalidLoadLabel);
		InvalidLoadLabel.setVisible(false);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1165, 693);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel LoadPositionFileLabel = new JLabel("Select File to Load:");
		LoadPositionFileLabel.setBackground(Color.WHITE);
		LoadPositionFileLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LoadPositionFileLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LoadPositionFileLabel.setBounds(10, 151, 332, 68);
		frame.getContentPane().add(LoadPositionFileLabel);
		
		JButton loadPositionFileButton = new JButton("Load File\r\n");
		loadPositionFileButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					valid = QC.loadSavedPosition("");
				} catch (IOException e1) {
					
					InvalidLoadLabel.setVisible(true);
					
				}
			}
		});
		loadPositionFileButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loadPositionFileButton.setBounds(904, 151, 238, 68);
		frame.getContentPane().add(loadPositionFileButton);
		
		//MouseListener mouseListenerLoadGameFileButton = new MouseListener();
		
		JComboBox LoadFileComboBox = new JComboBox();
		LoadFileComboBox.setBounds(283, 151, 586, 68);
		frame.getContentPane().add(LoadFileComboBox);
		
		JLabel TitleLabel = new JLabel("Quoridor\r\n");
		TitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setBounds(283, 10, 586, 101);
		frame.getContentPane().add(TitleLabel);
		
	}
}

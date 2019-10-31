package ca.mcgill.ecse223.quoridor.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class LoadGamePage {
	private JFrame frame;

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
		
		JLabel LoadGameFileLabel = new JLabel("Select which Game File to Load:");
		LoadGameFileLabel.setBackground(Color.WHITE);
		LoadGameFileLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LoadGameFileLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LoadGameFileLabel.setBounds(10, 151, 469, 68);
		frame.getContentPane().add(LoadGameFileLabel);
		
		JButton loadGameFileButton = new JButton("Load Game File\r\n");
		loadGameFileButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loadGameFileButton.setBounds(977, 151, 165, 68);
		frame.getContentPane().add(loadGameFileButton);
		
		//MouseListener mouseListenerLoadGameFileButton = new MouseListener();
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(381, 151, 586, 68);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Quoridor\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(381, 10, 586, 118);
		frame.getContentPane().add(lblNewLabel);
	}
}

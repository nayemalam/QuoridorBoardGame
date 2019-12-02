package ca.mcgill.ecse223.quoridor.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.model.Game.GameStatus;

import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameWonPopup {

	public JFrame frame;
	private JTextField txtGameOver;
	JTextField textArea;
	private JPanel panel_2;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWonPopup window = new GameWonPopup();
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
	public GameWonPopup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.POPUP);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		txtGameOver = new JTextField();
		txtGameOver.setEditable(false);
		txtGameOver.setFont(new Font("Monospaced", Font.BOLD, 25));
		txtGameOver.setBackground(SystemColor.activeCaption);
		txtGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		txtGameOver.setText("Game Over");
		panel.add(txtGameOver);
		txtGameOver.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		textArea = new JTextField();
		textArea.setEditable(false);
		panel_1.add(textArea);
		
		panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("Exit Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				System.exit(0);
			}
		});
		panel_2.add(btnNewButton);
		
		// Get text to write down
		DisplayWinnerText();
	}

	private void DisplayWinnerText() {
		GameStatus status = QuoridorApplication.getQuoridor().getCurrentGame().getGameStatus();
		String text = "";
		if(status.equals(GameStatus.WhiteWon)) {
			text += "White Player ( " + QuoridorApplication.getQuoridor().getCurrentGame().getWhitePlayer().getUser().getName() +" ) wins!" ;
		} else if(status.equals(GameStatus.BlackWon)) {
			text += "Black Player ( " + QuoridorApplication.getQuoridor().getCurrentGame().getBlackPlayer().getUser().getName() +" ) wins!" ;
		} else if(status.equals(GameStatus.Draw)) {
			text += "Game is a draw";
		} else {
			text += status.toString();
		}
		
		textArea.setText(text);
		
	}

}

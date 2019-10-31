package ca.mcgill.ecse223.quoridor.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.border.BevelBorder;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartGameWindow {

	private JFrame frmStartGame;
	private JTextField txtStartNewGame;
	private JTextField txtPlayerName;
	private JTextField txtPlayerName_1;
	private JTextField textField_Player2Name;
	private JTextField txtTotalThinkingTime;
	private JTextField textField_Minutes;
	private JTextField txtMinutes;
	private JTextField textField_Seconds;
	private JTextField txtSeconds;
	private JTextField textField_Player1Name;
	private JPanel panel_3;
	private JButton btnNewButton;
	private JTextField textField_errors;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartGameWindow window = new StartGameWindow();
					window.frmStartGame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartGameWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStartGame = new JFrame();
		frmStartGame.setResizable(false);
		frmStartGame.setTitle("Quoridor - Start New Game");
		frmStartGame.getContentPane().setBackground(SystemColor.textHighlightText);
		frmStartGame.setBounds(100, 100, 566, 380);
		frmStartGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel topPanel = new JPanel();
		topPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		topPanel.setBackground(SystemColor.activeCaption);
		frmStartGame.getContentPane().add(topPanel, BorderLayout.NORTH);
		
		JTextPane txtpnQuoridor = new JTextPane();
		txtpnQuoridor.setForeground(Color.BLACK);
		txtpnQuoridor.setEnabled(false);
		txtpnQuoridor.setBackground(SystemColor.activeCaption);
		txtpnQuoridor.setEditable(false);
		txtpnQuoridor.setFont(new Font("Monospaced", Font.BOLD, 30));
		txtpnQuoridor.setText("Quoridor");
		topPanel.add(txtpnQuoridor);
		
		JPanel panel = new JPanel();
		frmStartGame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		txtStartNewGame = new JTextField();
		txtStartNewGame.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtStartNewGame.setForeground(Color.BLACK);
		txtStartNewGame.setHorizontalAlignment(SwingConstants.LEFT);
		txtStartNewGame.setEnabled(false);
		txtStartNewGame.setEditable(false);
		txtStartNewGame.setText("Start New Game");
		panel.add(txtStartNewGame, BorderLayout.NORTH);
		txtStartNewGame.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		FormLayout fl_panel_1 = new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,});
		panel_1.setLayout(fl_panel_1);
		
		txtPlayerName = new JTextField();
		txtPlayerName.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtPlayerName.setEnabled(false);
		txtPlayerName.setEditable(false);
		txtPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlayerName.setText("Player 1 Name:");
		panel_1.add(txtPlayerName, "2, 2, fill, fill");
		txtPlayerName.setColumns(10);
		
		textField_Player1Name = new JTextField();
		textField_Player1Name.setToolTipText("Please enter a name for player 1");
		panel_1.add(textField_Player1Name, "4, 2, fill, default");
		textField_Player1Name.setColumns(10);
		
		txtPlayerName_1 = new JTextField();
		txtPlayerName_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtPlayerName_1.setEnabled(false);
		txtPlayerName_1.setEditable(false);
		txtPlayerName_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlayerName_1.setText("Player 2 Name:");
		panel_1.add(txtPlayerName_1, "2, 4, fill, fill");
		txtPlayerName_1.setColumns(10);
		
		textField_Player2Name = new JTextField();
		textField_Player2Name.setToolTipText("Please enter a name for player 2");
		panel_1.add(textField_Player2Name, "4, 4, fill, default");
		textField_Player2Name.setColumns(10);
		
		txtTotalThinkingTime = new JTextField();
		txtTotalThinkingTime.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTotalThinkingTime.setEnabled(false);
		txtTotalThinkingTime.setEditable(false);
		txtTotalThinkingTime.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalThinkingTime.setText("Thinking Time:");
		panel_1.add(txtTotalThinkingTime, "2, 6, fill, top");
		txtTotalThinkingTime.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, "4, 6, fill, top");
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		textField_Minutes = new JTextField();
		textField_Minutes.setToolTipText("Enter a thinking time in minutes");
		panel_2.add(textField_Minutes);
		textField_Minutes.setColumns(10);
		
		txtMinutes = new JTextField();
		txtMinutes.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtMinutes.setEnabled(false);
		txtMinutes.setEditable(false);
		txtMinutes.setText("Minutes");
		panel_2.add(txtMinutes);
		txtMinutes.setColumns(10);
		
		textField_Seconds = new JTextField();
		textField_Seconds.setToolTipText("Enter a thinking time in seconds");
		panel_2.add(textField_Seconds);
		textField_Seconds.setColumns(10);
		
		txtSeconds = new JTextField();
		txtSeconds.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtSeconds.setEditable(false);
		txtSeconds.setEnabled(false);
		txtSeconds.setText("Seconds");
		panel_2.add(txtSeconds);
		txtSeconds.setColumns(10);
		
		panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("Start Game!");
		btnNewButton.setToolTipText("Start New Game with above information");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		panel_3.add(btnNewButton);
		
		textField_errors = new JTextField();
		textField_errors.setEnabled(false);
		textField_errors.setEditable(false);
		panel_3.add(textField_errors);
		textField_errors.setColumns(10);
	}

}

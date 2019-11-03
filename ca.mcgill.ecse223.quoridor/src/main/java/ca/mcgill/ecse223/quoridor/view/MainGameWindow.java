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
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
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
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton Tile_1_1;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JButton btnNewButton_8;
	private JButton btnNewButton_9;
	private JButton btnNewButton_10;
	private JButton btnNewButton_11;
	private JButton btnNewButton_12;
	private JButton btnNewButton_13;
	private JButton btnNewButton_14;
	private JButton btnNewButton_15;
	private JButton btnNewButton_16;
	private JButton btnNewButton_17;
	private JButton btnNewButton_18;
	private JButton btnNewButton_19;
	private JButton btnNewButton_20;
	private JButton btnNewButton_21;
	private JButton btnNewButton_22;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_10;
	private JButton button_11;
	private JButton button_12;
	private JButton button_13;
	private JButton button_14;
	private JButton button_15;
	private JButton button_16;
	private JButton button_17;
	private JButton button_18;
	private JButton button_19;
	private JButton button_20;
	private JButton button_21;
	private JButton button_22;
	private JButton button_23;
	private JButton button_24;
	private JButton button_25;
	private JButton button_26;
	private JButton button_27;
	private JButton button_28;
	private JButton button_29;
	private JButton button_30;
	private JButton button_31;
	private JButton button_32;
	private JButton button_33;
	private JButton button_34;
	private JButton button_35;
	private JButton button_36;
	private JButton button_37;
	private JButton button_38;
	private JButton button_39;
	private JButton button_40;
	private JButton button_41;
	private JButton button_42;
	private JButton button_43;
	private JButton button_44;
	private JButton button_45;
	private JButton button_46;
	private JButton button_47;
	private JButton button_48;
	private JButton button_49;
	private JButton button_50;
	private JButton button_51;
	private JButton button_52;
	private JButton button_53;
	private JButton button_54;
	private JButton button_55;
	private JButton button_56;
	private JButton button_57;
	private JButton button_58;
	private JButton button_59;
	private JButton button_60;
	private JButton button_61;
	private JButton button_62;
	private JButton button_63;
	private JButton button_64;
	private JButton button_65;
	private JButton button_66;
	private JButton button_67;
	private JButton button_68;
	private JButton button_69;
	private JButton button_70;
	private JButton button_71;
	private JButton button_72;
	private JButton button_73;
	private JButton button_74;
	private JButton button_75;
	private JButton button_76;
	private JButton button_77;
	private JButton button_78;
	private JButton button_79;
	private JButton button_80;
	private JButton button_81;
	private JButton button_82;
	private JButton button_83;
	private JButton button_84;
	private JButton button_85;
	private JButton button_86;
	private JButton button_87;
	private JButton button_88;
	private JButton button_89;
	private JButton button_90;
	private JButton button_91;
	private JButton button_92;
	private JButton button_93;
	private JButton button_94;
	private JButton button_95;
	private JButton button_96;
	private JButton button_97;
	private JButton button_98;
	private JButton button_99;
	private JButton button_100;
	private JButton button_101;
	private JButton button_102;
	private JButton button_103;
	private JButton button_104;
	private JButton button_105;
	private JButton button_106;
	private JButton button_107;
	private JButton button_108;
	private JButton button_109;
	private JButton button_110;
	private JButton button_111;
	private JButton button_112;
	private JButton button_113;
	private JButton button_114;
	private JButton button_115;
	private JButton button_116;
	private JButton button_117;
	private JButton button_118;
	private JButton button_119;
	private JButton button_120;
	private JButton button_121;
	private JButton button_122;
	private JButton button_123;
	private JButton button_124;
	private JButton button_125;
	private JButton button_126;
	private JButton button_127;
	private JButton button_128;
	private JButton button_129;
	private JButton button_130;
	private JButton button_131;
	private JButton button_132;
	private JButton button_133;
	private JButton button_134;
	private JButton button_135;
	private JButton button_136;
	private JButton button_137;
	private JButton button_138;
	private JButton button_139;
	private JButton button_140;
	private JButton button_141;
	private JButton button_142;
	private JButton button_143;
	private JButton button_144;
	private JButton button_145;
	private JButton button_146;
	private JButton button_147;
	private JButton button_148;
	private JButton button_149;
	private JButton button_150;
	private JButton button_151;
	private JButton button_152;
	private JButton button_153;
	private JButton button_154;
	private JButton button_155;
	private JButton button_156;
	private JButton button_157;
	private JButton button_158;
	private JButton button_159;
	private JButton button_160;
	private JButton button_161;
	private JButton button_162;
	private JButton button_163;
	private JButton button_164;
	private JButton button_165;
	private JButton button_166;
	private JButton button_167;
	private JButton button_168;
	private JButton button_169;
	private JButton button_170;
	private JButton button_171;
	private JButton button_172;
	private JButton button_173;
	private JButton button_174;
	private JButton button_175;
	private JButton button_176;
	private JButton button_177;
	private JButton button_178;
	private JButton button_179;
	private JButton button_180;
	private JButton button_181;
	private JButton button_182;
	private JButton button_183;
	private JButton button_184;
	private JButton button_185;
	private JButton button_186;
	private JButton button_187;
	private JButton button_188;
	private JButton button_189;
	private JButton button_190;
	private JButton button_191;
	private JButton button_192;
	private JButton button_193;
	private JButton button_194;
	private JButton button_195;
	private JButton button_196;
	private JButton button_197;
	private JButton button_198;
	private JButton button_199;
	private JButton button_200;
	private JButton button_201;
	private JButton button_202;
	private JButton button_203;
	private JButton button_204;
	private JButton button_205;
	private JButton button_206;
	private JButton button_207;
	private JButton button_208;
	private JButton button_209;
	private JButton button_210;
	private JButton button_211;
	private JButton button_212;
	private JButton button_213;
	private JButton button_214;
	private JButton button_215;
	private JButton button_216;
	private JButton button_217;
	private JButton button_218;
	private JButton button_219;
	private JButton button_220;
	private JButton button_221;
	private JButton button_222;
	private JButton button_223;
	private JButton button_224;
	private JButton button_225;
	private JButton button_226;
	private JButton button_227;
	private JButton button_228;
	private JButton button_229;
	private JButton button_230;
	private JButton button_231;
	private JButton button_232;
	private JButton button_233;
	private JButton button_234;
	private JButton button_235;
	private JButton button_236;
	private JButton button_237;
	private JButton button_238;
	private JButton button_239;
	private JButton button_240;
	private JButton button_241;
	private JButton button_242;
	private JButton button_243;
	private JButton button_244;
	private JButton button_245;
	private JButton button_246;
	private JButton button_247;
	private JButton button_248;
	private JButton button_249;
	private JButton button_250;
	private JButton button_251;
	private JButton button_252;
	private JButton button_253;
	private JButton button_254;
	private JButton button_255;
	private JButton button_256;
	private JButton button_257;
	private JButton button_258;
	private JButton button_259;
	private JButton button_260;
	private JButton button_261;
	private JButton button_262;
	private JButton button_263;
	private JButton button_264;
	private JButton button_265;
	private JButton button_266;
	private JButton button_267;
	private JButton button_268;
	private JButton button_269;
	private JButton button_270;
	private JButton button_271;

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
		centerPanel.setLayout(new GridLayout(17, 17, 0, 0));
		
		btnNewButton_6 = new JButton("");
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		btnNewButton_6.setBackground(SystemColor.textHighlight);
		centerPanel.add(btnNewButton_6);
		
		btnNewButton_7 = new JButton("");
		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(btnNewButton_7);
		
		btnNewButton_8 = new JButton("");
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		btnNewButton_8.setBackground(SystemColor.textHighlight);
		centerPanel.add(btnNewButton_8);
		
		btnNewButton_9 = new JButton("");
		btnNewButton_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(btnNewButton_9);
		
		btnNewButton_10 = new JButton("");
		btnNewButton_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		btnNewButton_10.setBackground(SystemColor.textHighlight);
		centerPanel.add(btnNewButton_10);
		
		btnNewButton_11 = new JButton("");
		btnNewButton_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(btnNewButton_11);
		
		btnNewButton_12 = new JButton("");
		btnNewButton_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		btnNewButton_12.setBackground(SystemColor.textHighlight);
		centerPanel.add(btnNewButton_12);
		
		btnNewButton_13 = new JButton("");
		btnNewButton_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(btnNewButton_13);
		
		btnNewButton_14 = new JButton("");
		btnNewButton_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		btnNewButton_14.setBackground(SystemColor.textHighlight);
		centerPanel.add(btnNewButton_14);
		
		btnNewButton_15 = new JButton("");
		btnNewButton_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(btnNewButton_15);
		
		btnNewButton_16 = new JButton("");
		btnNewButton_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		btnNewButton_16.setBackground(SystemColor.textHighlight);
		centerPanel.add(btnNewButton_16);
		
		btnNewButton_17 = new JButton("");
		btnNewButton_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(btnNewButton_17);
		
		btnNewButton_18 = new JButton("");
		btnNewButton_18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		btnNewButton_18.setBackground(SystemColor.textHighlight);
		centerPanel.add(btnNewButton_18);
		
		btnNewButton_19 = new JButton("");
		btnNewButton_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(btnNewButton_19);
		
		btnNewButton_20 = new JButton("");
		btnNewButton_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		btnNewButton_20.setBackground(SystemColor.textHighlight);
		centerPanel.add(btnNewButton_20);
		
		btnNewButton_21 = new JButton("");
		btnNewButton_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(btnNewButton_21);
		
		btnNewButton_22 = new JButton("");
		btnNewButton_22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		btnNewButton_22.setBackground(SystemColor.textHighlight);
		centerPanel.add(btnNewButton_22);
		
		button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button);
		
		button_1 = new JButton("");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_1);
		
		button_2 = new JButton("");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_2);
		
		button_3 = new JButton("");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_3);
		
		button_4 = new JButton("");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_4);
		
		button_5 = new JButton("");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_5);
		
		button_6 = new JButton("");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_6);
		
		button_7 = new JButton("");
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_7);
		
		button_8 = new JButton("");
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_8);
		
		button_9 = new JButton("");
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_9);
		
		button_10 = new JButton("");
		button_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_10);
		
		button_11 = new JButton("");
		button_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_11);
		
		button_12 = new JButton("");
		button_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_12);
		
		button_13 = new JButton("");
		button_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_13);
		
		button_14 = new JButton("");
		button_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_14);
		
		button_15 = new JButton("");
		button_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_15);
		
		button_16 = new JButton("");
		button_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_16);
		
		button_17 = new JButton("");
		button_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_17.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_17);
		
		button_18 = new JButton("");
		button_18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_18);
		
		button_19 = new JButton("");
		button_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_19.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_19);
		
		button_20 = new JButton("");
		button_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_20);
		
		button_21 = new JButton("");
		button_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_21.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_21);
		
		button_22 = new JButton("");
		button_22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_22);
		
		button_23 = new JButton("");
		button_23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_23.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_23);
		
		button_24 = new JButton("");
		button_24.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_24);
		
		button_25 = new JButton("");
		button_25.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_25.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_25);
		
		button_26 = new JButton("");
		button_26.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_26);
		
		button_27 = new JButton("");
		button_27.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_27.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_27);
		
		button_28 = new JButton("");
		button_28.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_28);
		
		button_29 = new JButton("");
		button_29.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_29.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_29);
		
		button_30 = new JButton("");
		button_30.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_30);
		
		button_31 = new JButton("");
		button_31.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_31.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_31);
		
		button_32 = new JButton("");
		button_32.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_32);
		
		button_33 = new JButton("");
		button_33.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_33.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_33);
		
		button_34 = new JButton("");
		button_34.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_34);
		
		button_35 = new JButton("");
		button_35.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_35);
		
		button_36 = new JButton("");
		button_36.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_36);
		
		button_37 = new JButton("");
		button_37.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_37);
		
		button_38 = new JButton("");
		button_38.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_38);
		
		button_39 = new JButton("");
		button_39.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_39);
		
		button_40 = new JButton("");
		button_40.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_40);
		
		button_41 = new JButton("");
		button_41.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_41);
		
		button_42 = new JButton("");
		button_42.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_42);
		
		button_43 = new JButton("");
		button_43.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_43);
		
		button_44 = new JButton("");
		button_44.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_44);
		
		button_45 = new JButton("");
		button_45.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_45);
		
		button_46 = new JButton("");
		button_46.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_46);
		
		button_47 = new JButton("");
		button_47.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_47);
		
		button_48 = new JButton("");
		button_48.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_48);
		
		button_49 = new JButton("");
		button_49.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_49);
		
		button_50 = new JButton("");
		button_50.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_50);
		
		button_51 = new JButton("");
		button_51.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_51.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_51);
		
		button_52 = new JButton("");
		button_52.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_52);
		
		button_53 = new JButton("");
		button_53.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_53.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_53);
		
		button_54 = new JButton("");
		button_54.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_54);
		
		button_55 = new JButton("");
		button_55.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_55.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_55);
		
		button_56 = new JButton("");
		button_56.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_56);
		
		button_57 = new JButton("");
		button_57.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_57.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_57);
		
		button_58 = new JButton("");
		button_58.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_58);
		
		button_59 = new JButton("");
		button_59.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_59.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_59);
		
		button_60 = new JButton("");
		button_60.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_60);
		
		button_61 = new JButton("");
		button_61.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_61.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_61);
		
		button_62 = new JButton("");
		button_62.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_62);
		
		button_63 = new JButton("");
		button_63.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_63.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_63);
		
		button_64 = new JButton("");
		button_64.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_64);
		
		button_65 = new JButton("");
		button_65.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_65.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_65);
		
		button_66 = new JButton("");
		button_66.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_66);
		
		button_67 = new JButton("");
		button_67.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_67.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_67);
		
		button_68 = new JButton("");
		button_68.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
		});
		centerPanel.add(button_68);
		
		button_69 = new JButton("");
		button_69.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_69);
		
		button_70 = new JButton("");
		button_70.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_70);
		
		button_71 = new JButton("");
		button_71.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_71);
		
		button_72 = new JButton("");
		button_72.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_72);
		
		button_73 = new JButton("");
		button_73.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_73);
		
		button_74 = new JButton("");
		button_74.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_74);
		
		button_75 = new JButton("");
		button_75.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_75);
		
		button_76 = new JButton("");
		button_76.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_76);
		
		button_77 = new JButton("");
		button_77.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_77);
		
		button_78 = new JButton("");
		button_78.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_78);
		
		button_79 = new JButton("");
		button_79.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_79);
		
		button_80 = new JButton("");
		button_80.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_80);
		
		button_81 = new JButton("");
		button_81.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_81);
		
		button_82 = new JButton("");
		button_82.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_82);
		
		button_102 = new JButton("");
		button_102.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_102);
		
		button_103 = new JButton("");
		button_103.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_103);
		
		button_104 = new JButton("");
		button_104.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_104.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_104);
		
		button_105 = new JButton("");
		button_105.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_105);
		
		button_106 = new JButton("");
		button_106.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_106.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_106);
		
		button_107 = new JButton("");
		button_107.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_107);
		
		button_108 = new JButton("");
		button_108.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_108.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_108);
		
		button_109 = new JButton("");
		button_109.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_109);
		
		button_110 = new JButton("");
		button_110.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_110.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_110);
		
		button_111 = new JButton("");
		button_111.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_111);
		
		button_112 = new JButton("");
		button_112.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_112.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_112);
		
		button_113 = new JButton("");
		button_113.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_113);
		
		button_114 = new JButton("");
		button_114.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_114.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_114);
		
		button_115 = new JButton("");
		button_115.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_115);
		
		button_116 = new JButton("");
		button_116.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_116.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_116);
		
		button_117 = new JButton("");
		button_117.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_117);
		
		button_118 = new JButton("");
		button_118.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_118.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_118);
		
		button_83 = new JButton("");
		button_83.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_83);
		
		button_84 = new JButton("");
		button_84.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_84.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_84);
		
		button_85 = new JButton("");
		button_85.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_85);
		
		button_86 = new JButton("");
		button_86.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_86);
		
		button_87 = new JButton("");
		button_87.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_87);
		
		button_88 = new JButton("");
		button_88.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_88);
		
		button_89 = new JButton("");
		button_89.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_89);
		
		button_90 = new JButton("");
		button_90.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_90);
		
		button_91 = new JButton("");
		button_91.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_91);
		
		button_92 = new JButton("");
		button_92.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_92);
		
		button_93 = new JButton("");
		button_93.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_93);
		
		button_94 = new JButton("");
		button_94.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_94);
		
		button_95 = new JButton("");
		button_95.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_95);
		
		button_96 = new JButton("");
		button_96.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_96);
		
		button_97 = new JButton("");
		button_97.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_97);
		
		button_98 = new JButton("");
		button_98.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_98);
		
		button_99 = new JButton("");
		button_99.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_99);
		
		button_100 = new JButton("");
		button_100.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_100);
		
		button_101 = new JButton("");
		button_101.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_101);
		
		button_119 = new JButton("");
		button_119.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_119.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_119);
		
		button_120 = new JButton("");
		button_120.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_120);
		
		button_121 = new JButton("");
		button_121.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_121.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_121);
		
		button_122 = new JButton("");
		button_122.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_122);
		
		button_123 = new JButton("");
		button_123.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_123.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_123);
		
		button_124 = new JButton("");
		button_124.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_124);
		
		button_125 = new JButton("");
		button_125.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_125.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_125);
		
		button_126 = new JButton("");
		button_126.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_126);
		
		button_127 = new JButton("");
		button_127.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_127.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_127);
		
		button_128 = new JButton("");
		button_128.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_128);
		
		button_129 = new JButton("");
		button_129.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_129.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_129);
		
		button_130 = new JButton("");
		button_130.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_130);
		
		button_131 = new JButton("");
		button_131.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_131.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_131);
		
		button_132 = new JButton("");
		button_132.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_132);
		
		button_133 = new JButton("");
		button_133.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_133.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_133);
		
		button_134 = new JButton("");
		button_134.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_134);
		
		button_135 = new JButton("");
		button_135.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_135.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_135);
		
		button_136 = new JButton("");
		button_136.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_136);
		
		button_137 = new JButton("");
		button_137.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_137);
		
		button_138 = new JButton("");
		button_138.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_138);
		
		button_139 = new JButton("");
		button_139.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_139);
		
		button_140 = new JButton("");
		button_140.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_140);
		
		button_141 = new JButton("");
		button_141.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_141);
		
		button_142 = new JButton("");
		button_142.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_142);
		
		button_143 = new JButton("");
		button_143.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_143);
		
		button_144 = new JButton("");
		button_144.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_144);
		
		button_145 = new JButton("");
		button_145.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_145);
		
		button_146 = new JButton("");
		button_146.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_146);
		
		button_147 = new JButton("");
		button_147.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_147);
		
		button_148 = new JButton("");
		button_148.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_148);
		
		button_149 = new JButton("");
		button_149.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_149);
		
		button_150 = new JButton("");
		button_150.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_150);
		
		button_151 = new JButton("");
		button_151.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_151);
		
		button_152 = new JButton("");
		button_152.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_152);
		
		button_153 = new JButton("");
		button_153.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_153.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_153);
		
		button_154 = new JButton("");
		button_154.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_154);
		
		button_155 = new JButton("");
		button_155.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_155.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_155);
		
		button_156 = new JButton("");
		button_156.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_156);
		
		button_157 = new JButton("");
		button_157.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_157.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_157);
		
		button_158 = new JButton("");
		button_158.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_158);
		
		button_159 = new JButton("");
		button_159.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_159.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_159);
		
		button_160 = new JButton("");
		button_160.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_160);
		
		button_161 = new JButton("");
		button_161.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_161.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_161);
		
		button_162 = new JButton("");
		button_162.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_162);
		
		button_163 = new JButton("");
		button_163.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_163.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_163);
		
		button_164 = new JButton("");
		button_164.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_164);
		
		button_165 = new JButton("");
		button_165.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_165.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_165);
		
		button_166 = new JButton("");
		button_166.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_166);
		
		button_167 = new JButton("");
		button_167.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_167.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_167);
		
		button_168 = new JButton("");
		button_168.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_168);
		
		button_169 = new JButton("");
		button_169.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_169.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_169);
		
		button_170 = new JButton("");
		button_170.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_170);
		
		button_171 = new JButton("");
		button_171.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_171);
		
		button_172 = new JButton("");
		button_172.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_172);
		
		button_173 = new JButton("");
		button_173.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_173);
		
		button_174 = new JButton("");
		button_174.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_174);
		
		button_175 = new JButton("");
		button_175.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_175);
		
		button_176 = new JButton("");
		button_176.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_176);
		
		button_177 = new JButton("");
		button_177.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_177);
		
		button_178 = new JButton("");
		button_178.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_178);
		
		button_179 = new JButton("");
		button_179.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_179);
		
		button_180 = new JButton("");
		button_180.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_180);
		
		button_181 = new JButton("");
		button_181.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_181);
		
		button_182 = new JButton("");
		button_182.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_182);
		
		button_183 = new JButton("");
		button_183.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_183);
		
		button_184 = new JButton("");
		button_184.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_184);
		
		button_185 = new JButton("");
		button_185.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_185);
		
		button_186 = new JButton("");
		button_186.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_186);
		
		button_187 = new JButton("");
		button_187.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_187.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_187);
		
		button_188 = new JButton("");
		button_188.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_188);
		
		button_189 = new JButton("");
		button_189.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_189.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_189);
		
		button_190 = new JButton("");
		button_190.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_190);
		
		button_191 = new JButton("");
		button_191.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_191.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_191);
		
		button_192 = new JButton("");
		button_192.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_192);
		
		button_193 = new JButton("");
		button_193.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_193.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_193);
		
		button_194 = new JButton("");
		button_194.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_194);
		
		button_195 = new JButton("");
		button_195.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_195.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_195);
		
		button_196 = new JButton("");
		button_196.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_196);
		
		button_197 = new JButton("");
		button_197.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_197.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_197);
		
		button_198 = new JButton("");
		button_198.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_198);
		
		button_199 = new JButton("");
		button_199.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_199.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_199);
		
		button_200 = new JButton("");
		button_200.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_200);
		
		button_201 = new JButton("");
		button_201.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_201.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_201);
		
		button_202 = new JButton("");
		button_202.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_202);
		
		button_203 = new JButton("");
		button_203.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_203.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_203);
		
		button_204 = new JButton("");
		button_204.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_204);
		
		button_205 = new JButton("");
		button_205.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_205);
		
		button_206 = new JButton("");
		button_206.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_206);
		
		button_207 = new JButton("");
		button_207.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_207);
		
		button_208 = new JButton("");
		button_208.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_208);
		
		button_209 = new JButton("");
		button_209.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_209);
		
		button_210 = new JButton("");
		button_210.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_210);
		
		button_211 = new JButton("");
		button_211.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_211);
		
		button_212 = new JButton("");
		button_212.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_212);
		
		button_213 = new JButton("");
		button_213.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_213);
		
		button_214 = new JButton("");
		button_214.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_214);
		
		button_215 = new JButton("");
		button_215.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_215);
		
		button_216 = new JButton("");
		button_216.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_216);
		
		button_217 = new JButton("");
		button_217.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_217);
		
		button_218 = new JButton("");
		button_218.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_218);
		
		button_219 = new JButton("");
		button_219.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_219);
		
		button_220 = new JButton("");
		button_220.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_220);
		
		button_221 = new JButton("");
		button_221.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_221.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_221);
		
		button_222 = new JButton("");
		button_222.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_222);
		
		button_223 = new JButton("");
		button_223.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_223.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_223);
		
		button_224 = new JButton("");
		button_224.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_224);
		
		button_225 = new JButton("");
		button_225.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_225.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_225);
		
		button_226 = new JButton("");
		button_226.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_226);
		
		button_227 = new JButton("");
		button_227.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_227.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_227);
		
		button_228 = new JButton("");
		button_228.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_228);
		
		button_229 = new JButton("");
		button_229.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_229.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_229);
		
		button_230 = new JButton("");
		button_230.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_230);
		
		button_231 = new JButton("");
		button_231.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_231.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_231);
		
		button_232 = new JButton("");
		button_232.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_232);
		
		button_233 = new JButton("");
		button_233.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_233.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_233);
		
		button_234 = new JButton("");
		button_234.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_234);
		
		button_235 = new JButton("");
		button_235.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_235.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_235);
		
		button_236 = new JButton("");
		button_236.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_236);
		
		button_237 = new JButton("");
		button_237.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_237.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_237);
		
		button_238 = new JButton("");
		button_238.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_238);
		
		button_239 = new JButton("");
		button_239.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_239);
		
		button_240 = new JButton("");
		button_240.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_240);
		
		button_241 = new JButton("");
		button_241.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_241);
		
		button_242 = new JButton("");
		button_242.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_242);
		
		button_243 = new JButton("");
		button_243.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_243);
		
		button_244 = new JButton("");
		button_244.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_244);
		
		button_245 = new JButton("");
		button_245.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_245);
		
		button_246 = new JButton("");
		button_246.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_246);
		
		button_247 = new JButton("");
		button_247.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_247);
		
		button_248 = new JButton("");
		button_248.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_248);
		
		button_249 = new JButton("");
		button_249.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_249);
		
		button_250 = new JButton("");
		button_250.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_250);
		
		button_251 = new JButton("");
		button_251.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_251);
		
		button_252 = new JButton("");
		button_252.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_252);
		
		button_253 = new JButton("");
		button_253.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_253);
		
		button_254 = new JButton("");
		button_254.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_254);
		
		button_255 = new JButton("");
		button_255.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_255.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_255);
		
		button_256 = new JButton("");
		button_256.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_256);
		
		button_257 = new JButton("");
		button_257.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_257.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_257);
		
		button_258 = new JButton("");
		button_258.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_258);
		
		button_259 = new JButton("");
		button_259.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_259.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_259);
		
		button_260 = new JButton("");
		button_260.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_260);
		
		button_261 = new JButton("");
		button_261.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_261.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_261);
		
		button_262 = new JButton("");
		button_262.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_262);
		
		button_263 = new JButton("");
		button_263.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_263.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_263);
		
		button_264 = new JButton("");
		button_264.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_264);
		
		button_265 = new JButton("");
		button_265.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_265.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_265);
		
		button_266 = new JButton("");
		button_266.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_266);
		
		button_267 = new JButton("");
		button_267.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_267.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_267);
		
		button_268 = new JButton("");
		button_268.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_268);
		
		button_269 = new JButton("");
		button_269.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_269.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_269);
		
		button_270 = new JButton("");
		button_270.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		centerPanel.add(button_270);
		
		button_271 = new JButton("");
		button_271.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		button_271.setBackground(SystemColor.textHighlight);
		centerPanel.add(button_271);
		
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

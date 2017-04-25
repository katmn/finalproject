package finalProject;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class GameboardGUI extends JFrame implements WindowListener {
	public static final int WIDTH = 1500;
	public static final int HEIGHT = 1000;
	
	public JPanel character1Pos = new JPanel();
	public JPanel character2Pos = new JPanel();
	public JPanel character3Pos = new JPanel();
	public JPanel character4Pos = new JPanel();
	
	public JPanel gameName = new JPanel();
	public JPanel gameboard = new JPanel(new GridLayout(30, 20));
	public JPanel characterInfo = new JPanel(new BorderLayout());
	public JPanel gameStatus = new JPanel();
	public JPanel gameplayText = new JPanel();
	
	public JTextField gamenameTextField = new JTextField("ADVENTURE GAME!!!");
	public JTextField charInfo = new JTextField();
	public JTextField charStatus = new JTextField();
	
	public JTextArea charStats = new JTextArea();
	
	
	public GameboardGUI(String title) {
		super(title);
		super.setSize(WIDTH, HEIGHT);
		super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(this);
		
		setLayout(new BorderLayout());
		
		addPanels();
	}
	
	public void addPanels() {
		gamenameTextField.setEditable(false);
		gameName.add(gamenameTextField);
		
		
		createGameboard();
		//send a character as an argument to get info
		updateCharacterInfo();
		
		add(gameName, BorderLayout.NORTH);
		add(gameboard, BorderLayout.CENTER);
		add(characterInfo, BorderLayout.WEST);
		add(gameStatus, BorderLayout.EAST);
		add(gameplayText, BorderLayout.SOUTH);
	}
	
	public void createGameboard() {
		for (int i = 0; i < 20; i++ ) {
			for (int j = 0; j < 30; j++) {
				JPanel gameboardPnl = new JPanel();
				JButton positionBtn = new JButton("MOVE");
				gameboardPnl.add(positionBtn);
				if(i % 2 == 0 && j % 2 == 0
						) {
					gameboardPnl.setBackground(Color.DARK_GRAY);
				}
				else {
					gameboardPnl.setBackground(Color.blue);
				}
				gameboard.add(gameboardPnl);
			}
		}
	}
	
	/*
	public void moveCharacter(Character character) {
		
	}
	*/
	
	//take a character as a parameter to get info
	public void updateCharacterInfo() {
		charInfo.setText("Character Info and Stats:");
		charStats.setText("HEALTH: \nSTRENGTH: \nDEXTERITY: \nSPEED:\n");
		charStatus.setText("Alive");
		
		charInfo.setEditable(false);
		charStats.setEditable(false);
		charStatus.setEditable(false);
		
		
		characterInfo.add(charInfo, BorderLayout.NORTH);
		characterInfo.add(charStats, BorderLayout.CENTER);
		characterInfo.add(charStatus, BorderLayout.SOUTH);
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		protectClose gui = new protectClose();
		gui.setVisible(true);
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}
	
	public static void main(String[] args) {
		GameboardGUI playGame = new GameboardGUI("Adventure Game");
		playGame.setVisible(true);
	}
}
 


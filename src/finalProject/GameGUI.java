package finalProject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.*;
import javax.swing.*;

public class GameGUI extends JFrame implements ActionListener, WindowListener {
	
	//=======================GAME SETUP==============================================================
	private JTextField playerPromptField = new JTextField("How many players?");
	private JTextField playerNumField = new JTextField(" - ");
	
	private JButton onePlayerBtn = new JButton("1");
	private JButton twoPlayerBtn = new JButton("2");
	private JButton threePlayerBtn = new JButton("3");
	private JButton fourPlayerBtn = new JButton("4");
	private JButton confirmBtn = new JButton("CONFIRM");
	
	private JPanel setupPanel = new JPanel(new GridLayout(4, 1));
	private JPanel setupFirstRowPanel = new JPanel(new FlowLayout());
	private JPanel setupSecondRowPanel = new JPanel(new FlowLayout());
	private JPanel setupThirdRowPanel = new JPanel(new FlowLayout());
	
	private int numPlayers = 0;
	
	//=======================CHARACTER CREATION======================================================
	private JTextField playerField = new JTextField("Player  ");
	private JTextField nameField = new JTextField("Name: ");
	private JTextField enterNameField = new JTextField(10);
	private JTextField pointsField = new JTextField("Points to spend: ");
	private JTextField numPointsField = new JTextField("40");
	private JTextField healthField = new JTextField("Health: ");
	private JTextField numHealthField = new JTextField("40");
	private JTextField strengthField = new JTextField("Strength: ");
	private JTextField numStrengthField = new JTextField("20");
	private JTextField dexterityField = new JTextField("Dexterity: ");
	private JTextField numDexterityField = new JTextField("20");
	private JTextField speedField = new JTextField("Speed: ");
	private JTextField numSpeedField = new JTextField("20");
	
	private JButton healthSubtractBtn = new JButton("-");
	private JButton healthAddBtn = new JButton("+");
	private JButton strengthSubtractBtn = new JButton("-");
	private JButton strengthAddBtn = new JButton("+");
	private JButton dexteritySubtractBtn = new JButton("-");
	private JButton dexterityAddBtn = new JButton("+");
	private JButton speedSubtractBtn = new JButton("-");
	private JButton speedAddBtn = new JButton("+");
	private JButton defaultBtn = new JButton("Default");
	private JButton resetBtn = new JButton("Reset");
	private JButton createCharacterBtn = new JButton("Create Character");
	
	private JPanel charCreationPanel = new JPanel(new GridLayout(9, 1));
	private JPanel firstRowPanel = new JPanel(new FlowLayout());
	private JPanel secondRowPanel = new JPanel(new FlowLayout());
	private JPanel thirdRowPanel = new JPanel(new FlowLayout());
	private JPanel forthRowPanel = new JPanel(new FlowLayout());
	private JPanel fifthRowPanel = new JPanel(new FlowLayout());
	private JPanel sixthRowPanel = new JPanel(new FlowLayout());
	private JPanel seventhRowPanel = new JPanel(new FlowLayout());
	private JPanel eighthRowPanel = new JPanel(new FlowLayout());
	private JPanel ninthRowPanel = new JPanel(new FlowLayout());
	
	private int characterCount = 0;
	
	private ArrayList<Characters> characters = new ArrayList<Characters>();
	
	//=======================GAMEBOARD===============================================================
	public JPanel entireGameboardPanel = new JPanel(new BorderLayout());
	
	public JPanel character1Pos = new JPanel();
	public JPanel character2Pos = new JPanel();
	public JPanel character3Pos = new JPanel();
	public JPanel character4Pos = new JPanel();
	
	public JPanel gameName = new JPanel();
	public JPanel gameboard = new JPanel(new GridLayout(30, 20));
	public JPanel characterInfo = new JPanel(new BorderLayout());
	public JPanel gameStatus = new JPanel();
	public JPanel gameplayText = new JPanel();
	
	public JTextField gameNameTextField = new JTextField("GOAL: Fight your way to the castle at the bottom of the board!!");
	public JTextField charInfo = new JTextField();
	public JTextField charStatus = new JTextField();
	
	public JTextArea charStats = new JTextArea();
	
	public GameGUI(String title) {
		super(title);
		super.setSize(300, 200);
		super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		addWindowListener(this);
		
		createPanels();
		add(setupPanel);
		
		addActionListeners();
		
		playerField.setText("Player " + (getCharacterCount() + 1));
		setCharacterCount(getCharacterCount() + 1);
	}
	
	public void createPanels() {
		//Setup
		playerPromptField.setEditable(false);
		playerNumField.setEditable(false);
		setupFirstRowPanel.add(playerPromptField);
		setupFirstRowPanel.add(playerNumField);
		
		setupSecondRowPanel.add(onePlayerBtn);
		setupSecondRowPanel.add(twoPlayerBtn);
		
		setupThirdRowPanel.add(threePlayerBtn);
		setupThirdRowPanel.add(fourPlayerBtn);
		
		setupPanel.add(setupFirstRowPanel);
		setupPanel.add(setupSecondRowPanel);
		setupPanel.add(setupThirdRowPanel);
		setupPanel.add(confirmBtn);
		
		//Character Creation
		playerField.setEditable(false);
		firstRowPanel.add(playerField);
		
		nameField.setEditable(false);
		secondRowPanel.add(nameField);
		secondRowPanel.add(enterNameField);
		
		pointsField.setEditable(false);
		numPointsField.setEditable(false);
		thirdRowPanel.add(pointsField);
		thirdRowPanel.add(numPointsField);
		
		healthField.setEditable(false);
		numHealthField.setEditable(false);
		forthRowPanel.add(healthField);
		forthRowPanel.add(healthSubtractBtn);
		forthRowPanel.add(numHealthField);
		forthRowPanel.add(healthAddBtn);
		
		strengthField.setEditable(false);
		numStrengthField.setEditable(false);
		fifthRowPanel.add(strengthField);
		fifthRowPanel.add(strengthSubtractBtn);
		fifthRowPanel.add(numStrengthField);
		fifthRowPanel.add(strengthAddBtn);
		
		dexterityField.setEditable(false);
		numDexterityField.setEditable(false);
		sixthRowPanel.add(dexterityField);
		sixthRowPanel.add(dexteritySubtractBtn);
		sixthRowPanel.add(numDexterityField);
		sixthRowPanel.add(dexterityAddBtn);
		
		speedField.setEditable(false);
		numSpeedField.setEditable(false);
		seventhRowPanel.add(speedField);
		seventhRowPanel.add(speedSubtractBtn);
		seventhRowPanel.add(numSpeedField);
		seventhRowPanel.add(speedAddBtn);
		
		eighthRowPanel.add(defaultBtn);
		eighthRowPanel.add(resetBtn);
		
		ninthRowPanel.add(createCharacterBtn);
		
		charCreationPanel.add(firstRowPanel);
		charCreationPanel.add(secondRowPanel);
		charCreationPanel.add(thirdRowPanel);
		charCreationPanel.add(forthRowPanel);
		charCreationPanel.add(fifthRowPanel);
		charCreationPanel.add(sixthRowPanel);
		charCreationPanel.add(seventhRowPanel);
		charCreationPanel.add(eighthRowPanel);
		charCreationPanel.add(ninthRowPanel);
		
		//Gameboard
		createGameboard();
		
		gameNameTextField.setEditable(false);
		gameName.add(gameNameTextField);
		
		entireGameboardPanel.add(gameName, BorderLayout.NORTH);
		entireGameboardPanel.add(gameboard, BorderLayout.CENTER);
		entireGameboardPanel.add(characterInfo, BorderLayout.WEST);
		entireGameboardPanel.add(gameStatus, BorderLayout.EAST);
		entireGameboardPanel.add(gameplayText, BorderLayout.SOUTH);
		
	}

	public void addActionListeners() {
		//Game Setup
		onePlayerBtn.addActionListener(this);
		twoPlayerBtn.addActionListener(this);
		threePlayerBtn.addActionListener(this);
		fourPlayerBtn.addActionListener(this);
		confirmBtn.addActionListener(this);
		//Character Creation
		healthSubtractBtn.addActionListener(this);
		healthAddBtn.addActionListener(this);
		strengthSubtractBtn.addActionListener(this);
		strengthAddBtn.addActionListener(this);
		dexteritySubtractBtn.addActionListener(this);
		dexterityAddBtn.addActionListener(this);
		speedSubtractBtn.addActionListener(this);
		speedAddBtn.addActionListener(this);
		defaultBtn.addActionListener(this);
		resetBtn.addActionListener(this);
		createCharacterBtn.addActionListener(this);
	}

	public void createGameboard() {
		for (int i = 0; i < 29; i++) {
			for (int j = 0; j < 20; j++) {
				JPanel gameboardPnl = new JPanel();
				if(i % 2 == 0) {
					gameboardPnl.setBackground(Color.DARK_GRAY);
				}
				else {
					gameboardPnl.setBackground(Color.GREEN);
				}
				gameboard.add(gameboardPnl);
			}
		}
		for(int i = 0; i < 1; i++) {
			for (int j = 0; j < 20; j++) {
				JPanel gameboardPnl = new JPanel();
				gameboardPnl.setBackground(Color.BLACK);
				gameboard.add(gameboardPnl);
			}
		}
	}
	
	public void updateCharacterInfo(Characters character) {
		charInfo.setText("Player:" + character.getName());
		charStats.setText("HEALTH: "+ character.getHealth() +"\nSTRENGTH: "+ character.getStrength() +"\nDEXTERITY: "+ character.getDexterity() +"\nSPEED: "+ character.getSpeed() +"\n");
		charStatus.setText("Alive");
	
		charInfo.setEditable(false);
		charStats.setEditable(false);
		charStatus.setEditable(false);
		
		
		characterInfo.add(charInfo, BorderLayout.NORTH);
		characterInfo.add(charStats, BorderLayout.CENTER);
		characterInfo.add(charStatus, BorderLayout.SOUTH);
	}
	
	public int getNumPlayers() {
		return numPlayers;
	}

	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}
	
	public int getCharacterCount() {
		return characterCount;
	}

	public void setCharacterCount(int characterCount) {
		this.characterCount = characterCount;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String callingBtn = event.getActionCommand();
		Object src = event.getSource();
		int numPoints = Integer.parseInt(numPointsField.getText());
		int numHealth = Integer.parseInt(numHealthField.getText());
		int numStrength = Integer.parseInt(numStrengthField.getText());
		int numDexterity = Integer.parseInt(numDexterityField.getText());
		int numSpeed = Integer.parseInt(numSpeedField.getText());
		String name = enterNameField.getText();
		
		if (callingBtn.equals("1")) {
			playerNumField.setText("1");
		}
		else if (callingBtn.equals("2")) {
			playerNumField.setText("2");
		}
		else if (callingBtn.equals("3")) {
			playerNumField.setText("3");
		}
		else if (callingBtn.equals("4")) {
			playerNumField.setText("4");
		}
		else if (callingBtn.equals("CONFIRM")) {
			int numPlayersEntered = Integer.parseInt(playerNumField.getText());
			setNumPlayers(numPlayersEntered);
			super.setVisible(false);
			super.remove(setupPanel);
			
			super.setSize(300, 400);
			super.add(charCreationPanel);
			super.setVisible(true);
		}
		else if(src == healthSubtractBtn) {
			if (numPoints == 40 || numHealth == 40) {
				//do nothing
			}
			else {
				numPoints += 1;
				numPointsField.setText(numPoints + "");
				numHealth -= 1;
				numHealthField.setText(numHealth + "");
			}
		}
		else if(src == healthAddBtn) {
			if (numPoints == 0 || numHealth == 60) {
				//do nothing
			}
			else {
				numPoints -= 1;
				numPointsField.setText(numPoints + "");
				numHealth += 1;
				numHealthField.setText(numHealth + "");
			}
		}
		else if(src == strengthSubtractBtn) {	
			if (numPoints == 40 || numStrength == 20) {
				//do nothing
			}
			else {
				numPoints += 1;
				numPointsField.setText(numPoints + "");
				numStrength -= 1;
				numStrengthField.setText(numStrength + "");
			}
		}
		else if(src == strengthAddBtn) {
			if (numPoints == 0 || numStrength == 40) {
				//do nothing
			}
			else {
				numPoints -= 1;
				numPointsField.setText(numPoints + "");
				numStrength += 1;
				numStrengthField.setText(numStrength + "");
			}
		}
		else if(src == dexteritySubtractBtn) {
			if (numPoints == 40 || numDexterity == 20) {
				//do nothing
			}
			else {
				numPoints += 1;
				numPointsField.setText(numPoints + "");
				numDexterity -= 1;
				numDexterityField.setText(numDexterity + "");
			}
		}
		else if(src == dexterityAddBtn) {
			if (numPoints == 0 || numDexterity == 40) {
				//do nothing
			}
			else {
				numPoints -= 1;
				numPointsField.setText(numPoints + "");
				numDexterity += 1;
				numDexterityField.setText(numDexterity + "");
			}
		}
		else if(src == speedSubtractBtn) {
			if (numPoints == 40 || numSpeed == 20) {
				//do nothing
			}
			else {
				numPoints += 1;
				numPointsField.setText(numPoints + "");
				numSpeed -= 1;
				numSpeedField.setText(numSpeed + "");
			}
		}
		else if(src == speedAddBtn) {
			if (numPoints == 0 || numSpeed == 40) {
				//do nothing
			}
			else {
				numPoints -= 1;
				numPointsField.setText(numPoints + "");
				numSpeed += 1;
				numSpeedField.setText(numSpeed + "");
			}
		}
		else if(src == defaultBtn) {
			numPointsField.setText("0");
			numHealthField.setText("50");
			numStrengthField.setText("30");
			numDexterityField.setText("30");
			numSpeedField.setText("30");
		}
		else if(src == resetBtn) {
			numPointsField.setText("40");
			numHealthField.setText("40");
			numStrengthField.setText("20");
			numDexterityField.setText("20");
			numSpeedField.setText("20");
		}
		else if(src == createCharacterBtn) {
			if (name.length() < 4 || name.length() > 18 || numPoints != 0) {
				//do nothing
			}
			else {
				Random rand = new Random();
				int row = 1;
				int col = (4 * getCharacterCount()) - 4 + rand.nextInt(4);
				Characters newCharacter = new Characters(numHealth, numStrength, numDexterity, numSpeed, row, col, name);
				addCharacter(newCharacter);
				System.out.println("CHARACTER CREATED!");
				
				super.remove(charCreationPanel);
				super.setVisible(false);
				
				
				if(getCharacterCount() < getNumPlayers()) {
					super.setSize(300, 400);
					super.add(charCreationPanel);
					numPointsField.setText("40");
					numHealthField.setText("40");
					numStrengthField.setText("20");
					numDexterityField.setText("20");
					numSpeedField.setText("20");
					setCharacterCount(getCharacterCount() + 1);
					playerField.setText("Player " + getCharacterCount());
					
					super.setVisible(true);
				}
				else {
					super.setSize(1500, 1000);
					updateCharacterInfo(characters.get(0));
					super.add(entireGameboardPanel);
					super.setVisible(true);
				}
			}
		}
	}

	public void addCharacter(Characters character) {
		characters.add(character);
	}
	
	public ArrayList<Characters> getCharacters() {
		return characters;
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
		ProtectCloseGUI gui = new ProtectCloseGUI();
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
}

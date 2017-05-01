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
	private JButton defaultStatsBtn = new JButton("Default");
	private JButton resetStatsBtn = new JButton("Reset");
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
	public JPanel turnPanel = new JPanel(new BorderLayout());
	public JPanel characterInfo = new JPanel(new BorderLayout());
	public JPanel gameStatus = new JPanel();
	public JPanel gameplayText = new JPanel();
	
	public JTextField charInfo = new JTextField();
	public JTextField charStatus = new JTextField();
	public JTextField nextPlayerField = new JTextField("Next Player's Turn!");

	public JButton rollBtn = new JButton("Roll");
	
	public JTextArea gameNameTextField = new JTextArea("GOAL: Fight your way to the castle!\nThe castle is located at Row 40");
	public JTextArea charStats = new JTextArea();
	
	//=======================MOVE=====================================================================
	public JPanel movePanel = new JPanel(new GridLayout(6, 1));
	public JPanel firstMovePanel = new JPanel(new FlowLayout());
	public JPanel secondMovePanel = new JPanel(new FlowLayout());
	public JPanel thirdMovePanel = new JPanel(new FlowLayout());
	public JPanel forthMovePanel = new JPanel(new FlowLayout());
	public JPanel fifthMovePanel = new JPanel(new FlowLayout());
	public JPanel sixthMovePanel = new JPanel(new FlowLayout());
	
	public JTextField rolledTextField = new JTextField("You rolled: ");
	public JTextField rolledNumTextField = new JTextField("0");
	public JTextField moveDownTextField = new JTextField("Move down: ");
	public JTextField moveDownNumTextField = new JTextField("0");
	public JTextField moveRightTextField = new JTextField("Move right: ");
	public JTextField moveRightNumTextField = new JTextField("0");
	public JTextField moveLeftTextField = new JTextField("Move left: ");
	public JTextField moveLeftNumTextField = new JTextField("0");
	
	public JButton moveDownSubtractBtn = new JButton("-");
	public JButton moveDownAddBtn = new JButton("+");
	public JButton moveRightSubtractBtn = new JButton("-");
	public JButton moveRightAddBtn = new JButton("+");
	public JButton moveLeftSubtractBtn = new JButton("-");
	public JButton moveLeftAddBtn = new JButton("+");
	public JButton defaultMoveBtn = new JButton("Default");
	public JButton resetMoveBtn = new JButton("Reset");
	public JButton moveBtn = new JButton("Move");
	
	private Random rand = new Random();
	
	private int turn = 0;
	
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
		
		eighthRowPanel.add(defaultStatsBtn);
		eighthRowPanel.add(resetStatsBtn);
		
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
		
		gameNameTextField.setEditable(false);
		gameName.add(gameNameTextField);
		
		nextPlayerField.setEditable(false);
		
		turnPanel.setSize(500, 500);
		turnPanel.add(nextPlayerField, BorderLayout.NORTH);
		turnPanel.add(rollBtn, BorderLayout.CENTER);
		
		entireGameboardPanel.add(gameName, BorderLayout.NORTH);
		entireGameboardPanel.add(turnPanel, BorderLayout.CENTER);
		entireGameboardPanel.add(characterInfo, BorderLayout.WEST);
		entireGameboardPanel.add(gameStatus, BorderLayout.EAST);
		entireGameboardPanel.add(gameplayText, BorderLayout.SOUTH);
		
		//Turn movement
		rolledTextField.setEditable(false);
		rolledNumTextField.setEditable(false);
		firstMovePanel.add(rolledTextField);
		firstMovePanel.add(rolledNumTextField);
		
		moveDownTextField.setEditable(false);
		moveDownNumTextField.setEditable(false);
		secondMovePanel.add(moveDownTextField);
		secondMovePanel.add(moveDownSubtractBtn);
		secondMovePanel.add(moveDownNumTextField);
		secondMovePanel.add(moveDownAddBtn);
		
		moveRightTextField.setEditable(false);
		moveRightNumTextField.setEditable(false);
		thirdMovePanel.add(moveRightTextField);
		thirdMovePanel.add(moveRightSubtractBtn);
		thirdMovePanel.add(moveRightNumTextField);
		thirdMovePanel.add(moveRightAddBtn);
		
		moveLeftTextField.setEditable(false);
		moveLeftNumTextField.setEditable(false);
		forthMovePanel.add(moveLeftTextField);
		forthMovePanel.add(moveLeftSubtractBtn);
		forthMovePanel.add(moveLeftNumTextField);
		forthMovePanel.add(moveLeftAddBtn);
		
		fifthMovePanel.add(defaultMoveBtn);
		fifthMovePanel.add(resetMoveBtn);
		
		sixthMovePanel.add(moveBtn);
		
		movePanel.add(firstMovePanel);
		movePanel.add(secondMovePanel);
		movePanel.add(thirdMovePanel);
		movePanel.add(forthMovePanel);
		movePanel.add(fifthMovePanel);
		movePanel.add(sixthMovePanel);
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
		defaultStatsBtn.addActionListener(this);
		resetStatsBtn.addActionListener(this);
		createCharacterBtn.addActionListener(this);
		//TurnPanel
		rollBtn.addActionListener(this);
		moveDownSubtractBtn.addActionListener(this);
		moveDownAddBtn.addActionListener(this);
		moveRightSubtractBtn.addActionListener(this);
		moveRightAddBtn.addActionListener(this);
		moveLeftSubtractBtn.addActionListener(this);
		moveLeftAddBtn.addActionListener(this);
		defaultMoveBtn.addActionListener(this);
		resetMoveBtn.addActionListener(this);
		moveBtn.addActionListener(this);
	}
	
	public void updateCharacterInfo(Characters character) {
		charInfo.setText("PLAYER:" + character.getName());
		charStats.setText("HEALTH: "+ character.getHealth() +"\nSTRENGTH: "+ character.getStrength() +"\nDEXTERITY: "+ character.getDexterity() +"\nSPEED: "+ character.getSpeed() +"\nROW: " + character.getPositionRow() + "\nCOLUMN: " + character.getPositioncolumn());
		charStatus.setText("STATUS: ALIVE");
	
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
		int rolled = Integer.parseInt(rolledNumTextField.getText());
		int moveDown = Integer.parseInt(moveDownNumTextField.getText());
		int moveRight = Integer.parseInt(moveRightNumTextField.getText());
		int moveLeft = Integer.parseInt(moveLeftNumTextField.getText());
		int totalRoll = moveRight + moveLeft + moveDown + rolled;
		
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
		else if(src == defaultStatsBtn) {
			numPointsField.setText("0");
			numHealthField.setText("50");
			numStrengthField.setText("30");
			numDexterityField.setText("30");
			numSpeedField.setText("30");
		}
		else if(src == resetStatsBtn) {
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
				int row = 1;
				int col = (5 * getCharacterCount()) - 5 + rand.nextInt(5);
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
					super.setSize(1000, 800);
					updateCharacterInfo(characters.get(0));
					super.add(entireGameboardPanel);
					super.setVisible(true);
				}
			}
		}
		else if(callingBtn.equals("Roll")) {
			super.setVisible(false);
			entireGameboardPanel.remove(turnPanel);
			int roll = rand.nextInt(6) + 1;
			rolledNumTextField.setText(roll + "");
			entireGameboardPanel.add(movePanel, BorderLayout.CENTER);
			super.setVisible(true);
			System.out.println("Player has rolled");
		}
		else if(src == moveDownSubtractBtn) {
			if(moveDown == 0) {
				//do nothing
			}
			else {
				moveDown -= 1;
				moveDownNumTextField.setText(moveDown + "");
				rolled += 1;
				rolledNumTextField.setText(rolled + "");
			}
		}
		else if(src == moveDownAddBtn) {
			int currentRow = characters.get(turn % getNumPlayers()).getPositionRow();
			if(rolled == 0 || (currentRow + moveDown) > 40) {
				//do nothing
			}
			else {
				moveDown += 1;
				moveDownNumTextField.setText(moveDown + "");
				rolled -= 1;
				rolledNumTextField.setText(rolled + "");
			}
		}
		else if(src == moveRightSubtractBtn) {
			if(moveRight == 0) {
				//do nothing
			}
			else {
				moveRight -= 1;
				moveRightNumTextField.setText(moveRight + "");
				rolled += 1;
				rolledNumTextField.setText(rolled + "");
			}
		}
		else if(src == moveRightAddBtn) { 
			int currentCol = characters.get(turn % getNumPlayers()).getPositioncolumn();
			if(rolled == 0 || (currentCol + moveRight) > 18) {
				//do nothing
			}
			else {
				moveRight += 1;
				moveRightNumTextField.setText(moveRight + "");
				rolled -= 1;
				rolledNumTextField.setText(rolled + "");
			}
		}
		else if(src == moveLeftSubtractBtn) {
			if(moveLeft == 0) {
				//do nothing
			}
			else {
				moveLeft -= 1;
				moveLeftNumTextField.setText(moveLeft + "");
				rolled += 1;
				rolledNumTextField.setText(rolled + "");
			}
		}
		else if(src == moveLeftAddBtn) {
			int currentCol = characters.get(turn % getNumPlayers()).getPositioncolumn();
			if(rolled == 0 || (currentCol - moveLeft) < 1) {
				//do nothing
			}
			else {
				moveLeft += 1;
				moveLeftNumTextField.setText(moveLeft + "");
				rolled -= 1;
				rolledNumTextField.setText(rolled + "");
			}
		}
		else if(src == defaultMoveBtn) {
			moveDownNumTextField.setText(totalRoll + "");
			moveRightNumTextField.setText("0");
			moveLeftNumTextField.setText("0");
			rolledNumTextField.setText("0");
		}
		else if(src == resetMoveBtn) {
			rolledNumTextField.setText(totalRoll + "");
			moveDownNumTextField.setText("0");
			moveRightNumTextField.setText("0");
			moveLeftNumTextField.setText("0");
		}
		else if(src == moveBtn) {
			if(rolled == 0) {
				//character moves row, col
				characters.get(turn % getNumPlayers()).setPositionRow(characters.get(turn % getNumPlayers()).getPositionRow() + moveDown);
				characters.get(turn % getNumPlayers()).setPositioncolumn(characters.get(turn % getNumPlayers()).getPositioncolumn() + moveRight - moveLeft);
				System.out.println("Player has moved");
				
				//character has interaction
				Interaction gameplay = new Interaction();
				gameplay.startInteraction(characters.get(turn % getNumPlayers()), characters);
				//change center panel to interaction
				//while(nextPlayer) {continue
				//if hp == 0
					//!added to graveyard
					//add to graveyard
					//increment turn to skip over dead player's turn
				//always ends with a statement
				//the button on that statement will trigger the roll center panel and increment the turn w/ nextTurn();
				//updateCharacterInfo(characters.get(turn % getNumPlayers))
				//}
				//display end panel
			}
		}
	}

	public int getTurn() {
		return turn;
	}

	public void nextTurn() {
		this.turn += 1;
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
	
	public static void main(String[] args) {
		GameGUI playGame = new GameGUI("ADVENTURE GAME!");
		playGame.setVisible(true);
		
	}
}

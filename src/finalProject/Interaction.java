package finalProject;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/**
 * Katrina Brinatte
 * Final Project
 * Interaction Class
 * May 2, 2016
 */

/**
 * Interaction class engages the user in game play. It includes a battle class,
 * outpost class, and obstacle class.
 *
 */
public class Interaction extends JFrame implements ActionListener {
	// creates a String array list for holding the names of players of have died
	// in the game
	private String answer = null;
	private boolean questionReady = false;
	private Random rand = new Random();
	
	/**
	 * @return the questionReady
	 */
	public boolean isQuestionReady() {
		return questionReady;
	}

	/**
	 * @param questionReady
	 *            the questionReady to set
	 */
	public void setQuestionReady(boolean questionReady) {
		this.questionReady = questionReady;
	}

	// Brings in components for displaying in the game
	private JTextArea messageField = new JTextArea();
	private JButton yesBtn = new JButton("Yes");
	private JButton noBtn = new JButton("No");
	private JButton okBtn = new JButton("OK");
	private JPanel messagePanel = new JPanel(new FlowLayout());
	private JPanel inputPanel = new JPanel(new FlowLayout());
	private JPanel statementPanel = new JPanel(new GridLayout(2, 1));
	private JPanel mainPanel = new JPanel(new FlowLayout());
	


	private void addListners() {
		yesBtn.addActionListener(this);
		noBtn.addActionListener(this);
		okBtn.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		String callingBtn = e.getActionCommand();
		
		System.out.println(callingBtn);
		if (callingBtn.equals("OK")) {
			GameGUI game = new GameGUI("Gui");
			//	turns interaction panels off
			this.setVisible(false);
			game.setTurnFinished(true);
			//turns game gui panels back on
			game.setVisible(true);

		} else {
			this.setQuestionReady(true);
			this.setAnswer(callingBtn);

		}
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer
	 *            the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
	/**
	 * Constructor for initializing the Constructor class
	 */
	public Interaction() {
		super();
		addListners();
		this.setSize(600, 200);
		this.setTitle("Interaction Window");
		
	}

	private void statementPanel(String statement) {
		if (inputPanel != null) {
			inputPanel.removeAll();
		}
		if (messagePanel != null) {
			messagePanel.removeAll();
		}
		this.setQuestionReady(false);
		this.setAnswer(null);
		messageField.setText(statement);
		messagePanel.add(messageField);
		inputPanel.add(okBtn);
		statementPanel.add(messagePanel);
		statementPanel.add(inputPanel);
		mainPanel.add(statementPanel);
		buildPanel();
	}

	public void buildPanel() {
		messageField.setEditable(false);
		addListners();
		
		add(mainPanel);
		setVisible(true);
	}

	/*
	 * Battle() class. Takes in 2 Characters and the dice values to create
	 * combat between players that modifies the players position and health.
	 */
	public void Battle(Characters player, Characters opponent) {

		// variables to track and modify player attributes.
		int playerPosition = player.getPositionRow();
		int playerHealth = player.getHealth();
		setQuestionReady(false);

		// sets the outcome of the battle
		int result = ((player.getStrength() * (player.getDexterity() + player.getSpeed()))
				- (opponent.getStrength() * (opponent.getDexterity() + opponent.getSpeed())));		
		
		// variables for storing statement that will be displayed for the user.
		String statement = null;

			if (result == 0) {
				playerPosition -= 1;
				player.setPositionRow(playerPosition);
				statement = "You and " + opponent.getName() + " have tied, you have retreated one space.";
				statementPanel(statement);
			} else if (result > 0) {

				//	Adds health if the player won
					playerHealth = player.getHealth();
					playerHealth += rand.nextInt(5) + 1;
					player.setHealth(playerHealth);
					statement = "You have won against " + opponent.getName() +" this round and increased your health to " + player.getHealth();
					statementPanel(statement);

				} else {
					
					//	Subtracts health if you lost the battle
					playerHealth = player.getHealth();
					playerHealth -= rand.nextInt(5) + 1;
					player.setHealth(playerHealth);
					statement = "You have lost this round  " + opponent.getName() + " and decreased your health to " + player.getHealth();
					statementPanel(statement);
				}}

				
			


	/*
	 * Outpost() creates something for the user and returns a statement
	 * regarding how it impacts them.
	 */
	public String Outpost(Characters player) {

		/*
		 * Creates variables for storing the option that the user is presented
		 * with and the reward from the outpost they have encountered.
		 */
		int option = rand.nextInt(3);
		int reward = rand.nextInt(6);
		String object = null;
		String statement = null;
		answer = null;

		/*
		 * checks that reward is greater that 0, if it is then it will use the
		 * option to determine what the player has found. If it is not, the user
		 * has found and lost a rabbit.
		 */
		if (reward > 0) {

			/*
			 * uses even and odd results of the dice to determine whether the
			 * object found if a potion or magic stone.
			 */
			if (rand.nextBoolean()) {
				object = "a potion";
			} else {
				object = "a magical stone";
			}

			// option 0 increases the players health
			if (option == 0) {
				player.setHealth(player.getHealth() + reward);
				statement = "You have found " + object + " that increases your health by " + reward;
				// option 1 increases the players strength
			} else if (option == 1) {
				player.setStrength(player.getStrength() + reward);
				statement = "You have found " + object + " that increases your strength by " + reward;
				// the remaining option advances the players position.
			} else {
				player.setPositionRow(player.getPositionRow() + reward);
				statement = "You have found a portal that advances you " + reward + " places.";
			}
		} else {
			statement = "You found a rabbit, but you scared it and it has run away.";
		}

		/*
		 * writes the resulting statement to the console and returns the
		 * statement for the game.
		 */
		System.out.println(statement);
		statementPanel(statement);
		return statement;
	}

	public void Obstacle(Characters player) {

		String statement = null;
		answer = null;

		/*
		 * checks the results of the option calculation, then displays the
		 * result of the obstacle the player has encountered. the first obstacle
		 * is a poison arrow that subtracts health
		 */
		if (rand.nextBoolean()) {
			player.setHealth(player.getHealth() - 3);
			statement = "You have stepped on a poison arrow, you have lost 3 health points";
			statementPanel(statement);
			

			/*
			 * option 1 is a box that uses Outpost() to help determine the
			 * outcome.
			 */
		} else {
	
			statement = this.Outpost(player);
			statementPanel(statement);
			}

	}

	public void Castle(Characters player) {
		/*
		 * creates strings for holding the statement that will display for the
		 * player and the name of the loser
		 */
		GameGUI gameboard = new GameGUI("Castle");
		String statement = null;
		Characters loser = null;
		Characters opponent = gameboard.getWinner();
		int result = ((player.getStrength() * (player.getDexterity() + player.getSpeed()))
				- (opponent.getStrength() * (opponent.getDexterity() + opponent.getSpeed())));

		/*
		 * checks if there is a player that has arrived in the castle yet. If
		 * not, the current player is set as the winner.
		 */
		if (result > 0) {
			loser = opponent;
			gameboard.setWinner(player);
			statement = gameboard.getWinner().getName() + " has conqured the castle. " + loser
					+ " has gone to the graveyard.";
		} else {

			loser = player;
		}
		/*
		 * the loser is added to the graveyard and the result of the battle is
		 * added to the statement.
		 */

		if (loser != null) {
			statement = statement + loser.getName() + " has gone to the graveyard.";
		} 
		statementPanel(statement);

	}

	public void startInteraction(Characters player, ArrayList<Characters> playerList) {

		Monster monster = new Monster();

		// finds a random number for choosing what will occur in the game

		int option = rand.nextInt(3);
		
		//set to 0 to force the Obstacle option
		//	option = 2;

		// checks all of the players in the player list to see if the another
		// player

		// is in the same row. If there is someone in that spot the Battle
		// method starts. If not one of the other options is randomly selected.

		if (player.getPositionRow() > 39 ){
			this.Castle(player);
		} else {
		for (Characters character : playerList) {

			if (!character.getName().equals(player.getName())) {

				if (character.getPositionRow() == (player.getPositionRow())) {

					if (character.getPositioncolumn() == player.getPositioncolumn()) {

						this.Battle(player, character);
						//buildPanel();
						break;

					}

				}

			} else if (option == 0) {

				this.Obstacle(player);
				break;

			} else if (option == 1) {

				this.Outpost(player);
				break;

			} else {

				this.Battle(player, monster.randomMonster());
				break;

			}

		}
		}

	}

	public static void main(String[] args) {

		Monster monster = new Monster();
		Characters player1 = new Characters(50, 50, 10, 20, 40, 40, "John 1");
		Characters player2 = new Characters(50, 150, 10, 20, 1, 3, "John 2");
		Interaction gameplay = new Interaction();
		GameGUI game = new GameGUI("Gui");
		player2 = monster.randomMonster();

		// gameplay.Outpost(player1, 17);
		game.addCharacter(player1);
		gameplay.startInteraction(player1, game.getCharacters());
	}

}

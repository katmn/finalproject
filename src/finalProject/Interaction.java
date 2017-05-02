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
public class Interaction {
	// creates a String array list for holding the names of players of have died
	// in the game
	private String answer = null;
	private boolean questionReady = false;
	private Random rand = new Random();
	private String statement = "Hello World!";
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

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}
	
	/**
	 * Constructor for initializing the Constructor class
	 */
	public Interaction() {
		
	}


	/*
	 * Battle() class. Takes in 2 Characters and the dice values to create
	 * combat between players that modifies the players position and health.
	 */
	public void Battle(Characters player, Characters opponent) {

		// variables to track and modify player attributes.
		int playerPosition = player.getPositionRow();
		int playerHealth = player.getHealth();

		// sets the outcome of the battle
		int result = ((player.getStrength() * (player.getDexterity() + player.getSpeed()))
				- (opponent.getStrength() * (opponent.getDexterity() + opponent.getSpeed())));		
		
		// variables for storing statement that will be displayed for the user.
		if (result == 0) {
			playerPosition -= 1;
			player.setPositionRow(playerPosition);
			setStatement("You and " + opponent.getName() + " have tied, you have retreated one space.");
		} else if (result > 0) {
			//	Adds health if the player won
			playerHealth = player.getHealth();
			playerHealth += rand.nextInt(5) + 1;
			player.setHealth(playerHealth);
			setStatement("You have won against " + opponent.getName() +" this round and increased your health to " + player.getHealth());
		} else {		
			//	Subtracts health if you lost the battle
			playerHealth = player.getHealth();
			playerHealth -= rand.nextInt(5) + 1;
			player.setHealth(playerHealth);
			setStatement("You have lost this round  " + opponent.getName() + " and decreased your health to " + player.getHealth());
		}
		System.out.println(getStatement());
	}

	/*
	 * Outpost() creates something for the user and returns a statement
	 * regarding how it impacts them.
	 */
	public void Outpost(Characters player) {

		/*
		 * Creates variables for storing the option that the user is presented
		 * with and the reward from the outpost they have encountered.
		 */
		int option = rand.nextInt(3);
		int reward = rand.nextInt(6);
		String object = null;
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
				setStatement("You have found " + object + " that increases your health by " + reward);
				// option 1 increases the players strength
			} else if (option == 1) {
				player.setStrength(player.getStrength() + reward);
				setStatement("You have found " + object + " that increases your strength by " + reward);
				// the remaining option advances the players position.
			} else {
				player.setPositionRow(player.getPositionRow() + reward);
				setStatement("You have found a portal that advances you " + reward + " places.");
			}
		} else {
			setStatement(statement = "You found a rabbit, but you scared it and it has run away.");
		}

		/*
		 * writes the resulting statement to the console and returns the
		 * statement for the game.
		 */
		System.out.println(getStatement());
	}

	public void Obstacle(Characters player) {
		answer = null;

		/*
		 * checks the results of the option calculation, then displays the
		 * result of the obstacle the player has encountered. the first obstacle
		 * is a poison arrow that subtracts health
		 */
		if (rand.nextBoolean()) {
			player.setHealth(player.getHealth() - 3);
			setStatement("You have stepped on a poison arrow, you have lost 3 health points");
			/*
			 * option 1 is a box that uses Outpost() to help determine the
			 * outcome.
			 */
		} 
		else {
			this.Outpost(player);
		}
		System.out.println(getStatement());
	}

	public void Castle(Characters player) {
		/*
		 * creates strings for holding the statement that will display for the
		 * player and the name of the loser
		 */
		GameGUI gameboard = new GameGUI("Castle");
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
			setStatement(gameboard.getWinner().getName() + " has conqured the castle. " + loser
					+ " has gone to the graveyard.");
		} else {

			loser = player;
		}
		/*
		 * the loser is added to the graveyard and the result of the battle is
		 * added to the statement.
		 */

		if (loser != null) {
			setStatement(statement + loser.getName() + " has gone to the graveyard.");
		} 
	}

	public void startInteraction(Characters player, ArrayList<Characters> playerList) {

		Monster monster = new Monster();

		// finds a random number for choosing what will occur in the game

		int option = rand.nextInt(3);
		System.out.println("Option: " + option);
		//set to 0 to force the Obstacle option
		//	option = 2;

		// checks all of the players in the player list to see if the another
		// player

		// is in the same row. If there is someone in that spot the Battle
		// method starts. If not one of the other options is randomly selected.

		if (player.getPositionRow() > 39 ){
			this.Castle(player);
		} 
		else {
			for (Characters character : playerList) {
				if (!character.getName().equals(player.getName())) {
					if (character.getPositionRow() == (player.getPositionRow())) {
						if (character.getPositioncolumn() == player.getPositioncolumn()) {
							this.Battle(player, character);
							//buildPanel();
							break;
						}
					}
				} 
				else if (option == 0) {
					this.Obstacle(player);
					System.out.println("Running Obstacle");
					break;
				} 
				else if (option == 1) {
					this.Outpost(player);
					System.out.println("Running Outpost");
					break;
				} 
				else {
					this.Battle(player, monster.randomMonster());
					System.out.println("Running Battle");
					break;
				}
			}
		}
	}
}

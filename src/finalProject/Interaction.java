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
	private ArrayList<Characters> graveyard = new ArrayList<Characters>();
	private Characters winner = new Characters();
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
	private JPanel questionPanel = new JPanel(new GridLayout(2, 1));
	private JPanel statementPanel = new JPanel(new GridLayout(2, 1));
	private JPanel mainPanel = new JPanel(new FlowLayout());
	private JPanel graveyardPanel = new JPanel(new GridLayout(2, 2));

	private void addListners() {
		yesBtn.addActionListener(this);
		noBtn.addActionListener(this);
		okBtn.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		String callingBtn = e.getActionCommand();

		System.out.println(callingBtn);
		if (callingBtn.equals("OK")) {
			dispose();

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
	 * @return the graveyard
	 */
	public ArrayList<Characters> getGraveyard() {
		return graveyard;
	}

	/**
	 * @param graveyard
	 *            the graveyard to set
	 */
	public void setGraveyard(ArrayList<Characters> graveyard) {
		this.graveyard = graveyard;
	}

	/**
	 * @return the winner
	 */
	public Characters getWinner() {
		return winner;
	}

	/**
	 * @param winner
	 *            the winner to set
	 */
	public void setWinner(Characters winner) {
		this.winner = winner;
	}

	/**
	 * Constructor for initializing the Constructor class
	 */
	public Interaction() {
		addListners();
		ArrayList<String> graveyard = new ArrayList<String>();
		this.setSize(600, 200);
		this.setTitle("Interaction Window");
	}

	public String toString() {
		return "Interaction [graveyard=" + graveyard + ", winner=" + winner + "]";
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

	private void questionPanel(String question) {
		if (isQuestionReady()) {
			this.setQuestionReady(false);
		}
		if (getAnswer() != null) {
			this.setAnswer(null);
		}
		if (inputPanel != null) {
			inputPanel.removeAll();
		}
		messageField.setText(question);
		messagePanel.add(messageField);
		inputPanel.add(yesBtn);
		inputPanel.add(noBtn);
		questionPanel.add(messagePanel);
		questionPanel.add(inputPanel);
		mainPanel.add(questionPanel);
		buildPanel();

	}

	private void buildPanel() {
		messageField.setEditable(false);
		addListners();
		this.add(mainPanel);
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
		int healthPoints = (rand.nextInt(6) + 1);
		int dice = rand.nextInt(20);

		// sets the outcome of the battle
		int result = ((player.getStrength() * (player.getDexterity() + player.getSpeed()))
				- (opponent.getStrength() * (opponent.getDexterity() + opponent.getSpeed())));

		// sets how far the player will move in the game.
		int move = 0;

		// variables for storing data that will be displayed for the user.
		String question = null;
		answer = null;
		String statement = null;
		int mode = 0;

		// determines whether the dice is even or odd.
		mode = dice % 2;
		/*
		 * Uses the results of the mode setting to determine which question to
		 * ask the user.
		 */
		if (mode == 1) {
			question = "You have encountered " + opponent.getName() + " would you like to battle them?";
		} else {
			question = "You have been attacked by " + opponent.getName() + " would you like to battle them?";
		}

		while (!isQuestionReady()) {
			questionPanel(question);
		}

		if (answer.equals("No")) {
			/*
			 * If the player has passed the 4th row of the Kingdom, their new
			 * position will be randomly generated based upon the dice number
			 * plus the value of mode. If they are within the first 4 rows they
			 * will only retreat 1 space backwards.
			 */
			if (playerPosition > 5) {
				move = (((move * dice) % 3) + 1 + mode);
				playerPosition -= move;
				player.setPositionRow(playerPosition);
				statement = "You have retreated " + move + " spaces.";
				/*
				 * Prints the final statement after the while statement has
				 * completed.
				 */
				statementPanel(statement);
				System.out.println(statement);
			} else {
				move = 1;
				playerPosition -= move;
				player.setPositionRow(playerPosition);
				statement = "You have retreated " + move + " space.";
				/*
				 * Prints the final statement after the while statement has
				 * completed.
				 */
				statementPanel(statement);
				System.out.println(statement);
			}

		} else if (answer.equalsIgnoreCase("Yes")) {
			/*
			 * if the result of the battle is 0, indicating a tie and the player
			 * engaged the battle, they move backwards 1 space.
			 */
			if (result == 0 && mode == 1) {
				playerPosition -= 1;
				player.setPositionRow(playerPosition);
				statement = "You and " + opponent.getName() + " have tied, you have retreated one space.";
				/*
				 * Prints the final statement after the while statement has
				 * completed.
				 */
				statementPanel(statement);
				System.out.println(statement);
			}
			/*
			 * if the result of the battle is 0 for a tie and the player was
			 * attacked, they move forward 1 space.
			 */
			else if (result == 0 && mode == 0) {
				playerPosition += 1;
				player.setPositionRow(playerPosition);
				statement = "You and " + opponent.getName() + " have tied, you have advance one space.";
				/*
				 * Prints the final statement after the while statement has
				 * completed.
				 */
				statementPanel(statement);
				System.out.println(statement);
			}
			/*
			 * if the result is a positive number, the player one the battle and
			 * they advance a randomly determined number of spaces.
			 */
			else if (result > 0) {

				playerHealth = player.getHealth();
				playerHealth += healthPoints;
				player.setHealth(playerHealth);
				statement = "You have won this round and increased your health " + healthPoints + " points.";
				/*
				 * Prints the final statement after the while statement has
				 * completed.
				 */
				statementPanel(statement);
				System.out.println(statement);

			} else {
				playerHealth = player.getHealth();
				playerHealth -= healthPoints;
				player.setHealth(playerHealth);
				/*
				 * creates a statement for the change in the player's health. If
				 * their health is 0 or less then they are sent to the
				 * graveyard.
				 */ if (player.getHealth() < 1) {
					graveyard.add(player);
					player.setPositionRow(0);
					player.setPositionRow(0);
					statement = "You have lost the battle and entered the graveyard.";
				} else {
					statement = "You have lost this round and decreased your health " + healthPoints + " points.";
				}
				/*
				 * Prints the final statement after the while statement has
				 * completed.
				 */
				statementPanel(statement);
				System.out.println(statement);

			}
		}
	}

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
		int reward = rand.nextInt(5);
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
			 * randomly chooses whether the
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

		/*
		 * created variables for the player options, questions, answers, and
		 * statements.
		 */
		int option = rand.nextInt(3);
		String statement = null;
		String question = null;
		answer = null;

		/*
		 * checks the results of the option calculation, then displays the
		 * result of the obstacle the player has encountered. the first obstacle
		 * is a poison arrow that subtracts health
		 */
		if (option == 0) {
			player.setHealth(player.getHealth() - 3);
			statement = "You have stepped on a poison arrow, you have lost 3 health points";
			statementPanel(statement);

			/*
			 * option 1 is a box that uses Outpost() to help determine the
			 * outcome.
			 */
		} else if (option == 1) {
			setQuestionReady(false);
			while (!isQuestionReady()) {
				question = "You have found a mysterious box, would you like to open it?";
				questionPanel(question);
			}
			if (isQuestionReady() && getAnswer().equals("Yes")) {

				if (rand.nextBoolean()) {
					statement = this.Outpost(player);
					statementPanel(statement);
				} else {
					statement = "The box is empty";
					statementPanel(statement);
				}

			} else if (isQuestionReady() && getAnswer().equalsIgnoreCase("No")) {
				statement = "Then the box remains a mystery.";

			}

			/*
			 * option 2 is a witch with a potion, Outpost() is initialized if
			 * the dice is an even number, otherwise the potion is poisonous and
			 * the player loses health.
			 */else {
				setQuestionReady(false);

				while (!isQuestionReady()) {
					question = "You have encountered a witch, they offer a magic potion. Will you drink it?";
					questionPanel(question);
				}

				if (isQuestionReady() && answer.equalsIgnoreCase("Yes")) {
					if (rand.nextBoolean()) {
						statement = this.Outpost(player);
					} else {
						// player loses health from the poison
						player.setHealth(player.getHealth() - 3);
						// verifies if the player is still alive. If not, they
						// are sent to the graveyard.
						if (player.getHealth() < 1) {
							graveyard.add(player);
							player.setPositionRow(0);
							player.setPositionRow(0);
							statement = "The potion was poisonous and has killed you, you are now in the graveyard.";
						} else {
							statement = "The potion was poisonous and your health is now " + player.getHealth();
						}
					}
					// returns a statement if the player answers no
				} else if (answer.equalsIgnoreCase("no")) {
					statement = "Wise choice, she looked shifty";
				} else {
					statement = "I do not understand your answer.";
				}
				statementPanel(statement);
				// prints the result of the while statement.

			}
		}
	}

	public void Castle(Characters player) {
		/*
		 * creates strings for holding the statement that will display for the
		 * player and the name of the loser
		 */
		String statement = null;
		Characters loser = null;
		Characters opponent = this.getWinner();
		int result = ((player.getStrength() * (player.getDexterity() + player.getSpeed()))
				- (opponent.getStrength() * (opponent.getDexterity() + opponent.getSpeed())));

		/*
		 * checks if there is a player that has arrived in the castle yet. If
		 * not, the current player is set as the winner.
		 */
		if (result > 0) {
			loser = opponent;
			this.setWinner(player);
		} else {

			loser = player;
		}
		/*
		 * the loser is added to the graveyard and the result of the battle is
		 * added to the statement.
		 */
		graveyard.add(loser);

		if (loser != null) {
			statement = this.getWinner().getName() + " has conqured the castle. " + loser
					+ " has gone to the graveyard.";
		} else {
			statement = this.getWinner().getName() + " has conqured the castle.";
		}
		statementPanel(statement);

	}

	//	Starts an interaction for the player. Accepts the player list to see where the other players are in the game
	public void startInteraction(Characters player, ArrayList<Characters> playerList) {
		Monster monster = new Monster();
		//	finds a random number for choosing what will occur in the game
		int option = rand.nextInt(3);

		// checks all of the players in the player list to see if the  another player
		// is in the same row. If there is someone in that spot the Battle method starts. If not one of the other options is randomly selected.
		for (Characters character : playerList) {
			if (!character.getName().equals(player.getName())){
				if (character.getPositionRow() == (player.getPositionRow())) {
					if (character.getPositioncolumn() == player.getPositioncolumn()) {
						this.Battle(player, character);
						break;
					}
			}
			
			} else if (option == 0) {
				this.Obstacle(player);
				break;
			} else if (option == 1){
				this.Outpost(player);
				break;
			} else {
				this.Battle(player, monster.randomMonster());
				break;
			}
		}
	}

	public static void main(String[] args) {

		Random rand = new Random();
		ArrayList<Characters> playerList = new ArrayList<Characters>();
		Characters player1 = new Characters(rand.nextInt(50) + 20, rand.nextInt(20) + 20, rand.nextInt(20) + 20,
				rand.nextInt(20) + 20, 6, 6, "John 1");
		playerList.add(player1);
		Characters player2 = new Characters(rand.nextInt(50) + 20, rand.nextInt(20) + 20, rand.nextInt(20) + 20,
				rand.nextInt(20) + 20, rand.nextInt(17) + 1, rand.nextInt(29) + 1, "Mike 2");
		playerList.add(player2);
		Characters player3 = new Characters(rand.nextInt(50) + 20, rand.nextInt(20) + 20, rand.nextInt(20) + 20,
				rand.nextInt(20) + 20, 6, 6, "Sam 3");
		playerList.add(player3);
		Characters player4 = new Characters(0, 0, 0,
				0, 6, 6, "Chris 4");
		playerList.add(player4);
		
		Interaction gameplay = new Interaction();

		Winnerdisplay winnerWindow = new Winnerdisplay("Winner Display");
		
		gameplay.startInteraction(player4, playerList);
		//	winnerWindow.buildPanels();
		winnerWindow.setVisible(true);
	}

}

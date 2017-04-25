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
	private ArrayList<String> graveyard = new ArrayList<String>();
	private Characters winner = new Characters(0, 0, 0, 0, 0, 0, "Castle Master");
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
	public ArrayList<String> getGraveyard() {
		return graveyard;
	}

	/**
	 * @param graveyard
	 *            the graveyard to set
	 */
	public void setGraveyard(ArrayList<String> graveyard) {
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
		inputPanel.removeAll();
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
		this.setQuestionReady(false);
		this.setAnswer(null);
		inputPanel.removeAll();
		messageField.setText(question);
		messagePanel.add(messageField);
		inputPanel.add(yesBtn);
		inputPanel.add(noBtn);
		questionPanel.add(messageField);
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

	public void graveyardPanel() {

		if (graveyard.get(1) != null) {
			JLabel player1 = new JLabel(graveyard.get(1));
			graveyardPanel.add(player1);
			
		}
		if (graveyard.get(2) != null) {
			JLabel player2 = new JLabel(graveyard.get(2));
			graveyardPanel.add(player2);
		}
		if (graveyard.get(3) != null) {
			JLabel player3 = new JLabel(graveyard.get(3));
			graveyardPanel.add(player3);
		}
		if (graveyard.get(4) != null) {
			JLabel player4 = new JLabel(graveyard.get(4));
			graveyardPanel.add(player4);
		}
		this.add(graveyardPanel);
		setVisible(true);
	}

	/*
	 * Battle() class. Takes in 2 Characters and the dice values to create
	 * combat between players that modifies the players position and health.
	 */
	public void Battle(Characters player, Characters opponent, int dice) {
		
		// variables to track and modify player attributes.
		int playerPosition = player.getPositionRow();
		int playerHealth = player.getHealth();

		// sets the outcome of the battle
		int result = ((player.getStrength() * (player.getDexterity() + player.getSpeed())) - (opponent.getStrength() * (opponent.getDexterity() + opponent.getSpeed())));

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
			 * Uses the results of the mode setting to determine which question
			 * to ask the user.
			 */
			if (mode == 1) {
				question = "You have encountered " + opponent.getName() + " would you like to battle them?";
			} else {
				question = "You have been attacked by " + opponent.getName() + " would you like to battle them?";
			}
			
		while(!isQuestionReady()){
		questionPanel(question);}

			if (answer.equals("No")) {
				/*
				 * If the player has passed the 4th row of the Kingdom, their
				 * new position will be randomly generated based upon the dice
				 * number plus the value of mode. If they are within the first 4
				 * rows they will only retreat 1 space backwards.
				 */
				if (playerPosition > 5) {
					move = (((move * dice) % 3) + 1 + mode);
					playerPosition -= move;
					player.setPositionRow(playerPosition);
					statement = "You have retreated " + move + " spaces.";
				} else {
					move = 1;
					playerPosition -= move;
					player.setPositionRow(playerPosition);
					statement = "You have retreated " + move + " space.";
				}
				

			} else if (answer.equalsIgnoreCase("Yes")) {
				/*
				 * if the result of the battle is 0, indicating a tie and the
				 * player engaged the battle, they move backwards 1 space.
				 */
				if (result == 0 && mode == 1) {
					playerPosition -= 1;
					player.setPositionRow(playerPosition);
					statement = "You and " + opponent.getName() + " have tied, you have retreated one space.";
				}
				/*
				 * if the result of the battle is 0 for a tie and the player was
				 * attacked, they move forward 1 space.
				 */
				else if (result == 0 && mode == 0) {
					playerPosition += 1;
					player.setPositionRow(playerPosition);
					statement = "You and " + opponent.getName() + " have tied, you have advance one space.";
				}
				/*
				 * if the result is a positive number, the player one the battle
				 * and they advance a randomly determined number of spaces.
				 */
				else if (result > 0) {
					
					/*
					 * Checks if the results are less than -6 or greater than 6,
					 * if they are the modulus is subtracted from the player's
					 * health. If they are not then the results are subtracted
					 * from the players health.
					 */
					if ( result > 6) {
						playerHealth = player.getHealth();
						playerHealth += result % 5 + mode;
						player.setHealth(playerHealth);
						statement = "You have won this round and increased your health to " + player.getHealth();

					} else {
						playerHealth = player.getHealth();
						playerHealth += result;
						player.setHealth(playerHealth);
						statement = "You have won this round and increased your health to " + player.getHealth();
					}

				} else {
					if ( result < -6) {
						playerHealth = player.getHealth();
						playerHealth += result % 5;
						player.setHealth(playerHealth);
						
					} else {
						playerHealth = player.getHealth();
						playerHealth += result;
						player.setHealth(playerHealth);
					}
					/*
					 * creates a statement for the change in the player's
					 * health. If their health is 0 or less then they are sent
					 * to the graveyard.
					 */ if (playerHealth < 1) {
						graveyard.add(player.getName());
						player.setPositionRow(0);
						player.setPositionRow(0);
						statement = "You have lost the battle and entered the graveyard.";
					} else {
						statement = "You have lost this round and decreased your health to " + player.getHealth();

					} 
				}
			} 
			
		
		/*
		 * Prints the final statement after the while statement has completed.
		 */
		statementPanel(statement);
		System.out.println(statement);
	}

	/*
	 * Outpost() creates something for the user and returns a statement
	 * regarding how it impacts them.
	 */
	public String Outpost(Characters player, int dice) {

		/*
		 * Creates variables for storing the option that the user is presented
		 * with and the reward from the outpost they have encountered.
		 */
		int option = 0;
		int reward = 0;
		String object = null;
		String statement = null;
		answer = null;

		/*
		 * if the dice is over the number 4, the reward is set to the modulus of
		 * the dice divided by 4, so that the reward results are limited to 0,
		 * 1, 2, 3, and 4.
		 */
		if (dice > 5) {
			reward = dice % 5;
		} else {
			reward = dice;
		}

		/*
		 * if the dice is over the number 3, the option is set to the modulus of
		 * the dice divided by 3, so that the option results are limited to 0,
		 * 1, and 2.
		 */
		if (dice > 3) {
			option = dice % 3;
		} else {
			option = dice;
		}

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
			if (dice % 2 == 0) {
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

	public void Obstacle(Characters player, int dice) {

		/*
		 * created variables for the player options, questions, answers, and
		 * statements.
		 */
		int option = 0;
		String statement = null;
		String question = null;
		answer = null;

		if (dice < 3) {
			option = dice;
		} else {
			option = dice % 3;
		}
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

				if ((dice * player.getPositioncolumn()) % 2 == 0) {
					statement = this.Outpost(player, dice);
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
					if (((dice * player.getHealth()) % 2) == 0) {
						statement = this.Outpost(player, dice);
					} else {
						// player loses health from the poison
						player.setHealth(player.getHealth() - 3);
						// verifies if the player is still alive. If not, they
						// are sent to the graveyard.
						if (player.getHealth() < 1) {
							graveyard.add(player.getName());
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
		String loser = null;
		Characters opponent = this.getWinner();
		int result = ((player.getStrength() * (player.getDexterity() + player.getSpeed())) - (opponent.getStrength() * (opponent.getDexterity() + opponent.getSpeed())));

		/*
		 * checks if there is a player that has arrived in the castle yet. If
		 * not, the current player is set as the winner.
		 */
		if (result > 0) {
			loser = opponent.getName();
			this.setWinner(player);
		} else {
			
				loser = player.getName();
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

	public static void main(String[] args) {

		Characters player1 = new Characters(50, 148, 10, 20, 10, 10, "John 1");
		Characters player2 = new Characters(50, 150, 10, 20, 1, 3, "John 2");
		Interaction gameplay = new Interaction();

		gameplay.Castle(player2);
		//	gameplay.Outpost(player1, 17);
		gameplay.Battle(player2, player1, 15);
	}

}

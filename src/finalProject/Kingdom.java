package finalProject;

import java.util.ArrayList;

public class Kingdom  {
	private int numPlayers = 0;
	private int dice;
	private int diceRange;
	private int positionRow;
	private int positionCol;
	
	private ArrayList<Characters> characters = new ArrayList<Characters>();
	
	public int getNumPlayers() {
		return numPlayers;
	}
	public void setNumPlayers(int newNumPlayers) {
		this.numPlayers = newNumPlayers;
	}
	public int getDice() {
		return dice;
	}
	public void setDice(int newDice) {
		this.dice = newDice;
	}
	
	public int getDiceRange() {
		return diceRange;
	}
	public void setDiceRange(int newDiceRange) {
		this.diceRange = newDiceRange;
	}
	public int randomDice(int newDiceRange) {
		int randomDice = 1;
		//math for randomDice
		return randomDice;
	}
	public int getPositionRow() {
		return positionRow;
	}
	public void setPositionRow(int newRow) {
		this.positionRow = newRow;
	}
	public int getPositionCol() {
		return positionCol;
	}
	public void setPositionCol(int newCol) {
		this.positionCol = newCol;
	}
	
	public void setCharacters(ArrayList<Characters> characters) {
		this.characters = characters;
	}
	
	public void addCharacters(Characters characters) {
		this.characters.add(characters);
	}
	
	
	public static void main(String[] args)	{
		Kingdom playGame = new Kingdom();
		//create an instance of the gameboard
		GameGUI game = new GameGUI("ADVENTURE GAME");
		//open game
		//upon opening, create a pop up to enter the number of players
		//create characters
		game.setVisible(true);
		//MAIN loop
		
		
		//while(winner != null) {
		//WHERE CAN I GET WINNER FROM?
		
		//iterate through a "turn" loops
		//display updated info and gameboard to simulate a turn
		
			//check player status
				//if anyone is dead, add to graveyard
				//if 1 person remains, they win
			//give each alive player a turn
				//"[NAME] is about to start their turn" pop up
				//change character information
				//roll dice
				//move
				//handle interaction
				//next player
		
			
		//close gameboard
		
		//display stats
			//winner
			//number of turns the game lasted
			//all dead characters "ending" statistics
	}
}

package finalProject;

public class Kingdom {
	private int dice;
	private int diceRange;
	private int positionRow;
	private int positionCol;
	
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
	
	
	public static void main(String[] args)	{
		//create an instance of the gameboard
		GameboardGUI playGame = new GameboardGUI("Adventure Game");
		//open game
		playGame.setVisible(true);
		//upon opening, create a pop up to enter the number of players
		//return numPlayers
		
		//create characters
		
		//spawn in ALL characters
		 
		
		
		//MAIN loop
		
		
		//iterate through a "turn" loops
			//check player status
				//if anyone is dead, add to graveyard
				//if 1 person remains, they win
			//give each player a turn
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

package finalProject;

/** Final - group project
 * Characters class - Created by Kalavathi on 4/22/2017.
 * Characters class is used to determining and saving character attibutes.
 * Characters will include the players along with other humans or creatures to interact
 * with players.
 */

public class Characters implements Comparable {
    private int health;
    private int strength;
    private int dexterity;
    private int speed;
    private int positionRow;
    private int positioncolumn;
    private String name;
    

    public Characters() {
		super();
		// TODO Auto-generated constructor stub
	}


	public  Characters(int health, int strength, int dexterity, int speed, int positionRow, int positioncolumn, String name){
        this.health = health;
        this.strength = strength;
        this.dexterity = dexterity;
        this.speed = speed;
        this.positionRow = positionRow;
        this.positioncolumn = positioncolumn;
        this.name = name;

    }//Charactor


	//set up getters for charactors
    public int getHealth() {
        return health;
    }
    public int getStrength(){
        return strength;
    }
    public int getDexterity(){
        return dexterity;
    }
    public int getSpeed(){
        return speed;
    }
    public int getPositionRow(){
        return positionRow;
    }
    public int getPositioncolumn(){
        return positioncolumn;
    }
    public String getName(){
        return name;
    }
    public void setHealth(int newHealth){
        this.health = newHealth;
    }
    public void setStrength(int newStrength){
        this.strength = newStrength;
    }
    public void setDexterity(int newDexterity) {
        this.dexterity = newDexterity;
    }
    public void setSpeed(int newSpeed) {
        this.speed = newSpeed;
    }
    public void setPositionRow(int newPositionRow){
        this.positionRow = newPositionRow;
    }
    public void setPositioncolumn(int newPositioncolumn){
        this.positioncolumn = newPositioncolumn;
    }
    public  String toSring(){
        return "Health: " + health + "Strength: " + strength + "Dexterity: " + dexterity + "Speed" +
                 "Position Row: " +  "Position Column: " + positioncolumn + "Charactor Name: " + name;
    }//method toString

    public  int compareTo(Object arg0) {
        if (strength == ((Characters) arg0).getStrength()){
            return 0;
        } else if (strength > ((Characters) arg0).getStrength()){
            return 1;
        } else return -1;

//        if (health == ((Characters) arg0).getHealth()){
//            return 0;
//        } else if (health > ((Characters) arg0).getHealth()){
//            return 1;
//        } else return -1;

    }
}//Charactor class

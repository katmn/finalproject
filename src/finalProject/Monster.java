package finalProject;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Kalavathi on 4/22/2017.
 */
public class Monster {
	private int count = 0;
	private ArrayList<Characters> monsterChar = new ArrayList<>();
	private Random rand = new Random();

	public Monster() {
		// super();
		ArrayList<Characters> monsterChar = new ArrayList<>();
		this.buildMonster(monsterChar);
	}

	// get monster
	public ArrayList<Characters> getMonster() {

		return monsterChar;
	}

	// set monster
	public void setMonster() {

		this.monsterChar = monsterChar;
	}

	public void buildMonster(ArrayList<Characters> monsterList) {
		String charOfMonsters;
		String name;
		int health;
		int strength;
		int dexterity;
		int speed;
		int positionRow;
		int positionColumn;

		// create monster Dragon
		name = "Dragon1";
		health = rand.nextInt(50) + 20;
		strength = rand.nextInt(20) + 20;
		dexterity = rand.nextInt(20) + 20;
		speed = rand.nextInt(20) + 20;
		positionRow = 7;
		positionColumn = 1;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));
		name = "Dragon2";
		health = rand.nextInt(50) + 20;
		strength = rand.nextInt(20) + 20;
		dexterity = rand.nextInt(20) + 20;
		speed = rand.nextInt(20) + 20;
		positionRow = 22;
		positionColumn = 13;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));
		name = "Dragon3";
		health = rand.nextInt(50) + 20;
		strength = rand.nextInt(20) + 20;
		dexterity = rand.nextInt(20) + 20;
		speed = rand.nextInt(20) + 20;
		positionRow = 12;
		positionColumn = 40;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));

		// monster snacks
		name = "Snake1";
		health = rand.nextInt(50) + 20;
		strength = rand.nextInt(20) + 20;
		dexterity = rand.nextInt(20) + 20;
		speed = rand.nextInt(20) + 20;
		positionRow = 15;
		positionColumn = 80;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));
		name = "Snake2";
		health = rand.nextInt(50) + 20;
		strength = rand.nextInt(20) + 20;
		dexterity = rand.nextInt(20) + 20;
		speed = rand.nextInt(20) + 20;
		positionRow = 40;
		positionColumn = 35;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));
		name = "Snake3";
		health = rand.nextInt(50) + 20;
		strength = rand.nextInt(20) + 20;
		dexterity = rand.nextInt(20) + 20;
		speed = rand.nextInt(20) + 20;
		positionRow = 50;
		positionColumn = 27;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));

		// monster Goblin
		name = "Goblin1";
		health = rand.nextInt(50) + 20;
		strength = rand.nextInt(20) + 20;
		dexterity = rand.nextInt(20) + 20;
		speed = rand.nextInt(20) + 20;
		positionRow = 8;
		positionColumn = 30;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));
		name = "Goblin2";
		health = rand.nextInt(50) + 20;
		strength = rand.nextInt(20) + 20;
		dexterity = rand.nextInt(20) + 20;
		speed = rand.nextInt(20) + 20;
		positionRow = 47;
		positionColumn = 9;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));
		name = "Goblin3";
		health = rand.nextInt(50) + 20;
		strength = rand.nextInt(20) + 20;
		dexterity = rand.nextInt(20) + 20;
		speed = rand.nextInt(20) + 20;
		positionRow = 17;
		positionColumn = 55;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));

		// create monster Toll
		name = "Troll1";
		health = rand.nextInt(50) + 20;
		strength = rand.nextInt(20) + 20;
		dexterity = rand.nextInt(20) + 20;
		speed = rand.nextInt(20) + 20;
		positionRow = 62;
		positionColumn = 90;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));
		name = "Troll2";
		health = rand.nextInt(50) + 20;
		strength = rand.nextInt(20) + 20;
		dexterity = rand.nextInt(20) + 20;
		speed = rand.nextInt(20) + 20;
		positionRow = 29;
		positionColumn = 36;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));
		name = "Troll3";
		health = rand.nextInt(50) + 20;
		strength = rand.nextInt(20) + 20;
		dexterity = rand.nextInt(20) + 20;
		speed = rand.nextInt(20) + 20;
		positionRow = 28;
		positionColumn = 75;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));
		// create monster Dragon
		name = "Ghost1";
		health = rand.nextInt(50) + 20;
		strength = rand.nextInt(20) + 20;
		dexterity = rand.nextInt(20) + 20;
		speed = rand.nextInt(20) + 20;
		positionRow = 80;
		positionColumn = 10;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));
		name = "Ghost2";
		health = rand.nextInt(50) + 20;
		strength = rand.nextInt(20) + 20;
		dexterity = rand.nextInt(20) + 20;
		speed = rand.nextInt(20) + 20;
		positionRow = 60;
		positionColumn = 30;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));
		name = "Ghost3";
		health = rand.nextInt(50) + 20;
		strength = rand.nextInt(20) + 20;
		dexterity = rand.nextInt(20) + 20;
		speed = rand.nextInt(20) + 20;
		positionRow = 51;
		positionColumn = 100;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));

	}// create monster

	public Characters randomMonster() {
		this.buildMonster(monsterChar);
		int r = rand.nextInt(this.monsterChar.size());
		return monsterChar.get(r);

	}

}// Monster class
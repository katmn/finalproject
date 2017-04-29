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
		health = rand.nextInt(50) + 10;
		strength = rand.nextInt(20) + 10;
		dexterity = rand.nextInt(20) + 10;
		speed = rand.nextInt(20) + 10;
		positionRow = 6;
		positionColumn = 6;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));
		name = "Dragon2";
		health = rand.nextInt(50) + 15;
		strength = rand.nextInt(20) + 15;
		dexterity = rand.nextInt(20) + 15;
		speed = rand.nextInt(20) + 15;
		positionRow = 12;
		positionColumn = rand.nextInt(29) + 1;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));
		name = "Dragon3";
		health = rand.nextInt(50) + 20;
		strength = rand.nextInt(20) + 20;
		dexterity = rand.nextInt(20) + 20;
		speed = rand.nextInt(20) + 20;
		positionRow = 18;
		positionColumn = rand.nextInt(29) + 1;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));

		// monster snacks
		name = "Snake1";
		health = rand.nextInt(50) + 10;
		strength = rand.nextInt(20) + 10;
		dexterity = rand.nextInt(20) + 10;
		speed = rand.nextInt(20) + 10;
		positionRow = 3;
		positionColumn = rand.nextInt(29) + 1;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));
		name = "Snake2";
		health = rand.nextInt(50) + 15;
		strength = rand.nextInt(20) + 15;
		dexterity = rand.nextInt(20) + 15;
		speed = rand.nextInt(20) + 15;
		positionRow = 9;
		positionColumn = rand.nextInt(29) + 1;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));
		name = "Snake3";
		health = rand.nextInt(50) + 20;
		strength = rand.nextInt(20) + 20;
		dexterity = rand.nextInt(20) + 20;
		speed = rand.nextInt(20) + 20;
		positionRow = 15;
		positionColumn = rand.nextInt(29) + 1;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));

		// monster Goblin
		name = "Goblin1";
		health = rand.nextInt(50) + 10;
		strength = rand.nextInt(20) + 10;
		dexterity = rand.nextInt(20) + 10;
		speed = rand.nextInt(20) + 10;
		positionRow = 4;
		positionColumn = rand.nextInt(29) + 1;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));
		name = "Goblin2";
		health = rand.nextInt(50) + 15;
		strength = rand.nextInt(20) + 15;
		dexterity = rand.nextInt(20) + 15;
		speed = rand.nextInt(20) + 15;
		positionRow = 10;
		positionColumn = rand.nextInt(29) + 1;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));
		name = "Goblin3";
		health = rand.nextInt(50) + 20;
		strength = rand.nextInt(20) + 20;
		dexterity = rand.nextInt(20) + 20;
		speed = rand.nextInt(20) + 20;
		positionRow = 16;
		positionColumn = rand.nextInt(29) + 1;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));

		// create monster Toll
		name = "Troll1";
		health = rand.nextInt(50) + 10;
		strength = rand.nextInt(20) + 10;
		dexterity = rand.nextInt(20) + 10;
		speed = rand.nextInt(20) + 10;
		positionRow = 5;
		positionColumn = rand.nextInt(29) + 1;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));
		name = "Troll2";
		health = rand.nextInt(50) + 15;
		strength = rand.nextInt(20) + 15;
		dexterity = rand.nextInt(20) + 15;
		speed = rand.nextInt(20) + 15;
		positionRow = 11;
		positionColumn = rand.nextInt(29) + 1;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));
		name = "Troll3";
		health = rand.nextInt(50) + 20;
		strength = rand.nextInt(20) + 20;
		dexterity = rand.nextInt(20) + 20;
		speed = rand.nextInt(20) + 20;
		positionRow = 17;
		positionColumn = rand.nextInt(29) + 1;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));
		// create monster Dragon
		name = "Ghost1";
		health = rand.nextInt(50) + 10;
		strength = rand.nextInt(20) + 10;
		dexterity = rand.nextInt(20) + 10;
		speed = rand.nextInt(20) + 10;
		positionRow = 2;
		positionColumn = rand.nextInt(29) + 1;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));
		name = "Ghost2";
		health = rand.nextInt(50) + 15;
		strength = rand.nextInt(20) + 15;
		dexterity = rand.nextInt(20) + 15;
		speed = rand.nextInt(20) + 15;
		positionRow = 8;
		positionColumn = rand.nextInt(29) + 1;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));
		name = "Ghost3";
		health = rand.nextInt(50) + 20;
		strength = rand.nextInt(20) + 20;
		dexterity = rand.nextInt(20) + 20;
		speed = rand.nextInt(20) + 20;
		positionRow = 14;
		positionColumn = rand.nextInt(29) + 1;
		monsterList.add(new Characters(health, strength, dexterity, speed, positionRow, positionColumn, name));

	}// create monster

	public Characters randomMonster() {
		this.buildMonster(monsterChar);
		int r = rand.nextInt(this.monsterChar.size());
		return monsterChar.get(r);

	}

}// Monster class
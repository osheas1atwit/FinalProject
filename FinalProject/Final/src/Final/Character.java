package Final;

import java.util.ArrayList;
import java.util.List;

public class Character {
	protected int health;
	protected int shield;
	protected int strength;
	protected int vulnerable;
	protected int weak;
	protected int mana;
	protected int damageout;
	public List<String> cards = new ArrayList();
	
	public Character() {
		health = 20;
		damageout = 0;
		shield = 0;
		strength = 0;
		vulnerable = 0;
		weak = 0;
		mana = 6;
	}
	
	public void StartCharacter() {
		valuesSet();
		deckbuild();
	}
	
	public String[] deck;
	public String[] deckbuild() {
		deck[0] = "Strike";
		deck[1] = "Defend";
		deck[2] = "Bash";
		deck[3] = "Anger";
		deck[4] = "Body_Slam";
		deck[5] = "Cleave";
		deck[6] = "Clothesline";
		deck[7] = "Iron Wave";
		deck[8] = "Pommel_Strike";
		deck[9] = "Thunderclap";
		deck[10] = "Twin_Strike";
		deck[11] = "Dropkick";
		deck[12] = "Hemokinesis";
		deck[13] = "Searing Blow";
		deck[14] = "Uppercut";
		deck[15] = "Bludgeon";
		deck[16] = "Feed";
		deck[17] = "Reaper";
		deck[18] = "Flex";
		deck[19] = "Shrug_It_Off";
		deck[20] = "Flame_Barrier";
		deck[21] = "Seeing_Red";
		deck[22] = "Sentinel";
		return deck;
	}
	
	private int[] values = new int[6];
	private void valuesSet() {
	values[0] = 0;
	values[1] = 0;
	values[2] = 0;
	values[3] = 0;
	values[4] = 0;
	values[5] = 0;
	values[6] = 0;
	/*
	 * guide to the values*
	 * values[0] = card type (attack, skills, power)
	 * values[1] = damage
	 * values[2] = shield
	 * values[3] = strength
	 * values[4] = vulnerable
	 * values[5] = weak
	 * values[6] = mana
	 */
	}
	
	protected List<String> start() {
		cards.add(deck[0]);
		cards.add(deck[0]);
		cards.add(deck[0]);
		cards.add(deck[0]);
		cards.add(deck[0]);
		cards.add(deck[1]);
		cards.add(deck[1]);
		cards.add(deck[1]);
		cards.add(deck[1]);
		cards.add(deck[2]);
		return cards;
	}	
	
	public int[] Values(String name) {
		if(name == "Strike") {
			values[0] = 1;
			values[1] = 6;
			values[6] = 1;
			return values;
		}
		if(name == "Defend") {
			values[0] = 2;
			values[2] = 5;
			values[6] = 1;
			return values;
		}
		if(name == "Bash") {
			values[0] = 1;
			values[1] = 8;
			values[4] = 2;
			values[6] = 2;
			return values;
		}
		if(name == "Anger") {
			values[0] = 1;
			values[1] = 6;
			values[6] = 0;
			return values;
		}
		if(name == "Body_Slam") {
			values[0] = 1;
			values[6] = 1;
			return values;
		}
		if(name == "Cleave") {
			values[0] = 1;
			values[1] = 8;
			values[6] = 1;
			return values;
		}
		if(name == "Clothesline") {
			values[0] = 1;
			values[1] = 12;
			values[5] = 2;
			values[6] = 2;
			return values;
		}
		if(name == "Iron_Wave") {
			values[0] = 1;
			values[1] = 5;
			values[2] = 5;
			values[6] = 1;
			return values;
		}
		if(name == "Pommel_Strike") {
			values[0] = 1;
			values[1] = 9;
			values[6] = 1;
			//draw 1 card
			return values;
		}
		if(name == "Thunderclap") {
			values[0] = 1;
			values[1] = 4;
			values[4] = 1;
			values[6] = 1;
			return values;
		}
		if(name == "Twin_Strike") {
			values[0] = 1;
			values[1] = 5;
			values[6] = 1;
			return values;
		}
		if(name == "Dropkick") {
			values[0] = 1;
			values[1] = 5;
			values[6] = 1;
			return values;
		}
		if(name == "Hemokinesis") {
			values[0] = 1;
			values[1] = 14;
			values[6] = 1;
			return values;
		}
		if(name == "Searing_Blow") {
			values[0] = 1;
			values[1] = 12;
			values[6] = 2;
			return values;
		}
		if(name == "Uppercut") {
			values[0] = 1;
			values[1] = 13;
			values[4] = 1;
			values[5] = 1;
			values[6] = 2;
			return values;
		}
		if(name == "Bludgeon") {
			values[0] = 1;
			values[1] = 32;
			values[6] = 3;
			return values;
		}
		if(name == "Feed") {
			values[0] = 1;
			values[1] = 10;
			values[6] = 1;
			return values;
		}
		if(name == "Reaper") {
			values[0] = 1;
			values[1] = 4;
			values[6] = 2;
			return values;
		}
		/*
		 * 
		 * End of attack cards
		 * 
		 */
		if(name == "Flex") {
			values[0] = 2;
			values[3] = 2;
			values[6] = 0;
			return values;
			
		}
		if(name == "Shrug_It_Off") {
			values[0] = 2;
			values[2] = 8;
			values[6] = 1;
			return values;
		}
		if(name == "Flame_Barrier") {
			values[0] = 2;
			values[2] = 12;
			values[6] = 2;
			return values;
		}
		if(name == "Seeing_Red") {
			values[0] = 2;
			values[6] = -2;
			return values;
		}
		if(name == "Sentinel") {
			values[0] = 2;
			values[2] = 5;
			values[6] = 1;
			return values;
		}
		/*
		 * 
		 * end of skill cards
		 * 
		 */
		return values;
	}
}
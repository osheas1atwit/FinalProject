package Final;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Battle extends Enemies{
	private List<String> deck = new ArrayList();
	private List<String> hand = new ArrayList();
	private List<String> discard = new ArrayList();
	private List<String> draw = new ArrayList<>();
	private List<String> selectcard = new ArrayList<>();
	private Character player = new Character();
	private String[] enemies;
	private int[] enemynumbers;
	private Object[] enemiesinbattle;
	Enemies first;
	Enemies second;
	Enemies third;
	protected int stage = 1;
	
	public void GameStart() { //start of run
		draw = start();
	}
	
	public void EnemyDecide() { //called at the start of the encounter
		enemies = encounters(stage);
		StartEnemies();
		for(int i = 0; i < enemies.length; i++) {
			if(enemies[i] != null) {
				enemynumbers[i] = SetEnemyHealth(enemies[i]);
			}
		}
		SetEnemyValues(enemies);
	}
	
	public void SetEnemyValues(String[] enemies) { //sets all starting enemy values
		int counter = 0;
		if(enemies.length == 1) {
			first = new Enemies();
			enemiesinbattle[0] = first;
			first.health = enemynumbers[0];
		}
		if(enemies.length == 2) {
			first = new Enemies();
			second = new Enemies();
			enemiesinbattle[0] = first;
			enemiesinbattle[1] = second;
			first.health = enemynumbers[0];
			second.health = enemynumbers[1];
		}
		if(enemies.length == 3) {
			first = new Enemies();
			second = new Enemies();
			third = new Enemies();
			enemiesinbattle[0] = first;
			enemiesinbattle[1] = second;
			enemiesinbattle[2] = third;
			first.health = enemynumbers[0];
			second.health = enemynumbers[1];
			third.health = enemynumbers[2];
		}
	}
	
	public void Hand() { //creates a hand at the start of a turn
		for(int i = 0; i < 6; i++) {
			if(draw.size() == 0) {
				Reset();
			}
			int randomIndex = (int) (Math.random() * hand.size());
			 hand.add(draw.get( randomIndex ));
			 draw.remove(randomIndex);
		}
	}
	
	public void Remove(int index) { //called at the end of SinglePlay
		discard.add(hand.get(index));
		hand.remove(index);
	}
	
	public void RemoveAll(int length) { //activates when end turn button is pressed
		for(int i = 0; i < length; i++) {
			discard.add(hand.get(i));
			hand.remove(i);
		}
	}
	
	public void Reset() { //start of turn if not enough cards in draw
		draw = discard;
		discard.clear();
	}
	
	public void ResetDeck() { //at the end of battle
		for(int i = 0; i < hand.size(); i ++) {
			draw.add(hand.get(i));
			hand.remove(i);
		}
		for(int i = 0; i < discard.size(); i++) {
			draw.add(discard.get(i));
			discard.remove(i);
		}
		StageIncrease();
	}
	
	public boolean TestMana(String name) { //on button press before SinglePlay
		int[] stats = Values(name);
		if(player.mana > stats[6]) {
			return true;
		}
		return false;
	}
	
	public void SinglePlay(String name, int index, int enemyindex) { //on button press after TestMana
		int[] stats = Values(name);
		if(enemyindex == 1) {
			first.health -= stats[1] - player.strength + first.vulnerable - player.weak;
			first.vulnerable += stats[4];
			first.weak += stats[5];
		}
		if(enemyindex == 2) {
			second.health -= stats[1] - player.strength + second.vulnerable - player.weak;
			second.vulnerable += stats[4];
			second.weak += stats[5];
		}
		if(enemyindex == 3) {
			third.health -= stats[1] - player.strength + third.vulnerable - player.weak;
			third.vulnerable += stats[4];
			third.weak += stats[5];
		}
		player.shield += stats[2];
		player.strength += stats[3];
		player.mana -= stats[6];
		/*
		 * guide to the values*
		 * values[1] = damage
		 * values[2] = shield
		 * values[3] = strength
		 * values[4] = vulnerable to enemy
		 * values[5] = weak to enemy
		 * values[6] = mana
		 */
		Remove(index);
	}
	
	public void EnemyTurn() { //enemies turn after end turn
		int[] firstvalues = new int[5];
		int[] secondvalues = new int[5];
		int[] thirdvalues = new int[5];
		if(enemies.length == 1) {
			firstvalues = DamageValues(enemies[0]);
			player.health -= firstvalues[0] - first.strength + player.vulnerable - first.weak;
			first.shield += firstvalues[1];
			first.strength += firstvalues[2];
			player.vulnerable += firstvalues[3];
			player.weak += firstvalues[4];
		}
		if(enemies.length == 2) {
			firstvalues = DamageValues(enemies[0]);
			secondvalues = DamageValues(enemies[1]);
			player.health -= firstvalues[0] - first.strength + player.vulnerable - first.weak;
			first.shield += firstvalues[1];
			first.strength += firstvalues[2];
			player.vulnerable += firstvalues[3];
			player.weak += firstvalues[4];
			player.health -= secondvalues[0] - second.strength + player.vulnerable - second.weak;
			second.shield += secondvalues[1];
			second.strength += secondvalues[2];
			player.vulnerable += secondvalues[3];
			player.weak += secondvalues[4];
		}
		if(enemies.length == 3) {
			firstvalues = DamageValues(enemies[0]);
			secondvalues = DamageValues(enemies[1]);
			thirdvalues = DamageValues(enemies[2]);
			player.health -= firstvalues[0] - first.strength + player.vulnerable - first.weak;
			first.shield += firstvalues[1];
			first.strength += firstvalues[2];
			player.vulnerable += firstvalues[3];
			player.weak += firstvalues[4];
			player.health -= secondvalues[0] - second.strength + player.vulnerable - second.weak;
			second.shield += secondvalues[1];
			second.strength += secondvalues[2];
			player.vulnerable += secondvalues[3];
			player.weak += secondvalues[4];
			player.health -= thirdvalues[0] - third.strength + player.vulnerable - third.weak;
			third.shield += thirdvalues[1];
			third.strength += thirdvalues[2];
			player.vulnerable += thirdvalues[3];
			player.weak += thirdvalues[4];
		}
		/*
		 * guide to the values*
		 * enemyvalues[0] = damage
		 * enemyvalues[1] = shield
		 * enemyvalues[2] = strength
		 * enemyvalues[3] = vulnerable
		 * enemyvalues[4] = weak
		 */
	}
	
	public void CardOptions() { //after battle to add to deck
		String[] options = deckbuild();
		for(int i = 0; i < 3; i++) {
		int randomIndex = (int) (Math.random() * options.length);
		selectcard.add(options[randomIndex]);
		}
	}
	
	public void CardAdd(int index) { //after CardOptions
		draw.add(selectcard.get(index));
	}
	
	public void PlayerEndTurn() {
		if(player.strength != 0) {
			player.strength -= 1;
		}
		if(player.vulnerable != 0) {
			player.vulnerable -= 1;
		}
		if(player.weak != 0) {
			player.weak -= 1;
		}
		if(enemies.length == 1) {
			first.shield = 0;
		}
		if(enemies.length == 2) {
			first.shield = 0;
			second.shield = 0;
		}
		if(enemies.length == 3) {
			first.shield = 0;
			second.shield = 0;
			third.shield = 0;
		}
	}
	
	public void EnemyEndTurn() {
		player.shield = 0;
		if(enemies.length == 1) {
			if(first.strength != 0) {
				first.strength -= 1;
			}
			if(first.vulnerable != 0) {
				first.vulnerable -= 1;
			}
			if(first.weak != 0) {
				first.weak -= 1;
			}
		}
		if(enemies.length == 2) {
			if(first.strength != 0) {
				first.strength -= 1;
			}
			if(first.vulnerable != 0) {
				first.vulnerable -= 1;
			}
			if(first.weak != 0) {
				first.weak -= 1;
			}
			if(second.strength != 0) {
				second.strength -= 1;
			}
			if(second.vulnerable != 0) {
				second.vulnerable -= 1;
			}
			if(second.weak != 0) {
				second.weak -= 1;
			}
		}
		if(enemies.length == 3) {
			if(first.strength != 0) {
				first.strength -= 1;
			}
			if(first.vulnerable != 0) {
				first.vulnerable -= 1;
			}
			if(first.weak != 0) {
				first.weak -= 1;
			}
			if(second.strength != 0) {
				second.strength -= 1;
			}
			if(second.vulnerable != 0) {
				second.vulnerable -= 1;
			}
			if(second.weak != 0) {
				second.weak -= 1;
			}
			if(third.strength != 0) {
				third.strength -= 1;
			}
			if(third.vulnerable != 0) {
				third.vulnerable -= 1;
			}
			if(third.weak != 0) {
				third.weak -= 1;
			}
		}
	}
	
	public void BonfireHeal() {
		player.health += (player.health / 2);
	}
	
	public void Item() {
		player.health += 6;
	}
	
	public void StageIncrease() {
		stage++;
	}
}
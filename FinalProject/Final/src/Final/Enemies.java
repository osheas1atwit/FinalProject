package Final;

public class Enemies extends Character{
		protected int health;
		protected int damageout;
		protected int shield;
		protected int strength;
		protected int vulnerable;
		protected int weak;
		
		public Enemies() {
			health = 0;
			damageout = 0;
			shield = 0;
			strength = 0;
			vulnerable = 0;
			weak = 0;
		}
		
		public void StartEnemies() {
			enemies();
			SetEnemyValues();
		}
		
		private String[] enemylist = new String[9]; 
		public String[] enemies() {
		 enemylist[0]= "louse1";
		 enemylist[1]= "louse2";
		 enemylist[2]="acidSlime";
		 enemylist[3]= "thief";
		 enemylist[4]="goblinNob"; 
		 enemylist[5]="lagavulinSleep";
		 enemylist[6]="lagavulinAwake";
		 enemylist[7]= "slimeBoss" ;
		 enemylist[8]= "slimeBossSplit";
		return enemylist;
		}
		
		public int SetEnemyHealth(String name) {
			if(name == "lagavulinAwake") {
				health = 100;
			}
			if(name == "lagavulinSleep") {
				health = 10;
			}
			if(name == "goblinNob") {
				health = 80;
			}
			if(name == "acidSlime") {
				health = 8;
			}
			if(name == "louse1" || name == "louse2") {
				health = 10;
			}
			if(name == "slimeBoss") {
				health = 140;
			}
			if(name == "slimeBossSplit") {
				health = 30;
			}
			if(name == "thief") {
				health = 40;
			}
			return health;
		}

		public int RandomMath(int length, int min) {
		int attack = 0;
		 do {
		 attack= (int)(Math.random()*length);
		 }while(attack > length || attack <= min);
		 return attack;
		}
		
		private int[] enemyvalues;
		private void SetEnemyValues() {
			enemyvalues[0] = 0;
			enemyvalues[1] = 0;
			enemyvalues[2] = 0;
			enemyvalues[3] = 0;
			enemyvalues[4] = 0;
			/*
			 * guide to the values*
			 * enemyvalues[0] = damage
			 * enemyvalues[1] = shield
			 * enemyvalues[2] = strength
			 * enemyvalues[3] = vulnerable
			 * enemyvalues[4] = weak
			 */
		}
		
		public int[] DamageValues(String name) {
		int attack = RandomMath(3, 0);
		if(name == "lagavulinAwake" && attack == 0) {
			enemyvalues[0] = 18;
		}
		if(name == "lagavulinAwake" && (attack == 1 || attack == 2)) {
			enemyvalues[3] = 2;
			enemyvalues[4] = 2;
		}
		if(name == "lagavulinSleep") {
			enemyvalues[1] = 10;
		}
		if(name == "goblinNob" && attack == 0) {
			enemyvalues[0] = 14;
		}
		if(name == "goblinNob" && attack == 1) {
			enemyvalues[2] = 2;
		}
		if(name == "goblinNob" && attack == 2) {
			enemyvalues[0] = 6;
			enemyvalues[3] = 2;
		}
		if((name == "acidSlime" || name == "slimeBossSplit") && attack == 0) {
			enemyvalues[0] = 10;
		}
		if((name == "acidSlime" || name == "slimeBossSplit") && attack == 1) {
			enemyvalues[0] = 7;
			enemyvalues[4] = 1;
		}
		if((name == "acidSlime" || name == "slimeBossSplit") && attack == 2) {
			enemyvalues[4] = 2;
		}
		if((name == "louse1" || name == "louse2") && attack == 0) {
			enemyvalues[0] = 4;

		}
		if((name == "louse1" || name == "louse2") && (attack == 1 || attack == 2)) {
			enemyvalues[2] = 3;
		}
		if(name == "slimeBoss" && (attack == 0 || attack == 1)) {
			enemyvalues[0] = 35;
		}
		if(name == "slimeBoss" && attack == 2) {
			enemyvalues[4] = 2;
		}
		if(name == "thief" && attack == 0) {
			enemyvalues[1] = 6;
		}
		if(name == "thief" && attack == 1) {
			enemyvalues[0] = 12;
		}
		if(name == "thief" && attack == 2) {
			enemyvalues[0] = 10;
		}
		return enemyvalues;
		 }
		
		String[] enemiesselected;
		public String[] encounters(int stage) {
			int number = 0;
			if(stage == 1 || stage == 2 || stage == 5) {
				number = RandomMath(3, 0);
				if(number == 0) {
					enemiesselected[0] = enemylist[0];
					enemiesselected[1] = enemylist[1];
					enemiesselected[2] = enemylist[0];
				}
				if(number == 1) {
					enemiesselected[0] = enemylist[2];
					enemiesselected[1] = enemylist[2];
				}
				if(number == 2) {
					enemiesselected[0] = enemylist[3];
					enemiesselected[1] = enemylist[3];
				}
			}
			if(stage == 3) {
				number = RandomMath(2, 0);
				if(number == 0) {
					enemiesselected[0] = enemylist[4];
				}
				if(number == 1) {
					enemiesselected[0] = enemylist[5];
				}
			if(stage == 6) {
				enemiesselected[0] = enemylist[7];
			}
			}
			return enemiesselected;
		}
}
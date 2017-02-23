public class Creature 
{
	private int max_health;
	private int health;
	private int armour;
	private int attack;
	private int evasion;
	private String name; //Added this since it's not? going off Array
	
	// Can't just be a "creature" lmao
	
	public Creature(int max_health, int health, int armour, int attack, int evasion, String name)
	{
		this.max_health = max_health;
		this.health = health;
		this.armour = armour;
		this.attack = attack;
		this.evasion = evasion;
		this.name = name;
	}
	
	
}

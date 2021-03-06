import java.util.Random;

/** Class dedicated entirely to the looting mechanic, uses random number generation to give a chance to get loot, 
 * and again to determine what kind of loot */

public class Looting 
{
	static void main(String[] args)
	{}
	
	/** decides the chances to get loot from a corpse, and the quality of loot depending on the type of creature killed 
	 * Ogres give better loot than Rats.*/
	public static void lootBody(String enemyname)
	 {
		 Random rn = new Random(); 
		 int lootchance = rn.nextInt(10);
		 MainApp.corpse = false;
		 if (lootchance >= 4 && enemyname == "ogre")
		 {
			 loot(1);
		 }
		 else if (lootchance < 4 && enemyname == "ogre")
		 {
			System.out.println("the corpse has nothing left on it!");
		 }
		 if (lootchance >= 6 && enemyname == "rat")
		 {
			 loot(2);
		 }
		 else if (lootchance < 6 && enemyname == "rat")
		 {
			System.out.println("the corpse has nothing left on it!");
		 }
	 }
	
	/** Decides on the type of loot depending on what kind of creature was killed */
	static void loot(int rarity)
	{
		Random rn1 = new Random(); 
		 int lootnum = rn1.nextInt(5);
		 switch(lootnum+1)
		 {
		 case 1:
			 if(rarity == 1)
			 {
				 MainApp.coins = MainApp.coins + 10;
				 System.out.println("You found 10 coins on the corpse");
			 }
			 else
			 {
				 MainApp.coins = MainApp.coins + 5;
				 System.out.println("You found 5 coins on the corpse");
			 }
			 break;
			 
		 case 2:
			 if(rarity == 1)
			 {
				 InventoryStuff.invAdd('!');
				 System.out.println("You found an obsidian dagger on the corpse");
			 }
			 else
			 {
				 MainApp.potions[0] =  MainApp.potions[0] + 1;
				 System.out.println("You found a small potion on the corpse");
			 }
			 break;
			 
		 case 3:
			 if(rarity == 1)
			 {
				 InventoryStuff.invAdd('0');
				 System.out.println("You found an all-sided axe on the corpse");
			 }
			 else
			 {
				 MainApp.potions[1] =  MainApp.potions[1] + 1;
				 System.out.println("You found a medium potion on the corpse");
			 }
			 break;
			 
		 case 4:
			 if(rarity == 1)
			 {
				 InventoryStuff.invAdd('&');
				 System.out.println("You found a elven bow on the corpse");
			 }
			 else
			 {
				 MainApp.coins = MainApp.coins + 2;
				 System.out.println("You found 2 coins on the corpse");
			 }
			 break;
			 
		 case 5:
			 if(rarity == 1)
			 {
				 MainApp.potions[2] =  MainApp.potions[2] + 1;
				 System.out.println("You found a large potion on the corpse");
			 }
			 else
			 {
				 MainApp.coins = MainApp.coins + 3;
				 System.out.println("You found 3 coins on the corpse");
			 }
			 break;
			 
		default:
			System.out.println("I don't know how you managed to get no loot, are you a really terrible wizard?");
			break;
			
		 }

	}
	
	public static void chestChance()
	{
		 Random rn = new Random(); 
		 int chestnum = rn.nextInt(3);
		 
		 switch(chestnum)
		 {
		 case 1:
			 System.out.println("Oh no, that chest was a mimic!");
		     for ( int i = 0; i<=3 ; i++ ) 
		     {
		       MainApp.enemyStats[i] = EnemyStats.monster[2][i];
		       MainApp.enemyName = EnemyStats.monsterName[2];
		     }
		     MainApp.chest = false;
			Combat.attack();
		 	break;
		 case 2:
			 System.out.println("you found 25 coins inside the chest!");
			 MainApp.coins = MainApp.coins + 25;
			 MainApp.chest = false;
		 	break;
		 case 3:
			 System.out.println("You found 3 large potions in the chest");
			 MainApp.potions[2] =  MainApp.potions[2] + 3;
			 MainApp.chest = false;
			 break;
		default:
			System.out.println("STOP YOUR RNG BREAKING WIZARDRY");
			break;
		 }
	}
}

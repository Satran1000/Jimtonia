import java.util.Scanner;

/* This class is used to assign the Character and related statistics.
 * The player can choose name, race and class of their character which is assigned to variables stored in the Statistics class
 */
public class CharBuild
{

	// this is the character building function, it takes what the player puts in and assigns them to variables stored in the Statistics Class through calling various functions
	public static void charBuild()
	  {
	    System.out.println("Welcome to the Character builder for " + AdminTools.build_name + "!");
	    System.out.println("To start you off, what's your name?");
	    // Calls name collection function 
	    player_name();
	    System.out.println("Oh! So, " + Statistics.player_name  + ", right? Interesting!"); // After a large amount of characters this breaks and leaves a blank space, _Please_ don't do that
	    System.out.println("So, tell me, " + Statistics.player_name  + ", what race were you born to?");
	    System.out.println("1. I was born into a happy, Human family.");
	    System.out.println("2. I was born into a prestigious, Elven family.");
	    System.out.println("3. I was born into a mighty, Orcish family.");
	    // Calls race collection function 
	    player_race();
	    // Does a small grammar check, based off of player's Race 
	    if (Statistics.player_race == "Human")
	     {
	       System.out.println("A " + Statistics.player_race + " with a face like that? Well that's... interesting.");
	     }
	     else 
	     {
	       System.out.println("An " + Statistics.player_race + " with a face like that? Well that's... interesting.");
	     }
	    
	    System.out.println("Well, lastly, " + Statistics.player_name + " I'd just like to know what you wield there with you?");
	    System.out.println("1. A Dagger. I'm a Rogue!");
	    System.out.println("2. A Bow. I'm an Archer!");
	    System.out.println("3. An Axe. I'm a Warrior!");
	    // Calls class collection function 
	    player_class();
	    // Assigns the potion pouch, a placeholder item, player_potions and coins to the player, assigning them to variables stored in the Statistics class 
	    System.out.println(Statistics.player_name + " the " + Statistics.player_race + "-born " + Statistics.player_class + ", hmm? Marvelous!!!");
	    System.out.println("It's dangerous to go alone, take these potions, and some starting money!");
	    Statistics.player_inv[0][1] = 'P';
	    Statistics.player_potions[0] = 2;
	    Statistics.coins = 50;
	  }
	
	// Used to assign the player_name Variable, and stores it in the Statistics Class 
	static void player_name()
	{
	  Scanner sc = new Scanner(System.in);
	  Statistics.player_name = sc.nextLine();
	}
	
	// Used to assign the player_race Variable, assigning the player's racial statistics accordingly and storing them in the Statistics class 
	static void player_race()
	{
	for ( ; ; )
	{
	  Scanner sc = new Scanner(System.in);
	  int tempcalc = sc.nextInt();
	  
	  
	  switch(tempcalc) 
	  {
	    case 1: 
	    	Statistics.player_race = "Human";
	            Statistics.player_stats[0] = 10; //HP
	            Statistics.player_stats[1] = 10; //MAXHP
	            Statistics.player_stats[2] = 0;  //ARM
	            Statistics.player_stats[3] = 4;  //ATK
	            Statistics.player_stats[4] = 2;  //EVA
	    return;
	    
	    case 2: 
	    	Statistics.player_race = "Elf";
	            Statistics.player_stats[0] = 13;
	            Statistics.player_stats[1] = 13;
	            Statistics.player_stats[2] = 0;
	            Statistics.player_stats[3] = 2;
	            Statistics.player_stats[4] = 3;
	        
	    return;
	    
	    case 3: 
	    	Statistics.player_race = "Orc";
		    	Statistics.player_stats[0] = 12;
	            Statistics.player_stats[1] = 12;
	            Statistics.player_stats[2] = 1;
	            Statistics.player_stats[3] = 4;
	            Statistics.player_stats[4] = 1;
	    return;
	    
	    default:
	    System.out.println("Sorry, that was not a valid response.");
	    break;
	  }
	  }

	}
	
	// Used to assign the player_class Variable, adding extra points to the player's statistics and giving them a starting weapon based on their class selection, storing to the Statistics class 
	
	static void player_class()
	{
		for ( ; ; )
		{
			Scanner sc = new Scanner(System.in);
			int tempcalc = sc.nextInt();
		  
			switch(tempcalc) {
			    case 1: 
			    	Statistics.player_class = "Rogue";
			    	Statistics.player_stats[0] = Statistics.player_stats[0] + 2; //HP
		            Statistics.player_stats[1] = Statistics.player_stats[1] + 2; //MAXHP
		            Statistics.player_stats[2] = Statistics.player_stats[2] + 0; //ARM
		            Statistics.player_stats[3] = Statistics.player_stats[3] + 1; //ATK
		            Statistics.player_stats[4] = Statistics.player_stats[4] + 3; //EVA
		            Statistics.player_inv[0][0] = '^'; //Dagger
			    return;
			    
			    case 2: 
			    	Statistics.player_class = "Archer";
			    	Statistics.player_stats[0] = Statistics.player_stats[0] + 2;
		            Statistics.player_stats[1] = Statistics.player_stats[1] + 2;
		            Statistics.player_stats[2] = Statistics.player_stats[2] + 0;
		            Statistics.player_stats[3] = Statistics.player_stats[3] + 2;
		            Statistics.player_stats[4] = Statistics.player_stats[4] + 2;
		            Statistics.player_inv[0][0] = '$'; //Bow

			    return;
			    
			    case 3: 
			    	Statistics.player_class = "Warrior";
			    	Statistics.player_stats[0] = Statistics.player_stats[0] + 0;
		            Statistics.player_stats[1] = Statistics.player_stats[1] + 0;
		            Statistics.player_stats[2] = Statistics.player_stats[2] + 1;
		            Statistics.player_stats[3] = Statistics.player_stats[3] + 2;
		            Statistics.player_stats[4] = Statistics.player_stats[4] + 2;
		            Statistics.player_inv[0][0] = '%'; //AND MY AXE
		            
			    return;
			    
			    default:
			    System.out.println("Sorry, that was not a valid response.");
			    break;
			}
		}
	}
}
import java.util.*;

/** This class is used to assign the Character and related statistics.
 * The player can choose name, race and class of their character which is assigned to variables stored in the MainApp class
 */
public class CharBuild
{

	public static void main (String[] args) 
	  {
	    charbuild();
	  }

	/** this is the character building function, it takes what the player puts in and assigns them to variables stored in the MainApp Class through calling various functions */
	public static void charbuild()
	  {
	    System.out.println("Welcome to the Character builder for JimQuest 'Lite'!");
	    System.out.println("To start you off, what's your name?");
	    /** Calls name collection function */
	    playerName();
	    System.out.println("Oh! So, " + MainApp.playerName  + ", right? Interesting!"); // After a large amount of characters this breaks and leaves a blank space, _Please_ don't do that
	    System.out.println("So, tell me, " + MainApp.playerName  + ", what race were you born to?");
	    System.out.println("1. I was born into a happy, Human family.");
	    System.out.println("2. I was born into a prestigious, Elven family.");
	    System.out.println("3. I was born into a mighty, Orcish family.");
	    /** Calls race collection function */
	    playerRace();
	    /** Does a small grammar check, based off of player's Race */
	    if (MainApp.playerRace == "Human")
	     {
	       System.out.println("A " + MainApp.playerRace + " with a face like that? Well that's... interesting.");
	     }
	     else 
	     {
	       System.out.println("An " + MainApp.playerRace + " with a face like that? Well that's... interesting.");
	     }
	    
	    System.out.println("Well, lastly, " + MainApp.playerName + " I'd just like to know what you wield there with you?");
	    System.out.println("1. A Dagger. I'm a Rogue!");
	    System.out.println("2. A Bow. I'm an Archer!");
	    System.out.println("3. An Axe. I'm a Warrior!");
	    /** Calls class collection function */
	    playerClass();
	    /** Assigns the potion pouch, a placeholder item, potions and coins to the player, assigning them to variables stored in the MainApp class */
	    System.out.println(MainApp.playerName + " the " + MainApp.playerRace + "-born " + MainApp.playerClass + ", hmm? Marvelous!!!");
	    System.out.println("It's dangerous to go alone, take these potions!");
	    MainApp.inv[0][1] = 'P';
	    MainApp.potions[0] = 1;
	    MainApp.potions[1] = 3;
	    MainApp.potions[2] = 1;
	    MainApp.coins = 50;
	  }
	
	/** Used to assign the playerName Variable, and stores it in the MainApp Class */
	static void playerName()
	{
	  Scanner sc = new Scanner(System.in);
	  MainApp.playerName = sc.nextLine();
	}
	
	/** Used to assign the playerRace Variable, assigning the player's racial statistics accordingly and storing them in the MainApp class */
	static void playerRace()
	{
	for ( ; ; )
	{
	  Scanner sc = new Scanner(System.in);
	  int tempcalc = sc.nextInt();
	  
	  
	  switch(tempcalc) {
	    case 1: 
	    	MainApp.playerRace = "Human";
	            MainApp.playerStats[0] = 10;
	            MainApp.playerStats[1] = 10;
	            MainApp.playerStats[2] = 30;
	            MainApp.playerStats[3] = 2;
	            MainApp.playerStats[4] = 30;
	    return;
	    
	    case 2: 
	    	MainApp.playerRace = "Elf";
	            MainApp.playerStats[0] = 8;
	            MainApp.playerStats[1] = 30;
	            MainApp.playerStats[2] = 25;
	            MainApp.playerStats[3] = 1;
	            MainApp.playerStats[4] = 25;
	        
	    return;
	    
	    case 3: 
	    	MainApp.playerRace = "Orc";
		    	MainApp.playerStats[0] = 13;
	            MainApp.playerStats[1] = 25;
	            MainApp.playerStats[2] = 35;
	            MainApp.playerStats[3] = 3;
	            MainApp.playerStats[4] = 35;
	    return;
	    
	    default:
	    System.out.println("Sorry, that was not a valid response.");
	    break;
	  }
	  }

	}
	
	/** Used to assign the playerclass Variable, adding extra points to the player's statistics and giving them a starting weapon based on their class selection, storing to the MainApp class */
	
	static void playerClass()
	{
		for ( ; ; )
		{
			Scanner sc = new Scanner(System.in);
			int tempcalc = sc.nextInt();
		  
			switch(tempcalc) {
			    case 1: 
			    	MainApp.playerClass = "Rogue";
			    	MainApp.playerStats[0] = MainApp.playerStats[0] + 3;
		            MainApp.playerStats[1] = MainApp.playerStats[1] + 25;
		            MainApp.playerStats[2] = MainApp.playerStats[2] + 10;
		            MainApp.playerStats[3] = MainApp.playerStats[3] + 1;
		            MainApp.playerStats[4] = MainApp.playerStats[4] + 10;
		            MainApp.inv[0][0] = '^'; //Dagger
			    return;
			    
			    case 2: 
			    	MainApp.playerClass = "Archer";
			    	MainApp.playerStats[0] = MainApp.playerStats[0] + 4;
		            MainApp.playerStats[1] = MainApp.playerStats[1] + 20;
		            MainApp.playerStats[2] = MainApp.playerStats[2] + 5;
		            MainApp.playerStats[3] = MainApp.playerStats[3] + 1;
		            MainApp.playerStats[4] = MainApp.playerStats[4] + 5;
		            MainApp.inv[0][0] = '$'; //Bow

			    return;
			    
			    case 3: 
			    	MainApp.playerClass = "Warrior";
			    	MainApp.playerStats[0] = MainApp.playerStats[0] + 5;
		            MainApp.playerStats[1] = MainApp.playerStats[1] + 15;
		            MainApp.playerStats[2] = MainApp.playerStats[2] + 15;
		            MainApp.playerStats[3] = MainApp.playerStats[3] + 2;
		            MainApp.playerStats[4] = MainApp.playerStats[4] + 15;
		            MainApp.inv[0][0] = '%'; //AND MY AXE
		            
			    return;
			    
			    default:
			    System.out.println("Sorry, that was not a valid response.");
			    break;
			}
		}
	}
}

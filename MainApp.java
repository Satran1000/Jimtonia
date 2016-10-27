import java.util.*; // import that star boi
import java.io.*; // Import that io star boi

/**
 *  Main Class, hosts major variables used across all classes and is used for the majority of the game's menus from this class, saving, loading and 
 * The Double[] enemyStats is used for statistics of the currently faced enemy, in order, their attack, defence/evasion, health, armor and max health, and is assigned from the Combat class
 * the Double[] playerStats is used for storage of the player's statistics, in order, their attack, defence/evasion, health, armor and max health and is assigned from the CharBuild class
 * the Double[] items is used for the storage of the player's potions and is assigned from the CharBuild class
 * the char[][] inv is used for the player's inventory
 * the int travlocx is the x Coordinate of the player and is assigned initially from the MainApp class
 * the int travlocY is the Y Coordinate of the player and is assigned initially from the MainApp class
 * the String locationname is the name of the location the player is standing at and is assigned from the Location_Travel class
 * the char[][] loc is the game map and is assigned from within the MainApp class
 * the String playerRace is the Player's Race and is assigned from the CharBuild class
 * the String playerClass is the Player's Class and is assigned from the CharBuild class
 * the String playerName is the Player's Name and is assigned from the CharBuild class
 */

public class MainApp
{
	
	static double[] playerStats = {0, 0, 0, 0, 0};  //[0] = attack  [1] = defence / Evasion  [2] = health  [3] = armor [4] = max health
	static double[] enemyStats = {0, 0, 0, 0};  //[0] = attack  [1] = defence  [2] = health  [3] = armor
	static String enemyName; // Used for inspection purposes
	
	static int[] potions = {0, 0, 0};
	static char[][] inv = { {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'} };
	static int coins;
	
	static int travlocx;
	static int travlocy;
	static String locationname;
	static char[][] loc = {{' ',' ',' ',' '},{' ',' ',' ',' '},{' ',' ',' ',' '},{' ',' ',' ',' '}};
	
	static String playerRace;
	static String playerClass;
	static String playerName;
	
	static boolean chest;
	static boolean corpse;
	static boolean alreadyEquipped;
	
	
	public static void main(String[] args)
	{
		mainMenu(); // Loads Main Menu
		
		/* Debug Tools */
		//state_player(); 	// Describes player with all available variables w/ flavour text
		//state_player2();  // Describes player with all available variables w/ no flavour text
		//LocVars(1,1); 	//Assigns location variables by x,y
	}
	
	/** 
	 * Starts a new game by calling the charbuild function from the CharBuild class then sending the player to the ingame menu
	 */
	
	public static void newGame() // Start New Game - Called from Main Menu
	{
		CharBuild.charbuild();
		System.out.printf("\n");
		locvars(1,1); // Assign Location Variables
        gameMenu(); //Ingame Menu, The HUB
	}
	
	/**
	 * The ingame menu, Player can travel, interact, check their inventory, display the map, save and Quit from here
	 */
	
	public static void gameMenu() //Ingame Menu, The HUB
	{
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		
		for( ; ; )
		{
		statePlayer();
		gameMenudisp(); //Display Game Menu - HUB
		ch = sc.nextInt(); 	
	    sc.nextLine();
	    
	    switch(ch)
	    {
	    case 1:
	    	Location_Travel.travel();
	    	break;
	    case 2:
	    	interact();
	    	break;
	    case 3:
	    	InventoryStuff.displayInv();
	    	break;
	    case 4:
	    	MapStuff.displaymap();
	    	break;
	    case 5:
	    	saveGame();
	    	break;
	    case 6:
	    	quitGamemenu();
	    	return;
	    }
		}
	}

	/**
	 * The Main Menu, Offers the player a choice of starting a new game, loading a prior save or quitting the game
	 */
	
	static void mainMenu()
	  {
	 	  
		  Scanner sc = new Scanner(System.in);
		  int ch = 0;
	
	      mainMenudisp(); //Display Main Menu
	      System.out.println("Press Num Key of choice");
		  ch = sc.nextInt(); 	
	      sc.nextLine();
	      
	      switch (ch)
	      {
	        case 1:
	          newGame(); //Start New game Sequence
	          return;
	
	        case 2:
	          loadGame(); // Load game from last playthrough
	          return;
	
	        case 3:
	          System.out.println("Are you sure you want to Quit?");
	          quitMenu();
	          return;
	      }
	  }
	
	/**
	 * displays the main menu
	 */
	static void mainMenudisp()
	{
		System.out.println("Main Menu");
		System.out.println("1. Start New Game");
		System.out.println("2. Load Game");
		System.out.println("3. Quit");
	}

	/**
	 * Displays a yes/no choice for Quit menus
	 */
	
	static void quitMenudisp()
	{
		System.out.println("1. Yes");
		System.out.println("2. No");
	}
	
	/**
	 * displays the Ingame Quit game menu
	 */
	
	static void quitGamemenudisp()
	{
		System.out.println("1. Save and Quit");
		System.out.println("2. Quit");
	}
	
	/**
	 * Displays the ingame menu
	 */
	
	static void gameMenudisp()
	{
		System.out.println("What do you want to do?");
		System.out.println("1. Travel");
		System.out.println("2. Interact");
		System.out.println("3. Inventory");
		System.out.println("4. Map");
		System.out.println("5. Save");
		System.out.println("6. Quit");
	}
	
	/**
	 * This is the Quit menu, An offshoot of the main menu,
	 * after a choice to the player, This will close the game instance
	 */
	static void quitMenu() // Quit Game Menu, This will stop all interaction
	{
		Scanner sc = new Scanner(System.in);
		quitMenudisp(); //Display Quit menu 
	    
		int ch = 0;
	    ch = sc.nextInt(); 	
	      sc.nextLine();
	      
	      switch (ch)
	      {
	        case 1:
	        	System.out.println("Quitting Game!");
	        	return;
	        	
	        case 2:
	        	mainMenu();
	        	return;
	      }
	}
	
	/**
	 * This is the ingame quit game menu, this will offer the player a choice between saving the gamestate and quitting to the main menu, or just quitting to the main menu
	 */
	
	static void quitGamemenu() // Quit Game Menu, This will stop all interaction
	{
		quitGamemenudisp(); //Display Quit menu 
		Scanner sc = new Scanner(System.in);
	    int ch = 0;
	    ch = sc.nextInt(); 	
	      sc.nextLine();
	      
	      switch (ch)
	      {
	        case 1:
	        	System.out.println("Are you sure you want to Save and Quit?");
	        	quitMenudisp();
	        	saveQuit();
	        	return;
	        	
	        case 2:
	        	System.out.println("Are you sure you want to Quit?");
		        quitMenudisp();
		        hardQuit();
		        return;
	      }
	}
	
	static void interact()
	{
		if(chest == true)
		{
			Looting.chestChance(); 
			
		}
    	else if(locationname == "Town")
		{
			ShopStuff.enterShop();
		}
    	else if(chest == false && (locationname == "Wilderness" || locationname == "Cave"))
		{
			System.out.println("There is nothing to interact with here!");
		}
    	else System.out.println("What the absolute hell?!");
	}
	/**
	 * This is the ingame Save and Quit menu, offers to quit to the main menu, saving the gamestate, players may choose to decline and return to the game menu
	 */
	
	static void saveQuit() // Save and Quit Menu
	{
		Scanner sc = new Scanner(System.in);
	    int ch = 0;
	    ch = sc.nextInt(); 	
	    sc.nextLine();
	      
	      switch (ch)
	      {
	        case 1:
	        	System.out.println("Saved and Quitting!");
	        	saveGame();
	        	mainMenu();
	        	return;
	        	
	        case 2:
		        gameMenu();
		        return;
	      }
	}
	
	/** 
	 * This is the ingame 'Hard' Quit menu, offers to quit to the main menu with no saving of the gamestate, players may choose to decline and return to the game menu
	 */
	
	static void hardQuit() // Hard Quit Menu
	{
		Scanner sc = new Scanner(System.in);
	    int ch = 0;
	    ch = sc.nextInt(); 	
	    sc.nextLine();
	      
	      switch (ch)
	      {
	        case 1:
	        	System.out.println("Quitting!");
	        	mainMenu();
	        	return;
	        	
	        case 2:
		        gameMenu();
		        return;
	      }
	}
	
	/**
	 * assigns the map and the players location variables to x,y respectively.
	 * used for start game, debug and cheating purposes
	 * the int x is used to assign the player's x coordinate on the map
	 * the int y is used to assign the player's y coordinate on the map
	 * calls the "currentLocation" function to assign the player's current location
	 */
	static void locvars(int x, int y) // Assign Location Variables
	{
		MainApp.loc = new char[][] { {'W', 'W', 'W', 'C'}, {'W', 'T', 'W', 'W'}, {'C', 'W', 'W', 'W'}, {'W', 'W', 'T', 'W'} };
		travlocx = x;
		travlocy = y;
		Location_Travel.currentLocation(x,y);
		chest = false;
	}
	

	
	/**f
	 * Loads a saved game file, this is hardcoded to load "Save_1.sav"
	 * loads all major variables
	 */
	 public static void loadGame() // Load Game menu
	{
		try
			{
			Scanner sc = new Scanner(System.in);
			System.out.println("Choose a filename to load from, the extension will be applied automatically");
			String loadname = sc.nextLine();
			
			// Open file to read from, named SavedObj.sav.
			FileInputStream saveFile = new FileInputStream(loadname +".sav");
			
			// Create an ObjectInputStream to get objects from save file.
			ObjectInputStream save = new ObjectInputStream(saveFile);
			
			// Now we do the restore.
			// readObject() returns a generic Object, we cast those back
			// into their original class type.
			// For primitive types, use the corresponding reference class.
			playerClass = (String) save.readObject();
			playerRace = (String) save.readObject();
			playerName = (String) save.readObject();
			travlocx = (int) save.readObject();
			travlocy = (int) save.readObject();
			locationname = (String) save.readObject();
			playerStats = (double[]) save.readObject();
			potions = (int[]) save.readObject();
			inv = (char[][]) save.readObject();
			coins = (int) save.readObject();
			
			MainApp.loc = new char[][] { {'W', 'W', 'W', 'C'}, {'W', 'T', 'W', 'W'}, {'C', 'W', 'W', 'W'}, {'W', 'W', 'T', 'W'} };
			chest = false;
			
			// Close the file.
			save.close(); // This also closes saveFile.
		}
		catch(Exception exc)
		{
			exc.printStackTrace(); // If there was an error, print the info.
		}
		gameMenu();
	}
	
	 
	/**
	 * Saves the Game to a hardcoded "Save_1.sav" file
	 * Saves all Major Variables to file
	 */
	public static void saveGame()
	{
		try
		{  
			Scanner sc = new Scanner(System.in);
			System.out.println("Choose a name to save as, the extension will be applied automatically");
			String savename = sc.nextLine();
			
			// Open a file to write to.
			FileOutputStream saveFile=new FileOutputStream(savename + ".sav");
	
			// Create an ObjectOutputStream to put objects into save file.
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
	
			// Now we do the save.
			save.writeObject(playerClass);
			save.writeObject(playerRace);
			save.writeObject(playerName);
			save.writeObject(travlocx);
			save.writeObject(travlocy);
			save.writeObject(locationname);
			save.writeObject(playerStats);
			save.writeObject(potions);
			save.writeObject(inv);
			save.writeObject(coins);
			// Close the file.
			save.close(); // This also closes saveFile.
		}
	
		catch(Exception exc)
		{
			exc.printStackTrace(); // If there was an error, print the info.
		}
		System.out.println("Game Saved!");
	}
	
	/**
	 * function used to describe the player using all saved variables with flavour text 
	 */
	
	public static void statePlayer() // Describes Player Character with flavour text
	{
		if (MainApp.playerRace == "Human")
	    {
	       System.out.printf("the player is a ");
	    }
	    else 
	    {
	    	 System.out.printf("the player is an ");
	    }

		System.out.printf("%s %s Named %s\n",playerRace,playerClass,playerName); 
		System.out.printf("With %.0f " + "Attack, " + "%.0f " + "Evasion, " + "%.0f " + "Health and " +"%.0f " + "Armor.\n", playerStats[0],playerStats[1],playerStats[2],playerStats[3]);
		System.out.printf("They are located at (%d,%d) Which is a %s\n", travlocx,travlocy, locationname);
	}
	

	
	// Be wary, ye who enter here, debug tools of mass destruction be stored in these here shadowy halls
	
	// YE HAVE BEEN WARNED, most debug tools removed, no use for them anymore
	
	/**
	 * Alternative way to describe player, but without all flavour text, purely for debug purposes when flavour text may get in the way
	 */
	public static void statePlayer2() // Debug - Describes Player Character
	{
		System.out.printf("%s, %s %s\n",playerName,playerRace,playerClass); 
		System.out.printf("%.0f " + "Attack, " + "%.0f " + "Evasion, " + "%.0f " + "Health " +"%.0f " + "Armor\n", playerStats[0],playerStats[1],playerStats[2],playerStats[3]);
		System.out.printf("(%d,%d) :  %s\n", travlocx,travlocy, locationname);
	}
	
}
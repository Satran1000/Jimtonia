import java.util.*;

public class Welcome 
{
	public static void main(String[] args)
	{
		//A welcome message that lets the user know the build number
		System.out.println("Welcome to build " + AdminTools.build_no + " of Jimtonia! How would you like to get started?");
		gameSelect();
	}
	
	static void gameSelect()
	{
		//Initialises user input, and switch case.
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		//Displays a list of options, starting a new game, loading an old save, or quitting
		System.out.println("1. New Game");
		System.out.println("2. Load Game");
		System.out.println("3. Quit");
		System.out.println("To get started, select an option by typing the number referencing it, and hit 'Enter'");
		
		//Call for user input
		ch = sc.nextInt(); 	
	    sc.nextLine();
	    
	    switch (ch)
	    {
	        case 1:
	            newGame(); //Start New game Sequence
	            return;
	
	        case 2:
	            loadGame(); // Load game from last play-through
	            return;
	
	        case 3:
	            System.out.println("Are you sure you want to Quit?");
	            quitMenu();
	            return;
	      }
	}
	
	public static void newGame() // Start New Game - Called from gameSelect
	{
		CharBuild.charBuild();
		System.out.printf("\n");
        GameEnviro.gameMenu(); //In game Menu, The HUB
	}
	
	public static void loadGame() // Load Game menu
	{
	/* See Corn about this
	 * 
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
		
		gameMenu();*/
	} 
	
	static void quitMenu() // Quit Game Menu, This will stop all interaction
	{
		Scanner sc = new Scanner(System.in);
		//Display Quit menu 
		System.out.printf("1. Save and Quit\n" + "2. Quit\n");
	    
		int ch = 0;
	    ch = sc.nextInt(); 	
	    sc.nextLine();
	      
	    switch (ch)
	    {
	        case 1:
	        	System.out.println("Quitting Game!");
	        	return;
	        	
	        case 2:
	        	gameSelect();
	        	return;
	    }
	}	
}

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class AdminTools 
{
	public static String build_no = "0.1.1"; //The current version of the game
	public static String build_name = "Jimtonia"; //The current title of the game
	
	//Saving protocol
	public static void saveGame()
	{
		try
		{  
			Scanner sc = new Scanner(System.in);
			System.out.println("Choose a filename to save as.");
			String savename = sc.nextLine();
			
			// Open a file to write to.
			FileOutputStream saveFile=new FileOutputStream(savename + ".sav");
	
			// Create an ObjectOutputStream to put objects into save file.
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
	
			// Now we do the save.
			save.writeObject(Statistics.player_name);
			save.writeObject(Statistics.player_race);
			save.writeObject(Statistics.player_class);
			save.writeObject(Statistics.trav_loc_x);
			save.writeObject(Statistics.trav_loc_y);
			save.writeObject(Statistics.location_type);
			//save.writeObject(Statistics.player_stats);
			save.writeObject(Statistics.player_inv);
			save.writeObject(Statistics.player_potions);
			save.writeObject(Statistics.coins);
			// Close the file.
			save.close(); // This also closes saveFile.
		}
	
		catch(Exception exc)
		{
			exc.printStackTrace(); // If there was an error, print the info.
		}
		System.out.println("Game Saved!");
	}
	
	//Loading protocol
	public static void loadGame()
	{
		
	}
	
	public static void quitToMenu()
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
	        	saveGame();
	        	Welcome.main(null);
	        	return;
	        	
	        case 2:
	        	Welcome.main(null);
	        	return;
	    }
	}
}

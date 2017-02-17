import java.util.*;

public class GameEnviro 
{
	public static void main(String[] args)
	{
		gameMenu();
	}
	
	public static void gameMenu()
	{
				
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		
		for( ; ; )
		{
			statePlayer();
        
			System.out.println("What do you want to do?");
			System.out.println("1. Travel");
			System.out.println("2. Interact");
			System.out.println("3. Inventory");
			System.out.println("4. Map");
			System.out.println("5. Save");
			System.out.println("6. Quit");

			ch = sc.nextInt(); 	
			sc.nextLine();
	    
			switch(ch)
			{
	    		case 1:
	    			ToolsTravel.move();
	    			break;
	    		case 2:
	    			ToolsInteract.interact();
	    			break;
	    		case 3:
	    			ToolsInventory.open();
	    			break;
	    		case 4:
	    			ToolsTravel.show_map();
	    			break;
	    		/*case 5:
	    			saveGame();
	    			break;
	    		case 6:
	    			quit_menu();
	    			return;*/
	    	}
		}
	}
	
	public static void statePlayer() // Describes Player Character with flavour text
	{
		if (Statistics.player_race == "Human")
	    {
	       System.out.printf("the player is a ");
	    }
	    else 
	    {
	    	 System.out.printf("the player is an ");
	    }

		System.out.printf("%s %s Named %s\n",Statistics.player_race, Statistics.player_class, Statistics.player_name); 
		System.out.printf("With %d/%d Health, %d Armour, %d Attack, and %d Evasion\n", Statistics.player_stats[0], Statistics.player_stats[1], Statistics.player_stats[2], Statistics.player_stats[3], Statistics.player_stats[4]);
		System.out.printf("They are located at (%d,%d) Which is a %s\n", Statistics.trav_loc_x,Statistics.trav_loc_y, Statistics.location_type);
	}
	
	
	
	
	
	
	
}

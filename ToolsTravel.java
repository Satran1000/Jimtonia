import java.util.*;

public class ToolsTravel 
{

	public static void move()
	{
		
		boolean traveast = true;
		boolean travwest = true;
		boolean travnorth = true;
		boolean travsouth = true;
		 
		if (Statistics.trav_loc_x <= 0)
		{
		    Statistics.trav_loc_x = 0;
		    travwest = false;
		}
		if (Statistics.trav_loc_x >= 3)
		{
            Statistics.trav_loc_x = 3;
		    traveast = false;
		}
		if (Statistics.trav_loc_y <= 0)
		{
		    Statistics.trav_loc_y = 0;
		    travnorth = false;
		}
		if (Statistics.trav_loc_y >= 3)
		{
		  	Statistics.trav_loc_y = 3;
		    travsouth = false;
		}
		
		Boolean isStop = false;
	    while (!isStop)
	    {
	      

	        System.out.println("Which direction would you like to travel?");
	        if (travnorth == true) System.out.println("1. North");
	        if (traveast == true) System.out.println("2. East");
	        if (travsouth == true) System.out.println("3. South");
	        if (travwest == true) System.out.println("4. West");
	        System.out.println("5. Back to menu");
	      
	        Scanner sc = new Scanner(System.in);
	        String tempcalc = sc.nextLine();
	      
	        // handles the actual movement of the player
	        switch(tempcalc) 
	        {
	            case "1": 
	                //Moving North
	                if (travnorth == false)
	                {
	                    System.out.println("Sorry, that was not a valid response.");
	                    break;
	                }
	                else
	                {
	                    System.out.println("Travelling North...");
	                    Statistics.trav_loc_y = (Statistics.trav_loc_y - 1);
	                    isStop = true;
	                }
	                break;
	      
	            case "2": 
	            	//Moving East
	            	if (traveast == false)
	            	{
	            		System.out.println("Sorry, that was not a valid response.");
	            		break;
	            	}
	            	else
	            	{
	            		System.out.println("Travelling East...");
	            		Statistics.trav_loc_x = (Statistics.trav_loc_x + 1);
	            		isStop = true;
	            	}
	            	break;
	     
	            case "3": 
	            	//Moving South
	            	if (travsouth == false)
	            	{
	            		System.out.println("Sorry, that was not a valid response.");
	            		break;
	            	}
	            	else
	            	{
	            		System.out.println("Travelling South...");
	            		Statistics.trav_loc_y = (Statistics.trav_loc_y + 1);
	            		isStop = true;
	            	}
	            	break;
	          
	            case "4": 
	            	//Moving West
	            	if (travwest == false)
	            	{
	            		System.out.println("Sorry, that was not a valid response.");
	            		break;
	            	}
	            	else
	            	{
	            		System.out.println("Travelling West...");
	            		Statistics.trav_loc_x = (Statistics.trav_loc_x - 1);
	            		isStop = true;
	            	}
	            	break;
	          
	            case "5": 
	            	//Going back a menu
	            	return;
	      
	            default:
	            	System.out.println("Sorry, that was not a valid response.");
	            	break;
	        }
	    }
	    // Removes a chest from the area if a player moves away from the area
	    Statistics.chest = false;
	    Statistics.location_type = Statistics.map[Statistics.trav_loc_x][Statistics.trav_loc_y];
	    // assigns the saved x and y variables into temporary variables and feeds them into the currentLocation function
	    currentLocation(Statistics.location_type);
	    
	}
	
	// Assigns the locationName variable based off of the current x,y location of the player and stores it to the Statistics class 
	public static void currentLocation(char type)
	{
		
	 
	    //Depending on type, changes location_name to the appropriate title
	    switch (type) 
	    {
	    	case 'W':
	    		Statistics.location_name = "Wilderness";
	    		encounterChance(1);
	    		break;
	    	case 'T':
	    		Statistics.location_name = "Town";
	    		break;
	    	case 'C':
	    		Statistics.location_name = "Cave";
	    		encounterChance(2);
	    		break;
	    }
	    
	    
	    
	    System.out.println("You have arrived at: " + Statistics.location_name);
	  }
	
	public static void encounterChance(int chance)
	{
		Random rn = new Random(); 
		 int BS = rn.nextInt(10);
		 if (BS >= 6 && chance == 1)
		 {
			 //ToolsCombat.combat();
		 }
		 else if (BS >= 2 && chance ==2)
		 {
			 //ToolsCombat.combat();
		 }
		 else if (BS == 1 && (chance == 1 || chance == 2)) 
		 {
			 Statistics.chest = true;
			 System.out.println("There is a chest here!");
			 System.out.println("'Interact' with it to open");
		 }
			 
	}
	
	public static void show_map()
	{
		char last_loc = Statistics.map[Statistics.trav_loc_x][Statistics.trav_loc_y];
		Statistics.map[Statistics.trav_loc_x][Statistics.trav_loc_y] = 'X';
		System.out.printf("~~~~~~~~~~~~~~\n");
		System.out.printf("| %s  %s  %s  %s |\n", Statistics.map[0][0], Statistics.map[1][0], Statistics.map[2][0], Statistics.map[3][0]);
		System.out.printf("| %s  %s  %s  %s |\n", Statistics.map[0][1], Statistics.map[1][1], Statistics.map[2][1], Statistics.map[3][1]);
		System.out.printf("| %s  %s  %s  %s |\n", Statistics.map[0][2], Statistics.map[1][2], Statistics.map[2][2], Statistics.map[3][2]);
		System.out.printf("| %s  %s  %s  %s |\n", Statistics.map[0][3], Statistics.map[1][3], Statistics.map[2][3], Statistics.map[3][3]);
		System.out.printf("~~~~~~~~~~~~~~\n");
		Statistics.map[Statistics.trav_loc_x][Statistics.trav_loc_y] = last_loc;
		
	}
}

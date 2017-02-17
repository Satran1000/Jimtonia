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
	            		Statistics.trav_loc_x = (Statistics.trav_loc_y + 1);
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
	}
	
	public static void show_map()
	{
		
	}
}

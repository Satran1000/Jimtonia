import java.util.Scanner;

public class ToolsInventory 
{
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		
		for( ; ; )
		{      
			open();
			System.out.printf("%s rests to observe their backpack.\n", Statistics.player_name);
			System.out.println("1. Equip");
			System.out.println("2. Go back");

			ch = sc.nextInt(); 	
			sc.nextLine();
	    
			switch(ch)
			{
	    		case 1:
	    			System.out.println("Type the character of an item you have to equip it, if possible, or any other character to exit.");
	    			Scanner sc1 = new Scanner(System.in);
	    			String check = sc1.nextLine();
	    			inventoryCheck(check);
	    			if (Statistics.inventory_check == true) equip(check);
	    			break;
	    		case 2:
	    			return;
	    	}
		}
	}

	public static void open()
	{
		//says this is the player's inventory
		System.out.printf("%s's inventory\n", Statistics.player_name);
		//top of map
	    System.out.printf("~~~~~~~~~~~~~~\n");
	    //references each point of the inventory
	    System.out.printf("| %1s  %1s  %1s  %1s | ~~~~~\n", Statistics.player_inv[0][0], Statistics.player_inv[0][1], Statistics.player_inv[0][2], Statistics.player_inv[0][3]);
	    System.out.printf("| %1s  %1s  %1s  %1s | | %1s |\n", Statistics.player_inv[1][0], Statistics.player_inv[1][1], Statistics.player_inv[1][2], Statistics.player_inv[1][3], Statistics.player_equip);
	    System.out.printf("| %1s  %1s  %1s  %1s | ~~~~~\n", Statistics.player_inv[2][0], Statistics.player_inv[2][1], Statistics.player_inv[2][2], Statistics.player_inv[2][3]);
	    System.out.printf("~~~~~~~~~~~~~~\n");
	    //Shows current potions
	    System.out.printf("Potions S/M/L\n");
	    System.out.printf("%d/%d/%d\n",Statistics.player_potions[0], Statistics.player_potions[1], Statistics.player_potions[2]);
	    //Shows current coins
	    System.out.printf("Coins: %d\n", Statistics.coins);
	    
	}
	
	public static void add(char add)
	{
		//Sets checker boolean
		Statistics.add_check = true;
		//Sets checker count
		int check_count = 0;
		//Scans inventory from left to right, in descending rows
		for (int j = 0; j < 3 ; j++)
			for (int i = 0; i < 4 ; i++)
				//if an empty element is found, the item is put in there
				if (Statistics.player_inv[j][i] == 'X') Statistics.player_inv[j][i] = add;
				//if no empty element is found, check count is increased. If it hits max, that means the inventory is full
				else check_count++;
		//if check count hits max, a false add check can reject the addition
		if (check_count == 12) Statistics.add_check = false;
	}
	
	public static void inventoryCheck(String check)
	{
		//checks if entry is a single character, if not, back to selection
		if (check.length() != 1) main(null);
		//converts a single character string to the character primitive type
		char char_check = check.charAt(0);
		//pre-set inventory checking to false
		Statistics.inventory_check = false;
		//for each element in player_inv, check that it has the item. if one does, then the check returns true
		for (int i = 0; i < 4 ; i++)
			for (int j = 0; j < 3 ; j++)
				if (Statistics.player_inv[j][i] == char_check) Statistics.inventory_check = true;
	}
	
	public static void equip(String check)
	{
		//Swaps the currently equipped item with the targeted item (even if one or both are empty)
		char temp = Statistics.player_equip;
		char char_equip = check.charAt(0);
		Statistics.player_equip = char_equip;
	}
}

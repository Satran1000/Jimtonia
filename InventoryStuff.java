/** Handles all of the Inventory related core functions 
 * Namely, displaying the inventory, and adding an item later*/

public class InventoryStuff
{
  
  public static void main (String[] args)
  {
    displayInv();
  }
  /** Self Explanatory, displays the player's inventory, using temp values to avoid overwriting inventory slots
   * potions are kept in a separate 'pouch' in your inventory, else they would take up a majority of slots and would cause unneccessary bugs 
   */
  static void displayInv()
  {
    //Draws the current inventory 
    
    char[][] inv = MainApp.inv;
    
    //Assigns formatting variables
    char i0_0 = inv[0][0];
    char i1_0 = inv[0][1];
    char i2_0 = inv[0][2];
    char i3_0 = inv[0][3];
    char i0_1 = inv[1][0];
    char i1_1 = inv[1][1];
    char i2_1 = inv[1][2];
    char i3_1 = inv[1][3];
    char i0_2 = inv[2][0];
    char i1_2 = inv[2][1];
    char i2_2 = inv[2][2];
    char i3_2 = inv[2][3];
    
    String temp = MainApp.playerName;
    
    //displays the inventory
    
    System.out.printf("%s's inventory\n", temp);
    System.out.printf("~~~~~~~~~~~~~~\n");
    System.out.printf("| %1s  %1s  %1s  %1s |\n", i0_0, i1_0, i2_0, i3_0);
    System.out.printf("| %1s  %1s  %1s  %1s |\n", i0_1, i1_1, i2_1, i3_1);
    System.out.printf("| %1s  %1s  %1s  %1s |\n", i0_2, i1_2, i2_2, i3_2);
    System.out.printf("~~~~~~~~~~~~~~\n");
    System.out.printf("%d Small Potions\n",MainApp.potions[0]);
    System.out.printf("%d Medium Potions\n",MainApp.potions[1]);
    System.out.printf("%d Large Potions\n",MainApp.potions[2]);
        
    
  }
  
  /** Handles adding items to the player's inventory
   *  Searches for next empty slot, then places item into slot
   */
    static void invAdd(char item)
    {
      for (int i=0; i<3; ++i)
      {
        for (int k=0; k<4; ++k)
        {
          if (MainApp.inv[i][k] == 'X')
          {
        	  MainApp.inv[i][k] = item;
        	  return;
          }
        }
      }
    }
    
    /**
     * Runs a check to see if it's an upgraded weapon for player's class and if so, equips it, buffing damage.
     */
    
    static void weapon(char item)
    {
    	String pClass = MainApp.playerClass;
    	if(MainApp.alreadyEquipped == false)
		{
			if(pClass == "Warrior")
			{
	    		if(item == '0')
	    		{
	    			MainApp.playerStats[0] += 5;
	    			MainApp.alreadyEquipped = true;
	    			//System.out.print("Warrior Equipped!");
	    		}
	    		//System.out.print("Post Equip Warrior");
			}
			if(pClass == "Archer")
			{
				if(item == '&')
	    		{
	    			MainApp.playerStats[0] += 5;
	    			MainApp.alreadyEquipped = true;
	    			//System.out.print("Archer Equipped!");
	    		}
				//System.out.print("Post Equip Archer");
			}
			if(pClass == "Rogue")
			{
				if(item == '!')
	    		{
	    			MainApp.playerStats[0] += 5;
	    			MainApp.alreadyEquipped = true;
	    			//System.out.print("Rogue Equipped!");
	    		}
				//System.out.print("Post Equip Rogue");
			}
	    }
    }
}

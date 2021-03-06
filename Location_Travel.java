import java.util.*;

/** This class is used to allow the player to travel 
 * Handles whether a player can travel in certain circumstances, Random encounters including creature attacks or chest spawns*/
public class Location_Travel {

  public static void main (String[] args)
  { 
    travel();
  }
  
  /** Handles All player travelling stuff */
  public static void travel()
  {
  /** handles whether a player can travel in certain circumstances, such as map borders */
    boolean traveast = true;
    boolean travwest = true;
    boolean travnorth = true;
    boolean travsouth = true;
    
    /** removes a chest if there is a chest present when the player goes to travel, to prevent moving chests, which would be bad*/
    if (MainApp.chest == true)
    {
    	MainApp.chest = false;
    }
    
    /** if player is at border, prevent travel in that direction */
    if (MainApp.travlocx <= 0)
    {
      MainApp.travlocx = 0;
      travwest = false;
    }
    if (MainApp.travlocx >= 3)
    {
      MainApp.travlocx = 3;
      traveast = false;
    }
    if (MainApp.travlocy <= 0)
    {
      MainApp.travlocy = 0;
      travnorth = false;
    }
    if (MainApp.travlocy >= 3)
    {
      MainApp.travlocy = 3;
      travsouth = false;
    }
    
    Boolean isStop = false;
    while (!isStop)
    {
      

      System.out.println("Which direction would you like to travel?");
      if (travnorth == true)
      System.out.println("1. North");
      if (traveast == true)
      System.out.println("2. East");
      if (travsouth == true)
      System.out.println("3. South");
      if (travwest == true)
      System.out.println("4. West");
      System.out.println("5. Back to menu");
      
      Scanner sc = new Scanner(System.in);
      String tempcalc = sc.nextLine();
      
      /** handles the actual movement of the player */
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
            MainApp.travlocy = (MainApp.travlocy - 1);
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
            MainApp.travlocx = (MainApp.travlocx + 1);
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
            MainApp.travlocy = (MainApp.travlocy + 1);
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
            MainApp.travlocx = (MainApp.travlocx - 1);
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
    /** assigns the saved x and y variables into temporary variables and feeds them into the currentLocation function */
    int x = MainApp.travlocx;
    int y = MainApp.travlocy;
    currentLocation(x,y);
  }
  
  /** Assigns the locationName variable based off of the current x,y location of the player and stores it to the MainApp class */
  public static void currentLocation(int x, int y)
  {
	
    /**  W = Wilderness, T = Town, C = Cave. 
     *	{W, 	W, 		W, 		C}
     *	{W, 	T, 		W, 		W}
     *	{C, 	W, 		W, 		W}
     *	{W, 	W, 		T, 		W}
     *
     *	(x,y)
     *              x
     *  {(0,0), (1,0), (2,0), (3,0)}
     *  {(0,1), (1,1), (2,1), (3,1)}
     *y {(0,2), (1,2), (2,2), (3,2)}
     *  {(0,3), (1,3), (2,3), (3,3)}
     */
	      
    int currentcoord = MainApp.loc[x][y];
    /** x,y coords fed into function, and assigns locationName. Also calls the encounterChance function */
    switch (currentcoord) 
    {
      case 'W':
        MainApp.locationname = "Wilderness";
        encounterChance(1);
        break;
      case 'T':
    	  MainApp.locationname = "Town";
        break;
      case 'C':
    	  MainApp.locationname = "Cave";
    	  encounterChance(2);
        break;
    }
    
    
    
    System.out.println("You are currently at: " + MainApp.locationname);
  }
  
  /** Determines whether the player runs into an encounter while travelling 
   * int x, fed into the function from the previous function, determines the likelyhood of having an encounter
   * Caves will give a 80 % chance of an encounter (x = 2)
   * Wilderness will give a 40% chance of an encounter (x = 1)*
   * if the player does not have an encounter, they then have a 50% chance to spawn a chest at the current location
   */
  
  static void encounterChance(int x)
	 {
		 Random rn = new Random(); 
		 int BS = rn.nextInt(10);
		 if (BS >= 6 && x == 1)
		 {
			 Combat.combat();
		 }
		 else if (BS >= 2 && x ==2)
		 {
			 Combat.combat();
		 }
		 else if (BS == 1 && (x == 1 || x == 2)) 
		 {
			 MainApp.chest = true;
			 System.out.println("There is a chest here!");
			 System.out.println("'Interact' with it to open");
		 }
			 
	 }
  
}
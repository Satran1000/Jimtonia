import java.util.*;

public class ShopStuff
{

  
  public static void main (String[] args)
  {
	  enterShop();
  }
  
  static void enterShop()
  {
    System.out.println("You enter the shop.");
    if (MainApp.coins >= 2) System.out.println("The shopkeeper smiles as he hears the coins jingle in your pockets.");
    System.out.println("Keep: 'Good morning, how may I help you today?'");
    System.out.println("1. Buy");
    System.out.println("2. Sell");
    System.out.println("3. Quit");
    Scanner sc = new Scanner(System.in);
    int ch = 0;
    ch = sc.nextInt();  
    sc.nextLine();
       
    switch (ch)
    {
      case 1:
        //Purchase items from the shop with coins
        buyShop();
        break;
 
      case 2:
        // Place Holder for now
        System.out.println("Place Holder");
        break;
 
      case 3:
        //Exits back to the Town
        System.out.println("Keep: 'Come back soon!'");
        return;
   }

 }
  
  static void buyShop()
  {
    System.out.println("Keep: 'Certainly. This is what I have on offer.'");
    System.out.println("1. Small Potion [12 GP]");
    System.out.println("2. Medium Potion [20 GP]");
    
    //Allows third choice to only be relevant to current class
    switch (MainApp.playerClass)
    {
      case "Archer":
        System.out.println("3. Elven Bow [50 GP]");
        break;
 
      case "Rogue":
        System.out.println("3. Obsidian Dagger [50 GP]");
        break;
 
      case "Warrior":
        System.out.println("3. All-Sided Axe [50 GP]");
        break;
   }
   System.out.println("4. Exit");
   
   Scanner sc = new Scanner(System.in);
    int ch = 0;
    ch = sc.nextInt();  
    sc.nextLine();
    //Purchase items from the shop with coins
    switch (ch)
    {
      case 1:
        potionBuy();
        break;
 
      case 2:
        bigPotionBuy();
        break;
 
      case 3:
        weaponBuy(MainApp.playerClass);
        break;
       
      case 4:
        return;
   }
    
  }
  
  static void potionBuy()
  {
    if (MainApp.coins >= 12)
    {
      MainApp.potions[0] = MainApp.potions[0] + 1;
      MainApp.coins = MainApp.coins - 12;
      System.out.println("Thank you kindly!");
    }
    else
    {
      System.out.println("I'm sorry, but you don't appear to have enough money...");
    }
    
  }
  
  static void bigPotionBuy()
  {
    if (MainApp.coins >= 20)
    {
      MainApp.potions[1] = MainApp.potions[1] + 1;
      MainApp.coins = MainApp.coins - 20;
      System.out.println("Thank you kindly!");
    }
    else
    {
      System.out.println("I'm sorry, but you don't appear to have enough money...");
    }
    
  }
  
  static void weaponBuy(String charclass)
  {
    char temp2;
    
    //Chooses specific weapon for assignment to inventory in the case of a purchase
    switch (charclass)
    {
      case "Archer":
        temp2 = '$';
        itemSet(temp2);
        break;
 
      case "Rogue":
        temp2 = '!';
        itemSet(temp2);
        break;
 
      case "Warrior":
        temp2 = '0';
        itemSet(temp2);
        break;
      
   }
   
    
  }
  
  static void itemSet(char item)
  {
	  if (MainApp.coins >= 50)
	    {
	      InventoryStuff.invAdd(item);
	      InventoryStuff.weapon(item);
	      MainApp.coins = MainApp.coins - 50;
	      System.out.println("Thank you kindly!");
	    }
	    else
	    {
	      System.out.println("I'm sorry, but you don't appear to have enough money...");
	    }
  }
}

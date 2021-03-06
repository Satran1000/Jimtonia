
import java.util.*;

/** Handles choice of enemy type during combat, and most combat functions. */
public class Combat
{
  
 public static void main(String[] args)
 {
   combat();
 }
 
 /** the inital function called when combat starts */
 public static void combat() 
 {
   Scanner sc = new Scanner(System.in);
   int ch = 0;
   /** Grabs a random number that is used for randomly selecting an enemy you face */
   Random rn = new Random();   
   /** Sets the Variable that is used in choosing the array */
   int chooseEnemy = rn.nextInt(2);
   for ( int i = 0; i<=3 ; i++ ) 
   {
     /** This loads the chosen enemys stats to the temporary array in the MainApp */
     /** Using the i variable to individually assign the array variables */
     MainApp.enemyStats[i] = EnemyStats.monster[chooseEnemy][i];
     MainApp.enemyName = EnemyStats.monsterName[chooseEnemy];
   }
     
     for ( ; ; )
     {
       /** This is the menu that pops up when you encounter an enemy prompting you to make a decision */
       System.out.println("You Have encountered a " + MainApp.enemyName);
       System.out.println("1. Attack");
       System.out.println("2. Run");
       
       ch = sc.nextInt();  
       sc.nextLine();
       
       switch (ch)
       {
         case 1:
           /** Opens the attack menu */
           attack();
           break;
           
         case 2:
           /** Takes the player back to the game menu */
           MainApp.gameMenu();
           return;
       }
     }
 }
 
 public static void attack()  /** the menu once the player has chosen to attack */
 {
   Random rn = new Random();
   
   Scanner sc = new Scanner(System.in);
   int ch = 0;
   
   for ( ; ; )
   {
     /** Menu prompting the player to make an action */
         System.out.println("What do you choose to do?");
         System.out.println("1. Light Attack");
         System.out.println("2. Strong Attack");
         System.out.println("3. Items");
         System.out.println("4. Inspect");
         System.out.println("5. Run");
         
         ch = sc.nextInt();  
       sc.nextLine();
       /** Calculates a number that determines the hit chance of the players attack */
       int hitChance = rn.nextInt(100);
       /** Calculates a number that determines the hit chance of an enemy attack */
       int enemyHitChance = rn.nextInt(100);
       switch (ch)
       {
         case 1:
           /** Runs CombatAttack.attack function if hitChance is high enough with hit modifier and damage multiplier */
           CombatAttack.attack(hitChance,0,1); //(hitchance, Hitchance mod ( 0 - 100), damage multiplier)
           /** Runs CombatAttack.missordie where it displays text if hitChance is low enough */
           CombatAttack.missordie(hitChance);
           /** Runs CombatAttack.enemyAttack where it runs fully if enemyHitChance is high enough */
           CombatAttack.enemyAttack(enemyHitChance);
           break;
           
         case 2:
           /** Runs CombatAttack.attack function if hitChance is high enough with hit modifier and damage multiplier */
           CombatAttack.attack(hitChance,20,1.3); //(hitchance, Hitchance mod ( 0 - 100), damage multiplier)
           /** Runs CombatAttack.missordie where it displays text if hitChance is low enough */
           CombatAttack.missordie(hitChance);
           /** Runs CombatAttack.enemyAttack where it runs fully if enemyHitChance is high enough */
           CombatAttack.enemyAttack(enemyHitChance);
           break;
           
         case 3:
           /** Opens up the itemMenu function which lets the player interatct with their items */
           potionMenu();
           break;
           
         case 4:
           /** Gives details on the type of enemy you are facing */
           stateCritter();
           break;
           
         case 5:
           /** Takes the player out into the travel screen */
           MainApp.gameMenu();           
           return;
       }
   }
}
 
 /** the potion menu for using potion and whatnot  */
 public static void potionMenu() 
 {
   Scanner sc = new Scanner(System.in);
   int ch = 0;
     
   
   for ( ; ; )
     {
     /** Prints the a list of the potions you can choose from */
     System.out.println("What potion do you want to use?");
     System.out.println("1. Lesser health potion (+2)");
     System.out.println("2. Health potion (+4)");
     System.out.println("3. Strong Health potion (+8)");
     System.out.println("4. Back");
     
     ch = sc.nextInt();  
     sc.nextLine();
     switch (ch)
     {
         /** Potion choice based on input. (potion type, health returned)  */
       case 1:
         potion(0,2);
         break;
         
         /** Potion choice based on input. (potion type, health returned)  */
       case 2:
         potion(1,4);
         break;
         
         /** Potion choice based on input. (potion type, health returned)  */
         case 3:
           potion(2,8);
           break;
         
           /** Return to previous menu */
       case 4:
         return;
           
     }
   }
   
 }
 /** Centralized function for calculating the healing potions do*/
 static void potion(int x, int y)
 {
  if(MainApp.potions[x] >= 1)
  {
    /** This calculates the healing from the potion */ 
    MainApp.playerStats[2] = MainApp.playerStats[2] + y;
    /** This makes sure the healing dosent break the max health ceiling (Main.playerStats[4]) */
    if(MainApp.playerStats[2] > MainApp.playerStats[4])
    {
      MainApp.playerStats[2] = MainApp.playerStats[4];
    }
    /** Deducts one health potion from the inventory */
    MainApp.potions[x] = MainApp.potions[x] - 1;
    System.out.printf("You now have %.0f Health\n", MainApp.playerStats[2]); 
  }
  else if(MainApp.potions[x] <= 0){
    System.out.println("You do not have any " + potType(x) + "s left");}
 }
 /** An array for printing the correct potion names in the print functions */
 static String potType(int x)
 {
   String[] potType = {"Lesser Health potion","Health potion","Strong Health potion"};
   String retVal = potType[x];
   return retVal;   
 }

 /** the post combat sequence, offering the player a choice whether to rest, loot or leave */
 public static void loot() 
 { 
     Scanner sc = new Scanner(System.in);
     int ch = 0;
     
     for ( ; ; )
     {
       System.out.println("Congratulations on defeating the enemy.\nWhat do you want to do next?");
       System.out.println("1. Loot the remains");
       System.out.println("2. Attempt to rest");
       System.out.println("3. Leave");
       
       ch = sc.nextInt();  
       sc.nextLine();
       switch (ch)
       {
         case 1:
           /** Runs the loot functions */
        	 if(MainApp.corpse == true)
        	 {
        		 Looting.lootBody(MainApp.enemyName);
        	 }
           if (MainApp.corpse == false)
           {
             System.out.println("the corpse has nothing left on it!"); 
           }
        	 
           break;
           
         case 2:
           /**Runs the restChance function */
           restChance();
           break;
           
           
         case 3:
           /** Takes you back into the travel menu */
           MainApp.gameMenu();
           return;
       }
     } 
 }
 
 /** describes the enemy that the player is currently facing, listing name and health */
 static void stateCritter()
 {
   System.out.printf("You have encountered a ");
   System.out.printf("%s\n", MainApp.enemyName);
   System.out.printf("the enemy is at ");
   System.out.printf("%.0f",MainApp.enemyStats[2]);
   System.out.printf(" health\n");
   
 }
 
 /** determines whether the player will heal a quarter of their health, or whether they will have an encounter */
 static void restChance()
 {
   Random rn = new Random(); 
   /** Draws a random number used for encounter chance */
   int BS = rn.nextInt(10);
   /** Determines if they player is put into combat based on random chance */
   if (BS <= 2)
   {
     /** Runs combat if chance is low enough */
     Combat.combat();
   }
   else
   {
     /** If the number was high enough the player is healed for 1/4 of their health */
     MainApp.playerStats[2] = MainApp.playerStats[2] + (MainApp.playerStats[4] / 4);  
     if(MainApp.playerStats[2] > MainApp.playerStats[4])
     {
       MainApp.playerStats[2] = MainApp.playerStats[4];
     }
   }  
 }
}

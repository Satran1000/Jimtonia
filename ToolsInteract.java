import java.util.Random;
import java.util.Scanner;

public class ToolsInteract 
{
	public static void interact()
	{
		if (Statistics.chest == true)
		{
			interactChest();
			GameEnviro.main(null);
		}
		else if (Statistics.location_type == 'T')
		{
			interactTown();
		}
		else 
		{
			//ToolsCombat.initiate
		}
	}
	
	public static void interactChest()
	{
		Random rn = new Random(); 
		int chestnum = rn.nextInt(3);
		 
		switch(chestnum)
		{
		case 1:
			System.out.println("Oh no, that chest was a mimic!");
			/*for ( int i = 0; i<=3 ; i++ ) 
			{
				MainApp.enemyStats[i] = EnemyStats.monster[2][i];
				MainApp.enemyName = EnemyStats.monsterName[2];
			}
			MainApp.chest = false;
			Combat.attack();
		 	break;*/
			System.out.println("... But it scrambled away.");
			Statistics.chest = false;
		case 2:
			System.out.println("you found 25 coins inside the chest!");
			Statistics.coins = Statistics.coins + 25;
			Statistics.chest = false;
		 	break;
		case 3:
			System.out.println("You found 2 medium potions in the chest");
			Statistics.player_potions[1] =  Statistics.player_potions[1] + 3;
			Statistics.chest = false;
			break;
		default:
			System.out.println("STOP YOUR RNG BREAKING WIZARDRY");
			break;
		}
	}
	
	public static void interactTown()
	{
		
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		
		for( ; ; )
		{
			
			System.out.println("There appear to be some facilities around");
			System.out.println("1. Shop");
			System.out.println("2. Inn");
			System.out.println("3. Go back");

			ch = sc.nextInt(); 	
			sc.nextLine();
	    
			switch(ch)
			{
	    		case 1:
	    			interactShop();
	    			break;
	    		case 2:
	    			interactInn();
	    			break;
	    		case 3:
	    			return;
	    	}
		}
	}
	
	public static void interactShop()
	{
		System.out.println("Shop Keep: Hello there traveller, are you interested in any wares today?");
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		
		for( ; ; )
		{
			System.out.println("1. Buy");
			System.out.println("2. Sell (placeholder)");
			System.out.println("3. Go back");

			ch = sc.nextInt(); 	
			sc.nextLine();
	    
			switch(ch)
			{
	    		case 1:
	    			interactShopBuy();
	    			break;
	    		case 2:
	    			interactShopSell();
	    			break;
	    		case 3:
	    			return;
	    	}
		}
	}
	
	public static void interactShopBuy()
	{
		System.out.println("Shop Keep: We have the following items today. Just type the character of the desired item. ");
		System.out.println("Shop Keep: Oh, and don't ask about that wall there, the other three are fine, but the fourth is ");
		System.out.println("Shop Keep: a little broken");		
	}
	
	public static void interactShopSell()
	{
		System.out.println("Didn't I say this was a placeholder? You turd.");
		return;
	}
	
	public static void interactInn()
	{
		
	}
}

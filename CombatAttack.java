public class CombatAttack {


  /** This is when the player does an attack action from the combat class
    * The variables inputted from the function included the chance to hit (int hitChance = rn.nextInt(100);
    * The modifier to the hit chnce (if any)
    * And the damage modifier (if any) */
	
  public static void attack(int hitChance, int hitChancemod, double damageMod)
  {
	  /** If the player's chance of hitting - the chance modifier (Strong attacks only) is greater than or equal to the Enemy's evasion statistic */
    if((hitChance - hitChancemod) >= MainApp.enemyStats[1])
    {
    /** Enemy Health = Enemy health - (player's attack stat multiplied by the damage modifier(normal attack = 1, strong attack = 1.25)) - enemy's flat defense value */
      MainApp.enemyStats[2] = MainApp.enemyStats[2] - ((MainApp.playerStats[0] * damageMod) - MainApp.enemyStats[3]);
      System.out.printf("You Damaged the %s\n", MainApp.enemyName);
    }
  }
  /** This function runs when the players hit chance is lower than the enemies defence */
  public static void missordie(int hitChance)
  {
    if(hitChance < MainApp.enemyStats[1])
    {
      System.out.printf("You Missed\n");}
    if(MainApp.enemyStats[2] <=0)
    {
      System.out.printf("The %s has died\n", MainApp.enemyName);
      MainApp.corpse = true;
      Combat.loot();
    }
  }
  /** This code is basically the same as the attack function
    * but without a hit modifier and damage modifier
    * to make the enemies attacks more simplified */
  
  public static void enemyAttack(int enemyHitChance)
  {
	/** if the enemy is alive */
    if(MainApp.enemyStats[2] >=1)
    {
      /** if the enemy's hit chance is greater than or equal to the player's evasion stat*/
      if(enemyHitChance >= MainApp.playerStats[1])
      {
      /** Player Health = player health - (enemy attack - player flat defense value)*/
        MainApp.playerStats[2] = MainApp.playerStats[2] - (MainApp.enemyStats[0] - MainApp.playerStats[3]);
        System.out.printf("The %s Hits You, You are on %.0f \n", MainApp.enemyName, MainApp.playerStats[2]);
        /** if player health is less than or equal to 0, player is dead, returns to main menu */
        if(MainApp.playerStats[2] <= 0)
        {
          System.out.printf("You Died!!!!\n");
          MainApp.mainMenu();
        }
      }
      /** If enemy hitchance is less than player evasion, then the enemy missed */
      else if(enemyHitChance < MainApp.playerStats[1])
      {
        System.out.printf("The %s Missed\n", MainApp.enemyName);
      }
    }
  }
}

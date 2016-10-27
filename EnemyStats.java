/** Holds all of the enemy statistics in a central location */
public class EnemyStats
{
  public static String[] monsterName = {"rat", "ogre","mimic"};
  public static double[] rat = {6, 30, 10, 0};  //[0] = attack  [1] = evasion  [2] = health  [3] = armor
  public static double[] ogre = {9, 10, 20, 3};  //[0] = attack  [1] = evasion  [2] = health  [3] = armor
  public static double[] mimic = {15, 25, 15, 2}; //[0] = attack  [1] = evasion  [2] = health  [3] = armor
  public static double[] monster []= {rat, ogre, mimic};
}

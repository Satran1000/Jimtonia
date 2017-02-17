public class Statistics 
{
	public static String player_name; //The name chosen by the player
	public static String player_race; //The race chosen by the player
	public static String player_class; //The class chosen by the player
	
	public static int trav_loc_x; //The player's current Latitude
	public static int trav_loc_y; //The player's current Longitude
	public static String location_type; //The type of area the player is currently located
	
	public static int[] player_stats = {0, 0, 0, 0, 0}; //array to keep player stats (HP, Max HP, ARM, ATK, EVA)
	public static char[][] player_inv = 
		{
			{'X', 'X', 'X', 'X'}, 
			{'X', 'X', 'X', 'X'}, //Oh look, neatness
			{'X', 'X', 'X', 'X'}  //The inventory used to contain items
		}; 
	public static char player_equip;
	public static int[] player_potions = {0, 0, 0}; //The inventory used to specify current number of potions
	public static int coins = 10; //The number of coins held 
	
	public static char[][] map = 
		{
			{'W', 'W', 'W', 'C'}, 
			{'W', 'T', 'W', 'W'}, //Oh look, neatness
			{'C', 'W', 'W', 'W'},
			{'W', 'W', 'T', 'W'}  //The current map of the game
		}; 

	//Creature rat = new Creature("5, 5, 0, 3, 6"); //creating Rats
}

import java.util.Random;

public class ToolsCombat 
{
	public static void main(String[] args)
	{
		
	}

	public static void initiate()
	{
		
	}
	
	public static void encounter()
	{
		 Random rn = new Random(); //EC For Encounter Chance naturally. 
		 int EC = rn.nextInt(100); // Outta 100 makes it easier to spread out RNG related stuff later down the line.
		 
		 if (EC >= 66 && Statistics.location_type == 'W')
		 {
			 if (EC >= 90)
			 {
				 Creature Ogre = new Creature(5,5,5,5,5,"NOTJIM");
				 /*All pseudo BS from here
				 if(EC >= 98)
				 	{
				 		Creature Ogre2 = new Creature(5,5,5,5,5."ALSONOTJIM");
				 		Ogre.name += " 1"; // For if generically named, maybe slap if statement to determine between important/notimportant critters?
				 		Ogre2.name += " 2"; // Not naming the first one as "Ogre 1" originally incase there is only one ogre
				 		Ogre2 = enemy_2;
				 	}
				 Ogre = enemy_1;
				 Fight(); // Put a variable on here to determine whether you or the critter gets an early hit in? or neither? RNG for encounter?
				 */
			 }
			 else if (EC >= 66)
			 {
				 Creature Rat = new Creature(5,5,5,5,5,"NOTJIM'SPET");
				 // Another bit like above but for up to 3 or 4 rats for instance.
				 // Fight();
			 }
		 }
		 else if (EC == 50)
		 {
			 Creature MirrorJim = new Creature(Statistics.player_stats[0],Statistics.player_stats[0],Statistics.player_stats[2],Statistics.player_stats[3],Statistics.player_stats[4],Statistics.player_name);
			 //MirrorJim = enemy_1 //health starts maxed incase player is injured, just cause fuck you.
		     // Fight();
		 }

	}
}

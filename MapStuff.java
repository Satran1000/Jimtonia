public class MapStuff
{
   
  
  
  public static void main (String[] args)
  {
    displaymap();
  }
  
  static void displaymap()
  {
    
    char[][] loc = MainApp.loc;
    
    int x = MainApp.travlocx;
    int y = MainApp.travlocy;
    
    // Assign x,y to second variable. 
    char lastloc = loc[x][y];
    loc[x][y] = 'X';
    
    char e0_0 = loc[0][0];
    char e1_0 = loc[1][0];
    char e2_0 = loc[2][0];
    char e3_0 = loc[3][0];
    char e0_1 = loc[0][1];
    char e1_1 = loc[1][1];
    char e2_1 = loc[2][1];
    char e3_1 = loc[3][1];
    char e0_2 = loc[0][2];
    char e1_2 = loc[1][2];
    char e2_2 = loc[2][2];
    char e3_2 = loc[3][2];
    char e0_3 = loc[0][3];
    char e1_3 = loc[1][3];
    char e2_3 = loc[2][3];
    char e3_3 = loc[3][3];

    System.out.printf("The Map of Jimtonia    ______________\n");
    System.out.printf("W = Wilderness         | %1s  %1s  %1s  %1s |\n", e0_0, e1_0, e2_0, e3_0);
    System.out.printf("T = Town               | %1s  %1s  %1s  %1s |\n", e0_1, e1_1, e2_1, e3_1);
    System.out.printf("C = Cave               | %1s  %1s  %1s  %1s |\n", e0_2, e1_2, e2_2, e3_2);
    System.out.printf("X = You are Here       | %1s  %1s  %1s  %1s |\n", e0_3, e1_3, e2_3, e3_3);
    System.out.printf("                       ŻŻŻŻŻŻŻŻŻŻŻŻŻŻ\n");
    
    // Recall second variable after displaying, so the map doesn't get X'd out.
    MainApp.loc[x][y] = lastloc;
  }
  

}

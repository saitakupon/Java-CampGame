public class Scene extends Player {

  public static void clearScene() {
    System.out.print("\n\n\n\n\n\n\n\n\n\n");
    System.out.print("\n\n\n\n\n\n\n\n\n\n");
    System.out.print("\n\n\n\n\n\n\n\n\n\n");
  }

  public static void startScene() {
    System.out.println("\n      *****************************\n      |                           |");
    System.out.println("      |       〜CAMP GAME〜       |\n      |                           |\n      |          START！          |");
    System.out.println("      |                           |\n      *****************************\n");
  }

  public static void gameScene(int mode, int area[][]) {
    clearScene();
    if (mode == 0) System.out.print(" ○：Player1\n ●：CPU\n\n\n");
    else System.out.print(" ○：Player1\n ●：Player2\n\n\n");
    for (int ii = 0; ii < 8; ii++) {
      System.out.print("            ");
      if (ii % 2 == 0) {
        int i = ii / 2;
        for (int j = 0; j < 4; j++) {
          if (area[i][j] == 0) {
            if (i == 0 && j == 0) {
              System.out.print("    ");
            } else if (i == 0 && j > 0) {
              System.out.print(j + "   ");
            } else if (j == 0 && i > 0) {
              System.out.print(i + " | ");
            } else {
              System.out.print("  | ");
            }
          }
          else if (area[i][j] == 1) System.out.print("○ | ");
          else System.out.print("● | ");
        }
      } else {
        System.out.print("   ーーーーーー");
      }
      System.out.println();
    }
    System.out.println();
    System.out.println("-----------------------------------------\n\n\n\n\n");
  }

  public static void resultScene(int mode, int playerNum, int area[][]){
    if (win(area)) {
      if (playerNum == 1) System.out.println(" WINNER：Player1！");
      else {
        if (mode == 0) System.out.println(" WINNER：CPU！");
        else System.out.println(" WINNER：Player2！");
      }
    }
    else System.out.println(" DRAW GAME");
  }

}

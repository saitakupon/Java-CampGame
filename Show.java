import java.util.Scanner;

public class Show {

  public static void clear() {
    System.out.print("\n\n\n\n\n\n\n\n\n\n");
    System.out.print("\n\n\n\n\n\n\n\n\n\n");
    System.out.print("\n\n\n\n\n\n\n\n\n\n");
  }

  public static int startScene() {
    Scanner stdIn = new Scanner(System.in);
    System.out.println("\n      *****************************\n      |                           |");
    System.out.println("      |       〜CAMP GAME〜       |\n      |                           |\n      |          START！          |");
    System.out.println("      |                           |\n      *****************************\n");
    System.out.print("         Please Choose the Mode.\n\n           \'0\'-> CPU Mode\n           \'1\'-> Player Mode\n\n");
    boolean modeCheck = false;
    int mode = -1;
    while(!modeCheck) {
      System.out.print("                    ");
      String modeStr = stdIn.next();
      try {
        mode = Integer.parseInt(modeStr);
      } catch(Exception e) {}
      if (mode == 0 || mode == 1) modeCheck = true;
      else System.out.println("         Please Enter \'0\' or \'1\'.");
    }
    return mode;
  }

  public static int turn(int turn) {
    turn++;
    System.out.print(" Turn：" + turn);
    return turn;
  }

  public static void campArea(int mode, int area[][]) {
    clear();
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
    if (Check.win(area)) {
      if (playerNum == 1) System.out.println(" WINNER：Player1！");
      else {
        if (mode == 0) System.out.println(" WINNER：CPU！");
        else System.out.println(" WINNER：Player2！");
      }
    }
    else System.out.println(" DRAW GAME");
  }

}

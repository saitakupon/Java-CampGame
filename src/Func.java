import java.util.Scanner;
import java.util.Random;

public class Func extends Scene {

  public static int getRandPlayerNum() {
    Random rand = new Random();
    return rand.nextInt(2) + 1;
  }

  public static int getMode() {
    Scanner stdIn = new Scanner(System.in);
    System.out.print("         Please Choose the Mode.\n\n           \'0\'-> CPU Mode\n           \'1\'-> Player Mode\n\n");
    boolean modeCheck = false;
    int mode = -1;
    while(!modeCheck) {
      System.out.print("                   ");
      String modeStr = stdIn.next();
      try {
        mode = Integer.parseInt(modeStr);
      } catch(Exception e) {}
      if (mode == 0 || mode == 1) modeCheck = true;
      else System.out.println("         Please Enter \'0\' or \'1\'.");
    }
    return mode;
  }

  public static int changeTurn(int turn) {
    turn++;
    System.out.print(" Turn：" + turn);
    return turn;
  }

  public static int changePlayerNum(int playerNum) {
    if (playerNum == 1) return 2;
    else return 1;
  }

}

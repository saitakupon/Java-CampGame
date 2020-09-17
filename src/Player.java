import java.util.Scanner;

public class Player extends Move {

  public static void cpu(int turn, int playerNum, int area[][]) {
    if (turn < 9) {
      try {
        System.out.print(" CPU \n Thinking");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".\n");
      } catch(InterruptedException e) {
          e.printStackTrace();
      }
    } else {
      try {
        System.out.print(" CPU \n There's only one place you can put it.");
        Thread.sleep(1000);
      } catch(InterruptedException e) {
          e.printStackTrace();
      }
    }
    if (turn % 2 == 1) {
      switch(turn) {
        case 1:
          putCenter(area);
          break;
        case 3:
          putCorner(area);
          break;
        case 5:
          if (reach(area)) putReachPoint(area);
          else putWinningPoint(area);
          break;
        case 7:
        case 9:
          if (reach(area)) putReachPoint(area);
          else putBlankPoint(area, playerNum);
          break;
      }
    } else {
      switch(turn) {
        case 2:
          if (center(area) == 0) putCenter(area);
          else putCorner(area);
          break;
        case 4:
          if (reach(area)) putReachPoint(area);
          else if (center(area) == 1) putCorner(area);
          else if (center(area) == 2) putLinear(area);
          break;
        case 6:
        case 8:
          if (reach(area)) putReachPoint(area);
          else putBlankPoint(area, playerNum);
          break;
      }
    }
  }

  public static void human(int turn, int playerNum, int area[][]) {
    Scanner stdIn = new Scanner(System.in);
    System.out.println(" Player" + playerNum);
    boolean putCheck = false;
    if (turn == 9) {
      try {
        System.out.println(" There's only one place you can put it.");
        putBlankPoint(area, playerNum);
        Thread.sleep(1000);
      } catch(InterruptedException e) {
          e.printStackTrace();
      }
    } else {
      while(putCheck == false) {
        System.out.print(" Please enter a place to put it. (x,y)：");
        String s = stdIn.next();
        String [] position =s.split(",", 0);
        int x, y;
        try {
          x = Integer.parseInt(position[0]);
          y = Integer.parseInt(position[1]);
        } catch(Exception e) {
          x = 0;
          y = 0;
        }
        if (x > 3 || y > 3 ||  x < 1 || y < 1) System.out.println(" Illegal.");
        else if (area[y][x] != 0) System.out.println(" It has already been put there.");
        else {
          area[y][x] = playerNum;
          putCheck = true;
        }
      }
    }
  }

  public static void updateArea(int mode, int turn, int playerNum, int area[][]) {
    if (mode == 0) {
      if (playerNum == 1) human(turn, playerNum, area);
      else cpu(turn, playerNum, area);
    }
    else human(turn, playerNum, area);
  }

}

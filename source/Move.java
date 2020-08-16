import java.util.Scanner;

public class Move {

  public static int[][] putBlankPoint(int area[][], int playerNum) {
    CHECK: for (int i = 1; i < 4; i++) {
      for (int j = 1; j < 4; j++) {
        if (area[i][j] == 0) {
          area[i][j] = playerNum;
          break CHECK;
        }
      }
    }
    return area;
  }

  public static int[][] putCenter(int area[][]) {
    area[2][2] = 2;
    return area;
  }

  public static int[][] putCorner(int area[][]) {
    if (area[1][1] == 0) area[1][1] = 2;
    else if (area[1][3] == 0) area[1][3] = 2;
    else if (area[3][1] == 0) area[3][1] = 2;
    else area[3][3] = 2;
    return area;
  }

  public static int[][] putLinear(int area[][]) {
    if (area[2][1] == 0) area[2][1] = 2;
    else if (area[1][2] == 0) area[1][2] = 2;
    else if (area[3][2] == 0) area[3][2] = 2;
    else area[2][3] = 2;
    return area;
  }

  public static int[][] putReachPoint(int area[][]) {
    CHECK: for (int i = 1; i < 4; i++) {
      for (int j = 1; j < 4; j++) {
        if (area[i][j] == 0) {
          area[i][j] = 1;
          if (Check.win(area)) {
            area[i][j] = 2;
            break CHECK;
          }
          area[i][j] = 2;
          if (Check.win(area)) break CHECK;
          area[i][j] = 0;
        }
      }
    }
    return area;
  }

  public static int[][] putWinningPoint(int area[][]) {
    if ((area[1][3] == 2 && area[2][3] == 1) || (area[3][1] == 2 && area[3][2] == 1)) area[1][1] = 2;
    else if ((area[1][1] == 2 && area[2][1] == 1) || (area[3][3] == 2 && area[3][2] == 1)) area[1][3] = 2;
    else if ((area[3][3] == 2 && area[2][3] == 1) || (area[1][1] == 2 && area[1][2] == 1)) area[3][1] = 2;
    else if ((area[3][1] == 2 && area[2][1] == 1) || (area[1][3] == 2 && area[1][2] == 1)) area[3][3] = 2;
    return area;
  }

  public static int[][] cpu(int turn, int playerNum, int area[][]) {
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
          area = putCenter(area);
          break;
        case 3:
          area = putCorner(area);
          break;
        case 5:
          if (Check.reach(area)) area = putReachPoint(area);
          else area = putWinningPoint(area);
          break;
        case 7:
        case 9:
          if (Check.reach(area)) area = putReachPoint(area);
          else area = putBlankPoint(area, playerNum);
          break;
      }
    } else {
      switch(turn) {
        case 2:
          if (Check.center(area) == 0) area = putCenter(area);
          else area = putCorner(area);
          break;
        case 4:
          if (Check.reach(area)) area = putReachPoint(area);
          else if (Check.center(area) == 1) area = putCorner(area);
          else if (Check.center(area) == 2) area = putLinear(area);
          break;
        case 6:
        case 8:
          if (Check.reach(area)) area = putReachPoint(area);
          else area = putBlankPoint(area, playerNum);
          break;
      }
    }
    return area;
  }

  public static int[][] human(int turn, int playerNum, int area[][]) {
    Scanner stdIn = new Scanner(System.in);
    System.out.println(" Player" + playerNum);
    boolean putCheck = false;
    if (turn == 9) {
      try {
        System.out.println(" There's only one place you can put it.");
        area = putBlankPoint(area, playerNum);
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
    return area;
  }

  public static int[][] area(int mode, int turn, int playerNum, int area[][]) {
    if (mode == 0) {
      if (playerNum == 1) area = human(turn, playerNum, area);
      else area = cpu(turn, playerNum, area);
    }
    else area = human(turn, playerNum, area);
    return area;
  }

}

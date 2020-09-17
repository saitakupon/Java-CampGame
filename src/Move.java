import java.util.Scanner;

public class Move extends Check {

  public static void putBlankPoint(int area[][], int playerNum) {
    CHECK: for (int i = 1; i < 4; i++) {
      for (int j = 1; j < 4; j++) {
        if (area[i][j] == 0) {
          area[i][j] = playerNum;
          break CHECK;
        }
      }
    }
  }

  public static void putDirected(int area[][], int playerNum) {
    Scanner stdIn = new Scanner(System.in);
    boolean putCheck = false;
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

  public static void putCenter(int area[][]) {
    area[2][2] = 2;
  }

  public static void putCorner(int area[][]) {
    if (area[1][1] == 0) area[1][1] = 2;
    else if (area[1][3] == 0) area[1][3] = 2;
    else if (area[3][1] == 0) area[3][1] = 2;
    else area[3][3] = 2;
  }

  public static void putLinear(int area[][]) {
    if (area[2][1] == 0) area[2][1] = 2;
    else if (area[1][2] == 0) area[1][2] = 2;
    else if (area[3][2] == 0) area[3][2] = 2;
    else area[2][3] = 2;
  }

  public static void putReachPoint(int area[][]) {
    CHECK: for (int i = 1; i < 4; i++) {
      for (int j = 1; j < 4; j++) {
        if (area[i][j] == 0) {
          area[i][j] = 1;
          if (win(area)) {
            area[i][j] = 2;
            break CHECK;
          }
          area[i][j] = 2;
          if (win(area)) break CHECK;
          area[i][j] = 0;
        }
      }
    }
  }

  public static void putWinningPoint(int area[][]) {
    if ((area[1][3] == 2 && area[2][3] == 1) || (area[3][1] == 2 && area[3][2] == 1)) area[1][1] = 2;
    else if ((area[1][1] == 2 && area[2][1] == 1) || (area[3][3] == 2 && area[3][2] == 1)) area[1][3] = 2;
    else if ((area[3][3] == 2 && area[2][3] == 1) || (area[1][1] == 2 && area[1][2] == 1)) area[3][1] = 2;
    else if ((area[3][1] == 2 && area[2][1] == 1) || (area[1][3] == 2 && area[1][2] == 1)) area[3][3] = 2;
  }

}

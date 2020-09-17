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

public class Check {

  public static boolean win(int area[][]) {
    boolean win = false;
    for (int i = 1; i < 4; i++) {
      if ((area[i][1] == area[i][2] && area[i][2] == area[i][3] && (area[i][1] == 1 || area[i][1] == 2)) ||
      (area[1][i] == area[2][i] && area[2][i] == area[3][i] && (area[1][i] == 1 || area[1][i] == 2))) {
        win = true;
      }
    }
    if ((area[3][3] == area[1][1] && area[1][1] == area[2][2] && (area[3][3] == 1 || area[3][3] == 2)) ||
    (area[3][1] == area[2][2] && area[2][2] == area[1][3] && (area[3][1] == 1 || area[3][1] == 2))) {
      win = true;
    }
    return win;
  }

  public static boolean reach(int area[][]) {
    int reachNum = 0;
    for (int i = 1; i < 4; i++) {
      for (int j = 1; j < 4; j++) {
        if (area[i][j] == 0) {
          area[i][j] = 1;
          if (win(area)) reachNum++;
          area[i][j] = 2;
          if (win(area)) reachNum++;
          area[i][j] = 0;
        }
      }
    }
    if (reachNum > 0) return true;
    else return false;
  }

  public static int center(int area[][]) {
    if (area[2][2] == 0) return 0;
    else if (area[2][2] == 1) return 1;
    else return 2;
  }

  public static boolean end(int area[][]) {
    int zeroNum = 0;
    for (int i = 1; i < 4; i++) {
      for (int j = 1; j < 4; j++) {
        if (area[i][j] == 0) zeroNum++;
      }
    }
    if (zeroNum == 0) return true;
    else return false;
  }

}

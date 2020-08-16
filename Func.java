import java.util.Random;

public class Func {

  public static int randomPlayerNum() {
    Random rand = new Random();
    return rand.nextInt(2) + 1;
  }

  public static int changePlayerNum(int playerNum) {
    if (playerNum == 1) return 2;
    else return 1;
  }

}

public class CampGame {

  public static void main(String[] args) {
    //キャンプエリアを用意
    int area[][] = new int[4][4];
    //プレイヤー順をランダムにセット
    int playerNum = Func.randomPlayerNum();
    //ターン数を初期化
    int turn = 0;
    //スタート画面の表示
    int mode = Show.startScene();
    //キャンプエリアの表示
    Show.campArea(mode, area);
    //勝敗が決まるまでループ
    while (!Check.win(area)) {
      //ターン数の表示
      turn = Show.turn(turn);
      //プレイヤーのスイッチ
      playerNum = Func.changePlayerNum(playerNum);
      //キャンプエリアの移動
      area = Move.area(mode, turn, playerNum, area);
      //キャンプエリアの表示
      Show.campArea(mode, area);
      //フィールドが全て埋まったらループを抜ける
      if (Check.end(area)) break;
    }
    //リザルト画面の表示
    Show.resultScene(mode, playerNum, area);
  }
  
}

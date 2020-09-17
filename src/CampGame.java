public class CampGame extends Func {

  public static void main(String[] args) {
    //キャンプエリアを用意
    int area[][] = new int[4][4];
    //プレイヤー順をランダムにセット
    int playerNum = getRandPlayerNum();
    //ターン数を初期化
    int turn = 0;
    //スタート画面の表示
    startScene();
    //モード選択
    int mode = getMode();
    //キャンプエリアの表示
    gameScene(mode, area);
    //勝敗が決まるまでループ
    while (!win(area)) {
      //ターン数の表示
      turn = changeTurn(turn);
      //プレイヤーのスイッチ
      playerNum = changePlayerNum(playerNum);
      //キャンプエリアの更新
      updateArea(mode, turn, playerNum, area);
      //キャンプエリアの表示
      gameScene(mode, area);
      //フィールドが全て埋まったらループを抜ける
      if (end(area)) break;
    }
    //リザルト画面の表示
    resultScene(mode, playerNum, area);
  }

}

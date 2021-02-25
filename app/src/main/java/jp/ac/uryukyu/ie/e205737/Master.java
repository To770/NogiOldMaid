package jp.ac.uryukyu.ie.e205737;

import java.util.ArrayList;

/**
 * ババ抜きのゲームマスターを表すクラス
 */
public class Master {
    /**プレイヤーのリスト */
    private ArrayList players = new ArrayList();

    public void preparGame(Hand cards){
     /**System.out.println("『設楽』\n ドンッ！！\n さぁ始まりました！乃木坂工事中スペシャル！\n 司会のバナナマンですよろしくお願いします！\n 日村さん本日の予定をお願いします。\n");
        System.out.println("『日村』\n 乃木坂46ババ抜き最弱女王決定戦！\n");
        System.out.println("『設楽』\n と言うことで、早速始めていきましょう！\n それではカードを配ります。\n"); */
        
        //トランプをシャッフルする
        cards.shuffle();

        //トランプの枚数を取得
        int numberOfCards = cards.getNumverOfHandCards();

        //プレイヤーの人数を取得
        int numberOfPlayers = players.size();

        for(int index = 0; index < numberOfCards; index++){
            //カードから一枚引く
            Card card = cards.pickCard();

            //各プレイヤーに順番にカードを配る
            Player player = (Player) players.get(index % numberOfPlayers);
            player.receiveCard(card);
        }
    }

    /**
     * ゲームマスターがゲーム開始を宣言し、ゲームを開始するメソッド
     */
    public void startGame(){
        System.out.println("『ババ抜きを開始します』");

        //プレイヤーの人数を取得
        for(int count = 0; players.size() > 1; count++){
            int playerIndex = count % players.size();
            int nextPlayerIndex = (count + 1) % players.size();

            //指名するプレイヤーの取得
            Player player = (Player) players.get(playerIndex);

            //次のプレイヤーの取得
            Player nextPlayer = (Player) players.get(nextPlayerIndex);

            //プレイヤーを指名する
            System.out.println("\n" + player + "の番です。");
            player.Play(nextPlayer);
        }
        //プレイヤーが最後の1人になるとループを抜ける
        System.out.println("『ババ抜きを終了しました』");
    }

    /**
     * 上りを宣言するメソッド
     * 
     * @param 上がったプレイヤー
     */
    public void declareWin(Player winner){
        
        //上がったプレイヤー
        System.out.println(winner + "が上がりました!");

        //上がったプレイヤーをリストから外す
        players.remove(players.indexOf(winner));

        //残りプレイヤーが1人になると敗者を表示する
        if(players.size() == 1){
            Player loser = (Player) players.get(0);
            System.out.println(loser + "の負けです");
        /** System.out.println("『設楽』\n 乃木坂46 ババ抜き最弱女王は" + loser + "です！");
            System.out.println(loser + "弱いから"  + "罰ポイント＋２ね" ); */
        }
    }

    /**
     * ゲームに参加するプレイヤーを追加するメソッド
     * 
     * @param 参加するプレイヤー
     */
    public void registerPlayer(Player player){
        
        //リストに参加者を登録
        players.add(player);
    }
}

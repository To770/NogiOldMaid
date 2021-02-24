import java.lang.reflect.Field;

import jp.ac.uryukyu.ie.e205737.Card;
import jp.ac.uryukyu.ie.e205737.Hand;
import jp.ac.uryukyu.ie.e205737.Master;
import jp.ac.uryukyu.ie.e205737.Player;
import jp.ac.uryukyu.ie.e205737.Table;

/**
 * ババ抜きをするメインクラス
 */
public class Main {
    public static void main(String[] args){
        
        //ゲームマスターの生成
        Master master = new Master();

        //場の生成
        Table table = new Table();

        //プレイヤーの生成
        Player nishino = new Player("西野", master, table);
        Player shiraishi = new Player("白石", master, table);
        Player ikuta = new Player("生田", master, table);
        Player saito = new Player("齋藤", master, table);
        Player hashimoto = new Player("橋本", master, table);
        
        //ゲームマスターに参加プレイヤーを報告
        master.registerPlayer(nishino);
        master.registerPlayer(shiraishi);
        master.registerPlayer(ikuta);
        master.registerPlayer(saito);
        master.registerPlayer(hashimoto);

        //トランプの生成
        Hand trump = createTrump();

        //ゲームの準備
        master.preparGame(trump);

        //ゲーム開始
        master.startGame();
    }

    private static Hand createTrump(){
        Hand trump = new Hand();

        for(int number = 1; number < 13; number++){
            trump.addCard(new Card(Card.SUIT_SPADE, number));
            trump.addCard(new Card(Card.SUIT_DIAMOND, number));
            trump.addCard(new Card(Card.SUIT_CLUB, number));
            trump.addCard(new Card(Card.SUIT_HEART, number));   
        }

        //ジョーカーの生成
        trump.addCard(new Card(0, Card.JOKER));

        return trump;
    }

}

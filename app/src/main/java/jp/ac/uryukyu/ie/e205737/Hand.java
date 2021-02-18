package jp.ac.uryukyu.ie.e205737;

import java.util.ArrayList;


/**
 * ババ抜きの手札を表すクラス
 */
public class Hand {
    
    /**手札のカードを入れるリスト
     * 
     */
    private ArrayList hand_ = new ArrayList();


    /**
     * カードを手札に加えるメソッド
     * @param _card　加えるカード
     */
    public void addCard(Card _card){
         
        //カードをリストの一番後ろに追加
        hand_.add(_card);
    }

    /**
     * カードを引くメソッド
     * @return 引いたカード
     */
    public Card pickCard(){
        Card pickedCard = (Card) hand_.remove(0);

        return pickedCard;
    }

    /**
     * 手持ちのカードをシャッフルするメソッド
     */
    public void shuffle(){

    }

    public int getNumverOfHandCards(){
        return hand_.size();
    }
}

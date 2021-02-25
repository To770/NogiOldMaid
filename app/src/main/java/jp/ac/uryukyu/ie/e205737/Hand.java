package jp.ac.uryukyu.ie.e205737;

import java.util.ArrayList;


/**
 * ババ抜きの手札を表すクラス
 */
public class Hand {
    
    /**手札のカードを入れるリスト
     * 
     */
    private ArrayList<Card> hand = new ArrayList<Card>();


    /**
     * カードを手札に加えるメソッド
     * @param _card　加えるカード
     */
    public void addCard(Card _card){
         
        //カードをリストの一番後ろに追加
        hand.add(_card);
    }

    /**
     * カードを引くメソッド
     * @return 引いたカード
     */
    public Card pickCard(){
        Card pickedCard = (Card) hand.remove(0);

        return pickedCard;
    }

    /**
     * 手持ちのカードをシャッフルするメソッド
     */
    public void shuffle(){
        //手札の枚数を取得
        int number = hand.size();

        //カードを抜き出す位置
        int position;

        //カードをランダムに抜き取り、最後に加える動作を繰り返す
        for(int count = 0; count < number * 2; count++ ){
            //ランダムな位置から一枚抜きとる
            position = (int) (Math.random() * number);
            Card pickedCard = (Card) hand.remove(position);

            //抜き取ったカードを最後に加える
            hand.add(pickedCard);

        }

    }

    /**
     * 手札のカードの枚数を数えるメソッド
     * @return　手札のカードの枚数
     */
    public int getNumverOfHandCards(){
        return hand.size();
    }

    /**
     * 同じ数のカードを探すメソッド
     * 
     * @return 同じ数字のカード
     */
    public Card[] findSameNumberCards(){
        int numberOfCards = hand.size();
        Card[] sameCards = null;

        //手札にカードが一枚もない場合は何もしない
        if(numberOfCards > 0){

            //最後に追加されたカードを取得
            int lastIndex = numberOfCards - 1;
            Card lastAddedCard = (Card) hand.get(lastIndex);

            //最後に追加されたカードの数字を取得
            int lastAddedCardNumber = lastAddedCard.getNumber();

            for(int index = 0; index < lastIndex; index++){
                Card card = (Card) hand.get(index);
                if(card.getNumber() == lastAddedCardNumber){
                    
                    //最後に追加されたカードと同じ数字が見つかると、その組み合わせをsameCardsに格納しループを抜ける
                    sameCards = new Card[2];
                    sameCards[0] = (Card) hand.remove(lastIndex);
                    sameCards[1] = (Card) hand.remove(index);

                    break;
                }
                //同じ組み合わせがない時にはsameCardsはnullのまま
            }
        }

        return sameCards;
    }

    /**
     * 手札を文字列で返すメソッド
     * 
     * @return　手札のカードの文字列表現
     */

     public String toString(){
        StringBuffer string = new StringBuffer();

        int size = hand.size();
        if(size > 0){
            for(int index = 0; index < size; index++){
                Card card = (Card) hand.get(index);
                string.append(card);
                string.append(" ");
            }
        }

        return string.toString();

     }
}

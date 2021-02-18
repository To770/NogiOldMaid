package jp.ac.uryukyu.ie.e205737;

/**
 * トランプのカード全体を表すクラス
 */
public class Card {
    
    /**ジョーカーを表す定数 */
    private static final int JOKER = 0;

    /**スペードを表す定数 */
    private static final int SUIT_SPADE = 1;

    /**ダイヤを表す定数 */
    private static final int SUIT_DIAMOND = 2;

    /**クラブを表す定数 */
    private static final int SUIT_CLUB = 3;

    /**ハートを表す定数 */
    private static final int SUIT_HEART = 4;

    /**
     * カードの示すマーク
     */
    private int suit;

    /**
     * カードの示す数字
     */
    private int number;

    /**
     * 引数が、マークを示す数字とカードの数字であるコンストラクタ
     * 
     * @param _suit　カードのマーク
     * @param _number　カードの数字
     */
    public Card(int _suit, int _number){
        
        this.suit = _suit;
        this.number = _number;
    }

    /**
     * カードの数字を取得するメソッド
     */
    public int getNumber(){
        return number;
    }
    
    

}

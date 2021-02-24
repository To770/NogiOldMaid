package jp.ac.uryukyu.ie.e205737;

/**
 * トランプのカード全体を表すクラス
 */
public class Card {
    
    /**ジョーカーを表す定数 */
    public static final int JOKER = 0;

    /**スペードを表す定数 */
    public static final int SUIT_SPADE = 1;

    /**ダイヤを表す定数 */
    public static final int SUIT_DIAMOND = 2;

    /**クラブを表す定数 */
    public static final int SUIT_CLUB = 3;

    /**ハートを表す定数 */
    public static final int SUIT_HEART = 4;

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
     * @param _number　カードの数字 (ジョーカーは0)
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
    
    /**
     * カードを文字列で表記し、返すメソッド
     * 
     * @return　カードの文字列表現
     */

    public String toString(){
        StringBuffer string = new StringBuffer();
        if(number >0 ){
            
            //マークの表示
            switch (suit){
                case SUIT_SPADE :
                string.append("S");
                break;

                case SUIT_DIAMOND :
                string.append("D");
                break;
            
                case SUIT_CLUB :
                string.append("C");
                break;
                
                case SUIT_HEART :
                string.append("H");
                break;

                default :
                break;
            }

            //数字の表示
            switch(number){
                case 1:
                string.append("A");
                break;

                case 11:
                string.append("J");
                break;

                case 12:
                string.append("Q");
                break;

                case 13:
                string.append("K");
                break;

                default:
                string.append(number);
                break;
            }
        }else{
            //ジョーカーを表す
            string.append("JK");
        }
        
        return string.toString();
    }
}

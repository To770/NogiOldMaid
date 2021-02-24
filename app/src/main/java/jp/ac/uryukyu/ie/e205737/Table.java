package jp.ac.uryukyu.ie.e205737;

import java.util.ArrayList;

/**
 * 場を表すクラス
 */
public class Table {
    private ArrayList discards = new ArrayList();
    
    /**
     * カードを破棄するメソッド
     * @param 捨てるカードの配列
     */
    public void discards(Card card[]){
        for(int index = 0; index < card.length; index++){

            //破棄されたカードを表示
            System.out.println(card[index] + " ");
        }

        System.out.println("を破棄しました");

        //破棄されたカードはリストに追加し、保存する
        discards.add(card);
    }
}

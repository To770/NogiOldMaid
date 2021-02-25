package jp.ac.uryukyu.ie.e205737;
/**
 * ババ抜きをするプレイヤーを表すクラス。
 * 
 */
public class Player {
    /**ゲームマスター */
    private Master master;
    /**テーブル */
    private Table table;
    /**自分の手札 */
    private Hand myHand = new Hand();
    /**プレイヤー名 */
    private String name;

    /**
     * コンストラクタ
     * @param _name
     * @param _master
     * @param _table
     */
    public Player(String _name, Master _master, Table _table){
        this.name = _name;
        this.master = _master;
        this.table = _table;
    }

    /**
     * 順番を指定するメソッド
     * 
     * @param nextPlayer　次のプレイヤー
     */
    public void Play(Player nextPlayer){
        
        //次のプレイヤーに手札を出してもらう
        Hand nextHand = nextPlayer.showHand();

        //相手の手札からカードを一枚引く
        Card pickedCard = nextHand.pickCard();

        //引いたカードの結果を表示
        System.out.println(this + ":" + nextPlayer + "から " + pickedCard + " を引きました");
          
        //引いたカードを表示したい時にはここを消す
        //System.out.println(this + ":" + nextPlayer + "からカードを引きました");  

        //引いたカードを自分の手札に加えて、同じカードがあればそれを破棄する。
        dealCard(pickedCard);

        //手札が０になったかどうか調べる
        if(myHand.getNumverOfHandCards() == 0) {

            // 進行役に上りを宣言する
            master.declareWin(this);
        } else {
            // 現在の手札を表示する
            System.out.println(this + ":残りの手札は　" + myHand + "です");
        }
    }

    /**
     * 手札を見せるメソッド
     * 
     * @return 自分の手札
     */
    public Hand showHand() {
        // この時点で手札が一枚なら上がりであるため宣言
        if (myHand.getNumverOfHandCards() == 1) {
            master.declareWin(this);
        }

        //相手に手札を見せる前にシャッフルする
        myHand.shuffle();

        return myHand;
    }

    /**
     * カードを受け取る
     * 
     * @param card 受け取ったカード
     */
    public void receiveCard(Card card){

        //引いたカードを自分の手札に加えて同じ数のカードがあれば破棄する。
        dealCard(card);
    }

    private void dealCard(Card card){
        //カードを自分の手札に加える
        myHand.addCard(card);

        //今加えたカードと同じカードを探す
        Card[] sameCards = myHand.findSameNumberCards();

        //同じ数字のカードが存在した場合
        if(sameCards != null) {
            //場にカードを破棄する
            System.out.println(this + ":");
            table.discards(sameCards);
        }
    }

    /**
     * プレイヤーの名前を返すメソッド
     * @return プレイヤーの名前
     */
    public String toString(){
        return name;
    }
}

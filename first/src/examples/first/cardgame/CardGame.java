package examples.first.cardgame;

import java.util.List;

public class CardGame {
    public static void main(String[] args) {
        //카드를 만든다.
        List<Card> cardList = CardFactory.createCards();

        //딜러를 선정한다.
        Dealer dealer = new Dealer();

        //카드를 받는다.
        dealer.getCards(cardList);

        //플레이어를 모집한다.

        dealer.setPlayer(new Player("KBS"));
        dealer.setPlayer(new Player("SBS"));
        dealer.setPlayer(new Player("MBC"));

        //반복
        int gameCount = dealer.getGameCount();
        while(gameCount-- > 0) {
            int gameNum = dealer.getGameCount() - gameCount;
            //카드를 섞는다.
            dealer.shuffleCard();

            //플레이어들에게 카드를 나눠준다.
            dealer.distributeCard();

            //플레이어의 카드를 본다.
            dealer.showCardOfPlayers();

            //판정한다.
            Player winPlayer = dealer.judge();
            System.out.println(gameNum + "번째 게임의 승리자는 " + winPlayer.getName() + "입니다.");

            //카드를 반납한다.
            for (Player player : dealer.getPlayers()) {
                dealer.receiveCards(player.getCards());
            }
        }
    }
}

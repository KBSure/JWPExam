package examples.first.cardgame;

import java.util.*;

public class Dealer {
    private Queue<Card> cards = new LinkedList<>();
    private List<Player> players = new ArrayList<>();
    private Map<Player, Integer> cardSumMap = new HashMap<>();
    private int gameCount = 10;

    public int getGameCount(){
        return this.gameCount;
    }

    public void getCards(List<Card> cards){
        this.cards.addAll(cards);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayer(Player player){
        players.add(player);
    }

    public void shuffleCard(){
        List<Card> tempList = new ArrayList<>();
        tempList.addAll(cards);
        Collections.shuffle(tempList);
        cards.clear();
        cards.addAll(tempList);
    }

    public void distributeCard(){
        for(int i = 0; i < 5; i++){
            for(Player player : players){
                player.setCard(cards.poll());
            }
        }
    }

    public void showCardOfPlayers(){
        for(Player player : players){
            int sum = 0;
            for(Card card : player.getCards()){
                sum += card.getNumber();
            }
            cardSumMap.put(player, sum);
        }
    }

    public Player judge(){
        Player winPlayer = null;
        int maxSum = 0;
        for(Player player : players){
            if(maxSum < cardSumMap.get(player)){
                maxSum = cardSumMap.get(player);
                winPlayer = player;
            }
        }
        return winPlayer;
    }

    public void receiveCards(List<Card> cardList){
        cards.addAll(cardList);

    }
}

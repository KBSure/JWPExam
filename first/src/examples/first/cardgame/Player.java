package examples.first.cardgame;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> cards;

    public Player(String name){
        this.name = name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public String getName() {
        return name;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void setCard(Card card){
        if(cards == null){
            cards = new ArrayList<>();
        }
        cards.add(card);
    }
}

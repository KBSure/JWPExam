package examples.first.cardgame;

import java.util.ArrayList;
import java.util.List;

public abstract class CardFactory {
    private static String[] shape = {"heart", "clover", "diamond", "spade"};
    public static List<Card> createCards(){
        List<Card> cardList = new ArrayList<>();
        for(int i = 0; i < shape.length; i++){
            for(int j = 1; j <= 13; j++){
                cardList.add(new Card(shape[i], j));
            }
        }
        return cardList;
    }
}

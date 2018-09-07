package examples.first.cardgame;

public class Card {
    private String shape;
    private int number;

    public Card(String shape, int number){
        this.shape = shape;
        this. number = number;
    }

    public String getShape() {
        return shape;
    }

    public int getNumber() {
        return number;
    }
}

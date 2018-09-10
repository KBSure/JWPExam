package examples.first.sorttest;

public class Book implements Comparable<Book>{
    private String name;
    private int price;

    public Book(String name, int price){
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Book o) {
        return  price - o.price;
    }

    @Override
    public String toString() {
        return "책 제목 : " + name + " / 책 가격 : " + price;
    }
}

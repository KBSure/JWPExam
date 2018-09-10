package examples.first.sorttest;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        //String 이 구현한 comparetTo 이용
        return o1.getName().compareTo(o2.getName());
    }
}

package examples.first.sorttest;

import org.omg.CORBA.OBJ_ADAPTER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SortTest {
    public static void main(String[] args) {
        Book b1 = new Book("홍길동전", 3000);
        Book b2 = new Book("신데렐라", 2000);
        Book b3 = new Book("콩쥐팥쥐", 4000);

        List<Book> bookList = new ArrayList<>(3);
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);

        System.out.println("----- 정렬 전-----");

        for(Book book: bookList){
            System.out.println(book);
        }

        Collections.sort(bookList);

        System.out.println("----- Collections.sort(booklist) 정렬 후-----");
        for(Book book: bookList){
            System.out.println(book);
        }

        BookComparator bookComparator = new BookComparator();
        Collections.sort(bookList, bookComparator);

        System.out.println("----- Collections.sort(booklist, bookComparator) 정렬 후-----");
        for(Book book: bookList){
            System.out.println(book);
        }
    }
}

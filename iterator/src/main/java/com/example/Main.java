package com.example;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf();
        bookShelf.appendBook(new Book("生物と無生物の間"));
        bookShelf.appendBook(new Book("デザインパターン"));
        bookShelf.appendBook(new Book("モノリスからマイクロサービスへ"));
        
        Iterator<Book> it = bookShelf.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            System.out.println(book.getName());
        }
    }
}

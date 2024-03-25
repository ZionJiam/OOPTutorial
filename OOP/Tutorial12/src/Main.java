import java.util.ArrayList;
import java.util.List;

import Book.Book;
public class Main {

    public static void main(String[] args) {

        List<Book> bookList = new ArrayList<>();
        List<Book> emptyBookList = null;


        Book book1 = new Book("Hello World", "Stephen Hawking", "12345");
        Book book2 = new Book("NIHAO shijie", "Ronald Dahl", "234234");
        Book book3 = new Book("I DON KNOW", "Shakespeare", "4354354");

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        Library library = new Library("Hougang", bookList);



        // Book Exist
        String ISBN1 = "12345";
        System.out.println("Get Author of book with ISBN: " + ISBN1 + " >>> " + library.getBooksByISBN(ISBN1).getAuthor());;

        // Book does not exist
        String ISBN2 = "23423894";
        if(library.getBooksByISBN(ISBN2) != null){
            System.out.println("Get Author of book with ISBN: " + ISBN2 + " >>> " + library.getBooksByISBN(ISBN2).getAuthor());;
        }

        // No Books at library
        Library libraryWithEmptyBookList = new Library("Hougang", emptyBookList);
        String ISBN3 = "234234";
        if(libraryWithEmptyBookList.getBooksByISBN(ISBN3) != null){
            System.out.println("Get Author of book with ISBN: " + ISBN3 + " >>> " + libraryWithEmptyBookList.getBooksByISBN(ISBN3).getAuthor());;
        }    }
}
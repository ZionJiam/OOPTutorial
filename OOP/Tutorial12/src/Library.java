import Book.Book;
import Staff.*;

import java.util.List;

public class Library {

    private List<Book> books;
    private List<Librarian> librarians;
    private List<Cleaner> cleaners;
    private String location;

    public Library(String location, List<Book> books){
        this.location = location;
        this.books = books;
    }

    public Library(String location, List<Book> books, List<Librarian> librarians, List<Cleaner> cleaners){
        this.location = location;
        this.books = books;
        this.librarians = librarians;
        this.cleaners = cleaners;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBooksByISBN(String ISBN){
        try{
           for(Book book: books){
               if(book.getISBN().equals(ISBN)){
                   return book;
               }
           }
            System.out.println("Book with ISBN: " + ISBN + " does not exist. ");
        }catch (NullPointerException e){
            System.out.println("There are no books in this library");
        }

        return null;
    }
}

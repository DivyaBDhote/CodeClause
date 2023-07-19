import java.util.HashMap;
import java.util.Map;

class Book {
    private String isbn;
    private String title;
    private boolean isAvailable;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
        this.isAvailable = true;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn + ", Title: " + title + ", Available: " + isAvailable;
    }
}

class Library {
    private Map<String, Book> books;

    public Library() {
        this.books = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public Book getBook(String isbn) {
        return books.get(isbn);
    }

    public void issueBook(String isbn) {
        Book book = books.get(isbn);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book with ISBN " + isbn + " has been issued.");
        } else {
            System.out.println("Book with ISBN " + isbn + " is not available for issuance.");
        }
    }

    public void returnBook(String isbn) {
        Book book = books.get(isbn);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            System.out.println("Book with ISBN " + isbn + " has been returned.");
        } else {
            System.out.println("Invalid ISBN or the book is already available.");
        }
    }

    public void displayBooks() {
        System.out.println("Library Book Collection:");
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding some books to the library
        Book book1 = new Book("1234567890", "Java Programming");
        Book book2 = new Book("9876543210", "Python Programming");
        library.addBook(book1);
        library.addBook(book2);

        // Display all books in the library
        library.displayBooks();

        // Issue a book
        library.issueBook("1234567890");
        library.displayBooks();

        // Return the book
        library.returnBook("1234567890");
        library.displayBooks();
    }
}
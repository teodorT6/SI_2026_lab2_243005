import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SI2026Lab2Test {

    @Test
    void searchBookEveryStatementTest() {
        Library library = new Library();

        library.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));

        List<Book> result = library.searchBookByTitle("Clean Code");
        assertNotNull(result);

        List<Book> result2 = library.searchBookByTitle("Harry Potter");
        assertNull(result2);

        assertThrows(IllegalArgumentException.class, () -> {
            library.searchBookByTitle("");
        });
    }

    @Test
    void borrowBookEveryBranchTest() {
        Library library = new Library();

        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy"));
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "");
        });

        library.borrowBook("The Hobbit", "J.R.R. Tolkien");

        assertThrows(RuntimeException.class, () -> {
            library.borrowBook("The Hobbit", "J.R.R. Tolkien");
        });

        assertThrows(RuntimeException.class, () -> {
            library.borrowBook("Unknown", "Someone");
        });
    }

    @Test
    void searchBookMultipleConditionTest() {
        Library library = new Library();

        Book b1 = new Book("Clean Code", "Robert C. Martin", "Programming");
        Book b2 = new Book("Clean Code", "Robert C. Martin", "Programming");
        b2.setBorrowed(true);

        library.addBook(b1);
        library.addBook(b2);

        List<Book> result1 = library.searchBookByTitle("Clean Code");
        assertNotNull(result1);

        assertEquals(1, result1.size());

        List<Book> result2 = library.searchBookByTitle("Unknown");
        assertNull(result2);
    }

    @Test
    void borrowBookMultipleConditionTest() {
        Library library = new Library();

        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy"));

        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "J.R.R. Tolkien");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("The Hobbit", "");
        });

        library.borrowBook("The Hobbit", "J.R.R. Tolkien");
    }
}
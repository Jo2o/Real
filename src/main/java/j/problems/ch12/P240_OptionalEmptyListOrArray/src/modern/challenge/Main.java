package j.problems.ch12.P240_OptionalEmptyListOrArray.src.modern.challenge;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        Author author = new Author();

        // Avoid
        Optional<List<Book>> booksAvoid = author.fetchBooksByYearAvoid(2021);
        Optional<Book[]> booksAlsoAvoid = author.fetchBooksByYearAlsoAvoid(2021);

        // Prefer
        List<Book> booksPrefer = author.fetchBooksByYearPrefer(2021);
        Book[] booksAlsoPrefer = author.fetchBooksByYearAlsoPrefer(2021);
    }

}

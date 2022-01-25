package j.javacodingproblems.Chapter12.P226_InitializingOptional.src.modern.challenge;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        // Avoid
        Optional<Book> book1 = null;

        // Prefer
        Optional<Book> book2 = Optional.empty();
    }
}

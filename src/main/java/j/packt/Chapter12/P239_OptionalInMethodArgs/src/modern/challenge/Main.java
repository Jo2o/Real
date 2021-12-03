package j.packt.Chapter12.P239_OptionalInMethodArgs.src.modern.challenge;

import java.util.Optional;

public class Main { 

    public static void main(String[] args) {

        Book book = new Book();

        // Avoid
        book.renderBook(new Format(), Optional.of(new CoolRenderer()), Optional.empty());

        // Prefer
        book.renderBook(new Format(), new CoolRenderer(), null);
    }

}

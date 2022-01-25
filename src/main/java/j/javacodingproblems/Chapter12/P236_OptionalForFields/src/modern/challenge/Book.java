package j.javacodingproblems.Chapter12.P236_OptionalForFields.src.modern.challenge;

import java.util.Optional;

public class Book {

    // Avoid
    private Optional<String> title1;
    private Optional<String> subtitle1 = Optional.empty();

    // Prefer
    private String title2;
    private String subtitle2 = "";
}

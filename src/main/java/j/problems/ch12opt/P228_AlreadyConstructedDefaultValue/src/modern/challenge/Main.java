package j.problems.ch12opt.P228_AlreadyConstructedDefaultValue.src.modern.challenge;

public class Main {

    public static void main(String[] args) {

        Book book = new Book();

        // Avoid
        System.out.println(book.findStatusAvoid());

        // Prefer
        System.out.println(book.findStatusPrefer());
    }
}
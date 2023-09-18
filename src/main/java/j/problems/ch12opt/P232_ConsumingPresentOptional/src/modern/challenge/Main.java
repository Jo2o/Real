package j.problems.ch12opt.P232_ConsumingPresentOptional.src.modern.challenge;

public class Main {

    public static void main(String[] args) {

        Book book = new Book();

        // Avoid
        book.displayStatusAvoid();
        book.displayStatusAlsoAvoid();

        // Prefer
        book.displayStatusPrefer();
        book.displayStatusAlsoPrefer();
    }

}

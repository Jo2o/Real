package j.javacodingproblems.Chapter12.P235_OptionalForGettingValue.src.modern.challenge;

public class Main {

    public static void main(String[] args) {

        Book book = new Book();

        // Avoid
        System.out.println(book.findStatusAvoid());

        // Prefer
        System.out.println(book.findStatusPrefer());
    }

}

package java.packt.Chapter08.P175_CascadedBuilderPattern.src.modern.challenge;

public class Main {

    public static void main(String[] args) {

        Delivery.deliver(d -> d.firstname("Mark")
                .lastname("Kyilt")
                .address("25 Street, New York")
                .content("10 books"));
    }

}

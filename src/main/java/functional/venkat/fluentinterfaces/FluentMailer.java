package functional.venkat.fluentinterfaces;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

@Slf4j
class FluentMailer {
    private String from;
    private String to;
    private String subject;
    private String body;

    private FluentMailer() {
    }

    public FluentMailer from(final String address) {
        this.from = address;
        return this;
    }

    public FluentMailer to(final String address) {
        this.to = address;
        return this;
    }

    public FluentMailer subject(final String line) {
        this.subject = line;
        return this;
    }

    public FluentMailer body(final String message) {
        this.body = message;
        return this;
    }

    public static void send(final Consumer<FluentMailer> block) {
        FluentMailer fluentMailer = new FluentMailer();
        block.accept(fluentMailer);     // here it is as setter
        log.info("Sending FluentMailer...");
    }
}

package functional.venkat.fluentinterfaces;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
public class Main {
    public static void main(String[] args) {
        new Main().test();
    }

    private void test() {

        Mailer mailer = new Mailer();                         // lots of duplication
        mailer.from("build@agiledeveloper.com");
        mailer.to("venkats@agiledeveloper.com");
        mailer.subject("build notification");
        mailer.body("...your code sucks...");
        mailer.send();

        new MailerBuilder()                                   // still new keyword is here and may be stored elsewhere preventing GC
                .from("build@agiledeveloper.com")
                .to("venkats@agiledeveloper.com")
                .subject("build notification")
                .body("...your code sucks less...")
                .send();

        FluentMailer.send(m -> m.from("build@agiledeveloper.com") // got rid of new with (static send) + (private constructor) which creates new instance inside
                .to("venkats@agiledeveloper.com")                 // m is not defined here, it is captured/closure inside send() and then setters are carried out
                .subject("build notification")                    // then actions in send are done
                .body("...much better..."));
    }

    class Mailer {
        private String from;
        private String to;
        private String subject;
        private String body;

        public void from(final String address) {
            this.from = address;
        };
        public void to(final String address) {
            this.to = address;
        };
        public void subject(final String line) {
            this.subject = line;
        };
        public void body(final String message) {
            this.body = message;
        };
        public void send() {
            log.info("Sending Mailer...");
        };
    }

    class MailerBuilder {
        private String from;
        private String to;
        private String subject;
        private String body;

        public MailerBuilder from(final String address) {
            this.from = address;
            return this;
        };
        public MailerBuilder to(final String address) {
            this.to = address;
            return this;
        };
        public MailerBuilder subject(final String line) {
            this.subject = line;
            return this;
        };
        public MailerBuilder body(final String message) {
            this.body = message;
            return this;
        };
        public void send() {
            log.info("Sending MailerBuilder...");
        };
    }

}

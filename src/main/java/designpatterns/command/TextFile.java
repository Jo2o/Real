package designpatterns.command;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TextFile {

    public void open() {
        log.info("Opening the text file...");
    }

    public void delete() {
        log.info("Deleting the text file...");
    }

    public void save() {
        log.info("Saving the text file...");
    }

}

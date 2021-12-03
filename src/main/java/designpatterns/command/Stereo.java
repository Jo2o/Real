package designpatterns.command;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Stereo {

    public void on() {
        log.info("Stereo is on...");
    }

    public void off() {
        log.info("Stereo is off...");
    }
}

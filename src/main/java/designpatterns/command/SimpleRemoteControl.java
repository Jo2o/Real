package designpatterns.command;

public class SimpleRemoteControl {

    Command slot; // just one command

    public void setCommand(Command command) {
        slot = command;
    }

    public void buttonPressed() {
        slot.execute();
    }
}

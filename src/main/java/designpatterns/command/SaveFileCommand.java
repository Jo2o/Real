package designpatterns.command;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OpenFileCommand implements Command {

    private final TextFile textFile;

    @Override
    public void execute() {
        textFile.open();
    }
}

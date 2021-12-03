package designpatterns.command;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveFileCommand implements Command {

    private final TextFile textFile;

    @Override
    public void execute() {
        textFile.save();
    }
}

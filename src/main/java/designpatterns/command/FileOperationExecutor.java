package designpatterns.command;

import java.util.ArrayList;
import java.util.List;

public class FileOperationExecutor {

    private final List<Command> fileOperations = new ArrayList<>(); // Can be used as buffer for UNDO

    public void executeOperation(Command fileOperation) {
        fileOperations.add(fileOperation);
        fileOperation.execute();
    }
}

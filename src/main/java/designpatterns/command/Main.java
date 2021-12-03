package designpatterns.command;

import jdk.swing.interop.LightweightContentWrapper;
import lombok.extern.slf4j.Slf4j;

/**
 * In analogy to our problem a remote control is the CLIENT and stereo, lights etc. are the RECEIVERS.
 * In command pattern there is a Command object that encapsulates a request by binding together a SET OF ACTIONS ON A SPECIFIC RECEIVER.
 * It does so by exposing just one method EXECUTE() THAT CAUSES SOME ACTIONS TO BE INVOKED ON THE RECEIVER.
 *
 * RECEIVER = TextFile
 * COMMAND CLASSES = Command, Open/Save/DeleteFileCommand-s
 * INVOKER = FileOperationExecutor - knows how to execute a given command but does not know how the command is implemented.
 *                                   In some cases, the invoker also stores and queues commands, aside from executing them.
 *                                   This is useful for implementing some additional features, such as macro recording or UNDO and REDO functionality.
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        FileOperationExecutor fileOperationExecutor = new FileOperationExecutor();
//      fileOperationExecutor.executeOperation(new OpenFileCommand(new TextFile()));
//      fileOperationExecutor.executeOperation(new SaveFileCommand(new TextFile()));
        TextFile textFile = new TextFile();
        fileOperationExecutor.executeOperation(textFile::open); // With Lambdas, I don't actually need specific Command implementations! :)
        fileOperationExecutor.executeOperation(textFile::delete);

        log.info("--------------------------------------------------------------");

        /*
         * Notice that the remote control doesn’t know anything about turning on the stereo.
         * That information is contained in a separate command object.
         * This reduces the coupling between them.
         */

        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
        Light light = new Light();
        Stereo stereo = new Stereo();

        simpleRemoteControl.setCommand(light::on);
        simpleRemoteControl.buttonPressed();
        simpleRemoteControl.setCommand(stereo::off);
        simpleRemoteControl.buttonPressed();
    }
}

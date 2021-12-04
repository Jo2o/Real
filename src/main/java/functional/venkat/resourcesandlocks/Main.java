package functional.venkat.resourcesandlocks;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {

        /* Classical approach. */
        MyFileWriter myFileWriter = new MyFileWriter("src/main/java/functional/venkat/resourcesandlocks/peekaboo1.txt");
        try {
            myFileWriter.writeStuff("peek-a-boo-1");
        } finally {
            myFileWriter.finish(); // even if exception occurs
        }

        /* Auto Resource Management - Try with Resources */
        try (MyFileWriterTryWithResources myFileWriterTryWithResources =
                     new MyFileWriterTryWithResources("src/main/java/functional/venkat/resourcesandlocks/peekaboo2.txt")) {
            myFileWriterTryWithResources.writeStuff("peek-a-boo-2");
            log.info("Wrote peek-a-boo-2");
        }

        /* Lambdas - Execute Around: In: fileName & block what should be done. */
        MyFileWriterLambda.writeStuff(
                "src/main/java/functional/venkat/resourcesandlocks/peekaboo3.txt",
                myFileWriterLambda -> myFileWriterLambda.write("peek-a-boo-3")); // input for the lambda must be writer since it is used in the body!
                                                                                 // CRAZY that it is coming from/created afterwards in the MyFileWriterLambda.writeStuff
    }

}

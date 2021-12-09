package j.annotations;

import lombok.extern.slf4j.Slf4j;

@MyAnnotation(                           // now class is annotated (tagged)
        name = "Apple",
        count = 21,
        tags = {"red", "sour"}
)
@Slf4j
public class Annotated {

    @MyAnnotation(count = 555)
    public void doIt() {                 // now method is annotated (tagged)
        log.info("doing it...");
    }
}

package json.jackson;

import static com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT;
import static java.lang.System.lineSeparator;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        
        String jsonCarData = new ObjectMapper()
            //.enable(INDENT_OUTPUT)
            .writeValueAsString(
                CarDataWrapper.builder()
                    .cars(
                        List.of(
                            Car.builder()
                                .licensePlate("AB-123-CD")
                                .build(),
                            Car.builder()
                                .licensePlate("EF-456-GH")
                                .build()))
                    .build());

        log.info("Serialized: {}    {}", lineSeparator(), jsonCarData);
    }
}

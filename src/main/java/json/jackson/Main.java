package json.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    @SneakyThrows
    public static void main(String[] args) {

        String jsonCarData = new ObjectMapper().writeValueAsString(
            CarDataWrapper.builder()
                .car(
                    Car.builder()
                        .licensePlate("AB-123-CD")
                        .build())
                .build());
        
        log.info("Serialized: {}", jsonCarData);
    }
}

package json.jackson;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CarDataWrapper {
    
    private final Car car;
    
}

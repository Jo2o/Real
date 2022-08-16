package json.jackson;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CarDataWrapper {
    
    private final List<Car> cars;
    
}

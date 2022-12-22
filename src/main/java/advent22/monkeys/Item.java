package advent22.monkeys;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor(staticName = "of")
@Getter
@ToString
public class Item {

    @NonNull
    private int id;

    @NonNull
    @Setter
    private int worryLevel;

}

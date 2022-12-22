package advent22.monkeys;

import java.util.List;
import java.util.function.Function;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Monkey {

    private int name;
    private List<Item> items;
    private Function<Integer, Integer> operation;
    private Function<Integer, Integer> test;

    @Setter
    private int inspections;
}

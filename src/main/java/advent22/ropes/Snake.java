package advent22.ropes;

import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Snake {

    @NotNull
    private Head head;

    @NotNull
    private List<Tail> body;

    public void move(String direction) {
        head.move(direction);
        Knot previousKnot = head;
        for (Tail cell : body) {
            cell.move(previousKnot);
            previousKnot = cell;
        }
    }

    public Tail getTail() {
        return body.get(body.size() - 1);
    }

    public Tail getCell(@NotNull String name) {
        return body.stream()
            .filter(cell -> cell.getName().equals(name))
            .findAny()
            .orElseThrow();
    }

    public int getBodyLength() {
        return body.size();
    }
}

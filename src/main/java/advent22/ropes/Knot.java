package advent22.ropes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class Knot {

    private String name;
    private Position position;

    public boolean isTouching(Knot other) {
        return (Math.abs(this.getPosition().getX() - other.getPosition().getX()) <= 1)
            && (Math.abs(this.getPosition().getY() - other.getPosition().getY()) <= 1);
    }

}

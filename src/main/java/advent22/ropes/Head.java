package advent22.ropes;

public class Head extends Knot {

    public Head(String name, Position position) {
        super(name, position);
    }

    public void move(String oneStep) {
        switch (oneStep) {
            case "U":
                this.getPosition().setY(this.getPosition().getY() + 1);
                break;
            case "R":
                this.getPosition().setX(this.getPosition().getX() + 1);
                break;
            case "D":
                this.getPosition().setY(this.getPosition().getY() - 1);
                break;
            case "L":
                this.getPosition().setX(this.getPosition().getX() - 1);
                break;
            default:
                throw new RuntimeException("Unknown direction!");
        }
    }

}

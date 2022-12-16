package advent22.ropes;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;

@Getter
public class Tail extends Knot {

    private Set<Position> visitedPoints;

    public Tail(String name, Position position) {
        super(name, position);
        visitedPoints = new HashSet<>();
        visitedPoints.add(new Position(0, 0));

    }

    public void move(Knot head) {
        if (this.isTouching(head)) {
            return;
        }

        int deltaX = 0;
        int deltaY = 0;
        int headPositionX = head.getPosition().getX();
        int headPositionY = head.getPosition().getY();
        int tailPositionX = this.getPosition().getX();
        int tailPositionY = this.getPosition().getY();

        if (headPositionX == tailPositionX) {
            if (headPositionY > tailPositionY) {
                deltaY = 1;
            } else {
                deltaY = -1;
            }
        }

        if (headPositionY == tailPositionY) {
            if (headPositionX > tailPositionX) {
                deltaX = 1;
            } else {
                deltaX = -1;
            }
        }

        if ((headPositionX != tailPositionX) && (headPositionY != tailPositionY)) {
            if (headPositionX > tailPositionX && headPositionY > tailPositionY) {
                deltaX = 1;
                deltaY = 1;
            }
            if (headPositionX < tailPositionX && headPositionY < tailPositionY) {
                deltaX = -1;
                deltaY = -1;
            }
            if (headPositionX > tailPositionX && headPositionY < tailPositionY) {
                deltaX = 1;
                deltaY = -1;
            }
            if (headPositionX < tailPositionX && headPositionY > tailPositionY) {
                deltaX = -1;
                deltaY = 1;
            }
        }

        int newX = this.getPosition().getX() + deltaX;
        int newY = this.getPosition().getY() + deltaY;
        this.getPosition().setX(newX);
        this.getPosition().setY(newY);

        visitedPoints.add(new Position(newX, newY));
    }

}

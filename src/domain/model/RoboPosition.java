package domain.model;

import domain.exception.robotException;

import java.util.Objects;

public class RoboPosition {
    int x, y;
    public MoveDirection direction;

    public RoboPosition(int x, int y, MoveDirection direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public RoboPosition(RoboPosition roboPosition) {
        this.x = roboPosition.getX();
        this.y = roboPosition.getY();
    }

    //function to calculate chanege in position with new xy values
    public void positionChange(int posX, int posY) {
        this.x += posX;
        this.y += posY;
    }

    public RoboPosition getNewPosition() throws robotException {
        RoboPosition tempPosition = new RoboPosition(this);

        MoveDirection direction = this.direction;
        Objects.requireNonNull(direction);

        if (direction == MoveDirection.NORTH) {
            tempPosition.positionChange(0, 1);
        } else if (direction == MoveDirection.EAST) {
            tempPosition.positionChange(1, 0);
        } else if (direction == MoveDirection.SOUTH) {
            tempPosition.positionChange(0, -1);
        } else if (direction == MoveDirection.WEST) {
            tempPosition.positionChange(-1, 0);
        }
        return tempPosition;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public MoveDirection getDirection() {
        return direction;
    }

    public void setDirection(MoveDirection direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "RoboPosition{" +
                "x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                '}';
    }
}

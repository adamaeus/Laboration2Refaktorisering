package Operations;

import Operations.Interfaces.Directions;
import Operations.Interfaces.Movable;

public class MovingSystem implements Movable {

   public  Directions direction = Directions.RIGHT;

    private double x;
    private double y;


    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void turnLeft() {
        switch (direction) {
            case RIGHT -> direction = Directions.UP;
            case UP -> direction = Directions.LEFT;
            case DOWN -> direction = Directions.RIGHT;
            case LEFT -> direction = Directions.DOWN;
        }
    }


    public void turnRight() {
        switch (direction) {
            case LEFT -> direction = Directions.UP;
            case UP -> direction = Directions.RIGHT;
            case DOWN -> direction = Directions.LEFT;
            case RIGHT -> direction = Directions.DOWN;
        }
    }

    public void move(double currentSpeed) {
        switch (direction) {
            case LEFT -> x = x - currentSpeed;
            case RIGHT -> x = x + currentSpeed;
            case UP -> y = y + currentSpeed;
            case DOWN -> y = y - currentSpeed;
        }

    }
}

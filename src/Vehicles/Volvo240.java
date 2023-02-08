package Vehicles;

import Architechture.Car;
import Operations.MovingSystem;
import Vehicles.Components.Engine;

import java.awt.*;

public class Volvo240 extends Car {

    Engine volvoEngine = new Engine(100);


    public Volvo240() {
        super("Volvo240", Color.BLACK, 4, 700);
    }

    public final double trimFactor = 1.25;


    @Override
    public void move() {
        volvoEngine.move();
    }

    @Override
    public void gas() {
        volvoEngine.gas(1.25, speedFactor());
    }

    @Override
    public void brake() {
        volvoEngine.brake(1.25, speedFactor());
    }

    @Override
    public void turnRight() {
        volvoEngine.turnRight();
    }

    @Override
    public void turnLeft() {
        volvoEngine.turnLeft();
    }
    @Override
    public double speedFactor() {
        return volvoEngine.getEnginePower() * 0.01 * trimFactor;
    }
}



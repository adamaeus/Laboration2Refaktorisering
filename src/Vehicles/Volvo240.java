package Vehicles;

import Architechture.Car;
import Operations.MovingSystem;
import Vehicles.Components.Engine;

import java.awt.*;

public class Volvo240 extends Car {

    Engine volvoEngine = new Engine(100);

    MovingSystem volvoMovingSystem = new MovingSystem();


    public Volvo240() {
        super("Volvo240", Color.BLACK, 4, 700);
    }

    public final double trimFactor = 1.25;


    @Override
    public void move() {
        volvoMovingSystem.move(volvoEngine.getCurrentSpeed());
    }

    @Override
    public void gas(double amount) {
        volvoEngine.gas(1.25, speedFactor());
    }

    @Override
    public void brake() {
        volvoEngine.brake(1.25, speedFactor());
    }

    @Override
    public void turnRight() {
        volvoMovingSystem.turnRight();
    }

    @Override
    public void turnLeft() {
        volvoMovingSystem.turnLeft();
    }
    @Override
    public double speedFactor() {
        return volvoEngine.getEnginePower() * 0.01 * trimFactor;
    }
}



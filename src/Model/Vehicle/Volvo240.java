package Model.Vehicle;

import java.awt.*;

public class Volvo240 extends Car {


    // GJORDE PRIVATE OCH LADE TILL EN NY GET ENGINE LÄNGS NED...
    private final Engine volvoEngine = new Engine(100);


    public Volvo240() {
        super("Volvo240", Color.BLACK, 4, 700);
    }

    private final double trimFactor = 1.25;


    @Override
    public void move() {
        carMovingSystem.move(volvoEngine.getCurrentSpeed());
    }

    @Override
    public void gas(double amount) {
        volvoEngine.gas(amount, speedFactor());
    }

    @Override
    public void brake(double amount) {
        volvoEngine.brake(amount, speedFactor());
    }

    @Override
    public void turnRight() {
        carMovingSystem.turnRight();
    }

    @Override
    public void turnLeft() {
        carMovingSystem.turnLeft();
    }

    @Override
    protected double speedFactor() {
        return volvoEngine.getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    public Engine getEngine() {
        return volvoEngine;
    }

    @Override
    public double getWeight() {
        return 0;
    }



    @Override
    public double getCurrentSpeed() {
        return volvoEngine.getCurrentSpeed();
    }

}



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
        carMovingSystem.move(volvoEngine.getCurrentSpeed());
    }

    @Override
    public void gas(double amount) {
        volvoEngine.gas(amount, speedFactor());
    }

    @Override
    public void brake(double amount) {
        volvoEngine.brake(1.0, speedFactor());
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
    public double getWeight() {
        return 0;
    }

    @Override
    public double getCurrentSpeed(){
        return volvoEngine.getCurrentSpeed();
    }

}



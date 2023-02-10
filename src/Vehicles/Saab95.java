package Vehicles;

import Architechture.Car;
import Operations.MovingSystem;
import Vehicles.Components.Engine;

import java.awt.*;

public class Saab95 extends Car {


    Engine saabEngine = new Engine(125);


    public boolean turboOn;

    public Saab95() {
        super("Saab95", Color.RED, 2, 500);
    }




    public void setTurboOn(){
        turboOn = true;
    }
    public void setTurboOff(){
        turboOn = false;
    }



    @Override
    protected double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return saabEngine.getEnginePower()* 0.01 * turbo;
    }

    @Override
    public double getWeight() {
        return 0;
    }

    @Override
    public double getCurrentSpeed() {
        return saabEngine.getCurrentSpeed();
    }

    @Override
    public Engine getCarEngine() {
        return saabEngine;
    }

    @Override
    protected void move() {
        carMovingSystem.move(saabEngine.getCurrentSpeed());
    }

    @Override
    public void gas(double amount) {
        saabEngine.gas(1.3, speedFactor());
    }



    @Override
    public void brake(double amount) {
        saabEngine.brake(amount, speedFactor());
    }

    @Override
    protected void turnRight() {
        carMovingSystem.turnRight();
    }

    @Override
    protected void turnLeft() {
        carMovingSystem.turnLeft();
    }


}

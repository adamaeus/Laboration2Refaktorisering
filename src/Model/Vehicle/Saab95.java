package Model.Vehicle;

import java.awt.*;

public class Saab95 extends Car {


    private final Engine saabEngine = new Engine(125);




    private boolean turboOn;

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
        if(turboOn) turbo = 4.0;
        return saabEngine.getEnginePower()* 0.01 * turbo;
    }

    // NYTT 22:30 10 feb
    @Override
    public Engine getEngine() {
        return saabEngine;
    }



    @Override
    public double getWeight() {
        return 0;
    }

    @Override
    public iVehicle create() {
        return this;
    }

    @Override
    public double getCurrentSpeed() {
        return saabEngine.getCurrentSpeed();
    }

    @Override
    protected void move() {
        carMovingSystem.move(saabEngine.getCurrentSpeed());
    }

    @Override
    public void gas(double amount) {
        saabEngine.gas(amount, speedFactor());
    }

    @Override
    public void brake(double amount) {
        saabEngine.brake(0.5, speedFactor());
    }

    @Override
    public void turnRight() {
        carMovingSystem.turnRight();
    }

    @Override
    public void turnLeft() {
        carMovingSystem.turnLeft();
    }


}

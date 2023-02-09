package Vehicles;

import Architechture.Car;
import Operations.MovingSystem;
import Vehicles.Components.Engine;

import java.awt.*;

public class Saab95 extends Car {


    Engine saabEngine = new Engine(125);

    MovingSystem saabMovingSystem = new MovingSystem();
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
    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return saabEngine.getEnginePower()* 0.01 * turbo;
    }

    @Override
    protected void move() {
        saabMovingSystem.move(saabEngine.getCurrentSpeed());
    }

    @Override
    public void gas(double amount) {
        saabEngine.gas(1.3, speedFactor());
    }

    @Override
    protected void brake() {
        saabEngine.brake(1.3, speedFactor());
    }

    @Override
    protected void turnRight() {
        saabMovingSystem.turnRight();
    }

    @Override
    protected void turnLeft() {
        saabMovingSystem.turnLeft();
    }


}

package Vehicles;

import Architechture.Car;
import Vehicles.Components.Engine;

import java.awt.*;

public class Saab95 extends Car {


    Engine saabEngine = new Engine(125);
    public boolean turboOn;

    public Saab95(String modelName, int nrDoors, double enginePower, Color color, double weight) {
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

    }

    @Override
    protected void gas() {

    }

    @Override
    protected void brake() {

    }

    @Override
    protected void turnRight() {

    }

    @Override
    protected void turnLeft() {

    }


}

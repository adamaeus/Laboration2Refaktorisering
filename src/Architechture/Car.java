package Architechture;

import Operations.MovingSystem;
import Vehicles.Components.Engine;
import Vehicles.Volvo240;

import java.awt.*;

public abstract class Car {

    public Car (String modelName, Color color, int nrDoors, double weight) {
        this.modelName = modelName;
        this.nrDoors = nrDoors;
        this.color = color;
        this.weight = weight;
    }

    protected MovingSystem carMovingSystem = new MovingSystem();

    public MovingSystem getCarMovingSystem (){
        return carMovingSystem;
    }





    private final double weight;
    private final Color color;
    private final String modelName;
    private final int nrDoors;

    public String getModelName() { return modelName; }
    public int getNrDoors() {return nrDoors;}
    public Color getColor() {return color;}
    public abstract double getWeight();
    public abstract double getCurrentSpeed();

    public abstract Engine getCarEngine();
    protected abstract void move();
    public abstract void gas(double amount);
    public abstract void brake(double amount);
    public abstract void turnRight();
    public abstract void turnLeft();

    protected abstract double speedFactor();

    public abstract Engine getCarEngine();


}

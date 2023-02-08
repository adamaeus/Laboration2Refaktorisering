package Architechture;

import Operations.MovingSystem;
import Vehicles.Components.Engine;

import java.awt.*;

public abstract class Car {

    public Car (String modelName, Color color, int nrDoors, double weight) {
        this.modelName = modelName;
        this.nrDoors = nrDoors;
        this.color = color;
        this.weight = weight;
    }

    private final double weight;
    private final Color color;
    private final String modelName;
    private final int nrDoors;
    private double currentSpeed;


    public String getModelName() { return modelName; }
    public int getNrDoors() {return nrDoors;}
    public Color getColor() {return color;}
    public double getWeight() {return weight;}
    public double getCurrentSpeed() {return currentSpeed;}


    protected abstract void move();
    protected abstract void gas();
    protected abstract void brake();
    protected abstract void turnRight();
    protected abstract void turnLeft();

    public abstract double speedFactor();


}

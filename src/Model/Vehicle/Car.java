package Model.Vehicle;

import Model.MovingPackage.MovingSystem;

import java.awt.*;

public abstract class Car implements iVehicle {

    public Car (String modelName, Color color, int nrDoors, double weight) {
        this.modelName = modelName;
        this.nrDoors = nrDoors;
        this.color = color;
        this.weight = weight;
    }


    //----------ATTRIBUTES----------\\
    protected MovingSystem carMovingSystem = new MovingSystem();
    private final double weight;
    private final Color color;
    private final String modelName;
    private final int nrDoors;




    //----------METHODS----------\\

    @Override
    public abstract Engine getEngine();
    public MovingSystem getMovingSystem() {
        return carMovingSystem;
    }
    public abstract double getCurrentSpeed();
    public String getModelName() { return modelName; }
    public int getNrDoors() {return nrDoors;}
    public Color getColor() {return color;}
    public abstract double getWeight();



    protected abstract void move();

    public abstract void gas(double amount);
    public abstract void brake(double amount);
    public abstract void turnRight();
    public abstract void turnLeft();

    protected abstract double speedFactor();





}

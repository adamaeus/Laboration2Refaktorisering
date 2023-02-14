package Architechture;

import Operations.Interfaces.iVehicle;
import Operations.MovingSystem;
import Vehicles.Components.Engine;

import java.awt.*;

public abstract class Truck implements iVehicle {




    public Truck(String modelName, int nrDoors, Color color, double weight) {
        this.modelName = modelName;
        this.nrDoors = nrDoors;
        this.color = color;
        this.weight = weight;

    }

    public MovingSystem getTruckMovingSystem (){
        return truckMovingSystem;
    }
    protected MovingSystem truckMovingSystem = new MovingSystem();


    @Override
    public MovingSystem getMovingSystem() {
        return truckMovingSystem;
    }


    private String modelName;
    private int nrDoors;
    private Color color;
    private double weight;
    private double currentSpeed;



    public String getModelName() { return modelName; }
    public int getNrDoors() {return nrDoors;}
    public Color getColor() {return color;}
    public double getWeight() {return weight;}
    public abstract double getCurrentSpeed();


    protected abstract void openRamp();

    protected abstract void closeRamp();

    protected abstract void load(Car car);

    protected abstract void unLoad();

    protected abstract void move();

    protected abstract void turnLeft();

    protected abstract void turnRight();

    @Override
    public abstract void gas(double amount);

    @Override
    public abstract void brake(double amount);

    protected abstract double speedFactor();

    @Override
    public abstract Engine getEngine();



}

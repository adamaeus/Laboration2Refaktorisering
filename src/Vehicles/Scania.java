package Vehicles;

import Architechture.Car;
import Architechture.Truck;
import Operations.MovingSystem;
import Vehicles.Components.Engine;
import Vehicles.Components.TruckBed;
import Vehicles.Components.TruckBed;

import java.awt.*;

public class Scania extends Truck {


    Engine scaniaEngine = new Engine(250);


    TruckBed scaniaTruckBed = new TruckBed(1000, 70, "ScaniaFlak");


    public Scania() {
        super("Scania", 2, Color.BLUE, 2000);
    }



    //TODO FIXA DENNA VICINITY METODEN
    /*
    public boolean carVicinity(Car car){
        return Math.abs(car.getX() - getX()) <= 5.0 && (Math.abs(car.getY() - getY()) <= 5.0);

    }
    */

    @Override
    public double getCurrentSpeed() {
        return scaniaEngine.getCurrentSpeed();
    }

    @Override
    public void openRamp() {
        if((scaniaEngine.getCurrentSpeed() == 0)){
            scaniaTruckBed.openRamp();
        }
    }

    @Override
    public void closeRamp() {
        if (scaniaEngine.getCurrentSpeed() == 0) {
            scaniaTruckBed.closeRamp();
        }
    }
    public void setScaniaAngle(double amount){
        if (scaniaEngine.getCurrentSpeed() == 0) {
            if (scaniaTruckBed.getCurrentAngle() >= 1) {
                scaniaTruckBed.setAngle(amount);
            }
        }
    }


    @Override
    protected void load(Car car) {
        if(scaniaEngine.getCurrentSpeed() == 0){
            scaniaTruckBed.load(car);
        }
    }


    @Override
    protected void unLoad() {
        if (scaniaEngine.getCurrentSpeed() == 0) {
            scaniaTruckBed.unload();
        }
    }


    @Override
    protected void move() {
        truckMovingSystem.move(scaniaEngine.getCurrentSpeed());
    }

    @Override
    protected void turnLeft() {
        truckMovingSystem.turnLeft();
    }

    @Override
    protected void turnRight() {
        truckMovingSystem.turnRight();
    }

    @Override
    public void gas(double amount) {
        scaniaEngine.gas(amount, speedFactor());
    }

    // NYTT 22:30 10 feb (gjorde public)
    @Override
    public void brake(double amount) {
        scaniaEngine.brake(1.0, speedFactor());
    }

    @Override
    protected double speedFactor() {
        return Math.max(scaniaEngine.getEnginePower() * 0.01 - (scaniaTruckBed.getCarryCapacity() * 0.001), 01);
    }

    @Override
    public Engine getEngine() {
        return scaniaEngine;
    }


    public TruckBed getScaniaTruckBed(){
        return scaniaTruckBed;
    }
}

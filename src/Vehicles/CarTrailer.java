package Vehicles;

import Architechture.Car;
import Architechture.Truck;
import Vehicles.Components.Engine;
import Vehicles.Components.TruckBed;

import java.awt.*;

public class CarTrailer extends Truck {



    Engine trailerEngine = new Engine(350);

    TruckBed trailerTruckBed = new TruckBed(2000, 1, "TrailerRamp");



    public CarTrailer() {
        super("CarTrailer", 2, Color.RED, 5000);
    }


    @Override
    public double getCurrentSpeed() {
        return trailerEngine.getCurrentSpeed();
    }


    @Override
    public void openRamp() {
        if (trailerEngine.getCurrentSpeed() == 0) {
            trailerTruckBed.openRamp();
        }
    }

    @Override
    protected void closeRamp() {
        if (trailerEngine.getCurrentSpeed() == 0) {
            trailerTruckBed.closeRamp();
        }
    }





    @Override
    protected void load(Car car) {
        if (trailerEngine.getCurrentSpeed() == 0) {
            trailerTruckBed.load(car);
        }
    }

    @Override
    protected void unLoad() {
        if (trailerEngine.getCurrentSpeed() == 0){
            trailerTruckBed.unload();
        }

    }



    @Override
    protected void move() {
        truckMovingSystem.move(getCurrentSpeed());
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
        trailerEngine.gas(amount, speedFactor());
    }


    // NYTT 22:30 10 feb (gjorde public
    @Override
    public void brake(double amount) {
        trailerEngine.brake(1.0, speedFactor());
    }


    @Override
    protected double speedFactor() {
            return Math.max(trailerEngine.getEnginePower() * 0.01 - (trailerTruckBed.getCarryCapacity() * 0.001), 0.1);
        }


        // NYTT 22:30 10 feb
    @Override
    public Engine getEngine() {
        return trailerEngine;
    }
}


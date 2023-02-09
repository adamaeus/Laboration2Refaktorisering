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




    @Override
    protected void openRamp(double amount) {
        if (scaniaEngine.getCurrentSpeed() == 0) {
            scaniaTruckBed.openRamp(amount);
        }
    }

    @Override
    protected void closeRamp(double amount) {
        if (scaniaEngine.getCurrentSpeed() == 0) {
            scaniaTruckBed.closeRamp();
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
    protected void gas() {
        scaniaEngine.gas(1.0, speedFactor());
    }

    @Override
    protected void brake() {
        scaniaEngine.brake(1.0, speedFactor());
    }

    @Override
    protected double speedFactor() {
        return Math.max(scaniaEngine.getEnginePower() * 0.01 - (scaniaTruckBed.getCarryCapacity() * 0.001), 01);
    }
}

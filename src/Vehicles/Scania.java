package Vehicles;

import Architechture.Car;
import Architechture.Truck;
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



    /**
     * 8 feb. 22:55
     * Lade till kravet open och close ramp endast kan ske om farten är 0.
     */
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



    /**
     * 8 feb. 22:55
     * Lade till kravet på att lastning och avlastning endast kan ske om farten är 0.
     */
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

    /**
     * 23:05
     * fixade delegering från engine i båda truckarna, alltså trailer/scania -> till sin respektive engine, från engine -> movingsystem.
     */
    @Override
    protected void move() {
        scaniaEngine.move();
    }

    @Override
    protected void turnLeft() {
        scaniaEngine.turnLeft();
    }

    @Override
    protected void turnRight() {
        scaniaEngine.turnRight();
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

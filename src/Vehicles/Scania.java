package Vehicles;

import Architechture.Car;
import Architechture.Truck;
import Vehicles.Components.Engine;
import Vehicles.Components.TruckBed;
import Vehicles.Components.TruckBed;

import java.awt.*;

public class Scania extends Truck {


    Engine scaniaEngine = new Engine(300);

    TruckBed scaniaTruckBed = new TruckBed(1000, 70, "ScaniaFlak");


    public Scania(String modelName, int nrDoors, Color color, double weight) {
        super("Scania", 2, Color.BLUE, 2000);
    }




    @Override
    protected void openRamp(double amount) {
        scaniaTruckBed.openRamp(amount);
    }

    @Override
    protected void closeRamp(double amount) {
        scaniaTruckBed.closeRamp(amount);
    }

    @Override
    protected void load(Car car) {
        scaniaTruckBed.load(car);
    }


    @Override
    protected void unLoad() {
        scaniaTruckBed.unload();
    }

    @Override
    protected void move() {

    }

    @Override
    protected void turnLeft() {

    }

    @Override
    protected void turnRight() {

    }

    @Override
    protected void gas() {

    }

    @Override
    protected void brake() {

    }

    @Override
    protected void speedFactor() {

    }
}

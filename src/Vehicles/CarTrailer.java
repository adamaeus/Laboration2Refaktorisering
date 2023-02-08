package Vehicles;

import Architechture.Car;
import Architechture.Truck;
import Vehicles.Components.Engine;
import Vehicles.Components.TruckBed;

import java.awt.*;

public class CarTrailer extends Truck {



    Engine trailerEngine = new Engine(300);

    TruckBed trailerTruckBed = new TruckBed(2000, 1, "TrailerRamp");




    public CarTrailer(String modelName, int nrDoors, Color color, double weight) {
        super("CarTrailer", 2, Color.RED, 5000);
    }

    @Override
    protected void openRamp(double amount) {
        trailerTruckBed.openRamp(1);
    }

    @Override
    protected void closeRamp(double amount) {
        trailerTruckBed.closeRamp(0);
    }

    @Override
    protected void load(Car car) {
        trailerTruckBed.load(car);
    }

    @Override
    protected void unLoad() {

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

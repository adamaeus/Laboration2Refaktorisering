package Vehicles;

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
    protected void openRamp() {

    }

    @Override
    protected void closeRamp() {

    }

    @Override
    protected void load() {

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
}

package Vehicles;

import Architechture.Car;
import Architechture.Truck;
import Operations.MovingSystem;
import Vehicles.Components.Engine;
import Vehicles.Components.TruckBed;

import java.awt.*;

public class CarTrailer extends Truck {



    Engine trailerEngine = new Engine(350);

    TruckBed trailerTruckBed = new TruckBed(2000, 1, "TrailerRamp");

    MovingSystem trailerMovingSystem = new MovingSystem();


    public CarTrailer() {
        super("CarTrailer", 2, Color.RED, 5000);
    }



    /**
     * 8 feb. 22:55
     * Lade till kravet open och close ramp endast kan ske om farten är 0.
     */
    @Override
    protected void openRamp(double amount) {
        if (trailerEngine.getCurrentSpeed() == 0) {
            trailerTruckBed.openRamp(1);
        }
    }

    @Override
    protected void closeRamp(double amount) {
        if (trailerEngine.getCurrentSpeed() == 0) {
            trailerTruckBed.closeRamp();
        }
    }




    /**
     * 8 feb. 22:55
     * Lade till kravet på att lastning och avlastning endast kan ske om farten är 0.
     */
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

    /**
     * 23:05
     * fixade delegering från engine i båda truckarna, alltså trailer/scania -> till sin respektive engine, från engine -> movingsystem.
     */

    @Override
    protected void move() {
        trailerMovingSystem.move(getCurrentSpeed());
    }

    @Override
    protected void turnLeft() {
        trailerMovingSystem.turnLeft();
    }

    @Override
    protected void turnRight() {
        trailerMovingSystem.turnRight();
    }

    /**
     * Fixade gas metoderna i båda truckarna.
     */
    @Override
    protected void gas() {
        trailerEngine.gas(1.0, speedFactor());
    }

    @Override
    protected void brake() {
        trailerEngine.brake(1.0, speedFactor());
    }

    /**
     * Speedfactor för en truck tänker jag. Flaket väger en del, alltså 3.5 (engine) - 2
     * @return
     */
    @Override
    protected double speedFactor() {
            return Math.max(trailerEngine.getEnginePower() * 0.01 - (trailerTruckBed.getCarryCapacity() * 0.001), 0.1);
        }
    }


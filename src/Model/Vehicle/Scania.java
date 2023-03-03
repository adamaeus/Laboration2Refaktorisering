package Model.Vehicle;

import Model.LoadingPackage.TruckBed;

import java.awt.*;
import State.*;

public class Scania extends Truck {


    // private för att scaniaEngine bara ska ha åtkomst inne i Scania. final för att den ändras aldrig.
    private final Engine scaniaEngine = new Engine(250);


    private final TruckBed scaniaTruckBed = new TruckBed(1000, 70, "ScaniaFlak");


    State ScaniaState;
    public Scania() {
        super("Scania", 2, Color.BLUE, 2000);
        this.ScaniaState = new ClosedState();
    }



    //TODO FIXA DENNA VICINITY METODEN
    /*
    public boolean carVicinity(Car car){
        return Math.abs(car.getX() - getX()) <= 5.0 && (Math.abs(car.getY() - getY()) <= 5.0);

    }
    */


    @Override
    public iVehicle create() {
        return this;
    }

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


    //@Override
    public void load(Car car) {
        ScaniaState = new OpenState();
        if(scaniaEngine.getCurrentSpeed() == 0){
            scaniaTruckBed.load(car);
        }
    }



    protected void unLoad() {
        if (scaniaEngine.getCurrentSpeed() == 0) {
            scaniaTruckBed.unload();
        }
    }



    @Override
    protected void move() {
        ScaniaState.move();
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
        scaniaEngine.brake(0.5, speedFactor());
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

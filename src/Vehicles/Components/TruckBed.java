package Vehicles.Components;

import Architechture.Car;
import Operations.LoadingSystem;


public class TruckBed {

    private LoadingSystem<Car> truckBedLoadingSystem = new LoadingSystem<>();


    public TruckBed(double carryCapacity, double maxAngle, String bedType) {
        this.carryCapacity = carryCapacity;
        this.maxAngle = maxAngle;
        this.bedType = bedType;
    }


    private final String bedType;
    private final double carryCapacity;
    private final double maxAngle;
    private double currentLoad;
    private double currentAngle;


    public double getCarryCapacity() {
        return carryCapacity;
    }

    public String getBedType() {
        return bedType;
    }

    public double getCurrentLoad() {return currentLoad;}

    public double getCurrentAngle() {return currentAngle;}

    public double getMaxAngle() {
        return maxAngle;
    }

    public LoadingSystem<Car> getTruckBedLoadingSystem() {
        return truckBedLoadingSystem;
    }




    //-------------------RAMP METHODS-------------------\\
    public void openRamp(double amount) {
        incrementAngle(amount);
    }

    private void incrementAngle(double amount) {
        while (currentAngle < amount) {
            currentAngle = Math.min(amount, maxAngle);
        }
    }

    /**
     * Avslutar med ramp metoderna, lite fix här, typ closeRamp ska itne ta input och bara stänga rampen direkt.
     */
    public void closeRamp() {
        decrementAngle(0);
    }

    private void decrementAngle(double amount) {
        if (amount == 0) {
            currentAngle = 0;
        } else { while (currentAngle > amount) {
                currentAngle = Math.min(getCurrentAngle() - amount, maxAngle);
            }
        }
    }


    //-------------------LOAD METHODS-------------------\\
    public void load(Car car) {
        if (loadHelper(car)){
            loadCar(car);
        }
    }
    private boolean loadHelper (Car car) {
        return getCurrentAngle() == getMaxAngle() &&
                (carryCapacity - getCurrentLoad()) > car.getWeight();
    }
    private void loadCar(Car car) {
            truckBedLoadingSystem.load(car);
            currentLoad = currentLoad + car.getWeight();
        }

    public void unload(){
        if(unLoadHelper()){
            unLoadCar();
        }
    }

    private boolean unLoadHelper(){
        return (getCurrentAngle() == getMaxAngle());
    }

    private void unLoadCar(){
        truckBedLoadingSystem.unLoad();
    }


}












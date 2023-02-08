package Vehicles.Components;

import Architechture.Car;
import Architechture.Truck;
import Operations.LoadingSystem;

import static java.lang.System.out;


public class TruckBed {

    private LoadingSystem<Car> truckBedLoading = new LoadingSystem<>();


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

    public LoadingSystem<Car> getTruckBedLoading() {
        return truckBedLoading;
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

    public void closeRamp(double amount) {
        decrementAngle(amount);
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
            truckBedLoading.load(car);
            currentLoad = currentLoad + car.getWeight();
        }

    public void unload(){
        if(unLoadHelper()){
            unLoadCar();
        }
    }
    private boolean unLoadHelper(){
        return (getCurrentAngle() == getMaxAngle() && Engine.getCurrentSpeed() == 0);
    }

    private void unLoadCar(){
        truckBedLoading.unLoad();
    }


}












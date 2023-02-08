package Vehicles.Components;

import Architechture.Car;
import Architechture.Truck;
import Operations.LoadingSystem;


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
    public double getCurrentLoad() {return (currentLoad);}
    public double getCurrentAngle() {return currentAngle;}
    public double getMaxAngle() {
        return maxAngle;
    }
    public LoadingSystem<Car> getTruckBedLoading() {
        return truckBedLoading;
    }


    public void openRamp(double amount){
        incrementAngle(amount);
    }


    private void incrementAngle(double amount){
        while(currentAngle < amount){
            currentAngle = Math.min(amount, maxAngle);
        }
    }

    public void closeRamp(double amount){

    }

}

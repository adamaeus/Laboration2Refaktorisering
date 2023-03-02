package Model.LoadingPackage;

import Model.Vehicle.Car;
import Model.LoadingPackage.LoadingSystem;


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
    public void openRamp() {
        setAngle(1);
    }
    public void closeRamp() {
        setAngle(0);
    }

    public void setAngle(double amount){
        if (currentAngle < amount){
            currentAngle = Math.min(amount, maxAngle);
        }else if (currentAngle > amount){
            currentAngle = Math.max(amount, 0);
        }
    }


    // slagit ihop dem till en som heter setAngke, scania har tillgång till den, men cartrailer ej.
    /*
    private void incrementAngle(double amount) {
        while (currentAngle < amount) {
            currentAngle = Math.min(amount, maxAngle);
        }
    }
    private void decrementAngle(double amount) {
        if (amount == 0) {
            currentAngle = 0;
        } else { while (currentAngle > amount) {
                currentAngle = Math.min(getCurrentAngle() - amount, maxAngle);
            }
        }
    }
    */

    public void closeRamp(){
        setAngle(0);
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
        if(getCurrentAngle() == getMaxAngle()){
            unLoadCar();
        }
    }

    private void unLoadCar(){
        truckBedLoadingSystem.unLoad();
    }


    public void openRamp() {
        setAngle(1);
    }
}












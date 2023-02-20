package Vehicles.Components;

import Operations.LoadingSystem;



public class CarMechanic<Car> {


    private final LoadingSystem<Car> mechanicLoadingSystem = new LoadingSystem<>();


    public double getAmountOfCarsInCarMechanic() {
        return mechanicLoadingSystem.returnSize();
    }

    int maxAmountOfCars;

    public CarMechanic(int maxAmountOfCars) {
        this.maxAmountOfCars = maxAmountOfCars;
    }


    public void loadToMechanic(Car car) {
        if (mechanicLoadingSystem.returnSize() <= maxAmountOfCars) {
            mechanicLoadingSystem.load(car);
            System.out.println(mechanicLoadingSystem.showStack());
        } else {
            System.out.println("Full Stack");
        }
    }


    public void unLoad() {
        mechanicLoadingSystem.unLoad();
    }








}

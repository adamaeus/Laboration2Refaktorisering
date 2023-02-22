package Model.Vehicle;

import Model.MovingPackage.MovingSystem;

public interface iVehicle {

    MovingSystem getMovingSystem();

    double getCurrentSpeed();

    Engine getEngine();

    void brake(double amount);

   void gas(double amount);

    // interface for "generalising" a vehicle type.

}

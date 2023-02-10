package Vehicles.Components;

import Operations.MovingSystem;

public class Engine {


    MovingSystem engineMovingSystem = new MovingSystem();

    //--------------------CONSTRUCTOR--------------------\\


    public Engine (double enginePower){
        this.enginePower = enginePower;
    }


    private final double enginePower;
    private double currentSpeed;



    public double getEnginePower() { return enginePower; }

    public double getCurrentSpeed() {return currentSpeed;}



    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0.0;
    }





    public void gas(double amount, double speedFactor){
        if (amount >= 0 && amount <= 1.0){
            incrementSpeed(speedFactor, amount);
        }
    }


    public void brake(double amount, double speedFactor){
        if (amount >= 0 && amount <= 1){
            decrementSpeed(amount, speedFactor);
        }
    }


    private void incrementSpeed(double amount, double speedFactor) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor * amount, getEnginePower());
    }

    private void decrementSpeed(double amount, double speedFactor) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor * amount, 0);
    }


    /*

    //---------------MOVING-SYSTEM DELEGATING METHODS---------------\\
    public void move(){
        engineMovingSystem.move(getCurrentSpeed());
    }
    public void turnLeft(){
        engineMovingSystem.turnLeft();
    }
    public void turnRight(){
        engineMovingSystem.turnRight();
    }

*/

}

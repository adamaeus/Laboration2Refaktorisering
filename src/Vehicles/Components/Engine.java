package Vehicles.Components;

public class Engine {

    //--------------------CONSTRUCTOR--------------------\\


    public Engine (double enginePower){
        this.enginePower = enginePower;
    }


    private double enginePower;
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



}

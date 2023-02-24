package Controller;

import Model.MovingPackage.TimerListener;
import Model.Vehicle.Saab95;
import Model.Vehicle.Scania;
import Model.Vehicle.iVehicle;
import View2d.View;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller {



    private final TimerListener timerListener = new TimerListener();


    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (iVehicle vehicle : timerListener.getVehicleList()) {
            vehicle.brake(brake);
        }
    }

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (iVehicle vehicle : timerListener.getVehicleList()) {
            vehicle.gas(gas);
        }
    }


    void turnLeft(){
        for(iVehicle vehicle : timerListener.getVehicleList()){
            vehicle.getMovingSystem().turnLeft();
        }
    }


    void turnRight(){
        for(iVehicle vehicle : timerListener.getVehicleList()){
            vehicle.getMovingSystem().turnRight();
        }
    }

    void stopEngine(){
        for(iVehicle vehicle : timerListener.getVehicleList()){
            vehicle.getEngine().stopEngine();
        }
    }

    void startEngine(){
        for(iVehicle vehicle : timerListener.getVehicleList()){
            vehicle.getEngine().startEngine();
        }
    }

    void turnTurboOn(){
        for(iVehicle vehicle : timerListener.getVehicleList()) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    void lowerBedButton(){
        for(iVehicle vehicle : timerListener.getVehicleList()){
            if(vehicle instanceof Scania) {
                ((Scania) vehicle).openRamp();
                ((Scania) vehicle).setScaniaAngle(70);
                if(((Scania) vehicle).getScaniaTruckBed().getCurrentAngle() == 70){
                    System.out.println("ramp is open");
                }
            }
        }
    }


    void liftBedButton(){
        for(iVehicle vehicle : timerListener.getVehicleList()){
            if(vehicle instanceof Scania) {
                ((Scania) vehicle).getScaniaTruckBed().closeRamp();
            }
        }
    }
}

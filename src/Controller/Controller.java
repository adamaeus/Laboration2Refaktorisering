package Controller;

import MediatorPackage.ControllerInterface;
import Model.MovingPackage.World;
import Model.Vehicle.Saab95;
import Model.Vehicle.Scania;
import Model.Vehicle.iVehicle;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;

public class Controller implements ControllerInterface {


    private final World world;




    int gasAmount = 0;
    int brakeAmount = 0;

    public Controller(World world) {
        this.world = world;
    }


    //--------------------CREATE ACTIONLISTENERS--------------------\\
    @Override
    public ActionListener createStartEngineActionListener() {
        return e -> startEngine();
    }

    @Override
    public ActionListener createStopEngineActionListener() {
        return e -> stopEngine();
    }

    @Override
    public ActionListener createTurnLeftActionListener() {
        return e -> turnLeft();
    }

    @Override
    public ActionListener createTurnRightActionListener() {
        return e -> turnRight();
    }

    @Override
    public ActionListener createTurnTurboOnActionListener(){
        return e -> turnTurboOn();
    }

    @Override
    public ActionListener createTurnTurboOffActionListener() {
        return e -> turnTurboOff();
    }

    @Override
    public ActionListener createGasActionListener() {
        return e -> gas(gasAmount);
    }

    @Override
    public ActionListener createBrakeActionListener() {
        return e -> brake(brakeAmount);
    }

    @Override
    public ActionListener createTruckBedLowerActionListener() {
        return e -> lowerBedButton();
    }


    @Override
    public ActionListener createTruckBedLiftActionListener() {
        return e -> liftBedButton();
    }

    @Override
    public ActionListener createAddCarButton (){
        return e -> addCarButton();
    }

    @Override
    public ActionListener createRemoveCarButton(){
        return e -> removeCarButton();
    }


    @Override
    public ChangeListener createGasSpinnerActionListener() {
        return e -> gasAmount = (int) ((JSpinner) e.getSource()).getValue();
    }

    @Override
    public ChangeListener createBrakeSpinnerACtionListener() {
        return e -> brakeAmount = (int) ((JSpinner) e.getSource()).getValue();
    }


    //--------------------------------------------------//


    //--------------------METHOD DELEGATION TO MODEL--------------------\\

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (iVehicle vehicle : world.getVehicleList()) {
            vehicle.brake(brake);
        }
    }

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (iVehicle vehicle : world.getVehicleList()) {
            vehicle.gas(gas);
        }
    }


    void turnLeft() {
        for (iVehicle vehicle : world.getVehicleList()) {
            vehicle.getMovingSystem().turnLeft();
        }
    }


    void turnRight() {
        for (iVehicle vehicle : world.getVehicleList()) {
            vehicle.getMovingSystem().turnRight();
        }
    }

    void stopEngine() {
        for (iVehicle vehicle : world.getVehicleList()) {
            vehicle.getEngine().stopEngine();
        }
    }

    public void startEngine() {
        System.out.println("start Engine");
        for (iVehicle vehicle : world.getVehicleList()) {
            vehicle.getEngine().startEngine();
        }
    }

    void turnTurboOn() {
        for (iVehicle vehicle : world.getVehicleList()) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    void turnTurboOff() {
        for (iVehicle vehicle : world.getVehicleList()) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    void lowerBedButton() {
        for (iVehicle vehicle : world.getVehicleList()) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).openRamp();
                ((Scania) vehicle).setScaniaAngle(70);
                if (((Scania) vehicle).getScaniaTruckBed().getCurrentAngle() == 70) {
                    System.out.println("ramp is open");
                }
            }
        }
    }


    void liftBedButton(){
        for(iVehicle vehicle : world.getVehicleList()){
            if(vehicle instanceof Scania) {
                ((Scania) vehicle).getScaniaTruckBed().closeRamp();
            }
        }
    }

    void addCarButton(){
        System.out.println("addCarButton");
        world.addCars();
    }


    void removeCarButton(){
        world.removeCars();
    }

}


package GUI;


import Architechture.Car;
import Architechture.Truck;
import Operations.Interfaces.iVehicle;
import Operations.MovingSystem;
import Vehicles.Saab95;
import Vehicles.Scania;
import Vehicles.Volvo240;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.System.out;

/*
* * This class represents the Controller part in the MVC pattern
* * It's responsibilities is to listen to the View and responds in a appropriate manner by
* * modifying the model state and the updating the view.
 */

public class CarController {

    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;

    ArrayList <iVehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();


        cc.vehicles.add(new Volvo240());
        cc.vehicles.add(new Saab95());
        cc.vehicles.add(new Scania());







    }


    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */


    //getPosition() , vet inte om användbar eller ej
    private class TimerListener implements ActionListener {



        public void actionPerformed(ActionEvent e) {
            for (iVehicle vehicle : vehicles) {
                if(carHitsWall(vehicle))
                {
                    brakeAndTurnAround(vehicle);
                }
                out.println(vehicle.getMovingSystem().getY());
                out.println(frame.getDrawPanelYCoordinate());

                vehicle.getMovingSystem().move(vehicle.getCurrentSpeed());
                int x = (int) Math.round(vehicle.getMovingSystem().getX());
                int y = (int) Math.round(vehicle.getMovingSystem().getY());
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
            }



        }



    // NYTT. 23:00 10 feb.

    void brakeAndTurnAround(iVehicle vehicle){
        vehicle.getEngine().stopEngine();

        for (int i = 0; i < 2; i++) {
            vehicle.getMovingSystem().turnRight();
        }
        vehicle.getEngine().startEngine();

    }




    // FIXA FÖR VEHICLE
    public boolean carHitsWall(iVehicle vehicle){
        //parameters
        double carYPos = vehicle.getMovingSystem().getY();
        double carXPos = vehicle.getMovingSystem().getX();
        int topAndBottomFrame = frame.getDrawPanelYCoordinate()-50;
        int frameWalls = frame.getDrawPanelXCoordinate()-50;

        // collisions between car and wall
        boolean carHitsFloor = carYPos > topAndBottomFrame;
        boolean carHitsRightWall = carXPos > frameWalls;
        boolean carHitsRoof = carYPos < 0;
        boolean carHitsLeftWall = carXPos < 0;

        if(carHitsFloor){
            vehicle.getMovingSystem().setY(topAndBottomFrame);
        } else if (carHitsRoof) {
            vehicle.getMovingSystem().setY(0);
        } else if (carHitsLeftWall) {
            vehicle.getMovingSystem().setX(0);
        }
        else if (carHitsRightWall){
            vehicle.getMovingSystem().setX(frameWalls);
        }

        // true if collision occurs
        return (carHitsFloor || carHitsRightWall || carHitsRoof || carHitsLeftWall);
    }


    // TODO : SAMTLIGA BÖR LIGGA MED BUTTONWIDGET

    // NYTT. 23:00 10 feb.
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (iVehicle vehicle : vehicles) {
            vehicle.brake(brake);
        }
    }

    void gas(int amount) {
            double gas = ((double) amount) / 100;
            for (iVehicle vehicle : vehicles) {
                vehicle.gas(gas);
            }
    }

    // NYTT. 23:00 10 feb.
    void turnLeft(){
        for(iVehicle vehicle : vehicles){
            vehicle.getMovingSystem().turnLeft();
        }
    }

    // NYTT. 23:00 10 feb.
    void turnRight(){
        for(iVehicle vehicle : vehicles){
            vehicle.getMovingSystem().turnRight();
        }
    }

    void stopEngine(){
        for(iVehicle vehicle : vehicles){
            vehicle.getEngine().stopEngine();
        }
    }

    void startEngine(){
        for(iVehicle vehicle : vehicles){
            vehicle.getEngine().startEngine();
        }
    }

    void turnTurboOn(){
        for(iVehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    void lowerBedButton(){
        for(iVehicle vehicle : vehicles){
        if(vehicle instanceof Scania) {
            ((Scania) vehicle).openRamp();
            ((Scania) vehicle).setScaniaAngle(70);
            if(((Scania) vehicle).getScaniaTruckBed().getCurrentAngle() == 70){
                out.println("ramp is open");
            }
        }
        }
    }


    void liftBedButton(){
        for(iVehicle vehicle : vehicles){
            if(vehicle instanceof Scania) {
                ((Scania) vehicle).getScaniaTruckBed().closeRamp();
            }
        }
    }
}




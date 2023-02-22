package Model.MovingPackage;

import Controller.ButtonWidget;
import Controller.Controller;
import Model.Vehicle.Saab95;
import Model.Vehicle.Scania;
import Model.Vehicle.Volvo240;
import Model.Vehicle.iVehicle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.System.out;

public class TimerListener implements ActionListener {

    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new CarController.TimerListener());


    private ArrayList <iVehicle> vehicles = new ArrayList<>();

    Volvo240 volvo = new Volvo240();
    Saab95 saab95 = new Saab95();
    Scania scania = new Scania();

    public ArrayList<iVehicle> getVehicleList(){
        vehicles.add(volvo);
        vehicles.add(saab95);
        vehicles.add(scania);
        return vehicles;
    }




    public void actionPerformed(ActionEvent e) {

        for (iVehicle vehicle : vehicles) {
            if(carHitsWall(vehicle))
            {
                brakeAndTurnAround(vehicle);
            }

            vehicle.getMovingSystem().move(vehicle.getCurrentSpeed());
            int x = (int) Math.round(vehicle.getMovingSystem().getX());
            int y = (int) Math.round(vehicle.getMovingSystem().getY());
            frame.drawPanel.moveit(x, y);
            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();
        }
    }

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
}

package GUI;

import Architechture.Car;
import Operations.MovingSystem;
import Vehicles.Saab95;
import Vehicles.Volvo240;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.System.out;

/*
* This class represents the Controller part in the MVC pattern
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
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
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();



    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */


    //getPosition() , vet inte om användbar eller ej
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {

                   out.println(car.getCarMovingSystem().getY());
                   out.println(frame.getDrawPanelYCoordinate());
                   if(car.getCarMovingSystem().getY() > frame.getDrawPanelYCoordinate() - 100){
                       car.getCarEngine().stopEngine();
                       car.brake(100);
                   }

                    car.getCarMovingSystem().move(car.getCurrentSpeed());
                    int x = (int) Math.round(car.getCarMovingSystem().getX());
                    int y = (int) Math.round(car.getCarMovingSystem().getY());
                    frame.drawPanel.moveit(x, y);
                    // repaint() calls the paintComponent method of the panel
                    frame.drawPanel.repaint();
                }
            }
        }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    public boolean carHitsWall(Car car){
        //parameters
        double carYPos = car.getCarMovingSystem().getY();
        double carXPos = car.getCarMovingSystem().getX();
        int topAndBottomFrame = frame.getDrawPanelXCoordinate();
        int frameWalls = frame.getDrawPanelYCoordinate();
        // collisions between car and wall
        boolean carHitsFloor = carYPos > topAndBottomFrame;
        boolean carHitsRoof = carYPos < topAndBottomFrame;
        boolean carHitsRightWall = carXPos > frameWalls;
        boolean carHitsLeftWall = carXPos < frameWalls;
        // true if collision occurs
        return (carHitsFloor);
    }


    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
        }
    }




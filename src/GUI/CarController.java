package GUI;

import Animals.Kangaroo;
import Animals.KangarooKid;
import Architechture.Animal;
import Architechture.Car;
import Architechture.Truck;
import Operations.MovingSystem;
import Vehicles.Saab95;
import Vehicles.Scania;
import Vehicles.Volvo240;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

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
    ArrayList<Truck> trucks = new ArrayList<>();
    //ArrayList<Animal> animals = new ArrayList<>();


    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add( new Volvo240());
        cc.cars.add( new Saab95());


        cc.trucks.add( new Scania());
        //cc.objects.add((T) new Volvo240());


        // KANGAROO DAISY
        //cc.animals.add(new Kangaroo(Color.GRAY, 20, "DAISY"));

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
            actionPerformedTruck(e);
            for (Car car : cars) {
                car.getCarMovingSystem().move((car.getCurrentSpeed()));
                System.out.println(car.getCarMovingSystem().getX());
                System.out.println(car.getCarMovingSystem().getY());
                System.out.println(car.getCurrentSpeed());
                int x = (int) Math.round(car.getCarMovingSystem().getX());
                int y = (int) Math.round(car.getCarMovingSystem().getY());
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }


    // ACTION PERFOMED TRUCK
    public void actionPerformedTruck(ActionEvent e) {
        for (Truck truck : trucks) {
            truck.getTruckMovingSystem().move((truck.getCurrentSpeed()));
            System.out.println(truck.getTruckMovingSystem().getX());
            System.out.println(truck.getTruckMovingSystem().getY());
            System.out.println(truck.getTruckMovingSystem());
            int x = (int) Math.round(truck.getTruckMovingSystem().getX());
            int y = (int) Math.round(truck.getTruckMovingSystem().getY());
            frame.drawPanel.moveit(x, y);
            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }



    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            if(car.getCarMovingSystem().getY() > frame.drawPanel.getY()){
            }
            car.brake(brake);
        }
    }

    void turnRight(){
        for (Car car : cars){
            car.turnRight();
        }
    }

    void turnLeft(){
        for (Car car : cars){
            car.turnLeft();
        }
    }

    void startEngine(){
        for (Car car : cars){
            car.getCarEngine().startEngine();
        }
    }


}

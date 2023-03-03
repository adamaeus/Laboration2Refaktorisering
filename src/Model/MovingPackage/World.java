package Model.MovingPackage;

import Model.ListenerPackage.Observer;
import Model.Vehicle.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.System.out;


public class World {



    VehicleFactory vehicleFactory = new VehicleFactory();


    private final Timer timer;
    public World(){
        this.timer = new Timer(delay,new TimerListener());
        notifyObservers();
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    private final int delay = 50;

    private final ArrayList <iVehicle> vehicles = new ArrayList<>();
    public ArrayList<iVehicle> getVehicleList(){
        return vehicles;
    }

    private final List<Observer> observers = new ArrayList<>();

    // Add an observer to the list
    public void addObserver(Observer observer) {
        observers.add(observer);
    }


    // Remove an observer from the list
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Notify all observers that a vehicle has been moved
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    // CAR FACTORY CALL

    public void addCars () {
        if (vehicles.size() < 6) {
            Random rand = new Random();
            int boundRand = rand.nextInt(2);
            int position = vehicles.size() * 100;
            iVehicle vehicle = vehicleFactory.createRandomVehicle();
            vehicles.add(vehicle);
            vehicle.getMovingSystem().setY(position);
            notifyObservers();
        }
    }

        public void removeCars () {
            if (vehicles.size() > 0) {
                vehicles.remove(vehicles.size() - 1);
            }
        }


        public boolean carHitsWall (iVehicle vehicle){
            double carYPos = vehicle.getMovingSystem().getY();
            double carXPos = vehicle.getMovingSystem().getX();


            // collisions between car and wall
            boolean carHitsFloor = carYPos > 510;
            boolean carHitsRightWall = carXPos > 750;
            boolean carHitsRoof = carYPos < 0;
            boolean carHitsLeftWall = carXPos < 0;

            if (carHitsFloor) {
                vehicle.getMovingSystem().setY(510);
            } else if (carHitsRoof) {
                vehicle.getMovingSystem().setY(0);
            } else if (carHitsLeftWall) {
                vehicle.getMovingSystem().setX(0);
            } else if (carHitsRightWall) {
                vehicle.getMovingSystem().setX(750);
            }

            // true if collision occurs
            return (carHitsFloor || carHitsRightWall || carHitsRoof || carHitsLeftWall);

        }


        void brakeAndTurnAround (iVehicle vehicle){
            vehicle.getEngine().stopEngine();

            for (int i = 0; i < 2; i++) {
                vehicle.getMovingSystem().turnRight();
            }
            vehicle.getEngine().startEngine();

        }


        public class TimerListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {

                for (iVehicle vehicle : vehicles) {
                    if (carHitsWall(vehicle)) {
                        brakeAndTurnAround(vehicle);
                    }
                    vehicle.getMovingSystem().move(vehicle.getCurrentSpeed());
                    System.out.println(vehicle);
                    System.out.println(vehicle.getMovingSystem().getX());
                    System.out.println(vehicle.getMovingSystem().getY());
                }
                notifyObservers();
            }
        }
    }

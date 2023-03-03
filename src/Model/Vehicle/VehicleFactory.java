package Model.Vehicle;

import java.awt.*;
import java.util.Random;

public class VehicleFactory {


    public iVehicle createVolvo() {
        return new Volvo240();
    }
    public iVehicle createSaab() {
        return new Saab95();
    }
    public iVehicle createScania() {
        return new Scania();
    }


    public iVehicle createRandomVehicle() {
        Random rand = new Random();
        int boundRand = rand.nextInt(1, 4);
        switch (boundRand) {
            case 1 -> {
                iVehicle volvo240 = createVolvo();
                return volvo240;
            }
            case 2 -> {
                iVehicle saab95 = createSaab();
                return  saab95;
            }
            case 3 -> {
                iVehicle scania = createScania();
                return  scania;
            }
        }
        return null;
    }
}

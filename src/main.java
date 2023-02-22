import Controller.Controller;
import Model.Vehicle.CarTrailer;
import Model.Vehicle.Saab95;
import Model.Vehicle.Scania;
import Model.Vehicle.Volvo240;

public class main {


    public static void main (String [] args){


        Controller cc = new Controller();


        cc.startEngine();
        // Start a new view and send a reference of self
        frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        timer.start();



    }
}

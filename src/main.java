import Controller.Controller;
import MediatorPackage.ButtonViewInterface;
import MediatorPackage.ControllerInterface;
import MediatorPackage.Mediator;
import Model.Vehicle.CarTrailer;
import Model.Vehicle.Saab95;
import Model.Vehicle.Scania;
import Model.Vehicle.Volvo240;
import View2d.ButtonControlPanel;
import View2d.DrawWorld;

public class main {


    public static void main (String [] args){


        ControllerInterface vehicleC = new Controller();
        ButtonViewInterface view = new ButtonControlPanel("knapp panel");
        Mediator knappMedlare = new Mediator(vehicleC, view);

        DrawWorld world = new DrawWorld();




/*

        cc.startEngine();
        // Start a new view and send a reference of self
        frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        timer.start();


 */


    }
}

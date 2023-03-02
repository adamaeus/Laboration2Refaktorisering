import Controller.Controller;
import Model.MovingPackage.World;
import Model.Vehicle.Scania;
import Model.Vehicle.Volvo240;
import Model.Vehicle.iVehicle;
import View2d.ControlPanel;
import View2d.Window;
import View2d.WorldPanel;

public class main {


    public static void main (String [] args){

        World world = new World();
        world.addCars();
        world.start();

        Window window = new Window(world);


       // Window window = new Window(world);

    }
}

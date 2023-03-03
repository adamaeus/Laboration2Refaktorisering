import Controller.Controller;
import Model.MovingPackage.World;
import Model.Vehicle.Scania;
import Model.Vehicle.VehicleFactory;
import Model.Vehicle.Volvo240;
import Model.Vehicle.iVehicle;
import View2d.ControlPanel;
import View2d.Window;
import View2d.WorldPanel;
import com.sun.jdi.VoidValue;

public class main {


    public static void main (String [] args){

        World world = new World();
        world.start();
        Window window = new Window(world);



    }
}

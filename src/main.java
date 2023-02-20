import Architechture.Car;
import Vehicles.CarTrailer;
import Vehicles.Saab95;
import Vehicles.Scania;

public class main {


    public static void main (String [] args){


        Scania scania = new Scania();

        CarTrailer carTrailer = new CarTrailer();



        scania.load(new Saab95());

        carTrailer.load(new Saab95());

        scania.load(new Saab95());
    }
}

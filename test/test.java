import Operations.Interfaces.Directions;
import Vehicles.Components.Engine;
import Vehicles.Volvo240;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class test {



    Volvo240 volvo;
    Directions direction;



    @Before
    public void before(){
        volvo = new Volvo240();
        direction = Directions.UP;
    }
    @After
    public void after(){
        volvo = null;
        direction = null;
    }


    @Test public void testTurnRight() {
        volvo.getCarMovingSystem().direction = Directions.UP;
        volvo.turnRight();
        assert (volvo.getCarMovingSystem().direction == Directions.RIGHT);

    }


    // BORDE KANSKE INFÖRA DELEGATORS SOM ISTÄLLET FÖR ATT KALLA PÅ GETTERS KAN DELEGERA METODANROPET DIREKT ISTÄLLET. TEX:
    // volvo.startEngineCall();
    @Test public void testTurnRightAndDrive(){
        volvo.getCarMovingSystem().direction = Directions.UP;
        volvo.getVolvoEngine().startEngine();
        volvo.turnRight();
        volvo.getVolvoEngine().gas(1.0, volvo.getCurrentSpeed());
        volvo.getCarMovingSystem().move(volvo.getCurrentSpeed());
        volvo.getCarMovingSystem().move(volvo.getCurrentSpeed());
        assert (volvo.getCarMovingSystem().getX() > 0);
    }

    @Test public void testTurnLeftAndDrive(){
        volvo.getCarMovingSystem().direction = Directions.UP;
        volvo.getVolvoEngine().startEngine();
        volvo.turnLeft();
        volvo.getVolvoEngine().gas(1.0, volvo.getCurrentSpeed());
        volvo.getCarMovingSystem().move(volvo.getCurrentSpeed());
        volvo.getCarMovingSystem().move(volvo.getCurrentSpeed());
        assert (volvo.getCarMovingSystem().getX() < 0);
    }





}

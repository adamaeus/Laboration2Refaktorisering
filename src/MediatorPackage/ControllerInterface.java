package MediatorPackage;

import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;

public interface ControllerInterface {

    ActionListener createStartEngineActionListener();

    ActionListener createStopEngineActionListener();

    ActionListener createTurnLeftActionListener();

    ActionListener createTurnRightActionListener();

    ActionListener createTurnTurboOnActionListener();

    ActionListener createTurnTurboOffActionListener();

    ActionListener createGasActionListener();

    ActionListener createBrakeActionListener();

    ActionListener createTruckBedLowerActionListener();

    ActionListener createTruckBedLiftActionListener();

    ActionListener createAddCarButton();

    ActionListener createRemoveCarButton();

    ChangeListener createGasSpinnerActionListener();


    ChangeListener createBrakeSpinnerACtionListener();

}

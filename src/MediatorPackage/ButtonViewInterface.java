package MediatorPackage;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;

public interface ButtonViewInterface {


    void createStartEngineButton(ActionListener actionListener);

    void createStopEngineButton(ActionListener actionListener);

    void createTurnLeftButton(ActionListener actionListener);

    void createTurnRightButton(ActionListener actionListener);

    void createTurboOnButton(ActionListener actionListener);

    void createTurboOffButton(ActionListener actionListener);

    void createGasButton(ActionListener actionListener);

    void createBrakeButton(ActionListener actionListener);

    void createTruckBedLiftButton(ActionListener actionListener);

    void createTruckBedLowerButton(ActionListener actionListener);

    void createGasSpinner(ChangeListener changeListener);

    void createBrakeSpinner( ChangeListener changeListener);
}

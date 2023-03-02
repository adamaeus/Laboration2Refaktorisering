package MediatorPackage;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;

public interface ButtonViewInterface {





    JButton getStartEngineButton();


    JButton getStopEngineButton();

    JButton getTurnLeftButton();

    JButton getTurnRightButton();


    JButton getTurboOnButton();


    JButton getTurboOffButton();


    JButton getGasButton();

    JButton getBrakeButton();


    JButton getLiftBedButton();

    JButton getLowerBedButton();


    void createBrakeSpinner( ChangeListener changeListener);
}

package MediatorPackage;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Mediator{


    private final ButtonViewInterface view; // COntrolpanel
    private final ControllerInterface vehicleC;  // controller


    public Mediator (ControllerInterface vehicleC, ButtonViewInterface controlPanel){
        this.vehicleC = vehicleC;
        this.view = controlPanel;
        bindStartEngineButton();
        bindStopEngineButton();
        bindTurnRightButton();
        bindTurnLeftButton();
        bindAddCarButton();
        bindRemoveCarButton();
        bindGasButton();
        bindGasSpinnerButton();
        bindBrakeButton();
        bindBrakeSpinnerButton();
        bindTurboOnButton();
        bindTurboOffButton();
        bindLowerTruckBedButton();
        bindLiftTruckBedButton();
    }

    public void bindStartEngineButton() {
        view.getStartEngineButton().addActionListener(vehicleC.createStartEngineActionListener());
    }

    public void bindStopEngineButton(){
        view.getStopEngineButton().addActionListener(vehicleC.createStopEngineActionListener());
    }

    public void bindTurnLeftButton(){
        view.getTurnLeftButton().addActionListener(vehicleC.createTurnLeftActionListener());
    }

    public void bindTurnRightButton(){
        view.getTurnRightButton().addActionListener(vehicleC.createTurnRightActionListener());
    }

    public void bindTurboOnButton(){
        view.getTurboOnButton().addActionListener(vehicleC.createTurnTurboOnActionListener());
    }

    public void bindTurboOffButton(){
        view.getTurboOffButton().addActionListener(vehicleC.createTurnTurboOffActionListener());
    }

    public void bindGasButton(){
        view.getGasButton().addActionListener(vehicleC.createGasActionListener());
    }

    public void bindBrakeButton(){
        view.getBrakeButton().addActionListener(vehicleC.createBrakeActionListener());
    }

    public void bindLowerTruckBedButton(){
        view.getLowerBedButton().addActionListener(vehicleC.createTruckBedLowerActionListener());
    }

    public void bindLiftTruckBedButton(){
        view.getLiftBedButton().addActionListener(vehicleC.createTruckBedLiftActionListener());
    }

    public void bindGasSpinnerButton(){
        view.getGasSpinner().addChangeListener(vehicleC.createGasSpinnerActionListener());
    }

    public void bindBrakeSpinnerButton(){
        view.getBrakeSpinner().addChangeListener(vehicleC.createBrakeSpinnerACtionListener());
    }

    public void bindAddCarButton(){
        view.getAddCarButton().addActionListener(vehicleC.createAddCarButton());
    }

    public void bindRemoveCarButton(){
        view.getRemoveCarButton().addActionListener(vehicleC.createRemoveCarButton());
    }
}



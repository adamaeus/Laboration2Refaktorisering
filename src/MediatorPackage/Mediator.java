package MediatorPackage;

public class Mediator {


    private final ButtonViewInterface view;
    private final ControllerInterface vehicleC;

    public Mediator (ControllerInterface vehicleC, ButtonViewInterface view){
        this.vehicleC = vehicleC;
        this.view = view;
    }




    public void bindStartEngineButton() {
        view.createStartEngineButton(vehicleC.createStartEngineActionListener());
    }

    public void bindStopEngineButton(){
        view.createStopEngineButton(vehicleC.createStopEngineActionListener());
    }

    public void bindTurnLeftButton(){
        view.createTurnLeftButton(vehicleC.createTurnLeftActionListener());
    }

    public void bindTurnRightButton(){
        view.createTurnRightButton(vehicleC.createTurnRightActionListener());
    }

    public void bindTurboOnButton(){
        view.createTurboOnButton(vehicleC.createTurnTurboOnActionListener());
    }

    public void bindTurboOffButton(){
        view.createTurboOffButton(vehicleC.createTurnTurboOffActionListener());
    }

    public void bindGasButton(){
        view.createGasButton(vehicleC.createGasActionListener());
    }

    public void bindBrakeButton(){
        view.createBrakeButton(vehicleC.createBrakeActionListener());
    }

    public void bindLowerTruckBedButton(){
        view.createTruckBedLowerButton(vehicleC.createTruckBedLowerActionListener());
    }

    public void bindLiftTruckBedButton(){
        view.createTruckBedLiftButton(vehicleC.createTruckBedLiftActionListener());
    }

    public void bindGasSpinnerButton(){
        view.createGasSpinner(vehicleC.createGasSpinnerActionListener());
    }
}



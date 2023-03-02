package View2d;

import MediatorPackage.ButtonViewInterface;
import MediatorPackage.Mediator;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel implements ButtonViewInterface {


    JButton startEngineButton;

    JButton stopEngineButton;

    JButton turnLeftButton;

    JButton turnRightButton;

    JButton turboOffButton;

    JButton turboOnButton;

    JButton gasButton;

    JSpinner gasSpinner;

    JSpinner brakeSpinner;

    JButton brakeButton;

    JButton liftBedButton;

    JButton lowerBedButton;

    JButton addCarButton;

    JButton removeCarButton;




    private static final int X = 800;
    private static final int Y = 800;

    public ControlPanel() {
        setLayout(new GridLayout(2, 4));
        setPreferredSize(new Dimension((X / 2) + 4, 200));
        setBackground(Color.CYAN);
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        createStartEngineButton();
        add(startEngineButton, 0);
        createStopEngineButton();
        add(stopEngineButton,1);
        createTurnRightButton();
        add(turnRightButton, 2);
        createTurnLeftButton();
        add(turnLeftButton, 3);
        createAddCarButton();
        add(addCarButton);
        createRemoveCarButton();
        add(removeCarButton);
        createGasPanelButton();
        add(gasPanel);
        createBrakeButton();
        add(brakeButton);

    }

    // ARRAYLIST MED KNAPPAR.


    private void createStartEngineButton() {
        startEngineButton = new JButton("Start all cars");
        startEngineButton.setForeground(Color.black);
        startEngineButton.setPreferredSize(new Dimension(X / 7 - 15, 100));
        startEngineButton.setBackground(Color.blue);
    }



    private void createStopEngineButton() {
        stopEngineButton = new JButton("Stop all cars");
        stopEngineButton.setBackground(Color.red);
        stopEngineButton.setForeground(Color.black);
        stopEngineButton.setPreferredSize(new Dimension(X / 7 - 15, 100));
    }


    private void createTurnLeftButton() {
        turnLeftButton = new JButton("Turn Right");
        turnLeftButton.setPreferredSize(new Dimension(X / 7 - 15, 100));
    }


    private void createTurnRightButton() {
        turnRightButton = new JButton("Turn left");
        turnRightButton.setPreferredSize(new Dimension(X / 7 - 15, 100));


    }


    private void createGasButton(){
        gasButton = new JButton("Gas");
        gasButton.setPreferredSize(new Dimension(X / 7 - 15, 100));
    }

    private void createGasPanelButton(){
        createGasSpinner();
        createGasButton();
        gasPanel.add(gasButton);
        gasPanel.add(gasSpinner);
        JLabel gasLabel = new JLabel("Amount of gas");
        add(gasLabel, BorderLayout.PAGE_START);
        add(gasSpinner, BorderLayout.PAGE_END);
        //gasPanel.add(gasLabel);
    }

    private void createBrakeButton(){
        brakeButton = new JButton("Brake");
        brakeButton.setPreferredSize(new Dimension(X / 7 - 15, 100));
        createBrakeSpinner();
    }


    private void createTruckBedLiftButton() {
        liftBedButton = new JButton("Lift Bed");
        liftBedButton.setPreferredSize(new Dimension(X / 7 - 15, 100));
    }


    private void createTruckBedLowerButton() {
        lowerBedButton = new JButton("Lower Bed");
        lowerBedButton.setPreferredSize(new Dimension(X / 7 - 15, 100));
    }


    private void createTurboOnButton() {
        turboOnButton = new JButton("Saab Turbo on");
        turboOnButton.setPreferredSize(new Dimension(X / 7 - 15, 100));

    }


    private void createTurboOffButton() {
        turboOffButton = new JButton("Saab Turbo off");
        turboOffButton.setPreferredSize(new Dimension(X / 7 - 15, 100));
    }


    private void createGasSpinner(){
        gasSpinner = new JSpinner(createSpinners());
        gasSpinner.setPreferredSize(new Dimension(X / 7 - 15, 100));
    }


    private void createBrakeSpinner() {
        brakeSpinner = new JSpinner(createSpinners());
    }

    JPanel gasPanel = new JPanel();


    private void createAddCarButton(){
        addCarButton = new JButton("Add car");
        addCarButton.setPreferredSize(new Dimension(X / 7 - 15, 100));
    }

    private void createRemoveCarButton(){
        removeCarButton = new JButton("Remove car");
        removeCarButton.setPreferredSize(new Dimension(X / 7 - 15, 100));
    }


    private SpinnerModel createSpinners() {
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        return spinnerModel;
    }




    public JButton getRemoveCarButton(){
        return removeCarButton;
    }


    public JButton getAddCarButton(){
        return addCarButton;
    }
    public JSpinner getGasSpinner(){
        return gasSpinner;
    }
    public JSpinner getBrakeSpinner(){
        return brakeSpinner;
    }
    public JButton getGasButton(){
        return gasButton;
    }
    public JButton getBrakeButton(){
        return brakeButton;
    }
    public JButton getLiftBedButton(){
        return liftBedButton;
    }
    public JButton getLowerBedButton(){
        return lowerBedButton;
    }
    public JButton getStartEngineButton(){
        return startEngineButton;
    }
    public JButton getStopEngineButton(){
        return stopEngineButton;
    }
    public JButton getTurnLeftButton(){
        return turnLeftButton;
    }
    public JButton getTurnRightButton() {
        return turnRightButton;
    }
    public JButton getTurboOnButton(){
        return turboOnButton;
    }
    public JButton getTurboOffButton(){
        return turboOffButton;
    }

}

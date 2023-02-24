package View2d;

import MediatorPackage.ButtonViewInterface;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonControlPanel extends JFrame implements ButtonViewInterface {







    private static final int X = 800;
    private static final int Y = 800;

    private JPanel controlPanel = new JPanel();
    private JPanel gasPanel = new JPanel();

    public ButtonControlPanel(String title) {
        createControlPanel(title);
        // Add any other components you want to the frame here
        // ...
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void createControlPanel(String title) {
        controlPanel.setLayout(new GridLayout(2, 4));
        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
    }



    private SpinnerModel createSpinners() {
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        return spinnerModel;
    }




    public void createGasSpinner(ChangeListener gasSpinnerActionListener){
        JSpinner gasSpinner = new JSpinner(createSpinners());
        JLabel gasLabel = new JLabel("Amount of gas");
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        gasSpinner.addChangeListener(gasSpinnerActionListener);
    }

    @Override
    public void createBrakeSpinner(ChangeListener changeListener) {
        JSpinner brakeSpinner = new JSpinner(createSpinners());
        brakeSpinner.addChangeListener(changeListener);
    }


    public void createGasButton(ActionListener gasActionListener){
        JButton gasButton = new JButton("Gas");
        gasPanel.setLayout(new BorderLayout());
        gasButton.addActionListener(gasActionListener);
    }


    public void createBrakeButton(ActionListener brakeActionListener){
        JButton brakeButton = new JButton("Brake");
        controlPanel.add(brakeButton, 4);
        brakeButton.addActionListener(brakeActionListener);
    }

    @Override
    public void createTruckBedLiftButton(ActionListener LiftBedActionListener) {
        JButton liftBedButton = new JButton("Lift Bed");
        controlPanel.add(liftBedButton, 5);
        liftBedButton.addActionListener(LiftBedActionListener);
    }

    @Override
    public void createTruckBedLowerButton(ActionListener lowerBedActionListener) {
        JButton lowerBedButton = new JButton("Lower Bed");
        controlPanel.add(lowerBedButton, 6);
        lowerBedButton.addActionListener(lowerBedActionListener);

    }


    public void createStartEngineButton(ActionListener startEngineActionListener) {
        JButton startButton = new JButton("Start all cars");
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        startButton.setBackground(Color.blue);
        startButton.addActionListener(startEngineActionListener);
    }

    @Override
    public void createStopEngineButton(ActionListener stopEngineActionListener) {
        JButton stopButton = new JButton("Stop all cars");
        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        stopButton.addActionListener(stopEngineActionListener);
    }

    @Override
    public void createTurnLeftButton(ActionListener turnLeftActionListener) {
        JButton turnLeftButton = new JButton("Turn Right");
        controlPanel.add(turnLeftButton, 1);
        turnLeftButton.addActionListener(turnLeftActionListener);
    }

    @Override
    public void createTurnRightButton(ActionListener turnRightActionListener) {
        JButton turnRightButton = new JButton("Turn left");
        controlPanel.add(turnRightButton, 2);
        turnRightButton.addActionListener(turnRightActionListener);

    }

    @Override
    public void createTurboOnButton(ActionListener turboOnActionListener) {
        JButton turboOnButton = new JButton("Saab Turbo on");
        controlPanel.add(turboOnButton, 3);
        turboOnButton.addActionListener(turboOnActionListener);
    }

    @Override
    public void createTurboOffButton(ActionListener turboOffActionListener) {
        JButton turboOffButton = new JButton("Saab Turbo off");
        controlPanel.add(turboOffButton, 7);
        turboOffButton.addActionListener(turboOffActionListener);
    }

}

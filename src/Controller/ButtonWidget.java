package Controller;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Model.MovingPackage.TimerListener;
import Model.Vehicle.iVehicle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



public class ButtonWidget extends JFrame {


    private static final int X = 800;
    private static final int Y = 800;

    Controller vehicleC;

    JPanel controlPanel = new JPanel();
    JPanel gasPanel = new JPanel();




    int gasAmount = 0;
    int brakeAmount = 0;





    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");








    /*
    // Constructor
    public CarView(String framename, Controller cc) {
        this.vehicleC = cc;
        initComponents(framename);
    }
*/
    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work


    //TODO CAR CONTROLLER (BUTTON WIDGET)
    // BRYT ISÄR OCH DELA UPP

    private void createButtons() {
        createTurboButton();
        createTurnRightButton();
        createTurnLeftButton();
        createStartEngineButton();
        createStopEngineButton();
        createGasSpinner();
        createBrakeSpinner();
        createBrakeButton();
    }

    private void createTurboOffButton(){
        JButton turboOffButton = new JButton("Saab Turbo off");
        controlPanel.add(turboOffButton, 7);
        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleC.turnTurboOff();
            }
        });

    }



    private void createBrakeButton(){
        JButton brakeButton = new JButton("Brake");
        controlPanel.add(brakeButton, 4);
        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleC.brake(brakeAmount);
            }
        });

    }

    private void createControlPanel() {
        controlPanel.setLayout(new GridLayout(2, 4));
        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);
    }



    private void createStopEngineButton() {
        JButton stopButton = new JButton("Stop all cars");
        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleC.stopEngine();
            }
        });
    }

    private void createStartEngineButton() {
        JButton startButton = new JButton("Start all cars");

        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        startButton.setBackground(Color.blue);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleC.startEngine();
            }
        });
    }


    private void createTurnLeftButton() {
        JButton turnLeftButton = new JButton("Turn Right");
        controlPanel.add(turnLeftButton, 1);
        turnLeftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleC.turnLeft();
            }
        });
    }

    private void createTurnRightButton() {

        JButton turnRightButton = new JButton("Turn left");

        controlPanel.add(turnRightButton, 2);
        turnRightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleC.turnRight();
            }
        });
    }

    private void createTurboButton() {

        JButton turboOnButton = new JButton("Saab Turbo on");

        controlPanel.add(turboOnButton, 3);
        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleC.turnTurboOn();
            }
        });
    }

    private void createGasButton(){

        JButton gasButton = new JButton("Gas");
        gasPanel.setLayout(new BorderLayout());

        gasButton.addActionListener(new ActionListener() {  // felix gör nu
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleC.gas(gasAmount);
            }
        });
    }
    private void createGasSpinner() {

        JSpinner gasSpinner = new JSpinner();
        JLabel gasLabel = new JLabel("Amount of gas");
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        gasSpinner = new JSpinner(createSpinners());
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });
    }

    private void createBrakeSpinner() {
        JSpinner brakeSpinner = new JSpinner();
        brakeSpinner = new JSpinner(createSpinners());
        brakeSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                brakeAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });
    }


    private SpinnerModel createSpinners() {
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        return spinnerModel;
}





    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        controlPanel.add(liftBedButton, 5);
        controlPanel.add(lowerBedButton, 6);


        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleC.liftBedButton();
            }
        });


        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleC.lowerBedButton();
            }
        });


        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        /*
        public int getDrawPanelXCoordinate () {
            return X;
        }

        public int getDrawPanelYCoordinate () {
            return (Y - 240);
        }

         */

    }
}

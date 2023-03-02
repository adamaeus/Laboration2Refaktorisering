package View2d;

import Controller.Controller;
import MediatorPackage.ControllerInterface;
import MediatorPackage.Mediator;
import Model.MovingPackage.World;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{



    private static final int X = 800;
    private static final int Y = 800;



/*

    public Window (World world){
        world = new World();
        ControlPanel controlPanel = new ControlPanel();
        ControllerInterface controller = new Controller(world);
        WorldPanel worldPanel = new WorldPanel(800,800, world);
        Mediator mediator = new Mediator(controller, controlPanel);
        add(controlPanel);
        setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        add(worldPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        initComponents("world");
    }

*/

    public Window(World world) {
        super("world");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ControlPanel controlPanel = new ControlPanel();
        Controller controller = new Controller(world);
        WorldPanel worldPanel = new WorldPanel(800, 800, world);
        Mediator mediator = new Mediator(controller, controlPanel);

        // Add the control panel to the top of the frame
        add(controlPanel, BorderLayout.NORTH);
        // Add the world panel to the center of the frame
        add(worldPanel, BorderLayout.CENTER);

        // Set the size of the frame
        setSize(X, Y);
        // Center the frame on the screen
        setLocationRelativeTo(null);
        // Make the frame visible
        setVisible(true);
    }

    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        //this.add(worldPanel);
        //this.add(mediator);
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

    }


}

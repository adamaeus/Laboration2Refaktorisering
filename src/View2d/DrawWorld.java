package View2d;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawWorld extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    // To keep track of a singel cars position


    BufferedImage scaniaImage;

    // NYTT
    BufferedImage saabImage;
    Point volvoPoint = new Point();


    // NYTT
    Point saabPoint = new Point();

    Point scaniaPoint = new Point();


    // TODO: MOVE TO BUTTONWIDGET IN CONTROLLER

    private static int witchCar = 1;

    // GJORDE CARPOINT. ¯\_(ツ)_/¯
    void moveit(int x, int y){
        switch (witchCar) {
            case 1 -> {
                volvoPoint.x = x;
                volvoPoint.y = y;
                witchCar++;
            }
            case 2 -> {
                saabPoint.x = x;
                saabPoint.y = y + 100;
                witchCar++;
            }
            case 3 -> {
                scaniaPoint.x = x;
                scaniaPoint.y = y + 200;
                witchCar++;
            }

        }
        if ( witchCar > 3){
            witchCar = 1;
        }

       // witchCar = witchCar + 1 % 3;
    }



    // TODO: MOVE TO VIEW PACKAGE
    // Initializes the panel and reads the images
    public DrawWorld(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "GUI.pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: GUI.pics -> MOVE *.jpg to GUI.pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawWorld.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawWorld.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawWorld.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null);
        g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);
        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);// see javadoc for more info on the parameters
    }


}

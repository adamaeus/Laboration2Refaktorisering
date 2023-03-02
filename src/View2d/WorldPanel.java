package View2d;


import Model.ListenerPackage.Observer;
import Model.MovingPackage.World;
import Model.Vehicle.Volvo240;
import Model.Vehicle.iVehicle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class WorldPanel extends JPanel implements Observer {

    World world;
    BufferedImage volvoImage;
    BufferedImage scaniaImage;
    BufferedImage saabImage;

    public WorldPanel(int x, int y, World world) {
        this.world = world;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.world.addObserver(this);
        this.setBackground(Color.green);
        try {

            volvoImage = ImageIO.read(WorldPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(WorldPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(WorldPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }
    @Override
    public void update(){
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (iVehicle vehicle : world.getVehicleList()){
                g.drawImage(volvoImage, (int) vehicle.getMovingSystem().getX(), (int) vehicle.getMovingSystem().getY(), null);
            //g.drawImage(saabImage, (int) vehicle.getMovingSystem().getX(), (int) vehicle.getMovingSystem().getY(), null);
            //g.drawImage(scaniaImage, (int) vehicle.getMovingSystem().getX(), (int) vehicle.getMovingSystem().getY(), null);// see javadoc for more info on the parameters
        }
    }














/*
    private void addPoint (){
        try {
            if (vehiclePoints.size() < 10) {
                vehiclePoints.add(new Point());
            } else
                throw new IndexOutOfBoundsException("Cannot add car: list is full");

        }catch (IndexOutOfBoundsException e){
            System.err.println(e.getMessage());
        }
    }

    private void removePoint(){
        try {
            if (vehiclePoints.size() > 0) {
                vehiclePoints.remove(vehiclePoints.size() - 1);
            } else
                throw new IndexOutOfBoundsException("Cannot remove car: list is empty");

        } catch (IndexOutOfBoundsException e) {
        System.err.println(e.getMessage());
        }
    }


*/





/*
    private static int witchCar = 1;

    public void updateListenerss(double x, double y) {

        switch (witchCar) {

            case 1 -> {
                volvoPoint.x = (int) x;
                volvoPoint.y = (int) y;
                witchCar++;
            }
            case 2 -> {
                saabPoint.x = (int) x;
                saabPoint.y = (int) (y + 100);
                witchCar++;
            }
            case 3 -> {
                scaniaPoint.x = (int) x;
                scaniaPoint.y = (int) (y + 200);
                witchCar++;
            }

        }
        repaint();
        if ( witchCar > 3){
            witchCar = 1;
        }



    }

 */



}

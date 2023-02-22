package Animals;

import Model.LoadingPackage.LoadingSystem;
import Model.MovingPackage.MovingSystem;

import java.awt.*;

//jykygjgjj
public class Kangaroo extends Animal {


    LoadingSystem <KangarooKid> pouch = new LoadingSystem<>();

    MovingSystem jumpingLocomotion = new MovingSystem();

    public Kangaroo(Color furColor, double weight, String name){
        this.furColor = furColor;
        this.weight = weight;
        this.name = name;
    }

    private double jumpingSpeed = 1.0;
    private Color furColor;
    private double weight;
    private String name;


    public void loadPouch(KangarooKid kid){
        pouch.load(kid);
    }

    @Override
    public void move (){
        jumpingLocomotion.move(jumpingSpeed);
    }

    @Override
    public void turnLeft(){
        jumpingLocomotion.turnLeft();
    }

    @Override
    public void turnRight(){
        jumpingLocomotion.turnRight();
    }


}

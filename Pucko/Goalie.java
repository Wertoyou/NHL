package Pucko;

import hockey.api.*;
import java.lang.Math;

public class Goalie extends GoalKeeper {
    // Middle of our own goalcage, on the goal line
    protected static final Position GOAL_POSITION = new Position(-2600, 0);

    // If something is shot towards the friendly goal
    private boolean shotAtGoal(IObject a){
        int x=a.getX();
        int y=a.getY();
        int d=a.getHeading();

        if(x<-2600) return false;
        if(a.getSpeed()<100) return false;

        double s1 = Util.datan2((92)-y,(-2600)-x);
        double s2 = Util.datan2((-92)-y,(-2600)-x);

        if (3 > Math.abs(Util.dangle(s1,s2) - (Util.dangle(s1,d) + Util.dangle(s2,d)))) {
            return true;
        }
        return false;
    }

    //Where in the goal something is heading to
    private int posInGoal(IObject a){
        int x=a.getX();
        int y=a.getY();
        int d=a.getHeading();

        return (int)(((x+2600)*Math.tan(Math.toRadians(180-d)))+y);
    }

    // Number of the goalie.
    public int getNumber() { return 1; }

    // Name of the goalie.
    public String getName() { return "The Goalie"; }

    // Left handed goalie
    public boolean isLeftHanded() { return true; }

    // Initiate
    public void init() { }

    // Face off
    public void faceOff() { }

    // Called when the goalie is about to receive a penalty shot
    public void penaltyShot() { }

    int desiredX=-2550;
    int desiredY;

    // Intelligence of goalie
    public void step() {
        int pX = getPuck().getX();
        int pY = getPuck().getY();

        if (pX < -2555) {
            pX = -2555;
        }
        turn(pX, pY, MAX_TURN_SPEED);

        if(pY<0) desiredY = -70;
        else desiredY = 70;

        if(shotAtGoal(getPuck())) desiredY = posInGoal(getPuck());

        if (shotAtGoal(getPuck())) {
            skate(desiredX, desiredY, MAX_SPEED);
            return;
        }

        int speed = (int)Math.sqrt(Math.pow(getX()-desiredX,2)+Math.pow(getY()-desiredY,2));

        skate(desiredX, desiredY, 2*speed);

        //Passa upp
        //FIXA så att denna passar en spelare
        if(hasPuck()){
            shoot(-2500, 1500, 3450);
        }
    }
}

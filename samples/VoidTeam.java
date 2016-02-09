package samples;

import java.awt.Color;
import hockey.api.*;
import java.lang.Math;

public class VoidTeam implements ITeam {
    public int getLuckyNumber() { return 324; }
    public String getShortName() { return "VOID"; }
    public String getTeamName() { return "Void"; }
    public Color getTeamColor() { return Color.WHITE; }
    public Color getSecondaryTeamColor() { return Color.WHITE; }
    public GoalKeeper getGoalKeeper() { return new Goalie(0); }
    public Player getPlayer(int index) { return new VoidPlayer(index); }
}

class VoidPlayer extends GoalKeeper {
    private static String[] names = {
    "Voidkeeper", "Left Voiddefender", "Right Voiddefender", 
    "Left Voidforward", "Right Voidforward", "Voidcenter"
    };
    private int index;

    public VoidPlayer(int index) { this.index = index; }
    public int getNumber() { return (int)(Math.random()*100); }
    public String getName() { return names[index]; }
    public boolean isLeftHanded() { return false; }
    public void step() { }
}

//package Pucko;

class Goalie extends GoalKeeper {
    // Middle of our own goalcage, on the goal line
    protected static final Position GOAL_POSITION = new Position(-2600, 0);

    // If something is shot towards the friendly goal
    private boolean shotAtGoal(IObject a){
        int x=a.getX();
        int y=a.getY();
        int d=a.getHeading();

        if(x<-2600) return false;
        if(a.getSpeed()<1000) return false;

        double s1 = Util.datan2((92)-y,(-2600)-x);
        double s2 = Util.datan2((-92)-y,(-2600)-x);

        if (3 > Math.abs(Util.dangle(s1,s2) - (Util.dangle(s1,d) + Util.dangle(s2,d)))) {
            return true;
        }
        return false;
    }

    public Goalie(int a){}

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

    int desiredX=-2555;
    int desiredY;

    // Intelligence of goalie
    public void step() {
        int pX = getPuck().getX();
        int pY = getPuck().getY();

        if (pX < -2555) {
            pX = -2555;
        }
        turn(pX, pY, MAX_TURN_SPEED);

        if(pY<0) desiredY = -73;
        else desiredY = 73;

        if(shotAtGoal(getPuck())) desiredY = posInGoal(getPuck());

        int speed = (int)Math.sqrt(Math.pow(getX()-desiredX,2)+Math.pow(getY()-desiredY,2));

        skate(desiredX, desiredY, speed);

        //Passa upp
        //FIXA så att denna passar en spelare
        if(hasPuck()){
            shoot(-1000,1500,2000);
        }
    }
}


package team5;

import hockey.api.GoalKeeper;
import hockey.api.Position;
import hockey.api.Util;


public class Goalie extends GoalKeeper {
    // Middle of our own goalcage, on the goal line
    protected static final Position GOAL_POSITION = new Position(-2600, 0);

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

    // Intelligence of goalie.
    public void step() {
        if(hasPuck()){
            shoot(2600,-10,1000);
        }
	//skate(GOAL_POSITION.getX() + 50, GOAL_POSITION.getY(), (int)Util.dist(getX()-(GOAL_POSITION.getX() + 50),getY()-(GOAL_POSITION.getY())));
	//turn(getPuck(), MAX_TURN_SPEED);
    //int x,y;
    //x = (getPuck().getX() - 29*2550)/30 ;
    //y = (getPuck().getY() + 0 )/30;
    //int dx = x-getX();
    //int dy = y-getY();
    //skate(x,y,(int)(Math.round(Math.sqrt(dx*dx+dy*dy))));
    //turn(getPuck(), MAX_TURN_SPEED);
      if (hasPuck()){
            shoot(2600, -10, 1000);
        }
        if (!getPuck().isHeld()) {
            if (Util.dist(getX() - getPuck().getX(),getY() - getPuck().getY()) < 100) {
           skate(getPuck(), 1000); // Go for puck
       }
    }
        int deltax;
        int deltay;
        int totdist;
        int gotoy;
        int gotox;
        deltax=getPuck().getX()-GOAL_POSITION.getX();
        deltay=getPuck().getY()-GOAL_POSITION.getY();
        totdist=(int)Util.dist(deltax,deltay);
        gotox=(int)75*deltax/totdist + GOAL_POSITION.getX();
        gotoy=(int)75*deltay/totdist + GOAL_POSITION.getY();
        skate(gotox,gotoy,100);
    turn(getPuck(), MAX_TURN_SPEED);

    }
}

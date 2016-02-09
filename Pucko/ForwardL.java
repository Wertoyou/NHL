package Pucko;

import hockey.api.*;
import java.lang.Math;

public class ForwardL extends BasePlayer {
    // Left handed?
    public boolean isLeftHanded() { return false; }

    // Number of forward
    public int getNumber() { return 15; }

    // Name of forward
    public String getName() { return "AttiPatti"; }
    private int a;
    //Face-off
    public void faceOff() {
        a=0;
    }

    // Intelligence of forward
    public void step() {
        ++a;
        setAimOnStick(true);
	    if (hasPuck()) {
            turn(0,MAX_TURN_SPEED);
	        shoot(2600, -40, MAX_SHOT_SPEED); // SHOOT!
	    }
        else if (hasPuck() && a>=100) {
            shoot(2600, -90, MAX_SHOT_SPEED);
        }
        //if (getX()==-(getPlayer(10).getX())) {a=0;}
        //if (Util.dist(getPlayer(5),getPlayer(11))<300) {a=0;}

        else if (a<10) {
            turn(-41,MAX_TURN_SPEED);
            skate(MAX_SPEED);
        }
        else {
            if(getPuck().getHolder().isOpponent()){
                skate(getPuck(),MAX_SPEED);
            }
            else if(getPuck().isHeld()){
                skate(getPuck().getX()-200,getPuck().getY(),MAX_SPEED);
            }
            else{
                skate(getPuck(),MAX_SPEED);
            }
	    }
    }
}

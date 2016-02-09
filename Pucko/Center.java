package Pucko;

import hockey.api.*;
import java.io.PrintStream;

public class Center extends BasePlayer {
    // Number of center player
    public int getNumber() { return 19; }

    // Name of center player
    public String getName() { return "Center"; }

    // Left handed?
    public boolean isLeftHanded() { return false; }

    int a;

    public void faceOff() {
        skate(0);
        turn(-130, MAX_TURN_SPEED);
        //a=0;
    }

    // Center player's intelligence
    public void step() {
        ++a;
        setAimOnStick(true);
        if (hasPuck() && getY()>-100){
            shoot(getPlayer(3).getX()+200, getPlayer(3).getY(), 1500);
            return;
        }
        if (hasPuck()){
            shoot(getPlayer(4).getX()+210, getPlayer(3).getY(), 1450);
            return;
        }

        //if (Util.dist(this,getPlayer(11))<300) {a=Math.min(0,a);}

        // Tekning
        if (a<5) {
            skate(0);
            turn(getHeading()-130, MAX_TURN_SPEED);
            return;
        }
        else{
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

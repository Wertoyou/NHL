package Pucko;

import hockey.api.*;
import java.lang.Math;

public class ForwardR extends BasePlayer {
    public boolean isLeftHanded() {return true;}
    // Number of forward
    public int getNumber() { return 15; }

    // Name of forward
    public String getName() { return "RightyMighty"; }
    int a;
    //Face-off
    public void faceOff() {
        a=0;
    }

    // Intelligence of forward
    public void step() {
        ++a;
        setAimOnStick(true);
        if (hasPuck() && a<100 && !(getY()>1400)) {
            shoot(2600, 40, MAX_SHOT_SPEED); // SHOOT!
        }
        if (hasPuck() && a>=100) {
            shoot(2600, 90, MAX_SHOT_SPEED);
        }

        if (getX()==-(getPlayer(11).getX())) {a=0;}
        if (a<10&&!hasPuck()) {
            turn(41,MAX_TURN_SPEED);
            skate(MAX_SPEED);
        }
        else if(Util.dist(this,getPuck())>3000 || getPuck().getX()<-500){
            skate(0,500, ((int)(2*Util.dist(getX()-0.0,getY()-500.0)))); // get the puck
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

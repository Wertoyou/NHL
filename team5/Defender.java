package team5;
import hockey.api.Util;

public class Defender extends BasePlayer {
    // Number of defender
    public int getNumber() { return 10; }

    // Name of defender
    public String getName() { return "Defender"; }

    // Make left defender left handed, right defender right handed.
    public boolean isLeftHanded() { return getIndex() == 1; }

    // Initiate
    public void init() {
	setAimOnStick(false);
    }

    // Defender intelligence
    public void step() {


        double ppx = (double)getPuck().getX();
        double ppy = (double)getPuck().getY();
        int px = (int)Math.round(ppx+getPuck().getSpeed()*0.1*Math.cos((double)(getPuck().getHeading())*3.1415927/180.0));
        int py = (int)Math.round(ppy+getPuck().getSpeed()*0.1*Math.sin((double)(getPuck().getHeading())*3.1415927/180.0));

        if(hasPuck()){
            if (hasPuck() && 950 < getX() && getX() < 2100 && ((-600 < getY()) && (getY() < 600))) {

                if (Math.abs(Util.dangle(getHeading(),Util.datan2(0 - getY(),2550 - getX()))) < 20) {


                    if (getY() > 600){
                        shoot(2600, 5, 10000);
                    }
                    else if (getY() < -600){
                        shoot(2600, -5, 10000);
                    }
                    else if (0 < getY()) {
                        if ((getPlayer(6).getY() + getPlayer(6).getStick().getY())/2 > 0){
                            shoot(2600, -50, 10000);
                        }
                        else {
                            shoot(2600, 50, 10000);
                        }
                    }
                    else {
                        if ((getPlayer(6).getY() + getPlayer(6).getStick().getY())/2 > 0){
                            shoot(2600, -50, 10000);
                        }
                        else {
                            shoot(2600, 50, 10000);
                        }
                    }

                    int target = (int)(Math.random()*200)-100;
                    shoot(2600, target, 10000); // Shoot!
                }
                else{
                    turn(2600,0,MAX_TURN_SPEED/2);
                }

                /*
                if(getY()>0)
                    shoot(2600, -50, 10000);
                else
                   shoot(2600, 50, 10000);*/
            }
            else if (hasPuck()) {
                if (getY() > 0) {
                    skate(2100, 300, MAX_SPEED);
                }
                else {
                    skate(2100, -300, MAX_SPEED);
                }
            }
        }
        int x,y;
        if(getIndex()==1){
            x = (2*px - 2600)/3 ;
            y = (2*py + 0 )/3;
        }
        else {
            x = (px - 2*2600)/3 ;
            y = (py + 0 )/3;
        }
        int dx = x-getX();
        int dy = y-getY();
        //if(Util.dist(getX()-getPuck().getX(),getY()-getPuck().getY())>300 || (getPuck().getHolder()!=null && !getPuck().getHolder().isOpponent())){
          //  if(Util.dist(dx,dy)>150){
                skate(x,y,(int)(2*Math.round(Math.sqrt(dx*dx+dy*dy))));
            //}
            //else{
            //    turn(getPuck(),MAX_TURN_SPEED);
            //}
        //}
        //else {
          //  skate(getPuck(),1000);
        //}
        /*
        if (getPuck().isHeld())
            skate(getPuck().getHolder(), MAX_SPEED);
        else
            if (getIndex() == 1)
            skate(-20000, -10000, 1000);
            else
            skate(-20000, 10000, 1000);
        */
    }
}

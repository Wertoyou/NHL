
package team5;

import java.awt.Color;
import hockey.api.GoalKeeper;
import hockey.api.Player;
import hockey.api.ITeam;
import hockey.api.Util;
import java.awt.Color;
import hockey.api.GoalKeeper;
import hockey.api.IPlayer;
import hockey.api.Player;
import hockey.api.ITeam;
import hockey.api.Util;
/*
public class Forward extends BasePlayer {
    // Number of forward
    public int getNumber() { return 15; }

    // Name of forward
    public String getName() { return "Forward"; }

    // Intelligence of forward
    public void step() {
        if (hasPuck()){ // If we have the puck...
            if (Math.abs(Util.dangle(getHeading(),Util.datan2(0 - getY(),2500 - getX()))) < 90) {
                int target = (int)(Math.random()*200)-100;
               shoot(2600, target, 10000); // Shoot!
            } 
            else{ // Otherwise
                skate(2600, 0, 1000); // Go towards goal
        	}
        }
    	else {
    	    skate(getPuck(), MAX_SPEED); // get the puck
    	}
    }
}*/
/*
package team5;
 
public class Forward extends BasePlayer {
    // Number of forward
    public int getNumber() { return 15; }
 
    // Name of forward
    public String getName() { return "Forward"; }
 
    // Intelligence of forward
    public void step() {
        if (hasPuck()) {
            if (getY() > 0) {
                skate(2000, 500, MAX_SPEED);
                shoot(2600, 70,10000);
            }
            else {
                skate(2000, -500, MAX_SPEED);
                shoot(2600, -70,10000);
            }
        }
        else if (! getPuck().isHeld()){
            skate(getPuck(), MAX_SPEED); // get the puck
        }
        else if (getPuck().getHolder().isOpponent()) {
            if (getIndex() == 5) {
                skate(getPlayer(7), MAX_SPEED);
            }
            else {
                skate(getPlayer(8), MAX_SPEED);
            }
        }
        else {
            if (getIndex() == 5) {
                skate(2000, 500, MAX_SPEED);
            }
            else {
                skate(2000, -500, MAX_SPEED);
            }
        }
    }
}*/
/*
public class Forward extends BasePlayer {
    // Number of forward
    public int getNumber() { return 15; }
 
    // Name of forward
    public String getName() { return "Forward"; }
 
    // Intelligence of forward
    public void step() {
        double ppx = (double)getPuck().getX();
        double ppy = (double)getPuck().getY();
        int px = (int)Math.round(ppx+getPuck().getSpeed()*0.1*Math.cos((double)(getPuck().getHeading())*3.1415927/180.0));
        int py = (int)Math.round(ppy+getPuck().getSpeed()*0.1*Math.sin((double)(getPuck().getHeading())*3.1415927/180.0));

    if (hasPuck() && 850 < getX() && getX() < 2100 && ((-900 < getY()) && (getY() < 900))) {

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
           shoot(2600, 50, 10000    }
    else if (hasPuck()) {
        if (getY() > 0) {
            skate(2000, 500, MAX_SPEED);
        }
        else {
            skate(2000, -500, MAX_SPEED);
        }
    }
    else if (! getPuck().isHeld()){
        skate(px,py, MAX_SPEED); // get the puck
    }
    else if (getPuck().getHolder().isOpponent()) {
        if (getIndex() == 3) {
            skate(getPlayer(9), MAX_SPEED);
        }
        else if (getIndex() == 4) {
            skate(getPuck().getHolder(), MAX_SPEED);
        }
        else if (getIndex() == 5) {
            skate(getPlayer(10), MAX_SPEED);
        }
        else {
            skate(getPuck(), MAX_SPEED);
        }
    }
    else {
        IPlayer best = null;
        for (int i = 0; i < 12; ++i) { // Gå through all players
        IPlayer cur = getPlayer(i);

        if (cur.isOpponent() && // If player is opponent...
            (best == null || 
             Util.dist(getPuck().getHolder().getX() - cur.getX(), // ...and closest so far...
                   getPuck().getHolder().getY() - cur.getY()) <
             Util.dist(getPuck().getHolder().getX() - best.getX(),
                   getPuck().getHolder().getY() - best.getY())))
            best = cur; // ... then remember him
        }

        skate(best, 1000); // Tackle the nearest opponent.
    }
    }
}*/


public class Forward extends BasePlayer {
    // Number of forward
    public int getNumber() { return 15; }
 
    // Name of forward
    public String getName() { return "Forward"; }
 
    // Intelligence of forward
    public void step() {
        double ppx = (double)getPuck().getX();
        double ppy = (double)getPuck().getY();
        int px = (int)Math.round(ppx+getPuck().getSpeed()*0.1*Math.cos((double)(getPuck().getHeading())*3.1415927/180.0));
        int py = (int)Math.round(ppy+getPuck().getSpeed()*0.1*Math.sin((double)(getPuck().getHeading())*3.1415927/180.0));

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
    else if (! getPuck().isHeld()){
        skate(px,py, MAX_SPEED); // get the puck
    }
    else if (getPuck().getHolder().isOpponent()) {
        if (getIndex() == 3) {
            skate(getPlayer(9), MAX_SPEED);
        }
        else if (getIndex() == 4) {
            skate(getPuck().getHolder(), MAX_SPEED);
        }
        else if (getIndex() == 5) {
            skate(getPlayer(10), MAX_SPEED);
        }
        else {
            skate(getPuck(), MAX_SPEED);
        }
    }
    else {
        IPlayer best = null;
        for (int i = 0; i < 12; ++i) {
            if(i==6)continue;
         // Gå through all players
        IPlayer cur = getPlayer(i);

        if (cur.isOpponent() && // If player is opponent...
            (best == null || 
             Util.dist(getPuck().getHolder().getX() - cur.getX(), // ...and closest so far...
                   getPuck().getHolder().getY() - cur.getY()) <
             Util.dist(getPuck().getHolder().getX() - best.getX(),
                   getPuck().getHolder().getY() - best.getY())))
            best = cur; // ... then remember him
        }

        skate(best, 1000); // Tackle the nearest opponent.
    }
    }
}

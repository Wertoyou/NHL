package Pucko;

import java.awt.Color;
import hockey.api.GoalKeeper;
import hockey.api.Player;
import hockey.api.ITeam;
import hockey.api.Util;
import java.lang.Math;
import java.util.Random;
import java.util.Base64;

public class Defender extends Player {

    private int index;
    private String name;

    public Defender(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getNumber() { return 3;}
    public String getName() { return name; }
    public boolean isLeftHanded() { return index % 2 == 0; }

    int x;
    int y;
    int speed;

    public void step() {

    int targetX = -1500;
    int targetY = 700;

    if(hasPuck()) {
        if(getX()>1000) {
            if(getY()>0) shoot(2600, 80, MAX_SHOT_SPEED);
            else shoot(2600, -80, MAX_SHOT_SPEED);
        }
        else {
        skate(2600, 0, 1000);
        }
    }
    else {
        if(index % 2==1){
                x=(int)((getPuck().getX()-2600)/2);
                y=(int)((getPuck().getY())/2);
                speed=(int)Math.sqrt(Math.pow(getX()-x,2)+Math.pow(getY()-y,2));
                skate(x,y,speed);
                return;
            }

        setAimOnStick(true);
        if(getPuck().getX() < -200 || getPuck().getX() > 300) {
        skate(getPuck(), 1000);
        }
        else {
        int dist = (int)Util.dist(getX() - targetX, getY() - targetY);
        speed = 200;
        if(dist > 300) {
            speed = 1000;
        }
        if(index % 2 == 0) {
            skate(targetX, targetY, speed);
        }
        else {
            skate(targetX, -targetY, speed);
        }
        }
    }
    }
}

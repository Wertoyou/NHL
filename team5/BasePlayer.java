package team5;

import hockey.api.Position;
import hockey.api.Player;

public abstract class BasePlayer extends Player {
    // The middle of the opponents goal, on the goal line
    protected static final Position GOAL_POSITION = new Position(2600, 0);

    // Left handed?
    public boolean isLeftHanded() { return getIndex()%2==1; }

    // Initiate
    public void init() {
    }

    // Face off
    public void faceOff() {
    }

    // Penalty shot
    public void penaltyShot() {
    }

    // Player intelligence goes here
    public void step() {
    }
}

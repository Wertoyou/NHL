package team5;

public class Center extends BasePlayer {
    // Number of center player
    public int getNumber() { return 19; }

    // Name of center player
    public String getName() { return "Center"; }

    // Center player's intelligence
    public void step() {
    if(getPuck().getHolder()!=null && getPuck().getHolder().isOpponent()){
        skate(getPuck(), 1000);
    }
	if (hasPuck())
	    skate(GOAL_POSITION, MAX_SPEED);
	else
	    skate(0, getPuck().getY(), 1000);
    }
}

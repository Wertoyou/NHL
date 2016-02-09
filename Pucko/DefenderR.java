package Pucko;

public class DefenderR extends BasePlayer {
    // Number of defender
    public int getNumber() { return 10; }

    // Name of defender
    public String getName() { return "Right Defender"; }

    // Make left defender left handed, right defender right handed.
    public boolean isLeftHanded() { return getIndex() == 1; }

    // Initiate
    public void init() {
	setAimOnStick(false);
    }

    // Defender intelligence
    public void step() {
        setAimOnStick(true);
	if (getPuck().isHeld())
	    skate(getPuck().getHolder(), MAX_SPEED);
	else
	    if (getIndex() == 1)
		skate(-2000, -1000, 1000);
	    else
		skate(-2000, 1000, 1000);
    }
}

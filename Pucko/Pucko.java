package Pucko;

import java.awt.Color;
import hockey.api.GoalKeeper;
import hockey.api.Player;
import hockey.api.ITeam;

public class Pucko implements ITeam {
    // Team Short Name.  Max 4 characters.
    public String getShortName() { return "PUCK"; }

    // Team Name
    public String getTeamName() { return "Pucko"; }

    // Team color; body color
    public Color getTeamColor() { return Color.MAGENTA; }

    // Team color; helmet color.
    public Color getSecondaryTeamColor() { return Color.ORANGE; }

    // The team's LUCKY NUMBER!!
    public int getLuckyNumber() { return 0; }

    // Get the goal keeper of the team.
    public GoalKeeper getGoalKeeper() { return new Goalie(); }

    // Get the other five players of the team.
    public Player getPlayer(int index) {
	switch (index) {
	case 1: return new Defender(1,"DL"); // Left defender
	case 2: return new Defender(2,"DR"); // Right defender
	case 3: return new ForwardL(); // Left forward
	case 4: return new ForwardR(); // Right forward
	case 5: return new Center(); // Center
	}
	return null;
    }
}

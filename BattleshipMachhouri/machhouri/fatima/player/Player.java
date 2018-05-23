package machhouri.fatima.player;

import java.util.ArrayList;

import machhouri.fatima.Ship;

public abstract interface Player {

	public abstract String getPlayerName();
	public ArrayList<Ship> getFleet();
	public abstract int getCounterDestruction();

	public abstract boolean hitFleet(String missileCoord);
	public abstract void coordinateHit(String missileCoord);
	public abstract boolean lost();
		
	public abstract String action(Player opponent, String missileCoord);
	public abstract String choiceCoord();

}

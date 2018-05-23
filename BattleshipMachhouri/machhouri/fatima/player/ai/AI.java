package machhouri.fatima.player.ai;

import java.util.ArrayList;

import machhouri.fatima.Coord;
import machhouri.fatima.Ship;
import machhouri.fatima.exception.OverflowException;
import machhouri.fatima.exception.OverlapException;
import machhouri.fatima.exception.ShipSizeException;
import machhouri.fatima.player.Player;


public abstract class AI implements Player {

	protected ArrayList<Ship> fleet = new ArrayList<Ship> ();
	protected int counterDestruction;
	protected String playerName;	
	
	
	public String getPlayerName() {
		return playerName;
	}
	public ArrayList<Ship> getFleet() {
		return fleet;
	}
	public int getCounterDestruction() {
		return this.counterShipDestroyed();
	}
	
	protected void testOverflow(String coord) 
		throws OverflowException {			
			if( coord.charAt(0) - 64 > 10 || Integer.parseInt(coord.substring(1)) > 10 ||
					coord.charAt(0)  < 65 || Integer.parseInt(coord.substring(1)) < 1 ) 
			{throw new OverflowException();
			}
	}
	
	protected void commonCoord(ArrayList<Coord> list, Ship ship2) 
	
			throws OverlapException {
			
			boolean testBattleShip = false;
			int i = 0;
			
			while(i<list.size() && !(testBattleShip)) {
				int j = 0;
				while(j<ship2.getShip().size() && !(testBattleShip)) {
					if (ship2.getShip().get(j).getCoord().equals(list.get(i).getCoord())) {
						testBattleShip = true;
					}
					j = j + 1 ;
				}
				i = i + 1;
			}
			
			if (testBattleShip) {throw new OverlapException();}
		}

		
		
	protected void initShip(Ship ship, int length) 
		throws ShipSizeException {
		if (ship.getShip().size() != length) {
			throw new ShipSizeException(); }
	}
		
	
	protected int counterShipDestroyed() {
		int counter = 0 ;
		for(int i = 0; i<this.fleet.size(); i++) {
			if (this.fleet.get(i).isDestroyed()) {counter = counter + 1;}
		}
		return counter;
	}
	
	
	public void coordinateHit(String missileCoord) {
		boolean found = false;
		int i = 0;
		int j = 0;
		while(i< fleet.size() && !(found)) {
			if(fleet.get(i).isHit(missileCoord)) {
				while(j<fleet.get(i).getShip().size() && !(found)) {
					if (fleet.get(i).getShip().get(j).getCoord().equals(missileCoord)) {
						fleet.get(i).getShip().get(j).setHit(true);
						found = true;
					}
					j = j + 1;
				}
			}
			i = i + 1;
		}
	} 
	
	public boolean lost() {
		return this.getCounterDestruction() == 5 ;
	}
	
	
	public boolean hitFleet(String missileCoord) {
		boolean found = false;
		int i = 0;
		int j = 0;
		while(i< fleet.size() && !(found)) {
			if(fleet.get(i).isHit(missileCoord)) {
				while(j<fleet.get(i).getShip().size() && !(found)) {
					if (fleet.get(i).getShip().get(j).getCoord().equals(missileCoord)) {
						found = true;
					}
					j = j + 1;
				}
			}
			i = i + 1;
		}
		return found;
	}
	
	public abstract String choiceCoord();
	public abstract String action(Player opponent, String missileCoord);
	
	

	
	
}

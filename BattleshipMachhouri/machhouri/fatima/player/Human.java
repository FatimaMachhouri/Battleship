package machhouri.fatima.player;

import java.util.ArrayList;
import java.util.Scanner;

import machhouri.fatima.Coord;
import machhouri.fatima.Ship;
import machhouri.fatima.exception.CoordFormatException;
import machhouri.fatima.exception.DiagonalShipException;
import machhouri.fatima.exception.IncorrectCoordException;
import machhouri.fatima.exception.OverflowException;
import machhouri.fatima.exception.OverlapException;
import machhouri.fatima.exception.ShipSizeException;

public class Human implements Player {

	private String humanName;
	private ArrayList<Coord> shot = new ArrayList<Coord> ();
	private ArrayList<Ship> fleet = new ArrayList<Ship> ();
	private int counterDestruction;	
	
	
	public String getPlayerName() {
		return humanName;
	}
	public ArrayList<Coord> getShot() {
		return shot;
	}
	public ArrayList<Ship> getFleet() {
		return fleet;
	}
	public int getCounterDestruction() {
		return this.counterShipDestroyed();
	}
	
		
	public Human() {}
	public Human(String humanName) throws DiagonalShipException, CoordFormatException, IncorrectCoordException, ShipSizeException, OverflowException, OverlapException {
		this.humanName = humanName;
		boolean init5 = false;
		boolean init4 = false;
		boolean init3 = false;
		boolean init31 = false;
		boolean init2 = false;
		String coord1;
		String coord2;
		Ship ship;
		ArrayList<Coord> tmp = new ArrayList<Coord>();
		
		Scanner coordShip = new Scanner(System.in);

		while(!(init5)) {
				try {
				System.out.println(humanName + " : Enter the coordinates of the ship of size 5 :");
				coord1 = coordShip.nextLine();
				coord2 = coordShip.nextLine();
				ship = new Ship(coord1, coord2);
				initShip(ship, 5);
				testOverflow(coord1);
				testOverflow(coord2);
				init5 = true;
				for(int i = 0 ; i<ship.getShip().size();i++) {
					tmp.add(ship.getShip().get(i));
				}
				this.getFleet().add(ship);
				}
				catch(DiagonalShipException | CoordFormatException | IncorrectCoordException | ShipSizeException | OverflowException exception) {
			    	   System.out.println(exception);
				}
			
			}
			
			
			while(!(init4)) {
				try {
					System.out.println(humanName + " : Enter the coordinates of the ship of size 4 :");
					coord1 = coordShip.nextLine();
					coord2 = coordShip.nextLine();
					ship = new Ship(coord1, coord2);
					initShip(ship, 4);
					commonCoord(tmp, ship);
					testOverflow(coord1);
					testOverflow(coord2);
					init4 = true;
					for(int i = 0 ; i<ship.getShip().size();i++) {
						tmp.add(ship.getShip().get(i));
					}
					this.getFleet().add(ship);
					}
					catch(DiagonalShipException | CoordFormatException | IncorrectCoordException | ShipSizeException | OverlapException | OverflowException exception) {
				    	   System.out.println(exception);
					}
			}
			
			
			while(!(init3)) {
				try {
					System.out.println(humanName + " : Enter the coordinates of the ship of size 3 :");
					coord1 = coordShip.nextLine();
					coord2 = coordShip.nextLine();
					ship = new Ship(coord1, coord2);
					initShip(ship, 3);
					commonCoord(tmp, ship);
					testOverflow(coord1);
					testOverflow(coord2);
					init3 = true;
					for(int i = 0 ; i<ship.getShip().size();i++) {
						tmp.add(ship.getShip().get(i));
					}
					this.getFleet().add(ship);
					}
					catch(DiagonalShipException | CoordFormatException | IncorrectCoordException | ShipSizeException | OverlapException | OverflowException exception) {
				    	   System.out.println(exception);

					}
			}	
			

			
			
			while(!(init31)) {
				try {
					System.out.println(humanName + " : Enter the coordinates of the ship of size 3 :");
					coord1 = coordShip.nextLine();
					coord2 = coordShip.nextLine();
					ship = new Ship(coord1, coord2);
					initShip(ship, 3);
					commonCoord(tmp, ship);
					testOverflow(coord1);
					testOverflow(coord2);
					init31 = true;
					for(int i = 0 ; i<ship.getShip().size();i++) {
						tmp.add(ship.getShip().get(i));
					}
					this.getFleet().add(ship);
					}
					catch(DiagonalShipException | CoordFormatException | IncorrectCoordException | ShipSizeException | OverlapException | OverflowException exception) {
				    	   System.out.println(exception);

					}
			}	
			
			
			while(!(init2)) {
				try {
					System.out.println(humanName + " : Enter the coordinates of the ship of size 2 :");
					coord1 = coordShip.nextLine();
					coord2 = coordShip.nextLine();
					ship = new Ship(coord1, coord2);
					initShip(ship, 2);
					commonCoord(tmp, ship);
					testOverflow(coord1);
					testOverflow(coord2);
					init2 = true;
					for(int i = 0 ; i<ship.getShip().size();i++) {
						tmp.add(ship.getShip().get(i));
					}
					this.getFleet().add(ship);
					}
					catch(DiagonalShipException | CoordFormatException | IncorrectCoordException | ShipSizeException | OverlapException | OverflowException exception) {
				    	   System.out.println(exception);
					}
			}	
		
	}
	

	
	
	private void testOverflow(String coord) 
		throws OverflowException {			
			if( coord.charAt(0) - 64 > 10 || Integer.parseInt(coord.substring(1)) > 10 ||
					coord.charAt(0)  < 65 || Integer.parseInt(coord.substring(1)) < 1 ) 
			{throw new OverflowException();
			}
	}
	
	
	private void commonCoord(ArrayList<Coord> list, Ship ship2) 
	
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

	
	
	private void initShip(Ship ship, int length) 
		throws ShipSizeException {
		if (ship.getShip().size() != length) {
			throw new ShipSizeException(); }
	}
	
	private void missShot(String missileCoord) {
		boolean tmp = false;
		int i = 0;
		
		//doublons
		while (i < this.getShot().size() && !(tmp)) {
			if ((this.getShot().get(i).getCoord()).equals(missileCoord)) {tmp = true;}
			i = i + 1 ;
		}
	
		if (tmp == false) {
		try {
		Coord missedCoord = new Coord(missileCoord);
		this.getShot().add(missedCoord);	
		}
		catch (CoordFormatException exception) {
	    	   System.out.println(exception);
		}	
		}
	}
	
	private void hitShot(String missileCoord) {
		
		boolean tmp = false;
		int i = 0;
		
		while (i < this.getShot().size() && !(tmp)) {
			if ((this.getShot().get(i).getCoord()).equals(missileCoord)) {tmp = true;}
			i = i + 1 ;
		}
	
		if (tmp == false) {
			try {
			Coord hitCoord = new Coord(missileCoord);
			hitCoord.setHit(true);
			this.getShot().add(hitCoord);	
			}
			catch (CoordFormatException exception) {
		    	   System.out.println(exception);
			}	
		}
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

	
	private int counterShipDestroyed() {
		int counter = 0 ;
		for(int i = 0; i<this.fleet.size(); i++) {
			if (this.fleet.get(i).isDestroyed()) {counter = counter + 1;}
		}
		return counter;
	}
	

	public String action(Player opponent, String missileCoord) {
		if (opponent.hitFleet(missileCoord)) {
			opponent.coordinateHit(missileCoord);
			this.hitShot(missileCoord);
			return "Hit";
		}
		else {
			this.missShot(missileCoord);
			return "Miss";
		}
	}
	
	
	public String choiceCoord() {
		Scanner action = new Scanner(System.in);
		String missileCoord = action.nextLine();
		return missileCoord;

	}

	
	private boolean containsCoord(ArrayList<Coord> shot, String missile) {
		boolean testContain = false;
		int i = 0;
		
		while(i<shot.size() && !(testContain)) {
			if (shot.get(i).getCoord().equals(missile)) {
			testContain = true;
			}
			i = i + 1;
		}
		return testContain;
	}

	
}
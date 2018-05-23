package machhouri.fatima.player.ai;

import java.util.ArrayList;
import java.util.Random;

import machhouri.fatima.Coord;
import machhouri.fatima.Ship;
import machhouri.fatima.exception.CoordFormatException;
import machhouri.fatima.exception.DiagonalShipException;
import machhouri.fatima.exception.IncorrectCoordException;
import machhouri.fatima.exception.OverflowException;
import machhouri.fatima.exception.OverlapException;
import machhouri.fatima.exception.ShipSizeException;
import machhouri.fatima.player.Player;


public class AI0 extends AI implements Player {
		
	public AI0() 
			throws DiagonalShipException, CoordFormatException, IncorrectCoordException, ShipSizeException, OverflowException, OverlapException {
		this.playerName = "Level Beginner";
		boolean init5 = false;
		boolean init4 = false;
		boolean init3 = false;
		boolean init31 = false;
		boolean init2 = false;
		String coord1;
		String coord2;
		Ship ship;
		ArrayList<Coord> tmp = new ArrayList<Coord>();
		int coordInt;
		char coordChar;
		
		Random rand = new Random(); 

		
		while(!(init5)) {
				try {
				
				coordChar = (char) (rand.nextInt(74 - 65  + 1) + 65);
				coordInt = rand.nextInt(10) + 1;
				coord1 = (char) coordChar + Integer.toString(coordInt);
				
				int randChoice = rand.nextInt(2) ;

				if (randChoice == 1) {
				coordInt = coordInt + 4;
				coord2 = (char) coordChar + Integer.toString(coordInt);
				}

				else {
				coordChar = (char) (coordChar + 4);
				coord2 = (char) coordChar + Integer.toString(coordInt);
				}
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

					coordInt = rand.nextInt(10) + 1;
					coordChar = (char) (rand.nextInt(74 - 65  + 1) + 65);
					coord1 = (char) coordChar + Integer.toString(coordInt);
					
					int randChoice = rand.nextInt(2) ;

					if (randChoice == 1) {
					coordInt = coordInt + 3;
					coord2 = (char) coordChar + Integer.toString(coordInt);
					}

					else {
					coordChar = (char) (coordChar + 3);
					coord2 = (char) coordChar + Integer.toString(coordInt);
					}
					
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

					coordInt = rand.nextInt(10) + 1;
					coordChar = (char) (rand.nextInt(74 - 65  + 1) + 65);
					coord1 = (char) coordChar + Integer.toString(coordInt);
					
					int randChoice = rand.nextInt(2) ;

					if (randChoice == 1) {
					coordInt = coordInt + 2;
					coord2 = (char) coordChar + Integer.toString(coordInt);
					}

					else {
					coordChar = (char) (coordChar + 2);
					coord2 = (char) coordChar + Integer.toString(coordInt);
					}
					
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

					coordInt = rand.nextInt(10) + 1;
					coordChar = (char) (rand.nextInt(74 - 65  + 1) + 65);
					coord1 = (char) coordChar + Integer.toString(coordInt);
					
					int randChoice = rand.nextInt(2) ;

					if (randChoice == 1) {
					coordInt = coordInt + 2;
					coord2 = (char) coordChar + Integer.toString(coordInt);
					}

					else {
					coordChar = (char) (coordChar + 2);
					coord2 = (char) coordChar + Integer.toString(coordInt);
					}
					
					
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

					coordInt = rand.nextInt(10) + 1;
					coordChar = (char) (rand.nextInt(74 - 65  + 1) + 65);
					coord1 = (char) coordChar + Integer.toString(coordInt);
					
					int randChoice = rand.nextInt(2) ;

					if (randChoice == 1) {
					coordInt = coordInt + 1;
					coord2 = (char) coordChar + Integer.toString(coordInt);
					}

					else {
					coordChar = (char) (coordChar + 1);
					coord2 = (char) coordChar + Integer.toString(coordInt);
					}
					
					
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
	

	

	public String action(Player opponent, String missileCoord) {
		if (opponent.hitFleet(missileCoord)) {
			opponent.coordinateHit(missileCoord);
			return "Hit";
		}
		else {
			return "Miss";
		}
	}
	
	
	public String choiceCoord() {
		Random rand = new Random();
		int coordInt = rand.nextInt(10) + 1;
		char coordChar = (char) (rand.nextInt(74 - 65  + 1) + 65);
		String missileCoord = (char) coordChar + Integer.toString(coordInt);
		return missileCoord;

	}
	
	
	
}
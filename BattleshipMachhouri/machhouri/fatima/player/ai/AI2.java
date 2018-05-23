package machhouri.fatima.player.ai;


import static java.lang.Character.isLetter;

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


public class AI2 extends AI implements Player {

	private ArrayList<Coord> shot = new ArrayList<Coord> ();
	private ArrayList<String> coordToTarget = new ArrayList<String> ();

	
	public ArrayList<Coord> getShot() {
		return shot;
	}
	public ArrayList<String> getCoordToTarget() {
		return coordToTarget;
	}
	
	
	public AI2() 
			throws DiagonalShipException, CoordFormatException, IncorrectCoordException, ShipSizeException, OverflowException, OverlapException {
		this.playerName = "Level Hard";
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
				
				coordInt = rand.nextInt(10) + 1;
				coordChar = (char) (rand.nextInt(74 - 65  + 1) + 65);
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
	
	public String action(Player opponent, String missileCoord) {
		if (opponent.hitFleet(missileCoord)) {
			opponent.coordinateHit(missileCoord);
			this.hitShot(missileCoord);
			char coordChar = missileCoord.charAt(0);
			int coordInt = Integer.parseInt(missileCoord.substring(1));
			String coord = (char) (coordChar + 1) + Integer.toString(coordInt);
			if(goodFormatCoord(coord) && !(this.coordToTarget.contains(coord))) {this.coordToTarget.add(coord);}
			coord = (char) (coordChar - 1) + Integer.toString(coordInt);
			if(goodFormatCoord(coord) && !(this.coordToTarget.contains(coord))) {this.coordToTarget.add(coord);}
			coord = (char) (coordChar) + Integer.toString(coordInt + 1);
			if(goodFormatCoord(coord) && !(this.coordToTarget.contains(coord))) {this.coordToTarget.add(coord);}
			coord = (char) (coordChar) + Integer.toString(coordInt - 1);
			if(goodFormatCoord(coord) && !(this.coordToTarget.contains(coord))) {this.coordToTarget.add(coord);}
			return "Hit";
		}
		else {
			this.missShot(missileCoord);
			return "Miss";
		}
	}
	
	
	public String choiceCoord() {
		Random rand = new Random();
		String missileCoord = null;
		boolean test = false;
		
		if( !(this.coordToTarget.isEmpty()) ) {
			do {
				missileCoord = this.coordToTarget.get(0);
				coordToTarget.remove(0);
			}
			while(containsCoord(shot,missileCoord) && coordToTarget.size() != 0);
			
			if (containsCoord(shot, missileCoord) == false) {
				return missileCoord;
			}
			else{
				test = true;
			}
		}//if
		
		
		if ( test || this.coordToTarget.isEmpty() ) {
			
			do {
				int coordInt = rand .nextInt(10) + 1;
				char coordChar = (char) (rand.nextInt(74 - 65  + 1) + 65);
				missileCoord = (char) coordChar + Integer.toString(coordInt);
			}
			while( containsCoord(this.shot, missileCoord) );
			
			return missileCoord;
			
		} //elseif
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
	
	
	private boolean goodFormatCoord(String missileCoord) {
		
		if ( !(isLetter(missileCoord.charAt(0))) 
				|| missileCoord.charAt(0) - 64 > 10 
				|| missileCoord.charAt(0) < 65 
				|| missileCoord.equals(" ") ) {
			return false;
		}
		
		if ( !(isInteger(missileCoord.substring(1))) 
				|| Integer.parseInt(missileCoord.substring(1)) > 10 
				|| Integer.parseInt(missileCoord.substring(1)) < 1 ) {
			return false ;
			}
		return true;

	}
	
	 private static boolean isInteger(String s) {
	       boolean isValid = true;
	       try{ Integer.parseInt(s); }
	       catch(NumberFormatException exception){ 
	    	   isValid = false;
	    	   System.out.println(exception);
	       }
	       return isValid;
	 }

	

}

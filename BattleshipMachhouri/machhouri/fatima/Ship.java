package machhouri.fatima;

import static java.lang.Character.isLetter;
import java.util.ArrayList;

import machhouri.fatima.exception.CoordFormatException;
import machhouri.fatima.exception.DiagonalShipException;
import machhouri.fatima.exception.IncorrectCoordException;

public class Ship {
	
	private ArrayList<Coord> ship = new ArrayList<Coord>();
	
	public ArrayList<Coord> getShip() {
		return ship;
	}
	
	public Ship() {}
	public Ship(String startCoord, String endCoord) 
		
		throws DiagonalShipException, CoordFormatException, IncorrectCoordException {
		
			if( !(isLetter(startCoord.charAt(0))) || !(isInteger(startCoord.substring(1))) ) {
				throw new CoordFormatException();
			}
			
			
			if( !(isLetter(endCoord.charAt(0))) || !(isInteger(endCoord.substring(1))) ) {
				throw new CoordFormatException();
			}
			
			
			if( startCoord.charAt(0) > endCoord.charAt(0) ) {
				throw new IncorrectCoordException();
			}
			
			
			if( Integer.parseInt(startCoord.substring(1)) > Integer.parseInt(endCoord.substring(1)) ) {
				throw new IncorrectCoordException();
			}
			
		
			if(coordLetter(startCoord) != coordLetter(endCoord) && coordNumber(startCoord) != coordNumber(endCoord)) {
				throw new DiagonalShipException();
			
			}
			
			else {
				
			int coordNumber = coordNumber(startCoord);
			int coordLetter = coordLetter(startCoord);
			
			for(int i = 0 ; i < lengthShip(startCoord, endCoord) ; i++) {
				Coord coord = new Coord((char) coordLetter + Integer.toString(coordNumber));
				this.ship.add(coord);
				if (isVertical(startCoord, endCoord)) {coordNumber += 1 ;}
				else {coordLetter += 1;}	
			}
			}
		}
	
	
	

	private boolean isHorizontal(String startCoord, String endCoord) {
		return coordNumber(startCoord) == coordNumber(endCoord);
	}
	private boolean isVertical(String startCoord, String endCoord) {
		return coordLetter(startCoord) == coordLetter(endCoord);
	}
	private char coordLetter(String coord) {
		return coord.charAt(0);
	}
	private int coordNumber(String coord) {
		return Integer.parseInt(coord.substring(1));
	}
	private int lengthShip(String startCoord, String endCoord) {
		if (isVertical(startCoord, endCoord)) {
			return coordNumber(endCoord) - coordNumber(startCoord) + 1;
		}
		else {
			return coordLetter(endCoord) - coordLetter(startCoord) + 1 ;
		}
	}
	
	
	public boolean isHit(String missileCoord) {
		boolean hit = false;
		int j = 0;
		
		while ( j < ship.size() && !(hit) )
		{
			if (ship.get(j).getCoordChar() == coordLetter(missileCoord) 
					&& ship.get(j).getCoordInt() == coordNumber(missileCoord) )  {
				hit = true;
			}
			j += 1;
		}
		return hit;
	}
	

	public boolean isDestroyed() {
		boolean destroyed = true ;
		int i = 0;
		while (i < ship.size() && destroyed) 
		{
			if (ship.get(i).isHit() == false) {
				destroyed = false;
			}
			i = i + 1;
		}
		return destroyed;
	}

	 private static boolean isInteger(String s) {
	       boolean isValid = true;
	       try{ Integer.parseInt(s); }
	       catch(NumberFormatException exception){ 
	    	   System.out.println(exception);
	    	   isValid = false; }
	       return isValid;
	 }
	
	public String toString() {
		String printShip = "";
		for(int i = 0; i < ship.size(); i++) {
		printShip = printShip + " " + ship.get(i).toString();
		}
		return printShip;
	}


}

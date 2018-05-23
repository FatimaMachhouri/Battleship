package machhouri.fatima;

import static java.lang.Character.isLetter;

import machhouri.fatima.exception.CoordFormatException;

public class Coord {

	private char coordChar;
	private int coordInt;
	private String coord;
	private boolean isHit;
	
	
	public char getCoordChar() {
		return coordChar;
	}
	public int getCoordInt() {
		return coordInt;
	}
	public String getCoord() {
		return coord;
	}
	public boolean isHit() {
		return isHit;
	}
	public void setHit(boolean isHit) {
		this.isHit = isHit;
	}
	
	
	public Coord() {}
	
	public Coord(char coordChar, int coordInt) { 		
		this.coordChar = coordChar;
		this.coordInt = coordInt;
		this.coord = (char) coordChar + Integer.toString(coordInt);
		this.isHit = false;
	}
	
	public Coord(String coord) 
		throws CoordFormatException {
			if ( !(isLetter(coord.charAt(0))) || !(isInteger(coord.substring(1))) ) {
				throw new CoordFormatException();
			}
	
			this.coordChar = coord.charAt(0);
			this.coordInt = Integer.parseInt(coord.substring(1));
			this.coord = coord;
			this.isHit = false;
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
		return "[" + coord + " " + isHit + "]";
	}
	
}

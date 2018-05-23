package machhouri.fatima;

import static java.lang.Character.isLetter;

import java.util.ArrayList;

import machhouri.fatima.player.Player;

public class Game {

	private Player player1;
	private Player player2;


	public Player getPlayer1() {
		return player1;
	}
	public Player getPlayer2() {
		return player2;
	}


	public Game() {}
	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}


	public String actionPlayer(Player currentPlayer, Player opponent, String missileCoord) {
		return currentPlayer.action(opponent, missileCoord);
	}


	public boolean goodFormatCoord(String missileCoord) {

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
	    	   System.out.println(exception);
	    	   isValid = false; }
	       return isValid;
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


	private boolean containsCoordShip(ArrayList<Ship> fleet, String missile) {
		boolean testContain = false;
		int i = 0;

		while(i<fleet.size() && !(testContain)) {
			if (containsCoord(fleet.get(i).getShip(), missile)) {
				testContain = true;
			}
			i = i + 1;
		}

		return testContain;
	}



	private int index(ArrayList<Coord> shot, String missile) {

		int index = 0;

		if(containsCoord(shot, missile)) {
			boolean testContain = false;
			int i = 0;

			while(i<shot.size() && !(testContain)) {
				if (shot.get(i).getCoord().equals(missile)) {
				testContain = true;
				index = i ;
				}
				i = i + 1;
			}
		}

		return index;

	}




	public void printGridShot(ArrayList<Coord> shot) {

		String grid = "   A   B   C   D   E   F   G   H   I   J \n";

		for(int i = 1; i<=10; i++) {
			String line;
			if (i == 10) {line = Integer.toString(i) + " ";}
			else {line = " " + Integer.toString(i) + " ";}
			for(int j = 1; j<= 10; j++) {
				String coord = (char) (j + 64) + Integer.toString(i);
				if(containsCoord(shot,coord) && shot.get(index(shot, coord)).isHit() == true) {line += "H   ";}
				else if(containsCoord(shot,coord) && shot.get(index(shot, coord)).isHit() == false) {line += "M   ";}
				else {
					line += "~   ";
				}
			}
			grid += line + "\n\n";
		}
		System.out.println(grid);

	}



	public void printGridFleet(ArrayList<Ship> fleet) {

		String grid = "   A   B   C   D   E   F   G   H   I   J \n";

		for(int i = 1; i<=10; i++) {
			String line;
			if (i == 10) {line = Integer.toString(i) + " ";}
			else {line = " " + Integer.toString(i) + " ";}
			for(int j = 1; j<= 10; j++) {
				String coord = (char) (j + 64) + Integer.toString(i);
				if(containsCoordShip(fleet,coord) == true && isHit(fleet,coord)) {line += "X   ";}
				else if( containsCoordShip(fleet,coord) == true && !(isHit(fleet,coord)) ) {line += "O   ";}
				else {
					line += "~   ";
				}
			}
			grid += line + "\n\n";
		}

		System.out.println(grid);

	}


	private boolean isHit(ArrayList<Ship> fleet, String missile) {
		int i = 0 ;
		int j = 0;
		boolean hit = false;

		while(i<fleet.size() && !(hit) ) {
			j = 0;
			while(j<fleet.get(i).getShip().size() && !(hit)) {

				if(fleet.get(i).getShip().get(j).getCoord().equals(missile)) {
					if(fleet.get(i).getShip().get(j).isHit()) {
						hit = true;
					}
				}
				j = j + 1;
			}
			i = i + 1;
		}

		 return hit;

	}//isHit



}

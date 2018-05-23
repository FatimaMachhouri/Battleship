package fr.battleship;

import java.util.Random;

import machhouri.fatima.Game;
import machhouri.fatima.exception.CoordFormatException;
import machhouri.fatima.exception.DiagonalShipException;
import machhouri.fatima.exception.IncorrectCoordException;
import machhouri.fatima.exception.OverflowException;
import machhouri.fatima.exception.OverlapException;
import machhouri.fatima.exception.ShipSizeException;
import machhouri.fatima.player.Player;
import machhouri.fatima.player.ai.AI0;
import machhouri.fatima.player.ai.AI1;
import machhouri.fatima.player.ai.AI2;


public class TestIA {

	public static void main(String[] args) {

		String contenuCSV = "AI Name;score;AI Name2;score2\n";

		int counter1 = 0;
		int counter2 = 0;
		int i = 0;

		int match = 1;
		Player player1 = null;
		Player player2 = null;

		while(i<100 && match !=4) {
			try {

				Random rand = new Random();

				if(match == 1) {
					player1 = new AI0();
					player2 = new AI1();
				}

				else if (match == 2) {
					player1 = new AI0();
					player2 = new AI2();
				}

				else if (match == 3) {
					player1 = new AI1();
					player2 = new AI2();
				}


				Game game = new Game(player1, player2);


				Player currentPlayer = game.getPlayer1();
				Player opponent = game.getPlayer2();
				boolean gameOver = currentPlayer.lost() || opponent.lost();
				String result;
				int currentDestruction;
				boolean restart;


				if (i % 2 == 0) {
					currentPlayer = game.getPlayer1();
					opponent = game.getPlayer2();
				}
				else {
					currentPlayer = game.getPlayer2();
					opponent = game.getPlayer1();
				}

				while(!(gameOver)) {

					currentDestruction = opponent.getCounterDestruction();
					restart = true;

					do {
						String missileCoord = currentPlayer.choiceCoord();

						if(game.goodFormatCoord(missileCoord)) {
						result = currentPlayer.action(opponent, missileCoord);

						restart = false;
						}
					}
					while(restart);


					if (opponent.getCounterDestruction() > currentDestruction) {
					}


					if (currentPlayer == game.getPlayer1()) {
						currentPlayer = game.getPlayer2();
						opponent = game.getPlayer1();
					}
					else {
						currentPlayer = game.getPlayer1();
						opponent = game.getPlayer2();
					}

					gameOver = currentPlayer.lost() || opponent.lost();

				}

				if (game.getPlayer1().lost()) {
					counter2 = counter2 + 1 ;
					}
				else {
					counter1 = counter1 + 1 ;
					}


				if (i == 99) {
					System.out.println("Score " + game.getPlayer1().getPlayerName() + " " + counter1);
					System.out.println("Score " + game.getPlayer2().getPlayerName() + " " + counter2);

					contenuCSV += "AI " + player1.getPlayerName() + ";" + counter1 + ";" + player2.getPlayerName() + ";" + counter2 + "\n";

					match = match + 1;
					i = -1;
					counter1 = 0;
					counter2 = 0;

				}

			}
			catch (OverflowException | DiagonalShipException | CoordFormatException | ShipSizeException | IncorrectCoordException | OverlapException exception) {}


			i = i + 1;

		}//while

		Fichier proof = new Fichier();
		proof.ecrire("ai_proof.csv", contenuCSV);


	}

}

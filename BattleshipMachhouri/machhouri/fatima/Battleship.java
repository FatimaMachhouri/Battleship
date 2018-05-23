package machhouri.fatima;

import java.util.Random;
import java.util.Scanner;

import machhouri.fatima.exception.CoordFormatException;
import machhouri.fatima.exception.DiagonalShipException;
import machhouri.fatima.exception.IncorrectCoordException;
import machhouri.fatima.exception.OverflowException;
import machhouri.fatima.exception.OverlapException;
import machhouri.fatima.exception.ShipSizeException;
import machhouri.fatima.player.Human;
import machhouri.fatima.player.Player;
import machhouri.fatima.player.ai.AI0;
import machhouri.fatima.player.ai.AI1;
import machhouri.fatima.player.ai.AI2;

public class Battleship {

	public static void main(String[] args) {


		Player player1 = null;
		Player player2 = null;
		int counter1 = 0;
		int counter2 = 0;
		int i = 0;
		Game game = null;

		int match = 0;

		boolean replay = true;

		System.out.println("Enter the number of the match you want to play : ");
		System.out.println("1 for Human versus Human");
		System.out.println("2 for Human versus AI0");
		System.out.println("3 for Human versus AI1");
		System.out.println("4 for Human versus AI2");

		Scanner choice = new Scanner(System.in);
		int choixMatch = choice.nextInt();
		String namePlayer1 = null;


		System.out.println("A 'M' on the grid means Miss (miss shot), an 'H' means Hit (hit shot)");
		System.out.println("An 'O' on the grid of the fleet means that the coordinate of the boat has not been touched while an 'X' cross means that it has been touched");

		while(replay) {

			try {
				if (choixMatch == 1) {
					Scanner name = new Scanner(System.in);
					if (i==0)
					{
					System.out.print("Player 1, enter your name : ");
					namePlayer1 = name.nextLine();
					}
					player1 = new Human(namePlayer1);

					if(i==0)
					{
					System.out.print("Player 2, enter your name : ");
					namePlayer1 = name.nextLine();
					}
					player2 = new Human(namePlayer1);
				}

				else if (choixMatch == 2) {
					if (i==0) {
					Scanner name = new Scanner(System.in);
					System.out.print("Player 1, enter your name : ");
					namePlayer1 = name.nextLine();
					}
					player1 = new Human(namePlayer1);

					player2 = new AI0();
				}

				else if (choixMatch == 3) {
					if (i==0) {
					Scanner name = new Scanner(System.in);
					System.out.print("Player 1, enter your name : ");
					namePlayer1 = name.nextLine();
					}
					player1 = new Human(namePlayer1);

					player2 = new AI1();
				}

				else if (choixMatch == 4) {
					if (i==0) {
					Scanner name = new Scanner(System.in);
					System.out.print("Player 1, enter your name : ");
					namePlayer1 = name.nextLine();
					}
					player1 = new Human(namePlayer1);

					player2 = new AI2();
				}


				game = new Game(player1, player2);
				}
				catch (OverflowException | DiagonalShipException | CoordFormatException | ShipSizeException | IncorrectCoordException | OverlapException exception) {
			    	   System.out.println(exception);
				}

			Random rand = new Random();

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
					System.out.println(currentPlayer.getPlayerName() + " : Coordinate to target : ");

						String missileCoord = currentPlayer.choiceCoord();

						if(game.goodFormatCoord(missileCoord)) {
						result = currentPlayer.action(opponent, missileCoord);
						System.out.println(missileCoord);
						System.out.println(result);
						restart = false;
						}
					}
					while(restart);


					if (opponent.getCounterDestruction() > currentDestruction) {
						System.out.println(currentPlayer.getPlayerName() + " destroyed  a ship ! ");
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



					if (currentPlayer.getClass().getName() ==  "machhouri.fatima.player.Human") {
						System.out.println(currentPlayer.getPlayerName());
						game.printGridShot( ((Human) currentPlayer).getShot() );
						game.printGridFleet(currentPlayer.getFleet() );

					}



				}//while gameover

			if (game.getPlayer1().lost()) {
				System.out.println(player2.getPlayerName() + " win the game !");
				counter2 = counter2 + 1 ;
				}
			else {
				System.out.println(player1.getPlayerName() + " win the game !");
				counter1 = counter1 + 1 ;
				}
			i = i + 1;

			System.out.println("Replay ? Y/N ");
			Scanner replayScan = new Scanner(System.in);
			String tmp = replayScan.nextLine();

			if(!(tmp.equalsIgnoreCase("y"))) {
				replay = false;
			}


		}//while

		System.out.println(player1.getPlayerName() + " score " + counter1);
		System.out.println(player2.getPlayerName() + " score " + counter2);



		}



}

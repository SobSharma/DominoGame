package com.tsp.models;

import java.util.Iterator;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This Program's main objective is to simulate a domino game between a user and
 * the computer.
 * <p>
 * The domino stock is composed of 28 dominos. There are 7 doubles (same number
 * on both ends from double blank to double six) and 21 singles (different
 * numbers on both ends or a number and a blank).
 * <p>
 * At the beginning of the game, each player will recieve 6 dominos.
 * <p>
 * The one who starts is the one who has the biggest double on his hand. We
 * start with looking for a double six. If no one has it, we look for a double
 * five and so on. If no one has a double, the human player will start the game.
 * <p>
 * To play the rules are simple. The player put a domino from his hand on the
 * table matching one of the extreme values of the tiles that are already on the
 * table. In the case that the player does not have any matching domino, he will
 * draw from the remaining dominos in the stock until he gets a valid one to
 * play or the stock gets empty. In that latter case, the player will have to
 * pass his turn so that the computer can play. The game can get blocked if no
 * one of both players can play a domino and the stock is empty.
 * <p>
 * The game will end when one of the two player's hand gets empty.
 * <p>
 * When it's the human player's turn, he will have three choices:
 * <ul>
 * <li>Play a domino by picking it from his hand
 * <li>Draw a new domino from the stock
 * <li>Jump to pass his turn to the computer
 * </ul>
 * <p>
 * 
 * @author Ramzi Sellami <ramzi_sellami@yahoo.fr>
 * @author Saurabh Sharma <saurabh.sharma@telecom-sudparis.eu>
 * 
 * @version 3.0.0
 * @since 10/05/2015
 */

public class Game {

	// Main class Game attributes
	Player pc;
	Stock stock;
	Table table;
	int status;

	// Constructor of the Game class
	public Game() {
		status = 6;
		stock = Stock.instance();
		table = Table.instance();
		pc = new Player("Computer", stock, table);
	}

	/**
	 * This is the main function of our program in which we do our operations
	 * and call other classes and functions.
	 */
	public static void main(String args[]) {

		/** An instance of the class Game. We use it to run the game */
		@SuppressWarnings("unused")
		Game game = new Game();

		/** A variable in which we put the human player instance */
		Player user;

		/** A variable in which we put the player computer instance */
		@SuppressWarnings("unused")
		Player pc;

		/**
		 * A variable in which we put the 16 domino left after filling the two
		 * player's hand
		 */
		Stock stock;

		/**
		 * A variable in which we put the domino played by the two players on
		 * the board
		 */
		Table table;

		/**
		 * A variable used to know if the computer is blocked and can't play
		 * anymore
		 */
		boolean computerBlocked = false;

		/**
		 * A variable used to know if the human player is blocked and can't play
		 * anymore
		 */
		boolean playerBlocked = false;

		/** A variable used to know if the game is blocked in both sides */
		boolean blockGame = false;

		/**
		 * A variable used to differentiate the turns and actions done by the
		 * two users during the game
		 * <ul>
		 * <li>1- The human player's turn to play
		 * <li>2- The computer's turn to play
		 * <li>3- The computer has to draw a domino from the stock
		 * <li>4- The human player has to draw a domino from the stock
		 * <li>5- The player has won
		 * <li>6- The computer has won
		 * <li>7- The game is blocked
		 * </ul>
		 * */
		int event = 1;

		/**
		 * A variable used to know what action the human player wants to execute
		 * <ul>
		 * <li>1- Play a domino
		 * <li>2- Draw a domino from the stock
		 * <li>3- Jump to pass his turn and let the computer play
		 * </ul>
		 * */
		int playerChoice = 0;
		int leftVal;
		int rightVal;

		/** A variable in which we put the dominos making the computer's hand */
		Hand handPc;

		/**
		 * A variable in which we put the dominos making the human player's hand
		 */
		Hand handPlayer;

		/**
		 * A variable used to play the first double or not domino by one of the
		 * two users and put it on the table
		 */
		Domino playedDomino = null;

		/** A scanner used to get inputs from the human player */
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		user = new Player();
		table = Table.instance();
		stock = Stock.instance();
		handPc = new Hand(stock);
		pc = new Player("Computer", stock, table);

		/**
		 * A variable in which we put the name of the human player introduced by
		 * him at the beginning
		 */
		
		//stock.showStock();
		String name = user.getInputName();

		user = new Player(name, stock, table);
		System.out.println("Welcome To DoMiNoS " + name + ", have fun!");
		handPlayer = new Hand(stock);
		System.out.println(name + "'s hand:");
		handPlayer.show();
		//System.out.println("Computer's hand:");
		//handPc.show();
		table.display();

		/**
		 * A variable in which we put a flag to know if some of the two players
		 * played a domino
		 */
		int flag = 0;

		for (int i = 6; i >= 0; i--) {

			/**
			 * A variable in which we put one by one each domino from the
			 * players hand until we find a double
			 */
			Domino d = handPlayer.getDomino(i, i);

			if (d != null && flag == 0) {
				System.out
						.println(name
								+ " has a double "
								+ i
								+ " domino. So he starts by playing the following domino: ");
				d.displayDomino();
				playedDomino = d;
				flag = 1;
				event = 2;

				break;
			} else {
				System.out.println(name
						+ " jumped beacause he doesn't have a double " + i
						+ "...");
			}

			Domino d2 = handPc.getDomino(i, i);
			if (d2 != null && flag == 0) {
				System.out
						.println("Computer has a double "
								+ i
								+ " domino. So he starts by playing the following domino: ");
				playedDomino = d2;
				d2.displayDomino();
				flag = 1;
				event = 1;
				break;
			} else {
				System.out
						.println("Computer jumped beacause he doesn't have a double "
								+ i + "...");
			}
		}

		if (flag == 0) {
			System.out.println("No one has a Double Domino, " + name
					+ " plays any Domino.");
			event = 1;
		}

		/**
		 * We update the new extreme values of the table each time a domino is
		 * played
		 */
		table.setNewExtremes(playedDomino);

		table.display();

		while ((!(handPlayer.isEmpty()) || !(handPc.isEmpty()))
				&& blockGame == false) {

			if (playerBlocked == true && computerBlocked == true) {
				event = 7;
			}

			switch (event) {
			case 1:
				System.out.println(name + " has to play.");
				System.out.println("This is your hand: ");

				handPlayer.show();
                //stock.showStock();
				System.out
						.println("Do you want to play a domino, draw a new one or jump?");
				System.out.println("1-Play");
				System.out.println("2-Draw");
				System.out.println("3-Jump");
				/**
				 * In case the user enters an invalid option such as InputMismatch.
				 * To avoid the game from crashing the console will display an Exception Message
				 */
				try{
				    playerChoice = sc.nextInt();
				    }
                  catch (InputMismatchException e)
				   {
				    System.out.println("Exception: You entered a wrong choice");
				    sc.nextLine();
				    continue;
				   }
				

				switch (playerChoice) {

				case 1:
					System.out.println("Left value = ");
					/**
					 * In case the user enters an invalid left value such as any InputMismatch.
					 * To avoid the game from crashing the console will display an Exception Message
					 */
					try{
						leftVal = sc.nextInt();
					    }
	                  catch (InputMismatchException e)
					   {
					    System.out.println("Exception: Enter a valid left value from your hand");
					    sc.nextLine();
					    continue;
					   }

					/**
					 * A variable in which we put the left value of the domino
					 * choosed by the human player
					 */
					//int leftVal = sc.nextInt();

					System.out.println("Right value = ");
					/**
					 * In case the user enters an invalid Right value such as any InputMismatch.
					 * To avoid the game from crashing the console will display an Exception Message
					 */
					
					try{
						rightVal = sc.nextInt();
					    }
	                  catch (InputMismatchException e)
					   {
					    System.out.println("Exception: Enter a valid right value from your hand");
					    sc.nextLine();
					    continue;
					   }

					/**
					 * A variable in which we put the right value of the domino
					 * choosed by the human player
					 */
					//int rightVal = sc.nextInt();

					/**
					 * A variable in which we create and put the domino asked
					 * from the human player
					 */
					Domino dominoChoosed = new Domino(leftVal, rightVal);

					if (handPlayer.contains(dominoChoosed)
							&& handPlayer.canPutItOnTable(dominoChoosed,
									table.getExtremeValueLeft(),
									table.getExtremeValueRight())) {
						table.setNewExtremes(dominoChoosed);
						handPlayer.removeFromHand(dominoChoosed);
						if ((handPlayer
								.chooseDominoWithoutRemoving(
										table.extremeValueLeft,
										table.extremeValueRight) == null)
								&& stock.isEmpty()) {
							playerBlocked = true;
							event = 2;
						} else if (handPlayer.isEmpty()) {
							System.out.println("Congratulation, you won!");
							event = 5;
						} else {
							table.display();
							event = 2;
						}
					} else {
						System.out.println("Choose a valid domino!");
					}
					break;
				case 2:
					event = 4;
					break;

				case 3:
					event = 2;
					break;

				default:
					System.out.println("Please Choose a Valid Option");
					break;
				}

				break;

			case 2:
				System.out.println("Computer's turn to Play");
				//handPc.show();

				/**
				 * A variable in which we put the domino chosen by the computer
				 * to play on the table from its hand
				 */
				Domino d = handPc.chooseDomino(table.getExtremeValueLeft(),
						table.getExtremeValueRight());

				if (d == null && stock.isEmpty()) {
					computerBlocked = true;
					event = 1;
				} else if (handPc.isEmpty()) {
					System.out.println("Too bad, the Computer won!");
					event = 6;
					break;
				} else if (d != null && event != 6) {
					System.out.println("Computer plays the following domino: ");
					d.displayDomino();
					table.setNewExtremes(d);
					table.display();
					event = 1;
				} else if (d == null && event != 6) {
					event = 3;
				}
				break;

			case 3:
				System.out.println("Computer has to draw.");
				if (stock.isEmpty()) {
					System.out.println("The stock is empty, no more drawing!");
					System.out
							.println("Computer has to play but he can't draw anymore because the stock is empty. He tries to play from his hand.");
					event = 2;
				} else {
					handPc.drawFromStock();
					//handPc.show();
					event = 2;
				}
				break;

			case 4:
				System.out.println(name + " Draws a Domino ");
				//stock.showStock();
				if (stock.isEmpty()) {
					System.out.println("The stock is empty, no more drawing!"
							+ name + " has to Play now!");
					event = 1;
					break;
				} else {
					handPlayer.drawFromStock();
					handPlayer.show();
					event = 1;
					break;
				}
			case 5: // Player has won
				break;
			case 6: // Computer has won
				break;
			case 7:
				System.out.println("THE GAME IS BLOCKED!!!");
				blockGame = true;
				break;
			}

		}

	}

}

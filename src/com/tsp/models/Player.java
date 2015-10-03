package com.tsp.models;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class contains three methods (getInputName(), initialize() and showHand()),
 * setters and getters for the attributes.
 * 
 * @author Ramzi Sellami <ramzi_sellami@yahoo.fr>
 * @author Saurabh Sharma <saurabh.sharma@telecom-sudparis.eu>
 * 
 * @version 3.0.0
 * @since 10/05/2015
 */

public class Player {

	/** A variable in which we put the name of the player */
	private String name;
	/** A variable in which we put the dominos composing the hand of the player */
	private Hand hand;
	/** A variable in which we put the dominos played by the players on the bord/table */
	private Table table;
	/** A variable in which we put the dominos composing the stock that the players will draw from it while playing */
	private Stock stock;

	/** Two constructors for the Player class */
	public Player(String name, Stock stock, Table table) {
		
		
		/** Throwing Exceptions for Player Constructor without name, stock or table initialised */
		
		 if((name==null)||(name.trim().equals("")))
		 throw new IllegalArgumentException("It is mandatory to enter the name to Play Domino"); 
		 
		if (stock==null) 
			throw new NullPointerException("Stock is empty");
		if (table==null)
			throw new NullPointerException("Table is empty");
		
		
		this.name = name;
		//initialize(stock);
		this.table = table;
		this.stock = stock;
	}

	public Player() {
	}

	/**
	 * Getters and Setters
	 * */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	/**
	 * This method is used to get a String object from the user's standand input
	 * which is his name
	 * 
	 * @return The name introduced by the user
	 */
	public String getInputName() {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Your name");
		name = input.nextLine();
		return name;
	}

	/**
	 * Used in the constructor to initialize the hand of the player with random
	 * dominos from the stock.
	 */
	private void initialize(Stock stock) {
		hand = new Hand(stock);
	}

	/**
	 * This method is used to display on the standard output (console) the
	 * player's hand.
	 * 
	 */
	public void showHand() {
		hand.show();
	}

}

package com.tsp.models;

import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

/**
 * This class contains eight methods (instance(), initialize(), show(), next(),
 * hasNext(), remove(), getRandomDomino() and isEmpty()), setters and getters
 * for the attributes.
 * 
 * @author Ramzi Sellami <ramzi_sellami@yahoo.fr>
 * @author Saurabh Sharma <saurabh.sharma@telecom-sudparis.eu>
 * 
 * @version 3.0.0
 * @since 10/05/2015
 */

public class Stock extends Vector implements Iterator<Domino<Integer>> {
	int n, lower, upper, index, range;
	int servedCount = 0;
	boolean[] served;
	Vector v = new Vector();
	Iterator itr = v.iterator();
	protected static Stock uniqueInstance;
	private static Domino dominoes;

	/**
	 * This method makes sure that we only have one instance of stock in the
	 * game.
	 * */
	public synchronized static Stock instance() {
		if (uniqueInstance == null)
			uniqueInstance = new Stock(dominoes);
		return uniqueInstance;
		// initialize();
	}

	/**
	 * We have a composition relation between the two classes Stock and Domino,
	 * so we have to instanciate Dominos at each time we instanciate Stock.
	 */
	protected Stock(Domino d) {
		d = dominoes;
		initialize();
	}

	/**
	 * Used in the constructor to initialize the hand of the player with 28
	 * random dominos from the stock.
	 */
	private void initialize() {
		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j <= i; j++)
				v.addElement(new Domino(i, j));
		}
	}

	/**
	 * This method is used to display on the standard output (console) the
	 * stock's value(s).
	 */
	public void show() {
		Iterator itr = v.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());

	}

	/**
	 * This function modifies the next method of the Iterator class 
	 * 
	 * @return a domino at a random index in the vector
	 * */
	public Domino next() {
		Random random = new Random();

		n = v.size();
		lower = 0;
		upper = n - 1;
		served = new boolean[n];
		index = v.size() - 1;
		range = upper - lower + 1;
		do {
			index = lower + random.nextInt(range);
			// System.out.printf("Index : %d\n", index);
		} while (served[index]);

		served[index] = true;
		servedCount++;

		// System.out.println(n);
		Domino d = (Domino) v.elementAt(index);
		v.removeElementAt(index);
		// d.displayDomino();
		return d;
	}

	/**
	 * This function modifies the hasNext() method of Iterator class. 
	 * Used to browse the vector using Iteration.
	 * 
	 * @return true or false
	 * */
	public boolean hasNext() {
		return servedCount < n;
	}

	/**
	 * This function throws an UnsupportedOperationException when it occurs
	 * while drawing from the stock.
	 * */
	public void remove() {
		throw new UnsupportedOperationException();
	}

	/**
	 * This function browse the stock and pick a random domino from it. Now a new method next() above is implemented
	 * 
	 * @return Random domino from the stock
	 */
	public Domino getRandomDomino() {
		if (v.size() == 0) {
			return null;
		} else {
			int value = (int) (Math.random() * (double) v.size());
			Domino d = (Domino) v.elementAt(value);
			// System.out.println("domino selected");
			// d.displayDomino();
			v.removeElementAt(value);
			return d;
		}
	}

	/**
	 * This function check if the stock is empty or not using Iteration.
	 * 
	 * @return true if stock is empty or false if stock is not empty.
	 */
	public boolean isEmpty() {
		Iterator itr = v.iterator();
		if (itr.hasNext())
			return false;
		else
			return true;

	}

}

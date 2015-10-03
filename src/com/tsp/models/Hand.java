package com.tsp.models;

import java.util.Vector;
import java.util.Iterator;

/**
 * This class contains seven methods (chooseDomino(),
 * chooseDominoWithoutRemoving(), canPutItOnTable(), getDomino(), show(),
 * removeFromHand() and drawFromStock()), setters and getters for the
 * attributes.
 * 
 * @author Ramzi Sellami <ramzi_sellami@yahoo.fr>
 * @author Saurabh Sharma <saurabh.sharma@telecom-sudparis.eu>
 * 
 * @version 3.0.0
 * @since 10/05/2015
 */
@SuppressWarnings("rawtypes")
public class Hand extends Vector<Domino<?>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * A variable in which we put the 16 domino left after filling the two
	 * player's hand
	 */
	Stock stock;

	// Fill the hand with random dominos from the stock.
	@SuppressWarnings("unchecked")
	public Hand(Stock stock) {
		//System.out.println("hand is initiliazed");
		this.stock = stock;
		for (int i = 1; i <= 6; i++)
			add(stock.getRandomDomino());
	}

	/**
	 * This function chooses the domino to play from the player's hand if he has
	 * any corresponding and removes it from the hand.
	 * 
	 * @param left
	 *            The left value of the domino
	 * 
	 * @param right
	 *            The right value of the domino
	 * 
	 * @return Domino chosen from the hand
	 */
	public Domino<?> chooseDomino(int left, int right) {
		Domino<Integer> d = null;
		boolean found = false;
		int i = 0;
		while ((!found) && (i < size())) {
			d = (Domino<Integer>)elementAt(i);
			if ((d.getLeftValue() == left) || (d.getLeftValue() == right)
					|| (d.getRightValue() == left)
					|| (d.getRightValue() == right)) {
				remove(i);
				found = true;
			}
			i++;
		}
		if (found)
			return d;
		return null;
	}

	/**
	 * This function chooses the domino to play from the player's hand if he has
	 * any corresponding without removing it from the hand.
	 * 
	 * @param left
	 *            The left value of the domino
	 * 
	 * @param right
	 *            The right value of the domino
	 * 
	 * @return Domino chosen from the hand
	 */
	public Domino<?> chooseDominoWithoutRemoving(int left, int right) {
		Domino<Integer> d = null;
		boolean found = false;
		int i = 0;
		while ((!found) && (i < size())) {
			d = (Domino<Integer>)elementAt(i);
			if ((d.getLeftValue() == left) || (d.getLeftValue() == right)
					|| (d.getRightValue() == left)
					|| (d.getRightValue() == right)) {
				found = true;
			}
			i++;
		}
		if (found)
			return d;
		return null;
	}

	/**
	 * This function checks if the player can play/put a chosen domino on the
	 * table according to the current extreme table values.
	 * 
	 * @param d
	 *            The chosen domino
	 * @param extLeftValue
	 *            The left extreme value of the table
	 * 
	 * @param extRightValue
	 *            The right extreme value of the table
	 * 
	 * @return True (if the player can put a specific domino) or False (if not)
	 */
	public boolean canPutItOnTable(Domino<Integer> d, int extLeftValue, int extRightValue) {
		if ((d.getLeftValue() == extLeftValue)
				|| (d.getLeftValue() == extRightValue)
				|| (d.getRightValue() == extLeftValue)
				|| (d.getRightValue() == extRightValue))
			return true;
		else
			return false;
	}

	/**
	 * This function checks if the domino with the value v1 and v2 exists get it
	 * and remove it from the user's hand.
	 * 
	 * @param v1
	 *            The left value of the domino
	 * 
	 * @param v2
	 *            The right value of the domino
	 * 
	 * @return The domino if it exists or null otherwise
	 */
	public Domino getDomino(int v1, int v2) {
		Domino d = new Domino(v1, v2);
		if (contains(d)) {
			int index = indexOf(d);
			Domino result = (Domino) elementAt(index);
			remove(d);
			return result;
		} else {
			return null;
		}
	}

	/**
	 * This method is used to display on the standard output (console) the
	 * player's hand value(s) using Iterator to browse the vector.
	 */
	public void show() {
		Iterator itr = iterator();
		while (itr.hasNext())
			System.out.println(itr.next());
		/*for (int i = 0; i < size(); i++) {
			Domino d = (Domino) elementAt(i);
			System.out.println((new StringBuilder()).append(d).append(" / ")
					.toString()); 
		}*/
	}

	/**
	 * This function removes a specific domino from the player's hand.
	 * 
	 * @param d
	 *            The domino to remove
	 * 
	 */
	public void removeFromHand(Domino d) {
		remove(d);
	}

	/**
	 * This function checks if the stock still contains dominos. If so, it will
	 * draw from it and put in the player's hand.
	 * 
	 * 
	 * @return The domino drawn from the stock
	 */
	@SuppressWarnings("unchecked")
	public Domino drawFromStock() {
		boolean draw = false;
		Domino d = null;
		if (!stock.isEmpty()) {
			d = stock.getRandomDomino();
			add(d);

			draw = true;
		}
		if (draw)
			return d;
		else
			return null;

	}

}

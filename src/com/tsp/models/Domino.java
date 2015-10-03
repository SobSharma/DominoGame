package com.tsp.models;

//import graphics.InterfaceDomino;

/**
 * This class contains three methods (toString(), displayDomino() and equals()),
 * setters and getters for the attributes.
 * 
 * @author Ramzi Sellami <ramzi_sellami@yahoo.fr>
 * @author Saurabh Sharma <saurabh.sharma@telecom-sudparis.eu>
 * 
 * @version 3.0.0
 * @since 10/05/2015
 */

public class Domino<T>  {

	/** A variable in which we put the left value of a domino */
	public T leftValue;
	/** A variable in which we put the right value of a domino */
	public T rightValue;

	/** The constructor of the Domino class */
	public Domino(T leftValue, T rightValue) {
		this.leftValue = leftValue;
		this.rightValue = rightValue;
	}

	/**
	 * Getters and Setters
	 * */
	public T getLeftValue() {
		return leftValue;
	}

	public void setLeftValue(T leftValue) {
		this.leftValue = leftValue;
	}

	public T getRightValue() {
		return rightValue;
	}

	public void setRightValue(T rightValue) {
		this.rightValue = rightValue;
	}

	/**
	 * This method is used to get a String object representing the value of the
	 * Number Object.
	 * 
	 * @return The string value of the two integer values of the domino
	 */
	public String toString() {
		return (new StringBuilder(String.valueOf(leftValue))).append(" : ")
				.append(rightValue).toString();
	}

	/**
	 * This method is used to display on the standard output (console) a domino
	 * appending its two values, the left and the right one. For example: "5-2"
	 * 
	 */
	public void displayDomino() {
		System.out.println(getLeftValue() + "-" + getRightValue());
	}

	/**
	 * Checks if a domino is equal to another one by comparing its two extreme
	 * values.
	 * 
	 * @param o
	 *            The object to compare to a domino
	 * 
	 * @return True (for equality) or False (for non equality)
	 */
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (!(o instanceof Domino))
			return false;
		Domino d = (Domino) o;
		return d.leftValue == leftValue && d.rightValue == rightValue
				|| d.leftValue == rightValue && d.rightValue == leftValue;
	}

}

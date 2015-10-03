package com.tsp.models;

/**
 * This class contains three methods (setNewExtremes(), display() and
 * instance()), setters and getters for the attributes.
 * 
 * @author Ramzi Sellami <ramzi_sellami@yahoo.fr>
 * @author Saurabh Sharma <saurabh.sharma@telecom-sudparis.eu>
 * 
 * @version 3.0.0
 * @since 10/05/2015
 */
public class Table {

	/**
	 * A variable in which we put the extreme value on the left side of the
	 * table
	 */
	int extremeValueLeft;
	/**
	 * A variable in which we put the extreme value on the right side of the
	 * table
	 */
	int extremeValueRight;

	/**
	 * A variable in which we put a unique instance of the class table.
	 */
	protected static Table uniqueInstance;

	/**
	 * This method makes sure that we only have one instance of a table in the
	 * game.
	 * */
	public synchronized static Table instance() {
		if (uniqueInstance == null)
			uniqueInstance = new Table();
		return uniqueInstance;
	}

	/**
	 * The constructor of the Table class. At first, it just initialize the
	 * table's extreme values with -1 both sides.
	 * */

	public Table() {
		extremeValueLeft = -1;
		extremeValueRight = -1;
	}

	/**
	 * Getters and Setters
	 * */

	public int getExtremeValueLeft() {
		return extremeValueLeft;
	}

	public void setExtremeValueLeft(int extremeValueLeft) {
		this.extremeValueLeft = extremeValueLeft;
	}

	public int getExtremeValueRight() {
		return extremeValueRight;
	}

	public void setExtremeValueRight(int extremeValueRight) {
		this.extremeValueRight = extremeValueRight;
	}

	/**
	 * When a player choose a domino to play, this function changes the extreme
	 * values already on the table with the new ones from the domino played.
	 * 
	 * @param d
	 *            The domino to put on the table
	 * 
	 */
	public void setNewExtremes(Domino<Integer> d) {

		if (extremeValueLeft == -1 && extremeValueRight == -1) {

			extremeValueLeft = d.getLeftValue();

			extremeValueRight = d.getRightValue();
		} else

		if (extremeValueRight == d.getLeftValue()) {

			extremeValueRight = d.getRightValue();
		} else if (extremeValueRight == d.getRightValue()) {

			extremeValueRight = d.getLeftValue();
		} else if (extremeValueLeft == d.getRightValue()) {

			extremeValueLeft = d.getLeftValue();
		} else if (extremeValueLeft == d.getLeftValue()) {

			extremeValueLeft = d.getRightValue();
		}

	}

	/**
	 * This method is used to display on the standard output (console) the
	 * current extreme values of the table.
	 * 
	 */
	public void display() {
		System.out.println("*********************");
		System.out
				.println((new StringBuilder("Current table extreme values: "))
						.append(extremeValueLeft).append(" : ")
						.append(extremeValueRight).toString());
		System.out.println("*********************");
	}

}

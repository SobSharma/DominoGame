package com.tsp.tests;

import com.tsp.models.*;

/**
 * This is a unit testing class related to the exceptions we implemented in our
 * code.
 * 
 * @author Ramzi Sellami <ramzi_sellami@yahoo.fr>
 * @author Saurabh Sharma <saurabh.sharma@telecom-sudparis.eu>
 * 
 * @version 3.0.0
 * @since 10/05/2015
 */

public class TestTableSingleton {

	public static void main(String[] args) {

		/** We create two new instances of table */
		Table table = Table.instance();
		Table table1 = Table.instance();

		/**
		 * We set the extreme values of the first one to 6 as a left value and 5
		 * as the right one
		 */
		table.setExtremeValueLeft(6);
		table.setExtremeValueRight(5);

		/** We display the results to see the singleton working */
		System.out.println("First Table: ");
		System.out.println("First Table Extreme Left Value  =  "
				+ table.getExtremeValueLeft());
		System.out.println("First Table Extreme Right Value  =  "
				+ table.getExtremeValueRight());

		System.out.println("Second Table1: ");
		System.out.println("Second Table Extreme Left Value =  "
				+ table1.getExtremeValueLeft());
		System.out.println("First Table Extreme Right Value  =  "
				+ table.getExtremeValueRight());

	} // end main
} // end TestClassSingleton */

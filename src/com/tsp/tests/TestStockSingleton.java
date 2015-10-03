package com.tsp.tests;

import com.tsp.models.*;

import java.util.Vector;

/**
 * This is a unit testing class testing the singleton design pattern
 * implementation for the stock in the domino game. It instantiates two(2)
 * objects of the same singleton class Stock, displays the domino pieces of both
 * instances.
 * 
 * @author Ramzi Sellami <ramzi_sellami@yahoo.fr>
 * @author Saurabh Sharma <saurabh.sharma@telecom-sudparis.eu>
 * 
 * @version 3.0.0
 * @since 10/05/2015
 */

public class TestStockSingleton {

	public static void main(String[] args) {

		/** We create two new instances of stock */
		Stock stock = Stock.instance();
		Stock stock1 = Stock.instance();
        
		/** We display that both refers to the same stock */
		System.out.println("First Stock: " + stock);
		stock.show();
		System.out.println();
		System.out.println("Second Stock1: " + stock1);
		stock1.show();

	} // end main
} // end TestClassSingleton

package com.tsp.tests;


import com.tsp.models.Hand;
import com.tsp.models.Domino;
import com.tsp.models.Player;
import com.tsp.models.Stock;
import com.tsp.models.Table;

/**
 * This is a unit testing class related to the random iterator function.
 * 
 * @author Ramzi Sellami <ramzi_sellami@yahoo.fr>
 * @author Saurabh Sharma <saurabh.sharma@telecom-sudparis.eu>
 * 
 * @version 3.0.0
 * @since 10/05/2015
 */

public class RandomIteratorTest {

	public static void main(String args[]) {
		
		/** We create a new instance of stock */
	    Stock stock = Stock.instance();
	    
	    /** We create a new instance of hand for the PC */
	    Hand handPc = new Hand(stock);
	    
	    /** We create a new instance of hand for the User */
	    Hand handUser =new Hand (stock);
	    
	    /** We display the results as an example here */
		System.out.println("Below is displayed the randomly picked Computer's hand of six dominos using Iterator");
		handPc.show();
		System.out.println("Below is displayed the randomly picked Player's hand of six dominos using Iterator");
		handUser.show();
		}
	
	

}

package com.tsp.tests;

import com.tsp.models.Domino;
import com.tsp.models.Game;
import com.tsp.models.Player;
import com.tsp.models.Stock;
import com.tsp.models.Table;

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

public class TestDominoExceptions {

	public static void main ( String args[] ){
	
	/** Set of variables used */	
	Stock mystock = null;
	String myname = null;
	Table mytable = null;
	Domino mydomino;
	Game mygame  = new Game();
	try {
		/** We create a new instance of player */
		Player myplayer = new Player(myname, mystock, mytable);
	}
	catch ( IllegalArgumentException myIllegal )
	{
		System.out.println("Player name not entered");
	}
	
	catch ( NullPointerException  nullpointer )
	{
		System.out.println("Table or Stock are not Initialised");
	}
}	
}


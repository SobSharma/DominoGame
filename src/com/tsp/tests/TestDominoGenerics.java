package com.tsp.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tsp.models.*;


/**
 * This is a Junit test to test the functioning of Generics in the Domino class. 
 * This test is to prove that Domino can of any data type
 * 
 * @author Ramzi Sellami <ramzi_sellami@yahoo.fr>
 * @author Saurabh Sharma <saurabh.sharma@telecom-sudparis.eu>
 * 
 * @version 3.0.0
 * @since 10/05/2015
 */


	public class TestDominoGenerics {

		/**
		 * A pair of integers
		 */
		Domino <Integer> PairOfIntegers;
		
		/**
		 * A copy of the pair of Integers {@code PairOfIntegers}
		 */
		Domino <Integer> PairOfIntegers_copy;
		
		/**
		 * A pair of characters
		 */
		Domino <Character> PairOfCharacters;
		
		/**
		 * A copy of the pair of Characters {@code PairOfCharacters}
		 */
		Domino <Character> PairOfCharacters_copy;
		
		
		/**
		 * A generic pair of pairs
		 */
		Domino <Domino <?>> PairOfDifferentTypes; 
		
		
		@Before
		public void setUp()  {
			
			PairOfIntegers = new Domino <Integer>(0,0);
			PairOfCharacters = new Domino <Character>('a', 'b');
			PairOfDifferentTypes = new Domino <Domino <?>>( new Domino <Integer>(1,2), new Domino <Character>('c', 'd'));
		}
		
		/**
		 * sets all test variables to null
		 */
		@After
		public void tearDown() {
			 PairOfIntegers = null;
			 PairOfCharacters = null;
			 PairOfDifferentTypes = null;
		}
		
		/**
		 * Tests method {@link Domino#toString()}
		 */
		@Test
		public void testToString() {
			
			Assert.assertEquals(PairOfIntegers.toString(), "0 : 0");
			Assert.assertEquals(PairOfCharacters.toString(), "a : b");
			Assert.assertEquals(PairOfDifferentTypes.toString(), "1 : 2 : c : d");
		}
		
		
		/**
		 * Tests method {@link Domino#equals} 
		 */
		@Test
		public void testEquals() {
			
			
			Assert.assertTrue(PairOfIntegers.equals(PairOfIntegers));
			Assert.assertEquals(PairOfDifferentTypes, PairOfDifferentTypes);
			Assert.assertEquals(PairOfCharacters, PairOfCharacters);
			
			Assert.assertFalse(PairOfIntegers.equals(PairOfCharacters));
			
			
			
			
			    
		}
		
	

}

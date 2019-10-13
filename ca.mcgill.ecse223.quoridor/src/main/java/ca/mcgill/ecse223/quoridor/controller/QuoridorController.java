package ca.mcgill.ecse223.quoridor.controller;

import javax.swing.text.Utilities;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.model.*;
import ca.mcgill.ecse223.quoridor.utilities.*;

public class QuoridorController {
	
	/**
	 * Method used to get the current Player
	 * @param Quoridor game
	 * @author Ousmane Baricisse
	 * @return Current Player
	 */
	public static Player getPlayer(Quoridor quoridorApp) throws Exception {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Method to capture the time at which the clock was started
	 * @param 
	 * @author Ousmane Baricisse
	 * @return  time in seconds
	 */
	public static long startClock() {
		try {
			return TimerUtilities.getCurrentTime();
		} catch(Exception e) {
			throw new UnsupportedOperationException();
		}
	}
	
	/**
	 * Method to capture the time at which the clock is stopped
	 * @param 
	 * @author Ousmane Baricisse
	 * @return time in seconds
	 */
	public static long stopClock() throws Exception{
		try {
			return TimerUtilities.getCurrentTime();
		} catch(Exception e) {
			throw new UnsupportedOperationException();
		}
		
	}
	
	/**
	 * @author Ousmane Baricisse
	 * @return
	 */
	public static boolean completeMove() {
		throw new UnsupportedOperationException();
	}
	/**
	 * @author Ousmane Baricisse
	 * @return
	 */
	public static String showPlayerTurn() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * @author Ousmane Baricisse
	 * @return
	 */
	
	public static void setNextPlayer() {
		throw new UnsupportedOperationException();
	}
	public static boolean numberOfWallsInStock() {
		throw new UnsupportedOperationException();
	}
}


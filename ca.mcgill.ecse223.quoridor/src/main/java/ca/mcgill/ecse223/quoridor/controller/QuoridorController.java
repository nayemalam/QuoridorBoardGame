package ca.mcgill.ecse223.quoridor.controller;
import java.io.File;

import ca.mcgill.ecse223.quoridor.model.*;
public class QuoridorController {

	/**
	 * Method - saveGameFile(String filename, Game game)
	 * 
	 * Controller method used to save the game as a text file
	 * This file can later be loaded to keep playing 
	 * this instance of the game
	 * 
	 * @param filename - String name of file
	 * @return String - contents of the file
	 * @author Nicolas Buisson
	 * 
	 */
	public static String saveGameFile(String filename) {
		
		throw new UnsupportedOperationException();
	}
	/**
	 * Method - overWriteFile()
	 * 
	 * Controller method used to overwrite a saved game file
	 * with the current game
	 * 
	 * @param filename - String name of file
	 * @return String - contains the content of the overwritten file
	 * @author Nicolas Buisson
	 * 
	 */
	public static String overWriteFile(String filename) {
		
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Method - cancelOverWriteFile()
	 * 
	 * Controller method used to cancel overwriting a file
	 * 
	 * @return String - content of file
	 * @author Nicolas Buisson
	 * 
	 */
	public static String cancelOverWriteFile() {
		throw new UnsupportedOperationException();
		//if user cancels overwriting the file
		//then nothing happens, file and model are unchanged
		//only change is in UI
		//might not have to be a controller method
	}
	/**
	 * Method - loadSavedGame()
	 * 
	 * Controller method used to load a file containing the game state
	 * of a previous game that the user wishes to continue playing
	 * 
	 * @param filename - name of file
	 * @return Game - the game to be continued is returned
	 * @author Nicolas Buisson
	 * 
	 */
	public static Game loadSavedGame(String filename) {
		throw new UnsupportedOperationException();
	}
}

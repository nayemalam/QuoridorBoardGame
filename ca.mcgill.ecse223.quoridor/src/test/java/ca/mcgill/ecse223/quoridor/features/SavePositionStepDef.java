package ca.mcgill.ecse223.quoridor.features;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ca.mcgill.ecse223.quoridor.model.*;
import ca.mcgill.ecse223.quoridor.controller.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;
import java.util.*;
import java.io.*;

/**
 * Class used to encapsulate the step definitions related to SavePosition
 * feature
 * 
 * @author Nicolas Buisson
 * 
 */
public class SavePositionStepDef {

	private QuoridorController QC = new QuoridorController();
	private String expected;
	private String previousContent;
	private String savedContent;

	// *********************************************
	// Save position scenario
	// *********************************************

	/**  
	 * @author Nicolas Buisson
	 */


	@Given ("No file {string} exists in the filesystem")
	public void NoFileExistsInTheFileSystem(String filename) {
		String pathName = filename;

		File file = new File (filename);

		// new File creates a pointer to the file
		//createNewFile actually creates it

		if(file.exists()) {
			//if file exists, delete it
			file.delete();
		}
		else 
		{
			//file is not there, do nothing
		}
	}

	/**  
	 * @author Nicolas Buisson
	 */
	@When ("The user initiates to save the game with name {string}")
	public void TheUserInitiatesToSaveTheGameWithName(String filename) throws IOException {
		//Create test game and content , Run saveGame() -- throws exception
		if(filename.contains(".dat")) {
			savedContent = QC.overwriteGamePosition(filename);
		}
		if(filename.contains(".mov")) {
			savedContent = QC.overwriteGameFile(filename);
		}
	}


	/**  
	 * @author Nicolas Buisson
	 */
	@Then ("A file with {string} shall be created in the filesystem")
	public void AFileShallBeCreatedInTheFileSystem(String filename) throws IOException {

		String pathName = filename;
		File file = new File(pathName);
		//boolean FileExists = false;
		boolean FileExists = file.exists();

		assertEquals(true, FileExists);
		assertEquals(filename, file.getName());
		//check if file exists
		//check if it has the right name
	}


	// *********************************************
	// Save position with existing file name scenario
	// *********************************************

	/**   
	 * @author Nicolas Buisson
	 */
	@Given ("File {string} exists in the filesystem")
	public void FileExistsInTheFileSystem(String filename) {
		//Read previous content from file
		if(filename.contains(".dat")) {
			expected = "W: a3" + "\n" + "B: f5";
			//TEST FOR WALLS
			Game testGame = QuoridorApplication.getQuoridor().getCurrentGame();
			Tile blackTile = new Tile(5, 6, QuoridorApplication.getQuoridor().getBoard());
			Tile whiteTile = new Tile(3, 1, QuoridorApplication.getQuoridor().getBoard());
			PlayerPosition aNewBlackPosition = new PlayerPosition(QuoridorApplication.getQuoridor().getCurrentGame().getBlackPlayer(), blackTile);
			PlayerPosition aNewWhitePosition = new PlayerPosition(QuoridorApplication.getQuoridor().getCurrentGame().getWhitePlayer(), whiteTile);
			testGame.getCurrentPosition().setBlackPosition(aNewBlackPosition);
			testGame.getCurrentPosition().setWhitePosition(aNewWhitePosition);
		}
		if(filename.contains(".mov")) {
			expected = "1. e8 e2" + "\n" + "2. e7 e3" + "\n" + "3. e3h e6h" ;
			Game testGame = QuoridorApplication.getQuoridor().getCurrentGame();
			List<Move> moves = testGame.getMoves();
			
			//CREATE MOVES
			
			StepMove whiteMove1 = new StepMove(1, 1, QC.getWhitePlayer(), new Tile(8,5, QuoridorApplication.getQuoridor().getBoard()), testGame);
			StepMove blackMove1 = new StepMove(2, 1, QC.getBlackPlayer(), new Tile(2,5, QuoridorApplication.getQuoridor().getBoard()), testGame);
			StepMove whiteMove2 = new StepMove(1, 2, QC.getWhitePlayer(), new Tile(7,5, QuoridorApplication.getQuoridor().getBoard()), testGame);
			StepMove blackMove2 = new StepMove(2, 2, QC.getBlackPlayer(), new Tile(3,5, QuoridorApplication.getQuoridor().getBoard()), testGame);
			Wall whiteWall = testGame.getCurrentPosition().getWhiteWallsInStock(0);
			testGame.getCurrentPosition().removeWhiteWallsInStock(whiteWall);
			WallMove whiteWallMove1 = new WallMove(1, 3, QC.getWhitePlayer(),new Tile(3, 5, QuoridorApplication.getQuoridor().getBoard()), testGame, Direction.Horizontal, whiteWall);
//			whiteWall.setMove(whiteWallMove1);
			testGame.getCurrentPosition().addWhiteWallsOnBoard(whiteWall);
			Wall blackWall = testGame.getCurrentPosition().getBlackWallsInStock(0);
			testGame.getCurrentPosition().removeBlackWallsInStock(blackWall);
			WallMove blackWallMove1 = new WallMove(2, 3, QC.getBlackPlayer(),new Tile(6, 5, QuoridorApplication.getQuoridor().getBoard()), testGame, Direction.Horizontal, blackWall);
//			blackWall.setMove(blackWallMove1);
			testGame.getCurrentPosition().addBlackWallsOnBoard(blackWall);
			
			//Wall moves don't automatically get added to List of moves
			
			//LINK MOVES TOGETHER
			
			whiteMove1.setNextMove(blackMove1);
			blackMove1.setPrevMove(whiteMove1);
			blackMove1.setNextMove(whiteMove2);
			whiteMove2.setPrevMove(blackMove1);
			whiteMove2.setNextMove(blackMove2);
			blackMove2.setPrevMove(whiteMove2);
			blackMove2.setNextMove(whiteWallMove1);
			whiteWallMove1.setPrevMove(blackMove2);
			whiteWallMove1.setNextMove(blackWallMove1);
			blackWallMove1.setPrevMove(whiteWallMove1);	
			
			testGame.addMove(whiteWallMove1);
			testGame.addMove(blackWallMove1);
		}
		
		String pathName = filename;

		File file = new File(pathName);

		if(file.exists()) {
			//if it exists do nothing
		}
		else 
			//file is not there, create it
		{
			try {
				file.createNewFile();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

	/**   
	 * @author Nicolas Buisson
	 */
	@And ("The user confirms to overwrite existing file")
	public void TheUserConfirmsToOverwriteExistingFile() throws IOException {
		// Run overwriteGame() via UI
	}

	/**  
	 * @author Nicolas Buisson
	 */
	@Then ("File with {string} shall be updated in the filesystem")
	public void FileShallBeUpdatedInTheFileSystem(String filename) {
		//# Read real content, assert that real content = testContent
		String pathName = filename;

		File file = new File(pathName);


		FileReader reader = null;
		try{
			reader = new FileReader(file);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		BufferedReader BF = new BufferedReader(reader); 

		String newContent = "";
		StringBuilder sb = new StringBuilder();
		try {
			String line = BF.readLine();
			while(line != null) {
				sb.append(line);
				sb.append("\n");
				line = BF.readLine();
			}	
			sb.delete(sb.length()-1, sb.length());
			newContent = sb.toString();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		assertEquals(filename, file.getName());
		assertEquals(newContent, expected);
		// check that file has the right name
		// check that content of the file is updated
	}

	// *********************************************
	// Save position cancelled due to existing file name scenario
	// *********************************************

	/**   
	 * @author Nicolas Buisson
	 */
	@And ("The user cancels to overwrite existing file")
	public void TheUserCancelsToOverwriteExistingFile() {
		QC.cancelOverWriteFile();

	}

	/**   
	 * @author Nicolas Buisson
	 */
	@Then ("File {string} shall not be changed in the filesystem")
	public void FileShallNotBeChangedInTheFileSystem(String filename) {
		// same as above, but assert that real content = previous content
		String pathName = filename;

		File file = new File(pathName);

		FileReader reader = null;
		try{
			reader = new FileReader(file);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		BufferedReader BF = new BufferedReader(reader); 

		String readContent = "";
		StringBuilder sb = new StringBuilder();
		try {
			String line = BF.readLine();
			while(line != null) {
				sb.append(line);
				sb.append("\n");
				line = BF.readLine();
			}	
			sb.delete(sb.length()-1, sb.length());
			readContent = sb.toString();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		assertEquals(filename, file.getName());
		assertEquals(savedContent, readContent);
		//check that the file has the right name
		//check the file has the same content as before
	}

}

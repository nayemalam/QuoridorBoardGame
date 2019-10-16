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
	private File file;
	private String content;

	// *********************************************
	// Save position scenario
	// *********************************************

	/**  
	 * @author Nicolas Buisson
	 */


	@Given ("No file {string} exists in the filesystem")
	public void NoFileExistsInTheFileSystem(String filename) {
		String pathName = "C:\\Users\\Alexander\\iteration2\\ecse223-project--group-04\\ca.mcgill.ecse223.quoridor\\src\\main\\" + filename + ".txt";
		// new File creates a pointer to the file
		//createNewFile actually creates it
		
		if(new File(pathName).exists()) {
			//if file exists, delete it
			new File(pathName).delete();
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
	public void TheUserInitiatesToSaveTheGameWithName(String filename) {
		content = QC.saveGameFile(filename);
		
	}


	/**  
	 * @author Nicolas Buisson
	 */
	@Then ("A file with {string} shall be created in the filesystem")
	public void AFileShallBeCreatedInTheFileSystem(String filename) {
		
		String pathName = "C:\\Users\\Alexander\\iteration2\\ecse223-project--group-04\\ca.mcgill.ecse223.quoridor\\src\\main\\" + filename + ".txt";
		file = new File(pathName);
		boolean FileExists = false;
		try {
			FileExists = file.createNewFile();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
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

		String pathName = "C:\\Users\\nbuis\\git\\ecse223-project--group-04\\ca.mcgill.ecse223.quoridor\\src\\main\\" + filename + ".txt";
		file = new File(pathName);
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
	public void TheUserConfirmsToOverwriteExistingFile(String filename) {
		content = QC.overWriteFile(filename);
		
	}

	/**  
	 * @author Nicolas Buisson
	 */
	@Then ("File with {string} shall be updated in the filesystem")
	public void FileShallBeUpdatedInTheFileSystem(String filename) {
		
		String pathName = "C:\\Users\\nbuis\\git\\ecse223-project--group-04\\ca.mcgill.ecse223.quoridor\\src\\main\\" + filename + ".txt";
		file = new File(pathName);
		FileReader reader = null;
		try{
			reader = new FileReader(file);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		BufferedReader BF = new BufferedReader(reader); 
	
		String acc = "";
		try {
			String line = BF.readLine();
			while(line != null) {
				acc += line;
				line = BF.readLine();
			}	
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		assertEquals(filename, file.getName());
		assertEquals(content ,acc);
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
		content = QC.cancelOverWriteFile();
		
	}

	/**   
	 * @author Nicolas Buisson
	 */
	@Then ("File {string} shall not be changed in the filesystem")
	public void FileShallNotBeChangedInTheFileSystem(String filename) {
		
		String pathName = "C:\\Users\\Alexander\\iteration2\\ecse223-project--group-04\\ca.mcgill.ecse223.quoridor\\src\\main\\" + filename + ".txt";
		file = new File(pathName);
		FileReader reader = null;
		try{
			reader = new FileReader(file);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		BufferedReader BF = new BufferedReader(reader); 
		
		String acc = "";
		try {
			String line = BF.readLine();
			while(line != null) {
				acc += line;
				line = BF.readLine();
			}	
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		assertEquals(filename, file.getName());
		assertEquals(content, acc);
		//check that the file has the right name
		//check the file has the same content as before
	}

}

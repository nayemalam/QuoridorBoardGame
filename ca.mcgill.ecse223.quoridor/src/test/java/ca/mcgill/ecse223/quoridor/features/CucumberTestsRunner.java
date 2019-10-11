package ca.mcgill.ecse223.quoridor.features;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;
import ca.mcgill.ecse223.quoridor.model.Direction;
import ca.mcgill.ecse223.quoridor.model.Quoridor;
import ca.mcgill.ecse223.quoridor.model.Tile;
import ca.mcgill.ecse223.quoridor.model.Wall;
import ca.mcgill.ecse223.quoridor.model.WallMove;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = "pretty", 
		features = "src/test/resources",
		glue = "ca.mcgill.ecse223.quoridor.features")
public class CucumberTestsRunner {
	private CucumberStepDefinitions csd = new CucumberStepDefinitions();

	//@Given - construct objects to match the scenario in the string.
	//@When - do what it says in the string (e.g. Move the pawn etc.) BY CONTROLLER METHOD 
	//@Then - get result of what I did before (the pawn) and make sure its at the right position.
	//Either use the QuoridorApplication.getQuoridor() to get the system and then call a whole bunch of methods until you arrive at the pawn
	// OR make a query method in your controler getPawn(Player) - getBlackPlayer()

	/**
	 * Methods that assigns the values of the position to the black player
	 * @param row
	 * @param col
	 * @author Alexander Legouverneur
	 */
	@Given("A game position is supplied with pawn coordinate {int}:{int}")
	public void aGamePositionIsSuppliedWithPawnCoordinate(int row, int col) {
		// Reinitialize board and system
		csd.theGameIsRunning();

		// Access the system
		Quoridor q = QuoridorApplication.getQuoridor();
		Tile myTile = new Tile(row, col, q.getBoard());


		//set the position
		q.getCurrentGame().getCurrentPosition().getBlackPosition().setTile(myTile);
	}

	/**
	 * Methods that initiates the validation of the position
	 * @author Alexander Legouverneur
	 */
	@When("Validation of the position is initiated")
	public void ValidationOfThePositionIsInitiated() {
		Quoridor q = QuoridorApplication.getQuoridor();
		QuoridorController.InitializeValidatePosition(q.getCurrentGame().getCurrentPosition().getBlackPosition().getTile().getRow(),q.getCurrentGame().getCurrentPosition().getBlackPosition().getTile().getColumn()); 
	}

	/**
	 * 
	 * @param result
	 */
	@Then("The result is {string}")
	public void validatePositionResult(String result) {
		Quoridor q = QuoridorApplication.getQuoridor();
		assertEquals(result, QuoridorController.ValidatePawnPosition(q.getCurrentGame().getCurrentPosition().getBlackPosition().getTile().getRow(), q.getCurrentGame().getCurrentPosition().getBlackPosition().getTile().getColumn()));
		assertEquals(result, QuoridorController.ValidatePawnPosition(q.getCurrentGame().getCurrentPosition().getBlackPosition().getTile().getRow(), q.getCurrentGame().getCurrentPosition().getBlackPosition().getTile().getRow()));
	}

	/**
	 * Method to check that position of wall is supplied with direction and coordinates
	 * @author Alexander Legouverneur
	 */
	@Given("A game position is supplied with wall coordinate {int}:{int}-{dir}")
	public void aGamePositionIsSuppliedWithWallCoordinateAndDir(int row, int col, Direction dir) {
		// Reinitialize board and system
		csd.theGameIsRunning();

		// Access the system
		Quoridor q = QuoridorApplication.getQuoridor();
		Tile myTile = new Tile(row, col, q.getBoard());

		//Assign the position and direction to the wall
		Tile aTile = new Tile(row, col, q.getBoard());
		Wall aWall = new Wall(11, q.getCurrentGame().getBlackPlayer());
		WallMove Move = new WallMove( 1, 1, q.getCurrentGame().getBlackPlayer(), aTile, q.getCurrentGame(), dir, aWall);
		aWall.setMove(Move);
	}

	/**
	 * Method that initiates the validation of the position
	 * @author Alexander Legouverneur
	 */
	@When("Validation of the position is initiated (Wall)")
	public void ValidationOfWallPositionInitiated() {
		Quoridor q = QuoridorApplication.getQuoridor();
		QuoridorController.InitiatePosValidation(q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getTargetTile(), q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getWallDirection());

	}

	/**
	 * Method that verifies if the position of the wall is returned in result
	 * @author Alexander Legouverneur
	 */
	@Then("The position shall be \"<result>\"(Wall)")
	public void TheWallPositionShallBeResult(int row, int col, Direction result) {
		Quoridor q = QuoridorApplication.getQuoridor();
		assertEquals(result,QuoridorController.ValidateWallDirection(q.getCurrentGame().getBlackPlayer().getWall(11)));
		Tile r = QuoridorController.ValidateWallTile(row,col);
		assertEquals(row, r.getRow());
		assertEquals(row, r.getColumn());
	}

	/**
	 * Method that places the wall on the board
	 * @author Alexander Legouverneur
	 */
	@Given("The following walls exist:")
	public void ThefollowingWallsExist() {
		//reinitialize game
		csd.theGameIsRunning();

		//access system
		Quoridor q = QuoridorApplication.getQuoridor();

		//place the wall 1
		Wall aWall1 = new Wall(11, q.getCurrentGame().getBlackPlayer());
		Tile aTile1 = new Tile(1,1,q.getBoard());
		WallMove Move1 = new WallMove( 1, 1, q.getCurrentGame().getBlackPlayer(), aTile1, q.getCurrentGame(), Direction.Horizontal, aWall1);
		aWall1.setMove(Move1);

		//place wall 2
		Wall aWall2 = new Wall(12, q.getCurrentGame().getBlackPlayer());
		Tile aTile2 = new Tile(7,4,q.getBoard());
		WallMove Move2 = new WallMove( 2, 1, q.getCurrentGame().getBlackPlayer(), aTile2, q.getCurrentGame(), Direction.Vertical, aWall2);
		aWall2.setMove(Move2);
	}

	/**
	 * Method to verify that the  validation of the wall position has been initiated
	 */
	@When("Validation of the position is initiated")
	public void ValidationOfWallPositionIsInitiated() {
		//access system
		Quoridor q = QuoridorApplication.getQuoridor();
		//QuoridorController.InitiatePosValidation(q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getTargetTile(), q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getWallDirection());
		QuoridorController.InitiatePosValidation(q.getCurrentGame().getBlackPlayer().getWall(12).getMove().getTargetTile(), q.getCurrentGame().getBlackPlayer().getWall(12).getMove().getWallDirection());
	}

	/**
	 * Method that verifies if the position of the wall is valid
	 * @author Alexander Legouverneur
	 */
	@Then("The position shall be valid")
	public void ThePositionShallBeValid() {
		Quoridor q = QuoridorApplication.getQuoridor();
		//assertEquals(true,QuoridorController.CheckWallValid(q.getCurrentGame().getBlackPlayer().getWall(11)));
		assertEquals(true,QuoridorController.CheckWallValid(q.getCurrentGame().getBlackPlayer().getWall(12)));
	}

	/**
	 * Method that places the wall on the board
	 * @author Alexander Legouverneur
	 */
	@Given("The following walls exist:")
	public void ThefollowingWallsExist2() {
		//reinitialize game
		csd.theGameIsRunning();

		//access system
		Quoridor q = QuoridorApplication.getQuoridor();

		//place the wall 1
		Wall aWall1 = new Wall(11, q.getCurrentGame().getBlackPlayer());
		Tile aTile1 = new Tile(2,3,q.getBoard());
		WallMove Move1 = new WallMove( 1, 1, q.getCurrentGame().getBlackPlayer(), aTile1, q.getCurrentGame(), Direction.Horizontal, aWall1);
		aWall1.setMove(Move1);

		//place wall 2
		Wall aWall2 = new Wall(12, q.getCurrentGame().getBlackPlayer());
		Tile aTile2 = new Tile(2,4,q.getBoard());
		WallMove Move2 = new WallMove( 2, 1, q.getCurrentGame().getBlackPlayer(), aTile2, q.getCurrentGame(), Direction.Horizontal, aWall2);
		aWall2.setMove(Move2);
	}

	/**
	 * Method to verify that the  validation of the wall position has been initiated
	 */
	@When("Validation of the position is initiated")
	public void ValidationOfWallPositionIsInitiated2() {
		//access system
		Quoridor q = QuoridorApplication.getQuoridor();
		//QuoridorController.InitiatePosValidation(q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getTargetTile(), q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getWallDirection());
		QuoridorController.InitiatePosValidation(q.getCurrentGame().getBlackPlayer().getWall(12).getMove().getTargetTile(), q.getCurrentGame().getBlackPlayer().getWall(12).getMove().getWallDirection());
	}

	/**
	 * Method that verifies if the position is invalid
	 * @author Alexander Legouverneur
	 */
	@Then("The position shall be invalid")
	public void ThePositionShallBeInvalid2() {
		Quoridor q = QuoridorApplication.getQuoridor();
		assertEquals(false,QuoridorController.CheckWallValid(q.getCurrentGame().getBlackPlayer().getWall(12)));	}


/**
 * Method that places the wall on the board
 * @author Alexander Legouverneur
 */
@Given("The following walls exist:")
public void ThefollowingWallsExist3() {
	//reinitialize game
	csd.theGameIsRunning();

	//access system
	Quoridor q = QuoridorApplication.getQuoridor();

	//place the wall 1
	Wall aWall1 = new Wall(11, q.getCurrentGame().getBlackPlayer());
	Tile aTile1 = new Tile(3,2,q.getBoard());
	WallMove Move1 = new WallMove( 1, 1, q.getCurrentGame().getBlackPlayer(), aTile1, q.getCurrentGame(), Direction.Vertical, aWall1);
	aWall1.setMove(Move1);

	//place wall 2
	Wall aWall2 = new Wall(12, q.getCurrentGame().getBlackPlayer());
	Tile aTile2 = new Tile(2,2,q.getBoard());
	WallMove Move2 = new WallMove( 2, 1, q.getCurrentGame().getBlackPlayer(), aTile2, q.getCurrentGame(), Direction.Vertical, aWall2);
	aWall2.setMove(Move2);
}

/**
 * Method to verify that the  validation of the wall position has been initiated
 */
@When("Validation of the position is initiated")
public void ValidationOfWallPositionIsInitiated3() {
	//access system
	Quoridor q = QuoridorApplication.getQuoridor();
	//QuoridorController.InitiatePosValidation(q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getTargetTile(), q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getWallDirection());
	QuoridorController.InitiatePosValidation(q.getCurrentGame().getBlackPlayer().getWall(12).getMove().getTargetTile(), q.getCurrentGame().getBlackPlayer().getWall(12).getMove().getWallDirection());
}

/**
 * Method that verifies if the position is invalid
 * @author Alexander Legouverneur
 */
@Then("The position shall be invalid")
public void ThePositionShallBeInvalid3() {
	Quoridor q = QuoridorApplication.getQuoridor();
	assertEquals(false,QuoridorController.CheckWallValid(q.getCurrentGame().getBlackPlayer().getWall(12)));	
	}

/**
 * Method that places the wall on the board
 * @author Alexander Legouverneur
 */
@Given("The following walls exist:")
public void ThefollowingWallsExist4() {
	//reinitialize game
	csd.theGameIsRunning();

	//access system
	Quoridor q = QuoridorApplication.getQuoridor();

	//place the wall 1
	Wall aWall1 = new Wall(11, q.getCurrentGame().getBlackPlayer());
	Tile aTile1 = new Tile(3,2,q.getBoard());
	WallMove Move1 = new WallMove( 1, 1, q.getCurrentGame().getBlackPlayer(), aTile1, q.getCurrentGame(), Direction.Vertical, aWall1);
	aWall1.setMove(Move1);

	//place wall 2
	Wall aWall2 = new Wall(12, q.getCurrentGame().getBlackPlayer());
	Tile aTile2 = new Tile(3,2,q.getBoard());
	WallMove Move2 = new WallMove( 2, 1, q.getCurrentGame().getBlackPlayer(), aTile2, q.getCurrentGame(), Direction.Horizontal, aWall2);
	aWall2.setMove(Move2);
}

/**
 * Method to verify that the  validation of the wall position has been initiated
 */
@When("Validation of the position is initiated")
public void ValidationOfWallPositionIsInitiated4() {
	//access system
	Quoridor q = QuoridorApplication.getQuoridor();
	//QuoridorController.InitiatePosValidation(q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getTargetTile(), q.getCurrentGame().getBlackPlayer().getWall(11).getMove().getWallDirection());
	QuoridorController.InitiatePosValidation(q.getCurrentGame().getBlackPlayer().getWall(12).getMove().getTargetTile(), q.getCurrentGame().getBlackPlayer().getWall(12).getMove().getWallDirection());
}

/**
 * Method that verifies if the position is invalid
 * @author Alexander Legouverneur
 */
@Then("The position shall be invalid")
public void ThePositionShallBeInvalid4() {
	Quoridor q = QuoridorApplication.getQuoridor();
	assertEquals(false,QuoridorController.CheckWallValid(q.getCurrentGame().getBlackPlayer().getWall(12)));	}
}
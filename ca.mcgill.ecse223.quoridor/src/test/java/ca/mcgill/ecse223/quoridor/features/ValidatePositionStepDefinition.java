package ca.mcgill.ecse223.quoridor.features;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.model.*;
import ca.mcgill.ecse223.quoridor.controller.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;

/**
 * Class that encapsulates the ValidatePosition Gherkin feature
 * @author Alexander Legouverneur
 *
 */
public class ValidatePositionStepDefinition {

	private String Validity = new String();
	
	private int providedRow;
	private int providedColumn;
	private String providedDirection;


	/**
	 * Methods that assigns the values of the position to the black player
	 * @param row
	 * @param col
	 * @author Alexander Legouverneur
	 */
	@Given("A game position is supplied with pawn coordinate {int}:{int}")
	public void a_game_position_is_supplied_with_pawn_coordinate(int int1, int int2) {

		// Access the system
		Quoridor q = QuoridorApplication.getQuoridor();
		
		providedRow = int1;
		providedColumn = int2;
	}

	/**
	 * Methods that initiates the validation of the position
	 * @author Alexander Legouverneur
	 */
	@When("Validation of the position is initiated")
	public void ValidationOfThePositionIsInitiated() {
		Quoridor q = QuoridorApplication.getQuoridor();
		//if there are no walls placed on the board then call the  method initialize validation for pawns
		//else call the method initialize validation for wall
		if(q.getCurrentGame().getCurrentPosition().getBlackPosition()== null) {
			QuoridorController.InitiatePosValidation(providedRow,providedColumn, providedDirection);
		}
		else {
			
			QuoridorController.InitializeValidatePosition(providedRow,providedColumn);
		}
		 
	}

	/**
	 * Verifies if the result is equal to what it should be
	 * @param result
	 */
	@Then("The result is {string}")
	public void validatePositionResult(String result) {
		assertEquals(result, QuoridorController.ValidatePawnPosition(providedRow, providedColumn));
	}

	/**
	 * Method that gets the coordinate and direction of wall
	 * @author Alexander Legouverneur
	 */
	@Given("A game position is supplied with wall coordinate {int}:{int}-{string}")
	public void aGamePositionIsSuppliedWithWallCoordinateAndDir(Integer row, Integer col, String dir) {
		
		

		//Assign the position and direction to the wall
		providedRow = row;
		providedColumn = col;
		providedDirection = dir;
	}

	/**
	 * Method that verifies if the position of the wall is returned in result
	 * @author Alexander Legouverneur
	 */
	@Then("The position shall be {string}")
	public void TheWallPositionShallBeResult(String result) {
		Quoridor q = QuoridorApplication.getQuoridor();
		if(q.getCurrentGame().getCurrentPosition().getBlackPosition()== null) {
		assertEquals(result,QuoridorController.ValidateWall(providedRow, providedColumn, providedDirection));
		}
		
	}
	
	/**
	 * This methld gets the information from the walls existing
	 * @author Alexander Legouverneur
	 */
	@Given("The following walls exist")
	public void The_following_walls_Exist() {
		Quoridor q = QuoridorApplication.getQuoridor();
		//first wall existing
		providedRow = q.getCurrentGame().getBlackPlayer().getWall(0).getMove().getTargetTile().getRow(); 
		providedColumn = q.getCurrentGame().getBlackPlayer().getWall(0).getMove().getTargetTile().getColumn();
		if(q.getCurrentGame().getBlackPlayer().getWall(0).getMove().getWallDirection() == Direction.Horizontal) {
		providedDirection = "horizontal";
		}
		if(q.getCurrentGame().getBlackPlayer().getWall(0).getMove().getWallDirection() == Direction.Vertical) {
			providedDirection = "vertical";
		}
		//second wall existing
		providedRow = q.getCurrentGame().getBlackPlayer().getWall(1).getMove().getTargetTile().getRow(); //first wall existing
		providedColumn = q.getCurrentGame().getBlackPlayer().getWall(1).getMove().getTargetTile().getColumn();
		if(q.getCurrentGame().getBlackPlayer().getWall(1).getMove().getWallDirection() == Direction.Horizontal) {
		providedDirection = "horizontal";
		}
		if(q.getCurrentGame().getBlackPlayer().getWall(1).getMove().getWallDirection() == Direction.Vertical) {
			providedDirection = "vertical";
		}
	}
	
	/**
	 * Method that verifies if the position of the wall is valid
	 * @author Alexander Legouverneur
	 */
	@Then("The position shall be valid")
	public void ThePositionShallBeValid() {
		assertEquals(true,QuoridorController.CheckWallValid(providedRow,providedColumn, providedDirection));
	}
	
	/**
	 * Method that verifies if the position is invalid
	 * @author Alexander Legouverneur
	 */
	@Then("The position shall be invalid")
	public void ThePositionShallBeInvalid2() {
		
		assertEquals(false,QuoridorController.CheckWallValid(providedRow,providedColumn, providedDirection));	
		}

}
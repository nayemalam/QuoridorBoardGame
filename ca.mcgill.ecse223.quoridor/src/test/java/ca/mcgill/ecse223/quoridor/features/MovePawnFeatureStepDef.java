package ca.mcgill.ecse223.quoridor.features;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import ca.mcgill.ecse223.quoridor.*;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;
import ca.mcgill.ecse223.quoridor.model.*;


/**
 * Class used to encapsulate the step definitions related to LoadPosition
 * feature
 * 
 * @author Nicolas Buisson
 * 
 */

public class MovePawnFeatureStepDef {

	private QuoridorController QC = new QuoridorController();
	private Quoridor q = QuoridorApplication.getQuoridor();
	private String statusOfMove = "";

	@Given("The player is located at {int}:{int}")
	public void the_player_is_located_at(Integer int1, Integer int2) {

		if(q.getCurrentGame().getCurrentPosition().getPlayerToMove().equals(q.getCurrentGame().getBlackPlayer())) {
			Tile playerTile = q.getBoard().getTile(9*(int1 -1) + (int2 -1));
			PlayerPosition playerPos = new PlayerPosition(q.getCurrentGame().getBlackPlayer(), playerTile);
			q.getCurrentGame().getCurrentPosition().setBlackPosition(playerPos);
		}else {
			Tile playerTile = q.getBoard().getTile(9*(int1 -1) + (int2 -1));
			PlayerPosition playerPos = new PlayerPosition(q.getCurrentGame().getBlackPlayer(), playerTile);
			q.getCurrentGame().getCurrentPosition().setWhitePosition(playerPos);
		}
	}

	@Given("The opponent is located at {int}:{int}")
	public void the_opponent_is_located_at(Integer int1, Integer int2) {

		if(q.getCurrentGame().getCurrentPosition().getPlayerToMove().equals(q.getCurrentGame().getBlackPlayer())) {
			Tile playerTile = q.getBoard().getTile(9*(int1 -1) + (int2 -1));
			PlayerPosition opponentPos = new PlayerPosition(q.getCurrentGame().getBlackPlayer(), playerTile);
			q.getCurrentGame().getCurrentPosition().setWhitePosition(opponentPos);
		}else {
			Tile playerTile = q.getBoard().getTile(9*(int1 -1) + (int2 -1));
			PlayerPosition opponentPos = new PlayerPosition(q.getCurrentGame().getBlackPlayer(), playerTile);
			q.getCurrentGame().getCurrentPosition().setBlackPosition(opponentPos);
		}
	}

	@Given("There are no {string} walls {string} from the player nearby")
	public void there_are_no_walls_from_the_player_nearby(String string, String string2) {
		//do nothing, don't place any walls
	}

	@When("Player {string} initiates to move {string}")
	public void player_initiates_to_move(String string, String string2) {
		Player player;
		if(string.equals("black")) {
			 player = q.getCurrentGame().getBlackPlayer();
		}else {
			 player = q.getCurrentGame().getWhitePlayer();
		}
		QC.MovePawn(player, string2);
	}

	@Then("The move {string} shall be {string}")
	public void the_move_shall_be(String string, String string2) {
		
		assertEquals(string2, statusOfMove);
	}

	@Then("Player's new position shall be {int}:{int}")
	public void player_s_new_position_shall_be(Integer int1, Integer int2) {

		if(q.getCurrentGame().getCurrentPosition().getPlayerToMove().equals(q.getCurrentGame().getBlackPlayer())) {
			assertEquals(int1, (Integer)q.getCurrentGame().getCurrentPosition().getBlackPosition().getTile().getRow());
			assertEquals(int2, (Integer)q.getCurrentGame().getCurrentPosition().getBlackPosition().getTile().getColumn());
		}else {
			assertEquals(int1, (Integer)q.getCurrentGame().getCurrentPosition().getWhitePosition().getTile().getRow());
			assertEquals(int1, (Integer)q.getCurrentGame().getCurrentPosition().getWhitePosition().getTile().getColumn());
		}

	}

	@Then("The next player to move shall become {string}")
	public void the_next_player_to_move_shall_become(String string) {
		
		String nextPlayerToMove = "";
		if(q.getCurrentGame().getCurrentPosition().getPlayerToMove().equals(q.getCurrentGame().getBlackPlayer())) {
			nextPlayerToMove = "white";
		}else {
			nextPlayerToMove = "black";
		}
		assertEquals(string, nextPlayerToMove);
	}

	@Given("There is a {string} wall at {int}:{int}")
	public void there_is_a_wall_at(String string, Integer int1, Integer int2) {

		if(string.equals("vertical")) {
			Wall wall = new Wall(0, q.getCurrentGame().getBlackPlayer());
			Tile wallTile = q.getBoard().getTile((int1 -1)*9 + (int2-1));
			WallMove wallMove = new WallMove(0, 0, q.getCurrentGame().getBlackPlayer(), wallTile, q.getCurrentGame(), Direction.Vertical, wall);
			wall.setMove(wallMove);
			q.getCurrentGame().getCurrentPosition().addBlackWallsOnBoard(wall);
		}
		else {
			Wall wall = new Wall(0, q.getCurrentGame().getBlackPlayer());
			Tile wallTile = q.getBoard().getTile((int1 -1)*9 + (int2-1));
			WallMove wallMove = new WallMove(0, 0, q.getCurrentGame().getBlackPlayer(), wallTile, q.getCurrentGame(), Direction.Horizontal, wall);
			wall.setMove(wallMove);
			q.getCurrentGame().getCurrentPosition().addBlackWallsOnBoard(wall);

		}
	}

}

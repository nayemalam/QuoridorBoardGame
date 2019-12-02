package ca.mcgill.ecse223.quoridor.features;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;

import ca.mcgill.ecse223.quoridor.model.*;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertEquals;

public class JumpToStartStepDefinition {

	private int moveNumber;
	private int RoundNumber;
//	private  PlayerPosition bp = new PlayerPosition(QuoridorController.getBlackPlayer(),QuoridorApplication.getQuoridor().getBoard().getTile(8*9+4));
//	private  PlayerPosition wp = new PlayerPosition(QuoridorController.getWhitePlayer(),QuoridorApplication.getQuoridor().getBoard().getTile(4));;
	//private int i=0;

	@Given("The following moves have been played in game:")
	public void the_following_moves_have_been_played_in_game(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		Quoridor q = QuoridorApplication.getQuoridor();
		List<Map<String, String>> valueMaps = dataTable.asMaps();
		
		for (Map<String, String> map : valueMaps) {
		//	i++;
			Integer moveN = Integer.decode(map.get("mv"));
			Integer round = Integer.decode(map.get("rnd"));
			String move = map.get("move");

			int col = ((int) move.charAt(0)) - 96;
			int row = move.charAt(1) - 48;
			// Tile aTile = new Tile(row, col,q.getBoard());
			if (move.length() == 2) {
				if (round == 1) {
					StepMove mv = new StepMove(moveN, 1, q.getCurrentGame().getWhitePlayer(),
							QuoridorController.getTileAtRowCol(row, col), q.getCurrentGame());
					q.getCurrentGame().getCurrentPosition().getWhitePosition().setTile(QuoridorController.getTileAtRowCol(row, col));
					//wp.setTile(QuoridorController.getTileAtRowCol(row, col));
					//q.getCurrentGame().getCurrentPosition().setWhitePosition(pp);
					
//					int index = q.getCurrentGame().getPositions().size() > 0 ? q.getCurrentGame().getPositions().size()  : 0;
//					GamePosition gp = new GamePosition(index,pp, q.getCurrentGame().getCurrentPosition().getBlackPosition(),q.getCurrentGame().getWhitePlayer(),q.getCurrentGame());
//					q.getCurrentGame().addPosition(gp);
				} else {
					StepMove mv = new StepMove(moveN, 1, q.getCurrentGame().getBlackPlayer(),
							QuoridorController.getTileAtRowCol(row, col), q.getCurrentGame());
					q.getCurrentGame().getCurrentPosition().getBlackPosition().setTile(QuoridorController.getTileAtRowCol(row, col));
//					int index = q.getCurrentGame().getPositions().size() > 0 ? q.getCurrentGame().getPositions().size()  : 0;
//					GamePosition gp = new GamePosition(index,q.getCurrentGame().getCurrentPosition().getWhitePosition(),pp ,q.getCurrentGame().getBlackPlayer(),q.getCurrentGame());
//					q.getCurrentGame().addPosition(gp);
					//q.getCurrentGame().getCurrentPosition().setBlackPosition(pp);
				
				}
//				if(i%2==1) {
//					int index = q.getCurrentGame().getPositions().size() > 0 ? q.getCurrentGame().getPositions().size()  : 0;
//					GamePosition gp = new GamePosition(index,wp, bp,q.getCurrentGame().getWhitePlayer(),q.getCurrentGame());
//					q.getCurrentGame().addPosition(gp);
//				}

			} else {
				int indexW = 0;
				int indexB = 0;
				if (move.charAt(2) == 'h') {
					if (round == 1) {
						Wall whiteWall = q.getCurrentGame().getWhitePlayer().getWall(indexW);
						q.getCurrentGame().getCurrentPosition().removeWhiteWallsInStock(whiteWall);
						WallMove aMove = new WallMove(moveN, round, q.getCurrentGame().getWhitePlayer(),
								QuoridorController.getTileAtRowCol(row, col), q.getCurrentGame(), Direction.Horizontal,
								whiteWall);
						q.getCurrentGame().addMove(aMove);
						q.getCurrentGame().getCurrentPosition().addWhiteWallsOnBoard(whiteWall);
						
						indexW++;
					}
					if (round == 2) {
						Wall BWall = q.getCurrentGame().getBlackPlayer().getWall(indexW);
						q.getCurrentGame().getCurrentPosition().removeWhiteWallsInStock(BWall);
						WallMove aMove = new WallMove(moveN, round, q.getCurrentGame().getBlackPlayer(),
								QuoridorController.getTileAtRowCol(row, col), q.getCurrentGame(), Direction.Horizontal,
								BWall);
						q.getCurrentGame().addMove(aMove);
						q.getCurrentGame().getCurrentPosition().addWhiteWallsOnBoard(BWall);
						indexB++;
					}
				}
				if (move.charAt(2) == 'v') {
					if (round == 1) {
						if (q.getCurrentGame().getWhitePlayer().getWall(indexW).hasMove()) {
							indexW++;
						}
						new WallMove(moveN, round, q.getCurrentGame().getWhitePlayer(),
								QuoridorController.getTileAtRowCol(row, col), q.getCurrentGame(), Direction.Vertical,
								q.getCurrentGame().getWhitePlayer().getWall(indexW));
						indexW++;
					}
					if (round == 2) {
						if (q.getCurrentGame().getBlackPlayer().getWall(indexB).hasMove()) {
							indexB++;
						}

						new WallMove(moveN, round, q.getCurrentGame().getBlackPlayer(),
								QuoridorController.getTileAtRowCol(row, col), q.getCurrentGame(), Direction.Vertical,
								q.getCurrentGame().getBlackPlayer().getWall(indexB));
						indexB++;
					}
				}
			}

		}
		//QuoridorController.gamePositions();
	}

	@Given("The next move is {double}")
	public void the_next_move_is(Double double1) {
		int moveN = double1.intValue();
		Double roundD = (double1 % 1) * 10;
		int round = roundD.intValue();

		moveNumber = moveN;
		RoundNumber = round;
	}

	@When("Jump to start position is initiated")
	public void jump_to_start_position_is_initiated() {

		QuoridorController.jumpToStart(moveNumber, RoundNumber);
	}

	@Then("The next move shall be {double}")
	public void the_next_move_shall_be(Double double1) {
		Quoridor q = QuoridorApplication.getQuoridor();
		int moveN = double1.intValue();
		Double roundD = (double1 % 1) * 10;
		int round = roundD.intValue();
		
		assertEquals(0, QuoridorController.moveController());
		
		
		
	}

	@Then("White player's position shall be \\({int},{int})")
	public void white_player_s_position_shall_be(int row, int col) {
		Quoridor q = QuoridorApplication.getQuoridor();
		QuoridorController.jumpToStart(moveNumber, RoundNumber);
		int myRow = q.getCurrentGame().getCurrentPosition().getWhitePosition().getTile().getRow();
		int myCol = q.getCurrentGame().getCurrentPosition().getWhitePosition().getTile().getColumn();
		assertEquals(row, myRow);
		assertEquals(col,myCol );
	}

	@Then("Black player's position shall be \\({int},{int})")
	public void black_player_s_position_shall_be(int row, int col) {
		Quoridor q = QuoridorApplication.getQuoridor();
		
		assertEquals(row, q.getCurrentGame().getCurrentPosition().getBlackPosition().getTile().getRow());
		assertEquals(col, q.getCurrentGame().getCurrentPosition().getBlackPosition().getTile().getColumn());
	}

	@Then("White has {int} on stock")
	public void white_has_wwallno_on_stock(int int1) {
		Quoridor q = QuoridorApplication.getQuoridor();
		assertEquals(int1, q.getCurrentGame().getCurrentPosition().getWhiteWallsInStock().size());
	}

	@Then("Black has {int} on stock")
	public void black_has_on_stock(int int1) {
		Quoridor q = QuoridorApplication.getQuoridor();
		assertEquals(int1, q.getCurrentGame().getCurrentPosition().getBlackWallsInStock().size());
	}

}

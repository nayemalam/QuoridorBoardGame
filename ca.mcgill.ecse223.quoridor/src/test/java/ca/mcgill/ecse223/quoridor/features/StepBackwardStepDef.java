package ca.mcgill.ecse223.quoridor.features;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Map;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;
import ca.mcgill.ecse223.quoridor.model.Direction;
import ca.mcgill.ecse223.quoridor.model.Game;
import ca.mcgill.ecse223.quoridor.model.Move;
import ca.mcgill.ecse223.quoridor.model.Player;
import ca.mcgill.ecse223.quoridor.model.Quoridor;
import ca.mcgill.ecse223.quoridor.model.StepMove;
import ca.mcgill.ecse223.quoridor.model.Tile;
import ca.mcgill.ecse223.quoridor.model.Wall;
import ca.mcgill.ecse223.quoridor.model.WallMove;
import ca.mcgill.ecse223.quoridor.model.Game.GameStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepBackwardStepDef {
    private int moveNumber;
    private int roundNumber;
    @Given("The game is in replay mode")
    public void setGameInReplayMode(){
        Game game = QuoridorApplication.getQuoridor().getCurrentGame();
        game.setGameStatus(GameStatus.Replay);
    }

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
			Integer moveN = Integer.decode(map.get("mv"));
			Integer round = Integer.decode(map.get("rnd"));
			String move = map.get("move");

			int col = ((int) move.charAt(0)) - 96;
			int row = move.charAt(1) - 48;
			Tile aTile = new Tile(row, col,q.getBoard());
			if(move.length() == 2) {
				if(round == 1) {
					StepMove mv = new StepMove( moveN, 1, q.getCurrentGame().getWhitePlayer(), aTile, q.getCurrentGame());
				}
				else {
					StepMove mv = new StepMove( moveN, 1, q.getCurrentGame().getBlackPlayer(), aTile, q.getCurrentGame());
				}

			}
			else {
				int indexW = 0;
				int indexB = 0;
				if(move.charAt(2) == 'h') {
					if(round == 1) {
						new WallMove(moveN, round, q.getCurrentGame().getWhitePlayer(), aTile, q.getCurrentGame(), Direction.Horizontal,q.getCurrentGame().getWhitePlayer().getWall(indexW));
						indexW++;
					}
					if( round == 2) {
						new WallMove(moveN, round, q.getCurrentGame().getBlackPlayer(), aTile, q.getCurrentGame(), Direction.Horizontal,q.getCurrentGame().getBlackPlayer().getWall(indexB));
						indexB++;
					}
				}
				if(move.charAt(2) == 'v') {
					if(round == 1) {
						new WallMove(moveN, round, q.getCurrentGame().getWhitePlayer(), aTile, q.getCurrentGame(), Direction.Vertical,q.getCurrentGame().getWhitePlayer().getWall(indexW));
						indexW++;
					}
					if( round == 2) {
						new WallMove(moveN, round, q.getCurrentGame().getBlackPlayer(), aTile, q.getCurrentGame(), Direction.Vertical,q.getCurrentGame().getBlackPlayer().getWall(indexB));
						indexB++;
					}
				}
			}

		}
	}

	@Given("The next move is {double}")
	public void the_next_move_is(Double double1) {
		int moveN = double1.intValue();
		Double roundD = (double1%1)*10;
		int round = roundD.intValue();

		moveNumber = moveN;
		roundNumber = round;
	}
    @When("Step backward is initiated")
    public void initStepForward(){

    }

   // @Then("")
    
    

}
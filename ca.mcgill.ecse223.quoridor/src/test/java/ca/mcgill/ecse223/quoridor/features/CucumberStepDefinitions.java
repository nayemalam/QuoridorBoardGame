package ca.mcgill.ecse223.quoridor.features;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.model.Board;
import ca.mcgill.ecse223.quoridor.model.Direction;
import ca.mcgill.ecse223.quoridor.model.Game;
import ca.mcgill.ecse223.quoridor.model.Game.GameStatus;
import ca.mcgill.ecse223.quoridor.model.Game.MoveMode;
import ca.mcgill.ecse223.quoridor.model.GamePosition;
import ca.mcgill.ecse223.quoridor.model.Player;
import ca.mcgill.ecse223.quoridor.model.PlayerPosition;
import ca.mcgill.ecse223.quoridor.model.Quoridor;
import ca.mcgill.ecse223.quoridor.model.Tile;
import ca.mcgill.ecse223.quoridor.model.User;
import ca.mcgill.ecse223.quoridor.model.Wall;
import ca.mcgill.ecse223.quoridor.model.WallMove;
import cucumber.api.PendingException;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

public class CucumberStepDefinitions {

	// ***********************************************
	// Background step definitions
	// ***********************************************

	@Given("^The game is not running$")
	public void theGameIsNotRunning() {
		initQuoridorAndBoard();
		createUsersAndPlayers("user1", "user2");
	}

	@Given("^The game is running$")
	public void theGameIsRunning() {
		initQuoridorAndBoard();
		ArrayList<Player> createUsersAndPlayers = createUsersAndPlayers("user1", "user2");
		createAndStartGame(createUsersAndPlayers);
	}

	@And("^It is my turn to move$")
	public void itIsMyTurnToMove() throws Throwable {
		Quoridor quoridor = QuoridorApplication.getQuoridor();
		Player currentPlayer = quoridor.getCurrentGame().getWhitePlayer();
		QuoridorApplication.getQuoridor().getCurrentGame().getCurrentPosition().setPlayerToMove(currentPlayer);
	}

	@Given("The following walls exist:")
	public void theFollowingWallsExist(io.cucumber.datatable.DataTable dataTable) {
		Quoridor quoridor = QuoridorApplication.getQuoridor();
		List<Map<String, String>> valueMaps = dataTable.asMaps();
		// keys: wrow, wcol, wdir
		Player[] players = { quoridor.getCurrentGame().getWhitePlayer(), quoridor.getCurrentGame().getBlackPlayer() };
		int playerIdx = 0;
		int wallIdxForPlayer = 0;
		for (Map<String, String> map : valueMaps) {
			Integer wrow = Integer.decode(map.get("wrow"));
			Integer wcol = Integer.decode(map.get("wcol"));
			// Wall to place
			// Walls are placed on an alternating basis wrt. the owners
			//Wall wall = Wall.getWithId(playerIdx * 10 + wallIdxForPlayer);
			Wall wall = players[playerIdx].getWall(wallIdxForPlayer); // above implementation sets wall to null

			String dir = map.get("wdir");

			Direction direction;
			switch (dir) {
			case "horizontal":
				direction = Direction.Horizontal;
				break;
			case "vertical":
				direction = Direction.Vertical;
				break;
			default:
				throw new IllegalArgumentException("Unsupported wall direction was provided");
			}
			new WallMove(0, 1, players[playerIdx], quoridor.getBoard().getTile((wrow - 1) * 9 + wcol - 1), quoridor.getCurrentGame(), direction, wall);
			if (playerIdx == 0) {
				quoridor.getCurrentGame().getCurrentPosition().removeWhiteWallsInStock(wall);
				quoridor.getCurrentGame().getCurrentPosition().addWhiteWallsOnBoard(wall);
			} else {
				quoridor.getCurrentGame().getCurrentPosition().removeBlackWallsInStock(wall);
				quoridor.getCurrentGame().getCurrentPosition().addBlackWallsOnBoard(wall);
			}
			wallIdxForPlayer = wallIdxForPlayer + playerIdx;
			playerIdx++;
			playerIdx = playerIdx % 2;
		}
		System.out.println();

	}

	@And("I do not have a wall in my hand")
	public void iDoNotHaveAWallInMyHand() {
		// GUI-related feature -- TODO for later
	}
	
	@And("^I have a wall in my hand over the board$")
	public void iHaveAWallInMyHandOverTheBoard() throws Throwable {
		// GUI-related feature -- TODO for later
	}
	
	// ***********************************************
	// Scenario and scenario outline step definitions
	// ***********************************************

	/*
	 * TODO Insert your missing step definitions here
	 * 
	 * Call the methods of the controller that will manipulate the model once they
	 * are implemented
	 * 
	 */
	
	// ***********************************************
	// Initiate a new game scenario
	
	/**
	 * When method for when a game is initializing
	 * @throws Exception 
	 */
	@When("A new game is initializing")
	public void aNewGameIsInitializing() throws Exception {
		QuoridorController.initiateNewGame(game);
	}
	
	/**
	 * Method to verify that the white player has chosen a correct name
	 */
	@And("White player chooses a username")
	public void whitePlayerHasAUserName() {
		Boolean userIsInvalidOrNull = game.equals(null) && game.getWhitePlayer().equals(null)
				&& game.getWhitePlayer().getUser().equals(null);
		if(userIsInvalidOrNull) {
			fail();
		}
		User whiteUser = game.getWhitePlayer().getUser();
		validateUser(whiteUser);
	}
	
	/**
	 * Method to verify that the black player has chosen a correct name
	 */
	@And("Black player chooses a username")
	public void blackPlayerHasAUserName() {
		Boolean userIsInvalidOrNull = game.equals(null) && game.getBlackPlayer().equals(null)
				&& game.getBlackPlayer().getUser().equals(null);
		if(userIsInvalidOrNull) {
			fail();
		}
		User blackUser = game.getBlackPlayer().getUser();
		validateUser(blackUser);
	}
	
	/**
	 * Method used to verify that the total thinking time for both players
	 * has been set.
	 */
	@And("Total thinking time is set")
	public void totalThinkingTimeIsSet() {
		
		Player playerWhite = QuoridorApplication.getQuoridor().getCurrentGame().getWhitePlayer();
		Player playerBlack = QuoridorApplication.getQuoridor().getCurrentGame().getBlackPlayer();
		
		// Verify player 1 thinking time
		Time thinkingTimeP1 = playerWhite.getRemainingTime();
		if(thinkingTimeP1.equals(null) || thinkingTimeP1.equals(new Time(0))) {
			fail();
		}
		// Verify player 2 thinking time
		Time thinkingTimeP2 = playerBlack.getRemainingTime();
		if(thinkingTimeP2.equals(null) || thinkingTimeP2.equals(new Time(0))) {
			fail();
		}
	}
	
	/**
	 * Method to verify that the game is ready to start
	 */
	@Then("The game is ready to start")
	public void th1eGameIsReadyToStart() {
		assertEquals(Game.GameStatus.ReadyToStart, QuoridorApplication.getQuoridor().getCurrentGame().getGameStatus());
	}
	
	// ***************************************************
	// Start clock scenario
	@Given("The game is ready to start")
	public void theGameIsReadyToStart() throws Exception {
		theGameIsRunning();
	}
	
	/**
	 * Method used to start the clock on the current player
	 * @throws Exception
	 */
	@When("I start the clock")
	public void iStartTheClock() throws Exception {
		QuoridorController.startClock(game);
	}
	
	@And("The board is initialized")
	public void andTheBoardIsInitialized(){
		
	}
	
	@Then("The game is running")
	public void themtheGameIsRunning() {
		
	}
	
	// ***************************************************
	
	@When("The board is initialized")
	public void whenTheBoardIsInitialized() throws Exception {
		QuoridorController.initializeBoard(board);
	}
	
	@Then("It is white player to move")
	public void itIsWhitePlayerToMove() {
		throw new PendingException();
	}
	@And("White's pawn is in its initial position")
	public void whitesPawnIsInInitialPosition() {
		
	}
	@And("Black's pawn is in its initial position")
	public void blacksPawnIsInInitialPosition() {
		
	}
	@And("All of White's walls are in stock")
	public void allOfWhitesWallsAreInStock() {
		
	}
	@And("All of Black's walls are in stock")
	public void allOfBlacksWallsAreInStock() {
		
	}
	/**
	 * Verify that the clock for the current player is counting down
	 */
	@And("White's clock is counting down")
	public void whitesClockIsCountingDown() {
		
	}
	/**
	 * GUI step to verify that it is whites turn
	 */
	@And("It is shown that this is White's turn")
	public void itIsShownThatThisIsWhitesTurn() {
		throw new PendingException();
	}
	// ***********************************************

	// ***********************************************
	// Clean up
	// ***********************************************

	// After each scenario, the test model is discarded
	@After
	public void tearDown() {
		Quoridor quoridor = QuoridorApplication.getQuoridor();
		// Avoid null pointer for step definitions that are not yet implemented.
		if (quoridor != null) {
			quoridor.delete();
			quoridor = null;
		}
		for (int i = 0; i < 20; i++) {
			Wall wall = Wall.getWithId(i);
			if(wall != null) {
				wall.delete();
			}
		}
	}

	// ***********************************************
	// Extracted helper methods
	// ***********************************************

	// Place your extracted methods below
	
	private void validateUser(User user) {
		if(user.equals(null)) {
			fail();
		}
		if (!isUserNameValid(user.getName())) {
			fail();
		}
	}
	/**
	 * Method to verify the validity of a selectedUsername.
	 * @param userName - Name to verify
	 */
	private Boolean isUserNameValid(String userName) {
		userName = userName.trim();
		return (userName != null && !userName.isEmpty() && !userName.equals("") );
	}
	
	private void initQuoridorAndBoard() {
		Quoridor quoridor = QuoridorApplication.getQuoridor();
		Board board = new Board(quoridor);
		// Creating tiles by rows, i.e., the column index changes with every tile
		// creation
		for (int i = 1; i <= 9; i++) { // rows
			for (int j = 1; j <= 9; j++) { // columns
				board.addTile(i, j);
			}
		}
	}

	private ArrayList<Player> createUsersAndPlayers(String userName1, String userName2) {
		Quoridor quoridor = QuoridorApplication.getQuoridor();
		User user1 = quoridor.addUser(userName1);
		User user2 = quoridor.addUser(userName2);

		int thinkingTime = 180;

		// Players are assumed to start on opposite sides and need to make progress
		// horizontally to get to the other side
		//@formatter:off
		/*
		 *  __________
		 * |          |
		 * |          |
		 * |x->    <-x|
		 * |          |
		 * |__________|
		 * 
		 */
		//@formatter:on
		Player player1 = new Player(new Time(thinkingTime), user1, 9, Direction.Horizontal);
		Player player2 = new Player(new Time(thinkingTime), user2, 1, Direction.Horizontal);

		Player[] players = { player1, player2 };

		// Create all walls. Walls with lower ID belong to player1,
		// while the second half belongs to player 2
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 10; j++) {
				new Wall(i * 10 + j, players[i]);
			}
		}
		
		ArrayList<Player> playersList = new ArrayList<Player>();
		playersList.add(player1);
		playersList.add(player2);
		
		return playersList;
	}

	private void createAndStartGame(ArrayList<Player> players) {
		Quoridor quoridor = QuoridorApplication.getQuoridor();
		// There are total 36 tiles in the first four rows and
		// indexing starts from 0 -> tiles with indices 36 and 36+8=44 are the starting
		// positions
		Tile player1StartPos = quoridor.getBoard().getTile(36);
		Tile player2StartPos = quoridor.getBoard().getTile(44);
		
		Game game = new Game(GameStatus.Running, MoveMode.PlayerMove, players.get(0), players.get(1), quoridor);

		PlayerPosition player1Position = new PlayerPosition(quoridor.getCurrentGame().getWhitePlayer(), player1StartPos);
		PlayerPosition player2Position = new PlayerPosition(quoridor.getCurrentGame().getBlackPlayer(), player2StartPos);

		GamePosition gamePosition = new GamePosition(0, player1Position, player2Position, players.get(0), game);

		// Add the walls as in stock for the players
		for (int j = 0; j < 10; j++) {
			Wall wall = Wall.getWithId(j);
			gamePosition.addWhiteWallsInStock(wall);
		}
		for (int j = 0; j < 10; j++) {
			Wall wall = Wall.getWithId(j + 10);
			gamePosition.addBlackWallsInStock(wall);
		}

		game.setCurrentPosition(gamePosition);
	}

}

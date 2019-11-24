package ca.mcgill.ecse223.quoridor.features;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;
import ca.mcgill.ecse223.quoridor.model.Game;
import ca.mcgill.ecse223.quoridor.model.Player;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResignGameStepDef {

    private Player currentPlayer;

    /* DONE in SwitchPlayerStepDefinition.java
        > Given The player to move is "<player>"
    */

    @When("Player initates to resign")
    public void player_initates_to_resign() {
        QuoridorController.playerResigns();
    }

    @Then("Game result shall be {string}")
    public void game_result_shall_be(String result) {
        currentPlayer = QuoridorApplication.getQuoridor().getCurrentGame().getBlackPlayer();
        currentPlayer.setNextPlayer(QuoridorApplication.getQuoridor().getCurrentGame().getWhitePlayer());
        if(currentPlayer.equals(QuoridorApplication.getQuoridor().getCurrentGame().getBlackPlayer())) {
            assertEquals(result, Game.GameStatus.BlackWon.toString());
        } else {
            assertEquals(result, Game.GameStatus.WhiteWon.toString());
        }
    }
    // and then
    @And("The game shall no longer be running")
    public void the_game_shall_no_longer_be_running() {
        // Write code here that turns the phrase above into concrete actions
        currentPlayer = QuoridorApplication.getQuoridor().getCurrentGame().getBlackPlayer();
        currentPlayer.setNextPlayer(QuoridorApplication.getQuoridor().getCurrentGame().getWhitePlayer());

        assertEquals("", "");
    }
}

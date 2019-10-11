package ca.mcgill.ecse223.quoridor.features;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;
import ca.mcgill.ecse223.quoridor.model.Game;
import ca.mcgill.ecse223.quoridor.model.Player;
import ca.mcgill.ecse223.quoridor.model.User;
import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class ProvideSelectUserNameStepDef {

    private Player currentPlayer;

    // *********************************************
    // Select existing user name scenario
    // *********************************************

    @Given("Next player to set user name is {string}")
    public void NextPlayerToSetUserNameIsColor(String color) throws Exception {
        Game g = QuoridorApplication.getQuoridor().getCurrentGame();
//		Player currentPlayer = color.equals("white") ? g.getBlackPlayer() : g.getWhitePlayer();
        if(color.equals("white")) {
            currentPlayer = g.getBlackPlayer();
            currentPlayer.setNextPlayer(g.getWhitePlayer());
        }
        else if(color.equals("black")) {
            currentPlayer = g.getWhitePlayer();
            currentPlayer.setNextPlayer(g.getBlackPlayer());
        }
    }

    @And("There is existing user {string}")
    public void ThereIsExistingUserName(String username) {
        // populate empty list with existing user
        QuoridorApplication.getQuoridor().getUsers().add(new User(username, QuoridorApplication.getQuoridor()));
    }

    @When("The player selects existing {string}")
    public void ThePlayerSelectsExistingUser(String username) throws Exception{
        QuoridorController.selectExistingUserName(username);
    }

    @Then("The name of player {string} in the new game shall be {string}")
    public void TheNameOfPlayerColorInTheNewGameShallBeUser(String color, String username) {
        if(color.equals("white")){
            assertEquals(username, QuoridorApplication.getQuoridor().getCurrentGame().getWhitePlayer().getUser().getName());
        }
        else if (color.equals("black")) {
            assertEquals(username, QuoridorApplication.getQuoridor().getCurrentGame().getBlackPlayer().getUser().getName());
        } else {
            throw new PendingException();
        }
    }


    // *********************************************
    // Create new user name scenario
    // *********************************************

    // DONE during first scenario: Given Next player to set user name is "<color>"

    @And("There is no existing user {string}")
    public void ThereIsNoExistingUserName(String username) {
        QuoridorApplication.getQuoridor().getUsers().remove(new User(username, QuoridorApplication.getQuoridor()));
    }

    @When("The player provides new user name: {string}")
    public void ThePlayerProvidesNewUserName(String username) throws Exception {
        QuoridorController.selectNewUserName(username);
    }

    // DONE during first scenario: The name of player "<color>" in the new game shall be "<username>"

    // *********************************************
    // User name already exists scenario
    // *********************************************

    /* DONE during first scenario
    > Given Next player to set user name is "<color>"

    > And There is existing user "<username>"

    > When The player provides new user name: "<username>"
    */

    @Then("The player shall be warned that {string} already exists")
    public void ThePlayerShallBeWarnedThatUserNameAlreadyExists(String username) {
        throw new PendingException();
    }

    @And("Next player to set user name shall be {string}")
    public void NextPlayerToSetUserNameShallBeColor(String color) {
        assertEquals(color, currentPlayer.getNextPlayer().getUser().getName());
    }
}

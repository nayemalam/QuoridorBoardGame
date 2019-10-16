package ca.mcgill.ecse223.quoridor.features;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;
import ca.mcgill.ecse223.quoridor.model.Game;
import ca.mcgill.ecse223.quoridor.model.Player;
import ca.mcgill.ecse223.quoridor.model.User;
import cucumber.api.Pending;
import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static ca.mcgill.ecse223.quoridor.features.TestingUtilities.isExisting;
import static org.junit.Assert.assertEquals;
/**
 * Class used to encapsulate the step definitions related to the ProvideSelectUserName
 * feature
 *
 * @author Nayem Alam
 *
 */
public class ProvideSelectUserNameStepDef {

    /**
     * Field can be applied to select any player (white or black)
     */
    private Player currentPlayer;

    // *********************************************
    // Select existing user name scenario
    // *********************************************

    /**
     * Method used to set next player username based on color
     *
     * @param color the color can be white or black
     * @author Nayem Alam
     */
    @Given("Next player to set user name is {string}")
    public void next_player_to_set_user_name_is(String color) {
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
//        else {
          // Not sure if that's a pending exception or can just remove the 'else' statemtn
//          throw new PendingException("The color entered is not white or black");
//        }
    }

    /**
     * Method used to show that there is an existing user
     *
     * @param username the username exists within the list of users
     * @author Nayem Alam
     */
    @And("There is existing user {string}")
    public void there_is_existing_user(String username) {
        // populate empty list with existing user
        QuoridorApplication.getQuoridor().getUsers().add(new User(username, QuoridorApplication.getQuoridor()));
    }

    /**
     * Method used to allow player to select an existing user name
     *
     * @param username the username already exists
     * @throws Exception (UnsupportedOperationException) since Controller method isn't implemented yet
     * @author Nayem Alam
     */
    @When("The player selects existing {string}")
    public void the_player_selects_existing(String username) throws Exception{
        QuoridorController.selectExistingUserName(username);
    }

    /**
     * Method used to verify the username given the corresponding color
     *
     * @param color the color can be white or black
     * @param username the username of player in new game
     * @author Nayem Alam
     */
    @Then("The name of player {string} in the new game shall be {string}")
    public void the_name_of_player_in_the_new_game_shall_be(String color, String username) {
        if(color.equals("white")){
            assertEquals(username, QuoridorApplication.getQuoridor().getCurrentGame().getWhitePlayer().getUser().getName());
        }
        else if (color.equals("black")) {
            assertEquals(username, QuoridorApplication.getQuoridor().getCurrentGame().getBlackPlayer().getUser().getName());
        }
//        else {
          // Not sure if that's a pending exception or can just remove the 'else' statemtn
//            throw new PendingException();
//        }
    }

    // *********************************************
    // Create new user name scenario
    // *********************************************

    /* DONE during first scenario
        > Given Next player to set user name is "<color>"
    */

    /**
     * Method used to show that there is no existing user
     *
     * @param username the username does not exist within the list of users
     * @author Nayem Alam
     */
    @And("There is no existing user {string}")
    public void there_is_no_existing_user(String username) {
        QuoridorApplication.getQuoridor().getUsers().remove(new User(username, QuoridorApplication.getQuoridor()));
    }

    /**
     * Method used to allow player to provide a new username
     *
     * @param username new username provided by player
     * @throws Exception (UnsupportedOperationException) since Controller method isn't implemented yet
     * @author Nayem Alam
     */
    @When("The player provides new user name: {string}")
    public void the_player_provides_new_user_name(String username) throws Exception {
        QuoridorController.selectNewUserName(username);
    }

    /* DONE during first scenario
        > The name of player "<color>" in the new game shall be "<username>"
    */

    // *********************************************
    // User name already exists scenario
    // *********************************************

    /* DONE during first scenario
        > Given Next player to set user name is "<color>"

        > And There is existing user "<username>"

        > When The player provides new user name: "<username>"
    */

    /**
     * Method used to warn player if the username already exists
     *
     * @param username the username of player in new game
     * @throws PendingException bc I believe warning user can be done on (GUI) but not sure
     * @author Nayem Alam
     */
    @Then("The player shall be warned that {string} already exists")
    public void the_player_shall_be_warned_that_already_exists(String username) {
        if(isExisting(username)){
            assertEquals("user name exists", username,QuoridorApplication.getQuoridor().getUsers().get(0).toString() );
        } else {
            throw new PendingException(); // GUI maybe -- TODO
        }
    }
    /**
     * Method used to verify the next player's username given the corresponding color
     *
     * @param color color determines the corresponding username of the next player in new game
     * @author Nayem Alam
     */
    @And("Next player to set user name shall be {string}")
    public void next_player_to_set_user_name_shall_be(String color) {
        // if this color is white then next player is white??
        // I need to verify between the input color and the player's color but
        // not sure how to check what color the player currently has
        throw new PendingException(); // GUI maybe -- TODO
    }

}

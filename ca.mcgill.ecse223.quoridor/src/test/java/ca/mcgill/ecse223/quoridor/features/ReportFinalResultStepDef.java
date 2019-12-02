package ca.mcgill.ecse223.quoridor.features;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;
import ca.mcgill.ecse223.quoridor.model.Game;
import ca.mcgill.ecse223.quoridor.model.Player;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import sun.security.util.PendingException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReportFinalResultStepDef {

    @When("The game is no longer running")
    public void the_game_is_no_longer_running() {

    }

    @Then("The final result shall be displayed")
    public void the_final_result_shall_be_displayed() {

    }

    // and then
    @And("White's clock shall not be counting down")
    public void white_s_clock_shall_not_be_counting_down() {
//        if(currentPlayer.equals(QuoridorApplication.getQuoridor().getCurrentGame().getWhitePlayer())) {
//            whiteClock = !QuoridorController.startClock();
//        }
//        assertTrue(whiteClock);
    }

    @And("Black's clock shall not be counting down")
    public void black_s_clock_shall_not_be_counting_down() {
//        if(currentPlayer.equals(QuoridorApplication.getQuoridor().getCurrentGame().getBlackPlayer())) {
//            blackClock = !QuoridorController.startClock();
//        }
//        assertTrue(blackClock);
    }

    @And("White shall be unable to move")
    public void white_shall_be_unable_to_move() {

    }

    @And("Black shall be unable to move")
    public void black_shall_be_unable_to_move() {

    }





}

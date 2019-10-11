package ca.mcgill.ecse223.quoridor.features;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;
import ca.mcgill.ecse223.quoridor.model.Player;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.Time;

import static org.junit.Assert.assertEquals;

public class SetTotalThinkingTimeStepDef {

    // *********************************************
    // Set thinking time for players scenario
    // *********************************************

    @When("{int}:{int} is set as the thinking time")
    public void MinSecIsSetAsTheThinkingTime(int min, int sec) throws Exception {
        QuoridorController.setThinkingTime(min, sec);
    }
    @Then("Both players shall have {int}:{int} remaining time left")
    public void BothPlayersShallHaveMinSecRemainingTimeLeft(int min, int sec) {
        Time t = new Time(min*60l*1000 + sec*1000l);
        Player bPlayer = QuoridorApplication.getQuoridor().getCurrentGame().getBlackPlayer();
        Player wPlayer = QuoridorApplication.getQuoridor().getCurrentGame().getWhitePlayer();

        assertEquals(t, wPlayer.getRemainingTime());
        assertEquals(t, bPlayer.getRemainingTime());
    }
}

package ca.mcgill.ecse223.quoridor.features;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;
import ca.mcgill.ecse223.quoridor.model.Player;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.sql.Time;
import static org.junit.Assert.assertEquals;
/**
 * Class used to encapsulate the step definitions related to the SetTotalThinkingTime
 * feature
 *
 * @author Nayem Alam
 *
 */
public class SetTotalThinkingTimeStepDef {

    // *********************************************
    // Set thinking time for players scenario
    // *********************************************

    /**
     * Method used to set total thinking time (for both players)
     *
     * @param min sets the number of minutes
     * @param sec sets the number of seconds
     * @throws Exception (UnsupportedOperationException) since Controller method isn't implemented yet
     * @author Nayem Alam
     */
    @When("{int}:{int} is set as the thinking time")
    public void MinSecIsSetAsTheThinkingTime(int min, int sec) throws Exception {
        // controller method should set same thinking time for both p1&p2 -- i think
        QuoridorController.setThinkingTime(min, sec);
    }
    /**
     * Method used to verify that both players have the same remaining time left
     *
     * @param min sets the number of minutes
     * @param sec sets the number of seconds
     * @author Nayem Alam
     */
    @Then("Both players shall have {int}:{int} remaining time left")
    public void BothPlayersShallHaveMinSecRemainingTimeLeft(int min, int sec) {
        // converts min and sec to long type (unix epoch time)
        Time t = new Time(min*60l*1000 + sec*1000l);
        Player bPlayer = QuoridorApplication.getQuoridor().getCurrentGame().getBlackPlayer();
        Player wPlayer = QuoridorApplication.getQuoridor().getCurrentGame().getWhitePlayer();

        assertEquals(t, wPlayer.getRemainingTime());
        assertEquals(t, bPlayer.getRemainingTime());
    }
}

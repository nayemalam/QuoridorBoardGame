package ca.mcgill.ecse223.quoridor.features;
import static org.junit.Assert.assertEquals;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;
import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

public class SwitchPlayerStepDefinition {
	// ***********************************************
		// Switch Player Feature
		// ***********************************************
		@Given("The player to move is an? (.*)")
		public void thePlayerToMoveIsPlayer() throws Exception {
			QuoridorController.getPlayer(QuoridorApplication.getQuoridor());
		}
		
		@And(" The clock of \"<player>\" is an? (.*) ")
		public void theClockOfPlayerXIsRunning() {
			QuoridorController.startClock();
		}
		
		@And("The clock of \"<other>\" is stopped")
		public void theClockOfOtherIsStopped() throws Exception {
			QuoridorController.stopClock();
		}
		
		@When("Player \"<player>\" completes his move")
		public void playerXCompletesHisMove(){
			QuoridorController.completeMove();
		}
		
		@Then("The user interface shall be showing it is \"<other>\" turn")
		public void theUserInterfaceShallBeShowingItIsPlayerYTurn() {
			QuoridorController.showPlayerTurn();
		}
		@And("The clock of \"<player>\" shall be stopped")
		public void theClockOfPlayerXShallBeStopped() throws Exception {
			QuoridorController.startClock();
		}
		@And("The clock of \"<other>\" shall be running$")
		public void theClockOfPlayerYShallBeRunning() throws Exception {
			QuoridorController.stopClock();
		}
		
		@And("The next player to move shall be \"<other>\"")
		public void theNextPlayerToMoveShallBePlayerY() {
			QuoridorController.setNextPlayer();
		}
}

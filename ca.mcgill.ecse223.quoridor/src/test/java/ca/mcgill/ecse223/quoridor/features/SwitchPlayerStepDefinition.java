package ca.mcgill.ecse223.quoridor.features;
import static org.junit.Assert.assertEquals;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;
import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SwitchPlayerStepDefinition {
	// ***********************************************
		// Switch Player Feature
		// ***********************************************
		@Given("The player to move is /.*/")
		public void getPlayerToMove() throws Exception {
			QuoridorController.getPlayer(QuoridorApplication.getQuoridor());
		}
		
		@And(" The clock of \"<player>\" is running$")
		public void startPlayerClock() {
			QuoridorController.startClock();
		}
		
		@And("The clock of \"<other>\" is stopped$")
		public void stopPlayerClock() throws Exception {
			QuoridorController.stopClock();
		}
		
		@When("Player \"<player>\" completes his move$")
		public void completeMove(){
			QuoridorController.completeMove();
		}
		
		@Then("The user interface shall be showing it is \"<other>\" turn$")
		public void showPlayerTurn() {
			QuoridorController.showPlayerTurn();
		}
		@And("The clock of \"<player>\" shall be stopped$")
		public void stopPlayerClock2() throws Exception {
			QuoridorController.startClock();
		}
		@And("The clock of \"<other>\" shall be running$")
		public void startPlayer2Clock() throws Exception {
			QuoridorController.stopClock();
		}
		
		@And("The next player to move shall be \"<other>\"$")
		public void setNextPlayerToMove() {
			QuoridorController.setNextPlayer();
		}
}

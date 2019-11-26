package ca.mcgill.ecse223.quoridor.features;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.controller.QuoridorController;
import ca.mcgill.ecse223.quoridor.model.Game;
import ca.mcgill.ecse223.quoridor.model.Player;
import ca.mcgill.ecse223.quoridor.model.Quoridor;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResignGameStepDef {

    /* DONE in SwitchPlayerStepDefinition.java
        > Given The player to move is "<player>"
    */

    @When("Player initates to resign")
    public void player_initates_to_resign() {
            QuoridorController.playerWins(QuoridorController.getCurrentPlayer());
    }

    /* DONE in IdentifyGameWonStepDefinition.java
        > Then Game result shall be "{string}"
    */

    /* DONE in IdentifyGameWonStepDefinition.java
        > And The game shall no longer be running
    */

}

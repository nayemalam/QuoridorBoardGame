package ca.mcgill.ecse223.quoridor.utilities;

import java.sql.Time;
import java.util.TimerTask;

import ca.mcgill.ecse223.quoridor.controller.QuoridorController;
import ca.mcgill.ecse223.quoridor.model.Player;

public class ThreadTimer extends TimerTask{
    private static final int SECOND_IN_MS = 1000;
    
    Player player;
    public ThreadTimer(Player player){
    	this.player = player;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
    	Long timeLeft = player.getRemainingTime().getTime();
    	if(!(timeLeft > 0)) {
    		throw new RuntimeException("Time is up!");
    	}
    	Time newTime = new Time(timeLeft - SECOND_IN_MS);
    	QuoridorController.getCurrentPlayer().setRemainingTime(newTime);
    	
        System.out.println("Time Left for current player:" + TimerUtilities.clockToString(newTime.getTime()));
        
   }

}
package ca.mcgill.ecse223.quoridor.features;

import static org.junit.Assert.fail;

import java.sql.Time;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.model.User;

class TestingUtilities {

	// ***************************************
	// Constants
	// ***************************************
	
	// ***************************************
	// Some other constants used for tests
	public static final String WHITE_PLAYER_NAME = "playerW";
	public static final String BLACK_PLAYER_NAME = "playerB";
	public static final long THINKING_TIME_MS = 30000; // 30,000ms = 30s
	
	// ***************************************
	

	/**
	 * Helper method, used to validate if a user with a username is valid
	 * 
	 * @param user
	 * @author Tristan Bouchard
	 */
	public static void validateUser(User user) {
		if (user.equals(null)) {
			fail();
		}
		if (!isUserNameValid(user.getName())) {
			fail();
		}
	}

	/**
	 * Method to verify the validity of a selectedUsername.
	 * 
	 * @param userName - Name to verify
	 * @author Tristan Bouchard
	 */
	public static Boolean isUserNameValid(String userName) {
		userName = userName.trim();
		return (userName != null && !userName.isEmpty() && !userName.equals(""));
	}

	/**
	 * Method to check if username already exists
	 *
	 * @param username - username to check
	 * @author Nayem Alam
	 */
	public static boolean isExisting(String username) {
		QuoridorApplication.getQuoridor().getUsers().add(new User(username, QuoridorApplication.getQuoridor()));
		String existingUsername = QuoridorApplication.getQuoridor().getUsers().get(0).toString();
		if(username.equals(existingUsername)) {
			return true;
		}
		return false;
	}
}


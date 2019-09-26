/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.quoridor.model;
import java.util.*;
import java.sql.Date;
import java.sql.Time;

// line 3 "../../../../../model.ump"
// line 63 "../../../../../model.ump"
public class QuorridorGame
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //QuorridorGame Associations
  private List<User> users;
  private GameBoard gameBoard;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public QuorridorGame(GameBoard aGameBoard)
  {
    users = new ArrayList<User>();
    if (aGameBoard == null || aGameBoard.getQuorridorGame() != null)
    {
      throw new RuntimeException("Unable to create QuorridorGame due to aGameBoard");
    }
    gameBoard = aGameBoard;
  }

  public QuorridorGame(Date aStartDateForGameBoard, Time aStartTimeForGameBoard)
  {
    users = new ArrayList<User>();
    gameBoard = new GameBoard(aStartDateForGameBoard, aStartTimeForGameBoard, this);
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public User getUser(int index)
  {
    User aUser = users.get(index);
    return aUser;
  }

  public List<User> getUsers()
  {
    List<User> newUsers = Collections.unmodifiableList(users);
    return newUsers;
  }

  public int numberOfUsers()
  {
    int number = users.size();
    return number;
  }

  public boolean hasUsers()
  {
    boolean has = users.size() > 0;
    return has;
  }

  public int indexOfUser(User aUser)
  {
    int index = users.indexOf(aUser);
    return index;
  }
  /* Code from template association_GetOne */
  public GameBoard getGameBoard()
  {
    return gameBoard;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfUsers()
  {
    return 0;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfUsers()
  {
    return 2;
  }
  /* Code from template association_AddOptionalNToOne */
  public User addUser(String aUserName)
  {
    if (numberOfUsers() >= maximumNumberOfUsers())
    {
      return null;
    }
    else
    {
      return new User(aUserName, this);
    }
  }

  public boolean addUser(User aUser)
  {
    boolean wasAdded = false;
    if (users.contains(aUser)) { return false; }
    if (numberOfUsers() >= maximumNumberOfUsers())
    {
      return wasAdded;
    }

    QuorridorGame existingQuorridorGame = aUser.getQuorridorGame();
    boolean isNewQuorridorGame = existingQuorridorGame != null && !this.equals(existingQuorridorGame);
    if (isNewQuorridorGame)
    {
      aUser.setQuorridorGame(this);
    }
    else
    {
      users.add(aUser);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeUser(User aUser)
  {
    boolean wasRemoved = false;
    //Unable to remove aUser, as it must always have a quorridorGame
    if (!this.equals(aUser.getQuorridorGame()))
    {
      users.remove(aUser);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addUserAt(User aUser, int index)
  {  
    boolean wasAdded = false;
    if(addUser(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUserAt(User aUser, int index)
  {
    boolean wasAdded = false;
    if(users.contains(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUserAt(aUser, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while (users.size() > 0)
    {
      User aUser = users.get(users.size() - 1);
      aUser.delete();
      users.remove(aUser);
    }
    
    GameBoard existingGameBoard = gameBoard;
    gameBoard = null;
    if (existingGameBoard != null)
    {
      existingGameBoard.delete();
    }
  }

}
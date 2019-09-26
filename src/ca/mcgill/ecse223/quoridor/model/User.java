/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.quoridor.model;
import java.util.*;

// line 9 "../../../../../model.ump"
// line 73 "../../../../../model.ump"
public class User
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum Orientation { Horizontal, Vertical }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //User Attributes
  private String userName;

  //User Associations
  private Pawn pawn;
  private List<Wall> walls;
  private QuorridorGame quorridorGame;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User(String aUserName, QuorridorGame aQuorridorGame)
  {
    userName = aUserName;
    walls = new ArrayList<Wall>();
    boolean didAddQuorridorGame = setQuorridorGame(aQuorridorGame);
    if (!didAddQuorridorGame)
    {
      throw new RuntimeException("Unable to create user due to quorridorGame");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setUserName(String aUserName)
  {
    boolean wasSet = false;
    userName = aUserName;
    wasSet = true;
    return wasSet;
  }

  public String getUserName()
  {
    return userName;
  }
  /* Code from template association_GetOne */
  public Pawn getPawn()
  {
    return pawn;
  }

  public boolean hasPawn()
  {
    boolean has = pawn != null;
    return has;
  }
  /* Code from template association_GetMany */
  public Wall getWall(int index)
  {
    Wall aWall = walls.get(index);
    return aWall;
  }

  public List<Wall> getWalls()
  {
    List<Wall> newWalls = Collections.unmodifiableList(walls);
    return newWalls;
  }

  public int numberOfWalls()
  {
    int number = walls.size();
    return number;
  }

  public boolean hasWalls()
  {
    boolean has = walls.size() > 0;
    return has;
  }

  public int indexOfWall(Wall aWall)
  {
    int index = walls.indexOf(aWall);
    return index;
  }
  /* Code from template association_GetOne */
  public QuorridorGame getQuorridorGame()
  {
    return quorridorGame;
  }
  /* Code from template association_SetUnidirectionalOptionalOne */
  public boolean setPawn(Pawn aNewPawn)
  {
    boolean wasSet = false;
    pawn = aNewPawn;
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfWalls()
  {
    return 0;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfWalls()
  {
    return 10;
  }
  /* Code from template association_AddUnidirectionalOptionalN */
  public boolean addWall(Wall aWall)
  {
    boolean wasAdded = false;
    if (walls.contains(aWall)) { return false; }
    if (numberOfWalls() < maximumNumberOfWalls())
    {
      walls.add(aWall);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean removeWall(Wall aWall)
  {
    boolean wasRemoved = false;
    if (walls.contains(aWall))
    {
      walls.remove(aWall);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_SetUnidirectionalOptionalN */
  public boolean setWalls(Wall... newWalls)
  {
    boolean wasSet = false;
    ArrayList<Wall> verifiedWalls = new ArrayList<Wall>();
    for (Wall aWall : newWalls)
    {
      if (verifiedWalls.contains(aWall))
      {
        continue;
      }
      verifiedWalls.add(aWall);
    }

    if (verifiedWalls.size() != newWalls.length || verifiedWalls.size() > maximumNumberOfWalls())
    {
      return wasSet;
    }

    walls.clear();
    walls.addAll(verifiedWalls);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addWallAt(Wall aWall, int index)
  {  
    boolean wasAdded = false;
    if(addWall(aWall))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWalls()) { index = numberOfWalls() - 1; }
      walls.remove(aWall);
      walls.add(index, aWall);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveWallAt(Wall aWall, int index)
  {
    boolean wasAdded = false;
    if(walls.contains(aWall))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWalls()) { index = numberOfWalls() - 1; }
      walls.remove(aWall);
      walls.add(index, aWall);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addWallAt(aWall, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToAtMostN */
  public boolean setQuorridorGame(QuorridorGame aQuorridorGame)
  {
    boolean wasSet = false;
    //Must provide quorridorGame to user
    if (aQuorridorGame == null)
    {
      return wasSet;
    }

    //quorridorGame already at maximum (2)
    if (aQuorridorGame.numberOfUsers() >= QuorridorGame.maximumNumberOfUsers())
    {
      return wasSet;
    }
    
    QuorridorGame existingQuorridorGame = quorridorGame;
    quorridorGame = aQuorridorGame;
    if (existingQuorridorGame != null && !existingQuorridorGame.equals(aQuorridorGame))
    {
      boolean didRemove = existingQuorridorGame.removeUser(this);
      if (!didRemove)
      {
        quorridorGame = existingQuorridorGame;
        return wasSet;
      }
    }
    quorridorGame.addUser(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    pawn = null;
    walls.clear();
    QuorridorGame placeholderQuorridorGame = quorridorGame;
    this.quorridorGame = null;
    if(placeholderQuorridorGame != null)
    {
      placeholderQuorridorGame.removeUser(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "userName" + ":" + getUserName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "pawn = "+(getPawn()!=null?Integer.toHexString(System.identityHashCode(getPawn())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "quorridorGame = "+(getQuorridorGame()!=null?Integer.toHexString(System.identityHashCode(getQuorridorGame())):"null");
  }
}
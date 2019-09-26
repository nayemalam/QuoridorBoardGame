/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.quoridor.model;
import java.sql.Date;
import java.sql.Time;
import java.util.*;

// line 16 "../../../../../model.ump"
// line 82 "../../../../../model.ump"
public class GameBoard
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum Color { Black, White }
  public enum Orientation { Horizontal, Vertical }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GameBoard Attributes
  private Date startDate;
  private Time startTime;

  //GameBoard Associations
  private List<Wall> walls;
  private List<Pawn> pawns;
  private QuorridorGame quorridorGame;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GameBoard(Date aStartDate, Time aStartTime, QuorridorGame aQuorridorGame)
  {
    startDate = aStartDate;
    startTime = aStartTime;
    walls = new ArrayList<Wall>();
    pawns = new ArrayList<Pawn>();
    if (aQuorridorGame == null || aQuorridorGame.getGameBoard() != null)
    {
      throw new RuntimeException("Unable to create GameBoard due to aQuorridorGame");
    }
    quorridorGame = aQuorridorGame;
  }

  public GameBoard(Date aStartDate, Time aStartTime)
  {
    startDate = aStartDate;
    startTime = aStartTime;
    walls = new ArrayList<Wall>();
    pawns = new ArrayList<Pawn>();
    quorridorGame = new QuorridorGame(this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStartDate(Date aStartDate)
  {
    boolean wasSet = false;
    startDate = aStartDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setStartTime(Time aStartTime)
  {
    boolean wasSet = false;
    startTime = aStartTime;
    wasSet = true;
    return wasSet;
  }

  public Date getStartDate()
  {
    return startDate;
  }

  public Time getStartTime()
  {
    return startTime;
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
  /* Code from template association_GetMany */
  public Pawn getPawn(int index)
  {
    Pawn aPawn = pawns.get(index);
    return aPawn;
  }

  public List<Pawn> getPawns()
  {
    List<Pawn> newPawns = Collections.unmodifiableList(pawns);
    return newPawns;
  }

  public int numberOfPawns()
  {
    int number = pawns.size();
    return number;
  }

  public boolean hasPawns()
  {
    boolean has = pawns.size() > 0;
    return has;
  }

  public int indexOfPawn(Pawn aPawn)
  {
    int index = pawns.indexOf(aPawn);
    return index;
  }
  /* Code from template association_GetOne */
  public QuorridorGame getQuorridorGame()
  {
    return quorridorGame;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfWalls()
  {
    return 0;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfWalls()
  {
    return 20;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPawns()
  {
    return 0;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfPawns()
  {
    return 2;
  }
  /* Code from template association_AddUnidirectionalOptionalN */
  public boolean addPawn(Pawn aPawn)
  {
    boolean wasAdded = false;
    if (pawns.contains(aPawn)) { return false; }
    if (numberOfPawns() < maximumNumberOfPawns())
    {
      pawns.add(aPawn);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean removePawn(Pawn aPawn)
  {
    boolean wasRemoved = false;
    if (pawns.contains(aPawn))
    {
      pawns.remove(aPawn);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_SetUnidirectionalOptionalN */
  public boolean setPawns(Pawn... newPawns)
  {
    boolean wasSet = false;
    ArrayList<Pawn> verifiedPawns = new ArrayList<Pawn>();
    for (Pawn aPawn : newPawns)
    {
      if (verifiedPawns.contains(aPawn))
      {
        continue;
      }
      verifiedPawns.add(aPawn);
    }

    if (verifiedPawns.size() != newPawns.length || verifiedPawns.size() > maximumNumberOfPawns())
    {
      return wasSet;
    }

    pawns.clear();
    pawns.addAll(verifiedPawns);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPawnAt(Pawn aPawn, int index)
  {  
    boolean wasAdded = false;
    if(addPawn(aPawn))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPawns()) { index = numberOfPawns() - 1; }
      pawns.remove(aPawn);
      pawns.add(index, aPawn);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePawnAt(Pawn aPawn, int index)
  {
    boolean wasAdded = false;
    if(pawns.contains(aPawn))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPawns()) { index = numberOfPawns() - 1; }
      pawns.remove(aPawn);
      pawns.add(index, aPawn);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPawnAt(aPawn, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    walls.clear();
    pawns.clear();
    QuorridorGame existingQuorridorGame = quorridorGame;
    quorridorGame = null;
    if (existingQuorridorGame != null)
    {
      existingQuorridorGame.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "startDate" + "=" + (getStartDate() != null ? !getStartDate().equals(this)  ? getStartDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "startTime" + "=" + (getStartTime() != null ? !getStartTime().equals(this)  ? getStartTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "quorridorGame = "+(getQuorridorGame()!=null?Integer.toHexString(System.identityHashCode(getQuorridorGame())):"null");
  }
}
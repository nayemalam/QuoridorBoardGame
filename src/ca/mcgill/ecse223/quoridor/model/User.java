/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.quoridor.model;
import java.util.*;

// line 9 "../../../../../model.ump"
// line 70 "../../../../../model.ump"
public class User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //User Attributes
  private String userName;

  //User Associations
  private Pawn pawn;
  private List<Wall> wallStock;
  private Move currentMove;
  private List<Wall> placedWalls;
  private QuorridorSystem quorridorSystem;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User(String aUserName, QuorridorSystem aQuorridorSystem)
  {
    userName = aUserName;
    wallStock = new ArrayList<Wall>();
    placedWalls = new ArrayList<Wall>();
    boolean didAddQuorridorSystem = setQuorridorSystem(aQuorridorSystem);
    if (!didAddQuorridorSystem)
    {
      throw new RuntimeException("Unable to create user due to quorridorSystem");
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
  public Wall getWallStock(int index)
  {
    Wall aWallStock = wallStock.get(index);
    return aWallStock;
  }

  public List<Wall> getWallStock()
  {
    List<Wall> newWallStock = Collections.unmodifiableList(wallStock);
    return newWallStock;
  }

  public int numberOfWallStock()
  {
    int number = wallStock.size();
    return number;
  }

  public boolean hasWallStock()
  {
    boolean has = wallStock.size() > 0;
    return has;
  }

  public int indexOfWallStock(Wall aWallStock)
  {
    int index = wallStock.indexOf(aWallStock);
    return index;
  }
  /* Code from template association_GetOne */
  public Move getCurrentMove()
  {
    return currentMove;
  }

  public boolean hasCurrentMove()
  {
    boolean has = currentMove != null;
    return has;
  }
  /* Code from template association_GetMany */
  public Wall getPlacedWall(int index)
  {
    Wall aPlacedWall = placedWalls.get(index);
    return aPlacedWall;
  }

  public List<Wall> getPlacedWalls()
  {
    List<Wall> newPlacedWalls = Collections.unmodifiableList(placedWalls);
    return newPlacedWalls;
  }

  public int numberOfPlacedWalls()
  {
    int number = placedWalls.size();
    return number;
  }

  public boolean hasPlacedWalls()
  {
    boolean has = placedWalls.size() > 0;
    return has;
  }

  public int indexOfPlacedWall(Wall aPlacedWall)
  {
    int index = placedWalls.indexOf(aPlacedWall);
    return index;
  }
  /* Code from template association_GetOne */
  public QuorridorSystem getQuorridorSystem()
  {
    return quorridorSystem;
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
  public static int minimumNumberOfWallStock()
  {
    return 0;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfWallStock()
  {
    return 10;
  }
  /* Code from template association_AddUnidirectionalOptionalN */
  public boolean addWallStock(Wall aWallStock)
  {
    boolean wasAdded = false;
    if (wallStock.contains(aWallStock)) { return false; }
    if (numberOfWallStock() < maximumNumberOfWallStock())
    {
      wallStock.add(aWallStock);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean removeWallStock(Wall aWallStock)
  {
    boolean wasRemoved = false;
    if (wallStock.contains(aWallStock))
    {
      wallStock.remove(aWallStock);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_SetUnidirectionalOptionalN */
  public boolean setWallStock(Wall... newWallStock)
  {
    boolean wasSet = false;
    ArrayList<Wall> verifiedWallStock = new ArrayList<Wall>();
    for (Wall aWallStock : newWallStock)
    {
      if (verifiedWallStock.contains(aWallStock))
      {
        continue;
      }
      verifiedWallStock.add(aWallStock);
    }

    if (verifiedWallStock.size() != newWallStock.length || verifiedWallStock.size() > maximumNumberOfWallStock())
    {
      return wasSet;
    }

    wallStock.clear();
    wallStock.addAll(verifiedWallStock);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addWallStockAt(Wall aWallStock, int index)
  {  
    boolean wasAdded = false;
    if(addWallStock(aWallStock))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWallStock()) { index = numberOfWallStock() - 1; }
      wallStock.remove(aWallStock);
      wallStock.add(index, aWallStock);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveWallStockAt(Wall aWallStock, int index)
  {
    boolean wasAdded = false;
    if(wallStock.contains(aWallStock))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWallStock()) { index = numberOfWallStock() - 1; }
      wallStock.remove(aWallStock);
      wallStock.add(index, aWallStock);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addWallStockAt(aWallStock, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOptionalOneToOne */
  public boolean setCurrentMove(Move aNewCurrentMove)
  {
    boolean wasSet = false;
    if (currentMove != null && !currentMove.equals(aNewCurrentMove) && equals(currentMove.getUser()))
    {
      //Unable to setCurrentMove, as existing currentMove would become an orphan
      return wasSet;
    }

    currentMove = aNewCurrentMove;
    User anOldUser = aNewCurrentMove != null ? aNewCurrentMove.getUser() : null;

    if (!this.equals(anOldUser))
    {
      if (anOldUser != null)
      {
        anOldUser.currentMove = null;
      }
      if (currentMove != null)
      {
        currentMove.setUser(this);
      }
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPlacedWalls()
  {
    return 0;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfPlacedWalls()
  {
    return 10;
  }
  /* Code from template association_AddUnidirectionalOptionalN */
  public boolean addPlacedWall(Wall aPlacedWall)
  {
    boolean wasAdded = false;
    if (placedWalls.contains(aPlacedWall)) { return false; }
    if (numberOfPlacedWalls() < maximumNumberOfPlacedWalls())
    {
      placedWalls.add(aPlacedWall);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean removePlacedWall(Wall aPlacedWall)
  {
    boolean wasRemoved = false;
    if (placedWalls.contains(aPlacedWall))
    {
      placedWalls.remove(aPlacedWall);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_SetUnidirectionalOptionalN */
  public boolean setPlacedWalls(Wall... newPlacedWalls)
  {
    boolean wasSet = false;
    ArrayList<Wall> verifiedPlacedWalls = new ArrayList<Wall>();
    for (Wall aPlacedWall : newPlacedWalls)
    {
      if (verifiedPlacedWalls.contains(aPlacedWall))
      {
        continue;
      }
      verifiedPlacedWalls.add(aPlacedWall);
    }

    if (verifiedPlacedWalls.size() != newPlacedWalls.length || verifiedPlacedWalls.size() > maximumNumberOfPlacedWalls())
    {
      return wasSet;
    }

    placedWalls.clear();
    placedWalls.addAll(verifiedPlacedWalls);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPlacedWallAt(Wall aPlacedWall, int index)
  {  
    boolean wasAdded = false;
    if(addPlacedWall(aPlacedWall))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPlacedWalls()) { index = numberOfPlacedWalls() - 1; }
      placedWalls.remove(aPlacedWall);
      placedWalls.add(index, aPlacedWall);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePlacedWallAt(Wall aPlacedWall, int index)
  {
    boolean wasAdded = false;
    if(placedWalls.contains(aPlacedWall))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPlacedWalls()) { index = numberOfPlacedWalls() - 1; }
      placedWalls.remove(aPlacedWall);
      placedWalls.add(index, aPlacedWall);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPlacedWallAt(aPlacedWall, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToAtMostN */
  public boolean setQuorridorSystem(QuorridorSystem aQuorridorSystem)
  {
    boolean wasSet = false;
    //Must provide quorridorSystem to user
    if (aQuorridorSystem == null)
    {
      return wasSet;
    }

    //quorridorSystem already at maximum (2)
    if (aQuorridorSystem.numberOfUsers() >= QuorridorSystem.maximumNumberOfUsers())
    {
      return wasSet;
    }
    
    QuorridorSystem existingQuorridorSystem = quorridorSystem;
    quorridorSystem = aQuorridorSystem;
    if (existingQuorridorSystem != null && !existingQuorridorSystem.equals(aQuorridorSystem))
    {
      boolean didRemove = existingQuorridorSystem.removeUser(this);
      if (!didRemove)
      {
        quorridorSystem = existingQuorridorSystem;
        return wasSet;
      }
    }
    quorridorSystem.addUser(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    pawn = null;
    wallStock.clear();
    Move existingCurrentMove = currentMove;
    currentMove = null;
    if (existingCurrentMove != null)
    {
      existingCurrentMove.delete();
      existingCurrentMove.setUser(null);
    }
    placedWalls.clear();
    QuorridorSystem placeholderQuorridorSystem = quorridorSystem;
    this.quorridorSystem = null;
    if(placeholderQuorridorSystem != null)
    {
      placeholderQuorridorSystem.removeUser(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "userName" + ":" + getUserName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "pawn = "+(getPawn()!=null?Integer.toHexString(System.identityHashCode(getPawn())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "currentMove = "+(getCurrentMove()!=null?Integer.toHexString(System.identityHashCode(getCurrentMove())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "quorridorSystem = "+(getQuorridorSystem()!=null?Integer.toHexString(System.identityHashCode(getQuorridorSystem())):"null");
  }
}
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.quoridor.model;

// line 24 "../../../../../model.ump"
// line 113 "../../../../../model.ump"
public abstract class Token
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Token Associations
  private Position gamePosition;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Token()
  {}

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public Position getGamePosition()
  {
    return gamePosition;
  }

  public boolean hasGamePosition()
  {
    boolean has = gamePosition != null;
    return has;
  }
  /* Code from template association_SetUnidirectionalOptionalOne */
  public boolean setGamePosition(Position aNewGamePosition)
  {
    boolean wasSet = false;
    gamePosition = aNewGamePosition;
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    gamePosition = null;
  }

  public abstract String GetPositionAsString();

}
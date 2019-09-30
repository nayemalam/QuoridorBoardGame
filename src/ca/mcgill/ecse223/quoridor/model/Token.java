/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.quoridor.model;

// line 27 "../../../../../model.ump"
// line 105 "../../../../../model.ump"
public abstract class Token
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Token Associations
  private Tile tile;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Token()
  {}

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public Tile getTile()
  {
    return tile;
  }

  public boolean hasTile()
  {
    boolean has = tile != null;
    return has;
  }
  /* Code from template association_SetUnidirectionalOptionalOne */
  public boolean setTile(Tile aNewTile)
  {
    boolean wasSet = false;
    tile = aNewTile;
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    tile = null;
  }

}
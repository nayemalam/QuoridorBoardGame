/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.quoridor.model;

// line 50 "../../../../../model.ump"
// line 101 "../../../../../model.ump"
public class Position
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Position Attributes
  private int row;
  private Character column;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Position(int aRow, Character aColumn)
  {
    row = aRow;
    column = aColumn;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRow(int aRow)
  {
    boolean wasSet = false;
    row = aRow;
    wasSet = true;
    return wasSet;
  }

  public boolean setColumn(Character aColumn)
  {
    boolean wasSet = false;
    column = aColumn;
    wasSet = true;
    return wasSet;
  }

  public int getRow()
  {
    return row;
  }

  public Character getColumn()
  {
    return column;
  }

  public void delete()
  {}

  // line 54 "../../../../../model.ump"
  public boolean ColumnIsValid(char column){
    return true;
  }

  // line 55 "../../../../../model.ump"
  public boolean RowIsValid(int row){
    return true;
  }


  public String toString()
  {
    return super.toString() + "["+
            "row" + ":" + getRow()+ "," +
            "column" + ":" + getColumn()+ "]";
  }
}
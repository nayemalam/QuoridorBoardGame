/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.quoridor.model;

// line 27 "../../../../../model.ump"
// line 33 "../../../../../model.ump"
// line 94 "../../../../../model.ump"
public class Pawn extends Token
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum Color { Black, White }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Pawn Attributes
  private Color color;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Pawn(Color aColor)
  {
    super();
    color = aColor;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setColor(Color aColor)
  {
    boolean wasSet = false;
    color = aColor;
    wasSet = true;
    return wasSet;
  }

  public Color getColor()
  {
    return color;
  }

  public void delete()
  {
    super.delete();
  }

  // line 36 "../../../../../model.ump"
   public String GetPositionAsString(){
    return "";
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "color" + "=" + (getColor() != null ? !getColor().equals(this)  ? getColor().toString().replaceAll("  ","    ") : "this" : "null");
  }
}
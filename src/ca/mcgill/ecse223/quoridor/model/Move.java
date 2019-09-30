/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.quoridor.model;

// line 46 "../../../../../model.ump"
public abstract class Move
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Move Associations
  private Move prev;
  private Move next;
  private Token token;
  private User user;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Move(User aUser)
  {
    boolean didAddUser = setUser(aUser);
    if (!didAddUser)
    {
      throw new RuntimeException("Unable to create currentMove due to user");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public Move getPrev()
  {
    return prev;
  }

  public boolean hasPrev()
  {
    boolean has = prev != null;
    return has;
  }
  /* Code from template association_GetOne */
  public Move getNext()
  {
    return next;
  }

  public boolean hasNext()
  {
    boolean has = next != null;
    return has;
  }
  /* Code from template association_GetOne */
  public Token getToken()
  {
    return token;
  }

  public boolean hasToken()
  {
    boolean has = token != null;
    return has;
  }
  /* Code from template association_GetOne */
  public User getUser()
  {
    return user;
  }
  /* Code from template association_SetUnidirectionalOptionalOne */
  public boolean setPrev(Move aNewPrev)
  {
    boolean wasSet = false;
    prev = aNewPrev;
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetUnidirectionalOptionalOne */
  public boolean setNext(Move aNewNext)
  {
    boolean wasSet = false;
    next = aNewNext;
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetUnidirectionalOptionalOne */
  public boolean setToken(Token aNewToken)
  {
    boolean wasSet = false;
    token = aNewToken;
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToOptionalOne */
  public boolean setUser(User aNewUser)
  {
    boolean wasSet = false;
    if (aNewUser == null)
    {
      //Unable to setUser to null, as currentMove must always be associated to a user
      return wasSet;
    }
    
    Move existingCurrentMove = aNewUser.getCurrentMove();
    if (existingCurrentMove != null && !equals(existingCurrentMove))
    {
      //Unable to setUser, the current user already has a currentMove, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    User anOldUser = user;
    user = aNewUser;
    user.setCurrentMove(this);

    if (anOldUser != null)
    {
      anOldUser.setCurrentMove(null);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    prev = null;
    next = null;
    token = null;
    User existingUser = user;
    user = null;
    if (existingUser != null)
    {
      existingUser.setCurrentMove(null);
    }
  }

}
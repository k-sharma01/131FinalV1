/**
 * This class represents a playable character in my text-based game
 * @author Kirin Sharma
 * @version 1.0
 * CS 131 Final Project
 *
 */

public class PlayableCharacter {
	
	private int column; // holds the x-coordinate of the character
	private int row; // holds the y-coordinate of the character
	private String charName; // holds the name of the character
	private boolean hasDragonKey = false; // whether character has found the Dragon Key
	private boolean hasQuestionKey = false; // whether character has found the Question Key
	private boolean hasFlute = false; // whether character has found a flute
	private boolean hasSword = false; // whether character has found a sword
	
	/**
	 * Constructs a character with a specific name and default x and y coordinates
	 * @param name
	 */
	public PlayableCharacter(String name)
	{
		column = 1;
		row = 1;
		charName = name;
	} // end preferred constructor
	
	/**
	 * Getter for column
	 * @return
	 */
	public int getColumn()
	{
		return column;
	} // end getColumn
	
	/**
	 * Getter for row
	 * @return
	 */
	public int getRow()
	{
		return row;
	} // end getRow
	
	/**
	 * Getter for CharName
	 * @return
	 */
	public String getCharName()
	{
		return charName;
	} // end getCharName
	
	/**
	 * Moves the character up one space
	 * @return whether movement was successful
	 */
	public boolean moveNorth()
	{
		if (row > 0)
		{
			row -= 1;
			return true;
		}
		return false;
	} // end moveNorth
	
	/**
	 * Moves the character down one space
	 * @return whether movement was successful
	 */
	public boolean moveSouth()
	{
		if (row < 2)
		{
			row += 1;
			return true;
		}
		return false;
	} // end moveSouth
	
	/**
	 * Moves the character right one space
	 * @return whether movement was successful
	 */
	public boolean moveEast()
	{
		if (column < 2)
		{
			column += 1;
			return true;
		}
		return false;
	} // end moveEast
	
	/**
	 * Moves the character left one space
	 * @return whether movement was successful
	 */
	public boolean moveWest()
	{
		if (column > 0)
		{
			column -= 1;
			return true;
		}
		return false;
	} // end moveWest
	
	/**
	 * Getter for hasDragonKey
	 * @return the hasDragonKey
	 */
	public boolean hasDragonKey() 
	{
		return hasDragonKey;
	} // end hasDragonKey

	/**
	 * Getter for hasQuestionKey
	 * @return the hasQuestionKey
	 */
	public boolean hasQuestionKey() 
	{
		return hasQuestionKey;
	} // end hasQuestionKey

	/**
	 * Getter for hasFlute
	 * @return the hasFlute
	 */
	public boolean hasFlute() 
	{
		return hasFlute;
	} // end hasFlute

	/**
	 * Getter for hasSword
	 * @return the hasSword
	 */
	public boolean hasSword() 
	{
		return hasSword;
	} // end hasSword

	/**
	 * Setter for hasDragonKey
	 * @param hasDragonKey the hasDragonKey to set
	 */
	public void setHasDragonKey(boolean hasDragonKey) 
	{
		this.hasDragonKey = hasDragonKey;
	} // end setHasDragonKey

	/**
	 * Setter for hasQuestionKey
	 * @param hasQuestionKey the hasQuestionKey to set
	 */
	public void setHasQuestionKey(boolean hasQuestionKey) 
	{
		this.hasQuestionKey = hasQuestionKey;
	} // end setHasQuestionKey

	/**
	 * Setter for hasFlute
	 * @param hasFlute the hasFlute to set
	 */
	public void setHasFlute(boolean hasFlute) 
	{
		this.hasFlute = hasFlute;
	} // end setHasFlute

	/**
	 * Setter for hasSword
	 * @param hasSword the hasSword to set
	 */
	public void setHasSword(boolean hasSword) 
	{
		this.hasSword = hasSword;
	} // end setHasSword
	
} // end class

/**
 * This class represents a room in my text-based game
 * @author Kirin Sharma
 * @version 1.0
 * CS 131 Final Project
 *
 */

public class Room {
	
	private String name; // holds the name of the room
	private boolean hasVisited = false; // holds whether the room has been visited yet
	
	/**
	 * Preferred constructor allows caller to pass in values for instance variables
	 * @param roomName
	 */
	public Room(String roomName)
	{
		name = roomName;
	} // end preferred constructor

	/**
	 * Getter for name
	 * @return
	 */
	public String getName()
	{
		return name;
	} // end getName
	
	/**
	 * Getter for hasVisited
	 * @return
	 */
	public boolean hasVisited()
	{
		return hasVisited;
	} // end hasVisited
	
	/**
	 * Setter for hasVisited
	 * @param b
	 */
	public void setHasVisited(boolean b)
	{
		hasVisited = b;
	} // end setHasVisited
	
} // end class

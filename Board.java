/**
 * This class represents the board in my text-based game
 * @author Kirin Sharma
 * @version 1.0
 * CS 131 Final Project
 *
 */

public class Board {

	private Room[][] board = new Room[3][3];
	
	/**
	 * This constructs a game board with 4 rooms, one in each corner of a 3x3 grid
	 */
	public Board()
	{
		board[0][0] = new Room("Castle"); // top left corner
		board[0][2] = new Room("Chest"); // top right corner
		board[2][0] = new Room("Dragon Cave"); // bottom left corner
		board[2][2] = new Room("Shack"); // bottom right corner
	} // end default constructor
	
	/**
	 * This method returns the name of a room based on coordinates of character (to be passed in)
	 * @param row
	 * @param col
	 * @return
	 */
	public Room getRoom(int row, int col)
	{
		if (board[row][col] != null)
		{
			return board[row][col];
		}
		else
		{
			return null;
		}
	} // end getRoomName
	
} // end class

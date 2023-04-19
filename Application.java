/**
 * This class is the application for the text-based game
 * @author Kirin Sharma
 * @version 1.0
 * CS 131 Final Project
 *
 */

import java.util.Scanner;


public class Application {

	static Scanner scan = new Scanner(System.in);
	public static void main(String args[])
	{
		System.out.print("\nWelcome to the realm of Fritjof!"
				+ "\nFritjof has kidnapped your princess, and your task here is to"
				+ "\nlocate and free her by any means necessary."
				+ "\nBut before we begin on this quest, what should we call you? ");
		
		String name;
		while (true)
		{
			try 
			{
				name = scan.nextLine().strip();
				if (name.length() >= 1)
					break;

			}
			catch (Exception e)
			
		}
		Game myGame = new Game(name);
		
		System.out.println("\nHello, " + myGame.playerName + "!");
		System.out.println("\nHere are some instructions to get you started: ");
		myGame.printTutorial();
		System.out.println("Let's get to work!");
		
		
		while (!myGame.hasFinishedGame())
		{
			// Check if the movement was successful and determine gameplay based on that
			boolean hasMoved = myGame.travel(scan);
			if (myGame.checkIfInRoom() && hasMoved)
			{
				String currentRoomName = myGame.getRoomName();
				
				if (currentRoomName.equals("Castle"))
				{
					// do stuff for castle
					myGame.castleGameplay();
				}
				else if (currentRoomName.equals("Chest"))
				{
					// do chest stuff
					myGame.chestGameplay(scan);
					
				}
				else if (currentRoomName.equals("Dragon Cave"))
				{
					// do dragon stuff
					myGame.caveGameplay(scan);
				}
				else if (currentRoomName.equals("Shack"))
				{
					// do shack stuff
					myGame.shackGameplay(scan);
				}	
			}
			else if (!hasMoved)
			{
				System.out.println("\nOops, you can't go that way.");
			}
			else
			{
				System.out.println("\nYou don't see anything here. Keep moving!");
			}
		} // end while
		
		System.out.println("\nCongratulations, " + myGame.playerName + "!");
		System.out.println("\nYou have saved the princess!"
				+ "\nYour name will now be known across the lands for your heroism!");
		
	} // end main()
	
} // end class

import java.util.Scanner;

/**
 * This class represents the game in the text-based game
 * @author Kirin Sharma
 * @version 1.0
 * CS 131 Final Project
 *
 */

public class Game {

	private Board myBoard = new Board();
	private PlayableCharacter me;
	private boolean finishedGame = false;
	protected String playerName;
	
	/**
	 * Constructor for a game initializes player to a specific name
	 * @param characterName
	 */
	public Game(String characterName)
	{
		me = new PlayableCharacter(characterName);
		playerName = characterName;
	} // end constructor
	
	
	/**
	 * This function represents gameplay for the chest room
	 */
	public void chestGameplay(Scanner scan)
	{
		
		// gameplay if this is first time visiting room
		if (!myBoard.getRoom(0, 2).hasVisited())
		{
			System.out.println("\nOut of the corner of your eye you see something glinting in the sun."
					+ "\nAfter walking closer, you see that it is a chest with a strange glow"
					+ " emanating from it."
					+ "\nAfter some time, you are able to pry it open, and see two objects inside:"
					+ "\nOne sword, and one flute.");
			
			System.out.print("\nWhat would you like to do? ");
			String userInput = scan.nextLine().strip();
			// Get user input until it is valid
			while(!userInput.equalsIgnoreCase("take flute") && !userInput.equalsIgnoreCase("take sword"))
			{
				if (userInput.equalsIgnoreCase("t"))
				{
					printTutorial();
					System.out.print("\nWhat would you like to do? ");
					userInput = scan.nextLine().strip();
				}
				else
				{
					System.out.print("\nSorry, I didn't understand that command. Try again? ");
					userInput = scan.nextLine().strip();
				}
			}
			
			// Allow user to take what they chose, either the flute or sword
			if (userInput.equalsIgnoreCase("take flute"))
			{
				System.out.println("\nWise choice! Perhaps this flute will be of use in the future!");
				me.setHasFlute(true);
				myBoard.getRoom(0, 2).setHasVisited(true);
			}
			else
			{
				System.out.println("\nWise choice! Perhaps this sword will be of use in the future!");
				me.setHasSword(true);
				myBoard.getRoom(0, 2).setHasVisited(true);
			}
			
		}
		else // gameplay if you have visited previously
		{
			System.out.println("\nYou found the same chest as before! "
					+ "\nAfter taking a quick peek inside, you find that unfortunately "
					+ "there is nothing new inside. "
					+ "\nCarry on brave knight!");
		} 
		
	} // end chestGameplay
	

		/**
		 * This function represents the gameplay for the shack room
		 */
		public void shackGameplay(Scanner scan)
		{
			
			// Code if this is the first time user has visited shack
			if (!myBoard.getRoom(2, 2).hasVisited())
			{
				// Dialogue for introduction and riddle
				System.out.print("\nYou stumble upon a shack in the middle of the woods, "
						+ "and cautiously approach. \nThe door creaks open as you peek inside, "
						+ "and you are greeted suddenly by a mischievous imp. "
						+ "\n\"Welcome to my humble abode, wanderer,\" said the imp. "
						+ "\n\"What can I do for you today?\""
						+ "\n\nYou reply that you are looking for a key, and the imp's eyes light up."
						+ "\nThe imp said back,"
						+ "\"I may know something about this, but if you want me to tell you "
						+ "first you must solve my riddle.\""
						+ "\nAfter a brief groan, you agree."
						+ "\n\nMy riddle is: \'I have cities, but no houses."
						+ " I have mountains, but no trees. \nI have water, but no fish. What am I?\' ");
				
				String userInput = scan.nextLine().strip();
				
				// Get user input until it is valid
				while(!userInput.equalsIgnoreCase("map") && !userInput.equalsIgnoreCase("a map"))
				{
					if (userInput.equalsIgnoreCase("t"))
					{
						printTutorial();
						System.out.print("\n\nWhat is the answer? ");
						userInput = scan.nextLine().strip();
					}
					else
					{
						System.out.print("\nNope, not quite. Try again? ");
						userInput = scan.nextLine().strip();
					}
				}
				
				// Dialogue after solving riddle
				System.out.println("\n\"Congratulations, you have solved my riddle\", said the imp."
						+ "\n\"I believe I promised you something in return.\""
						+ " The imp reaches into his pocket and pulls out"
						+ "\na question-mark shaped key."
						+ "\n\"Here is your reward, wanderer. I only wish we could have had more fun.\""
						+ "\nYou thank the imp, and carry on.");
				
				// make it so that the room has been visited and the player has the key
				me.setHasQuestionKey(true);
				myBoard.getRoom(2, 2).setHasVisited(true);
			}
			
			else // Code if the shack has been visited already
			{
				System.out.println("\n\"Back already?\", asked the imp. "
						+ "\n\"Sorry, but I have nothing else for you."
						+ " Best of luck on your quest.\"");
			}
			
		} // end shackGameplay
	
	/**
	 * This method represents gameplay for the castle room
	 * @param scan
	 */
	public void castleGameplay()
	{
		// gameplay if room has not yet been visited
		if (!myBoard.getRoom(0, 0).hasVisited())
		{
			System.out.println("\nYou stumble across a massive castle in a clearing, and promptly go inside."
					+ "\nYou hear a faint call from the other side of the castle, and sprint over"
					+ "\nto find your princess behind a locked door."
					+ "\n\'You must help me\', she exclaimed. She explained that Fritjof had captured"
					+ "\nher and turned it into a sick game, hiding keys across the lands. One"
					+ "\nis in the shape of a question mark and the other in the shape of a dragon's head."
					+ "\nShe begs you to go find the keys, then asks if you by chance have found them"
					+ "\nalready.");
			myBoard.getRoom(0, 0).setHasVisited(true);
		}
		else
		{
			System.out.println("\n\'Back already?\', asked the princess. You see"
					+ "\na glimmer of hope in her eyes."
					+ "\n\'Do you have the keys?\'");
		}
		
		// Check if player has both keys to free the princess and complete the game
		if (me.hasDragonKey() && me.hasQuestionKey())
		{
			System.out.println("\nYou proudly respond yes."
					+ "\nNow that you have found both of the keys, it is time to put them"
					+ "\nto use. You reach into your satchel and show her the keys."
					+ "\n\'Thank Goodness!\', exclaimed the queen. She knew that she would now be saved."
					+ "\nYou quickly insert both keys and turn them at the same time, and the door screeches open.");
			finishedGame = true;
		}
		else
		{
			System.out.println("\nYou respond that you don't have them yet, but wanted to come "
					+ "\nby and make sure that she was okay."
					+ "\nThe princess expresses her gratitude, and urges you to continue"
					+ "\ntrying to find the keys to free her.");
		}
		
	} // end castleGameplay
	
	/**
	 * This method represents gameplay for the cave Room
	 * @param scan
	 */
	public void caveGameplay(Scanner scan)
	{
		if (!myBoard.getRoom(2, 0).hasVisited())
		{
			if (!me.hasFlute() && !me.hasSword())
			{
				System.out.println("\nYou stumble across a cave, and hear the rumblings of"
						+ "\na dragon inside. You decide to not enter and return once you have"
						+ "\nobtained some more useful gear.");
			}
			else
			{
				// use scanner to use an object to defeat the dragon.
				System.out.print("\nAfter stumbling across a cave, you hear the deep murmur"
						+ "\nof a dragon\'s breath. You cautiously approach, knowing that an"
						+ "\nexciting encounter awaits."
						+ "\nYou creep through the mouth of the cave, and the dragon catches your"
						+ "\nscent, whipping around to face you."
						+ "\nYou know that you must act fast. What will you do? ");
				
				String userInput = scan.nextLine().strip();
				// Get user input until it is valid
				while(true)
				{
					if (userInput.equalsIgnoreCase("t"))
					{
						printTutorial();
						System.out.print("\nWhat would you like to do? ");
						userInput = scan.nextLine().strip();
					}
					else if (userInput.equalsIgnoreCase("use flute") && me.hasFlute())
					{
						System.out.println("\nYou pull the flute you grabbed earlier out of your pack,"
								+ "\nand begin to play a soft tune as the dragon cocks its head in curiosity."
								+ "\nAs you continue playing, you see the dragon\'s eyes getting heavier,"
								+ "\nand after just a few minutes it nods off into a deep sleep."
								+ "You see a glimmer in its mouth,"
								+ "\nand creeping closer you see a key poking out."
								+ "\nYou grab it, and continue on your way.");
						break;
					}
					else if (userInput.equalsIgnoreCase("use sword") && me.hasSword())
					{
						System.out.println("\nYou pull the sword that you grabbed earlier out of its sheath"
								+ "\njust as the dragon begins to rush at you. You quickly get out of its way,"
								+ "\nand as the dragon skids past, you cock back the sword and aim for its eyes."
								+ "\nYou nail the dragon, impaling it through its eye, and it falls dead."
								+ "\nYou see a glimmer in its mouth, and creeping closer you see a key poking out."
								+ "\nYou grab it, and continue on your way.");
						break;
					}
					else
					{
						System.out.print("\nSorry, you can't do that. Try again? ");
						userInput = scan.nextLine().strip();
					}
				}
				
				
				
				myBoard.getRoom(2, 0).setHasVisited(true);
				me.setHasDragonKey(true);
			}
		}
		else
		{
			System.out.println("\nYou found the same cave as before!"
					+ "\nIt doesn't seem like there is anything more to do here."
					+ "\nCarry on!");
		}
	} // end caveGameplay
	
	/**
	 * This method reads user input to determine which way to move them
	 * @return whether movement was successful
	 */
	public boolean travel(Scanner scan)
	{		
		System.out.print("\nWhich way would you like to go? ");
		String direction;
		while(true)
		{
			try 
			{
				direction = scan.nextLine();
				break;
			}
			catch (Exception e)
			{
				System.out.print("\nSorry, I didn't understand that command. Try again?  ");
			}
		}
		boolean isValidInput = direction.equalsIgnoreCase("n") || direction.equalsIgnoreCase("north")
							|| direction.equalsIgnoreCase("s") || direction.equalsIgnoreCase("south")
							|| direction.equalsIgnoreCase("e") || direction.equalsIgnoreCase("east")
							|| direction.equalsIgnoreCase("w") || direction.equalsIgnoreCase("west");
		// Gets valid user input
		while (!isValidInput)
		{
			if (direction.equalsIgnoreCase("t") || direction.equalsIgnoreCase("tutorial"))
			{
				printTutorial();
				System.out.print("\nWhich way would you like to go?  ");
				direction = scan.nextLine();
			}
			else if (direction.equalsIgnoreCase("L") || direction.equalsIgnoreCase("location"))
			{
				printCoords();
				System.out.print("\nWhich way would you like to go?  ");
				direction = scan.nextLine();
			}
			else
			{
				System.out.print("\nSorry, I didn't understand that command. Try again?  ");
				direction = scan.nextLine();
			}
			isValidInput = direction.equalsIgnoreCase("n") || direction.equalsIgnoreCase("north")
					|| direction.equalsIgnoreCase("s") || direction.equalsIgnoreCase("south")
					|| direction.equalsIgnoreCase("e") || direction.equalsIgnoreCase("east")
					|| direction.equalsIgnoreCase("w") || direction.equalsIgnoreCase("west");
		}
		
		// Moves character in specified direction
		if (direction.equalsIgnoreCase("n") || direction.equalsIgnoreCase("north"))
			if (me.moveNorth())
				return true;
			else return false;
		else if (direction.equalsIgnoreCase("e") || direction.equalsIgnoreCase("east"))
			if (me.moveEast())
				return true;
			else return false;
		else if (direction.equalsIgnoreCase("w") || direction.equalsIgnoreCase("west"))
			if (me.moveWest())
				return true;
			else return false;
		else
			if (me.moveSouth())
				return true;
			else return false;
	} // end travel
	
	/**
	 * This method prints the tutorial for the game to the screen
	 */
	public void printTutorial()
	{
		System.out.println("\nTo go north, simply type \'n\'. To go east, type \'e\', "
				+ "\ntype \'w\' for west and \'s\' for south. If you would like to try and "
				+ "\nuse an object that you have collected at any point, type \'use\' or "
				+ "\n\'take\' and then the name of the object you would like to use. For "
				+ "\nexample, \'use keys\', or \'use sword\', or \'take flute\'. To review "
				+ "\nthis tutorial at any point during the game, simply type \'t\'. "
				+ "\nBest of luck on your adventure, brave knight!");
	} // end printTutorial
	
	/**
	 * Getter for finishedGame
	 */
	public boolean hasFinishedGame()
	{
		return finishedGame;
	} // end hasFinishedGame
	
	public String getRoomName()
	{
		return myBoard.getRoom(me.getRow(), me.getColumn()).getName();
	}
	
	/**
	 * This method determines whether the character is in a room (one of corners in 3x3 board)
	 * @return
	 */
	public boolean checkIfInRoom()
	{
		if ((me.getColumn() == 0 && me.getRow() == 0) || (me.getColumn() == 2 && me.getRow() == 0))
			return true;
		else if((me.getColumn() == 0 && me.getRow() == 2) || (me.getColumn() == 2 && me.getRow() == 2))
			return true;
		else
			return false;
	} // end checkIfInRoom
	
	/**
	 * Prints the current coordinates of the character
	 */
	public void printCoords()
	{
		System.out.println("Location:  Row: " + me.getRow() +" Column: " + me.getColumn());
	} // end printCoords
	
} // end class

# Reflection

Add to this file to satisfy the "Reflection Updates" non-functional requirement
for this project. Please keep this document organized using Markdown. If you
click on this file in your team's GitHub repository website, then you will see
that the Markdown is transformed into nice looking HTML.

Here is a sample entry (delete this line; also: feel free to copy/paste/modify):

## TUES 2019-16-04 @ 11:55 PM EST

1. **DONE:** Downloaded the skeleton code.
    -SUMMARY: overall we created the internal part of the game through 2D arrays.
    - We created a file called App2048 for the 2048 game.
    - We added a constructor that set the game board size to 4x4.
    - We created the print method that allows us to test other methods before adding GUIs.
    - We made the addNewRandom method that finds a random empty space on the game board and
      replaces it with 2 every time it is called.
    - We made a keyUp method that should be called when the player clicks up, and this was
      was used for down, left, and right keys.
    - We called the print method in driver to test the other method.
2. **TODO:** Finish reading the project description.
    - We will attempt to complete the 2048 app by the next checkpoint or at least get the GUI part working.
    - We have the methods for the keys, but we need to make that connection with the actual key pressed action by user
    - Overall we need to convert our inner game displayed by the 2D array into a GUI application
3. **PROB:** We had trouble creating another class for the 2048 game and organizing our project as a whole.
    -  We also problems in understanding how to work on the same file at the same time.
        - We had to test the git pull and push methods numerous times to understand the efficiency
          of working on two files at the same time
    - Technical problems: there was confusion when sometimes there would be a double merge.
        - We fixed this by creating a boolean array that recorded if a current row had already been merged
          so that it couldn't be merged twice. 


 ## TUES 2019-23-04 @ 11:55 PM EST

 1. **DONE:** Downloaded the skeleton code.
    -SUMMARY: Overall we figure out the GUI part of 2048. The game is bascially done.
        - we also added a welcome page which includes button in order to switch scene for the games
	- created a scene that displays you have won
2. **TODO:** Finish the small bugs in game, and complete half of tetris
   	- Bugs rom 2048
	  - game over
	  - returning back to the 2048 scene after returning back to main menu. (making buttons continuous)
	- Tetris
	  - make shapes, background for board
	  - figure out lines of blocks
	  - have the shapes move, etc.
	  
3. **PROB:** We had trouble creating another class for the 2048 game and organizing our project as a whole.
    -  Had a lot of problems dealing with setting the actions of the buttons.
       - it was hard switching between the scenes
    - There was confusion on setting actions on the keyboard keys
    - there was a lot of confusion between the classes and its method.
      - problems with a class's scope and figuring out a way not to use static variables. 
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

    ## TUES 2019-30-04 @ 11:55 PM EST

 1. **DONE:** Downloaded the skeleton code.
    -SUMMARY: We decided to do Space Invaders instead of Tetris.
	- created a Sprite class to assign different attributes to each sprite based on if they are a enemy or player
    - created a Space Invaders Class
    - fixed 2048 so when you press menu button, the game restarts
2. **TODO:** Finish Space Invaders
   	- Space Invaders
	  - make player shoot bullets
      - make enemies shoot bullets
      - add lives to player in space Invaders
	- General
	  - fix bug that prevents players from return to either 2048 or Space Invaders after they hace gone to home page	  
3. **PROB:** We had difficulty getting the buttons to work for both 2048 and SpaceInvaders
    - We had trouble trying to make the Sprite object move, so we ended up just using an ImagView instead of aSprite object
    - We had trouble organizing our SpaceInvaders game because there were so many differet aspects of the game interacting
## TUES 2019-07-05 @ 11:55 PM EST
 1. **DONE:** Downloaded the skeleton code.
    -SUMMARY: The Space Invaders Game is completed
    - The player and enemies can shoot
    - The player can lose lives
    - The score updates unlike before
    - The enemies and player can move
    - There are levels that increase the speed of the enemies based on each level
2. **TODO:** This is the last submission.	  
3. **PROB:** It was difficult trying to fix the issue with the score not updating because we did not know where to add the score label to the VBox.
    - We had difficulty trying to find when to change the levels and how much we should change the speed of the enemies each time.
    - The ImageViews for the enemies and player would not be removed after a level change.x
    - There was an issue with the BorderPane when trying to complete the animation extra credit because the ImageView would not move
    
package cs1302.arcade;
import javafx.geometry.Pos;
import java.util.Random;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.BorderPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
/**
 *This class has methods for the 2048 game.
 */
public class App2048{
    Random rgn = new Random();// random number generator
    private int score = 0;
    private int[][] board;//board
    boolean gameWon=false; 
    //ImageView tile;
    ArrayList<ImageView> images = new ArrayList<>();

    /**
      *This is the constructor that sets the board to size 4X4
      */
    public App2048(){
        //this is initializing a board every time a new game is being created
        board=new int[4][4];
     }
    /**
     *This clears the board.
     */
    public void clearBoard(){
	board=new int[4][4];
    }
    public void makeFrame(TilePane t, BorderPane b){	 
	t.getChildren().clear();
        for(int i = 0;i<4; i++){
            for(int j = 0; j<4; j++){
		//setting it to blank tile initially when initalizing it
                ImageView tile; 
               
                if(board[i][j]==2){
                    tile = new ImageView("tile2.png");
                }
                else if(board[i][j]==4){
                    tile = new ImageView("tile4.png");
                }
                else if(board[i][j]==8){
		    
                    tile = new ImageView("tile8.png");
                }
                else if(board[i][j]==16){
                    tile = new ImageView("tile16.png");
                }
                else if(board[i][j]==32){
                    tile = new ImageView("tile32.png");
                }
                else if(board[i][j]==64){
                    tile = new ImageView("tile64.png");
                }
                else if(board[i][j]==128){
                    tile = new ImageView("tile128.png");
                }
                else if(board[i][j]==256){
                    tile = new ImageView("tile256.png");
                }
                else if(board[i][j]==512){
                    tile = new ImageView("tile512.png");
                }
                else if(board[i][j]==1024){
                    tile = new ImageView("tile1024.png");
                }
                else if(board[i][j]==2048){
                    tile = new ImageView("tile2048.png");
                    gameWon=true; //setting boolean to true
                }
                else{
                    tile = new ImageView("tile0.png");
                }
                
                //adding the tile late into the img Gallery
             
                t.getChildren().add(tile);
                    // add Platform.runLater when making threads
                t.setPrefRows(4);
                t.setHgap(2);
                t.setVgap(2);
                tile.setFitWidth(60);
                tile.setFitHeight(60);
                tile.setPreserveRatio(false);
                tile.setSmooth(true);    
                
            }
            
        }
	//only executes if it is given to be true
	if(gameWon){
	    //creating gameOver image
	    ImageView youWin= new ImageView("youwin.png");
	    youWin.setFitHeight(200);
	    youWin.setFitWidth(200);
	    b.setCenter(youWin);
	}
	//bascailly if board is full (true) && there are no more moves, it will return you lost 
	else if(boardIsFull()&&(!hasMoves())){
	    ImageView youLose= new ImageView("gameover.jpg");
	    youLose.setFitHeight(200);
	    youLose.setFitWidth(200);
	    b.setCenter(youLose);
	}
	//if you have not won or lost, then execute this
	else{
	    //added tilpane to borderpane
	    b.setCenter(t);
	    //Platform.runLater(() -> b.setCenter(t));
	}
    }
    /**
      *This method is used to print the 2D array that we create. It just shows the
      *internal part of the game
      */
    public void print(){
        for(int[] x: board){
             //setting the format for printing the board
            System.out.format("%6d%6d%6d%6d%n",x[0],x[1],x[2],x[3]);
        }
        System.out.println(); //adding empty line below for formating
    }

    /**
     *This method is used when beginning a new game. It places randomly the number 2 into
      *the board.
      */
    public void addNewRandom(){
     //creating a new ArrayList that holds all of the blank empty spaces
        ArrayList<Integer> blankSpacesX= new ArrayList<Integer>(); //creating to hold X
        ArrayList<Integer> blankSpacesY= new ArrayList<Integer>(); //creating to hold Y
        //going through the board and recording which areas are empty or not
        for(int row=0;row<4;row++){
         for(int col=0;col<4;col++){
             if(board[row][col]==0){
                 Integer integerX= new Integer(row); //converting int to Integer
                 Integer integerY=new Integer(col);
             blankSpacesX.add(integerX); //adding the  x coordinate of empty space into array
             blankSpacesY.add(integerY); //adding the y coordinate of empty space to array
             }
         }
       }
        int choice= rgn.nextInt(blankSpacesX.size()); //using blankSpacesX b/c same size as y
	//System.out.println(choice); //***********************************************************
        int changingX=blankSpacesX.get(choice); //getting the x coordinate of the random spot
        int changingY=blankSpacesY.get(choice); //getting the y coordinate of the random spot

	//the 90 percent probability portion
	Double probCalculator= Math.random();
	if(probCalculator<0.9)
	    {
		board[changingX][changingY]=2;
	    }
	else
	    {
		board[changingX][changingY]=4; 
	    }
        //board[changingX][changingY]=2; //setting that random location with a 2
    }
    
    /**
     *This method is used when the user pushes the up arrow keyboard. This pushes the boxes up. 
     */
    public void keyUp(){
	System.out.println("This is testing the push up method");
	boolean[] alreadyCombined= {false,false,false,false}; //creating a boolean method
	for(int col=0;col<4;col++){
	    for(int row=1;row<4;row++){
		//box goes up until it hits another non empty box/space
		if(board[row][col]!=0){
		    int value=board[row][col]; //storing what number was in the original place
		    int tempX=row-1; //this is the temperary X that gets shifted up
		    //we continue this while loop until there is a space that is not empty
		    while((tempX>=0)&&(board[tempX][col]==0)){
		    tempX--; //continue to go upwards until it hits a non empty place
		    }
		    //to check if the thing has reached the end wall boundaries, etc.
		    if(tempX==-1){
			board[0][col]=value; //this means it has reached the very top (row=0)
			board[row][col]=0; //setting the intial value into 0.
		    }
		    else if(board[tempX][col]!=value){
			//only changes original to 0 if the row and tempX are not 1 apart
			if((tempX+1)!=row){
			    board[tempX+1][col]=value;
			    board[row][col]=0; //setting original back to 0.
			}
		    }
		    else {
			if(alreadyCombined[tempX]==true){
			    board[tempX+1][col]=value;
			    board[row][col]=0;
			}
			else{
			    //this only executes if the values are the same/ match
			    //this also only executes if it already has not been pushed up before. 
			    board[tempX][col]*=2; //basically the value doubles
			    if(gameWon==false){
				score = score+ board[tempX][col];// ADDING TO SCORE WHEN TILES MERGE
			    }
			    alreadyCombined[tempX]=true;
			    board[row][col]=0; //setting the previous one back to 0.
			}
		    }
		}
	    }
	}
    addNewRandom();
    }

    /**
     *This is the method for the down key 
     */
    public void keyDown(){
          System.out.println("This is testing the push DOWN method");
          boolean[] alreadyCombined= {false,false,false,false}; //creating a boolean method
          for(int col=0;col<4;col++){
              for(int row=2;row>-1;row--){
                  //box goes up until it hits another non empty box/space
                  if(board[row][col]!=0){
                      int value=board[row][col]; //storing what number was in the original place
                      int tempX=row+1; //this is the temperary X that gets shifted up
                      //we continue this while loop until there is a space that is not empty
                      while((tempX<=3)&&(board[tempX][col]==0)){
                      tempX++; //continue to go upwards until it hits a non empty place
                      }
                      //to check if the thing has reached the end wall boundaries, etc.
                      if(tempX==4){
                          board[3][col]=value; //this means it has reached the very top (row=0)
                          board[row][col]=0; //setting the intial value into 0.
                      }
                      else if(board[tempX][col]!=value){
                          //only changes original to 0 if the row and tempX are not 1 apart
                          if((tempX-1)!=row){
                              board[tempX-1][col]=value;
                              board[row][col]=0; //setting original back to 0.
                          }
                      }
                      else {
                          if(alreadyCombined[tempX]==true){
                              board[tempX-1][col]=value;
                              board[row][col]=0;
                          }
                          else{
                              //this only executes if the values are the same/ match
                             //this also only executes if it already has not been pushed up before.
                             board[tempX][col]*=2; //basically the value doubles
                             if(gameWon==false){
				 score = score+ board[tempX][col];// ADDING TO SCORE WHEN TILES MERGE
			     }
                             alreadyCombined[tempX]=true;
                             board[row][col]=0; //setting the previous one back to 0.
                         }
                     }
                 }
              }
         }
          //adds a new 2 tile
          addNewRandom();
     }
    /**
     *This method is used when the user pressed the left keyboard
     */
    public void keyLeft(){
	System.out.println("This is testing the push left method");
	boolean[] alreadyCombined= {false,false,false,false}; //creating a boolean method
	for(int row=0;row<4;row++){
	    for(int col=1;col<4;col++){
		//box goes up until it hits another non empty box/space
		if(board[row][col]!=0){
		    int value=board[row][col]; //storing what number was in the original place
		    int tempY=col-1; //this is the temperary Y that gets shifted to the left
		    //we continue this while loop until there is a space that is not empty
		    while((tempY>=0)&&(board[row][tempY]==0)){
			tempY--; //continue to go upwards until it hits a non empty place
		    }
		    //to check if the thing has reached the end wall boundaries, etc.
		    if(tempY==-1){
			board[row][0]=value; //this means it has reached the very top (row=0)
			board[row][col]=0; //setting the intial value into 0.
		    }
		    else if(board[row][tempY]!=value){
			//only changes original to 0 if the row and tempX are not 1 apart
			if((tempY+1)!=col){
			    board[row][tempY+1]=value;
			    board[row][col]=0; //setting original back to 0.
			}
		    }
		    else {
			if(alreadyCombined[tempY]==true){
			    board[row][tempY+1]=value;
			    board[row][col]=0;
			}
			else{
			    //this only executes if the values are the same/ match
			    //this also only executes if it already has not been pushed up before.
			    board[row][tempY]*=2; //basically the value doubles
			    if(gameWon==false){
				score = score+ board[row][tempY];// ADDING TO SCORE WHEN TILES MERGE
			    }
			    alreadyCombined[tempY]=true;
			    board[row][col]=0; //setting the previous one back to 0.
			}
		    }
		}
	    }
	}
    //I just added this:adds a new 2 tile
    addNewRandom();
    }

    /**
     *This method is used when the user presses the right keyboard button
     */
    public void keyRight(){
         System.out.println("This is testing the push right method");
         boolean[] alreadyCombined= {false,false,false,false}; //creating a boolean method
         for(int row=0;row<4;row++){
             for(int col=2;col>-1;col--){
                 //box goes up until it hits another non empty box/space
                 if(board[row][col]!=0){
                     int value=board[row][col]; //storing what number was in the original place
                     int tempY=col+1; //this is the temperary Y that gets shifted to the left
                     //we continue this while loop until there is a space that is not empty
                     while((tempY<=3)&&(board[row][tempY]==0)){
                         tempY++; //continue to go upwards until it hits a non empty place
                     }
                     //to check if the thing has reached the end wall boundaries, etc.
                     if(tempY==4){
                         board[row][3]=value; //this means it has reached the very top (row=0)
                         board[row][col]=0; //setting the intial value into 0.
                     }
                     else if(board[row][tempY]!=value){
                         //only changes original to 0 if the row and tempX are not 1 apart
                         if((tempY-1)!=col){
                             board[row][tempY-1]=value;
                             board[row][col]=0; //setting original back to 0.
                         }
                     }
                     else {
                         if(alreadyCombined[tempY]==true){
                             board[row][tempY-1]=value;
                             board[row][col]=0;
                         }
                         else{
                             //this only executes if the values are the same/ match
                             //this also only executes if it already has not been pushed up before.
                             board[row][tempY]*=2; //basically the value doubles
                             if(gameWon==false){
				 score = score+ board[row][tempY];// ADDING TO SCORE WHEN TILE MERGE
			     }
			     alreadyCombined[tempY]=true;
                             board[row][col]=0; //setting the previous one back to 0.
                         }
                     }
                 }
             }
         }
         addNewRandom();
     }
    /**
     *This sets the score.
     *@param x x is the number the score must be set to.
     */
    public void setScore(int x){
	score=x;
    }
    /**
     *This adds the score label and score to a borderPane.
     *@param b b is a BorderPane that is being changed.
     */
    public void score(BorderPane b)
    {
        VBox topVBox= new VBox();
        Label title = new Label("Welcome to 2048!");
        Label rules = new Label("Use arrow keys to move tiles");
        String scoreString= "Score: " +score;
        Label score = new Label(scoreString);
	
        Label emptyLine= new Label(""); 
        topVBox.getChildren().addAll(title,rules,score,emptyLine);
        topVBox.setAlignment(Pos.BASELINE_CENTER); //centering the title labels
        b.setTop(topVBox);
    }

    /**
     * This method is used to see if the board is full.
     *@return true if it is full, else returns false
     */
    public boolean boardIsFull(){
	//using a nested for loop to go through each value of the array to see if 0.
	for(int row=0;row<4;row++){
	    for(int col=0;col<4;col++){
		if(board[row][col]==0){
		    return false;
		}
	    }
	}
	return true; //else it returns true
    }
    
    /**
     *This method is only used if the board is full. It checks to see if there can be any more moves.
     *@return true if the board still can have moves.
     */
    public boolean hasMoves(){
	for(int row=0;row<4;row++){
	    for(int col=0;col<4;col++){
		if(row==0){
		    if(col!=0){
			//checking if the position in first row is equal to column before
			if(board[row][col]==board[row][col-1]){
			    return true;
			}
		    }
		}
		else{
		    if(col!=0){
			//would do same if x wasn't a 0.
			if(board[row][col]==board[row][col-1]){
			    return true;
			}
		    }
		    if(board[row][col]==board[row-1][col]){
			return true;
		    }
		}
	    }
	}
	return false;
    }
}//App2048

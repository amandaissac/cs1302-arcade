package cs1302.arcade;
import java.util.Random;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

public class App2048{
    Random rgn = new Random();// random number generator
    
    private int[][] board;
    
    /**
      *This is the constructor that sets the board to size 4X4
      */
    public App2048(){
        //this is initializing a board every time a new game is being created
        board=new int[4][4];
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
        int changingX=blankSpacesX.get(choice); //getting the x coordinate of the random spot
        int changingY=blankSpacesY.get(choice); //getting the y coordinate of the random spot
       board[changingX][changingY]=2; //setting that random location with a 2
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
			    alreadyCombined[tempX]=true;
			    board[row][col]=0; //setting the previous one back to 0.
			}
		    }
		}
	    }
	}
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
                             alreadyCombined[tempX]=true;
                             board[row][col]=0; //setting the previous one back to 0.
                         }
                     }
                 }
              }
         }
     }
}

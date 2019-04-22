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
import javafx.scene.layout.TilePane;
import javafx.scene.layout.BorderPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class App2048{
    Random rgn = new Random();// random number generator
    
    private int[][] board;
    //ImageView tile;
    ArrayList<ImageView> images = new ArrayList<>();

    /**
      *This is the constructor that sets the board to size 4X4
      */
    public App2048(){
        //this is initializing a board every time a new game is being created
        board=new int[4][4];
     }
    public void makeFrame(TilePane t, BorderPane b){
        
        for(int i = 0;i<4; i++){
            for(int j = 0; j<4; j++){
                ImageView tempTile;
                
                if(board[i][j]==2){
                    tempTile = new ImageView("https://i.pinimg.com/564x/81/fe/0a/81fe0a9f0042616cb42405617a2661b4.jpg");
                }
                else if(board[i][j]==4){
                    tempTile = new ImageView("https://i.pinimg.com/564x/6b/93/0b/6b930bf4a15baeca5561b11f5b0940d7.jpg");
                }
                else if(board[i][j]==8){
                    tempTile = new ImageView("https://i.pinimg.com/564x/b0/b5/93/b0b593549debda8a1158452283d348c1.jpg");
                }
                else if(board[i][j]==16){
                    tempTile = new ImageView("https://i.pinimg.com/564x/4d/9e/8d/4d9e8d7d019aa107d2e267a8d4eb4771.jpg");
                }
                else if(board[i][j]==32){
                    tempTile = new ImageView("https://i.pinimg.com/564x/ec/a2/1f/eca21f53a4587ae3dfa77fe174358bf6.jpg");
                }
                else if(board[i][j]==64){
                    tempTile = new ImageView("https://i.pinimg.com/564x/a7/a5/94/a7a5947e894f1ca7d5f33fac12e0f7b6.jpg");
                }
                else if(board[i][j]==128){
                    tempTile = new ImageView("https://i.pinimg.com/564x/40/10/c0/4010c0659be6aef6d9782b858446cb0f.jpg");
                }
                else if(board[i][j]==256){
                    tempTile = new ImageView("https://i.pinimg.com/originals/4f/00/84/4f00842b8492488c51240ad935846a27.png");
                }
                else if(board[i][j]==512){
                    tempTile = new ImageView("https://i.pinimg.com/originals/25/4b/1c/254b1c5d02478eb6e92ab0590b5cab92.png");
                }
                else if(board[i][j]==1024){
                    tempTile = new ImageView("https://i.pinimg.com/564x/bd/22/19/bd2219feb2b5fe0636fc43c2f1409b8b.jpg");
                }
                else if(board[i][j]==2048){
                    tempTile = new ImageView("https://i.pinimg.com/564x/72/96/ba/7296bad25fc18dd24a103fddf6c2a1ed.jpg");
                }
                else{
                    tempTile = new ImageView("https://i.pinimg.com/564x/bd/26/33/bd26336b2208faa58912c37d63a7d556.jpg");
                }
                ImageView tile = tempTile ;
                
                //adding the tile late into the img Gallery
            Platform.runLater(()-> t.getChildren().add(tile));
            t.setPrefColumns(4);
            tile.setFitWidth(100);
            tile.setPreserveRatio(true);
            tile.setSmooth(true);    
                
            }
            
        }

        //added tilpane to borderpane
        Platform.runLater(() -> b.setCenter(t));

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
			    alreadyCombined[tempY]=true;
			    board[row][col]=0; //setting the previous one back to 0.
			}
		    }
		}
	    }
	}
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
                             alreadyCombined[tempY]=true;
                             board[row][col]=0; //setting the previous one back to 0.
                         }
                     }
                 }
             }
         }
     }
}

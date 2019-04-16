package cs1302.arcade;
import java.util.Random;
import java.util.ArrayList;
//hello my people
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
    Random rgn = new Random();           // random number generator
    
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
    
}

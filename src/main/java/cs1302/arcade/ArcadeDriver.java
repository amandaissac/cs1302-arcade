package cs1302.arcade;

import javafx.application.Application;

/** 
 * Driver for the {@code ArcadeApp} class.
 */
public class ArcadeDriver {

    /**
     * Main entry-point into the application.
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {
        try {
	     Application.launch(ArcadeApp.class, args);

        /*    
	    //NEED TO CHANGE THE DRIVER CLASS. THIS IS JUST TO TEST INTERNAL PART OF GAME!
	    App2048 g= new App2048(); //change back to game

	    //******************checking the key methods************************
	    for(int x=0;x<3;x++){
		g.addNewRandom();
	    }
	    //testing push up thing right now
	    for(int x=0;x<7;x++){
		g.addNewRandom();
		g.print();
		g.keyUp();
		g.print(); //to see if the changes were made
	    }
	    for(int i=0;i<7;i++){
		g.addNewRandom();
		g.print();
		g.keyDown();
		g.print();
	    }
	    //this is to test the keyLeft method
	    for(int i=0;i<7;i++){
		g.addNewRandom();
		g.print();
		g.keyLeft();
		g.print();
	    }
	    //this is to test the keyRight method
	    for(int i=0; i<7;i++){
		g.addNewRandom();
		g.print();
		g.keyRight();
		g.print();
	    }
	    //*************************************************
	    */
        } catch (UnsupportedOperationException e) {
            System.out.println(e);
            System.err.println("If this is a DISPLAY problem, then your X server connection");
            System.err.println("has likely timed out. This can generally be fixed by logging");
            System.err.println("out and logging back in.");
            System.exit(1);
        } // try
    } // main

} // ArcadeDriver

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
import javafx.scene.layout.BorderPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class ArcadeApp extends Application {

    //Group group = new Group();           // main container
    Random rgn = new Random();// random number generator
    BorderPane b;
    TilePane t= new TilePane();
    App2048 a = new App2048();;
    //Rectangle r = new Rectangle(20, 20); // some rectangle
    /*
    /**
     * Return a mouse event handler that moves to the rectangle to a random
     * position any time a mouse event is generated by the associated node.
     * @return the mouse event handler
     */
    /*
    private EventHandler<? super MouseEvent> createMouseHandler() {
	return event -> {
	    System.out.println(event);
	    r.setX(rng.nextDouble() * (640 - r.getWidth()));
	    r.setY(rng.nextDouble() * (480 - r.getHeight()));
	};
    } // createMouseHandler
    */

    /*
    /**
     * Return a key event handler that moves to the rectangle to the left
     * or the right depending on what key event is generated by the associated
     * node.
     * @return the key event handler
     */
    /*
    private EventHandler<? super KeyEvent> createKeyHandler() {
	return event -> {
	    System.out.println(event);
	    if (event.getCode() == KeyCode.LEFT)  r.setX(r.getX() - 10.0);
	    if (event.getCode() == KeyCode.RIGHT) r.setX(r.getX() + 10.0);
	    // TODO bounds checking
	};
    } // createKeyHandler
    */
    
    //THIS IS FOR THE ARCADEAPP
    private EventHandler<? super KeyEvent> createKeyHandler() {
        return event -> {
            System.out.println(event);
            if (event.getCode() == KeyCode.LEFT)
             {
                 
                 a.keyLeft();
                 a.score(b);
                 a.makeFrame(t,b);
             }
            else if (event.getCode() == KeyCode.RIGHT)
             {
                 
                 a.keyRight();
                 a.score(b);
                 a.makeFrame(t,b);
             }
            else if (event.getCode() == KeyCode.UP)
             {
                 
                 a.keyUp();
                 a.score(b);
                 a.makeFrame(t,b);
             }
            else if (event.getCode() == KeyCode.DOWN)
             {
                 
                 a.keyDown();
                 a.score(b);
                 a.makeFrame(t,b);
             }
            else
            {
                //will do nothing
            }
             // TODO bounds checking
        };
	} // createKeyHandler
    
    
    /** {@inheritdoc} */
    
    @Override
    public void start(Stage stage) {

        /* You are allowed to rewrite this start method, add other methods,
         * files, classes, etc., as needed. This currently contains some
         * simple sample code for mouse and keyboard interactions with a node
         * (rectangle) in a group.
         */
        //a = new App2048();
        b = new BorderPane();
        a.score(b);
        //adding the tilepane to window
        //a.addNewRandom();
        //a.makeFrame(t,b);
        
	        
	//r.setX(50);                                // 50px in the x direction (right)
        //r.setY(50);                                // 50ps in the y direction (down)
        //group.getChildren().add(r);                // add to main container
        //r.setOnMouseClicked(createMouseHandler()); // clicks on the rectangle move it randomly
        //group.setOnKeyPressed(createKeyHandler()); // left-right key presses move the rectangle

        Scene scene = new Scene(b/*group*/, 640, 480);
        scene.setOnKeyPressed(createKeyHandler());
        stage.setTitle("cs1302-arcade!");
        stage.setScene(scene);
        //stage.sizeToScene();
	stage.setWidth(250);
	stage.setHeight(300);
        stage.show();

        // the group must request input focus to receive key events
        // @see https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Node.html#requestFocus--
        //group.requestFocus();

    } // start
    
} // ArcadeApp

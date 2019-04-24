package cs1302.arcade;

import java.util.Random;
import java.util.ArrayList;
import javafx.geometry.Pos;
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
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class ArcadeApp extends Application {

    //Group group = new Group();           // main container
    Random rgn = new Random();// random number generator
    BorderPane b;//2048
    //Scene start;
    //Stage stage; 
    BorderPane b1;//Welcome
    //Scene scene;
    Button app2048;
    Button tetris;
    //Scene scene2048 = new Scene(b/*group*/, 640, 480);
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
    /*
    public void welcome(){
        Scene start;
        b1 = new BorderPane();
        HBox h = new HBox();
        
        app2048 = new Button("Play 2048");
        tetris = new Button("Play Tetris");
        h.getChildren().addAll(app2048,tetris);
        ImageView welcome = new ImageView("https://i-h2.pinimg.com/564x/13/78/3d/"+
                                          "13783d5dbc5927e449cd075c2c52dc60.jpg");
        b1.setCenter(welcome);
        b1.setBottom(h);
        
        start = new Scene(b1,640,480);
        stage.setScene(start);
    }
    public void scene2048(){
        app2048.setOnAction(new EventHandler<ActionEvent>() {
                 @Override public void handle(ActionEvent e) {
                     Scene app2048 = new Scene(b, 640, 480);
                     stage.setScene(app2048);
                 }//handle
             });//setOnAction
        //scene = new Scene(b/, 640, 480);
    }*/
    /** {@inheritdoc} */
    
    @Override
    public void start(Stage stage) {

        /* You are allowed to rewrite this start method, add other methods,
         * files, classes, etc., as needed. This currently contains some
         * simple sample code for mouse and keyboard interactions with a node
         * (rectangle) in a group.
         */
        //a = new App2048();
        //Testing the button from welcome page
        Scene start;
        b1 = new BorderPane();
        HBox h = new HBox();
        
        app2048 = new Button("Play 2048");
        tetris = new Button("Play Tetris");
        h.getChildren().addAll(app2048,tetris);
	h.setAlignment(Pos.CENTER);
        ImageView welcome = new ImageView("https://i-h2.pinimg.com/564x/13/78/3d/"+
                                          "13783d5dbc5927e449cd075c2c52dc60.jpg");
        welcome.setFitHeight(300);
        welcome.setFitWidth(240);
        b1.setCenter(welcome);
	//b.setAlignment(h,Pos.CENTER);
        b1.setBottom(h);
        
        start = new Scene(b1,640,480);
        stage.setScene(start);
        
        app2048.setOnAction(new EventHandler<ActionEvent>() {
                 @Override public void handle(ActionEvent e) {
                     Scene scene2048 = new Scene(b/*group*/, 640, 480);
                     scene2048.setOnKeyPressed(createKeyHandler());
                     stage.setScene(scene2048);
                 }//handle
             });//setOnAction
        //Testing button from welcome page
        b = new BorderPane();

	Button menuButton= new Button("Main Menu");

         menuButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {
                        //Scene  = new Scene(b/*group*/, 640, 480);
                        //scene2048.setOnKeyPressed(createKeyHandler());
                        stage.setScene(start);
                    }//handle
                });//setOnAction
	 b.setAlignment(menuButton, Pos.CENTER);
	 b.setBottom(menuButton);
	 
	 
        a.score(b);
        //adding the tilepane to window
        a.addNewRandom();
        a.addNewRandom();
        a.makeFrame(t,b);
        
	        
	//r.setX(50);                                // 50px in the x direction (right)
        //r.setY(50);                                // 50ps in the y direction (down)
        //group.getChildren().add(r);                // add to main container
        //r.setOnMouseClicked(createMouseHandler()); // clicks on the rectangle move it randomly
        //group.setOnKeyPressed(createKeyHandler()); // left-right key presses move the rectangle
        //welcome();
        //scene2048();
        //scene = new Scene(b/*group*/, 640, 480);
        //scene2048.setOnKeyPressed(createKeyHandler());
        stage.setTitle("cs1302-arcade!");
        //stage.setScene(scene);
        //stage.sizeToScene();
        stage.setWidth(250);
        stage.setHeight(340);
        stage.show();

        // the group must request input focus to receive key events
        // @see https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Node.html#requestFocus--
        //group.requestFocus();

    } // start
    
} // ArcadeApp

/*
0;136;0c0;136;0c
 */
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
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.layout.Priority;
public class ArcadeApp extends Application {

    Group group;// = new Group();           // main container
    //Group aliens = new Group();
    Random rgn = new Random();// random number generator
    BorderPane b2048;//2048
    //Scene start;
    //Stage stage; 
    BorderPane bWelcome;//Welcome
    //Scene scene;
    Button app2048;
    Button space;
    //Scene scene2048 = new Scene(b/*group*/, 640, 480);
    TilePane t= new TilePane();
    App2048 a = new App2048();;
    SpaceInvaders s = new SpaceInvaders();
    ImageView r;
    Button menuButton;
    Scene scene2048;
    Scene sceneSpace;
     Scene start;
    //ImageView bullet= new ImageView("https://i.pinimg.com/564x/8a/34/04/8a340499a281be7b9166ecbf81a49b3f.jpg");
    //Sprite r = new Sprite(50,50,20,20,"player");
    //Sprite r;
    //r.setImage(sprite.getImage());
    // Rectangle r = new Rectangle(20, 20); // some rectangle
    
    //r.setFill(new ImagePattern(new Image("https://i.pinimg.com/564x/34/7d/80/347d80a7c7cc0faf3a507a04a8d50433.jpg")));
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

    
    /**
     * Return a key event handler that moves to the rectangle to the left
     * or the right depending on what key event is generated by the associated
     * node.
     * @return the key event handler
     */
    //REMEMBER TO CHANGE r to whatever the alien object is
    //r is the Rectangle object!!
    private EventHandler<? super KeyEvent> keyHandlerSpace() {
        return event -> {
            System.out.println(event);
            if (event.getCode() == KeyCode.LEFT)  r.setX(r.getX() - 10.0);
            if (event.getCode() == KeyCode.RIGHT) r.setX(r.getX() + 10.0);
            //make method that animates bullets
            if (event.getCode() == KeyCode.SPACE){
                s.bulletAnim(r,group,"player",r); //r is player
	    }
// TODO bounds checking
        };
    } // createKeyHandler
    
    
    //THIS IS FOR THE ARCADEAPP
    private EventHandler<? super KeyEvent> keyHandler2048() {
        return event -> {
            System.out.println(event);
            if (event.getCode() == KeyCode.LEFT)
             {
                 
                 a.keyLeft();
                 a.score(b2048);
                 a.makeFrame(t,b2048);
             }
            else if (event.getCode() == KeyCode.RIGHT)
             {
                 
                 a.keyRight();
                 a.score(b2048);
                 a.makeFrame(t,b2048);
             }
            else if (event.getCode() == KeyCode.UP)
             {
                 
                 a.keyUp();
                 a.score(b2048);
                 a.makeFrame(t,b2048);
             }
            else if (event.getCode() == KeyCode.DOWN)
             {
                 
                 a.keyDown();
                 a.score(b2048);
                 a.makeFrame(t,b2048);
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
        
        /** You are allowed to rewrite this start method, add other methods,
         * files, classes, etc., as needed. This currently contains some
         * simple sample code for mouse and keyboard interactions with a node
         * (rectangle) in a group.
         */
        
        r = new ImageView("https://i.pinimg.com/564x/4f/58/27/4f58272fa91d49ad60c22bf49b94f3fb.jpg");
        r.setFitWidth(20);
        r.setFitHeight(20);
        //Testing the button from welcome page
       
        bWelcome = new BorderPane();
        HBox h = new HBox();
        
        app2048 = new Button("Play 2048");
        space = new Button("Play Space Invaders");
        h.getChildren().addAll(app2048,space);
        h.setAlignment(Pos.CENTER);
        ImageView welcome = new ImageView("https://i-h2.pinimg.com/564x/13/78/3d/"+
                                          "13783d5dbc5927e449cd075c2c52dc60.jpg");
        welcome.setFitHeight(300);
        welcome.setFitWidth(240);
        bWelcome.setCenter(welcome);
        
        bWelcome.setBottom(h);
        
        start = new Scene(bWelcome,640,480, Color.DEEPSKYBLUE);
        //Scene startButton = new Scene(bWelcome,640,480);
        stage.setScene(start);
        
        //s.enemyDeath();
        
        app2048.setFocusTraversable(false);
        //s.setScore(234);
        //VBox vbox; //=new VBox();;
        
        //Label name =new Label("Space Invaders");
        //Label intro = new Label("Use the arrow keys to move");
        //Label intro2 = new Label("left and right. Spacebar is to shoot!");
        //String scoreString = "Score: "+ s.getScore();
    
        //Label score =new Label(scoreString);
    //vbox.getChildren().add(score);
        space.setFocusTraversable(false);
        
        space.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    //HBox hSpace =new HBox();
                    group =new Group();
                    //s.setScore(12);
		    menuButton.setAlignment(Pos.CENTER);
                    VBox vMenu = new VBox(menuButton);
                    vMenu.setAlignment(Pos.CENTER);
                    s.createEnemy(group);
                    s.alienMovementX();
                    s.alienMovementY();
                    s.randomEnemyShooting(group,r);
                    r.setX(50);                                // 50px in the x direction (right)
                    r.setY(310);                               // 50ps in the y direction (down)
                    //s.addToVBox(vbox,menuButton);
                    //vbox.getChildren().addAll(name,intro,intro2,score, menuButton);
                    //vbox.setAlignment(Pos.CENTER);
                    group.getChildren().addAll(vMenu,r);
                    
		    //s.makeSpace(group,r,menuButton);
                    sceneSpace = new Scene(/*bSpaceInv*/group, 640, 480);
                    
                    sceneSpace.setOnKeyPressed(keyHandlerSpace());
                    s.setScore(12);
                    stage.setScene(sceneSpace);
                }//handle
            });//setOnAction
        //Making the action for the 2048 button
        app2048.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    //Was perviously in start
                    b2048 = new BorderPane();
                    b2048.setAlignment(menuButton, Pos.CENTER);
                    b2048.setBottom(menuButton);
                    menuButton.setFocusTraversable(false);
                    a.setScore(0);
		    a.clearBoard();
                    a.score(b2048);
                    //adding the tilepane to window
                    a.addNewRandom();
                    a.addNewRandom();
                    a.makeFrame(t,b2048);
                    //Was previously in start
                    scene2048 = new Scene(b2048, 640, 480,Color.LIGHTGREY);
                    scene2048.setOnKeyPressed(keyHandler2048());
                    stage.setScene(scene2048);
                }//handle
            });//setOnAction
        //Testing button from welcome page
        
        //Making the the action for the menu button
        menuButton= new Button("Main Menu");
        menuButton.setFocusTraversable(false);
        menuButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    //Scene  = new Scene(b/*group*/, 640, 480);
                    //scene2048.setOnKeyPressed(createKeyHandler());
                    stage.setScene(start);
                }//handle
            });//setOnAction
        //s.addToVBox(vbox,menuButton);
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

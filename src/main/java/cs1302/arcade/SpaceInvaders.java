package cs1302.arcade;
import javafx.scene.Group;
import java.util.ArrayList;
import javafx.scene.image.Image; 
import javafx.scene.image.ImageView;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.util.Duration;
import javafx.animation.Animation;
import java.time.LocalTime;

public class SpaceInvaders{

    ArrayList<ImageView> listEnemy= new ArrayList<ImageView>(); //creating an array to store enemies
    ArrayList<ImageView> listBullet= new ArrayList<ImageView>(); //creating arrayList for bullets
    
    int countX=0;
    int countY=0;

    public SpaceInvaders(){
	//this is the constructor
    }

    
    public void createEnemy(Group g){
        for(int x=0;x<5;x++){
            
            for(int i=0;i<12;i++){
                ImageView enemy= new ImageView(new Image("https://i.pinimg.com/564x/34/7d/80/347"+
						     "d80a7c7cc0faf3a507a04a8d50433.jpg"));
                enemy.setX(13+i*17);
                enemy.setY(50+x*20);
                enemy.setFitHeight(10);
                enemy.setFitWidth(10);
                g.getChildren().add(enemy);
                listEnemy.add(enemy); //adding enemy into the list containing enemy
            }
        }
    }
    
    //AMANDA's PART ***********************************************
    public void setCountX(int x){
	countX=x;
    }
    public int getCountX(){
	return countX;
    }
    public void alienMovementX(){
	EventHandler<ActionEvent> handler = event -> {
	    if(getCountX()<=3){
		updateX(0); //will go right
		setCountX(getCountX()+1); //setting it one more
	    }
	    if((getCountX()>3)&&(getCountX()<=7)){
		updateX(1); //will shift to left
		if(getCountX()==7){
		    setCountX(0);
		}
		else{
		    setCountX(getCountX()+1); //setting it to one more until it is 5
		}
	    }
	};
	KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), handler);
	Timeline timeline = new Timeline();
	timeline.setCycleCount(Timeline.INDEFINITE);
	timeline.getKeyFrames().add(keyFrame);
	timeline.play();
    }
    public void updateX(int count){
	//if the count is 0, then it will shift to right
	if(count==0){
	    for(int i=0;i<listEnemy.size();i++){
		listEnemy.get(i).setX(listEnemy.get(i).getX()+7);
	    }
	}
	else{
	    //for left; only if it is 1
	    for(int i=0;i<listEnemy.size();i++){
		listEnemy.get(i).setX(listEnemy.get(i).getX()-7);
	    }
	}
    }
    
    
    /*
    public void alienMovement(){
        EventHandler<ActionEvent> handler = event -> {
            System.out.println(LocalTime.now());
            //updateX();
            int count=2;
            if(listEnemy.get(12).getX()==330){
                //updateX(1);
                count=1;
                //make down method
            }
            else if(listEnemy.get(0).getX()==5){
                //updateX(2);
                count=2;
                //down method
            }
            else{
                // updateX(count);
            }
            updateX(count);
        };
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), handler);
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
        
    }
    public void updateX(int count){
        if(count%2==0){
            
            for(int i=0;i<listEnemy.size();i++){
                listEnemy.get(i).setX(listEnemy.get(i).getX()+(count*5));
            }
        }
        else{
            //for left
            for(int i=0;i<listEnemy.size();i++){
                listEnemy.get(i).setX(listEnemy.get(i).getX()-5);
            }
        }
    }
    */
    
    /*
    //this is to run it smooth; I think it should be in the start method
    AnimationTime timer =new AnimationTimer(){
	    @Override
	    public void handle(long now){
		update();
	    }
	});
    */

    /*
    public void shoot(Sprite s,Group g){
	//creating a the bullets coming out. Updating the 
	Sprite shootSprite= new Sprite(s.getTranslateX()+20,s.getTranslateY()+20,5,20,"bullet");
	g.getChildren().add(shootSprite);
    }
    public void nextLevel(Group g){
	//bacially creating the five aliens next to each other
	for(int i=0;i<5;i++){
	    Sprite enemies= new Sprite(90+i*100,150,30,30,"enemy"); //creating a new sprite object
	    g.getChildren().add(enemies);
	    listEnemy.add(enemies); //adding the enemy object into the arrayList
	}
    }

    //this is the method that updates the scene to see if there has been any bullet intersections
    public void update(){
	for(int i=0;i<listBullet.size();i++){ //for each bullet
	    Sprite bullet= listBullet.get(i); //accessing the bullet
	    for(int x=0;x.listEnemy.size();x++){
		Sprite enemy= listEnemy.get(x);
		if(bullet.getBoundsInParent().intersects(enemy.getBoundsInParent())){
		    enemy.setIsLiving(false); //setting the boolean living to false.
		}
	    }
	}
    }
    */
}

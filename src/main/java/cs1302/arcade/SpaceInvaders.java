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
import javafx.application.Platform;

public class SpaceInvaders{

    ArrayList<ImageView> listEnemy= new ArrayList<ImageView>(); //creating an array to store enemies
    ArrayList<ImageView> listBullet= new ArrayList<ImageView>(); //creating arrayList for bullets
    ArrayList<String> listEnemyStatus= new ArrayList<String>(); 
    
    int countX=0;
    int countY=0;
    int score=0;

    public SpaceInvaders(){
	//this is the constructor
    }
    
    public void createEnemy(Group g){
	for(int i=0;i<60;i++){
	    listEnemyStatus.add("alive");
	}
        for(int x=0;x<5;x++){   
            for(int i=0;i<12;i++){
                ImageView enemy= new ImageView(new Image("https://i.pinimg.com/564x/34/7d/80/347"+
						     "d80a7c7cc0faf3a507a04a8d50433.jpg"));
                enemy.setX(13+i*17);
                enemy.setY(50+x*20);
                enemy.setFitHeight(10);
                enemy.setFitWidth(10);
		/*
		if(listBullet.size()!=0){
                for(int j=0;j<listBullet.size();j++){
                     if(!(enemy.getBoundsInParent().intersects(listBullet.get(j).getBoundsInParent()))){
                        g.getChildren().add(enemy);
                        listEnemy.add(enemy); //adding enemy into the list containing enemy
                  }
                    //add empty images
                }
                }
                else{
		*/
                g.getChildren().add(enemy);
                listEnemy.add(enemy);
                //}
            }
        }
    }
    // ***********************************************
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
	timeline.setCycleCount(57);
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

    //NOW FOR THE Y MOVEMENT
    public void alienMovementY(){
          EventHandler<ActionEvent> handler = event -> {
	      updateY(); //will go down
          };
          KeyFrame keyFrame = new KeyFrame(Duration.seconds(3.6), handler);
          Timeline timeline = new Timeline();
          timeline.setCycleCount(15);
          timeline.getKeyFrames().add(keyFrame);
          timeline.play();
      }
     public void updateY(){
	 for(int i=0;i<listEnemy.size();i++){
	     listEnemy.get(i).setY(listEnemy.get(i).getY()+10);
	 }
     }

    
    //FOR SPACE BAR ********************************************
    public double getXCoord(ImageView sprite){
      return sprite.getX();
    }
    public double getYCoord(ImageView sprite){
        return sprite.getY();
    }
    
    public void bulletAnim(ImageView player,Group g,String playerType){
	ImageView bullet= new ImageView(new Image("https://i.pinimg.com/564x/8a/34/04/8a340499a281"+
						  "be7b9166ecbf81a49b3f.jpg"));
	bullet.setFitHeight(5);
	bullet.setFitWidth(5);
	g.getChildren().add(bullet);
	listBullet.add(bullet); //adding the newly made bullet into ArrayList of bullets
	//setting original starting place of bullet
	bullet.setX(getXCoord(player)+5);
	bullet.setY(getYCoord(player));
        EventHandler<ActionEvent> handler = event -> { 
	    updateBull(bullet,g,playerType);
        };
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.01), handler);
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(keyFrame); 
        timeline.play();
      
    }
    public void updateBull(ImageView bullet,Group g,String playerType){
	if(playerType.equals("enemy")){ //if the playerType is a enemy, then bullets will go down
		bullet.setY(bullet.getY()+3);
	}
	else{ //if the type is a player
	    bullet.setY(bullet.getY()-3);
	}
	enemyDeath(bullet,g);
    }
    public int getScore(){
	return score; 
    }
         public void enemyDeath(ImageView bullet,Group group){
         //EventHandler<ActionEvent> handler = event -> {
             Runnable r = () -> {
                 for(int i=0;i<listEnemy.size();i++){
                     ImageView enemy=listEnemy.get(i);
		     String aliveString= listEnemyStatus.get(i);
		     boolean alive=false; //false until proven tru
		     if(aliveString.equals("alive")){
			 alive=true;
			 }
                     if((enemy.getBoundsInParent().intersects(bullet.getBoundsInParent()))&&alive){
                         group.getChildren().remove(i);
                         listEnemyStatus.set(i,"dead");//need to see that status array to dead
                         //listEnemy.set(i,new ImageView(new Image("https://i.pinimg.com/564x/6f/ff/63/6"+
                         //                                      "fff63515a436df1e0799bf823abc07d.jpg")));
                         bullet.setX(0);
                         bullet.setY(0);
                         if(i>36){
                             score=score+10;
                         }
                         else if(i>12){
                             score=score+20;
                         }
                         else{
                             //the first row is worth 40
                             score=score+40;
                         }
                     }
                 }
             };
             Platform.runLater(r);
             //Thread t = new Thread(r);
             //t.setDaemon(true);
            //t.start();
             //};
     }

    //**********************************************
    
    
    
    
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

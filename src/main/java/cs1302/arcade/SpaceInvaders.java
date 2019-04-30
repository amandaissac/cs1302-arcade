package cs1302.arcade;
import javafx.scene.Group;
import java.util.ArrayList;
import javafx.scene.image.Image; 
import javafx.scene.image.ImageView;
public class SpaceInvaders{

    ArrayList<ImageView> listEnemy= new ArrayList<ImageView>(); //creating an array to store enemies
    ArrayList<ImageView> listBullet= new ArrayList<ImageView>(); //creating arrayList for bullets

    public SpaceInvaders(){
	//this is the constructor
    }
    public void createEnemy(Group g){
	for(int x=0;x<5;x++){
	    
	    for(int i=0;i<12;i++){
		ImageView enemy= new ImageView(new Image("https://i.pinimg.com/564x/34/7d/80/347"+
						     "d80a7c7cc0faf3a507a04a8d50433.jpg"));
		enemy.setX(12+i*17);
		enemy.setY(50+x*20);
		enemy.setFitHeight(10);
		enemy.setFitWidth(10);
		g.getChildren().add(enemy);
		listEnemy.add(enemy); //adding enemy into the list containing enemy
	    }
	}
    }
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

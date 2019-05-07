package cs1302.arcade;
import java.util.Random;
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
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
public class SpaceInvaders{
    
    ArrayList<ImageView> listEnemy; //creating an array to store enemies
    ArrayList<ImageView> listBullet; //creating arrayList for bullets
    ArrayList<String> listEnemyStatus; 
    ArrayList<ImageView> listObstacle;
    String levelString;
    int level;
    int countX;
    int countY;
    int score;
    boolean goRight;
    int numLives;
    ImageView heart;
    ArrayList<ImageView> listHeart;
    boolean gameOver;
    ImageView gameOverPic;
    VBox v;
    ArrayList<Integer> listObstacleCount;
    Button menuButton;
    int prevScore;
    int countDown;
    boolean level1NotDone;
    ImageView player;
    Double movementXTime;
    Double movementYTime;
    /**
     *This method is the constructor for the spaceInvaders App
     */
    public SpaceInvaders(){
        //this is the constructor
    }
    public void setMenuButton(Button button){
        menuButton = button;
    }
    public void setPlayer(ImageView r){
	player = r;
    }

    /*
	public void resetLevel(Group g){
	g.getChildren().remove(v);
	listEnemy=new ArrayList<ImageView>();
	listBullet=new ArrayList<ImageView>();
	listEnemyStatus= new ArrayList<String>();
	//listObstacle= new ArrayList<ImageView>();
	countX=0;
	countY=0;
	score=getScore();
	gameOver=false;
	goRight=true;
	numLives=0;
	listHeart=new ArrayList<ImageView>();
	createHearts(g);
	v=new VBox();
	g.getChildren().add(addToVBox());
	listObstacleCount=new ArrayList<Integer>();
	for(int i=0;i<3;i++){
	    listObstacleCount.add(0);
	}
	createEnemy(g);
	alienMovementX();
	alienMovementY(g);	
    }
    /*
    public void checkGameOver(Group g){
        if(listEnemy.get(59).getY()>=290){
            gameOver=true;
        }
        System.out.println("y pos" + listEnemy.get(59).getY());
    }
    */
    /*
	public void changeLevels(Group g){
        //checkGameOver(g);
        if(((getScore()==1240)||(getScore()==1300))&&countDown==10){
	    changeLevel1(g);
	    level1NotDone=true;
	    System.out.println("tried to chnage into level1");
	}
	if(countDown==20){
	    changeLevel2(g);
	}
	if(countDown==30){
	    changeLevel3(g);
	}
	if(gameOver){
	    //the you lose picture shows up
	    gameOverPic= new ImageView(new Image("gameover.jpg"));
	    gameOverPic.setFitHeight(250);
	    gameOverPic.setFitWidth(250);
	    gameOverPic.setX(0);
	    gameOverPic.setY(100);
	    g.getChildren().add(gameOverPic);
	}
    }
    public void  changeLevel1(Group g){
	//changing to level 2
        if(((getScore()==1240)&&(listEnemyStatus.get(60).equals("al"+
	"ive")))||((getScore()==1300)&&(listEnemyStatus.get(60).equals("dead")))){
            prevScore = getScore();
	    //resetting the level
	    resetLevel(g);
	    System.out.println("reset the level");
            level=2;
            levelString= "Level 2";
        }
	else{
	    gameOver=true;
	}
    }
    public void changeLevel2(Group g){
	if(prevScore==1260){
	    if(((getScore()==2560)&&(listEnemyStatus.get(60).equals("dead")))||((getScore()==2460)&&(listEnemyStatus.get(60).equals("alive")))){
		prevScore=getScore();
		//resetting the level
		resetLevel(g);
		level=3;
		levelString= "level 3";
		gameOver=false;
	       }
	    else{
		gameOver=true;
	    }
	}
	if(prevScore==1200){
	    if(((getScore()==2460)&&(listEnemyStatus.get(60).equals("dead")))||((getScore()==2400)&&(listEnemyStatus.get(60).equals("alive")))){
		prevScore=getScore();
		//resetting the level
		resetLevel(g);
		level=3;
		levelString="level 3";
		gameOver=false;
	    }
	    else{
		gameOver=true;
	    }
	}
    }
    public void changeLevel3(Group g){
	if(prevScore==2520){
	    if(((getScore()==3780)&&(listEnemyStatus.get(60).equals("dead")))||((getScore()==3720)&&(listEnemyStatus.get(60).equals("alive")))){
		//need to display you win
		youWinCreate(g);
	    }
	    else{
		gameOver=true;
	    }
	}
	if(prevScore==2460){
	    if(((getScore()==3720)&&(listEnemyStatus.get(60).equals("dead")))||((getScore()==3660)&&(listEnemyStatus.get(60).equals("alive")))){
		//need to display you win
		youWinCreate(g);
		gameOver=false;
	    }
	    else{
		gameOver=true;
	    }
	}
	if(prevScore==2400){
	    if(((getScore()==3660)&&(listEnemyStatus.get(60).equals("dead")))||((getScore()==3600)&&(listEnemyStatus.get(60).equals("alive")))){
		//need to display you win
		youWinCreate(g);
		gameOver=false;
	    }
	    else{
		gameOver=true;
	    }
	}
    }
    public void youWinCreate(Group g){
	ImageView youWin=new ImageView(new Image("youWin.jpg"));
	youWin.setFitHeight(250);
	youWin.setFitWidth(250);
	youWin.setX(0);
	youWin.setY(100);
	g.getChildren().add(youWin);
    }
    ////////////////////////////
    */
/**
     *sets initial values of game
     *@param g g is the group that the VBox is added to in the beginning of the game
     */
    public void newGame(Group g){
	listEnemy=new ArrayList<ImageView>();
	listBullet=new ArrayList<ImageView>();
	listEnemyStatus= new ArrayList<String>();
	listObstacle= new ArrayList<ImageView>();
	countX=0;
	countY=0;
	score=0;
	goRight=true;
	numLives=0;
	listHeart=new ArrayList<ImageView>();
	gameOver=false;
	createHearts(g);
	v=new VBox();
	g.getChildren().add(addToVBox());
	listObstacleCount=new ArrayList<Integer>();
	for(int i=0;i<3;i++){
	    listObstacleCount.add(0);
	}
	level=1;
	levelString="Level 1";
	prevScore=0;
	countDown=0;
	level1NotDone=true;
	movementXTime=2.5;
	movementYTime=9.0;
    }
    public void checkAllDead(Group g){
	listEnemyStatus=new ArrayList<String>();
	listEnemy=new ArrayList<ImageView>();
	listObstacle=new ArrayList<ImageView>();
	createHearts(g);
	createEnemy(g);
	alienMovementX();
	alienMovementY(g);
	randomEnemyShooting(g,player);
    }
    
    public void createHearts(Group g){
      listHeart= new ArrayList<ImageView>(); //creating a new ArrayList each time
      for(int i=0;i<3;i++){
          heart=new ImageView(new Image("heart.jpg"));
          heart.setFitWidth(15);
          heart.setFitHeight(15);
          heart.setX(75+(i*40));
          heart.setY(87);
          listHeart.add(heart);//so this list will have length of 3
	  g.getChildren().add(heart);
      }
    }
     public void setGameOver(boolean value){
	 gameOver=value;
     }
    public int getNumLives(){
	return numLives;
    }
    public void setNumLives(int i){
	numLives=i;
    }

    /**
     *This method is to set the format of the 12X5 enemies
     */
    public void createEnemy(Group g){
        
        //newGame(g);
	for(int i=0;i<60;i++){
	    listEnemyStatus.add("alive");
	}
	for(int x=0;x<5;x++){   
	    for(int i=0;i<12;i++){
		ImageView enemy= new ImageView(new Image("topRowAlien.jpg"));
		
		if((x==1)||(x==2)){
		    //second a third row
		    enemy= new ImageView(new Image("middleRowAlien.jpg"));
		}
		if((x==3)||(x==4)){
		    enemy= new ImageView(new Image("bottomRowAlien.jpg"));
		}
		
        enemy.setX(13+i*17);
        enemy.setY(110+x*20);
        enemy.setFitHeight(15);
        enemy.setFitWidth(15);
        g.getChildren().add(enemy);
        listEnemy.add(enemy);
        }
    }
	listEnemyStatus.add("alive"); //for the red extra point one
	ImageView enemy=new ImageView(new Image("redAlien.jpg"));
	enemy.setX(10);
	enemy.setY(100);
	enemy.setFitHeight(15);
	enemy.setFitWidth(15);
	g.getChildren().add(enemy);
	listEnemy.add(enemy);
    
	for(int i=0;i<3;i++){
	    ImageView obstacle= new ImageView(new Image("barrier.png"));
        listObstacle.add(obstacle);
        obstacle.setX(40+i*70);
        obstacle.setY(290);
        obstacle.setFitHeight(15);
        obstacle.setFitWidth(25);
        g.getChildren().add(obstacle);
	}
    }
    // ***********************************************
    
    /**
     *This method is used for the alienMovementX method. 
     */
    public void setCountX(int x){
        countX=x;
    }
    /**
     *This returns the X count.
     *@return x count 
     */
    public int getCountX(){
        return countX;
    }
    /**
     *The alienMovementX is used to move the aliens right and left. 
     */
    public void alienMovementX(){
        redAlienMovement();
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
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(movementXTime), handler);
        Timeline timeline = new Timeline();
        timeline.setCycleCount(39);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }
    public boolean getGoRight(){
        return goRight;
    }
    public void setGoRight(boolean status){
        goRight=status;
    }
    public void redAlienMovement(){
        ImageView redEnemy=listEnemy.get(60);
        EventHandler<ActionEvent> handler = event -> {
            if((redEnemy.getX()<=350)&&getGoRight()){
                redEnemy.setX(redEnemy.getX()+2);
                if(redEnemy.getX()>350){
                    setGoRight(false);
                
                }
            }
            else{
		if((redEnemy.getX()>-100)&(!getGoRight())){
                redEnemy.setX(redEnemy.getX()-2);
                if(redEnemy.getX()<=-100){
                    setGoRight(true);
                }
            }
            }
        };
        KeyFrame keyFrame= new KeyFrame(Duration.seconds(0.1),handler);
        Timeline timeline= new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }
    /**
     *This method updates the X location of each imageView element.
     */
    public void updateX(int count){
	//if the count is 0, then it will shift to right
        if(count==0){
            for(int i=0;i<60;i++){
                listEnemy.get(i).setX(listEnemy.get(i).getX()+7);
            }
        }
	else{
	    //for left; only if it is 1
	    for(int i=0;i<60;i++){
            listEnemy.get(i).setX(listEnemy.get(i).getX()-7);
	    }
	}
    }
    public boolean allAlienDead(){
	for(int i=0;i<60;i++){
	    if(listEnemyStatus.get(i).equals("alive")){
		return false;
	    }
	}
	return true;
    }
    
    //NOW FOR THE Y MOVEMENT
    /**
     *Used to make the aliens move up and down
     */
    public void alienMovementY(Group g){
        EventHandler<ActionEvent> handler = event -> {
            updateY(); //will go down
	    countDown=countDown+1;
	    if(countDown==10){
		if(allAlienDead()){
		    levelString="Level 2";
		    level=2;
		    movementXTime=2.0;
		    movementYTime=7.2;
		    checkAllDead(g);
		}
		else{
		    gameOverPic(g);
		}
	    }
	    if(countDown==20){
		if(allAlienDead()){
		    levelString="Level 3";
		    level=3;
		    movementXTime=1.5;
		    movementYTime=5.4;
		    checkAllDead(g);
		}
		else{
		    gameOverPic(g);
		}
	    }
	    if(countDown==30){
		if(allAlienDead()){
		    youWinImage(g);
		}
		else{
		    gameOverPic(g);
		}
	    }
        };
          KeyFrame keyFrame = new KeyFrame(Duration.seconds(movementYTime), handler);
          Timeline timeline = new Timeline();
          timeline.setCycleCount(10);
          timeline.getKeyFrames().add(keyFrame);
          timeline.play();
	  //changeLevels(g);
    }
    public void gameOverPic(Group g){
	gameOverPic=new ImageView(new Image("gameover.jpg"));
	gameOverPic.setFitHeight(250);
	gameOverPic.setFitWidth(250);
	gameOverPic.setX(0);
	gameOverPic.setY(100);
	g.getChildren().add(gameOverPic);
    }
    /**
     *updates the y location of the enemy
     */
    public void updateY(){
        for(int i=0;i<60;i++){
            listEnemy.get(i).setY(listEnemy.get(i).getY()+10);
	 }
    }
    
    //FOR SPACE BAR ********************************************
    /**
     *returns the x coordinate
     *@return x coordiante
     */
    public double getXCoord(ImageView sprite){
        return sprite.getX();
    }
    /**
     *returns the y coordinate
     */
    public double getYCoord(ImageView sprite){
        return sprite.getY();
    }
    /**
     *generates the aliens radnomly shooting
     */
    public void randomEnemyShooting(Group g,ImageView mainPlayer){
        EventHandler<ActionEvent> handler1= event -> {
            Random rand= new Random();
            int i=rand.nextInt(60); //getting random number for index
            while(listEnemyStatus.get(i).equals("dead")){
                i=rand.nextInt(60);
            }
            //calling the bulletAnim method
            bulletAnim(listEnemy.get(i),g,"enemy",mainPlayer);
        };
        KeyFrame keyFrame= new KeyFrame(Duration.seconds(2),handler1);
        Timeline timeline= new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }
    /**
     *creates the bullets and there is a timeline keyframe that decides where the bullets begin from
     */
    public void bulletAnim(ImageView player,Group g,String playerType,ImageView mainPlayer){
        ImageView bullet= new ImageView(new Image("bullet.jpg"));
        bullet.setFitHeight(5);
        bullet.setFitWidth(5);
        g.getChildren().add(bullet);
        listBullet.add(bullet); //adding the newly made bullet into ArrayList of bullets
        //setting original starting place of bullet
        bullet.setX(player.getX()+5);
        bullet.setY(player.getY());
        EventHandler<ActionEvent> handler = event -> { 
            updateBull(bullet,g,playerType,mainPlayer);
        };
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.01), handler);
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(keyFrame); 
        timeline.play();
    }
    /**
     *Causes the bullet to go up. 
     */
    public void updateBull(ImageView bullet,Group g,String playerType,ImageView mainPlayer){
        if(playerType.equals("enemy")){ //if the playerType is a enemy, then bullets will go down
            bullet.setY(bullet.getY()+3);
	    if(bullet.getBoundsInParent().intersects(mainPlayer.getBoundsInParent())){
		setNumLives(getNumLives()-1);
		System.out.println("This is the number of lives: "+getNumLives());
		if((getNumLives()>=-9)&&(getNumLives()!=0)){
		    listHeart.get(2).setX(-100);
		    listHeart.get(2).setY(-100);
		    //System.out.println("This is the number of lives: "+getNumLives()); 
		    //listHeart.get(getNumLives()).setX(-100);
		    //listHeart.get(getNumLives()).setY(-100);
		}
		else if(getNumLives()>=-18){
		    listHeart.get(1).setX(-100);
		    listHeart.get(1).setY(-100);
		}
		else{ //if it is 0; may need to fix formating
		    listHeart.get(0).setX(-100);
		    listHeart.get(0).setY(-100);
		    gameOver=true;
		    gameOverPic= new ImageView(new Image("gameover.jpg"));
		    gameOverPic.setFitHeight(250);
		    gameOverPic.setFitWidth(250);
		    gameOverPic.setX(0);
		    gameOverPic.setY(100);
		    g.getChildren().add(gameOverPic);
		}
	    }
        }
        else{ //if the type is a player
            bullet.setY(bullet.getY()-3);
            enemyDeath(bullet,g);
        }
	destroyObstacle(bullet,g); //destroy obstacle if the bullet hits it
    }
    /**
     *moves ImageViews based on if the barriers are hit by bullets
     *@param bullet bullet that is hitting the barrier
     *@param g g is the group that the barrier ImageViews are being added to
     */
    public void destroyObstacle(ImageView bullet,Group g){
	for(int i=0;i<listObstacle.size();i++){
	    ImageView obstacle=listObstacle.get(i);
	    if(obstacle.getBoundsInParent().intersects(bullet.getBoundsInParent())){
		listObstacleCount.set(i,listObstacleCount.get(i)+1);
		System.out.println("This is the obstacleCount: "+listObstacleCount.get(i));
		if(listObstacleCount.get(i)<=5){
		    ImageView newObstacle=new ImageView(new Image("obstacle1.jpg"));
		    imageFormat(obstacle,newObstacle,g);
		    bullet.setX(-100);
		    bullet.setY(-100);
		}
		else if(listObstacleCount.get(i)<=10){
		    ImageView newObstacle=new ImageView(new Image("obstacle2.jpg"));
		    imageFormat(obstacle,newObstacle,g);
		    bullet.setX(-100);
		    bullet.setY(-100);
		}
		else if(listObstacleCount.get(i)<=15){
		    ImageView newObstacle=new ImageView(new Image("obstacle3.jpg"));
		    imageFormat(obstacle,newObstacle,g);
		    bullet.setX(-100);
		    bullet.setY(-100);
		}
		else if(listObstacleCount.get(i)<=20){
		    ImageView newObstacle=new ImageView(new Image("obstacle4.jpg"));
		    imageFormat(obstacle,newObstacle,g);
		    bullet.setX(-100);
		    bullet.setY(-100);
		}
		else{ //if it has hit 5 times
		    ImageView newObstacle=new ImageView(new Image("obstacle5.jpg"));
		    imageFormat(obstacle,newObstacle,g);
		}
	    }
	}
    }
    public void imageFormat(ImageView obstacle,ImageView newObstacle,Group g){
	newObstacle.setX(obstacle.getX());
	newObstacle.setY(obstacle.getY());
        newObstacle.setFitHeight(obstacle.getFitHeight());
        newObstacle.setFitWidth(obstacle.getFitWidth());
        g.getChildren().add(newObstacle);
    }
    /**
     *returns the score
     *@return score
     */
    public int getScore(){
        return score; 
    }
    /**
     *sets the score 
     *@param value value is the value the score is being set to
     */
    public void setScore(int value){
        score=value;
    }
    /**
     *Looks to see if the bullets intersect with an enemy. 
     *If it does intersect, then the status of the enemy changes to dead. 
     */
    public void enemyDeath(ImageView bullet,Group group){
        Runnable r = () -> {
            for(int i=0;i<listEnemy.size();i++){
                ImageView enemy=listEnemy.get(i);
                String aliveString= listEnemyStatus.get(i);
                boolean alive=false; //false until proven tru
                if(aliveString.equals("alive")){
                    alive=true;
                }
                if((enemy.getBoundsInParent().intersects(bullet.getBoundsInParent()))&&alive){
                    //group.getChildren().remove(i);
                    listEnemyStatus.set(i,"dead");//need to see that status array to dead
                    listEnemy.get(i).setX(-100);
                    listEnemy.get(i).setY(-100);
                    //listEnemy.set(i,new ImageView(new Image("https://i.pinimg.com/564x/6f/ff/63/6"+
                    //                                      "fff63515a436df1e0799bf823abc07d.jpg")));
                    bullet.setX(0);
                    bullet.setY(0);
                    if(i==60){
                        setScore(getScore()+60);
			group.getChildren().remove(v);
			group.getChildren().add(addToVBox());
                        System.out.println(getScore());
                        //changeLevels(group);
                    }
                    if(i>36){
                        setScore(getScore()+10);
			group.getChildren().remove(v);
			group.getChildren().add(addToVBox());
                        System.out.println(getScore());
                        //changeLevels(group);
                    }
                    else if(i>12){
                        setScore(getScore()+20);
			group.getChildren().remove(v);
			group.getChildren().add(addToVBox());
			//changeLevels(group);
                        //System.out.println(getScore());
                    }
                    else{
                        //the first row is worth 40
                        setScore(getScore()+40);
			group.getChildren().remove(v);
			group.getChildren().add(addToVBox());
                        System.out.println(getScore());
                        //changeLevels(group);
                    }
		    scoreCheckEnemyAllDead(group);
                }
            }
            };
            Platform.runLater(r);
            //addToVBox(menuButton);
    }
    public void scoreCheckEnemyAllDead(Group g){
	if(allAlienDead()){
	    System.out.println("All alien dead: "+allAlienDead());
	    if(countDown<=10){
		levelString="Level 2";
		level=2;
		movementXTime=2.0;
		movementYTime=7.2;
		countDown=10;
		checkAllDead(g);
	    }
	    else if(countDown<=20){
		levelString="Level 3";
		level=3;
		movementXTime=1.5;
		movementYTime=5.4;
		countDown=20;
		checkAllDead(g);
	    }
	    else{
		//you win image pops up
		youWinImage(g);
	    }
	}
    }
    public void youWinImage(Group g){
	ImageView youWinImage=new ImageView(new Image("youwin.jpg"));
	 youWinImage.setFitHeight(250);
	 youWinImage.setFitWidth(250);
	 youWinImage.setX(0);
	 youWinImage.setY(100);
	 g.getChildren().add(youWinImage);
    }
    public void makeSpace(Group group,ImageView r, Button menuButton){
        Label name =new Label("Space Invaders");
        Label intro = new Label("Use the arrow keys to move");
        Label intro2 = new Label("left and right. Spacebar is to shoot!");
        String scoreString = "Score: "+ getScore();
        Label score =new Label(scoreString);
        createEnemy(group);
        alienMovementX();
        alienMovementY(group);
        randomEnemyShooting(group,r);
        r.setX(50);                                // 50px in the x direction (right)
        r.setY(310);                               // 50ps in the y direction (down)
        
        VBox vbox = new VBox(name,intro,intro2,score, menuButton);
        vbox.setAlignment(Pos.CENTER);
        group.getChildren().addAll(vbox,r);
    }
    
    //**********************************************
    /**
     *adds items to VBox
     */
    public VBox addToVBox(){
        v.getChildren().clear();
        Label levelLabel= new Label(levelString);
        //Label empty2=new Label("");
        Label name =new Label("Space Invaders");
        Label intro = new Label("Use the arrow keys to move");
        Label intro2 = new Label("left and right. Spacebar is to shoot!");
        String scoreString = "Score: "+ getScore();
        System.out.println(scoreString);//test
        Label score =new Label(scoreString);
        //Label name =new Label("Space Invaders");
        v.getChildren().addAll(/*empty,empty2,*/menuButton,name,intro,intro2,score,levelLabel);
        v.setAlignment(Pos.CENTER);
        return v;        
    }
}

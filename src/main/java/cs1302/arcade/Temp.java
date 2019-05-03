/*
boolean alive = true;
public int getXCoord(ImageView sprite){
    return sprite.getX();
}
public int getYCoord(ImageView sprite){
    return sprite.getY();
}
public void bulletAnim(ImageView player,ImageView bullet){
    EventHandler<ActionEvent> handler = event -> {
        updateBull(player,bullet);
        
    };
 KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), handler);
 Timeline timeline = new Timeline();
 timeline.setCycleCount(Timeline.INDEFINITE);
 timeline.getKeyFrames().add(keyFrame);
     timeline.play();
     
}
public void updateBull(ImageView player,ImageView bullet){
    bullet.setX(getXCoord(player));
    bullet.setY(getYCoord(player));
    for(int i=0;i<listEnemy.size();i++){
        bullet.setX(bullet.getX()+10);
    }
    
}
*/
/*
public boolean isAlive(ImageView sprite, ImageView bullet){
    boolean alive = true;
    if(bullet.getBoundsInParent().intersects(enemy.getBoundsInParent())){
        alive = false;
    }
    return alive;
}
//what happens if intersects returns false
public void removeAlien(){
    if(isAlive()==false){
        listEnemies.remove();//idk how to find which alien in the arraylist intersected with the bullet??
    }
}
*/
//in arcade app: randomEnemyShoot(group, r)
//in arcade app: for space bar it should be bulletAnim(r, group,"player,r);

///////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////

/*
int numLives=0;
//ImageView player;
ImageView heart;
ArrayList<ImageView> listHeart= new ArrayList<ImageView>();
boolean gameOver=false;
ImageView gameOverPic;

//call this in make enemy
public boolean createHearts(){
    listHeart= new ArrayList<ImageView>(); //creating a new ArrayList each time
    for(int i=0;i<3;i++){
	heart=new ImageView(new Image(""));
	heart.setFitWidth(10);
	heart.setFitHieght(10);
	heart.setX(100+(i*10));
	heart.setY(300);
	listHeart.add(heart);//so this list will have length of 3
    }
}
public void randomEnemyShooting(Group g, ImageView mainplayer){
    bulletAnim(listEnemy,get(i),g,"enemy",mainPlayer);
}
public void bulletAnim(ImageView player, Group g, String playerType, ImageView mainPlayer){
    updateBull(bullet,g,playerType,mainPlayer);
}
public void updateBullet(ImageView bullet, Group g, String playerType, ImageView mainPlayer){
    if(playerType.equals("enemy")){
	bullet.setY(bullet.getY()+3);
	if(bullet.getBoundsInParent().interects(mainPlayer.getBoundsInParent())){
	    setNumLives(getNumLives()-1);
	    if(getNumLives()!=0){
		listHeart.get(i).setX(-100);
		listHeart.get(i).setY(-100);
	    }
	    else{ //if it is 0; may need to fix formating
		gameOver=true;
		gameOverPic= new ImageView(new Image(""));
		gameOverPic.setFitHeight(300);
		gameOverPic.setFitWidth(240);
		gameOverPic.setX(0);
		gameOverPic.setY(100);
		g.getChidren().add(gameOverPic);
	    }
	}
    }
    else{
	//whatever
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
*/


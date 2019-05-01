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

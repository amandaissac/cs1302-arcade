package cs1302.arcade;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;
public class Sprite extends ImageView{
    ImageView image;
    boolean alive = true;
    String type;
    public Sprite(int x,int y,String type){
        //super(w,h,color);
        setX(x);
        setY(y);
	this.type=type;
	
        if(type.equals("player")){
            image = new ImageView("https://i.pinimg.com/originals/4f/58/27/4f58272fa91d49ad60c22bf"+
				  "49b94f3fb.webp");
    
        }
        else if(type.equals("alien")){
            image = new ImageView("https://i.pinimg.com/564x/34/7d/80/347d80a7c7cc0faf3a507a04a8d5"+
				  "0433.jpg");
        }
        else{
	    //the bullet images
            image = new ImageView("https://i.pinimg.com/564x/8a/34/04/8a340499a281be7b9166ecbf8"+
	    "1a49b3f.jpg"
        }
    }
}

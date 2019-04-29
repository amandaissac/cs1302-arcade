package cs1302.arcade;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;
public class Sprite extends ImageView{
    public Sprite(int x,int y,String type){
        //super(w,h,color);
        setX(x);
        setY(y);
    }
}

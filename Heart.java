/**
 * Draws a Heart Sign
 * @author Alex Kleinhanzl
 * @version 12/18/2018
 * */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

public class Heart extends ManyCards {
  /**
   * Constructor
   * */
  public Heart (double x1, double y1, int suit, int rank) {
    super(x1, y1, suit, rank);
    this.xArray = new double[6];
    this.yArray = new double[6];
  }
  /**
   * this implements suit and rank
   * */
  public Heart(int suit,int rank){
    this(0,0,0,rank);
  }
  /**
   * this draws the object
   * */
  public void drawFaceUp(GraphicsContext gc) {
    this.xArray[0] = x1;
    this.yArray[0] = y1 + h1/3;
    this.xArray[1] = x1 + w1/2;
    this.yArray[1] = y1 + h1;
    this.xArray[2] = x1 + w1;
    this.yArray[2] = y1 + h1/3;
    this.xArray[3] = x1 + w1*.75;
    this.yArray[3] = y1;
    this.xArray[4] = x1 + w1/2;
    this.yArray[4] = y1 + h1/3;
    this.xArray[5] = x1 + w1*.25;
    this.yArray[5] = y1;
    
    this.drawBox(x1,y1,gc);
    this.drawRank(rank,x1,y1,gc);
    gc.setFill(Color.RED);
    gc.fillPolygon(xArray,yArray,6);
  }
  
}
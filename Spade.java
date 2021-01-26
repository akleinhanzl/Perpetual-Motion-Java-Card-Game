/**
 * Draws a Spade Sign
 * @author Alex Kleinhanzl
 * @version 12/18/2018
 * */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

public class Spade extends ManyCards {
  /**
   * Constructor
   * */
  public Spade (double x1, double y1, int suit, int rank) {
    super(x1, y1, suit, rank);
    this.xArray = new double[9];
    this.yArray = new double[9];
  }
  /**
   * this implements suit and rank
   * */
  public Spade (int suit,int rank){
    this(0,0,3,rank);
  }
  /**
   * this draws the object
   * */
  public void drawFaceUp(GraphicsContext gc) {
    this.xArray[0] = x1 + w1/2;
    this.yArray[0] = y1 + h1*.66;
    this.xArray[1] = x1 + w1*.43;
    this.yArray[1] = y1 + h1;
    this.xArray[2] = x1 + w1*.66;
    this.yArray[2] = y1 + h1;
    this.xArray[3] = x1 + w1/2;
    this.yArray[3] = y1 + h1*.66;
    this.xArray[4] = x1 + w1*.833;
    this.yArray[4] = y1 + h1*.833;
    this.xArray[5] = x1 + w1;
    this.yArray[5] = y1 + h1*.86;
    this.xArray[6] = x1 + w1/2;
    this.yArray[6] = y1;
    this.xArray[7] = x1;
    this.yArray[7] = y1 + h1*.86;
    this.xArray[8] = x1 + w1/6;
    this.yArray[8] = y1 + h1*.833;
    
    this.drawBox(x1,y1,gc);
    this.drawRank(rank,x1,y1,gc);
    gc.setFill(Color.BLACK);
    gc.fillPolygon(xArray,yArray,9);
  }
  
}
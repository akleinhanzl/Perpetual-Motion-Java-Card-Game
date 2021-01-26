/**
 * Draws a Club Sign
 * @author Alex Kleinhanzl
 * @version 12/18/2018
 * */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;


public class Club extends ManyCards {
  /**
   * Constructor
   * */
  public Club (double x1, double y1, int suit, int rank) {
    super(x1, y1, suit, rank);
    this.xArray = new double[15];
    this.yArray = new double[15]; 
  }
  /**
   * this implements suit and rank
   * */
  public Club (int suit,int rank){
    this(0,0,2,rank);
  } 
  /**
   * this draws the object
   * */
  public void drawFaceUp(GraphicsContext gc) {
    this.xArray[0] = x1 + w1/2;
    this.yArray[0] = y1 + h1/2;
    this.xArray[1] = x1 + w1/3;
    this.yArray[1] = y1 + h1;
    this.xArray[2] = x1 + w1*.66;
    this.yArray[2] = y1 + h1;
    this.xArray[3] = x1 + w1/2;
    this.yArray[3] = y1 + h1/2;
    this.xArray[4] = x1 + w1*.9;
    this.yArray[4] = y1 + h1*.9;
    this.xArray[5] = x1 + w1;
    this.yArray[5] = y1 + h1/2;
    this.xArray[6] = x1 + w1*.9;
    this.yArray[6] = y1 + h1/3;
    this.xArray[7] = x1 + w1/2;
    this.yArray[7] = y1 + h1/2;
    this.xArray[8] = x1 + w1*.9;
    this.yArray[8] = y1 + h1/6;
    this.xArray[9] = x1 + w1/2;
    this.yArray[9] = y1;
    this.xArray[10] = x1 + w1/3;
    this.yArray[10] = y1 + h1/6;
    this.xArray[11] = x1 + w1/2;
    this.yArray[11] = y1 + h1/2;
    this.xArray[12] = x1 + w1/6;
    this.yArray[12] = y1 + h1/3;
    this.xArray[13] = x1;
    this.yArray[13] = y1 + h1/2;
    this.xArray[14] = x1 + w1/6;
    this.yArray[14] = y1 + h1*.9;
    
    drawBox(x1,y1,gc);
    drawRank(rank,x1,y1,gc);
    gc.setFill(Color.BLACK);
    gc.fillPolygon(xArray,yArray,15);  
  }
  
}
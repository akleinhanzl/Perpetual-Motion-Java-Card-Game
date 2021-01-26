/**
 * General Card Class
 * @author Alex Kleinhanzl
 * @version 12/18/2018
 * */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public abstract class ManyCards {
  
  public static final double CARD_HEIGHT = 150;
  public static final double CARD_WIDTH = 100;
  protected double x1;
  protected double y1;
  protected double w1;
  protected double h1;
  protected int suit;
  protected int rank;
  protected double[] xArray;
  protected double[] yArray;
  protected boolean faceUp;
  
  public ManyCards(double x1, double y1, int suit, int rank){
    this.x1 = x1;
    this.y1 = y1;
    this.w1 = 50;
    this.h1 = 50;
    this.suit = suit;
    this.rank = rank;
    this.faceUp = false;
  }
  /**
   * this is where everything goes to without any other inofrmation 
   * */
  public ManyCards(int suit, int rank){
    this(0,0,suit,rank);
  }
  /**
   * Method gets the suit
   * */
  public int getSuit(){
    return this.suit;
  }
  /**
   * Method gets the rank
   * */
  public int getRank(){
    return this.rank;
  }
  /**
   * Method
   * gets either face up or face down 
   * */
  public boolean getFaceUp(){
    return this.faceUp;
  }
  /**
   * Method sets the faceUp boolean 
   * */
  public void setFaceUp(boolean faceUp){
    this.faceUp = faceUp;
  }
  /**
   * Method gets the double X value
   * 
   * */
  public double getX(){
    return this.x1;
  }
  /**
   * Method sets the new double x value
   * */
  public void setX(double x){
    this.x1 = x;
  }
  /**
   * Method gets the double y value
   * */
  public double getY(){
    return this.y1;
  } 
  /**
   * Method sets the new double x value
   * */
  public void setY(double y){
    this.y1 = y;
  }
  /**
   * Method Draws the card
   * */
  public void draw(GraphicsContext gc){
    if(this.faceUp == true){
      drawFaceUp(gc);
    }
    else{
      drawFaceDown(gc);
    }
  }
  /**
   * helper method defines faceup cards
   * */
  public abstract void drawFaceUp(GraphicsContext gc);
  /**
   * helper method draws a facedown card
   * */  
  public void drawFaceDown(GraphicsContext gc){
    gc.setFill(Color.YELLOW);
    gc.fillRect(x1,y1,CARD_WIDTH,CARD_HEIGHT);
    gc.setFill(Color.BLACK);
    double ax = 5;
    double ay = 5;
    double ax2 = 5;
    double ay2 = 5;
    gc.fillRect(x1+ax2,y1+ay2,CARD_WIDTH-ax,CARD_HEIGHT-ay);
    gc.setStroke(Color.BLACK);
    for(double i=0; i<10; i++){
      gc.strokeRect(x1+(ax2*i),y1+(ay2*i),CARD_WIDTH-(ax*i),CARD_HEIGHT-(ay*i));
    }
  }
  
  public void drawBox(double x, double y,GraphicsContext gc){
    gc.setFill(Color.WHITE);
    gc.fillRect(x,y,100,150);
  }
  /**
   * this helps with drawing the rank on the card
   * */
  public void drawRank(int rank, double x, double y,GraphicsContext gc){
    gc.setFill(Color.BLACK);
    gc.setFont(new Font(30));
    if(rank != 0 && rank != 12 && rank != 11 && rank != 10){
      gc.fillText(Integer.toString(rank),x+80,y+100);
    }
    if(rank == 0){
      gc.fillText("A",x+80,y+100);
    }
    if(rank == 10){
      gc.fillText("J",x+80,y+100);
    }
    if(rank == 11){
      gc.fillText("Q",x+80,y+100);
    }
    if(rank == 12){
      gc.fillText("K",x+80,y+100);
    }
  }
}
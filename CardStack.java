/**
 * Class that creates the Stack and produces four columns as a result
 * @author Alex Kleinhanzl
 * @version 12/18/2018
 * */
import java.util.Stack;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;


public class CardStack {
  public static final int NUM_CARDS = 52;
  public Stack<ManyCards> column;
  public Stack<ManyCards> stockPile;
  
  /**
   * constructor
   * initializes the instance variables
   * */
  public CardStack(){
    this.column = new Stack<ManyCards>();
    this.stockPile = new Stack<ManyCards>();
  }
  /**
   * makes ManyCards a stack and into a "deck"
   * */
  public Stack<ManyCards> newStack(ManyCards[] deck){
    for(int i=0; i<NUM_CARDS; i++){
      this.stockPile.push(deck[i]);
    }
    return this.stockPile;
  }
  
}